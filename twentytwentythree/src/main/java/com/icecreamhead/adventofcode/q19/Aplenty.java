package com.icecreamhead.adventofcode.q19;

import static com.icecreamhead.adventofcode.q19.Aplenty.Operator.GT;
import static com.icecreamhead.adventofcode.q19.Aplenty.Operator.LT;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Aplenty {

  long part1(List<String> workflowInput, List<String> partInput) {
    Map<String, Workflow> workflows = parseWorkflows(workflowInput);
    List<Part> parts = parseParts(partInput);

    return parts.stream()
        .mapToInt(part -> {

          Workflow workflow = workflows.get("in");

          while (workflow != null) {
            for (Rule rule : workflow.rules()) {
              String res = rule.apply(part);

              switch (res) {
                case "A":
                  return part.total();
                case "R":
                  return 0;
                case "NEXT":
                  continue;
                default: {
                  workflow = workflows.get(res);
                }
              }
              break;
            }

          }
          throw new IllegalStateException();
        })
        .sum();
  }

  long part2(List<String> workflowInput) {
    Map<String, Workflow> workflows = parseWorkflows(workflowInput);

    return traverseWorkflows(workflows.get("in"), 0, workflows, new PartRange());
  }

  private static long traverseWorkflows(Workflow workflow, int ruleIx, Map<String, Workflow> workflows, PartRange partRange) {
    Rule rule = workflow.rules().get(ruleIx);

    return rule.apply(partRange)
        .mapToLong(ruleResult -> switch (ruleResult.result()) {
          case "A" -> ruleResult.partRange().total();
          case "R" -> 0;
          case "NEXT" -> traverseWorkflows(workflow, ruleIx + 1, workflows, ruleResult.partRange());
          default -> traverseWorkflows(workflows.get(ruleResult.result()), 0, workflows, ruleResult.partRange());
        })
        .sum();
  }

  private static final Pattern PART = Pattern.compile("\\{x=(\\d+),m=(\\d+),a=(\\d+),s=(\\d+)}");

  private static List<Part> parseParts(List<String> partInput) {
    return partInput.stream()
        .map(in -> {
          Matcher matcher = PART.matcher(in);
          if (!matcher.matches()) {
            throw new IllegalStateException(in);
          }
          return new Part(
              Integer.parseInt(matcher.group(1)),
              Integer.parseInt(matcher.group(2)),
              Integer.parseInt(matcher.group(3)),
              Integer.parseInt(matcher.group(4))
          );
        })
        .toList();
  }

  private static Map<String, Workflow> parseWorkflows(List<String> workflows) {
    return workflows.stream()
        .map(workflow -> {
          int open = workflow.indexOf('{');
          String name = workflow.substring(0, open);
          List<Rule> rules = Arrays.stream(workflow.substring(open + 1).replace("}", "").split(","))
              .map(rule -> {
                if (rule.contains(":")) {
                  String[] parts = rule.split(":");
                  char ruleCat = rule.charAt(0);
                  Operator ruleOp = Operator.parse(rule.charAt(1));
                  int ruleVal = Integer.parseInt(parts[0].substring(2));
                  String ruleOut = parts[1];
                  return new Rule(ruleCat, ruleOp, ruleVal, ruleOut);
                }
                return new Rule('!', null, -1, rule);
              })
              .toList();
          return new Workflow(name, rules);
        })
        .collect(Collectors.toMap(Workflow::name, Function.identity()));
  }

  record Workflow(String name, List<Rule> rules) {

  }

  record Rule(char category, Operator operator, int val, String output) {

    String apply(Part part) {
      if (operator == null) {
        return output;
      }
      int operand = switch (category) {
        case 'x' -> part.x;
        case 'm' -> part.m;
        case 'a' -> part.a;
        case 's' -> part.s;
        default -> throw new IllegalStateException(String.valueOf(category));
      };
      return operator.apply(operand, val) ? output : "NEXT";
    }

    Stream<RuleResult> apply(PartRange range) {
      if (operator == null) {
        return Stream.of(new RuleResult(range, output));
      }

      return Stream.of(
          new RuleResult(
              new PartRange(
                  category == 'x' && operator == GT ? Math.max(val + 1, range.xMin) : range.xMin,
                  category == 'x' && operator == LT ? Math.min(val - 1, range.xMax) : range.xMax,
                  category == 'm' && operator == GT ? Math.max(val + 1, range.mMin) : range.mMin,
                  category == 'm' && operator == LT ? Math.min(val - 1, range.mMax) : range.mMax,
                  category == 'a' && operator == GT ? Math.max(val + 1, range.aMin) : range.aMin,
                  category == 'a' && operator == LT ? Math.min(val - 1, range.aMax) : range.aMax,
                  category == 's' && operator == GT ? Math.max(val + 1, range.sMin) : range.sMin,
                  category == 's' && operator == LT ? Math.min(val - 1, range.sMax) : range.sMax
              ), output
          ),
          new RuleResult(
              new PartRange(
                  category == 'x' && operator == LT ? Math.max(val, range.xMin) : range.xMin,
                  category == 'x' && operator == GT ? Math.min(val, range.xMax) : range.xMax,
                  category == 'm' && operator == LT ? Math.max(val, range.mMin) : range.mMin,
                  category == 'm' && operator == GT ? Math.min(val, range.mMax) : range.mMax,
                  category == 'a' && operator == LT ? Math.max(val, range.aMin) : range.aMin,
                  category == 'a' && operator == GT ? Math.min(val, range.aMax) : range.aMax,
                  category == 's' && operator == LT ? Math.max(val, range.sMin) : range.sMin,
                  category == 's' && operator == GT ? Math.min(val, range.sMax) : range.sMax
              ), "NEXT"
          )
      );
    }
  }

  record RuleResult(PartRange partRange, String result) {

  }

  record Part(int x, int m, int a, int s) {

    int total() {
      return x + m + a + s;
    }
  }

  record PartRange(int xMin, int xMax, int mMin, int mMax, int aMin, int aMax, int sMin, int sMax) {

    PartRange() {
      this(1, 4000, 1, 4000, 1, 4000, 1, 4000);
    }

    long total() {
      return (long) (xMax + 1 - xMin) * (aMax + 1 - aMin) * (mMax + 1 - mMin) * (sMax + 1 - sMin);
    }
  }

  enum Operator {
    GT, LT;

    boolean apply(int x, int y) {
      return this == GT ? x > y : x < y;
    }

    static Operator parse(char s) {
      return switch (s) {
        case '>' -> GT;
        case '<' -> LT;
        default -> throw new IllegalStateException(String.valueOf(s));
      };
    }
  }
}

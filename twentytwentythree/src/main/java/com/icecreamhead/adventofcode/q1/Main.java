package com.icecreamhead.adventofcode.q1;

import com.icecreamhead.adventofcode.util.InputLoader;

import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        List<String> calibrationLines = InputLoader.loadLines("q1/puzzle.txt");

        long total = calibrationLines.stream()
//                .peek(line -> System.out.print(line + " => "))
                .mapToInt(line -> firstDigit(line) * 10 + lastDigit(line))
//                .peek(System.out::println)
                .sum();

        System.out.println("\n" + total);
    }

    private static int firstDigit(String line) {
        char c;
        return switch (c = line.charAt(0)) {
            case '1', '2', '3', '4', '5', '6', '7', '8', '9' -> c - 48;
            case 'o', 't', 'f', 's', 'e', 'n' -> switch (line.substring(0, Math.min(5, line.length() - 1))) {
                case "three" -> 3;
                case "seven" -> 7;
                case "eight" -> 8;
                default -> switch (line.substring(0, Math.min(4, line.length() - 1))) {
                    case "four" -> 4;
                    case "five" -> 5;
                    case "nine" -> 9;
                    default -> switch (line.substring(0, Math.min(3, line.length() - 1))) {
                        case "one" -> 1;
                        case "two" -> 2;
                        case "six" -> 6;
                        default -> firstDigit(line.substring(1));
                    };
                };
            };
            default -> firstDigit(line.substring(1));
        };
    }

    private static int lastDigit(String line) {
        char c;
        return switch (c = line.charAt(line.length() - 1)) {
            case '1', '2', '3', '4', '5', '6', '7', '8', '9' -> c - 48;
            case 'e', 'o', 'x', 'r', 'n', 't' -> switch (line.substring(Math.max(0, line.length() - 5))) {
                case "three" -> 3;
                case "seven" -> 7;
                case "eight" -> 8;
                default -> switch (line.substring(Math.max(0, line.length() - 4))) {
                    case "four" -> 4;
                    case "five" -> 5;
                    case "nine" -> 9;
                    default -> switch (line.substring(Math.max(0, line.length() - 3))) {
                        case "one" -> 1;
                        case "two" -> 2;
                        case "six" -> 6;
                        default -> lastDigit(line.substring(0, line.length() - 1));
                    };
                };
            };
            default -> lastDigit(line.substring(0, line.length() - 1));
        };
    }
}
package com.icecreamhead.adventofcode.two;

import junit.framework.TestCase;

import static org.assertj.core.api.Assertions.assertThat;

public class ChecksumTest extends TestCase {

  private final Checksum checksum = new Checksum();

  public static final String PART_1_TEST_INPUT = "5 1 9  5\n7 5\t3\n2 4 6 8";

  public void testQ2P1() throws Exception {
    assertThat(checksum.solvePart1(PART_1_TEST_INPUT)).isEqualTo(18);
  }

  private static final String puzzleInput = "6046\t6349\t208\t276\t4643\t1085\t1539\t4986\t7006\t5374\t252\t4751\t226\t6757\t7495\t2923\n" +
      "1432\t1538\t1761\t1658\t104\t826\t806\t109\t939\t886\t1497\t280\t1412\t127\t1651\t156\n" +
      "244\t1048\t133\t232\t226\t1072\t883\t1045\t1130\t252\t1038\t1022\t471\t70\t1222\t957\n" +
      "87\t172\t93\t73\t67\t192\t249\t239\t155\t23\t189\t106\t55\t174\t181\t116\n" +
      "5871\t204\t6466\t6437\t5716\t232\t1513\t7079\t6140\t268\t350\t6264\t6420\t3904\t272\t5565\n" +
      "1093\t838\t90\t1447\t1224\t744\t1551\t59\t328\t1575\t1544\t1360\t71\t1583\t75\t370\n" +
      "213\t166\t7601\t6261\t247\t210\t4809\t6201\t6690\t6816\t7776\t2522\t5618\t580\t2236\t3598\n" +
      "92\t168\t96\t132\t196\t157\t116\t94\t253\t128\t60\t167\t192\t156\t76\t148\n" +
      "187\t111\t141\t143\t45\t132\t140\t402\t134\t227\t342\t276\t449\t148\t170\t348\n" +
      "1894\t1298\t1531\t1354\t1801\t974\t85\t93\t1712\t130\t1705\t110\t314\t107\t449\t350\n" +
      "1662\t1529\t784\t1704\t1187\t83\t422\t146\t147\t1869\t1941\t110\t525\t1293\t158\t1752\n" +
      "162\t1135\t3278\t1149\t3546\t3686\t182\t149\t119\t1755\t3656\t2126\t244\t3347\t157\t865\n" +
      "2049\t6396\t4111\t6702\t251\t669\t1491\t245\t210\t4314\t6265\t694\t5131\t228\t6195\t6090\n" +
      "458\t448\t324\t235\t69\t79\t94\t78\t515\t68\t380\t64\t440\t508\t503\t452\n" +
      "198\t216\t5700\t4212\t2370\t143\t5140\t190\t4934\t539\t5054\t3707\t6121\t5211\t549\t2790\n" +
      "3021\t3407\t218\t1043\t449\t214\t1594\t3244\t3097\t286\t114\t223\t1214\t3102\t257\t3345";

  public void testSolutionQ2P1() throws Exception {
    System.out.println("Q2P1: " + checksum.solvePart1(puzzleInput));
  }

  private static final String PART_2_TEST_INPUT = "5 9 2 8\n9 4 7 3\n3 8 6 5";

  public void testQ2P2() throws Exception {
    assertThat(checksum.solvePart2(PART_2_TEST_INPUT)).isEqualTo(9);
  }

  public void testSolutionQ2P2() throws Exception {
    System.out.println("Q2P2: " + checksum.solvePart2(puzzleInput));
  }
}
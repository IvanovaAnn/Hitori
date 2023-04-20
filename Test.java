import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test extends TestCase {

    public void test1() {
        ArrayList<ArrayList<Integer>> originalField = new ArrayList<>(3);
        ArrayList<Integer> str1 = new ArrayList<>(3);
        ArrayList<Integer> str2 = new ArrayList<>(3);
        ArrayList<Integer> str3 = new ArrayList<>(3);
        str1.add(3);
        str1.add(2);
        str1.add(3);
        str2.add(1);
        str2.add(5);
        str2.add(5);
        str3.add(1);
        str3.add(1);
        str3.add(5);
        originalField.add(str1);
        originalField.add(str2);
        originalField.add(str3);
        ArrayList<ArrayList<String>> newList = new ArrayList<>(3);
        ArrayList<String> str12 = new ArrayList<>(3);
        ArrayList<String> str22 = new ArrayList<>(3);
        ArrayList<String> str32 = new ArrayList<>(3);
        str12.add("-");
        str12.add("?");
        str12.add("?");
        str22.add("?");
        str22.add("?");
        str22.add("?");
        str32.add("?");
        str32.add("?");
        str32.add("?");
        newList.add(str12);
        newList.add(str22);
        newList.add(str32);
        int countString = 3, sl = 3;
        boolean run = true;
        int i = 0, j = 0;
        boolean diagonal = true;
        run = Checker.neighbors(i, j, run, countString, sl, newList, originalField, diagonal);
        assertTrue(Integer.parseInt(newList.get(0).get(1)) == 2 &&
                Integer.parseInt(newList.get(1).get(0)) == 1 && run);
    }

    public void test2() {
        ArrayList<ArrayList<Integer>> originalField = new ArrayList<>(3);
        ArrayList<Integer> str1 = new ArrayList<>(3);
        ArrayList<Integer> str2 = new ArrayList<>(3);
        ArrayList<Integer> str3 = new ArrayList<>(3);
        str1.add(3);
        str1.add(2);
        str1.add(3);
        str2.add(1);
        str2.add(5);
        str2.add(5);
        str3.add(3);
        str3.add(1);
        str3.add(5);
        originalField.add(str1);
        originalField.add(str2);
        originalField.add(str3);
        ArrayList<ArrayList<String>> newList = new ArrayList<>(3);
        ArrayList<String> str12 = new ArrayList<>(3);
        ArrayList<String> str22 = new ArrayList<>(3);
        ArrayList<String> str32 = new ArrayList<>(3);
        str12.add("3");
        str12.add("?");
        str12.add("?");
        str22.add("?");
        str22.add("?");
        str22.add("?");
        str32.add("?");
        str32.add("?");
        str32.add("?");
        newList.add(str12);
        newList.add(str22);
        newList.add(str32);
        int countString = 3, sl = 3;
        boolean run = true;
        boolean diagonal = true;
        Engine eng = new Engine(run, sl, countString, newList, originalField, diagonal);
        eng.paintingRepeatsInBlack();
        System.out.println(newList.get(0).get(2));
        System.out.println(newList.get(2).get(0));
        assertTrue(newList.get(0).get(2).equals("-") &&
                newList.get(2).get(0).equals("-"));
    }

    public void test3() {
        ArrayList<ArrayList<Integer>> originalField = new ArrayList<>(3);
        ArrayList<Integer> str1 = new ArrayList<>(3);
        ArrayList<Integer> str2 = new ArrayList<>(3);
        ArrayList<Integer> str3 = new ArrayList<>(3);
        str1.add(3);
        str1.add(2);
        str1.add(3);
        str2.add(1);
        str2.add(5);
        str2.add(5);
        str3.add(3);
        str3.add(1);
        str3.add(5);
        originalField.add(str1);
        originalField.add(str2);
        originalField.add(str3);
        ArrayList<ArrayList<String>> newList = new ArrayList<>(3);
        ArrayList<String> str12 = new ArrayList<>(3);
        ArrayList<String> str22 = new ArrayList<>(3);
        ArrayList<String> str32 = new ArrayList<>(3);
        str12.add("?");
        str12.add("?");
        str12.add("?");
        str22.add("?");
        str22.add("?");
        str22.add("?");
        str32.add("?");
        str32.add("?");
        str32.add("?");
        newList.add(str12);
        newList.add(str22);
        newList.add(str32);
        int countString = 3, sl = 3;
        boolean run = true;
        boolean diagonal = true;
        Engine eng = new Engine(run, sl, countString, newList, originalField, diagonal);
        run = eng.paintingInRedCellsAmongTheSameCells();
        assertTrue(Integer.parseInt(newList.get(0).get(1)) == 2 && run);
    }

    public void test4() {
        ArrayList<ArrayList<Integer>> originalField = new ArrayList<>(3);
        ArrayList<Integer> str1 = new ArrayList<>(3);
        ArrayList<Integer> str2 = new ArrayList<>(3);
        ArrayList<Integer> str3 = new ArrayList<>(3);
        str1.add(3);
        str1.add(2);
        str1.add(3);
        str2.add(1);
        str2.add(5);
        str2.add(5);
        str3.add(3);
        str3.add(1);
        str3.add(5);
        originalField.add(str1);
        originalField.add(str2);
        originalField.add(str3);
        ArrayList<ArrayList<String>> newList = new ArrayList<>(3);
        ArrayList<String> str12 = new ArrayList<>(3);
        ArrayList<String> str22 = new ArrayList<>(3);
        ArrayList<String> str32 = new ArrayList<>(3);
        str12.add("-");
        str12.add("?");
        str12.add("?");
        str22.add("1");
        str22.add("-");
        str22.add("?");
        str32.add("?");
        str32.add("?");
        str32.add("?");
        newList.add(str12);
        newList.add(str22);
        newList.add(str32);
        int countString = 3, sl = 3;
        boolean run = true;
        boolean diagonal = true;
        Engine eng = new Engine(run, sl, countString, newList, originalField, diagonal);
        run = eng.checkForTightnessOfTheRedCell();
        assertTrue(Integer.parseInt(newList.get(2).get(0)) == 3 && run);
    }

    public void testNeighbors() {
        ArrayList<ArrayList<String>> newList = new ArrayList<>();
        newList.add(new ArrayList<>());
        newList.add(new ArrayList<>());
        newList.get(0).add("1");
        newList.get(0).add("2");
        newList.get(1).add("3");
        newList.get(1).add("4");
        ArrayList<ArrayList<Integer>> originalField = new ArrayList<>();
        originalField.add(new ArrayList<>());
        originalField.add(new ArrayList<>());
        originalField.get(0).add(1);
        originalField.get(0).add(2);
        originalField.get(1).add(3);
        originalField.get(1).add(4);
        assertTrue(Checker.neighbors(0, 0, true, 2, 2, newList, originalField, false));
        newList.get(0).set(1, "-");
        assertFalse(Checker.neighbors(0, 0, true, 2, 2, newList, originalField, false));
    }

    public void testPair() {
        Checker.Pair pair = new Checker.Pair(1, 2);
        assertEquals(1, pair.getA());
        assertEquals(2, pair.getB());
        pair.setA(3);
        pair.setB(4);
        assertEquals(3, pair.getA());
        assertEquals(4, pair.getB());
    }

    public void testManaging() {
        int countString1 = 3;
        int sl1 = 3;
        ArrayList<ArrayList<Integer>> originalField1 = new ArrayList<ArrayList<Integer>>();
        originalField1.add(new ArrayList<Integer>(List.of(1, 2, 3)));
        originalField1.add(new ArrayList<Integer>(List.of(4, 5, 6)));
        originalField1.add(new ArrayList<Integer>(List.of(7, 2, 8)));
        ArrayList<ArrayList<String>> startList1 = new ArrayList<ArrayList<String>>();
        startList1.add(new ArrayList<String>(List.of("?", "?", "?")));
        startList1.add(new ArrayList<String>(List.of("?", "?", "?")));
        startList1.add(new ArrayList<String>(List.of("?", "?", "?")));
        boolean diagonal1 = false;
        ArrayList<ArrayList<ArrayList<String>>> expected1 = new ArrayList<ArrayList<ArrayList<String>>>();
        ArrayList<ArrayList<String>> solution1 = new ArrayList<ArrayList<String>>();
        solution1.add(new ArrayList<String>(List.of("1", "-", "3")));
        solution1.add(new ArrayList<String>(List.of("4", "5", "6")));
        solution1.add(new ArrayList<String>(List.of("7", "2", "8")));
        ArrayList<ArrayList<String>> solution2 = new ArrayList<ArrayList<String>>();
        solution2.add(new ArrayList<String>(List.of("1", "2", "3")));
        solution2.add(new ArrayList<String>(List.of("4", "5", "6")));
        solution2.add(new ArrayList<String>(List.of("7", "-", "8")));
        expected1.add(solution1);
        expected1.add(solution2);
        ArrayList<ArrayList<ArrayList<String>>> actual1 = ManagingInternediateMethods.managing(countString1, sl1, originalField1, startList1, diagonal1);
        assertEquals(expected1, actual1);
    }

    public void testPaintingRepeatsInBlackReturnsTrue() {
        boolean run = true;
        int sl = 3;
        int countString = 3;
        ArrayList<ArrayList<String>> newList = new ArrayList<>();
        newList.add(new ArrayList<>(List.of("1", "2", "?")));
        newList.add(new ArrayList<>(List.of("?", "-", "6")));
        newList.add(new ArrayList<>(List.of("2", "-", "?")));
        ArrayList<ArrayList<Integer>> originalField = new ArrayList<>();
        originalField.add(new ArrayList<>(List.of(1, 2, 3)));
        originalField.add(new ArrayList<>(List.of(4, 5, 6)));
        originalField.add(new ArrayList<>(List.of(2, 6, 1)));
        boolean diagonal = false;
        Engine engine = new Engine(run, sl, countString, newList, originalField, diagonal);
        boolean result = engine.paintingRepeatsInBlack();
        assertTrue(result);
    }

    public void testPaintingInRedCellsAmongTheSameCells_noRedCells() {
        ArrayList<ArrayList<String>> newList = new ArrayList<>();
        newList.add(new ArrayList<String>(Arrays.asList("-", "-", "1")));
        newList.add(new ArrayList<>(Arrays.asList("-", "2", "-")));
        newList.add(new ArrayList<>(Arrays.asList("3", "-", "-")));

        ArrayList<ArrayList<Integer>> originalField = new ArrayList<>();
        originalField.add(new ArrayList<>(Arrays.asList(0, 0, 1)));
        originalField.add(new ArrayList<>(Arrays.asList(0, 2, 0)));
        originalField.add(new ArrayList<>(Arrays.asList(3, 0, 0)));

        Engine engine = new Engine(true, 3, 3, newList, originalField, true);
        assertTrue(engine.paintingInRedCellsAmongTheSameCells());
    }

    public void testPaintingInRedCellsAmongTheSameCells_redCellsHorizontal() {
        ArrayList<ArrayList<String>> newList = new ArrayList<>();
        newList.add(new ArrayList<>(Arrays.asList("-", "-", "1")));
        newList.add(new ArrayList<>(Arrays.asList("-", "2", "-")));
        newList.add(new ArrayList<>(Arrays.asList("3", "4", "4")));

        ArrayList<ArrayList<Integer>> originalField = new ArrayList<>();
        originalField.add(new ArrayList<>(Arrays.asList(0, 0, 1)));
        originalField.add(new ArrayList<>(Arrays.asList(0, 2, 0)));
        originalField.add(new ArrayList<>(Arrays.asList(3, 4, 4)));

        Engine engine = new Engine(true, 3, 3, newList, originalField, true);
        assertTrue(engine.paintingInRedCellsAmongTheSameCells());
    }

    public void testPaintingInRedCellsAmongTheSameCells_redCellsVertical() {
        ArrayList<ArrayList<String>> newList = new ArrayList<>();
        newList.add(new ArrayList<>(Arrays.asList("-", "-", "1")));
        newList.add(new ArrayList<>(Arrays.asList("-", "2", "3")));
        newList.add(new ArrayList<>(Arrays.asList("3", "-", "-")));

        ArrayList<ArrayList<Integer>> originalField = new ArrayList<>();
        originalField.add(new ArrayList<>(Arrays.asList(0, 0, 1)));
        originalField.add(new ArrayList<>(Arrays.asList(0, 2, 3)));
        originalField.add(new ArrayList<>(Arrays.asList(3, 0, 0)));

        Engine engine = new Engine(true, 3, 3, newList, originalField, true);
        assertTrue(engine.paintingInRedCellsAmongTheSameCells());
    }

    public void testPaintingInRedCellsAmongTheSameCells_redCellsDiagonal() {
        ArrayList<ArrayList<String>> newList = new ArrayList<>();
        newList.add(new ArrayList<>(Arrays.asList("-", "-", "1")));
        newList.add(new ArrayList<>(Arrays.asList("-", "2", "3")));
        newList.add(new ArrayList<>(Arrays.asList("3", "4", "-")));

        ArrayList<ArrayList<Integer>> originalField = new ArrayList<>();
        originalField.add(new ArrayList<>(Arrays.asList(0, 0, 1)));
        originalField.add(new ArrayList<>(Arrays.asList(0, 2, 3)));
        originalField.add(new ArrayList<>(Arrays.asList(3, 4, 0)));

        Engine engine = new Engine(true, 3, 3, newList, originalField, true);
        assertTrue(engine.paintingInRedCellsAmongTheSameCells());
    }
}

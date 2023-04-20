import java.util.ArrayList;

public class Checker {
    public static boolean neighbors(int i, int j, boolean run, int countString, int sl,
                                    ArrayList<ArrayList<String>> newList,
                                    ArrayList<ArrayList<Integer>> originalField,
                                    boolean diagonal) {
        if (!run) {
            return run;
        }
        if (i > 0) {
            if (newList.get(i -1).get(j).equals("-")) {
                run = false;
            }
            else if (newList.get(i - 1).get(j).equals("?")) {
                newList.get(i - 1).set(j, originalField.get(i - 1).get(j).toString());
            }
        }
        if (i < countString - 1) {
            if (newList.get(i + 1).get(j).equals("-")) {
                run = false;
            }
            else if (newList.get(i + 1).get(j).equals("?")) {
                newList.get(i + 1).set(j, originalField.get(i + 1).get(j).toString());
            }
        }
        if (j > 0) {
            if (newList.get(i).get(j - 1).equals("-")) {
                run = false;
            }
            else if (newList.get(i).get(j - 1).equals("?")) {
                newList.get(i).set(j - 1, originalField.get(i).get(j - 1).toString());
            }
        }
        if (j < sl - 1) {
            if (newList.get(i).get(j + 1).equals("-")) {
                run = false;
            }
            else if (newList.get(i).get(j + 1).equals("?")) {
                newList.get(i).set(j + 1, originalField.get(i).get(j + 1).toString());
            }
        }
        if (diagonal) {
            ArrayList<Pair> neighbors = new ArrayList<Pair>(4);
            neighbors.add(new Pair(i - 1, j - 1));
            neighbors.add(new Pair(i - 1, j + 1));
            neighbors.add(new Pair(i + 1, j - 1));
            neighbors.add(new Pair(i + 1, j + 1));
            ArrayList<Pair> filtred = new ArrayList<Pair>();
            for (int ni = 0; ni < 4; ni++) {
                if (0 <= neighbors.get(ni).getA() && neighbors.get(ni).getA() <= countString - 1 &&
                    0 <= neighbors.get(ni).getB() && neighbors.get(ni).getB() <= sl - 1) {
                    filtred.add(neighbors.get(ni));
                }
            }
            for (Pair pair : filtred) {
                if (newList.get(pair.getA()).get(pair.getB()).equals("-")) {
                    run = false;
                }
                else if (newList.get(pair.getA()).get(pair.getB()).equals("?")) {
                    newList.get(pair.getA()).set(pair.getB(), String.valueOf(
                            originalField.get(pair.getA()).get(pair.getB())));
                }
            }
        }
        return run;
    }

    static class Pair {
        private int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }

        public void setA(int a) {
            this.a = a;
        }

        public void setB(int b) {
            this.b = b;
        }
    }
}

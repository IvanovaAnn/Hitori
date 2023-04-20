import java.util.ArrayList;

public class Engine {
    boolean run;
    int sl, countString;
    ArrayList<ArrayList<String>> newList;
    ArrayList<ArrayList<Integer>> originalField;
    boolean diagonal;

    public Engine(boolean run, int sl, int countString, ArrayList<ArrayList<String>> newList,
                  ArrayList<ArrayList<Integer>> originalField, boolean diagonal) {
        this.run = run;
        this.sl = sl;
        this.countString = countString;
        this.newList = newList;
        this.originalField = originalField;
        this.diagonal = diagonal;
    }

    public boolean paintingRepeatsInBlack() {
        for (int i = 0; i < countString; i++) {
            for (int j = 0; j < sl; j++) {
                if (!run) {
                    return false;
                }
                else if (newList.get(i).get(j).equals("?") || newList.get(i).get(j).equals("-")) {
                    continue;
                }
                for (int q = 0; q < countString; q++) {
                    if (i != q && originalField.get(q).get(j).toString().equals(newList.get(i).get(j)) &&
                        run) {
                        if (newList.get(q).get(j).equals("?")) {
                            newList.get(q).set(j, "-");
                            run = Checker.neighbors(q, j, run, countString, sl, newList,
                                    originalField, diagonal);
                        }
                        else if (!newList.get(q).get(j).equals("-")) {
                            run = false;
                            return false;
                        }
                    }
                }
                for (int q = 0; q < sl; q++) {
                    if (j != q && originalField.get(i).get(q).toString().equals(newList.get(i).get(j)) &&
                            run) {
                        if (newList.get(i).get(q).equals("?")) {
                            newList.get(i).set(q, "-");
                            run = Checker.neighbors(i, q, run, countString, sl, newList,
                                    originalField, diagonal);
                        }
                        else if (!newList.get(i).get(q).equals("-")) {
                            run = false;
                            return false;
                        }
                    }
                }
                if (diagonal) {
                    for (int q = 0; q < countString; q++) {
                        for (int p = 0; p < sl; p++) {
                            if (i != q && j != p && Math.abs(i - q) == Math.abs(j - p) &&
                                    originalField.get(q).get(p).toString().equals(newList.get(i).get(j)) &&
                                    run) {
                                if (newList.get(q).get(p).equals("?")) {
                                    newList.get(q).set(p, "-");
                                    run = Checker.neighbors(q, p, run, countString, sl,
                                            newList, originalField, diagonal);
                                }
                                else if (!newList.get(q).get(p).equals("-")) {
                                    run = false;
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return run;
    }

    public boolean paintingInRedCellsAmongTheSameCells() {
        for (int i = 0; i < countString; i++) {
            for (int j = 0; j < sl; j++) {
                if (!run) {
                    return false;
                }
                if (0 < i && i < countString - 1 &&
                        originalField.get(i - 1).get(j).equals(originalField.get(i + 1).get(j))) {
                    if (newList.get(i).get(j).equals("-")) {
                        run = false;
                        return false;
                    }
                    else {
                        newList.get(i).set(j, String.valueOf(originalField.get(i).get(j)));
                    }
                }
                if (0 < j && j < sl - 1 &&
                        originalField.get(i).get(j - 1).equals(originalField.get(i).get(j + 1))) {
                    if (newList.get(i).get(j).equals("-")) {
                        run = false;
                        return false;
                    }
                    else {
                        newList.get(i).set(j, String.valueOf(originalField.get(i).get(j)));
                    }
                }
                if (diagonal && 0 < i && i < countString - 1 && 0 < j && j < sl - 1) {
                    if (originalField.get(i + 1).get(j + 1).equals(originalField.get(i - 1).get(j - 1))) {
                        if (newList.get(i).get(j).equals("-")) {
                            run = false;
                            return false;
                        }
                        else {
                            newList.get(i).set(j, String.valueOf(originalField.get(i).get(j)));
                        }
                    }
                    if (originalField.get(i - 1).get(j + 1).equals(originalField.get(i + 1).get(j - 1))) {
                        if (newList.get(i).get(j).equals("-")) {
                            run = false;
                            return false;
                        }
                        else {
                            newList.get(i).set(j, String.valueOf(originalField.get(i).get(j)));
                        }
                    }
                }
            }
        }
        return run;
    }

    public boolean checkForTightnessOfTheRedCell() {
        for (int i = 0; i < countString; i++) {
            for (int j = 0; j < sl; j++) {
                if (!run) {
                    return run;
                }
                int countQues = 0;
                Checker.Pair cell = new Checker.Pair(0, 0);
                if (i > 0) {
                    if (newList.get(i - 1).get(j).equals("?")) {
                        ++countQues;
                        cell.setA(i - 1); cell.setB(j);
                    }
                    else if (!newList.get(i - 1).get(j).equals("-")) {
                        continue;
                    }
                }
                if (i < countString - 1) {
                    if (newList.get(i + 1).get(j).equals("?")) {
                        ++countQues;
                        cell.setA(i + 1); cell.setB(j);
                    }
                    else if (!newList.get(i + 1).get(j).equals("-")) {
                        continue;
                    }
                }
                if (j > 0) {
                    if (newList.get(i).get(j - 1).equals("?")) {
                        ++countQues;
                        cell.setA(i); cell.setB(j - 1);
                    }
                    else if (!newList.get(i).get(j - 1).equals("-")) {
                        continue;
                    }
                }
                if (j < sl - 1) {
                    if (newList.get(i).get(j + 1).equals("?")) {
                        ++countQues;
                        cell.setA(i); cell.setB(j + 1);
                    }
                    else if (!newList.get(i).get(j + 1).equals("-")) {
                        continue;
                    }
                }
                if (countQues == 0) {
                    run = false;
                    return false;
                }
                else if (countQues == 1) {
                    newList.get(cell.getA()).set(cell.getB(),
                            String.valueOf(originalField.get(cell.getA()).get(cell.getB())));
                }
            }
        }
        return run;
    }
}

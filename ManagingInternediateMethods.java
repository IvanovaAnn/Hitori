import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ManagingInternediateMethods {
    public static ArrayList<ArrayList<ArrayList<String>>>
            managing(int countString, int sl, ArrayList<ArrayList<Integer>> originalField,
                                ArrayList<ArrayList<String>> startList, boolean diagonal) {
        ArrayList<ArrayList<ArrayList<String>>> solutionsPending =
                new ArrayList<ArrayList<ArrayList<String>>>();
        ArrayList<ArrayList<ArrayList<String>>> allSolutions =
                new ArrayList<ArrayList<ArrayList<String>>>();
        solutionsPending.add(startList);
        while (solutionsPending.size() > 0) {
            boolean run = true;
            ArrayList<ArrayList<String>> newList = new ArrayList<ArrayList<String>>();
            newList.addAll(solutionsPending.get(solutionsPending.size() - 1));
            solutionsPending.remove(solutionsPending.size() - 1);
            for (int i = 0; i < countString; i++) {
                if (!run) {
                    break;
                }
                for (int j = 0; j < sl; j++) {
                    if (!run) {
                        break;
                    }
                    ArrayList<ArrayList<String>> copyNewList = new ArrayList<ArrayList<String>>(countString);
                    while ((!equal(copyNewList, newList)) && run) {
                        copyNewList = new ArrayList<ArrayList<String>>();
                        for (int wi = 0; wi < newList.size(); wi++) {
                            ArrayList<String> copy_string = new ArrayList<String>();
                            for (int wj = 0; wj < newList.get(wi).size(); wj++) {
                                copy_string.add(newList.get(wi).get(wj));
                            }
                            copyNewList.add(copy_string);
                        }
                        Engine eng = new Engine(run, sl, countString, newList, originalField, diagonal);
                        run = eng.paintingInRedCellsAmongTheSameCells();
                        run = eng.paintingRepeatsInBlack();
                        run = eng.checkForTightnessOfTheRedCell();
                    }
                    if (!newList.get(i).get(j).equals("?") || !run) {
                        continue;
                    }
                    for (int nj = 0; nj < sl; nj++) {
                        if (!newList.get(i).get(nj).equals("-") &&
                                originalField.get(i).get(j).equals(originalField.get(i).get(nj)) &&
                                j != nj) {
                            newList.get(i).set(j, "-");
                        }
                    }
                    for (int ni = 0; ni < countString; ni++) {
                        if (!newList.get(ni).get(j).equals("-") &&
                                originalField.get(i).get(j).equals(originalField.get(ni).get(j)) &&
                                i != ni) {
                            newList.get(i).set(j, "-");
                        }
                    }
                    if (diagonal) {
                        for (int im = 0; im < countString; im++) {
                            for (int jm = 0; jm < sl; jm++) {
                                if (Math.abs(i - im) == Math.abs(j - jm) &&
                                        !newList.get(im).get(jm).equals("-") &&
                                        originalField.get(i).get(j).equals(originalField.get(im).get(jm)) &&
                                        j != jm && i != im) {
                                    newList.get(i).set(j, "-");
                                }
                            }
                        }
                    }
                    if (!newList.get(i).get(j).equals("-")) {
                        newList.get(i).set(j, originalField.get(i).get(j).toString());
                    }
                    else {
                        ArrayList<ArrayList<String>> otherOpinion =
                                new ArrayList<ArrayList<String>>();
                        for (int ni = 0; ni < newList.size(); ni++) {
                            otherOpinion.add(new ArrayList<String>());
                            for (int nj = 0; nj < newList.get(ni).size(); nj++) {
                                otherOpinion.get(ni).add(newList.get(ni).get(nj));
                            }
                        }
                        otherOpinion.get(i).set(j, originalField.get(i).get(j).toString());
                        solutionsPending.add(otherOpinion);
                        run = Checker.neighbors(i, j, run, countString, sl, newList, originalField, diagonal);
                    }
                }
            }
            if (run) {
                ArrayList<ArrayList<String>> new_hit = new ArrayList<ArrayList<String>>();
                for (int ni = 0; ni < newList.size(); ni++) {
                    ArrayList<String> hit_str = new ArrayList<String>();
                    for (int nj = 0; nj < newList.get(ni).size(); nj++) {
                        hit_str.add(newList.get(ni).get(nj));
                    }
                    new_hit.add(hit_str);
                }

                System.out.println(new_hit);
                String ANSI_RED = "\u001B[31m";
                String ANSI_BLACK = "\u001B[30m";
                ArrayList<ArrayList<String>> color_array = new ArrayList<ArrayList<String>>();
                for (int ir = 0; ir < new_hit.size(); ir++) {
                    ArrayList<String> color_str = new ArrayList<String>();
                    for (int jr = 0; jr < new_hit.get(ir).size(); jr++) {
                        if (Integer.toString(originalField.get(ir).get(jr)).equals(new_hit.get(ir).get(jr))){
                            color_str.add(ANSI_RED + new_hit.get(ir).get(jr) + ANSI_RED);
                        }
                        else {
                            color_str.add(ANSI_BLACK + originalField.get(ir).get(jr) + ANSI_BLACK);
                        }
                    }
                    color_array.add(color_str);
                }


                allSolutions.add(color_array);
            }
        }
        return allSolutions;
    }

    private static boolean equal(ArrayList<ArrayList<String>>a, ArrayList<ArrayList<String>>b) {
        if (a.size() != b.size())
            return false;
        try {
            for (int i = 0; i < a.size(); i++) {
                if (a.get(i).size() != b.get(i).size())
                    return false;
                for (int j = 0; j < a.get(i).size(); j++) {
                    if (!(a.get(i).get(j).equals(b.get(i).get(j)))) {
                        return false;
                    }
                }
            }
            return true;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }
}

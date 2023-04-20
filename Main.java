import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> originalField = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<String>> newList = new ArrayList<ArrayList<String>>();
        int countStringArg = 3, countColumnsArg = 3, numberOfSolutionArg = -1;
        boolean diagonalArg = false;

        int countString, sl = 0, numberOfSolution = -1;
        String diagonal;
        ArrayList<String> contents;
        Scanner in = new Scanner(System.in);
        String arg[] = in.nextLine().split(" ");
        countStringArg = Integer.parseInt(arg[0]);
        countColumnsArg = Integer.parseInt(arg[1]);
        if (arg.length > 2 && arg[2].equals("d")) diagonalArg = true;
        else if (arg.length > 2) numberOfSolutionArg = Integer.parseInt(arg[2]);
        if (arg.length > 3 && arg[3].equals("d")) diagonalArg = true;
        countString = countStringArg;
        sl = countColumnsArg;
        for (int s = 0; s < countString; s++) {
            String ch[] = in.nextLine().split(" ");
            ArrayList<Integer> oneInAll = new ArrayList<Integer>();
            ArrayList<String> newInAll = new ArrayList<String>();
            for (String q : ch) {
                oneInAll.add(Integer.parseInt(q));
            }
            for (int i = 0; i < ch.length; i++) {
                newInAll.add("?");
            }
            originalField.add(oneInAll);
            newList.add(newInAll);
        }

        ArrayList<ArrayList<ArrayList<String>>> allSolutions =
                ManagingInternediateMethods.managing(countStringArg, sl, originalField, newList, diagonalArg);
        if (allSolutions.size() == 0) {
            System.out.println("There is no solution. What is it?!");
        }
        else {
            int countSolutions = numberOfSolutionArg;
            if (countSolutions == -1) {
                countSolutions = allSolutions.size();
            }
            else if (numberOfSolutionArg > allSolutions.size()) {
                System.out.println("The number of solutions found is " +
                        "less than the one you requested!");
                countSolutions = allSolutions.size();
            }
            System.out.println("\nOutput");
            for (int i = 0; i < countSolutions; i++) {
                for (int j = 0; j < allSolutions.get(i).size(); j++) {
                    for (int h = 0; h < allSolutions.get(i).get(j).size(); h++) {
                            System.out.print(allSolutions.get(i).get(j).get(h) + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
        }
    }
}

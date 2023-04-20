# Hitori
Logical puzzle "Hitori".
Hitori is a Japanese logic puzzle.
The rules of the game in Hitori:
Write down all the values of the cells or cross them out. At the same time:
- The numbers in the recorded cells in each row and in each column should not be repeated;
- Crossed-out cells should not touch the sides;
- All recorded cells must be connected (there should be no isolated individual recorded cells or isolated groups of recorded cells).
There is a puzzle at the entrance to the program
(both with specifying the size of the table in the program arguments, and with a table with numbers),
the program provides a solution to the puzzle.
First, the number of rows and columns is entered.
To enable an additional rule: the neighbors on the diagonal are different, you need to add d.
You can set the number of solutions you want to get after the number of columns.
If you do not specify the required number of solutions, then all possible solutions to this puzzle are displayed.
P.S. In the solution, "-" denotes black cells, and the values are red cells.
Launch example:
3 3
1 3 5
4 6 7
8 3 9

Conclusion:
1 - 5
4 6 7
8 3 9

1 3 5
4 6 7
8 - 9

Another example:
3 4 1 d
1 2 3 4
5 6 2 7
8 9 19 20

Conclusion:
1 - 3 4
5 6 2 7
8 9 19 20

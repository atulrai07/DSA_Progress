package Leetcode;
//count negative numbers in a sorted matrix
public class leetcode1351 {
    public int countNegatives(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int i = 0;
        int j = cols - 1;
        int count = 0;

        while (i < rows && j >= 0) {
            if (grid[i][j] < 0) {
                count += (rows - i);
                j--;
            } else {
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        leetcode1351 solution = new leetcode1351();
        int[][] grid = {
            {4, 3, 2, -1},
            {3, 2, 1, -1},
            {1, 1, -1, -2},
            {-1, -1, -2, -3}
        };
        int result = solution.countNegatives(grid);
        System.out.println("Number of negative numbers: " + result);
    }
}

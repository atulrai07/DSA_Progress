public class Search2DMatrix_74{
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = 0;
        int high = rows * cols - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midValue = matrix[mid / cols][mid % cols];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Search2DMatrix_74 obj = new Search2DMatrix_74();
        int[][] matrix = {{1, 3, 5}, {7, 9, 11}, {13, 15, 17}};
        int target = 11;
        boolean result = obj.searchMatrix(matrix, target);
        System.out.println("Target found: " + result);
    }
}

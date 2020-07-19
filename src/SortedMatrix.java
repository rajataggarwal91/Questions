import java.util.Arrays;

public class SortedMatrix {
    public static void main(String args[]) {
        int[][] matrix = {{1,2,3},{3,3,6},{5, 6, 7}};
        //System.out.println(kthSmallest(matrix, 6));
        System.out.println(Arrays.toString(findElement(matrix, 2)));


    }

    private static int[] findElement(int[][] matrix, int k) {
        int[] cell = {-1, -1};
        int start=0, end = matrix[0].length - 1;
        if (k < matrix[0][0] || k > matrix[matrix.length-1][matrix[0].length-1]) return cell;
        while (start < end) {
            int mid = (start + end)/2;
            if (matrix[matrix.length-1][mid] < k) start = mid + 1;
            if (matrix[matrix.length-1][mid] >= k) end = mid;
        }
        int col = end;
        start = 0;
        end = matrix.length-1;
        while (start < end) {
            int mid = (start + end)/2;
            if (matrix[mid][col] < k) start = mid + 1;
            if (matrix[mid][col] == k) {
                cell[0] = mid;
                cell[1] = col;
                return cell;
            }
            if (matrix[mid][col] > k) end = mid;
        }
        return cell;

    }

    private static int kthSmallest(int[][] matrix, int k) {
        int m=matrix.length;

        int lower = matrix[0][0];
        int upper = matrix[m-1][m-1];

        while(lower<upper){
            int mid = lower + ((upper-lower)>>1);
            int count = count(matrix, mid);
            if(count<k){
                lower=mid+1;
            }else{
                upper=mid;
            }
        }

        return upper;
    }

    private static int count(int[][] matrix, int target){
        int m=matrix.length;
        int i=m-1;
        int j=0;
        int count = 0;

        while(i>=0&&j<m){
            if(matrix[i][j]<=target){
                count += i+1;
                j++;
            }else{
                i--;
            }
        }

        return count;
    }

}

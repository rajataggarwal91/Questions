import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueenProblem {

    private static List<List<Integer>> coordinates = new ArrayList<>();

    public static void main(String args[]) {

        int[][] matrix = new int[4][4];
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(matrix[i], 0);
        }


        for (List<Integer> lc : coordinates) {
            System.out.println(Arrays.toString(lc.toArray()));
        }

     //   findCoordinates(matrix, 0);

    }


    }

//    private static int findCoordinates(int[][] matrix, int r) {
//        int col = -2;
//        if (r < matrix.length - 1)
//            col = findCoordinates(matrix, r + 1);
//        if (col != -1) {
//
//
//    }
//
//
//
//
//    }
//}

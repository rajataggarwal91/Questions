import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {
        //        List<Integer> currentValue = new ArrayList<>(Arrays.asList(102,203,322,44,52));
        //        List<Integer> futureValue = new ArrayList<>(Arrays.asList(120,253,222,47,59));
        //        System.out.println(selectStock(2074, currentValue, futureValue));
        //
        //        List<Integer> nonSortedArray = new ArrayList<>(Arrays.asList(10,25,22,4,5));
        //        System.out.println(almostSortedArray(nonSortedArray));
        //        System.out.println(almostSortedArray(Arrays.asList(2,4,1,3)));
        //        System.out.println("bcd".substring(0, 1));
        //
        //        housie();

//        List<Integer> list = null;
//        if (!list.equals(new Object()))
//            System.out.println("Hi");
//
//        int[] array = {6,1,2,3,4,5};
//        mergeSort(array, 0 , array.length - 1);

        RobloxInterview2.main(null);


    }

    public static int selectStock(int saving, List<Integer> currentValue, List<Integer> futureValue) {
        //Sort both arrays
        int length = currentValue.size();

        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            diff.add(i, futureValue.get(i) - currentValue.get(i));
        }

        //Sort currentValue and futureValue by diff
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (diff.get(j) < diff.get(j + 1)) {
                    int temp = currentValue.get(i);
                    currentValue.set(i, currentValue.get(j));
                    currentValue.set(j, temp);
                    temp = futureValue.get(i);
                    futureValue.set(i, futureValue.get(j));
                    futureValue.set(j, temp);
                    temp = diff.get(i);
                    diff.set(i, diff.get(j));
                    diff.set(j, temp);
                }
            }
        }
        System.out.println(saving);
        System.out.println(currentValue);
        System.out.println(futureValue);
        System.out.println(diff);


        int profit = 0;
        for (int i = 0; i < length; i++) {
            if (currentValue.get(i) <= saving && diff.get(i) > 0) {
                int numberOfShares = saving / currentValue.get(i);
                saving = saving - numberOfShares * currentValue.get(i);
                profit += numberOfShares * diff.get(i);
            }
        }

        return profit > 0 ? profit : 0;
    }


    static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int mid = (start + end)/2;
            mergeSort(array, start, mid);
            mergeSort(array, mid+1, end);
            merge(array, start, mid, end);
        }
    }

    static int[] merge(int[] array, int p, int q, int r) {
        int m = q - p + 1;
        int n = r - q;

        int[] M = new int[m];
        int[] N = new int[n];

        for (int i = p, j = 0 ; i < q -  1 ; i++, j++) {
            M[j] = array[i];
        }

        for (int i = q, j = 0 ; i < r ; i++, j++) {
            N[j] = array[i];
        }


        int i = 0, j = 0;
        while (i < m && j < n) {
            if (M[i] <= N[j]) {
                array[p + i + j] = M[i];
                i++;
            } else {
                array[p + i + j] = N[j];
                j++;
            }
        }
        while (i < m) {
            array[p+i+j] = M[i];
            i++;
        }
        while (j < n) {
            array[p+i+j] = N[j];
            j++;
        }

        return array;
    }

}
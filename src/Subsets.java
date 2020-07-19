import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
result []
result += (result elements + arr[i])

for each element in result add all ith element

 */







public class Subsets {
    public static void main(String args[]) {
        int[] arr = {1,2,3,4};
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int cur = 0;
        while (result.size() < Math.pow(2, arr.length)) {
            System.out.println(result.size());
            System.out.println(Arrays.toString(result.toArray()));
            List<List<Integer>> temp = result.subList(cur, result.size());
            for (List<Integer> t : temp) {
            if (result.size() < Math.pow(2, arr.length)) break;
                cur += 1;
                for (int i = 0; i < arr.length; i++) {
                    List<Integer> point = new ArrayList<>();
                    point.addAll(t);
                    if (!point.contains(arr[i]))
                        point.add(arr[i]);
                    result.add(point);
                }

            }
        }

    System.out.println(Arrays.toString(result.toArray()));
    }

}

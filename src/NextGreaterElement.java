import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import javafx.util.Pair;

public class NextGreaterElement {
    public static void main(String args[]) {
        int[] nums = {124, 125, 121, 119, 122, 126, 123, 110};
        List<Integer> list = new ArrayList<Integer>();
        list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        System.out.println(list.toString());
        nums = list.stream().mapToInt(i->i).toArray();
        System.out.println(Arrays.toString(nums));

        System.out.println(Arrays.toString(ngi(nums)));
    }

    private static int[] ngi(int[] nums) {
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        int[] result = new int[nums.length];

        if (nums.length == 1) return new int[]{-1};
        stack.push(new Pair(0, nums[0]));
        for (int i = 1 ; i < nums.length; i++) {
            while(!stack.isEmpty() && stack.peek().getValue() < nums[i]) {
                result[stack.pop().getKey()] = i;
            }
            stack.push(new Pair(i, nums[i]));
        }

//        while (!stack.isEmpty()) {
//            result[stack.pop().getKey()] = -1;
//        }
//        Map<Integer> map = new HashMap<>();
//        String.join()

        return result;
    }
}

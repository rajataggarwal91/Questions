import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String args[]) {
        System.out.println(lis(new int[]{10,22,9,33,21,80,41,60,80}));
    }

    private static int lis(int[] nums) {
        int[] lis = new int[nums.length];
        int[] prev = new int[nums.length];
        Arrays.fill(lis, 1);
        prev[0] = -1;
        int last = 0;

        for (int i = 1; i < nums.length; i++) {
            int j = 0;
            while (j < i) {
                if (nums[i] > nums[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                    prev[i] = j;
                }

                j++;
            }
        }

        // Getting the maximum value of lis and from there backtrack to find the previous path of subsequence.
        int maxIndex = -1;
        int maxCount = 1;
        for (int i = 0 ; i < nums.length; i++) {
            if (lis[i] > maxCount) {
                maxCount = lis[i];
                maxIndex = i;

            }
        }
        int temp = maxIndex;
        for (int i = 0 ; i < maxCount; i++) {
            System.out.println(nums[temp]);
            temp = prev[temp];
        }

        return Arrays.stream(lis).max().getAsInt();
    }
}


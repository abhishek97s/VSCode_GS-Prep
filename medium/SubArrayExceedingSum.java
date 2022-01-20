package medium;

//find the length of minimum subarray exceeding sum
public class SubArrayExceedingSum {
    public static int subArrayExceedsSum(int nums[], int target) {

        if (nums==null || nums.length == 0)
            return -1;

            int n = nums.length;
            int ans = Integer.MAX_VALUE;
            int left = 0;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += nums[i];
                while (sum >= target) {
                    ans = Math.min(ans, i + 1 - left);
                    sum -= nums[left++];
                }
            }
            System.out.println(ans);
            return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    /**
     * Execution entry point.
     */
    public static void main(String[] args) {
        boolean result = true;
        int[] arr = { 2, 4, 3, 2 };
        result = result && subArrayExceedsSum(arr, 6) == 2;
        result = result && subArrayExceedsSum(arr, 12) == -1;

        if (result) {
            System.out.println("All tests pass\n");
        } else {
            System.out.println("There are test failures\n");
        }
    }
};
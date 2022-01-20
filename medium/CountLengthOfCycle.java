package medium;

public class CountLengthOfCycle {

	public static int countLengthOfCycle(int[] arr, int startIndex) {
		if (arr == null || arr.length < 1 || arr[startIndex] >= arr.length)
			return -1;

		int count = 1;
		int slow = arr[startIndex];
		int fast = arr[arr[startIndex]];

		while (slow != fast) {
			if (slow < 0 || fast < 0 || fast >= arr.length || arr[fast] >= arr.length)
				return -1;

			count += 1;
			slow = arr[slow];
			fast = arr[arr[fast]];
		}
		System.out.println(count);
		return count;
	}

	public static void main(String[] args) {

		boolean testsPassed = true;

		testsPassed &= countLengthOfCycle(new int[] { 1, 0 }, 0) == 2;
		testsPassed &= countLengthOfCycle(new int[] { 1, 2, 3, 4, 15, 0 }, 0) == -1;
		testsPassed &= countLengthOfCycle(new int[] { 2, 0, -1 }, 0) == -1;
		testsPassed &= countLengthOfCycle(new int[] { 1, 2, 0 }, 0) == 3;
		testsPassed &= countLengthOfCycle(new int[] { 1, 2, 1 }, 0) == 2;
		testsPassed &= countLengthOfCycle(new int[] { 1, 3, 0, 4, 1 }, 0) == 3;

		if (testsPassed) {
			System.out.println("Test passed.");
			// return true;
		} else {
			System.out.println("Test failed.");
			// return false;
		}

	}
}

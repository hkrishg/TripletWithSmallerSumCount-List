import java.util.*;

class Main {

  // Given an array arr of unsorted numbers and a target sum, count all triplets
  // in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three
  // different indices. Write a function to return the count of such triplets.

  // Example 1:

  // Input: [-1, 0, 2, 3], target=3
  // Output: 2
  // Explanation: There are two triplets whose sum is less than the target: [-1,
  // 0, 3], [-1, 0, 2]
  // Example 2:

  // Input: [-1, 4, 2, 1, 3], target=5
  // Output: 4
  // Explanation: There are four triplets whose sum is less than the target:
  // [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]

  public static int TripletCountWithSmallerSum(int[] nums, int target) {
    int count = 0;
    Arrays.sort(nums);
    int len = nums.length;
    for (int i = 0; i < len - 2; i++) {
      int left = i + 1, right = len - 1;
      while (left < right) {
        if (nums[i] + nums[left] + nums[right] < target) {
          // we know that since -2 + 0 + 3 < 2, we can replace hi (3) with 1, and it would
          // still work. Therefore, we can just add hi - lo to the triplet count.
          count += right - left;
          left++;
        } else {
          right--;
        }
      }
    }

    return count;
  }

  // Problem: Write a function to return the list of all such triplets instead of
  // the count. How will the time complexity change in this case?

  public static List<List<Integer>> TripletListWithSmallerSum(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    int len = nums.length;
    for (int i = 0; i < len - 2; i++) {
      int left = i + 1, right = len - 1;
      while (left < right) {
        if (nums[i] + nums[left] + nums[right] < target) {
          // we know that since -2 + 0 + 3 < 2, we can replace hi (3) with 1, and it would
          // still work. Therefore, we can just add hi - lo to the triplet count.
          for (int j = right; j > left; j--)
            result.add(Arrays.asList(nums[i], nums[left], nums[j]));
          left++;
        } else {
          right--;
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(Main.TripletCountWithSmallerSum(new int[] { -1, 0, 2, 3 }, 3));
    System.out.println(Main.TripletCountWithSmallerSum(new int[] { -1, 4, 2, 1, 3 }, 5));
    System.out.println(Main.TripletListWithSmallerSum(new int[] { -1, 0, 2, 3 }, 3));
    System.out.println(Main.TripletListWithSmallerSum(new int[] { -1, 4, 2, 1, 3 }, 5));
  }
}
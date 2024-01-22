// Rotate Array

// Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.


// Example 1:

// Input: nums = [1,2,3,4,5,6,7], k = 3
// Output: [5,6,7,1,2,3,4]
// Explanation:
// rotate 1 steps to the right: [7,1,2,3,4,5,6]
// rotate 2 steps to the right: [6,7,1,2,3,4,5]
// rotate 3 steps to the right: [5,6,7,1,2,3,4]
// Example 2:

// Input: nums = [-1,-100,3,99], k = 2
// Output: [3,99,-1,-100]
// Explanation: 
// rotate 1 steps to the right: [99,-1,-100,3]
// rotate 2 steps to the right: [3,99,-1,-100]


// Constraints:

// 1 <= nums.length <= 105
// -231 <= nums[i] <= 231 - 1
// 0 <= k <= 105
 
// Follow up:

// Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
// Could you do it in-place with O(1) extra space?


//Solution 1: Using Extra Space

public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle cases where k is greater than the length of the array
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = nums[i];
        }
        
        System.arraycopy(result, 0, nums, 0, n); // Update the original array in-place
    }
}


//Solution 2: Reverse Three Times

class Solution 
{
    public void rotate(int[] nums, int k) 
    {
        
    int n = nums.length;
        k = k % n;

        
        reverse(nums, 0, n - 1);
       
        reverse(nums, 0, k - 1);
        
        reverse(nums, k, n - 1);
    }

    public static void reverse(int[] nums, int start, int end) 
    {
        while (start < end) 
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}


//Solution 3: Using Cyclic Replacements

public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        
        int count = 0;
        for (int start = 0; count < n; start++) {
            int current = start;
            int prev = nums[start];
            
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}
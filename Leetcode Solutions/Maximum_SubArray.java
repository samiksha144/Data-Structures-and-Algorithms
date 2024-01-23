// Given an integer array nums, find the 
// subarray
//  with the largest sum, and return its sum.


// Example 1:

// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.


// Example 2:

// Input: nums = [1]
// Output: 1
// Explanation: The subarray [1] has the largest sum 1.


// Example 3:

// Input: nums = [5,4,-1,7,8]
// Output: 23
// Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 

// Constraints:

// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
 

// Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

class Solution {
    public int maxSubArray(int[] nums) 
    {
        int n = nums.length;

        int max_sum_possible = nums[0];

        int current_max = nums[0];

        for(int i=1;i<n;i++)
        {
            current_max = Math.max(nums[i], nums[i] + current_max);

            max_sum_possible = Math.max(current_max, max_sum_possible);
        }

        return max_sum_possible;
        
    }
}

// Time Complexity:
// The time complexity of the algorithm is O(n), where n is the length of the input array nums. The loop iterates through each element of the array once, performing constant time operations in each iteration.

// Space Complexity:
// The space complexity is O(1) because the algorithm uses a constant amount of extra space regardless of the size of the input array. It only uses a few variables (n, max_sum_possible, and current_max) to keep track of the maximum subarray sum and the current subarray sum. Therefore, the space complexity is constant and does not depend on the size of the input array.
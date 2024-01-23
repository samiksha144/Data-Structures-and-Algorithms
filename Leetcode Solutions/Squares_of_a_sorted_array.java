// Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.


// Example 1:

// Input: nums = [-4,-1,0,3,10]
// Output: [0,1,9,16,100]
// Explanation: After squaring, the array becomes [16,1,0,9,100].
// After sorting, it becomes [0,1,9,16,100].

// Example 2:

// Input: nums = [-7,-3,2,3,11]
// Output: [4,9,9,49,121]
 

// Constraints:

// 1 <= nums.length <= 104
// -104 <= nums[i] <= 104
// nums is sorted in non-decreasing order.

class Solution 
{
    public int[] sortedSquares(int[] nums) 
    {
        int[] result = new int[nums.length];

    
    for (int i = 0; i < nums.length; i++) 
    {
      nums[i] = nums[i] * nums[i];
    }

    int head = 0;
    int tail = nums.length - 1;

    
    for (int pos = nums.length - 1; pos >= 0; pos--) 
    {

      if (nums[head] > nums[tail]) {
        result[pos] = nums[head];
       
        head++;
      } else {
        result[pos] = nums[tail];
      
        tail--;
      }
    }

    return result;
  }

}

// Time Complexity:

// The first loop that squares each element in the nums array has a time complexity of O(n), where n is the length of the array.
// The second loop, which fills in the result array by comparing and inserting elements from the squared nums array, also has a time complexity of O(n).
// Therefore, the overall time complexity of the code is O(n).

// Space Complexity:

// The result array is created with a length of nums.length, contributing to a space complexity of O(n) for the result array.
// The use of additional variables (head, tail, and pos) does not depend on the size of the input array and can be considered constant space.
// Therefore, the overall space complexity of the code is O(n) due to the result array.




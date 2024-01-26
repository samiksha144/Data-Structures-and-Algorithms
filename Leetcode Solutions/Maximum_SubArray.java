/*Given an integer array nums, find the 
subarray
 with the largest sum, and return its sum.


Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.


Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.


Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

*/

/* Solution 1 : Brute force approach

Implementation steps :

1.] The method maxSubArray takes an array of integers (nums) as input.
2.] n is initialized to the length of the input array (nums.length).
3.] maxSum is initialized to Integer.MIN_VALUE. This variable will store the maximum subarray sum found so far.
4.] The outer loop (for (int i = 0; i < n; i++)) iterates over each possible starting index of the subarray.
5.] The inner loop (for (int j = i; j < n; j++)) iterates over each possible ending index of the subarray, starting from the current starting index.
6.] Inside the inner loop, a variable currentSum is initialized to 0. This variable will store the sum of the subarray from index i to index j.
7.] The elements of the subarray are added to currentSum in each iteration of the inner loop.
8.] At each step in the inner loop, the maximum of the current subarray sum (currentSum) and the overall maximum subarray sum (maxSum) is calculated using Math.max and updated in the maxSum variable.
9.] After both loops complete, the method returns the final maximum subarray sum (maxSum).

*/

class Solution {
    public int maxSubArray(int[] nums) 
    {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) 
        {
            int currentSum = 0;
            for (int j = i; j < n; j++) 
            {
                currentSum += nums[j];
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }
}

/*
Time complexity :
The time complexity of this solution is O(n^2) because there are two nested loops, each iterating over the length of the input array. 

Space complexity :
The space complexity is O(1) because only a constant amount of extra space is used to store the variables.
*/




/* Solution 2 : Kadane's algorithm 

Implementation steps :

1.] n: Get the length of the input array nums.
2.] max_sum_possible: Initialize it with the first element of the array. This variable will store the maximum subarray sum found so far.
3.] current_max: Initialize it with the first element of the array. This variable will store the maximum subarray sum ending at the current position.
4.] Use a loop to iterate over the array starting from the second element (i=1) since we have already initialized our variables with the first element.
5.] At each step, update current_max to be the maximum of the current element nums[i] and the sum of nums[i] and current_max. This step represents the decision of whether to start a new subarray or continue with the existing one.
6.] Update max_sum_possible to be the maximum of the current current_max and the previous max_sum_possible. This step ensures that max_sum_possible always holds the maximum subarray sum found so far.
7.] After the loop completes, the variable max_sum_possible contains the maximum subarray sum, so return it as the result of the function.

*/

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

/* 
Time Complexity:
The time complexity of the algorithm is O(n), where n is the length of the input array nums. The loop iterates through each element of the array once, performing constant time operations in each iteration.

Space Complexity:
The space complexity is O(1) because the algorithm uses a constant amount of extra space regardless of the size of the input array. It only uses a few variables (n, max_sum_possible, and current_max) to keep track of the maximum subarray sum and the current subarray sum. Therefore, the space complexity is constant and does not depend on the size of the input array.
*/






/* Solution 3 : Divde and conquer approach

Implementation steps :

1.] This is the public method that users will call to find the maximum subarray sum.
2.] It initializes the call to the helper method maxSubArrayHelper with the entire array and its bounds (0 to nums.length - 1).
3.] maxSubArrayHelper Method: implements the divide-and-conquer approach to find the maximum subarray sum.
4.] Base Case: If the array has only one element (low == high), return that element.
5.] Calculate the middle index (mid) of the array.
6.] Recursively find the maximum subarray sum in the left half (low to mid) and the right half (mid + 1 to high).
7.] Find the maximum subarray sum that crosses the midpoint using the maxCrossingSubarray method.
8.] Return the maximum of the three sums: leftMax, rightMax, and crossMax.
9.] maxCrossingSubarray Method: This method finds the maximum subarray sum that crosses the midpoint.
10.] It calculates the maximum sum in the left subarray by iterating from the midpoint (mid) to the beginning of the array (low).
11.] It calculates the maximum sum in the right subarray by iterating from the midpoint (mid + 1) to the end of the array (high).
12.] Return the sum of the maximum left and right subarrays.

 */

 class Solution {
    public int maxSubArray(int[] nums) {
        return maxSubArrayHelper(nums, 0, nums.length - 1);
    }

    private int maxSubArrayHelper(int[] nums, int low, int high) {
        // Base case: If the array has only one element, return that element
        if (low == high) {
            return nums[low];
        }

        // Calculate the middle index
        int mid = (low + high) / 2;

        // Recursively find the maximum subarray sum in the left and right halves
        int leftMax = maxSubArrayHelper(nums, low, mid);
        int rightMax = maxSubArrayHelper(nums, mid + 1, high);

        // Find the maximum subarray sum that crosses the midpoint
        int crossMax = maxCrossingSubarray(nums, low, mid, high);

        // Return the maximum of the three sums
        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    private int maxCrossingSubarray(int[] nums, int low, int mid, int high) {
        // Find the maximum sum in the left subarray
        int leftMax = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= low; i--) {
            sum += nums[i];
            leftMax = Math.max(leftMax, sum);
        }

        // Find the maximum sum in the right subarray
        int rightMax = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= high; i++) {
            sum += nums[i];
            rightMax = Math.max(rightMax, sum);
        }

        // Return the sum of the maximum left and right subarrays
        return leftMax + rightMax;
    }
}


/*
Time complexity :
The time complexity of this solution is O(n log n), where n is the length of the input array. This is because the algorithm uses a divide and conquer approach, recursively splitting the array in half and solving subproblems. The merge step, which finds the maximum subarray that crosses the midpoint, takes O(n) time.

Space complexity :
The space complexity is O(log n) due to the recursive calls on the stack. This is because the algorithm splits the array in half at each step, resulting in a maximum recursion depth of log n.
*/
/*Rotate Array

Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.


Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]


Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

Follow up:

Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space? */



//Solution 1: Using brute force approach

/*Implementation steps :
  1.] n = nums.length: Determine the length of the array nums.
  2.] k = k % n: Ensure that k is within the valid range (less than the length of the array) by taking the modulo of k with n.
  3.] Run the outer loop k times to perform the rotation k times.
  4.] For each iteration of the outer loop, perform a right rotation of the array by one step.
  5.] int temp = nums[n - 1];: Store the last element of the array in a temporary variable (temp).
  6.] for (int j = n - 1; j > 0; j--) { nums[j] = nums[j - 1]; }: Shift each element one position to the right, starting from the last element and moving towards the beginning of the array.
  7.] nums[0] = temp;: Place the last element (stored in temp) at the beginning of the array.
  8.] After the outer loop completes (k iterations), the array nums will be rotated to the right by k steps.
 */

public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        // Handle the case when k is greater than array length
        k = k % n;

        for (int i = 0; i < k; i++) {
            // Rotate the array one step to the right
            int temp = nums[n - 1];
            for (int j = n - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }
}

/*
Time Complexity:

The outer loop runs k times.
The inner loop performs a right rotation of the array, shifting each element one step to the right.
The inner loop has a time complexity of O(n) for each iteration.
Therefore, the overall time complexity is O(k * n).

Space Complexity:

The algorithm uses a constant amount of extra space regardless of the input size.
The only additional variable used is temp to store the last element during the rotation.
Thus, the space complexity is O(1), indicating constant space usage.

Time Complexity: O(k * n)
Space Complexity: O(1)
*/



//Solution 2: Using Extra Space

/* Implementation steps : 
   1.] Get the length of the input array (n).
   2.] Ensure k is within bounds by calculating k = k % n.
   3.] Create a new array (result) to store the rotated elements.
   4.] Create rotation (for) loop for each index 'i' in the original array (nums):
   5.] Calculate the new index after rotation: (i + k) % n.
   6.] Store the element at the current index in nums at the calculated index in the result array.
   7.] Use System.arraycopy to copy the rotated elements from the result array back to the original array (nums).
       Source array: result
       Source index: 0
       Destination array: nums
       Destination index: 0
       Number of elements to copy: n
*/

/* Which approach is used ?
   Ans : Modulo Indexing approach.
*/

public class Solution 
{
    public void rotate(int[] nums, int k) 
    {
        int n = nums.length;
        k = k % n; // Handle cases where k is greater than the length of the array
        int[] result = new int[n];

        for (int i = 0; i < n; i++) 
        {
            result[(i + k) % n] = nums[i];
        }

        System.arraycopy(result, 0, nums, 0, n); // Update the original array in-place
    }
}

// Time Complexity: O(n) - We iterate through the entire array once.
// Space Complexity: O(n) - We use extra space to store the rotated array.




//Solution 3: Reverse Three Times

/*Implementation steps

1.] Declare a method rotate which takes an array of integers nums and an integer k as parameters.
2.] Calculate the length of the array n.
3.] Update k to be the effective rotation value, i.e., k = k % n.
4.] Call the reverse method on the array nums with parameters 0 and n - 1. This effectively reverses the entire array.
5.] Call the reverse method on the array nums with parameters 0 and k - 1. This reverses the first part of the array up to position k - 1.
6.] Call the reverse method on the array nums with parameters k and n - 1. This reverses the second part of the array starting from position k to the end.

*/

/* Which approach is used ?
   Ans : Two pointer approach.
*/ 

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

// Time Complexity: O(n) - We reverse the entire array and then reverse two subarrays.
// Space Complexity: O(1) - We use constant space for temporary variables.





//Solution 4: Using Cyclic Replacements

/*Implementation steps :
  1.] Calculate the length of the array n.
  2.] Update k to be the remainder of the division of k by n. This ensures that k is within the valid range of array indices.
  3.] Initialize a counter variable count to keep track of the number of elements that have been rotated.
  4.] Use a for loop to iterate through the array indices, starting from start = 0.
  Inside the loop:
  * Initialize current to the current index.
  * Initialize prev to the value at the current index (nums[start]).
  * Use a do-while loop to perform the actual rotation until we come back to the starting index.
  * Calculate the next index (next) by adding k to the current index and taking the modulo n.
  * Swap the values at the current and next indices.
  * Update prev to the value that was at the next index.
  * Update current to the next index.
  * Increment the count variable.
  5.] Repeat the process until all elements in the array have been rotated.
  6.] The outer loop continues until count is equal to n, meaning all elements have been rotated.
 */

 /* Which approach is used ?
   Ans : The approach used in this code is known as the "Cycle Reversal" or "Juggling" algorithm. This algorithm is commonly used for rotating an array.
*/ 

public class Solution 
{
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        int count = 0;
        for (int start = 0; count < n; start++) 
        {
            int current = start;
            int prev = nums[start];

            do 
            {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } 
            while (start != current);
        }
    }
}

// Time Complexity: O(n) - We visit each element of the array once.
// Space Complexity: O(1) - We use constant space for temporary variables.
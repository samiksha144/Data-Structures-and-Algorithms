/* Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.


Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]

Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
 
*/

/* Solution 1 : Brute force approach

Implementation steps :

1.] Declare a variable n to store the length of the input array nums.
2.] Create an array result of size n to store the squared values.
3.] Use a loop to iterate through each element of the input array nums.
4.] Square each element and store the result in the corresponding position of the result array.
5.] Use the Arrays.sort method to sort the result array in ascending order.
6.] Return the sorted squared array result as the final output.

*/

class Solution 
{
    public int[] sortedSquares(int[] nums) 
    {
         int n = nums.length;
        int[] result = new int[n];

        // Square each element
        for (int i = 0; i < n; i++) {
            result[i] = nums[i] * nums[i];
        }

        // Sort the squared array
        Arrays.sort(result);

        return result;
    }
}

// Time complexity :
// The time complexity of this solution is O(n log n), where n is the length of the input array nums. This is because the solution involves squaring each element in the array, which takes O(n) time, and then sorting the squared array using Arrays.sort(), which has a time complexity of O(n log n).

// Space complexity : 
// The space complexity of this solution is O(n), where n is the length of the input array nums. This is because the solution creates a new array called result to store the squared elements, which requires O(n) space.

 

/* Solution 2 : Two pointer approach

Implementation Steps:

1.] Create an array result to store the squared values and eventual sorted result.
2.] Iterate through each element of the input array nums and square each element.
3.] Initialize two pointers, head and tail, pointing to the beginning and end of the squared array, respectively.
4.] Iterate from the end of the result array.
5.] Compare the squared values at the head and tail positions.
6.] Place the larger value at the current position in the result array and move the corresponding pointer.
7.] The result array now contains the squared values of the input array, sorted in non-decreasing order.

 */


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




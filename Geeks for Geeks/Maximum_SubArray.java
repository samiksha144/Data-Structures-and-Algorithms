/*Find out the maximum sub-array of non negative numbers from an array.

The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).

Example:
a = [1, 2, 5, -7, 2, 3]
The two sub-arrays are [1, 2, 5] [2, 3].
The answer is [1, 2, 5] as its sum is larger than [2, 3]

NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length.
If there is still a tie, then return the segment with minimum starting index.
If no such subarray is present return "-1"

Example 1:

Input:
n = 3
a[] = {1, 2, 3}
Output: 1 2 3
Explanation: In the given array every
element is non-negative.


Example 2:

Input:
n = 2
a[] = {-1, 2}
Output: 2
Explanation: The only subarray [2] is
the answer.
 

Your Task:
Complete the function findSubarray() which takes the array a and the size of the array, n, as input parameters and returns an array representing the answer. If there is no subarray return an array of length 1 containing -1 only. You don't to print answer or take inputs.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
*/


/*Solution 1 : Brute force approach

Implementation steps :

1.] maxSum: Initialize to Integer.MIN_VALUE to keep track of the maximum sum found.
2.] start: Initialize to -1, indicating the start index of the maximum subarray.
3.] end: Initialize to -1, indicating the end index of the maximum subarray.
4.] The outer loop (indexed by i) iterates over all possible starting indices of the subarray.
5.] The inner loop (indexed by j) iterates over all possible ending indices of the subarray, starting from the current i.
6.] Calculate the sum of the subarray from index i to j using currentSum.
7.] If currentSum is greater than maxSum, update maxSum, start, and end with the current values of currentSum, i, and j respectively.
8.] After the loops, create an ArrayList<Integer> named result to store the elements of the subarray with the maximum sum.
9.] Use a loop to copy elements from the a array, starting from the start index and ending at the end index, into the result ArrayList.
10.] Return the result ArrayList containing the subarray with the maximum sum.

*/

 class Solution
 {
     ArrayList<Integer> findSubarray(int a[], int n) 
     {
         n = a.length;
         int maxSum = Integer.MIN_VALUE;
         int start = -1;
         int end = -1;
 
         for (int i = 0; i < n; i++) 
         {
             int currentSum = 0;
             for (int j = i; j < n; j++) 
             {
                 currentSum += a[j];
                 if (currentSum > maxSum) 
                 {
                     maxSum = currentSum;
                     start = i;
                     end = j;
                 }
             }
         }
 
         // Create an ArrayList to store the subarray with the maximum sum
         ArrayList<Integer> result = new ArrayList<>();
         for (int i = start; i <= end; i++) 
         {
             result.add(a[i]);
         }
 
         // Return the ArrayList
         return result;
     }
 }

/*
Time complexity :
The time complexity of the findSubarray method is O(n^2) because there are two nested loops. The outer loop runs n times, and the inner loop runs n-i times for each iteration of the outer loop. Therefore, the total number of iterations is n + (n-1) + (n-2) + ... + 1, which is equal to n(n+1)/2, resulting in a time complexity of O(n^2).

Space complexity :
The space complexity of the findSubarray method is O(n) because the size of the result ArrayList is proportional to the size of the subarray with the maximum sum. In the worst case, the subarray could contain all n elements of the input array, resulting in a space complexity of O(n).
*/

 


/* Solution 2 : 

Implementation steps :

1.] Initialize max_sum to -1, which will store the maximum sum found.
2.] Initialize cur_sum to 0, which will store the current sum of the elements in the current range.
3.] Initialize max_range_left and max_range_right to -1, representing the indices of the maximum sum subarray.
4.] Initialize cur_range_left and cur_range_right to 0, representing the current indices of the subarray being considered.
5.] Use a while loop to iterate through the array until cur_range_right reaches the end of the array (n).
6.] Inside the loop:
If the current element is negative, update cur_range_left to the next element, and reset cur_sum to 0.
If the current element is non-negative, add it to cur_sum.
Update max_sum, max_range_left, and max_range_right if the current sum is greater than max_sum.
If the current sum is equal to max_sum, update max_range_left and max_range_right if the current range is larger than the previous max range.
7.] After the loop, check if max_range_left and max_range_right are still -1. If they are, there is no valid subarray with a positive sum. In this case, add -1 to the result ArrayList and return it.
8.] If not, create a new ArrayList called ans to store the elements of the subarray.
9.] Use a for loop to iterate from max_range_left to max_range_right and add the corresponding elements to the ans ArrayList.
10.] Return the ans ArrayList containing the elements of the subarray with the maximum sum.

 */

 
class Solution
{

    ArrayList<Integer> findSubarray(int a[], int n) 
    {
        long max_sum = -1;  
        long cur_sum = 0;  // initialize current sum to 0
        int max_range_left = -1;  // initialize max range left to -1
        int max_range_right = -1;  // initialize max range right to -1
        int cur_range_left = 0;  // initialize current range left to 0
        int cur_range_right = 0;  // initialize current range right to 0
        
        while (cur_range_right < n) 
        {  // iterate until current range right reaches the end
            if (a[cur_range_right] < 0) 
            {  // if current element is negative
                cur_range_left = cur_range_right + 1;  // update current range left to next element
                cur_sum = 0;  // reset current sum to 0
            } 
            else 
            {
                cur_sum += (long)a[cur_range_right];  // add current element to current sum
                if (cur_sum > max_sum) 
                {  // if current sum is greater than max sum
                    max_sum = cur_sum;  // update max sum
                    max_range_left = cur_range_left;  // update max range left
                    max_range_right = cur_range_right;  // update max range right
                } 
                else if (cur_sum == max_sum) 
                {  // if current sum is equal to max sum
                    if (cur_range_right + 1 - cur_range_left >
                        max_range_right + 1 - max_range_left) 
                        {  // if current range is larger than max range
                        max_range_left = cur_range_left;  // update max range left
                        max_range_right = cur_range_right;  // update max range right
                        }
                }
            }
            cur_range_right++;  // increment current range right
        }
        
        ArrayList<Integer> ans = new ArrayList<>();  // create a new ArrayList for the answer
        
        if (max_range_left == -1 || max_range_right == -1) 
        {  // if max range is still -1
            ans.add(-1);  // add -1 to the answer
            return ans;  // return the answer
        }

        for (int i = max_range_left; i <= max_range_right; ++i) ans.add(a[i]);  // add elements from max range to the answer
        return ans;  // return the answer
    }
}


// Time Complexity: As we finding the range first then pushing the elements. So the time complexity is O(N), N is number of given elements.

// Space Complexity: As we are storing the elements in a vector so the space complexity is O(N), N is number of elements.
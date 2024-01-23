// Find out the maximum sub-array of non negative numbers from an array.

// The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

// Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).

// Example:
// a = [1, 2, 5, -7, 2, 3]
// The two sub-arrays are [1, 2, 5] [2, 3].
// The answer is [1, 2, 5] as its sum is larger than [2, 3]

// NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length.
// If there is still a tie, then return the segment with minimum starting index.
// If no such subarray is present return "-1"

// Example 1:

// Input:
// n = 3
// a[] = {1, 2, 3}
// Output: 1 2 3
// Explanation: In the given array every
// element is non-negative.


// Example 2:

// Input:
// n = 2
// a[] = {-1, 2}
// Output: 2
// Explanation: The only subarray [2] is
// the answer.
 

// Your Task:
// Complete the function findSubarray() which takes the array a and the size of the array, n, as input parameters and returns an array representing the answer. If there is no subarray return an array of length 1 containing -1 only. You don't to print answer or take inputs.

// Expected Time Complexity: O(N)
// Expected Auxiliary Space: O(1)


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
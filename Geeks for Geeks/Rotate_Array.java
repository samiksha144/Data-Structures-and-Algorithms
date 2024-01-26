/*Given an unsorted array arr[] of size N. Rotate the array to the left (counter-clockwise direction) by D steps, where D is a positive integer. 


Example 1:

Input:
N = 5, D = 2
arr[] = {1,2,3,4,5}
Output: 3 4 5 1 2
Explanation: 1 2 3 4 5  when rotated
by 2 elements, it becomes 3 4 5 1 2.


Example 2:

Input:
N = 10, D = 3
arr[] = {2,4,6,8,10,12,14,16,18,20}
Output: 8 10 12 14 16 18 20 2 4 6
Explanation: 2 4 6 8 10 12 14 16 18 20 
when rotated by 3 elements, it becomes 
8 10 12 14 16 18 20 2 4 6.
 

Your Task:
You need not print or read anything. You need to complete the function rotateArr() which takes the array, D and N as input parameters and rotates the array by D elements. The array must be modified in-place without using extra space. 
 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

*/

//Solution 1: Using brute force approach

/*Implementation steps :
  1.] n = arr.length: Determine the length of the array arr.
  2.] d = d % n: Ensure that d is within the valid range (less than the length of the array) by taking the modulo of d with n.
  3.] Run the outer loop d times to perform the rotation d times.
  4.] For each iteration of the outer loop, perform a right rotation of the array by one step.
  5.] int temp = arr[0];: Store the first element of the array in a temporary variable (temp).
  6.] for (int j = 0; j < n-1; j++) { arr[j] = arr[j + 1]; }: Shift each element one position to the left, starting from the first element and moving towards the end of the array.
  7.] arr[n-1] = temp;: Place the first element (stored in temp) at the end of the array.
  8.] After the outer loop completes (d iterations), the array arr will be rotated to the right by d steps.
 */

 class Solution
{
    //Function to rotate an array by d elements in counter-clockwise direction. 
    static void rotateArr(int arr[], int d, int n)
    {
        
        n = arr.length;

        // Handle the case when k is greater than array length
        d = d % n;

        for (int i = 0; i < d; i++) 
        {
            // Rotate the array one step to the right
            int temp = arr[0];
            for (int j = 0; j < n-1; j++) 
            {
                arr[j] = arr[j + 1];
            }
            arr[n-1] = temp;
        }
    }
}
 
 /*
 Time Complexity:
 
 The outer loop runs d times.
 The inner loop performs a right rotation of the array, shifting each element one step to the left.
 The inner loop has a time complexity of O(n) for each iteration.
 Therefore, the overall time complexity is O(d * n).
 
 Space Complexity:
 
 The algorithm uses a constant amount of extra space regardless of the input size.
 The only additional variable used is temp to store the first element during the rotation.
 Thus, the space complexity is O(1), indicating constant space usage.
 
 Time Complexity: O(d * n)
 Space Complexity: O(1)
 */


//Solution 2: Using Extra Space

/* Implementation steps : 
   1.] Get the length of the input array (n).
   2.] Ensure d is within bounds by calculating d = d % n.
   3.] Create a new array (result) to store the rotated elements.
   4.] Create rotation (for) loop for each index 'i' in the original array (arr):
   5.] Calculate the new index after rotation: (i - k + n) % n.
   6.] Store the element at the current index in arr at the calculated index in the result array.
   7.] Use System.arraycopy to copy the rotated elements from the result array back to the original array (arr).
       Source array: result
       Source index: 0
       Destination array: arr
       Destination index: 0
       Number of elements to copy: n
*/

/* Which approach is used ?
   Ans : Modulo Indexing approach.
*/

class Solution
{
    //Function to rotate an array by d elements in counter-clockwise direction. 
    static void rotateArr(int arr[], int d, int n)
    {
        
        n = arr.length;
        d = d % n; // Handle cases where k is greater than the length of the array
        int[] result = new int[n];

        for (int i = 0; i < n; i++) 
        {
            result[(i - d + n) % n] = arr[i];
        }

        System.arraycopy(result, 0, arr, 0, n); // Update the original array in-place
    }
}

// Time Complexity: O(n) - We iterate through the entire array once.
// Space Complexity: O(n) - We use extra space to store the rotated array.



//Solution 3: Reverse Three Times

/*Implementation steps

1.] Declare a method rotate which takes an array of integers arr and an integer d as parameters.
2.] Calculate the length of the array n.
3.] Update d to be the effective rotation value, i.e., d = d % n.
4.] Call the reverse method on the array nums with parameters 0 and d - 1. This reverses the first part of the array up to position k - 1.
5.] Call the reverse method on the array nums with parameters d and n - 1. This reverses the second part of the array starting from position d to the end.
6.] Call the reverse method on the array nums with parameters 0 and n - 1. This effectively reverses the entire array.
*/

/* Which approach is used ?
   Ans : Two pointer approach.
*/ 

class Solution
{
    //Function to rotate an array by d elements in counter-clockwise direction. 
    static void rotateArr(int arr[], int d, int n)
    {
        
        d = d%n;
        
        reverse(arr, 0, d-1);
        reverse(arr, d, n-1);
        reverse(arr, 0, n-1);
        
    }
    
    public static void reverse (int arr[], int start, int end)
    {
        int temp;
        
        while(start<end)
        {
        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
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
  2.] Update d to be the remainder of the division of d by n. This ensures that d is within the valid range of array indices.
  3.] Initialize a counter variable count to keep track of the number of elements that have been rotated.
  4.] Use a for loop to iterate through the array indices, starting from start = 0.
  Inside the loop:
  * Initialize current to the current index.
  * Initialize prev to the value at the current index (arr[start]).
  * Use a do-while loop to perform the actual rotation until we come back to the starting index.
  * Calculate the next index (next) by subtracting d from the current index and adding n and then taking the modulo n.
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

class Solution
{
    //Function to rotate an array by d elements in counter-clockwise direction. 
    static void rotateArr(int arr[], int d, int n)
    {
        
        n = arr.length;
        d = d % n;

        int count = 0;
        for (int start = 0; count < n; start++) 
        {
            int current = start;
            int prev = arr[start];

            do 
            {
                int next = (current - d + n) % n;
                int temp = arr[next];
                arr[next] = prev;
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
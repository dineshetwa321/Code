package a.array.cond;

/*
Given a range [L, R], the task is to print all the perfect squares from the given range.
Examples: 
 

Input: L = 2, R = 24 
Output: 4 9 16
Input: L = 1, R = 100 
Output: 1 4 9 16 25 36 49 64 81 100 
 */
public class SquaresRtWithInRange 
{
     
// Function to print all the perfect
// squares from the given range
static void findSq(int l, int r)
{
 
    // For every element from the range
    for (int i = l; i <= r; i++) 
    {
 
        // If current element is a perfect square
        if (Math.sqrt(i) == (int)Math.sqrt(i))
            System.out.print(i + " ");
    }
}
 
// Driver code
public static void main (String[] args)
{
    int l = 2, r = 24;
    findSq(l, r);
}
}
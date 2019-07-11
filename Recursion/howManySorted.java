/**
 * A recursive method that receives a size of a array and a maximum number,
 * returns the the number of options to fill the array with numbers
 * from 1 to max (the numbers are in ordered).
 *
 */
public class howManySorted
{
    public static int howManySorted(int n, int max)
    {
        return howManySorted(n, max, 0 , 1);
    }
    public static int howManySorted(int n, int max, int index, int counter){
        if (index == n - 1) {
            return (max - counter) + 1;
        }
        if (counter == max + 1){
            return 0; 
        }
        return howManySorted(n, max, index + 1, counter) +
               howManySorted(n, max, index, counter + 1);
    }
}


/**
 * This method receives as a parameter a 1D array filled with integers that are sorted
 * and receives an integer num. The method returns how many triples of 
 * numbers in an array whose sum is actually less than num. 
 * The numbers are not necessarily sequential numbers.
 */
public class countTriplets
{
    public static int countTriplets (int [] arr, int num) {
        int low = 0;
        int mid = 1;
        int high = arr.length - 1;
        if (arr.length < 3){
            return 0;
        }
        int count = 0; 
        while (low < high -1) {
            if (arr[low] + arr[mid] + arr[high] < num) {
                count = count + (high - mid);
                if (mid < high - 1)
                    mid++;
                else
                    { low++;
                      mid = low + 1;
                    }
                    
            }
            else {
                high--;
                mid = low + 1;
            }
        }
        return count;
    }
}

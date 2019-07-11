/**
 * An efficient Boolean method that accepts as a parameter a one-dimensional array containing integers.
 * The volume is sorted in a very ascending order. 
 * The method returns true if there are two sets of limit1 and limit2 indexes that are different and fulfills this conditions:
 * 1.limit1 < limit2
 * 2.The sum of values in cells from 0 to limit1 is negative
 * 3.The sum of values in cells limit1 + 1 to limit2 is zero
 * 4.The sum of values in cells from limit2 + 1 to arr.length is positive.
 * If there are no such indexes, false returns.
 */
public class splitTo3
{
    public static boolean splitTo3(int [] arr){
        int limit1 = 0, limit2 = arr.length-1,sum = 0;
        for (int i = limit1 ; i< limit2 ; i++){
            sum +=arr[i];
        }
        
        while (limit1 < limit2) {
            if (sum == 0)
                return true;
            else if (sum < 0)
            {
                sum -= arr[limit1];
                limit1++;
            }
            else if (sum > 0)
            {
                sum -= arr[limit2];
                limit2--;
            }
        }
        return false;
    }

    // Simple basic test
    public static void main(){
        int [] myarray1 = new int []{-8,-7,-5,-3,-2,5,8};
        System.out.println(splitTo3.splitTo3(myarray1));
    }
}

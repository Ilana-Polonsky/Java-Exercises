/**
 * FindX is a method that receives a sorted array of integers
 * and an integer x and returns true if there is two 
 * adjacent members whose sum is x and false if doesn't exsist.
 */
public class findX
{
    public static boolean findX(int[] a, int num)
    {
        int res = a[0];
        int start_index = 0;
        for (int i = 1 ; i < a.length ; i++){
            res += a[i];
            if (res == num) {
                return true;
            }
            else {
                res -= a[start_index];
                start_index += 1;
            }
        }
        return false; 
    }
    
    // Simple basic test
    public static void main(){
    int [] a1 = new int []{1,2,5,3,6,10,9};
    System.out.println(findX.findX(a1, 9));
    }
}

/**
 * FindX2 is a method that receives a sorted array of integers
 * and an integer x and returns true if there is two 
 * adjacent members whose sum is x and false if doesn't exsist.
 */
public class findX2 {
    public static boolean findX2(int [] a, int num){
        int low = 0, high = a.length - 1, m, sum;
        while( low <= high) {
            m = (low + high) / 2;
            sum = a[m] + a[m + 1];
            if (sum == num) {
                return true;
            }
            
            if (sum < num ){
                low = m + 1;
            }
            else {
                high = m - 1;
            }
        }
        return false; 
    }
    
    // Simple basic test
    public static void main(){
    int [] a1 = new int []{1,2,5,3,6,10,9};
    System.out.println(findX2.findX2(a1, 3));
    }
}

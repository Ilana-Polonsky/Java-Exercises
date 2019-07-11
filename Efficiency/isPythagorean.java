/**
 * An efficient Boolean method that accepts as a parameter an one-dimensional array filled with integers sorted in 
 * a very ascending order and returns true if the array has a triangular three and flase if it does not exist.
 * triangular three - three positive integers that satisfy the Pythagoras theorem, a^2 + b^2 = c^2.
 */
public class isPythagorean {
    public static boolean isPythagorean(int[] arr){
        for(int m = 1; m < arr.length - 1; m++){
            int low = 0;
            int high = m + 1;
            while ( low < m && high < arr.length ){
                int left = arr[low] * arr[low] + arr[m] * arr[m];
                int right = arr[high] * arr[high];
                if (left == right){ 
                    return true;
                }
                else if (left < right){
                    low++;
                }
                else {
                    high++;
                }
            }
        }
        return false;
    }
    
    //Simple basic test
    public static void main(){
        int[] myIntArray1 = new int[]{1,3,4,5,6};
        int[] myIntArray2 = new int[]{4,5,6,10,12};
        
        System.out.println(isPythagorean.isPythagorean(myIntArray1));
        System.out.println(isPythagorean.isPythagorean(myIntArray2));
    }
}

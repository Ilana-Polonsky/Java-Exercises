/**
 * A recursive method that accept as a parameter positive integer - n 
 * Returns the minimum number of connectors (1,5 and 7) so that n can be 
 * obtained by calculating their sum.
 */
public class oneFiveSeven
{     
    public static int oneFiveSeven(int n){
        if (n == 0){
            return 0;
        }
        
        int minnumber = oneFiveSeven(n-1);
        if (n >= 5) {
            int number5 = oneFiveSeven(n-5);
            if (number5 < minnumber) {
                minnumber = number5;
            }
        }
        
        if (n >= 7) {
            int number7 = oneFiveSeven(n-7);
            if (number7 < minnumber) {
                minnumber = number7;
            }
        }
        return minnumber+1;
    }
    
    //Simple basic test
    public static void main  (){
        int n = 10;
        System.out.println(oneFiveSeven.oneFiveSeven(n));
    }
}


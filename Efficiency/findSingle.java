/**
 * A static method that receives an array as parameter int this array each number 
 * appears twice except for one number that appears only once.
 * The method will return the number that appears only once.
 */
public class findSingle{
    public static int findSingle(int [] a){
        if (a.length == 1)
            return a[0];
            
        if (a[0] != a[1])
            return a[0];
            
        if (a[a.length - 1] != a[a.length - 2])
            return a[a.length - 1];
            
        int low = 0, high = a.length - 1;
        while (true){
            int mid = (low + high) / 2;
            if (mid % 2 == 0){
                if (a[mid] == a[mid + 1])
                    low = mid + 2;
                else if (a[mid] != a[mid - 1])
                    return a[mid];
                else 
                    high = mid - 2;
            }
            else {
                if (a[mid] == a[mid - 1])
                    low = mid + 1;
                else if (a[mid] != a[mid + 1])
                    return a[mid];
                else 
                    high = mid - 1;
            }
        }
    }
    
    //Simple basic test
    public static void main(){
        int [] myarray1 = new int []{6,6,18,18,-4,-4,12,9,9};
        System.out.println(findSingle.findSingle(myarray1));
        int [] myarray2 = new int []{8,8,-7,-7,3,3,0,0,10,10,5,5,4};
        System.out.println(findSingle.findSingle(myarray2));
    }
}

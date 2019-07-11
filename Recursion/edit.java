
/**
 * A recursive method that accepts two strings str1 and str2 as parameters
 * Returns the number of addition and subtraction operations
 * that must be performed to convert str1 to str2.
 */
public class edit{
    public static int edit(String str1, String str2){
        return edit(str1, str2, 0, 0);
    }
    public static int edit(String str1, String str2, int index1, int index2){
        if (str1.charAt(index1) == str2.charAt(index2)){
            return edit(str1, str2, index1+1, index2+1);
        }
        
        if (index2 == str2.length()) {
            return str1.length()- index1;
        }
        if (index1 == str1.length()) {
            return str2.length() - index2;
        }
        return ( 1 + Math.min( edit(str1, str2, index1 + 1, index2)
                                , edit(str1, str2, index1, index2 + 1)));
    }
    
    //Simple basic test
    public static void main(){
        String str1 = "sunday", str2 = "saturday";
        System.out.println(edit.edit(str1,str2));
        
        String str3 = "geek", str4 = "gesek";
        System.out.println(edit.edit(str3,str4));
    }
}

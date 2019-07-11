
/**
 * A recursive method that accepts as a Boolean 2D matrix as a parameter,
 * Returns how many different true zones exist in the matrix. 
 * If there are no true zones, 0 will be returned.
 */
public class cntTrueReg
{
    public static int cntTrueReg(boolean [][] mat){
        int length = mat.length;  //create new array for the tracking.
        boolean[][] marked = new boolean[length][mat[0].length];
        return cntTrueReg(mat, marked, 0); //0 - index of location
    }
    
    public static int cntTrueReg(boolean [][] mat,boolean [][] marked, int pos){
        int x = pos % mat[0].length; 
        int y = pos / mat[0].length;
        
        if ( pos >= mat[0].length * mat.length ) {
            return 0;
        }
        
        // if true in the square and also didn't visit it yet.
        if (mat[x][y] && !marked[x][y]) {  
            drawPath(mat, marked, x, y); //Start moving from this point
            return 1 + cntTrueReg(mat, marked, pos + 1);  // create new route from new square
        }
    
        return cntTrueReg(mat, marked, pos +1);
     }
     
    public static void drawPath (boolean mat[][], boolean marked [][], int x ,int y){
        if ( x == mat[0].length || y == mat.length || x == - 1 || y == - 1) {
            return;
        }
        if (!mat[x][y] || marked[x][y]) {
            return;
        }
        marked[x][y] = true;
        drawPath(mat, marked, x+1, y);
        drawPath(mat, marked, x-1, y);
        drawPath(mat, marked, x, y+1);
        drawPath(mat, marked, x, y-1);
    }
}

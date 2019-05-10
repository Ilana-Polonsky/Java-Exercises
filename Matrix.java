
/**
 * Class representing a matrix, a two dimensional array that contains numbers between 
 * 0 and 255. The numbers represents shades of grey, where 0 is white and 255 is black.
 *
 * @author Ilana Polonsky
 * @version 1.0
 */
public class Matrix
{
    private int[][] _array;
    private final int DEFAULT_VAL=0;
    private final int MAX_VAL=255;

    /**
     * Constructs a Matrix from a two-dimensional array, copying the dimensions and the
     * values inside the array.
     * 
     * @param array the array to copy from.
     */
    public Matrix(int[][] array) {
        _array = new int[array.length][array[0].length];
        for ( int i = 0 ; i < array.length ; i++ ){
            for ( int j = 0 ; j < array[i].length ; j++ ) {
                _array[i][j] = array[i][j];
            }
        }
    }

    /**
     * Constructs a matrix of size1 rows and size2 columns filled with default values.
     * 
     * @param size1 represents number of rows in the array.
     * @param size2 represents number of columns in the array.
     */
    public Matrix(int size1, int size2) {
        _array = new int[size1][size2];
        for ( int i = 0 ; i < size1 ; i++ ) {
            for ( int j = 0 ; j < size2 ; j++ ) {
                _array[i][j] = DEFAULT_VAL;
            }
        }
    }
    
    /**
     * Constructs and returns the string representation of the Matrix object.
     * 
     * @return the string representation.
     */
    public String toString(){
        String total = "";
        for ( int i = 0 ; i < _array.length ; i++ ) {
            for ( int j = 0 ; j < _array[i].length ; j++ ) {
                total += _array[i][j];
                // Add \t only if this is not the last element.
                if ( j < _array[i].length - 1 ) {
                    total += "\t";   
                }
            }
            // Add \n at the end of each row.
            total += "\n";
        }
        
        return total;
    }
    
    /**
     * Creates and returns a new matrix that representes the negative image of our matrix.
     * 
     * @return negative matrix.
     */
    public Matrix makeNegative() {
        int[][] arrayNew = new int[_array.length][_array[0].length];
        for ( int i = 0 ; i < arrayNew.length ; i++ ) {
            for ( int j = 0 ; j < arrayNew[i].length ; j++ ) {
                arrayNew[i][j] = MAX_VAL - _array[i][j];
            }
        }
        
        return new Matrix(arrayNew);
    }
    
    /**
     * Creates and returns a new matrix that has all of it's values smoothed to be the
     * average value of all of it's neighbors, including itself.
     * 
     * @return new smoothed matrix.
     */
    public Matrix imageFilterAverage() {
        int[][] arrayNew = new int[_array.length][_array[0].length];
        // Goes over each index to find the new smoothed value.
        for ( int i = 0 ; i < arrayNew.length ; i++ ) {
            for ( int j = 0 ; j < arrayNew[i].length ; j++ ) {
                // For a specific index go over all of it's neighbors and add the values
                // of the valid ones, while counting the valids.
                int neighbors = 0;
                arrayNew[i][j] = 0;
                for (int r = -1; r <= 1; r++) {
                    for (int c = -1; c <= 1; c++) {
                        // Check if the neighbor's index is in the array.
                        if ( i + r >= 0 && i + r < _array.length && 
                             j + c >= 0 && j + c < _array[i].length ) {
                            arrayNew[i][j] += _array[i + r][j + c];
                            neighbors++;
                        }
                    }
                }
                
                // Divide by the amount of valid neighbors to get the average.
                arrayNew[i][j] /= neighbors;
            }
        }
        
        return new Matrix(arrayNew);
    }
    
    /**
     * Creates and calculates a matrix that represents the clockwise rotation of our matrix.
     * 
     * @return a new matrix representing a clockwise rotation of our matrix.
     */
    public Matrix rotateClockwise(){
        int[][] arrayNew = new int[_array[0].length][_array.length];
        for ( int i = 0 ; i < arrayNew.length ; i++ ) {
            for ( int j = 0 ; j < arrayNew[i].length ; j++ ) {
                arrayNew[i][j] = _array[arrayNew[i].length - 1 - j][i];
            }
        }
        
        return new Matrix(arrayNew);
    }
    
    /**
     * Creates and calculates a matrix that represents the counter-clockwise 
     * rotation of our matrix.
     * 
     * @return a new matrix representing a counter-clockwise rotation of our matrix.
     */
    public Matrix rotateCounterClockwise(){
        int[][] arrayNew = new int[_array[0].length][_array.length];
        for ( int i = 0 ; i < arrayNew.length ; i++ ) {
            for ( int j = 0 ; j < arrayNew[i].length ; j++ ) {
                arrayNew[i][j] = _array[j][arrayNew.length - 1 - i];
            }
        }
        
        return new Matrix(arrayNew);
    }
}

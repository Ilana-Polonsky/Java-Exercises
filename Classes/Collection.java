
/**
 * This class represents an array of boxes, sorted by their volume.
 * Each box represented by it's base point, length, width and height.
 * The maximum amount of boxes in the array is 100 and the current 
 * amount is saved as _noOfBoxes.
 *
 * @author Ilana Polonsky
 * @version 1.0
 */
public class Collection
{
    private Box3D[] _boxes;
    private int _noOfBoxes;
    private final int MAX_NUM_BOXES = 100;
    private final int START_NUM_OF_BOXES = 0;

    /**
     * Constructs a collection with an empty box array of the maximum allowed size.
     */
    public Collection(){
        _boxes = new Box3D[MAX_NUM_BOXES];
        _noOfBoxes = START_NUM_OF_BOXES;
    }

    /**
     * Constructs a box from a point and measures, and adds it to the box array.
     * Checks if there is room left in the array for a new box, otherwise return false,
     * Adds the new box in the right place to keep the array sorted by volume.
     *
     * @param base the base point of the box.
     * @param length the length of the box.
     * @param width the width of the box.
     * @param height the height of the box.
     * 
     * @return true if succeeded in adding the box.
     * @return flase if the array is full.
     */
    public boolean addBox(Point3D base, int length, int width, int height){
        if ( _noOfBoxes >= MAX_NUM_BOXES ) {
            return false;
        }
        
        Box3D newBox = new Box3D(base, length, width, height);
        int newBoxVolume = newBox.getVolume();
        // Find the first place we can insert the box.
        for ( int i = 0 ; i < _noOfBoxes ; i++ ) {
             if ( newBoxVolume <= _boxes[i].getVolume() ) {
                // Found a place. Move all following boxes one place ahead.
                for ( int j = _noOfBoxes ; j >= i + 1 ; j-- ){   
                    _boxes[j] = _boxes[j - 1];  
                }
                // Add the box.
                _boxes[i] = newBox; 
                _noOfBoxes++;
                return true;
             }
        }
        
        // If got here, didn't find a place in between boxes, add to the end.
        _boxes[_noOfBoxes] = newBox;
        _noOfBoxes++;
        return true;
    }
    
    /**
     * Calculates and returns a copy of box with the most upper base corner of 
     * all boxes in the array.
     * 
     * @return null if the array empty.
     * @return the box that have the most upper base corner.
     */
    public Box3D mostUpperBaseCorner() {
        if ( _noOfBoxes == 0 ){
            return null;
        }
        
        int maxIndex = 0;
        for ( int i=1 ; i < _noOfBoxes ; i++ ) {
            if ( _boxes[i].getBase().isAbove(_boxes[maxIndex].getBase()) ){
                maxIndex = i;
            }
        }
        
        return new Box3D(_boxes[maxIndex]);
    }
    
    /**
     * Calculates and returns the total surface area of all boxes in array.
     * 
     * @return total surface area of all boxes in the array.
     */
    public double totalSurfaceArea() {
        double sumSurface = 0; 
        for ( int i = 0 ; i<_noOfBoxes ; i++ ) {
            sumSurface += _boxes[i].getSurfaceArea();
        }
        
        return sumSurface;
    }
    
    /**
     * Calculates and returns the longest distance between two boxes in the collection.
     * 
     * @return 0 if the number of boxes in the array smaller than 2.
     * @return the longest distance.
     */
    public double longestDistance(){
        if ( _noOfBoxes < 2 ){
            return 0;
        }
        
        // Go over every boxes pair and find the maximum distance between two.
        double maxDistance = 0;
        for ( int i = 0 ; i < _noOfBoxes ; i++ ) {
            for ( int j = i + 1 ; j < _noOfBoxes ; j++ ) {
                double currentDistance = _boxes[i].distance(_boxes[j]);
                if ( currentDistance > maxDistance ){
                    maxDistance = currentDistance;
                }
            }
        }
        
        return maxDistance;
    }
    
    /**
     * Counts and returns the amount of boxes in the collection that contain a given box.
     * 
     * @param box the box to that is counted how many times it is contained.
     * 
     * @return the number of boxes in the collection that contain the box.
     */
    public int howManyContains(Box3D box){
        int containsNumber = 0;    
        for ( int i = 0 ; i < _noOfBoxes ; i++ ){
            if ( _boxes[i].contains(box) ){
                containsNumber++;
            }
        }
        
        return containsNumber;
    }
    
    /**
     * Find the volume of the smallest box that can contain all of the boxes in 
     * the collection that are in the range of i and j (inclusive).
     * Checks if the indexes represent a valid range in the collection and 
     * returns 0 otherwise.
     * 
     * @param i first index.
     * @param j second index.
     * 
     * @return 0 if the indexes don't represent a valid range.
     * @return the volume of the smallest box that can contain all of the boxes in 
     * the range.
     */
    public int volumeOfSmallestBox(int i, int j) {
        // We define the smaller of the indexes and the larger one and check if they 
        // are valid.
        int minIdx = Math.min(i, j);
        int maxIdx = Math.max(i, j);
        if ( minIdx < 0 || maxIdx >= _noOfBoxes ) {
            return 0;
        }
        
        // The smallest box that can contain all of the boxes of the range will have the
        // maximum length, width and height of all of the boxes in that range. That way it
        // can contain each of the boxes on their own, and there is no box smaller.
        int maxLength = 0;
        int maxWidth = 0;
        int maxHeight = 0;
        for ( int idx = minIdx ; idx <= maxIdx ; idx++ ) {
            if ( _boxes[idx].getLength() > maxLength ){
                maxLength = _boxes[idx].getLength();
            }
            if ( _boxes[idx].getWidth() > maxWidth ){
                maxWidth = _boxes[idx].getWidth();
            }
            if ( _boxes[idx].getHeight() > maxHeight ){
                maxHeight = _boxes[idx].getHeight();
            }  
        }
        
        return (maxLength + 1) * (maxWidth + 1) * (maxHeight + 1);
    }
    
    /**
     * Create and return a new array that is the size of the actual amount of boxes in 
     * the collection with a copy of all of the boxes.
     * 
     * @return the new array of boxes.
     */
    public Box3D[] getBoxes() {
        Box3D[] boxesNew = new Box3D[_noOfBoxes];
        for ( int i = 0 ; i < _noOfBoxes ; i++ ) {
            boxesNew[i] = new Box3D(_boxes[i]);
        }
        
        return boxesNew;
    }
    
    /**
     * Return number of boxes in the array.
     * 
     * @return number of boxes in the array.
     */
    public int getNumOfBoxes(){
        return _noOfBoxes;
    }
    
    /**
     * Returns a string representation of the collection object.
     * 
     * @return string with the boxes array information.
     */
    public String toString(){
        String total = "";
        for ( int i = 0; i < _noOfBoxes ; i++ ) {
            total += "Box no. " + (i + 1) + ": " + _boxes[i].toString() + "\n";
        }
        
        return total;
    }
}

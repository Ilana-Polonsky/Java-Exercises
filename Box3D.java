
/**
 * This class represents a three-dimensional box 
 * The box is represented by its lower-left-front point 
 * and three integers for the length (x axis), 
 * width (y axis) and height (z axis) of the box. 
 * the box dimensions must be equal or greater than 1.
 * 
 * @author Ilana Polonsky
 * @version 1.0
 */
public class Box3D
{
    private Point3D _base;
    private int _length;
    private int _width;
    private int _height;
    private final int DEFAULT_VAL=0;

    /**
     * Constructs and initializes a box with a default base 
     * point and all dimensions to 1.
     */
    public Box3D() {
        _base = new Point3D();
        _length = 1;
        _width = 1;
        _height = 1;
    }

    /**
     * Constructs and initializes a Box3D object from a given Box3D.
     * @param other the box to copy from. Contains the initialization of 
     * the base point and all dimentions.
     */
    public Box3D(Box3D other) {
        _base = new Point3D(other._base);
        _length = other._length;
        _width = other._width;
        _height = other._height;
    } 

    /**
     * Constructs and initializes a box object from a given 
     * base point and 3 integers as the dimentions of the Box
     * @param p the base point of the box
     * @param length the length of the box
     * @param width the width of the box
     * @param height the height of the box
     */
    public Box3D(Point3D p,
    int length,
    int width,
    int height) {
        _base = new Point3D(p);
        if (length > DEFAULT_VAL)
            _length = length;   
        else
            _length = 1;
        if (width > DEFAULT_VAL)
            _width = width;
        else
            _width = 1;
        if (height > DEFAULT_VAL)
            _height = height;
        else
            _height = 1;    
    } 

    /**
     * Determines whether this box can contain the other box.
     * @param other a Box3D object to check if it can be contained within this box    
     */
    public boolean contains(Box3D other) {
        return (_length > other._length && _width > other._width
        && _height > other._height);
    }

    /**
     * Computes the distance between two boxes based on the 
     * distance of their center points.
     * @return the distance between two Box3D objects
     */
    public double distance(Box3D other) {
        Point3D baseCenter = this.getCenter();
        Point3D otherCenter = other.getCenter();
        return baseCenter.distance(otherCenter);
    }

    /**
     * Determines whether or not the two boxes are equal.
     * @param other a Box3D object to be compared with this Box3D
     */
    public boolean equals(Box3D other) {
        return (_base.equals(other._base) 
        && other._length == _length 
        && other._width == _width
        && other._height == _height);
    } 

    /**
     * returns the height dimension
     * @return the height of the box
     */
    public int getHeight() {
        return _height;
    }

    /**
     * returns the width dimension
     * @return the width of the box
     */
    public int getWidth() {
        return _width;
    }
        
    /**
     * returns the length dimension
     * @return the length of the box
     */
    public int getLength() {
        return _length;
    }

    /**
     * returns the lower-left-front (base) Point3D of the box
     * @return the base point of the box
     */
    public Point3D getBase() {
        return new Point3D(_base);
    }  
    
    /**
     * Computes the surface area of a box.
     * @return the surface area of a Box3D object
     */
    public int getSurfaceArea() {
        int upperFace = 2 * _length * _width;
        int sideFace = 2 * _height * _length;
        int forwardFace  = 2 * _width * _height;
        return upperFace + sideFace + forwardFace;
    } 

    /**
     * Calculates and returns the upper-right-back point of this box
     * @return the upper-right-back point of this box
     */
    public Point3D getUpRightBackPoint() {
        Point3D p1 = new Point3D(_base);
        p1.move(-_length, _width, _height);
        return p1;
    } 

    /**
     * Calculates and returns the center point of the box
     * @return the center point of the box
     */
    public Point3D getCenter() {
        Point3D p1 = new Point3D(_base);
        p1.move((-_length)/2.0, (_width)/2.0, (_height)/2.0);
        return p1;
    } 
    
    /**
     * Computes the volume of the box.
     * @return volume of the Box3D object
     */
    public int getVolume() {
        return (_length * _width * _height);
    } 

    /**
     * Checks if this box is above the other box
     * @param other The box to check if this box is above it
     * @return true if this box is above the other box, false otherwise
     */
    public boolean isAbove(Box3D other) {
        Point3D p1 = other.getUpRightBackPoint();
        return this._base.isAbove(p1);
        }

    /**
     * Determines whether this box has a greater volume in compare to other box.
     * @param other a Box3D object whose volume will be compared with the volume of this Box3D
     */
    public boolean isLargerCapacity(Box3D other) {
        return this.getVolume() > other.getVolume();
    } 

    /**
     * Moves the box in the (x,y,z) coordinate system to (x+dx,y+dy,z+dz) 
     * without changing the box dimensions
     * @return the new box in its new location
     */
    public Box3D move(double dx,
    double dy,
    double dz) {
        Point3D p1 = new Point3D(_base);
        p1.move(dx, dy, dz);
        return new Box3D(p1, _length, _width, _height);
    }  
    
    /**
     * Sets the base point of the box
     * @param otherBase the Point3D to set
     */
    public void setBase(Point3D otherBase) {
        _base = new Point3D(otherBase);
    } 
    
    /**
     * Sets the height of the box only if the given 
     * value is equal or greater than 1.
     * @param num the height to set
     */
    public void setHeight(int num) {
        if (num > DEFAULT_VAL) 
            _height = num;
    }
    
    /**
     * Sets the length of the box only if the given 
     * value is equal or greater than 1.
     * @param num the length to set
     */
    public void setLength(int num) {
        if (num > DEFAULT_VAL) 
            _length = num;
    }
    
    /**
     * Sets the width of the box only if the given 
     * value is equal or greater than 1.
     * @param num the width to set
     */
    public void setWidth(int num){
        if (num > DEFAULT_VAL) 
            _width = num;
    }
    
    /**
     * Returns a string representation of this Box3D object.
     */
    public String toString()
    {
        return "The base point is "+ _base.toString()+", length = "+_length+
        ", width = "+_width+", height = "+_height;
    }
}

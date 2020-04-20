import java.util.ArrayList;
import java.util.Random;

/**
 * Instead of a Sample.java class, we decided to make a Point.java class because it made more sense to us
 * Professor Hickey encouraged us to deviate from the steps he outlined to write code that was most sensible to us
 * 
 * The main difference between Sample.java and Point.java is that while Sample.java includes a list of doubles,
 * Point.java creates points as like on a 2-D graph, which better matches our understanding of this k-means assignment,
 * since it involves points on a 2-D graph.
 * 
 * @author Team 5: Peppa Pig
 *
 */
public class Point {
	// a point object consists of an x-value and a y-value, as well as a cluster_number
	private double x = 0;
	private double y = 0;
	private int cluster_number = 0;
	
	/**
	 * Creates a point object with parameters:
	 * @param x
	 * @param y
	 */
	public Point(double x, double y) {
		this.setX(x);
		this.setY(y);
	}
	
	/**
	 * Creates a default point object with parameters (0,0)
	 */
	public Point() {
		this.setX(0);
		this.setY(0);
	}
	
	// setter method for this.x
	public void setX(double x) {
        this.x = x;
    }
	
	// getter method for this.x
    public double getX()  {
        return this.x;
    }
    
    // setter method for this.y
    public void setY(double y) {
        this.y = y;
    }
    
    // getter method for this.y
    public double getY() {
        return this.y;
    }
    
    // setter method for cluster_number
    public void setCluster(int n) {
        this.cluster_number = n;
    }
    
    // getter method for cluster_number
    public int getCluster() {
        return this.cluster_number;
    }
    
    public String toString() {
    	return "("+x+","+y+")";
    }
    
    // calculates the distance between two points
    // (formula was found online at https://ncalculators.com/geometry/length-between-two-points-calculator.htm)
    protected static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p2.getY()-p1.getY()), 2) + Math.pow((p2.getX()-p1.getX()), 2));
    }
    
    // creates a random point
    // instead of putting this method in the Cluster.java class, we found that putting it in the Point.java class makes it easier
    protected static Point createRandomPoint(int min, int max) {
    	Random r = new Random();
    	double x = min+(max-min)*r.nextDouble();
    	double y = min+(max-min)*r.nextDouble();
    	return new Point(x,y);
    }
    
    // creates an ArrayList of random points
    protected static ArrayList<Point> createRandomPoints(int min, int max, int number) {
    	ArrayList<Point> points = new ArrayList<Point>(number);
    	for(int i = 0; i < number; i++) {
    		points.add(createRandomPoint(min,max));
    	}
    	return points;
    }
}

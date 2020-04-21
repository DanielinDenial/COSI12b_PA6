import java.util.ArrayList;

/**
 * This class initiates a cluster which consists of points and a cluster point
 * In this class, we also id'd each cluster
 * 
 * @author Team 5: Peppa Pig
 *
 */
public class Cluster {
	public ArrayList<Point> points;
	public Point clusterpoint;
	public int id;
	
	/**
	 * Creates a cluster object with an id
	 * @param id
	 */
	public Cluster(int id) {
		this.id = id;
		this.points = new ArrayList<Point>();
		this.clusterpoint = null;
	}
	
	// getter method for this.points
	public ArrayList<Point> getPoints() {
		return this.points;
	}
	
	// add method for this.points
	public void addPoint(Point point) {
		this.points.add(point);
	}
	
	// setter method for this.points
	public void setPoints(ArrayList<Point> points) {
		this.points = points;
	}
 
	// getter method for this.clusterpoint
	public Point getclusterpoint() {
		return this.clusterpoint;
	}
 
	// setter method for this.clusterpoint
	public void setclusterpoint(Point clusterpoint) {
		this.clusterpoint = clusterpoint;
	}
 
	// getter method for this.id
	public int getId() {
		return this.id;
	}
	
	// clear method for this.points
	public void clear() {
		this.points.clear();
	}
	
	// plots the cluster with its points and cluster point
	public void plotCluster() {
		System.out.println("[Cluster: " + this.id+"]");
		System.out.println("[Cluster Point: " + this.clusterpoint + "]");
		System.out.println("[Points: \n");
		for(Point p : this.points) {
			System.out.println(p);
		}
		System.out.println("]");
	}
}
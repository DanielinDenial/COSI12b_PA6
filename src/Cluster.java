import java.util.ArrayList;
import java.util.List;

//The Cluster Class initiates a cluster with points and cluster points
public class Cluster {
	
	public ArrayList<Point> points;
	public Point centroid;
	public int id;
	
	//creates new cluster, uses this. to refer to instance variables
	public Cluster(int id) {
		this.id = id;
		this.points = new ArrayList();
		this.centroid = null;
	}
	
	//creates a getter for points
	public ArrayList<Point> getPoints() {
		return points;
	}
	//method that adds point to ArrayList points
	public void addPoint(Point point) {
		points.add(point);
	}
	//creates setter for points
	public void setPoints(ArrayList<Point> points) {
		this.points = points;
	}
	//creates getter for Centroid
	public Point getCentroid() {
		return centroid;
	}
	//creates setter for centroid
	public void setCentroid(Point centroid) {
		this.centroid = centroid;
	}
	//creates getter for id
	public int getId() {
		return id;
	}
	
	public void clear() {
		points.clear();
	}
	//creates system of print lines in order to plot the cluster
	public void plotCluster() {
		System.out.println("[Cluster: " +id+"]");
		System.out.println("[Centroid: "+centroid+"]");
		System.out.println("[Points \n");
		for(Point p : points) {
			System.out.println(p);
		}
		System.out.println("]");
	}

}

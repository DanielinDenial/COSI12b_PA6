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
	
	
}

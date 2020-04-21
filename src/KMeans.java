import java.util.ArrayList;

public class KMeans {
	// number of Clusters
    private int NUM_CLUSTERS = 3;    
    // number of Points
    private int NUM_POINTS = 15;
    // min and max X and Y
    private static final int MIN_COORDINATE = 0;
    private static final int MAX_COORDINATE = 10;
    
    private ArrayList<Point> points;
    private ArrayList<Cluster> clusters;
    
    /**
     * Creates KMeans object with points and clusters
     */
    public KMeans() {
    	this.points = new ArrayList<Point>();
    	this.clusters = new ArrayList<Cluster>();
    }

}

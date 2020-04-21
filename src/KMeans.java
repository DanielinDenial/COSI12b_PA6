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
    
	// initializes the process
    public void init() {
    	// create Points randomly
    	points = Point.createRandomPoints(MIN_COORDINATE,MAX_COORDINATE,NUM_POINTS);
    	
    	// create Clusters with random cluster points
    	for (int i = 0; i < NUM_CLUSTERS; i++) {
    		Cluster cluster = new Cluster(i);
    		Point clusterpoint = Point.createRandomPoint(MIN_COORDINATE,MAX_COORDINATE);
    		cluster.setClusterPoint(clusterpoint);
    		clusters.add(cluster);
    	}
    	
    	// print Initial state
    	plotClusters();
    }
    
    // plots clusters
    private void plotClusters() {
    	for (int i = 0; i < NUM_CLUSTERS; i++) {
    		Cluster c = clusters.get(i);
    		c.plotCluster();
    	}
    }
    
    //clears cluster
    private void clearClusters() {
    	for(Cluster cluster : clusters) {
    		cluster.clear();
    	}
    }
    
    //getter method for clusterPoint ArrayList
    private ArrayList<Point> getClusterPoint() {
    	ArrayList<Point> clusterpoint = new ArrayList<Point>(NUM_CLUSTERS);
    	for(Cluster cluster : clusters) {
    		Point aux = cluster.getClusterPoint();
    		Point point = new Point(aux.getX(),aux.getY());
    		clusterpoint.add(point);
    	}
    	return clusterpoint;
    }
    
    //setter method for cluster
    private void assignCluster() {
        double max = Double.MAX_VALUE;
        double min = max; 
        int cluster = 0;                 
        double distance = 0.0; 
        
        for(Point point : points) {
        	min = max;
            for(int i = 0; i < NUM_CLUSTERS; i++) {
            	Cluster c = clusters.get(i);
                distance = Point.distance(point, c.getClusterPoint());
                if(distance < min){
                    min = distance;
                    cluster = i;
                }
            }
            point.setCluster(cluster);
            clusters.get(cluster).addPoint(point);
        }
    }
    
    // calculates closer clusterPoint
    private void calculateclusterpoint() {
    	for(Cluster cluster : clusters) {
    		double sumX = 0;
    		double sumY = 0;
    		ArrayList<Point> list = cluster.getPoints();
    		int n_points = list.size();

    		for(Point point : list) {
    			sumX += point.getX();
    			sumY += point.getY();
    		}

    		Point clusterpoint = cluster.getClusterPoint();
    		if(n_points > 0) {
    			double newX = sumX / n_points;
    			double newY = sumY / n_points;
    			clusterpoint.setX(newX);
    			clusterpoint.setY(newY);
    		}
    	}
    }
    
 // calculates K Means with iterating method
    public void calculate() {
        boolean finish = false;
        int iteration = 0;
        
        // add in new data, one at a time, recalculating cluster point with each new one
        while(!finish) {
        	// clear cluster state
        	clearClusters();
        	
        	ArrayList<Point> lastclusterpoint = getClusterPoint();
        	
        	// assign points to the closer cluster
        	assignCluster();
            
            // calculate new clusterpoint
        	calculateclusterpoint();
        	
        	iteration++;
        	
        	ArrayList<Point> currentclusterpoint = getClusterPoint();
        	
        	// calculates total distance between new and old clusterpoint
        	double distance = 0;
        	for(int i = 0; i < lastclusterpoint.size(); i++) {
        		distance += Point.distance(lastclusterpoint.get(i),currentclusterpoint.get(i));
        	}
        	System.out.println("#################");
        	System.out.println("Iteration: " + iteration);
        	System.out.println("Cluster point distances: " + distance);
        	plotClusters();
        	        	
        	if(distance == 0) {
        		finish = true;
        	}
        }
    }

}

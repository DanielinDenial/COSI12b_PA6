import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Collections;

/**
 * This class initiates the calculation of k-means
 * 
 * @author Team 5: Peppa Pig
 *
 */
public class KMeans {
	// number of Clusters
    private int numClusters;
    
    // min and max X and Y
    private static double minCoordinate;
    private static double maxCoordinate;
    
    
    private ArrayList<Point> points;
    private ArrayList<Cluster> clusters;
    
    /**
     * Creates KMeans object with points and clusters
     */
    public KMeans(int numClusters) {
    	this.points = new ArrayList<Point>();
    	this.clusters = new ArrayList<Cluster>();
    	this.numClusters = numClusters;
    }
    
    /**
     * main method that runs program
     * args: number of clusters
     * @param number of clusters
     * @throws FileNotFoundException 
     */
	public static void main(String[] args) throws FileNotFoundException {
		KMeans kmeans = new KMeans(Integer.parseInt(args[0]));
		File file = new File("C:\\Users\\Daniel Hariyanto\\eclipse-workspace\\COSI12b_PA6\\src\\test.txt");
		Scanner in = new Scanner(file);
    	ArrayList<Double> pointsList = new ArrayList<Double>();
    	while(in.hasNextDouble()) {
    		pointsList.add(in.nextDouble());
    	}
    	
    	// finds minimum and maximum x/y coordinate
    	
    	minCoordinate = getMin(pointsList);
    	maxCoordinate = getMax(pointsList);
    	System.out.println(minCoordinate);
    	System.out.println(maxCoordinate);

    	kmeans.init(pointsList);
    	kmeans.calculate();
	}
	
	// calculate minimum value in ArrayList
	public static Double getMin(ArrayList<Double> arr){ 
	    Double minValue = arr.get(0); 
	    for(int i = 1; i < arr.size();i++){ 
	    	if(arr.get(i) < minValue){ 
	    		minValue = arr.get(i);
	    	}
	    }
	    return minValue; 
	}
	
	// calculate maximum value in ArrayList
	public static Double getMax(ArrayList<Double> arr){ 
	    Double maxValue = arr.get(0); 
	    for(int i = 1; i < arr.size();i++){ 
	    	if(arr.get(i) > maxValue){ 
	    		maxValue = arr.get(i);
	      	}
	    }
	    return maxValue; 
	}
    
	// initializes the process
    public void init(ArrayList<Double> pointsList) {
    	// create Points
    	points = Point.createPoints(pointsList);
    	
    	// create Clusters with random cluster points
    	for (int i = 0; i < numClusters; i++) {
    		Cluster cluster = new Cluster(i);
    		Point clusterpoint = Point.createRandomPoint(minCoordinate,maxCoordinate);
    		cluster.setclusterpoint(clusterpoint);
    		clusters.add(cluster);
    	}
    	
    	// print Initial state
    	plotClusters();
    }
    
    // plots clusters
    private void plotClusters() {
    	for (int i = 0; i < numClusters; i++) {
    		Cluster c = clusters.get(i);
    		c.plotCluster();
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
        	
        	ArrayList<Point> lastclusterpoint = getclusterpoint();
        	
        	// assign points to the closer cluster
        	assignCluster();
            
            // calculate new clusterpoint
        	calculateclusterpoint();
        	
        	iteration++;
        	
        	ArrayList<Point> currentclusterpoint = getclusterpoint();
        	
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
    
    // clears cluster
    private void clearClusters() {
    	for(Cluster cluster : clusters) {
    		cluster.clear();
    	}
    }
    
    // getter method for clusterpoint Arraylist
    private ArrayList<Point> getclusterpoint() {
    	ArrayList<Point> clusterpoint = new ArrayList<Point>(numClusters);
    	for(Cluster cluster : clusters) {
    		Point aux = cluster.getclusterpoint();
    		Point point = new Point(aux.getX(),aux.getY());
    		clusterpoint.add(point);
    	}
    	return clusterpoint;
    }
    
    // setter method for cluster
    private void assignCluster() {
        double max = Double.MAX_VALUE;
        double min = max; 
        int cluster = 0;
        double distance = 0.0; 
        
        for(Point point : points) {
        	min = max;
            for(int i = 0; i < numClusters; i++) {
            	Cluster c = clusters.get(i);
                distance = Point.distance(point, c.getclusterpoint());
                if(distance < min){
                    min = distance;
                    cluster = i;
                }
            }
            point.setCluster(cluster);
            clusters.get(cluster).addPoint(point);
        }
    }
    
    // calculates closer clusterpoint
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
            
            Point clusterpoint = cluster.getclusterpoint();
            if(n_points > 0) {
            	double newX = sumX / n_points;
            	double newY = sumY / n_points;
                clusterpoint.setX(newX);
                clusterpoint.setY(newY);
            }
        }
    }
}

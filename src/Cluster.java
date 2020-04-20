import java.util.ArrayList;
import java.util.Random;

/**
 * A cluster is a cluster point (which is itself a sample)
 * and a list of Samples (the one's closest to that sample point, ideally).
 * @author presenting
 *
 */
public class Cluster {
	ArrayList<Sample> cluster;
	Sample clusterpoint;
	
	public Cluster(Sample[] sample) {
		this.cluster = new ArrayList<Sample>();
		for (int i=0; i<sample.length; i++) {
			cluster.add(sample[i]);
		}
	}
	
	public static int getRandom(int[] array) {
	    int random = new Random().nextInt(array.length);
	    return array[random];
	}
	
	/*public static void main(String[] args) {
		double[] p1 = {1d, 2d, 3.14, 2.71};
		double[] p2 = {0.1, 1.1, 2.1, 3.1};
		double[] p3 = {4d, 3.4, 5.6, 9.1};
		Sample s1 = new Sample(p1);
		Sample s2 = new Sample(p2);
		Sample s3 = new Sample(p3);
		Sample[] sample = new Sample[] {s1,s2,s3};
		Cluster cluster = new Cluster(sample);
		System.out.println(cluster);
	}*/
}

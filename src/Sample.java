import java.util.ArrayList;

/**
 * A Sample represents a vector of doubles to be used in a clustering algorithm...
 * @author presenting
 *
 */

public class Sample {
	ArrayList<Double> sample;
	
	public Sample(double[] values) {
		this.sample = new ArrayList<Double>();
		for (int i=0; i<values.length; i++) {
			sample.add(values[i]);
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("testing for the Sample class.");
		double[] p1 = {1d, 2d, 3.14, 2.71};
		double[] p2 = {0.1, 1.1, 2.1, 3.1};
		Sample s1 = new Sample(p1);
		Sample s2 = new Sample(p2);
		System.out.println("s1="+s1);
		System.out.println("s2="+s2);
	}

	public Double calculateDistance(ArrayList<Double> s1, ArrayList<Double> s2) {
		double sum = 0;
		for (int i = 0; i < s1.size(); i++) {
			Double v1 = s1.get(i);
			Double v2 = s2.get(i);
			
			if (v1!=null && v2!=null) {
				sum += Math.pow(v1-v2, 2);
			}
		}
		
		return Math.sqrt(sum);
	}
	
	public String toString() {
		return ""+this.sample;
	}
}

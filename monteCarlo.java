import java.util.Random;

public class piApprox {

	public static void main(String[] args) {
		
		int times = 0;
		int appeared = 0;
		
		while(times <1000000) {
			Random xValue = new Random();
			Random yValue = new Random();
		
			double x = xValue.nextDouble();
			double y = yValue.nextDouble();
			
			double value = (x*x)+ (y*y);

			if (value < 1.0) {
				appeared++;
			}
			
			times++;
		}
		
		double pi = (double)appeared/times;
		
		System.out.println(4*pi);
	}
}

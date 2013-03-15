package problem2;

public class EvenFibonacciSum {
	
	/**
	 * Returns the sum of all the even fibonacci numbers
	 * less than the value input in main.
	 * E.g. Fibonacci nos < 100:
	 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89.
	 * Returns 44 (2 + 8 + 34)
	 * @author james
	 *
	 */
	public static int get(int maxVal){
		int a = 1, b = 2, c = a+b, total = 2;
		while(c <= maxVal){
			if(c%2 == 0){
				total+=c;
			}
			a = b; b = c; c = a+b;
		}
		return total;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(EvenFibonacciSum.get(4000000));
	}

}

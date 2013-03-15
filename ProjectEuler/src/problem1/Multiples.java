package problem1;

import java.util.LinkedList;
import java.util.List;

public class Multiples {

	/**
	 * Returns the sum of all multiples of a and b
	 * which are less than the value of max.
	 * E.g. a=3, b=5, max=10.  
	 * Multiples of 3 = 3, 6, 9
	 * Multiples of 5 = 5
	 * Returns 23 (3 + 6 + 9 + 5).
	 * @author james
	 *
	 */
	public static int getSumOfMultiples(final int a, final int b, final int max){
		List<Integer> list = new LinkedList<Integer>();
		int product = a;
		for(int i = 2; product < max; i++){
			list.add(product);
			product = a*i;
		}
		product = b;
		for(int i = 2; product < max; i++){
			list.add(product);
			product = b*i;
		}
		int result = 0;
		for(int j : list){
			result += j;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(Multiples.getSumOfMultiples(3, 5, 10));
	}

}

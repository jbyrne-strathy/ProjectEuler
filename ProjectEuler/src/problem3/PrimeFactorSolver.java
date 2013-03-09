package problem3;

import java.util.Collection;
import java.util.LinkedList;

public class PrimeFactorSolver {

	static Collection<Long> factors = new LinkedList<Long>();

	boolean reset;
	void getPrimeFactors(long input) {
		if (isPrime(input)) {
			factors.add(input);
			return;
		}
		long y = input;
		while(true){
			reset = false;
			if ((y = reduce(y, 2)) == 1) return;
			else if(reset) continue;
			if ((y = reduce(y, 3)) == 1) return;
			else if(reset) continue;
			long l = 1;
			while (l <= Math.sqrt(y) && !reset) {
				if ((y = reduce(y, (6 * l) - 1)) == 1) return;
				else if(reset) break;
				if ((y = reduce(y, (6 * l) + 1)) == 1) return;
				else if(reset) break;
				l++;
			}
		}
	}

	long reduce(long number, long factor) {
		if (number % factor == 0) {
			factors.add(factor);
			if (isPrime(number /= factor)) {
				factors.add(number);
				return 1;
			}
			reset = true;
		}
		return number;
	}

	boolean isPrime(long number) {
		if (number == 1)
			return false;
		if (number % 2 == 0)
			return false;
		if (number % 3 == 0)
			return false;
		long i = 1;
		long low = (6 * i) - 1;
		long high = (6 * i) + 1;
		while (low <= Math.sqrt(number)) {
			if (number % low == 0)
				return false;
			if (number % high == 0)
				return false;
			i++;
			low = (6 * i) - 1;
			high = (6 * i) + 1;
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrimeFactorSolver p = new PrimeFactorSolver();
		p.getPrimeFactors(600851475143l);
		System.out.println(factors);
	}

}

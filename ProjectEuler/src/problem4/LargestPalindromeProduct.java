package problem4;

/**
 * Works out the largest palindrome product of 2 3-digit numbers.
 */
public class LargestPalindromeProduct {
	
	// Result < (998001 = 999 x 999)
	// .'. 997799 is starting point.
	int palindrome = 998899; //test method subtracts 1100 at start.
	int minimum = 10001; // 100 x 100 = 10000 so 10001 is lowest palindrome.

	/**
	 * Loops through possible divisors of the palindrome until it 
	 * either finds 2 3-digit divisors or can't find one. 
	 * @return Whether or not it finds 2 suitable divisors.
	 */
	private boolean test(){
		palindrome -= 1100;
		System.out.println(palindrome); //Print palindrome being tested.
							// Divisor1 is square root of palindrome 
		int divisor1 = (int) Math.floor(Math.sqrt(palindrome));
		do {
			float divisor2 = (float) palindrome / divisor1;
			if (divisor2 > 999)
				return false; //Divisor 2 will only increase from here.
			if (divisor2 % 1 == 0.0f){
				System.out.println(palindrome + " = " + divisor1 + " x "
						+ (int) divisor2);
				return true; //Result found.
			}
		} while (divisor1-- >= 100);
		return false; //Result not found.
	}

	/**
	 * Repeatedly loops through the test method until either a solution is
	 * found or one can't be found.
	 */
	public void find() {
		for (int i = 0; i <= 7; i++) { //Only 7 loops to 990099.
			if(test()) return;
		}
		while (palindrome > minimum) {
			palindrome += 990;			//To ensure next loop is a palindrome.
			for (int i = 0; i <= 9; i++) { //9 loops for every lower palindrome.
				if(test()) return;
			}
		}
		System.out.println("Can't find a solution... :(");
	}

	public static void main(String[] args) {
		LargestPalindromeProduct p = new LargestPalindromeProduct();
		p.find();
	}

}

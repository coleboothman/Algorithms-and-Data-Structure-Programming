import java.io.*;


//This program will count the number of lowercase a's in input.
// You can run by passing input into the command line or pipe.
// ie. using the program as example: java count < Count.java < out.txt


public class Count {
	
    //We only need to check up to the square root of count for prime numbers.
    // The sqrt of count will always be in the middle of the factors of count.
	public static boolean isPrime(int count) {
       
        //two is the only even prime number. Check for two as a seperate case.
        if(count%2 == 0) {
			System.out.println("NO- The number of a's is " + count +  " which is divisible by 2");
			return false;
		}

        // if not, check for all numbers from 3 up to sqrt of count, incrementing by 2. (since all other
        // primes are odd).
		for(int i=3; i*i<=count; i+=2) {
        	if(count%i==0) {
        		System.out.println("NO- The number of a's is " + count +  " which is divisible by " + i);
            	return false;
        	}
        }
        return true;
    }

    // counts the number of lower cases a's in each line of input.
	public static int countLowers(String line) {
		int count = 0;
		for(int i=0; i<line.length(); i++) {
            char c = line.charAt(i);
            if (c == 'a') {
            	count++;
            }
        }
		return count;
	}

	public static void main(String[] args) throws Exception {

    //initialize reader and count_lower for counting number of lowercase a's.
	int count_lower = 0;
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String s;

    //while the line is not equal to null, count_lower is incremented by a function call for each line of input.
    while ((s = in.readLine())!= null) 
        count_lower += countLowers(s);
    
    in.close();  
    //once we have the total number of count lowers, check if the number is prime.
    boolean p = isPrime(count_lower);
    //the true case (number is prime) handled here. False cases handled in isPrime().
    if(p) 
      System.out.println("YES- The number of a's is " + count_lower + " which is prime.");
    
	}

}

import java.util.Arrays;

public class interview_Questions {
	

/* ------------FIND OUT IF A PAIR OF NUMBERS IN AN ARRAY ADD UP TO A SPECIFIC VALUE------------ */

boolean pair_Sum(int[] A, int x) {

	int n = A.length;
	int[] T = new int[x];

	//record the values that exist and could be possible solutions in array T
	for(int i=0; i<n; i++) {
		int cur = A[i];
		if(A[i] >= 0 && A[i] <= x) {
			T[cur]++;
		}
	}

	//checks to see if there are two values ie. a pair that add up to the number
	for(int j=0; j<=x; j++) {
		if(T[j] > 0 && T[x-j] > 0) 
			return true;
		
	}

	return false;

}

/* ----------FIND OUT IF A STRING IS A PALINDROME---------- */

boolean isPalindrome(String s) {
	int n = s.length();

	//iterative loop that goes through half the string. if the charAt both indexes are not the same, return false.
	for(int i=0; i< (n/2); i++){
		if(s.charAt(i) != s.charAt(n-i-1))
			return false;
	}

	return true;
}

// IN PYTHON THERE IS AN EASY WAY TO DO THIS.
// s = 'hello'
// t = s[::-1]
// print s == t

/* --------FIND IF A NUMBER EXISTS IN AN ARRAY---------- */

//Using List and Array library
boolean exists(String[] ar, String target) {
	return Arrays.asList(ar).contains(target);
}
//Iteratively

boolean exists2(int[] ar, int x) {
	for(int i=0; i<ar.length; i++) {
		if(ar[i] == x) //using a string would be ar[i].equals(x)
			return true;
	}
	return false;
}

/* -------------REVERSE A STRING------------- */

public static String reverse(String input) {
	//convert to char array first.
	char[] ip = input.toCharArray();
	int start = 0;
	int end = ip.length-1;
	char temp;
	//continually switch the string up to half way (ie. then it is already reversed)
	while(end > start) {
		temp = ip[start];
		ip[start] = ip[end];
		ip[end] = temp;
		end--;
		start++;

	}
	return new String(ip);
}

/* -------------- FIZZ BUZZ --------------- */
// PRINT OUT THE NUMBERS FROM 1 TO 100, BUT IF THE NUMBER IS DIVISBLE BY 3, PRINT BUZZ IF 5 PRINT FIZZ 
//IF 15 PRINT FIZZBUZZ

public static void fizzBuzz() {
	
	for (int i=0; i<=100; i++) {

		//DO DIVISIBLE BY 15 FIRST
		if(i%15 ==0) {
			System.out.println("FizzBuzz");

		}else if(i%5 ==0) {
			System.out.println("Fizz");

		}else if(i%3 ==0) {
			System.out.println("Buzz");
		}else {
			System.out.println(i);
		}

	}
}

/* -----------FIND THE LARGEST CONSECUTIVE SUBARRAY IN AN ARRAY OF INTEGERS ------------- */ 

public static void largeSub(int[] A) {

	int best_S = 0;
	int cur_S = 0;
	int cur_I = -1;
	int start_I = -1;
	int best_I = -1;

	for(int i=0; i<A.length; i++) {

		// if the current sum plus the next number in the array is greater than 0, then add to current sum
		// note while this doesn't handle decreasing the sum, it is checked after against the best sum
		// to handle this
		if(cur_S + A[i] > 0) {
			cur_S = cur_S + A[i];
		// if it isn't greater than 0, then we want to reset the start index and reset the sum
		} else {
			cur_I = i+1;
			cur_S = 0;
		}
		//if the current sum is greater than the best sum
		if(cur_S > best_S) {
			best_S = cur_S;
			start_I = cur_I; //note that the start index isn't always updated, only if the 0 case triggers.
			best_I = i+1;
		}

	}

	System.out.println("The highest sum was:" + best_S + " Start Index:" + start_I + " End Index:" + best_I);
}

/* --------------FIND IF 2 STRINGS ARE ANAGRAMS------------------- */

public static boolean isAnagram(String x, String y) {

	//preliminary check to see if the strings are the same size
	if(x.length() != y.length()) 
		return false;
	char[] xc = x.toCharArray();
	char[] yc = x.toCharArray();

	//sorting the new arrays
	Arrays.sort(xc);
	Arrays.sort(yc);
	String newx = new String(xc);
	String newy = new String(yc);

	//compare
	return (newx.equals(newy));

}

/* ----------------------COUNT THE NUMBER OF TIMES THAT 2 APPEARS IN N NUMBERS------------- */
public static void count_Twos(int x) {

	//first initalize the count variable and string array with size X, ie. the number we want to check up to
	String[] s = new String[x];
	int count = 0;

	//copy over all values and covert from int into string
	for(int i=0; i<s.length; i++) {
		s[i] = Integer.toString(i);
	}
	//check if the string contains the character 2. note we must convert from char to string.
	for(int i=0; i<x; i++){
		if(s[i].contains(Character.toString('2')))
			count++;
	}

	System.out.println("The number of times that 2 appears: " + count);
}

public static void main(String[] args) {

	int[] x = {-2,1,3,-4,-1,2,-1,5,-4};
	largeSub(x);

	String z =  new String("hello");
	String y = new String("ohell");

	boolean t = isAnagram(z,y);
	System.out.println(t);

	count_Twos(500);
}











































}
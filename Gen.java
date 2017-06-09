import java.util.Arrays;

//CSC 320 Recursive String Perms. with no consecutive values
//COLE BOOTHMAN ST.ID V00808231

// Java program to print all possible strings of length k
public class Gen {
 
    //initalization of the count, K lengths and table for holding counts
    static int count;
    static int[][] table = new int[7][7];
    static int[] k_lengths = {1,2,3,4,5,6,7};
    
    // Driver method to test below methods
    public static void main(String[] args) {             
        
        //initialization of diff char sets to use, 1-7.
        char c1[] = {'1'};
        char c2[] = {'1', '2'};
        char c3[] = {'1','2','3'};
        char c4[] = {'1', '2', '3', '4'};
        char c5[] = {'1', '2', '3', '4', '5'};
        char c6[] = {'1', '2', '3', '4', '5', '6'};
        char c7[] = {'1', '2', '3', '4', '5', '6', '7'};

        // fill the rows of the table.
        fillTable(c1, 0);
        fillTable(c2, 1);
        fillTable(c3, 2);
        fillTable(c4, 3);
        fillTable(c5, 4);
        fillTable(c6, 5);
        fillTable(c7, 6);

        //print out the table
        for(int[] row : table) {
            System.out.println(Arrays.toString(row));
        }

    }    
 
    
    // Fills the table with values for s (Num of diff chars) = 7 and k = 7 (length of string we want)
    // Filled using the count from each run of the stringRec method
    public static void fillTable(char c[], int row) {
        
        int n = c.length; 
        
        for(int i=0; i<7; i++) {
            stringRec(c, "", n, k_lengths[i]);
            table[row][i] = count;
            count = 0;
            
        }
    }


   
    // Recursive method to find perm. of all strings without consecutive #s.
    // Takes in a prefix, set of chars that we want to find the permutatino from,
    // int n, the number of different chars, and int k, the length of the String we want to generate.
    
    public static int stringRec(char c[], String prefix, int num_chars, int k) {
        

        // Base case: if K is 0, we have no more suffixes to add to our prefix, so
        // update the count
        if (k == 0) {
            return count++;
        }
 
        
        // add all characters from set recursively 
        // decrement k each time, so start from strings of length K, when we hit zero update the count.
        for (int i = 0; i < num_chars; ++i) {
             
            
            // If the prefix is not an empty string, we need to check if the last index of the prefix string
            // is equal to the char in the set that we currently want to add
            // if it is, skip onto the next iteration as we don't want strings with consecutive (same) values.
            
            if(!prefix.equals("")) {
                int len = prefix.length();
                char prefix_char = prefix.charAt(len-1);
                char cur_char = c[i];

                if(prefix_char == cur_char) {
                    continue;
                }
            }

            // Add the next character to the prefix from the char set. (if they aren't consecutive)
            String new_prefix = prefix + c[i]; 

            // Since we added the next char to the prefix, decrement k and call the method again with the
            // new prefix.
            stringRec(c, new_prefix, num_chars, k - 1); 
        }
        
        // need a return value (shouldn't hit this case, should return the count above)
        return 0;
    }
}
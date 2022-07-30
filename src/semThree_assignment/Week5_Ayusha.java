package semThree_assignment;

public class Week5_Ayusha {
	    public static void checkSubset(String target, String[] input) {
	        String visited = " ";

	        int result = 0;
	        
	      //loop through the target string
	        for (int i = 0; i < target.length(); i++) {
	        	
	        	//loop through the set string
	            for (int j = 0; j < input.length; j++) {
	            	
	            	//loop through the set string again
	                for (int k = 0; k < input[j].length(); k++) {
	                	
	                	//if the target string and set string are the same, then increment the output
	                    if (target.charAt(i) == input[j].charAt(k) && !visited.contains(target.charAt(i) + "")) {
	                        visited += target.charAt(i);

	                        if (result <= j + 1) {  //if the output is less than or equal to the set string, then increment the output
	                        	result++;
	                        }
	                    }
	                }
	            }
	        }
	        System.out.print("Output : ");

	        System.out.println(result);
	    }

	    public static void main(String[] args) {
	        String target = "frog";
	        String[] input = { "programming", "For", "developers" };
	        checkSubset(target, input);
	    }
}

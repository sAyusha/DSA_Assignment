package semThree_assignment;

public class Week4_Ayusha {
	    // sorting array
	    static void Array(int arr[]) {
	        // sorting the provided by the user in the parameter
	        for (int i = 1; i < arr.length; i++) {
	            int j = i; //initilize j to i
	            
	            int current = arr[i]; //initilize a to the value of the current index of the array
	            
	            while ((j > 0) && (arr[j - 1] > current)){
	            	//move the value of the current index of the array to the next index
	                arr[j] = arr[j - 1];
	                
	                j--;
	            }
	            
	            
	          //assign the value of a to the current index of the array
	            arr[j] = current;
	        }
	    }

	    public static void findContainer(int arr[]){
	        int i; 
	        int container = 0;

	        // sorted the number of villages in grades
	        Array(arr);

	        int prev_val = 0; 
	        int villageContainer = 0;

	        // looping through the sorted array to find the number of containers needed for each village
	        for (i = 0; i < arr.length; i++) {
	        	
	            // if the grades of the current village is not equals to the grades of previous village, 
	        	// then add 1 to the containerforcurrentvillage and add the containerforcurrentvillage to the totalcontainers
	            if (arr[i] != prev_val) {
	            	prev_val = arr[i];
	            	villageContainer += 1;
	                container += villageContainer;
	            }
	            
	            // if the grade of current village is equals to the grade of the previous village, 
	            //then add containerforcurrentvillage to the totalcontainer for the current village
	             else {
	            	 prev_val = arr[i];
	                container += villageContainer;
	            }
	        }

	        //printing the number of containers needed for each village
	        System.out.println(container);
	    }
	    
	    public static void main(String[] args) {
	    	
	        // initializing an array as the number of villages in grades
	        int arr[] = { 5, 2, 6 };

	      //calling the function to find the number of containers needed for each village
	        System.out.print("Output : ");
	        findContainer(arr);
	    }   
}



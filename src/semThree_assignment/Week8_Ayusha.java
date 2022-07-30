package semThree_assignment;

public class Week8_Ayusha {
	String[] input;
    int rows; 
    int cols;

    Week8_Ayusha(String[] input) {
        this.input = input; 
        this.rows = input.length;    
        this.cols = input[0].length();
    }

    int processor() {

    	//calling the keysNumberFinder method to find the number of keys
        int keys = findKeys();

        int travel = 0; //
        int foundOnes = 0;
        boolean run = true;
        int x = 0;
        int travelledRow = 0;
        int adder = 1;
        char[] arrFoundKey = new char[2]; //initializing the found k array

        while (run)
        {
            if (input[travelledRow].charAt(x + adder) != '#') //if the element is not a #
            {

                if (input[travelledRow].charAt(x + adder) == '*') //if the element is a *
                {
                    x += adder; 
                    travel++; 
                    continue; 
                } 
                else //if the element is not a *
                {
                	//if the element is not an uppercase letter
                    if (input[travelledRow].charAt(x + adder) != input[travelledRow].toUpperCase().charAt(x + adder))
                    {
                    	travel++; //increment the total travelled integer   
                    	
                    	arrFoundKey[foundOnes] = input[travelledRow].charAt(x + adder); //add the element to the found k array
                    	
                        x += adder; //increment the x integer
                        
                        foundOnes++; //increment the keys found integer

                      //if the keys found integer is equal to the number of keys
                        if (foundOnes == keys)
                        {
                            run = false; //set the run boolean to false
                            
                            break; //break the loop
                        } 
                        
                      //if the keys found integer is not equal to the number of keys
                        else
                        {
                            continue; 
                        }

                    } 
                    
                  //if the element is an uppercase letter
                    else 
                    {

                        boolean yes = false; //initializing the yes boolean

                        for (int l = 0; l < arrFoundKey.length; l++) 
                        {
                            if (arrFoundKey[l] == input[travelledRow].toLowerCase().charAt(x + adder)) //if the element is in the found k array
                            {

                                yes = true; //set the yes boolean to true
                            }
                        }

                        if (yes)
                        {
                            travel++; 
                            x += adder;
                            continue;
                        }
                        else
                        {
                            adder *= -1; //set the adder integer to negative
                            continue;
                        }

                    }
                }

            }

            if (input[travelledRow + 1].charAt(x) != '#') //if the element is not a #
            {

                if (input[travelledRow + 1].charAt(x) == '*') //if the element is a *
                {

                    travelledRow += 1;
                    travel++; 
                    continue; 
                } 
                else //if the element is not a *
                {
                	
                	//if the element is not an uppercase letter
                    if (input[travelledRow + 1].charAt(x) != input[travelledRow + 1].toUpperCase().charAt(x))
                    {
                    	travel++;
                    	arrFoundKey[foundOnes] = input[travelledRow + 1].charAt(x); //add the element to the found k array
                        travelledRow += 1; 
                        foundOnes++; //increment the keys found integer

                        
                      //if the keys found integer is equal to the number of keys
                        if (foundOnes == keys)
                        {
                            run = false; //set the run boolean to false
                            break; 
                        } 
                        
                        //if the keys found integer is not equal to the number of keys
                        else 
                        {
                            continue; 
                        }

                    } 
                    
                    // if the element is an uppercase letter
                    else
                    {

                        boolean yes = false; //initializing the yes boolean

                        for (int l = 0; l < arrFoundKey.length; l++) //loop through the found k array
                        {
                            if (arrFoundKey[l] == input[travelledRow + 1].toLowerCase().charAt(x)) //if the element is in the found k array
                            {

                                yes = true; //set the yes boolean to true
                            }
                        }

                        if (yes) //if the yes boolean is true
                        {
                        	travel++; 
                            travelledRow++; 
                            continue; 
                        }

                    }
                }

            }
        }

        return travel; 
    }

    //finding key number method
    int findKeys()
    {

        int alphabets = 0;

        for (int i = 0; i < rows; i++) //loop through the input string array
        {
            for (int j = 0; j < cols; j++) //loop through the input string array
            {
                if (input[i].charAt(j) == '@' || input[i].charAt(j) == '#' //if the element is an @ or a #
                        || input[i].charAt(j) == '*') //if the element is a *
                        {
                    continue; 
                }
                
              //if the element is not an @ or a # or a *
                else
                {
                    alphabets++; 
                }
            }
        }

      //set the keys integer to the alphabets integer divided by 2
        int keys = alphabets / 2;

        return keys; 
    }

    
    // driver class
    public static void main(String[] args) 
    {

        String[] value = { "@*a*#", "###*#", "b*A*B" }; 

        Week8_Ayusha pth = new Week8_Ayusha(value); 
        System.out.println("Output is: " + pth.processor());
    }
}

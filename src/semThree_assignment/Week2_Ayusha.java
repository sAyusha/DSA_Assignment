package semThree_assignment;

import java.util.*;

public class Week2_Ayusha {

	int lengthOfArray; 
    int[] arr; 

    Week2_Ayusha(int lengthOfArray, int[] arr) 
    {

        this.lengthOfArray = lengthOfArray; 
        int length = 0;
        
        // creating a new array with the length of the array passed in the parameter
        int[] jointArray = new int[arr.length];

        for (int i = 0; i < arr.length; i++) 
        {
            boolean push = false;
            
            //loop through the array again to check if the element is already in the array
            for (int j = 0; j < arr.length; j++)

            {
            	//if the element is already in the array, then don't push it into the new array
                if (i >= j) 
                {
                    if (i == arr.length - 1) {
                        push = true;
                        break;
                    }
                    continue;
                }

                if (arr[i] == arr[j]) //if the element is not in the array, then push it into the new array
                 {
                    push = false;
                    break;
                } else if (arr[i] != arr[j]) {
                    push = true;
                }
            }
            if (push) //if the element is not in the array, then push it into the new array

            {
            	jointArray[length] = arr[i];
                push = false;
                length++;
            }
        }

        int[] joint = new int[length];

      //loop through the new array to assign the elements to the original array
        for (int i = 0; i < length; i++)
        {
        	joint[i] = jointArray[i];
            
        }

        this.arr = joint;

    }

    void FindResult(){

        int[][] output = findPrime(arr);
        
        int[] outputResult = output[0]; 
        
        int mainLoop = output[1][0]; 
        
        if (mainLoop == lengthOfArray) { //if the length of the prime numbers is equal to the length of the array, then print the prime numbers
            for (int i = 0; i < mainLoop; i++) 
            {
                System.out.print(outputResult[i] + " ");
            }
        } 
        else {
            int[] more = SearchAlgo(outputResult, mainLoop); //calling the function to find the more prime numbers in the array
            
            for (int i = 0; i < lengthOfArray; i++) {
            	
            	//if the element is greater than the length of the prime numbers, then print the more prime numbers
                if (i >= mainLoop) {
                    int num = i - mainLoop;
                    System.out.println(more[num]);
                } 
                
              //if the element is less than the length of the prime numbers, then print the prime numbers
                else
                {
                    System.out.print(outputResult[i]);
                }

            }
        }

    }

    int[] SearchAlgo (int[] primenum, int mainLoop)
    {

        int[] len = new int[lengthOfArray]; //creating a new array with the length of the array
        int moreIn = 0;
        boolean skip = false;
        for (int i = 0; i < arr.length; i++) 
        {
            for (int ext = 0; ext < primenum.length; ext++) {
                if (arr[i] == primenum[ext]){ //if the element is equal to the prime numbers array, then skip it
                    skip = true;
                    break;
                }
            }
            if (skip){ //if the element is equal to the prime numbers array, then skip it
            
                skip = false;
                continue;
            }

            boolean push = true;
            
          //loop through the prime numbers array again to check if the element is already in the array
            for (int j = 0; j < mainLoop; j++){
            
            	//if the element is equal to the prime numbers array, then skip it
                if (primenum[j] == 1) {
                
                    continue;
                } 
                else //if the element is not equal to the prime numbers array, then push it into the new array
                {   
                    float checkval = (float) arr[i] / (float) primenum[j];
                    
                    if (checkval == Math.floorDiv(arr[i], primenum[j])) //if the element is a multiple of the prime numbers array, then skip it
                    {
                        push = false;
                    }
                }
            }

            if (push) //if the element is not equal to the prime numbers array, then push it into the new array
            {
                len[moreIn] = arr[i];
                moreIn++;
            }

        }

        return len;

    }
    
    
  //function to find the prime numbers in the array
    int[][] findPrime(int[] arr){

        int[] primeElements = new int[lengthOfArray];
        int mainLoop = 0;

        for (int i = 0; i < arr.length; i++) 
        {

            if (arr[i] == 0) //if the element is equal to 0, then skip it
            {
                continue;
            } 
            else if (arr[i] == 1) //if the element is equal to 1, then push it into the new array
            {
            	primeElements[mainLoop] = 1;
                mainLoop++;

            } else if (arr[i] == 2) //if the element is equal to 2, then push it into the new array
            {
            	primeElements[mainLoop] = 2;
                mainLoop++;
            } 
            else if (arr[i] == 3) //if the element is equal to 2, then push it into the new array
            {
                primeElements[mainLoop] = 3;
                mainLoop++;
            }

            else //if the element is not equal to 0, 1, 2, or 3 then check if it is a prime number
            {

                boolean prime = true;
               
                int divideLimit = Math.floorDiv(arr[i], 2); //checking if the element is a multiple of 2
                
                for (int j = 2; j <= divideLimit; j++) //loop through the array to check if the element is a multiple of 2
                {

                    float check = (float) arr[i] / j;

                    if (check == Math.floorDiv(arr[i], j)) //if the element is a multiple of 2, then skip it
                    {

                        prime = false;

                    }
                }

                if (prime == true) //if the element is not a multiple of 2, then push it into the new array
                {

                    primeElements[mainLoop] = arr[i];
                    mainLoop++;
                }

            }

        }

        int[][] returner = { primeElements, { mainLoop } }; //assigning the prime numbers to the mainResult array

        return returner;

    }


    public static void main(String[] args) //main method
    {

        int[] input = { 10, 10, 5, 0, 2, 1, 2, 5 }; 

        //creating a new object of the class Week2 with the length of the array and the array elements
        Week2_Ayusha sub = new Week2_Ayusha(3, input); 
        sub.FindResult();
    }

}

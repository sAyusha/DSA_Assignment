package semThree_assignment;

import java.util.*;

public class Week6_Ayusha {
	String[] left; 
    String right;
    HashMap<String, String> map = new HashMap<String, String>(); 

    Week6_Ayusha(String[] left, String right) {

        this.left = left; 
        this.right = right;
    }

    
  //method to process the left side array and right side string
    boolean processor() {

        String valueCheck = String.join("", left); //converting the left side array to a string
        
        String finalCheck = valueCheck + right; //concatenating the left side array and right side string

      //calling the uniqueFinder method to find the unique characters
        findUniqueChar(finalCheck, valueCheck.charAt(valueCheck.length() - 1));

        int leftSum = sumLeft();

        String rightSum = "";

        for (int i = 0; i < right.length(); i++) //loop through the right side string
        {
            rightSum += map.get("" + right.charAt(i));
        }

        if (leftSum == Integer.parseInt(rightSum)) //if the left side sum is equal to the right side sum, then return true
        {
            return true;
        }

        return false;

    }

  //method to find the sum of the left side array
    int sumLeft() 
    {
        int units = 0;
        String[] arrUnit = new String[left.length]; 
        int leftTotal = 0;

        for (int i = 0; i < left.length; i++) //loop through the left side array
        {

        	arrUnit[units] = "";

            for (int j = 0; j < left[i].length(); j++) //loop through the left side string
            {

            	arrUnit[units] += map.get("" + left[i].charAt(j)); //assigning the units array to the units itter

            }
            leftTotal += Integer.parseInt(arrUnit[units]); //adding the units itter to the left total
            units++;

        }

        return leftTotal; //returning the left total
    }

    String findUniqueChar(String a, char leftSide) //method to find the unique characters in the string
    {

        int len = 0;
        char[] arrPass = new char[a.length()]; 

        for (int i = 0; i < a.length(); i++)  
        {
        	//initializing the push boolean
            boolean push = false;
            
          //loop through the string again to check if the element is already in the array
            for (int j = 0; j < a.length(); j++) 
            {
                if (i >= j) //if the element is already in the array, then don't push it into the new array
                {
                    if (i == a.length() - 1) //if the element is the last element, then push it into the new array
                    {
                        push = true;
                        break;
                    }
                    continue;
                 }

                if (a.charAt(i) == a.charAt(j)) //if the element is not in the array, then push it into the new array
                {
                    push = false;
                    break;
                } else if (a.charAt(i) != a.charAt(j)) //if the element is in the array, then don't push it into the new array
                {
                    push = true;
                }
            }
            if (push) //if the push boolean is true, then add the element to the new array
            {
                arrPass[len] = a.charAt(i); //adding the element to the new array
                push = false;
                len++; 
            }
        }

        String combinedString = " ";

        for (int i = 0; i < len; i++) 
        {
        	combinedString += arrPass[i]; //adding the element to the combined string
        	
            map.put("" + arrPass[i], "" + i); //adding the element to the hashmap

        }

        return combinedString;

    }

    
    //driver class
    public static void main(String[] args){

        String[] leftInput = { "THIS", "IS", "TOO" }; 

      //calling the processor method to process the left input array and right input string
        System.out.println(new Week6_Ayusha(leftInput, "FUNNY").processor());
    }
}

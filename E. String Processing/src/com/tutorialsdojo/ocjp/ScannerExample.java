package com.tutorialsdojo.ocjp;

import java.util.ArrayList;
import java.util.List;

public class ScannerExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input = "Unit 147, Level3,  Clemency Building ,Forgiveness St. , San Pedro City , Laguna, Philippines ";
		
		// Should output: 
		//    Clemency,Building,Forgiveness,St.,San,Pedro,City,Laguna,Philippines 
		
		System.out.println(processLine(input));

	}

	
	private static String processLine(String input){
		
		String[] words = input.split(",|//s");
		
		StringBuilder output = new StringBuilder();
		
		for ( String w : words){
			
			if (w.matches(".*\\d.*")){
				//DEBUG: 
				System.out.format("Removed > %s as it contains a number.%n", w);
				
			}else if (w.matches(".*\\s.*")){
				System.out.format("Has > %s%n", w);
				
				String[] wordsArray = w.split("\\s");
				System.out.format("wordsArray > %s%n", wordsArray.length);
				
				for (String words2 : wordsArray){
					System.out.format("Inner > %s%n", w);
					output.append(w.trim() + ",");
				}
				
			}
			
			else{
				//DEBUG: 				
				System.out.format("Added to the list > %s%n", w);
				
				//Trim the word before adding to the list.
			
				output.append(w.trim() + ",");				
				
			}
			
		}
		
		//Removes the last comma of the output.
		System.out.format("Length = %d%n", output.length());
		output.deleteCharAt(output.length()-1);

		System.out.format("> %s%n", output);
				
		
		return output.toString();
	}
}

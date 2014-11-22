package com.tutorialsdojo.ocjp;

public class SearchStrings {
	
	public static void main(String[] args) {
	
		
		String regex = ".*[0-9&&[^1-3]].*";
		String input = "ssssR3Rsssss";
		
		matchString(input,regex);
		
	}
	
	/*
	 * Search the string for regex
	 */
	private static void matchString(String input, String regex){
		
		String wordMatch = "Found a match.";
		String noMatch = "No match.";
		
		if (input.matches(regex)){
		
			System.out.format("%s\t input: %2$s \t regex: %3$s %n", wordMatch, input, regex);
			
		}else{
			System.out.format("%s\t input: %s  \t regex:%s %n", noMatch, input, regex);
		}
		
		
	}

}

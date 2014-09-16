package edu.jsu.mcis;

import java.util.*;

public class Hangman {
    public enum Result { WIN, LOSE, NONE };
    private String word;
    private List<Character> usedLetters;
 //   private String allLetters = "abcdefghijklmnopqrstuvwxyz";
	private int guessNumber=0;
	
    public Hangman() {
        word = "";
        usedLetters = new ArrayList<Character>();
    }
    
    public void setWord(String word) {
        this.word = word;
    }
    
    public boolean available(char c) { 
		if(this.usedLetters.isEmpty()){
			this.usedLetters.add(c);
			return true;
		}
		else if(this.usedLetters.contains(c))
			return false;
		else{
			this.usedLetters.add(c);
			return true;
		}
    }
    
    public int guess(char c) {
		this.guessNumber++;
		int occur =0;
		for(int i;i<word.length();i++){
			if(c==word.charAt(i))
			occur++;
		}
		
        return occur;
    }
    
    public Result getResult() {
        return Result.NONE;
    }
    
	
}













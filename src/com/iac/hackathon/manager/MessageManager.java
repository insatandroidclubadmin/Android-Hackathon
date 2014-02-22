package com.iac.hackathon.manager;

import java.util.ArrayList;

import com.iac.hackathon.domain.EmergencyCall;
import com.iac.hackathon.domain.Letter;
import com.iac.hackathon.domain.Word;

public class MessageManager {

	ArrayList<Letter> letters;
	ArrayList<Word> words;
	
	
	
	public MessageManager() {
		super();
		letters = new ArrayList<Letter>();
		words = new ArrayList<Word>();
		init();
	}



	private void init() {
		letters.add(new Letter("a", 0));
		letters.add(new Letter("b", 0));
		letters.add(new Letter("c", 0));
		letters.add(new Letter("d", 0));
		letters.add(new Letter("e", 0));
		letters.add(new Letter("f", 0));
		letters.add(new Letter("g", 0));
		letters.add(new Letter("h", 0));
		letters.add(new Letter("i", 0));
		letters.add(new Letter("j", 0));
		letters.add(new Letter("k", 0));
		letters.add(new Letter("l", 0));
		letters.add(new Letter("m", 0));
		letters.add(new Letter("n", 0));
		letters.add(new Letter("o", 0));
		letters.add(new Letter("p", 0));
		letters.add(new Letter("q", 0));
		letters.add(new Letter("r", 0));
		letters.add(new Letter("s", 0));
		letters.add(new Letter("t", 0));
		letters.add(new Letter("u", 0));
		letters.add(new Letter("v", 0));
		letters.add(new Letter("x", 0));
		letters.add(new Letter("y", 0));
		letters.add(new Letter("z", 0));
		
		words.add(new Word("Hello", 0));
		words.add(new Word("How are you", 0));
		words.add(new Word("Fine", 0));
	}

	public ArrayList<Letter> getLetters() {
		return letters;
	}

	public ArrayList<Word> getWords() {
		return words;
	}

	public Letter getLetterByName(String name) {
		for (Letter letter : getLetters()) {
			if(name.equals(letter.getName())){
				return letter;
			}
		}
		return null;  //exception
	}

	public Word getWordByName(String name) {
		for (Word word : getWords()) {
			if(name.equals(word.getName())){
				return word;
			}
		}
		return null;  //exception
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

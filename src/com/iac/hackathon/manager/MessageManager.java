package com.iac.hackathon.manager;

import java.util.ArrayList;

import com.iac.hackathon.R;
import com.iac.hackathon.domain.Gesture;
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
		letters.add(new Letter("a", R.drawable.letter_a));
		letters.add(new Letter("b", R.drawable.letter_b));
		letters.add(new Letter("c", R.drawable.letter_c));
		letters.add(new Letter("d", R.drawable.letter_d));
		letters.add(new Letter("e", R.drawable.letter_e));
		letters.add(new Letter("f", R.drawable.letter_f));
		letters.add(new Letter("g", R.drawable.letter_g));
		letters.add(new Letter("h", R.drawable.letter_h));
		letters.add(new Letter("i", R.drawable.letter_i));
		letters.add(new Letter("j", R.drawable.letter_j));
		letters.add(new Letter("k", R.drawable.letter_k));
		letters.add(new Letter("l", R.drawable.letter_l));
		letters.add(new Letter("m", R.drawable.letter_m));
		letters.add(new Letter("n", R.drawable.letter_n));
		letters.add(new Letter("o", R.drawable.letter_o));
		letters.add(new Letter("p", R.drawable.letter_p));
		letters.add(new Letter("q", R.drawable.letter_q));
		letters.add(new Letter("r", R.drawable.letter_r));
		letters.add(new Letter("s", R.drawable.letter_s));
		letters.add(new Letter("t", R.drawable.letter_t));
		letters.add(new Letter("u", R.drawable.letter_u));
		letters.add(new Letter("v", R.drawable.letter_v));
		letters.add(new Letter("w", R.drawable.letter_w));
		letters.add(new Letter("x", R.drawable.letter_x));
		letters.add(new Letter("y", R.drawable.letter_y));
		letters.add(new Letter("z", R.drawable.letter_z));
		
		words.add(new Word("Fine", R.drawable.letter_w));
		words.add(new Word("Fine", R.drawable.letter_w));
		words.add(new Word("Fine", R.drawable.letter_w));
		words.add(new Word("Fine", R.drawable.letter_w));
		words.add(new Word("Fine", R.drawable.letter_w));
		words.add(new Word("Fine", R.drawable.letter_w));
		words.add(new Word("Fine", R.drawable.letter_w));
		words.add(new Word("Fine", R.drawable.letter_w));
		words.add(new Word("Fine", R.drawable.letter_w));
		words.add(new Word("Fine", R.drawable.letter_w));
		
		
		words.add(new Word("Hello", R.drawable.letter_a));
		words.add(new Word("Hello", R.drawable.letter_a));
		words.add(new Word("Hello", R.drawable.letter_a));
		words.add(new Word("Hello", R.drawable.letter_a));
		words.add(new Word("Hello", R.drawable.letter_a));
		words.add(new Word("Hello", R.drawable.letter_a));
		words.add(new Word("Hello", R.drawable.letter_a));
		words.add(new Word("Hello", R.drawable.letter_a));
		words.add(new Word("Hello", R.drawable.letter_a));
		words.add(new Word("Hello", R.drawable.letter_a));
		words.add(new Word("Hello", R.drawable.letter_a));
		words.add(new Word("Hello", R.drawable.letter_a));
		words.add(new Word("Hello", R.drawable.letter_a));
		words.add(new Word("Hello", R.drawable.letter_a));
		words.add(new Word("Hello", R.drawable.letter_a));
		words.add(new Word("Hello", R.drawable.letter_a));
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

	public ArrayList<Gesture> getGestures(String message){
		ArrayList<Gesture> gestures = new ArrayList<Gesture>();
		String[] words = message.split("\\s+");
		for (int i = 0; i < words.length; i++) {
			Word word = getWordByName(words[i]);
			if(word!= null){
				gestures.add(word);
			}else{
				char[] letters = words[i].toCharArray();
				for (int j = 0; j < letters.length; j++) {
					Letter letter = getLetterByName(letters[j]+"");
					if(letter!=null){
						gestures.add(letter);
					}
				}
			}
			
		}
		
		return gestures;
	}
}

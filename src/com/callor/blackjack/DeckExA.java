package com.callor.blackjack;

import java.util.ArrayList;
import java.util.List;

public class DeckExA {
public static void main(String[] args) {
	String strSuit = "◆♥♠♣";
	String strDenomination = "A234567890KQJ";
	
	String[] suits = strSuit.split("");
	String[] denos = strDenomination.split("");
	
	List<PlayingCardDto> deckList = new ArrayList<PlayingCardDto>();
	
	for(String suit : suits) {
		for(String deno : denos) {
			PlayingCardDto dto = new PlayingCardDto();
			dto.suit = suit;
			dto.denomination = deno;
			
			int value = 0;
			try {
				value = Integer.valueOf(deno);
				dto.value = value;
			} catch (Exception e) {
				if(deno.equals("A")) value = 1;
				else value = 10;
				dto.value = value;
			}
			deckList.add(dto);
		}
	}
	for(PlayingCardDto dto : deckList) {
		// System.out.println(dto.suit + dto.denomination + "," + dto.value);
		for(String pattern : dto.getPattern()) {
			System.out.println(pattern);
		}
	}
	
}


}

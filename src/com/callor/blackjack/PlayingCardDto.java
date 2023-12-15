package com.callor.blackjack;

public class PlayingCardDto {
	public String suit;
	public String denomination;
	public int value;
	
	public String[] getPattern() {
		String pattern[] = {
			String.format("┌──────┐ "),
			String.format("│  %1s   │ ",this.suit),
			String.format("│      │ "),
			String.format("│      │ "),
			String.format("│  %2s  │ ",this.denomination),
			String.format("└──────┘ ")
		};
		return pattern;
	}
	
}
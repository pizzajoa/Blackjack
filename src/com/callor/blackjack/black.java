package com.callor.blackjack;

import java.util.Scanner;

public class black {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int playerTotal = 0;
		int dealerTotal = 0;
		int count = 0;
		System.out.println("게임을 시작합니다\n");

		// 내차례
		playerTotal = (int) (Math.random() * 10) + 1; // 1점~10점까지
		System.out.println("당신의 점수는: " + playerTotal + "점");
		System.out.println("카드를 뽑으시겟습니까?(h:진행 s:멈춤 (h/s))");
		count++; // 누를 때마다 횟수 증가
		String player = scan.nextLine();

		while (player.equals("h")) { // 17이하일때만 h누르기
			int pHit = (int) (Math.random() * 10) + 1;
			playerTotal += pHit;
			System.out.println(pHit + "점을 얻었습니다." + " 총 점수는 " + playerTotal);
			if (playerTotal > 21) {
				System.out.println("파산! " + count + " 회 시도");
				break;
			}
			System.out.println("카드를 뽑으시겟습니까?(h:진행 s:멈춤 (h/s))");
			count++;
			player = scan.nextLine();
		}

		// 딜러차례
		dealerTotal = (int) (Math.random() * 10) + 1;
		System.out.println("\n딜러의 점수는: " + dealerTotal + "점");

		while (dealerTotal < 17) { // 딜러도 21안넘게끔 룰대로 17이하때만 뽑게 설정
			int dHit = (int) (Math.random() * 10) + 1;
			dealerTotal += dHit;
			System.out.println(dHit + "점을 얻었습니다." + " 총 점수는 " + dealerTotal);
		}

		// 승자결정
		if (dealerTotal > 21) { // 플레이어, 딜러 21넘김 = 무승부
			System.out.println("파산! 무승부입니다! " + count + " 회 시도");
			System.out.println("플레이어 : " + playerTotal + " 딜러 : " + dealerTotal);
		} else if (dealerTotal > playerTotal) { // 딜러 21못넘기고 플레이어보다 점수 높음 = 딜러 승
			System.out.println("딜러가 이겼습니다! " + count + " 회 시도");
			System.out.println("플레이어 : " + playerTotal + " 딜러 : " + dealerTotal);
		} else if (dealerTotal == playerTotal) { // 딜러 21못넘기고 플레이어와 딜러가 동점 = 무승부
			System.out.println("동점! 무승부입니다! " + count + " 회 시도");
			System.out.println("플레이어 : " + playerTotal + " 딜러 : " + dealerTotal);
		} else if (playerTotal > 21) { // 딜러 21못넘기고 플레이어보다 점수가 높지않고 플레이어가 21보다 높음(파산패) = 딜러 승
			System.out.println("딜러가 이겼습니다! " + count + " 회 시도");
			System.out.println("플레이어 : " + playerTotal + " 딜러 : " + dealerTotal);
		} else { // 딜러21못넘기고 플레이어보다 점수가 높지 않고 플레이어가 21보다 높지 않다 = 플레이어 승
			System.out.println("당신이 이겼습니다! " + count + " 회 시도");
			System.out.println("플레이어 : " + playerTotal + " 딜러 : " + dealerTotal);
		}
		scan.close();
	}
}

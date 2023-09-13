package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("What's your start amount?");
		int startAmount = in.nextInt();
		System.out.println("What's the win chance?");
		double winChance = in.nextDouble();
		System.out.println("What's your win limit?");
		int winLimit = in.nextInt();
		System.out.println("How many days are you gambling?");
		int totalSimulations = in.nextInt();
		int ruinTimes = 0;
		
		for (int day = 1; day <= totalSimulations; day++) {
			int times = 0;
			int amount = startAmount;
			while (0 < amount && amount < winLimit) {
				double randomNumber = Math.random();
				if (randomNumber < winChance) {
					amount ++;
				}
				else {
					amount --;
				}
				times ++;
			}
			String result = null;
			if (amount == 0) {
				result = "Ruin" ;
				ruinTimes++;
			}
			else if (amount == winLimit) {
				result = "Success" ;
			}
			System.out.println("Simulation " + day + ": " + times + " " + result);
				
		}
		double ruinTimesD = ruinTimes;
		double ruinRate = ruinTimesD/totalSimulations;
		double expectedRuin;
		double a = (1-winChance)/winChance;
		if (winChance == 0.5) {
			expectedRuin = 1 - startAmount/winLimit;
		}
		else {
			expectedRuin = (Math.pow(a,startAmount)-Math.pow(a,winLimit))/(1-Math.pow(a,winLimit));
		}
		
		
		System.out.println("Losses: " + ruinTimes + " Simulations: "+ totalSimulations);
		System.out.println("Ruin rate from simulation: " + ruinRate + " Expected Ruin Rate: "+ expectedRuin);
	}

}

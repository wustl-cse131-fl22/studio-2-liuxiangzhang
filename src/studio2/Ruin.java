package studio2;
import java.util.Scanner;
import java.lang.Math;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter start amount: ");
		double startAmount = in.nextDouble();
		System.out.println("Enter win chance: ");
		double winChance = in.nextDouble();
		System.out.println("Enter win limit: ");
		int winLimit = in.nextInt();
		System.out.println("Enter total simulations: ");
		int totalSimulations = in.nextInt();


		double expectedRuin;
		double alpha = (1-winChance)/winChance;
		if (winChance == 0.5)
			expectedRuin = 1 - startAmount/winLimit;
		else
			expectedRuin = (Math.pow(alpha, startAmount) - Math.pow(alpha, winLimit))/(1 - Math.pow(alpha, winLimit));


		int numberOfLoss = 0;
		for (int day = 1; day <= totalSimulations; day++)
		{
			int count = 0;
			double money = startAmount;
			while ((money < winLimit) && (money > 0))
			{
				double possibility = Math.random();
				count ++;
				if (possibility > 1-winChance)
					money += 1;
				else
					money -= 1;
			}
			if (money >= winLimit)
			{
				System.out.print("Simulation day " + day + "   ");
				System.out.print("Number of plays: " + count + "   ");
				System.out.println("Success");
			}
			else
			{
				System.out.print("Simulation day " + day + "   ");
				System.out.print("Number of plays: " + count + "   ");
				System.out.println("Ruin");
				numberOfLoss += 1;
			}
		}
		double simulationRate = (double) numberOfLoss/totalSimulations;
		System.out.println("Losses: " + numberOfLoss + " Simulations: " + totalSimulations);
		System.out.println("Ruin rate from simulation: " + simulationRate);
		System.out.println("Expected Ruin Rate: " + expectedRuin);

	}

}

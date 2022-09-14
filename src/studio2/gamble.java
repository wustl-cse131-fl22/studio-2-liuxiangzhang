package studio2;

import java.util.Scanner;

public class gamble {
	Scanner in = new Scanner(System.in);
	System.out.println("startAmount");
	int startAmount = in.nextInt();
	Scanner scan = new Scanner(System.in);
	System.out.println("winChance");
	double winChance = scan.nextDouble();
	Scanner limt = new Scanner(System.in);
	System.out.println("winLimit");
	int winLimit = limt.nextInt();
	Scanner total = new Scanner(System.in);
	System.out.println("totalSimulations");
	int totalSimulations = total.nextInt();
	double count_ruin = 0;
	int simulationCount =0;
	int countStep = 0;
	for (int count = 0; count < totalSimulations; count++)
	{
		
		int add = startAmount;
		while((add < winLimit) && (add >0))
		{
			if(Math.random() <=winChance)
			{
				add++;
				countStep++;
			}
			else
			{
				add--;
				countStep++;
			}
		}	
		if(add == 0)
		{
			System.out.println("simulation"+simulationCount+": "+ countStep+"lose");
			count_ruin++;
		}
		else
		{
			System.out.println("simulation"+simulationCount+": "+countStep +"win");
			
	    }
		 simulationCount++;
		 countStep = 0;
	}
	double ruinRate = count_ruin/totalSimulations;
	double expect;
	if(winChance == 0.5)
	{
		 expect = 1-(startAmount/winLimit);
	}
	else
	{
		double alpha = (1-winChance)/winChance;
		 expect = (Math.pow(alpha, startAmount)-Math.pow(alpha, winLimit))/(1-Math.pow(alpha, winLimit));
	}
	System.out.print("Ruin Rate from Simulation:"+ruinRate +"Expecct: " + expect);
}


}

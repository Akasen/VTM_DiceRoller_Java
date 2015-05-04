/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VTM_DiceRoller;

import java.util.Scanner;
import java.util.Random;
        
public class MainProgram{
    public static void main(String[] args)
    {
        while(true)
        {
            Scanner scan = new Scanner (System.in);

            int dice, difficulty;
            int[] results;

            System.out.println("Please enter your amount: ");
            dice = getInput(scan);

            System.out.println("Enter the difficulty: ");
            difficulty = getInput(scan);

            results = displayResults(dice);

        calculateAll(results, dice, difficulty);
        }
        
    }
   
    public static int getRandomNumber()
    {
        Random rand = new Random();
        
        int pickedNumber = rand.nextInt(10)+1;
        
        return pickedNumber;
    }
   
    public static int getInput(Scanner scan)
    {
        String a;
        int input, properInput = 0;
        do{
            if(!scan.hasNextInt())
            {
                    
                System.out.println("I'm sorry, you did not enter a number."
                        + "Please try again.");
                System.out.println("Enter Value: ");
                scan.nextLine();
                
            }
            else
                properInput = 1;
        }while(!scan.hasNextInt());
        
        
        return scan.nextInt();
    }
    
    public static int[] getPlayerRolls(int amount)
    {
        int[] rolls;
        rolls = new int[amount];
        
        int i;
        
        for(i = 0; amount > i; i++)
        {
            rolls[i] = getRandomNumber();
        }
        
        return rolls;
    }
    
    public static int[] displayResults(int amount)
    {
        int[] results;
        //results = new int[amount];
        
        results = getPlayerRolls(amount);
        
        int i;
        
        System.out.println("Full Results: ");
        /*
        for(i = 0; i < amount; i++)
        {
            System.out.println(results[i]);
        }*/
        System.out.println(java.util.Arrays.toString(results));
        
        return results;
    }
    
    public static int calculateSuccess(int[] results, int amount, int difficulty)
    {
        int i, successCount = 0;
        
        for(i = 0; i < amount; i++)
        {
            if (results[i] >= difficulty)
            {
                successCount++;
            }
        }
        
        System.out.println("\nAmount of Successes: " + successCount);
        return successCount;
    }
    
    public static int calculateOne(int[] results, int amount)
    {
        int i, oneCount = 0;
        
        for(i = 0; i < amount; i++)
        {
            if (results[i] == 1)
            {
                oneCount++;
            }
        }
        System.out.println("Amount of 1's: "+ oneCount);
        return oneCount;
    }
    
    public static void calculateAll(int[] results, int amount, int difficulty)
    {
        int successes, ones;
        
        successes = calculateSuccess(results, amount, difficulty);
        ones = calculateOne(results, amount);
        
        System.out.println("\nTotal amount of successes: " + (successes - ones));
        botchDetection(successes, ones, (successes - ones));
        
    }
    
    public static void botchDetection(int successes, int ones, int totalSuccesses)
    {
        if(ones > successes)
            System.out.println("\nBOTCH!");
        else if (successes == 0 && ones == 0)
            System.out.println("\nFAILURE!");
        else if(totalSuccesses > 0)
            System.out.println("\nSUCCESS!");
    }
    
}

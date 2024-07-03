package com.app.assign_bank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BankAccount {

	public static void main(String[] args) 
	{
		double sumOfDeposits = 0.0;
        double maxDepositAmount = 0.0;
        double shoppingExpenses = 0.0;
        double maxWithdrawalAmount = 0.0;
        String dateOfMaxWithdrawal = "";

        System.out.println("Enter the file name : ");
        try (Scanner sc = new Scanner(System.in);
        		BufferedReader br = new BufferedReader(new FileReader(sc.nextLine()))) 
        {
            String line = br.readLine(); // Read the header line
            
            while ((line = br.readLine()) != null) 
            {
                String[] values = line.split(",");
                String transactionDate = values[0];
                String narration = values[1];
                double withdrawalAmount = Double.parseDouble(values[2]);
                double depositAmount = Double.parseDouble(values[3]);

                // Sum of all deposits
                sumOfDeposits += depositAmount;

                // Max deposit amount
                if (depositAmount > maxDepositAmount) {
                    maxDepositAmount = depositAmount;
                }

                // Shopping expenses
                if (narration.toLowerCase().contains("shopping")) {
                    shoppingExpenses += withdrawalAmount;
                }

                // Date on which maximum amount withdrawn
                if (withdrawalAmount > maxWithdrawalAmount) {
                    maxWithdrawalAmount = withdrawalAmount;
                    dateOfMaxWithdrawal = transactionDate;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print the results
        System.out.println("Sum of all deposits = " + sumOfDeposits);
        System.out.println("Max deposit amount = " + maxDepositAmount);
        System.out.println("Shopping expenses = " + shoppingExpenses);
        System.out.println("Date on which max amount withdrawn = " + dateOfMaxWithdrawal);
    
	}
}

package org.ATMinterface.main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.ATMinterface.main.dao.AtmFunctionality;

public class App {

	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String args[])
			throws NumberFormatException, IOException, ClassNotFoundException, SQLException {

		System.out.println("------------------------------------------------------------------------------------");
		System.out.println("----------------------------------- WELCOME TO ATM ---------------------------------");
		System.out.println("------------------------------------------------------------------------------------");

		boolean status = false;
		do {
			System.out.print("\t\t  User Name : ");
			String userName = bufferedReader.readLine();
			System.out.println("");
			System.out.print("\t\t  Enter Your 4 Digit PIN : ");
			String pin = bufferedReader.readLine();
			System.out.println(" ");
			status = AtmFunctionality.login(userName, pin);

			if (status) {
				do {
					System.out.println(" ");
					System.out.println("-------------------------------------- MENU ----------------------------------------");
					System.out.println(" ");
					System.out.println("\t\t  Choose 1-> Withdraw ");
					System.out.println("\t\t  Choose 2-> Deposit");
					System.out.println("\t\t  Choose 3-> Check Balance ");
					System.out.println("\t\t  Choose 4-> Account Information.");
					System.out.println("\t\t  Choose 5-> Change PIN ");
					System.out.println("\t\t  Choose 6-> Exit");
					System.out.println("------------------------------------------------------------------------------------");
					System.out.println("\t\t  Enter a valid input between 1 to 6:");
					int choice = Integer.parseInt(bufferedReader.readLine());

					switch (choice) {
					case 1:
						System.out.println("Enter Account No:");
						long accountId = Integer.parseInt(bufferedReader.readLine());
						System.out.println("Enter withdraw amount:");
						double withdrawalAmount = Double.parseDouble(bufferedReader.readLine());
						double result = AtmFunctionality.withdraw(accountId, withdrawalAmount);

						if (result == 0) {
							System.out.println("Insufficient Balance");
							System.out.println("Transaction is unsuccessfull");
						} else {
							System.out.println("Transaction successfull");
							System.out.println("Available Balance:" + result);
						}
						break;

					case 2:
						System.out.println("Enter valid Account No:");
						accountId = Integer.parseInt(bufferedReader.readLine());
						System.out.println("Enter Deposit Amount:");
						double depositAmount = Double.parseDouble(bufferedReader.readLine());
						result = AtmFunctionality.deposit(accountId, depositAmount);

						if (result == 0) {

							System.out.println("Transaction is unsuccessfull");
						} else {
							System.out.println("Transaction successfull");
							System.out.println("Available Balance :" + result);
						}
						break;
						

					case 3:
						System.out.println("Enter Valid Account No:");
						accountId = Integer.parseInt(bufferedReader.readLine());
						System.out.println("Current Available Balance is :" + AtmFunctionality.balanceCheck(accountId));
						break;

					case 4:
						System.out.println("Enter Valid Account No:");
						accountId = Integer.parseInt(bufferedReader.readLine());
						System.out.println("------------------------------------------------------------------------------------");
						System.out.println("----------------------------- ACCOUNT INFORMATION ----------------------------------");
						System.out.println("------------------------------------------------------------------------------------");

						ResultSet accountInfo = AtmFunctionality.checkAccountInfo(accountId);
						System.out.println("\t\t  Account Number      :" + accountInfo.getLong("accid"));
						System.out.println("\t\t  Account Holder Name :" + accountInfo.getString("accname"));
						System.out.println("\t\t  Account Type        :" + accountInfo.getString("acc_typ"));
						System.out.println("\t\t  Phone               :" + accountInfo.getLong("phone"));
						System.out.println("\t\t  Email               :" + accountInfo.getString("email"));
						System.out.println("\t\t  Available Balance   :" + accountInfo.getString("balance"));
						System.out.println("------------------------------------------------------------------------------------");
						break;
					case 5:
						System.out.println("Enter your account number:");
						accountId = Integer.parseInt(bufferedReader.readLine());
						System.out.println("Enter your 4 digit pin number:");
						pin =bufferedReader.readLine();
						System.out.println("Enter your new 4 digit pin number:");
						String newPin =bufferedReader.readLine();
						System.out.println("PIN Successfully Changed :");
//						+ AtmFunctionality.pinchange(accountId, pin, newPin));
						break;
					case 6:
						status = false;
						System.out.println(" ");
						System.out.println("Exit successfully");		
						System.out.println("------------------------------------------------------------------------------------");
						break;

					default:
						System.out.println("------------------------------------------------------------------------------------");
						System.out.println("Incorrect Choice");
						System.out.println("------------------------------------------------------------------------------------");
					}

				} while (status);
			}

			else {
				System.out.println(
						"-----------------------------------------------------------------------------------------");
				System.out.println("Incorrect User Name or PIN");
				System.out.println(
						"-----------------------------------------------------------------------------------------");
			}
		} while (status);
	}

}
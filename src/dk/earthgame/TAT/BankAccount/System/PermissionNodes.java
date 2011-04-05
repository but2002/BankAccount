package dk.earthgame.TAT.BankAccount.System;

public enum PermissionNodes {
	ACCESS				("bankaccount.access"),		//Access to allow user to use BankAccount.
													//Overrides all other Bankaccount permissions
	ADMIN				("bankaccount.admin"),		//Access to all commands and accounts
	OPEN				("bankaccount.open"),		//Access to open own accounts + show balance
	USER				("bankaccount.user"),		//Access to add/remove users on own accounts
	CLOSE				("bankaccount.close"),		//Access to close own accounts
	DEPOSIT				("bankaccount.deposit"),	//Access to deposit to own accounts
	WITHDRAW			("bankaccount.withdraw"),	//Access to withdraw from own accounts
	PASSWORD			("bankaccount.password"),	//Access to withdraw from own accounts
	TRANSFER			("bankaccount.transfer"),	//Access to transfer from own accounts
	LOAN				("bankaccount.loan"),		//Access to loan money
	EXTENDED			("bankaccount.extended"),	//Access to all commands except area commands
	BASIC				("backaccount.basic");		//Access the same as: open,user,deposit,withdraw
	
	private final String node;
	PermissionNodes(String node) {
		this.node = node;
	}
	public String getNode() { return node; }
};
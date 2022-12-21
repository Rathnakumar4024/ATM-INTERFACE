package org.ATMinterface.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.ATMinterface.main.dao.AtmFunctionality;

import org.ATMinterface.main.Exception.InvalidAmtException;

import org.junit.jupiter.api.Test;

public class WithdrawModuleTest {
	

	@Test
	public void testCase1() throws ClassNotFoundException, SQLException, InvalidAmtException
	{
		
		assertEquals(3000, AtmFunctionality.withdraw(1,3000));
	}

	
	@Test
	public void testCase2() throws ClassNotFoundException, SQLException, InvalidAmtException
	{
		
		assertEquals(3000, AtmFunctionality.withdraw(2,3000));
	}
}

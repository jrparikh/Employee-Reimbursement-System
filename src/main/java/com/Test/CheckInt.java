package com.Test;

import static org.junit.Assert.*;

import org.junit.Test;


public class CheckInt {

	@Test //Checks the CheckInt method ability to catch non integer inputs
	public void test() {
		int num = 0; String string = "12345H";
		num = CheckIntTestingSetup.CheckInt(num, string);
		assertEquals(1,num);//Expects a 1 for a fail
	}

}

package com.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.Model.User;

public class CheckLoginMethod {


	@Test
	public void test() {
		ArrayList<User> EMPs = new ArrayList<User>();
		EMPs.add(new User("JimmyD","123456","Jay","3Legs","Jay3Legs",1));
		boolean bool = CheckLoginMethodTester.CheckForUsers("JimmyD", "123456", EMPs);
		assertEquals(true,bool);
	}

}

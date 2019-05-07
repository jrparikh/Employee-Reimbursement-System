package com.Test;

public class CheckIntTestingSetup {

	static int CheckInt(int number, String input) 
	{
		number = 0;
		String Intcheck = null;
		while (Intcheck == null) {
			Intcheck = input;
			try {
				number = Integer.valueOf(Intcheck);break;
			}catch(NumberFormatException e){
				number = 1;
				}
			}
		return number;
	}
	
}

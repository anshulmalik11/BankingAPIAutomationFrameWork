package com.api.utilites;

import java.util.Random;

public class JavaUtilities {

	public int ranNum() {
		Random ran = new Random();
		int num = ran.nextInt(10000);
		return num;
	}
}

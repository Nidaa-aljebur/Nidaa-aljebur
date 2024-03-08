package com.neotech.lesson05;

import com.neotech.utils.BaseClass;

public class OpenOrangeHRM3 extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		
		//Let's set up the testing session --> use setUp() 
		setUp();
		
		//Let's write our test here
		String title = driver.getTitle();
		System.out.println("Title: " + title);
		Thread.sleep(3000);
		
		//Let's terminate the session --> use tearDown()
		tearDown();
	}

}

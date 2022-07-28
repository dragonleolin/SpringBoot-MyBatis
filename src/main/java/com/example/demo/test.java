package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class test {

	public static void main(String[] args) throws InterruptedException {
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println(timeStamp);
		if(timeStamp.equals("2022/07/26 18:10:00")) {
			System.out.println("yyy");
		}

		
	}

}

package com.ubs.opsit.interviews.application;
import com.ubs.opsit.interviews.service.impl.TimeConverterImpl;


public class TimeConverterMain {

	public static void main(String[] args) {
		TimeConverterImpl timeConverterImpl = new TimeConverterImpl();
		
		System.out.println("*********Berlin Time For 00:00:00*********");
		System.out.println(timeConverterImpl.convertTime("00:00:00"));
		
		System.out.println("*********Berlin Time For 13:17:01*********");
		System.out.println(timeConverterImpl.convertTime("13:17:01"));

		System.out.println("\n*********Berlin Time For 23:59:59*********");
		System.out.println(timeConverterImpl.convertTime("23:59:59"));

		System.out.println("\n*********Berlin Time For 24:00:00*********");
		System.out.println(timeConverterImpl.convertTime("24:00:00"));
	}

}

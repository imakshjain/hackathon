package com.ubs.opsit.interviews.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ubs.opsit.interviews.service.ITimeConverter;

public class TimeConverterImpl implements ITimeConverter {

	public String convertTime(String standardTime) {

		List<Integer> timeUnitList = new ArrayList<Integer>();
		boolean isTimeValid = false;
		String berlinTime = null;
		isTimeValid = isTimeValid(standardTime,timeUnitList);
		if(isTimeValid){
			berlinTime = getTimeInBerlinFormat(timeUnitList);
		}else {
			System.out.println("Please enter valid time");
		}
		return berlinTime;
	}

	public String getTimeInBerlinFormat(List<Integer> timeUnitList) {
		String berlinTime = "";
		berlinTime = berlinTime + getTimeForTopLamp(timeUnitList.get(2)) + "\n";
		berlinTime = berlinTime + getTimeForFirstLamp(timeUnitList.get(0)) + "\n";
		berlinTime = berlinTime + getTimeForSecondLamp(timeUnitList.get(0)) + "\n";
		berlinTime = berlinTime + getTimeForThirdLamp(timeUnitList.get(1)) + "\n";
		berlinTime = berlinTime + getTimeForFourthLamp(timeUnitList.get(1)) + "\n";
		
		return berlinTime;
	}
	
	public String getTimeForFourthLamp(Integer minutes) {
		return getTime(4, minutes % 5, "Y");	
	}

	public String getTimeForThirdLamp(Integer minutes) {
		Integer numberOfOnLights = getNumberOfOnLights(minutes);
		String timeForThirdLamp = getTime(11, numberOfOnLights, "Y").replaceAll("YYY", "YYR");
		timeForThirdLamp = timeForThirdLamp.replaceAll("YYY", "YYR");
		return timeForThirdLamp;
	}

	public Integer getNumberOfOnLights(Integer number) {
		return (number - (number % 5)) / 5;
	}

	public String getTimeForSecondLamp(Integer hours) {
		return getTime(4, hours % 5, "R");
		
	}

	public String getTimeForFirstLamp(Integer hours) {
		Integer numberOfOnLights = getNumberOfOnLights(hours);
		return getTime(4, numberOfOnLights, "R");
	}

	public String getTime(int numberOfLights, Integer numberOfOnLights, String timeFormat) {
		String result = "";
		
		 for (int i = 0; i < numberOfOnLights; i++) {
			 result += timeFormat;
	        }
	        
		 for (int i = 0; i < (numberOfLights - numberOfOnLights); i++) {
			 result += "O";
	        }
		return result;
	}

	public String getTimeForTopLamp(Integer seconds) {
		if(seconds % 2 == 0){
			return "Y";
		}else{
			return "O";
		}
	}

	public boolean isTimeValid(String standardTime, List<Integer> timeUnitList) {
		
		if(standardTime != null && !standardTime.isEmpty()){
			
			for (String part : standardTime.split(":")) {
				timeUnitList.add(Integer.parseInt(part));
			}
			
			if(timeUnitList.size() != 3){
				return false;
			}
			
			if(timeUnitList.get(0) < 0 || timeUnitList.get(0) > 24){
				return false;
			}
			
			if(timeUnitList.get(1) < 0 || timeUnitList.get(1) > 59){
				return false;
			}
			
			if(timeUnitList.get(2) < 0 || timeUnitList.get(2) > 59){
				return false;
			}
			
		}else{
			return false;
		}
		
		return true;
		
	}

}

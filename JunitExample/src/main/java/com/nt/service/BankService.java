package com.nt.service;

public class BankService {
	public 	 float calcSimpleInterestAmount(float p,float r,float t) {
		/*try {
			Thread.sleep(20500);
		}catch(Exception e){
			e.printStackTrace();
		}*/
		if(p<=0||r<=0 ||t<=0) {
			throw new IllegalArgumentException();
		}
		return p*r*t/100;
		
	}

}

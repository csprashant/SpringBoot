package com.nt.java;

public class PhoneNumberValidator  {
	public PhoneNumberValidator() {
	
	}

	
	public boolean test(String phone) {
		if (phone.startsWith("+91") && phone.length()==13)
			return true;		
		return false;
	}
	

}

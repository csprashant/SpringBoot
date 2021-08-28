package com.nt.java;

import java.util.function.Predicate;

public class PhoneNumberValidator implements Predicate<String> {
	public PhoneNumberValidator() {
	
	}

	@Override
	public boolean test(String phone) {
		if (phone.startsWith("+91") && phone.length()==13)
			return true;		
		return false;
	}
	

}

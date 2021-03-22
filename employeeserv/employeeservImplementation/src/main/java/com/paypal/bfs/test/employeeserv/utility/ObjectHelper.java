package com.paypal.bfs.test.employeeserv.utility;

import com.paypal.bfs.test.employeeserv.api.model.Address;

public class ObjectHelper {
	
	public static Address getAddress() {
		
		Address address = new Address();
		address.setLine1("sample_line1");
		address.setCity("sample_city");
		address.setState("sample_state");
		address.setCountry("sample_country");
		address.setZip_code("sample_pincode");
		
	return address;
	}

}

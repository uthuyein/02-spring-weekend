package com.jdc.dto;

import com.jdc.utils.MyServiceAnno;
import com.jdc.utils.ShowLogger;

@MyServiceAnno
public class MyEmployeeService {

	
	public void sale() {
		ShowLogger.output("Sale some products !");
	}
	
	public void save(String data) {
		ShowLogger.output("Save some products !");
	}
	
}

package com.jdc.service;

import com.jdc.anno.MyAnno;
import com.jdc.anno.MyServiceAno;
import com.jdc.utils.ShowLogger;

@MyAnno
public class MyService {

	public void doWork() {
		ShowLogger.output("doWork from myService");
	}
	
	@MyServiceAno
	public void doWorkOther() {
		ShowLogger.output("doWork other from myService");
	}
}

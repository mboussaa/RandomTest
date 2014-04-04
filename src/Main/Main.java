package Main;

import DataGenerators.RandomGeneration;
import SystemUnderTest.SystemSample_JAVA;


public class Main {

	public static void main(String[] arg) throws Exception{
		
		RandomGeneration R=new RandomGeneration();
	
		//Starting from an interface name we start the random generation dynamically
		R.startInvoke(Commons.JAVA_IMPLEMENTAION_CLASS,Commons.JS_IMPLEMENTAION_CLASS,Commons.INTERFACE_NAME);	
	
	}
}

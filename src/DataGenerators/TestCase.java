package DataGenerators;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;
import java.util.Vector;

public class TestCase {

	Method m;
	Object[] data;
	Vector<Object> outputs;
	float testCaseFitnessValue;
	
	public TestCase (Method m,Object[] data,Vector<Object> outputs){
		
		this.m=m;
		this.data=data;
		this.outputs=outputs;
		
	}
	
	//calculate the fitness value of one test case : intersection
	public void calculateTestCaseFitness(){
		int nb=1;
		float fitness;
		for (int i = 0; i < outputs.size(); i++) {			
			
		}
		Object value;
		int frequence, i, j, counter ; 
		frequence = 0; 
		for (i=0; i < outputs.size(); i++){
			counter = 0 ; 
		for (j = 0 ; j < outputs.size(); j++){
		 if ( outputs.elementAt(i).toString().equals(outputs.elementAt(j).toString()) ) {
			 counter = counter + 1 ;
		}
		} 
		if  (counter > frequence) {
		frequence = counter ; 
		value = outputs.elementAt(i) ;
		}
		} 
		
		fitness=frequence/outputs.size();
		
		this.testCaseFitnessValue=fitness;
	}
	
	//display details about the current test case : Method name, inputs, outputs and fitness value
	public void displayTestCase(){
		System.out.println(" Method : "+this.m.getName());
		for (int i = 0; i < data.length; i++) {
			System.out.println(" Input : "+data[i] );
		}
		for (int i = 0; i < outputs.size(); i++) {
			System.out.println(" Output "+(i+1)+" : "+this.outputs.elementAt(i));
		}
		System.out.println(" Fitness value : "+this.testCaseFitnessValue );

		
	}
	
	//get test case fitness value
	public float getTestCaseFitnessValue(){
		return testCaseFitnessValue;
	}
	
	//get a method
	public Method getMethod(){
		return m;
	}
	
	//get the generated data
	public Object[] getData(){
		return data;
	}
	
	//set a new method call
	public void setMethod(Method m){
		this.m=m;
	}
	
	//set new generated data
	public void setData(Object[] data){
		this.data=data;
	}
}

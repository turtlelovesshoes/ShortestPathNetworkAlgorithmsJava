package rng;
import java.io.*;
import java.util.*;
import java.lang.Math;
import java.io.PrintWriter;
import java.io.File;

public class randomNumberGen4 {
	
	
	//Rachel McGuigan
	//Random number generator to test a simulated server FIFO queue
	//variables
	//funtion of m to calculate the work times for each m randomly generated
	//example: 
	 /*   Customer C1 : s1 = 80; a1 = 30;W1 = 0:
		Customer C2 : s2 = 150; a2 = 25; W2 = (0 + 80 - 30)+ = 50:
		Customer C3 : s3 = 90; a3 = 65;  W3 = (50 + 150 - 25)+ = 175:
		Customer C4 : s4 = 60; a4 = 80;  W4 = (175 + 90 - 65)+ = 200:
		Customer C5 : s5 = 80; a5 = 80;  W5 = (200 + 60 - 80)+ = 180:
		Customer C6 :                    W6 = (180 + 80 - 80)+ = 180.*/
	//Um = sm/am:
//u= 1/Ts and p =u  Wq = p/(u-p*u)
//variables
	//initialize the vars  */
	public double Ta = 200.0, Ts =100.0, te = 1000.0;
	public double t11, t22, tm, tb = 0, s, time1;
	public static double workbar=0; 
	
//need to remember previous W and need to limit to m times 
	public void docalc(int m, String filename){
    	PrintWriter writer = null;
		try {
			writer = new PrintWriter(filename, "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.println("Work for m =");
		writer.print(m);
		writer.println("________________________");
		
		int i =0;
		double[] a = new double[m+1];
		double[] s = new double[m+1];
		double[] work = new double[m+1];
		
		while (i <=  m){
			if(i==0){
				//call first event t1= getRandom, t2=getRandom
				t11= getRandom(727633698, i);
				t22 = getRandom(276090261, i);
				writer.println(t11); writer.println(t22);	
				a[i]=t11; 
				s[i]=t22;
				work[i]=0;
				i++;
			}
			else{
				
				t11= getRandom(Ta, i);	
				t22 = getRandom(Ts, i);
				a[i]=t11; 
				s[i]=t22;
				work[i]=work[i-1] + (short)s[i-1] - (short)a[i-1];
				writer.println("WORK for");
				writer.print(i);
				writer.println(work[i]);
				i++;
				writer.print("a");writer.println(t11); writer.print("s"); writer.println(t22);
			
			}
			
	
		}
		//calc last
		writer.println("Last work for m");
		writer.println(work[i-1]);
		work[m-1]=work[m-1] + s[m-1] - a[m-1];
		
		//i==m
		//calculate Wq and p
		double u = calcU(m, a, s, work);
		writer.println("This is utilization: ");
		writer.println(u);
		writer.println("This is Wq: ");
		double Wq= workbar;
		writer.println(Wq);
		writer.close();
		
	}
	
    public void doSimulation(){

		int m=10;
    	String filename="m10.txt";
    	docalc(m, filename);

    	m=100;
        filename="m100.txt";
    	docalc(m, filename);
    
    	m=1000;
    	filename="m1000.txt";
    	docalc(m,filename);
    
    	m=10000;
    	filename="m10000.txt";
    	docalc(m, filename);
    
    	m=100000;
    	filename="m100000.txt";
    	docalc(m, filename);
    	
    	
    	

   

    }
 

  	//function to calculate utilization
  	private static double calcU(double m, double[] a, double[] s, double[] work){
  		int calc=1; 
  		double abar=0; 
  		double sbar=0;
  	
  		while(calc < m){
  			abar+=a[calc];
  			sbar+=s[calc];
  			workbar+=work[calc];
  			calc++;
  			System.out.println(sbar);
  			System.out.println(abar);
  		}
  		abar=abar/m;
  		sbar=sbar/m;
  		workbar=workbar/m;
  		System.out.println(workbar);
  		System.out.println(sbar);
  		double util=sbar/abar;
  		System.out.println(util);
  		 return util;
  	}
  	
  	//function for Wq or the work in the queue
  	public static double calcWq(double Ts, double util){
  		double mu = 1/Ts;
  		return (util)/(mu*(1-util)); 
  		
  		
  	}

  	//main function for 	
  	

      private static double getRandom(double x, int i) { 
         // expected values dist: 1/m sum (an) and 1/m sum(sn)
      	//expected value will be equal to -Taln(x) via
      	//1-e^(-lambda*t)
      	double a = 200;
      	double u;
      	double operator1;
      	double operator2; 
      	operator1= Math.log(x);
      	operator2= operator1*a;
      	//operator2= Math.abs(operator2);
      	//x= -a*ln(x);
      	
      	u = operator2/i;
      	return u;
      }		
      	
      
}

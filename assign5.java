package rng;
import java.io.*;
import java.util.*;
import java.lang.Math;

public class assign5 {
	
	
	//Rachel McGuigan
	//Random number generator to test a simulated server FIFO queue
	//variables Assignment 5
	//
public static double T = 0;// period of time over which the system is measured.
public static double A = 0;// number of arrivals in time T.
public static double C = 0; //number of completions in time 
//public static double T = 0;//arrival rate.
public static double X = 0; //throughput rate.
public static double B = 0;//server busy time.
public static double U = 0;//server utilization.
public static double Ts = 0;// mean service time per customer.
public static double L = 0; //average number of customers in the system.
public static double W = 0; //average time of the customers spent in the system.
public static double Lq = 0; //average number of customers queued in the system.
public static double Wq = 0; //mean queueing time.

/*Arrival rate:   = A=T

  Throughput rate: X = C=T

//ow balance: U =  T s
//Lq =  W q*/
	
	
    public void doSimulation(){
		
	//initialize the vars  */
	double Ta = 200.0, Ts =180.0, te = 1000000.0, t1, t2, tn, tb = 0, s, time;
	//double B, C, L, s, tb, U, W, X,
	int n = 1;s=0;
	t1 = 0.0; t2 = te; time = 0.0; tn = time;
	

   //call first event t1= getRandom, t2=getRandom
	t1= getRandom(727633698, n);
	t2 = getRandom(276090261, n);
	System.out.print(t1); System.out.print(t2);

   // do this by calculate the first two seeds t1 and t2 first i
 int i = 0;
   while (time < te){
	   printC(C, t1, t2, tn, tb); 
   	if (t1 < t2){// the event has arrived
   		n++;
   		time=t1;
   		tn=time;
   		s+= n*(time - tn);
   		System.out.println("s:  ");
   		System.out.println(s);
   		t1= time + getRandom(Ta, n);
   		//if queue is empty time=total time->
   		System.out.println("This is new");
   		System.out.print(n);
   		if(n==1){
   			tb=time; 
   			t2= time + getRandom(Ts,n);}
   	}
   	else{// the next event is completed
   		i++;
   		 time=t2;
   		 s += n*(time - tn); 
   		 n--;
   		 tn = time;
   		 C++;
   		//When the simulation completes, the average number in the system is computed by dividing s by the observation period length, and the average residence time then computed using Little’s Law.
   		//print out each C here
   		 printC(C, t1, t2, tn, tb); 
   		 if (n > 0) {
   			t2 = time + getRandom(Ts, n);
   			}
   		else{ 
   			t2 = te;
   			B += time - tb;
   			}
   		}
   		}
   //end while
   X = C / time;System.out.println("throughput ="); System.out.println(X);
   U = B / time; System.out.println("utilization ="); System.out.println(U);
   L = s / time; System.out.println("mean no. in system ="); System.out.println(L);
   W = L / X; System.out.println("mean residence time ="); System.out.println(W);
  
   //print out: i, Ci, Interarrival time, Service time, Ai, Si, wi
   //?????need to compute wis
   
   //print out m/m/i Queue
   System.out.println("This is p:");
   double z= calcU(Ts, i);
   System.out.println(z);
   System.out.println("This is Wq:");
   double o= calcWq(Ts, z);
   System.out.println(o);
    }
  //function to generate t1 s t2 a since they both have same behavior

  	//function to calculate utilization
  	private static double calcU(double s, double t){
  		double calc; 
  		 calc=s/t;
  		 return calc;
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
      
      private void printC(double v, double time1, double time2, double tn, double tb){
    	 System.out.println("      ");
      	System.out.println("i Ci Interarrival time Service time  Ai Si wi");
      	System.out.println(v);
      	System.out.println(v);
      	System.out.println(time1);
      	System.out.println(time2);
      	System.out.println(tb);
      	System.out.println(tn);
      	System.out.println(tb-tn);
      	
      }

}

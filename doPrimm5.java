package node;

import java.io.IOException;

public class doPrimm5 {
	public static void main (String[] args) throws Exception{
		
		readfile5 r = new readfile5();
		r.openFile5();
		r.readFile5();
		r.closeFile5();
		r.getA();
	
		r.closeFile5();
		r.CalPrimm();
		r.printFinal();
		
		//given 
	}
}

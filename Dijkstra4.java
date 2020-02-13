package node;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

class Dijkstra4
{
	public static BufferedReader br;
	//define buffer
	public static char[] buf = new char[1024];
    public static int numRead=0;
    public static int startV;
	public static int endV;
	public static int cost = 0;
	static int[][] costmulti = new int[100][100];
	
	
	
	public static void main (String[] args) throws IOException{
		

		
		/*readfile r = new readfile();
		r.openFile();
		r.readFile();
		r.closeFile();*/
	
		 try {
				BufferedReader br = new BufferedReader(new FileReader("input.txt"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 StringBuffer fileData = new StringBuffer();
		String[] arrayofstrings;
		
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
			while((numRead=reader.read(buf)) != -1){
	            String readData = String.valueOf(buf, 0, numRead);
	            fileData.append(readData);
	            System.out.println(readData);
	           arrayofstrings = readData.split("\\n");
	           
	           int n = 0;
	           //while each line read 
	           System.out.println(arrayofstrings.length + "arraystringlength");
				while(n != arrayofstrings.length){
					System.out.println(arrayofstrings[n]);
					
					if(n == 0){
						int start=Integer.parseInt(arrayofstrings[n]);
						startV=start;
						System.out.println(start + "<-startnode");
						n=n+1;
					}
					if(n == 1){
						int end=Integer.parseInt(arrayofstrings[n]);
						endV=end;
						System.out.println(end + "<-destination node");
						n=n+1;
					}
					//create cost array
					if(n>1){
						String[] temp;
						int [] temp2 = new int[3];
						temp=arrayofstrings[n].split("\\s++");
						for(int i=0; i < 3; i++){
							temp2[i]=Integer.parseInt(temp[i]);
						}
						for(int row =0; row <100; row++){
							if(row == temp2[0]){
								for(int col=0; col <100; col++){
									if(col == temp2[1]){
										costmulti[row][col]= temp2[2];
										System.out.println(row + "<" + col + "<" + costmulti[row][col] +  "<-- cost multi!");
									}
									
								}
							}
						}
						n=n+1;
					}
				}
				n=n+1;
					
			}	
		//cost matrix has been built
		//now find min in each row calc cost
	int child=0;
	int tempcost=0; 
	int min=0; 
	int[] path= new int[1000];
	int[] pathchild= new int[1000];
	
	for(int parent = 0; parent < 100; parent++){	
		for(child=0; child < 100; child++){
			//System.out.println(costmulti[parent][child] + "<" + parent + "<" + child);
	
					if(costmulti[parent][child] != 0){
						//compare, and add
					System.out.println("I Found an edge");
				
						if((costmulti[parent][child] < pathchild[parent]) || (parent == path[parent])){
							//if the new path is less than the previous, subtract and add new min
							cost= cost - pathchild[parent] + costmulti[parent][child];
							path[parent]=parent;
							pathchild[parent]=costmulti[parent][child];
							System.out.println("<--I changed my path");
							
						}
						path[parent+1]=parent;
						pathchild[parent]=child;
						cost=tempcost + costmulti[parent][child];
						System.out.println(path[parent]);
						System.out.println(cost + "<--new cost");
						//print out T and D array
						System.out.println("T {");
						int fi = 0;
						while(fi != 7){
							System.out.print(path[fi] + ",");
							fi++;
						}	
						System.out.println("}\n");
						
						int fin = 0; 
						System.out.println("D {");
						while(fin != 7){
							System.out.print(pathchild[fin] + ",");
							fin++;
						}
						System.out.println("}\n");
						
						
					}	
				
				
			}//endchild loop	
		
		if(parent==5){
			System.out.println("BROKE loop end");
			break;
			
		}
		}//end parent loop
	
	
	System.out.println("this is the final cost:" + (cost));
	System.out.println("T {");
	int fi = 0;
	while(fi != 7){
		System.out.print(path[fi] + ",");
		fi++;
	}	
	System.out.println("}\n");
	
	int fin = 0; 
	System.out.println("D {");
	while(fin != 7){
		System.out.print(pathchild[fin] + ",");
		fin++;
	}
	System.out.println("}\n");
	
	}	
	
					
	}					

					
						
					


			
		
		
	


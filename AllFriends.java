package Homework7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AllFriends {
	

	
	public static void directFriends(String name,String[]names,String[]numbers, int num){
	ArrayList<String> indirect = new ArrayList<String>();
	
	if (num==0){
		for (int i=0;i<names.length;i++){
			if(names[i].equalsIgnoreCase(name)){
				for(int j=0;j<numbers[i].length();j++){
					if(numbers[i].charAt(j)=='1'){
						System.out.println(name+" is friends with "+names[j]);
						//indirect.add(names[j]);//New stuff
					}
				}
			}
		}
	}
	else//New Stuff
		/*for(int f=0;f<indirect.size();f++){
			directFriends(indirect.get(f),names,numbers,0);//System.out.println(name+" is friends with "+names[j]);
		}
		 * 
		 * 	 
		 */
		for (int i=0;i<names.length;i++){
			if(names[i].equalsIgnoreCase(name)){
				for(int j=0;j<numbers[i].length();j++){
					if(numbers[i].charAt(j)=='1'){
						indirect.add(names[j]);//New stuff
						System.out.println("1");
						if(j==numbers[i].length()-1 && i==names.length-1){
							for(int f=0;f<indirect.size();f++){
							
								directFriends(indirect.get(f),names,numbers,0);
							}
						}
						else {
							continue;}
					}
				}
			}
		}
	}
	

	
	
	public static void main(String[] args) throws IOException {
		
		//Initialize Counter
		int counter=0;
	
	// Open the file
		FileInputStream fstream = new FileInputStream("C:/CodeRepository/CS 342 Homework/src//Homework7/friends.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

	String preLine;

	//Read File Line By Line
		while ((preLine = br.readLine()) != null)   {
			if (!preLine.isEmpty()) {
	  // Put in Array add to counter
			counter++;}
	}

	//Close the input stream
		br.close();
	
	//Create String lines List
		String[] lines = new String[counter];
	
	// Open the file
		fstream = new FileInputStream("C:/CodeRepository/CS 342 Homework/src/Homework7/friends.txt");
		br = new BufferedReader(new InputStreamReader(fstream));

		int counter2 = 0;
	
	//Read File Line By Line
		while ((preLine = br.readLine()) != null)   {
			  // Put in Array , if line isnt empty
			if (!preLine.isEmpty()) {
			   lines[counter2] = preLine;
			   counter2++;}
			else
				continue;
			}

	//Close the input stream
		br.close();
		
	//Edited Array
		String[] eLines = new String[counter];
		
	//Remove Spaces
		for (int i=0;i<lines.length;i++){
				eLines[i]=lines[i].replaceAll("\\s","");
		}
	
	//Number of People
		final int PEOPLE = Character.getNumericValue((eLines[1].charAt(0)));
	
	//People maker
	String[] names = new String[PEOPLE];
	for ( int t=0;t<PEOPLE;t++){
		names[t]="";
	}
	
	//For numbers
	String[] numbers = new String[PEOPLE];
	for ( int t=0;t<PEOPLE;t++){
		numbers[t]="";
	}
	
	//Fill Number and Name Array
		for (int i=2;i<eLines.length;i++) {
			for(int j=0;j<eLines[i].length();j++){
				if (Character.isAlphabetic(eLines[i].charAt(j))){
					names[i-2]+=eLines[i].charAt(j);
				}
				else {
					numbers[i-2]+=eLines[i].charAt(j);
				}
					
			}
		}
   //Blah Blah
		directFriends("Smith", names, numbers,1);
		
	}
}

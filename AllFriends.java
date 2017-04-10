package Homework7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class AllFriends {
	

	
	public static void directFriends(String name,String[]names,String[]numbers, int num){
	ArrayList<String> indirect = new ArrayList<String>();
	
	if (num==0){
		//Go through names array
		for (int i=0;i<names.length;i++){
			//If name entered is within the array
			if(names[i].equalsIgnoreCase(name)){
				//Look at the corresponding numbers array
				for(int j=0;j<numbers[i].length();j++){
					//If the current character is a 1
					if(numbers[i].charAt(j)=='1'){
						System.out.println(name+" is friends with "+names[j]);
						
					}
				}
			}
		}
	}
	else
		//Go through names array
		for (int i=0;i<names.length;i++){
			//To see if name entered is the same as a name from the list
			if(names[i].equalsIgnoreCase(name)){
				//For each character in the individual number String
				for(int j=0;j<numbers[i].length();j++){
					//Check if it's a 1(Friends)
					if(numbers[i].charAt(j)=='1'){
						//Then add this friend to the group of people needed to be friend searched 
						indirect.add(names[j]);//New stuff
						//If 
						if(j==numbers[i].lastIndexOf("1") ) {
						
							for(int f=0;f<indirect.size();f++){
								num--;
								directFriends(name,names,numbers,num);
								System.out.println("Indirect Friends of "+name+":");
								directFriends(indirect.get(f),names,numbers,num);
								
							}
						}
						
					}
				}
			}
		}
	}
	

	
	
	public static void main(String[] args) throws IOException {
		
	//Initialization of Variable
		int counter=0;
		String option=null;
		Scanner input = new Scanner(System.in);
		
	//ArrayL
		ArrayList<String> namesCont = new ArrayList<String>();
	
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
	//Array List Maker
		for(int i=0;i<names.length;i++){
			namesCont.add(names[i]);
		}
   //Program
		System.out.print("Enter then name of a person whose friends you want to find (enter 0 for exit): ");
		option = input.next();
		while(!option.equalsIgnoreCase("0")) {
			
				if(namesCont.contains(option)){
					directFriends(option,names,numbers,1);
					System.out.print("Enter then name of a person whose friends you want to find (enter 0 for exit): ");
					option = input.next();
				}
				else {
					System.out.print("Invalid name request, Enter then name of a person whose friends you want to find (enter 0 for exit): ");
					option = input.next();
					
				}
				
			}
		System.exit(0);
		}
		
		
	}


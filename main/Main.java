package main;

import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a number greater than or equal to 1.");
		int size = scan.nextInt();
		while(size < 1) {
			size = scan.nextInt();
			System.out.println("Please reenter");
			
		}
		Grid grid = new Grid(size);
	}

}

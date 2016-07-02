//CSC402 HW5
//@author DACHI XU

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;

public class MaxStockApp {
	public static void main(String args[]){
		String fname;
		int M;
		MyMinPQ<Djia> djiaPQ = new MyMinPQ<Djia>();
		
		System.out.println("This program finds the N lowest closing averages in a");
		System.out.println("file of Dow Jones Industrial Average closing records.\n");
		
		
		Scanner fin = new Scanner(System.in);
		System.out.print("Stock file: ");
		fname = fin.nextLine();
		
		System.out.print("Higest M closing averages. M: ");
		M = Integer.parseInt(fin.nextLine());
		
		Scanner fileScan = new Scanner(fname);
		try { 
			fileScan = new Scanner(new FileReader(fname));
		} catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}
		
		while (fileScan.hasNextLine()){
			String singleLine = fileScan.nextLine();
			String lineSeperated[] = singleLine.split(",");
			Djia tempDjia = new Djia(lineSeperated[0],Double.parseDouble(lineSeperated[1]),Double.parseDouble(lineSeperated[1]));
			djiaPQ.insert(tempDjia);
		}
		
		if (M > djiaPQ.size()){
			M = djiaPQ.size();
		}
		
		System.out.println();
		Iterator djiaIter = djiaPQ.iterator();
		for(int i = 0; i < M; i++){
			Djia temp = (Djia) djiaIter.next();
			System.out.printf("Higest average:\t%f, Date: %s\n",temp.closing(),temp.date());
		}
		
	}
}

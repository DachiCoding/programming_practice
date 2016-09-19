/*
 * Description: BalancedApp contains method to check whether the delimiters '{','}','[',']','(',')' in an input while are balanced.
 * Author: Dachi Xu
 * Class: BalancedApp
 */

import java.util.Scanner;
import java.util.Stack;
import java.io.FileNotFoundException;
import java.io.FileReader;

//wrapper class
public class BalancedApp {
	
	//delimiter class
	public class DelimPos {
		private char openDelim;
		private int linenum;
		
		//constructor
		public DelimPos()
		{}
		
		public DelimPos(char delim,int line)
		{
			openDelim = delim;
			linenum = line;
		}
		
		//check if the open and close delimiters are matching.
		public boolean match(char closeDelim)
		{
			if (openDelim == '(' && closeDelim == ')') return true;
			if (openDelim == '[' && closeDelim == ']') return true;
			if (openDelim == '{' && closeDelim == '}') return true;
			return false;
		}
		
		//return the delimiter line number
		public int line()
		{
			return linenum;
		}
	}
	
	public static void checkBalance(String fname){
		int lineNum = 1;
		boolean ifBalance = true;
		Stack<DelimPos> delimStk = new Stack<DelimPos>();
		
		//Read file and the open delimiters, push to the stack
		Scanner fileScan = new Scanner(fname);
		try { 
			fileScan = new Scanner(new FileReader(fname));
		} catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}
		
		fileScan.useDelimiter("");
		
		while(fileScan.hasNext())
		{
			char ch = fileScan.next().charAt(0);
			BalancedApp ba = new BalancedApp();
			BalancedApp.DelimPos testdelim = ba.new DelimPos();
			
			//counting line number
			if (ch == '\n')
				lineNum++;
			
			//reading delimiters
			if (ch == '{' || ch == '[' || ch == '(')
			{
				
				BalancedApp.DelimPos currdelim = ba.new DelimPos(ch, lineNum);
				delimStk.push(currdelim);
			}
			
			//if read close delimiters, check if match
			if (ch == '}' || ch == ']' || ch == ')')
			{
				//if the stack still has elements
				if (delimStk.isEmpty() == false)
				{
				 testdelim = delimStk.pop();
				 if (testdelim.match(ch) != true)
				 {
					 System.out.println("Line " + lineNum + ". Symbol '" + ch + "' is the wrong closing symbol for char = '" +
							 			 testdelim.openDelim + "'," + testdelim.line());
					 ifBalance = false;
				 }
				}
				
				//if the stack is empty 
				else 
				{
					System.out.println("Line " + lineNum + ". Closing character '" + ch + "', with no matching opening character.");
					ifBalance = false;
				}
			}
		}
		
		if (delimStk.isEmpty() == false)
		{
			BalancedApp.DelimPos unbadelim = delimStk.pop();
			System.out.println("At the end of file, no closing symbol found for the cahr = '" + unbadelim.openDelim +
						       "', line" + unbadelim.line());
			ifBalance = false;
		}
		
		if (ifBalance == true)
		{
			System.out.println(" 1.This file has balanced curly braces, square brackets");
			System.out.println(" 2.and parentheses: {}, [] and (). [Note that these");
			System.out.println(" 3.characters are not required to balance on the");
			System.out.println(" 4.same line, as long as there is a matching closing character.]");
			System.out.println();
			System.out.println("Input is balanced.");
		}
		
		/* Error Case 1 Does not have end
		[This ({line} is balanced) ],
		but this character ] is not.
		 */
		
		/* Error Case 2 Does not have open
		(This left parenthesis
		is not "closed"! [Balanced
		square brackets], then a }
		 */
		
		/* Error Case 3 Does not match
		 Opening square
		 bracket, [, is not matched
		 when end of file reached.
		 */
	}
	
	public static void main(String args[]){
	/*
	 * Test Client of the BalacnedApp class
	 * @param input file name
	 * @return whether if the delimiter are balanced
	 * @throws	
	 */
	
		//read the file name for balance check
		Scanner fin = new Scanner(System.in);
		System.out.print("Please enter your file name:");
		String fname = fin.nextLine();
		
		//check whether the delimiters are balanced in the file
		checkBalance(fname);
	}
}

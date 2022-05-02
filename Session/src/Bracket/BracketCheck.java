package Bracket;
import java.util.Scanner;
import java.util.Stack;

public class BracketCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ina =new Scanner(System.in);
//		System.out.println("Enter the bracket sequence");
		
//		String seq=ina.nextLine().trim();
		String seq="([[{}])";
		
		if(isbalance(seq)) {
			System.out.println("Balanced bracket sequence");
		}
		else {
			System.out.println("Not balanced bracket sequence");
		}
		
		ina.close();

	}
	
	static boolean isbalance(String bracketSeq) 
	{
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i<bracketSeq.length();i++) 
		{
			char character = bracketSeq.charAt(i);
			
			if(character == '(' || character=='[' || character=='{')
			{
				stack.push(character);
				continue;
			}
			
			System.out.println(stack);
			
			
			if (stack.isEmpty())
				return false;
		    
			char c;
			
			switch(character) {
			case ')':
				c=stack.pop();
				if(c== '{' || c=='[')
					return false;
				break;
			case ']':
				c=stack.pop();
				if(c== '{' || c=='(')
					return false;
				break;
			case '}':
				c=stack.pop();
				if(c== '(' || c=='[')
					return false;
				break;
			}
		}
		return (stack.isEmpty());
	}
	

}

import java.util.Scanner;

public class Balance {
	private LinkedStack<Character> stack;
	private char pairChar; 
	private boolean isPair, isOpen, isClosed;

	private final static char PARENTHESIS = 'P'; 
	private final static char CURLYBRACES = 'C';
	private final static char BRACKETS = 'B';
	private final static char ARROWS = 'A';

	public static void main(String[] args) {
	    {
	        String expression, again;
	        boolean result;
	    
	        Scanner in = new Scanner(System.in);
	      
	        do
	        {  
	            Balance tester = new Balance();
	            tester.definePair('(', ')');
	            tester.definePair('[', ']');
	            tester.definePair('{', '}');
	            tester.definePair('<', '>');
	            
				System.out.println("Enter a string with ()'s: ");
	            expression = in.nextLine();
	            
	            result = tester.isBalanced(expression);
	            
	            System.out.println("\nThat expression " + (result ? "is balanced" : "is NOT balanced"));

	            System.out.print("Evaluate another expression [Y/N]? ");
	            again = in.nextLine();
	            System.out.println();
	        
	           
	        }
	        while (again.equalsIgnoreCase("y"));
	        
	        in.close();
	  }
	}
	
	public Balance() {
		stack = new LinkedStack<Character>();
	}	
	
	public boolean isBalanced(String s) { 
		char a = 'a';	
		
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
				case '(': 
					if (isOpen) {
					stack.push(a);
					System.out.print(a++);
					} 
					break;
				case ')':
					if (isClosed) {
					if (stack.size() == 0 || (pairChar != PARENTHESIS)) return false;
					System.out.print(stack.pop().charValue());
					}
					break;
				case '{': 
					if (isOpen) {
					stack.push(a);
					System.out.print(a++);
					}
					break;
				case '}':
					if (isClosed) {
					if (stack.size() == 0 || (pairChar != CURLYBRACES) || isPair != true) return false;
					System.out.print(stack.pop().charValue());
					} 
					break;
				case '[': 
					if (isOpen) {
					stack.push(a);
					System.out.print(a++);
					}
					break;
				case ']':
					if (isClosed) {
					if (stack.size() == 0 || (pairChar != BRACKETS)) return false;
					System.out.print(stack.pop().charValue());
					}
					break;
				case '<': 
					if (isOpen) {
					stack.push(a);
					System.out.print(a++);
					}
					break;
				case '>':
					if (isClosed) {
					if (stack.size() == 0 || (pairChar != ARROWS)) return false;
					System.out.print(stack.pop().charValue());
					}
					break;
				default:
					System.out.print(' ');
			}
			
		}
		return stack.isEmpty();
	}
	
	
	public void definePair(char open, char closed) 
	{
		char symbol = 0;
		switch (symbol) {	
		case '(':
		case '{': 
		case '[':
		case '<':
		{
			
			isOpen = true;
			
		}
		case ')':
		case '}':
		case ']':
		case '>':
		{ 
			isClosed = true;
		
		}
	}
			
	if (open == '(' && closed == ')') 
	{ 
		pairChar = PARENTHESIS;
		isPair = true;
	}
	else isPair = false;
	
	
	
	if (open == '[' && closed == ']') 
	{ 
		pairChar = BRACKETS;
		isPair = true;
	}
	else isPair = false;
	
	
	
	if (open == '{' && closed == '}') 
	{ 
		pairChar = CURLYBRACES;
		isPair = true;
	} else isPair = false;
	
	
	
	if (open == '<' && closed == '>') 
	{ 
		pairChar = ARROWS;
		isPair = true; }
	else isPair = false;
		
	}
	
}


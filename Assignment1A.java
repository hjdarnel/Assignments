// @author Henry Darnell
// id 010646670
// assignment 1a
// algorithms - beavers

public class Assignment1A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Assignment1A Assignment1A = new Assignment1A();
		
		//Given the below test cases
		
		System.out.println(Assignment1A.solve("1+2"));
		System.out.println(Assignment1A.solve("3/2"));
		System.out.println(Assignment1A.solve("000000000014/00000000002"));
		
	}
	
	public int solve(String input){		
		char operator = getOperator(input);
		int lhs = getLHS(input, operator);
		int rhs = getRHS(input, operator);
		
		return doOperation(lhs, rhs, operator);
	}

	private char getOperator(String input){	
		for(int i = 0; i < input.length(); i++){
			if (input.charAt(i) == '*')
				return '*';
			if (input.charAt(i) == '/')
				return '/';
			if (input.charAt(i) == '+')
				return '+';
			if (input.charAt(i) == '-')
				return '-';
		}
		return 'a';
	}
	

	private int getLHS(String input, char operator) {
		String lhs = " ";
		for (int i = 0; i < input.length(); i++){
			lhs = input.substring(0,i);
			if(input.charAt(i) == operator)
				break;
		}
		return Integer.parseInt(lhs);
	}
	
	private int getRHS(String input, char operator) {
		String rhs = " ";
		int rhsStart = 0;
		for(int i = 0; i < input.length(); i++){
			rhsStart = i;
			if (input.charAt(i) == operator){
				rhsStart++;
				break;
			}
		}
		rhs = input.substring(rhsStart);
		return Integer.parseInt(rhs);
	}
	
	private int doOperation(int lhs, int rhs, char op){
		int result = 0;
		
		if (op == '*')
			result = (lhs * rhs);
		if (op == '/')
			result = (lhs/rhs);
		if (op == '+')
			result = (lhs + rhs);
		if (op == '-')
			result = (lhs - rhs);
		
		return result;
	}
}

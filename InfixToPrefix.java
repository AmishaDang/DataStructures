import java.util.Stack;

public class InfixToPrefix {
	public static char[] reverse(char[] str,int start, int end) {
		char temp;
		while(start<end) {
			temp = str[start];
			str[start]=str[end];
			str[end]=temp;
			start++;
			end--;
		}
		//System.out.println(str);
		return str;
	}
	public static boolean isOperator(char ch) {
		if((ch>='a'&&ch<='z') ||(ch>='A'&&ch<='Z') || (ch>='0' && ch<='9'))
			return false;
		else
			return true;
	}
	public static int getPriority(char ch) {
		if(ch=='+' || ch=='-')
			return 1;
		else if(ch=='*' || ch=='/' || ch=='%')
			return 2;
		else if(ch=='^')
			return 3;
		return 0;
	}
	public static String infixToPostfix(char[] infix, int l) {
		Stack<Character> stack = new Stack<>();
		String output="";
		for(int i=0;i<l;i++) {
			if(!(isOperator(infix[i])))
				output+=infix[i];
			else if(infix[i]=='(')
				stack.push(infix[i]);
			else if(infix[i]==')') {
				while(stack.peek()!='(') {
					output+=stack.pop();
				}
				stack.pop();
			}
			else {
				if(stack.isEmpty() || (getPriority(stack.peek())<getPriority(infix[i])))
					stack.push(infix[i]);
				else {
					while(!stack.isEmpty() && getPriority(stack.peek())>=getPriority(infix[i])) {
						output+=stack.pop();
					}
					stack.push(infix[i]);
				}
			}
		}
		while(!stack.isEmpty()) {
			output+=stack.pop();
		}
		//System.out.println(output);
		return output;
	}
	public static String infixToPrefix(String infix) {
		int l = infix.length();
		char[] infix1=reverse(infix.toCharArray(),0,l-1);

		for(int i=0;i<l;i++) {
			if(infix1[i]=='(')
				infix1[i]=')';
			else if(infix1[i]==')')
				infix1[i]='(';
		}
		//System.out.println(infix1);
		char[] prefix = (infixToPostfix(infix1, l)).toCharArray();
		prefix = reverse(prefix,0,prefix.length-1);
		return String.valueOf(prefix);
	}
	public static void main(String[] args) {
		String infix = "a+b*(c^d-e)";
		System.out.println(infixToPrefix(infix));
		//String infix2 = "(a-b/c)*(a/j-p)";
		//System.out.println(infixToPrefix(infix2));
	}
}
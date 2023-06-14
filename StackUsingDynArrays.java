package DataStructures;
class ArrayStack{
	int stack[];
	int top;
	int size;
	
	public ArrayStack(int size){
		this.size = size;
		this.stack = new int[size];
		top=-1;
	}
	public void push(int el) {
		if(isFull())
			System.out.println("Stack overflow!");
		else {
			stack[++top]=el;
		}
	}
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack underflow!");
			System.exit(1);
		}
		return stack[top--];
	}
	public boolean isEmpty(){
		return top==-1 ? true : false;
	}
	public boolean isFull() {
		return top==size-1 ? true:false;
	}
	public int topElement() {
		return stack[top];
	}
	public int size() {
		return top+1;
	}
	public void printStack() {
		if(isEmpty())
			System.out.println("Stack underflow!");
		else {
			for(int i=0;i<=top;i++)
				System.out.print(stack[i]+" ");
			System.out.println();
		}
	}
	
}
public class StackUsingDynArrays{
	public static void main(String args[]) {
		ArrayStack ob = new ArrayStack(4);
		ob.push(1);
		ob.push(2);
		ob.push(3);
		ob.push(4);
		ob.printStack();
		ob.pop();
		ob.printStack();
		System.out.println(ob.size());
		System.out.println(ob.topElement());
	}
}
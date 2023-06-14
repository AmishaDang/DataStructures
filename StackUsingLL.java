package DataStructures;
class Node{
	int data;
	Node next;
	Node(){
		
	}
	Node(int data){
		this.data= data;
		this.next=null;
	}
}
class LinkedStack{
	Node top;
	public boolean isEmpty() {
		return top==null ? true:false;
	}
	public void push(Node n) {
		if(top!=null)
			n.next=top;
		top=n;
	}
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty!");
			System.exit(1);
		}
		int temp = top.data;
		top=top.next;
		return temp;
	}
	public int peek() {
		return top.data;
	}
	public void printStack() {
		if(isEmpty())
			System.out.println("Stack is empty!");
		else {
			Node ptr=top;
			while(ptr!=null) {
				System.out.print(ptr.data+" ");
				ptr=ptr.next;
			}
			System.out.println();
		}
	}
}
public class StackUsingLL{
	public static void main(String args[]) {
		LinkedStack obj = new LinkedStack();
		obj.push(new Node(1));
		obj.push(new Node(2));
		obj.push(new Node(3));
		System.out.println(obj.peek());
		obj.printStack();
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		obj.printStack();
	}
}
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
class LLQueue{
	Node front=null, rear=null;
	public void enqueue(Node n) {
		if(front==null)
			front=n;
		else
			rear.next=n;
		rear=n;
	}
	public int dequeue() {
		if(isEmpty()) {
			System.out.println("Stack is empty!");
			System.exit(0);
		}
		Node temp=front;
		front=front.next;
		if(front==null)
			rear=null;
		return temp.data;
	}
	public int peek() {
		return rear.data;
	}
	public void display() {
		Node temp = front;
		while(temp!=rear.next) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	public boolean isEmpty() {
		return front==null?true:false;
	}
}
public class QueueWithLL{
	public static void main(String args[]) {
		LLQueue ob = new LLQueue();
		ob.enqueue(new Node(1));
		ob.enqueue(new Node(2));
		ob.enqueue(new Node(3));
		System.out.println(ob.peek());
		ob.display();
		System.out.println("Deleted element : "+ob.dequeue());
		System.out.println(ob.peek());
	}
}
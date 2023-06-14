package DataStructures;
class Queue{
	int size;
	int queue[];
	int front,rear;
	Queue(int size){
		this.size = size;
		queue=new int[size];
		front= rear=-1;
	}
	public boolean isFull(){
		return (front==0 && rear+1 ==size) ? true:false;
	}
	public boolean isEmpty(){
		return front==-1 ? true:false;
	}
	public void Enqueue(int el) {
		if(isFull())
			System.out.println("Queue is full!");
		else {
			if(front==-1)
				front++;
			queue[++rear]=el;
		}
	}
	public int Dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is empty!");
			System.exit(0);
		}
		if(rear==0)
			front--;
		return queue[rear--];
	}
	public int peek() {
		return queue[rear];
	}
	public int size() {
		return rear+1;
	}
	public void printQueue() {
		for(int i =0;i<=rear;i++)
			System.out.println(queue[i]);
	}
}

public class QueueUsingArray {

	public static void main(String[] args) {
		Queue ob = new Queue(3);
		ob.Enqueue(1);
		ob.Enqueue(2);
		ob.Enqueue(3);
		ob.Enqueue(4);
		System.out.println(ob.peek());
		ob.Dequeue();
		ob.printQueue();
	}

}

package DataStructures2;

import java.util.ArrayList;
import java.util.LinkedList;

class HashMap<K,V>{
	class Node{
		K key;
		V val;
		public Node(K key,V val) {
			this.key=key;
			this.val = val;
		}
	}
	int N;                                     //buckets or size of hash-table
	int n;                                     //nodes or no. of keys to be inserted
	LinkedList<Node> buckets[];                //Array of LinkedLists
											   //N=buckets.length
	@SuppressWarnings("unchecked")
	public HashMap(int size) {
		this.N=size;
		this.buckets=new LinkedList[size];
		for(int i=0;i<size;i++) {
			this.buckets[i]=new LinkedList<>();
		}
	}
	public void put(K key, V val) {
		int bi = hashFunc(key);                //to find index to store key in the array
		int di = searchInLL(bi,key);           
		if(di==-1) {                           
			buckets[bi].add(new Node(key,val));
			n++;
		}
		else {                                 //if the key is found, update the value
			Node node = buckets[bi].get(di);
			node.val=val;
		}
		double lambda = (double)n/N;
		if(lambda>2.0) {
			rehash();
		}
	}
	public V remove(K key) {
		int bi = hashFunc(key);                //to find index of key in the array
		int di = searchInLL(bi,key);          
		if(di==-1) {                           
			return null;
		}
		else {                                 //if the key is found, return the value
			Node node = buckets[bi].remove(di);
			n--;
			return node.val;
		}
	}
	public V get(K key) {
		int bi = hashFunc(key);                //to find index of key in the array
		int di = searchInLL(bi,key);          
		if(di==-1) {                           
			return null;
		}
		else {                                 //if the key is found, return the value
			Node node = buckets[bi].get(di);
			return node.val;
		}
	}
	public boolean containsKey(K key) {
		int bi = hashFunc(key);                //to find index of key in the array
		int di = searchInLL(bi,key);           //to search if the key exists in the linked list or not
		if(di==-1)                             //if the key is not found
			return false;
		else                                   //if the key is found
			return true;
	}
	@SuppressWarnings("unchecked")
	private void rehash() {
		LinkedList<Node> temp[]=buckets;
		N=N*2;
		buckets=new LinkedList[N];
		n=0;
		for(int i=0;i<buckets.length;i++) {
			buckets[i]=new LinkedList<>();
		}
		for(int i=0;i<temp.length;i++) {
			LinkedList<Node> ll =temp[i];
			for(int j=0;j<ll.size();j++) {
				Node node= ll.get(j);
				put(node.key,node.val);
			}
		}
	}
	private int searchInLL(int bi, K key) {
		for(int i=0;i<buckets[bi].size();i++) {
			if(buckets[bi].get(i).key==key)
				return i;
		}
		return -1;
	}
	private int hashFunc(K key) {
		int bi = key.hashCode();
		return Math.abs(bi)%N;
	}
	public boolean isEmpty() {
		return n==0;
	}
	public ArrayList<K> keySet() {
		ArrayList<K> arr = new ArrayList<>();
		for(int i=0;i<buckets.length;i++) {
			LinkedList<Node> ll = buckets[i];
			for(int j=0;j<ll.size();j++) {
				arr.add(ll.get(j).key);
			}
		}
		return arr;
	}
}
public class Hashing {

	public static void main(String[] args) {
		HashMap<String,Integer> obj =new HashMap<>(4);
		obj.put("India", 100);
		obj.put("US", 150);
		obj.put("Australia", 60);
		obj.put("Italy",30);
		obj.put("Nepal",40);
		obj.put("Canada",130);
		obj.put("Switzerland", 250);
		obj.put("Dubai", 50);
		obj.put("Ukraine", 160);
		obj.put("Indonesia",70);
		obj.put("Nagaland",110);
		obj.put("Sydney",90);
		
		ArrayList<String> keys = obj.keySet();   //to get all the keys in an ArrayList
		for(int i=0;i<keys.size();i++) {
			System.out.println(keys.get(i)+" "+obj.get(keys.get(i)));
		}
		obj.remove("Italy");
		System.out.println(obj.get("Italy"));
		System.out.println(obj.n+" "+obj.N);
		
	}
}

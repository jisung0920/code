package queue;


public class Queue_prob {
<<<<<<< HEAD
	
	Node front;
	Node back;
	
	private class Node{
		int data;
		Node next;
		private Node(int data){
=======
	private Node front;
	private Node back;
	
	private class Node{
		private int data;
		private Node next;
		Node(int data){
>>>>>>> origin/master
			this.data = data;
		}
	}
	public Queue_prob() {
		front = null;
		back = null;
<<<<<<< HEAD
		
	}

	public void enqueue(int data){
		Node nNode = new Node(data);
		if(front == null){
			front = nNode;
			back = nNode;
			front.next = back;
			back.next = null;
		}
		else{
			back.next = nNode;
			back = back.next;
		}
			
	}

	public Node dequeue(){
		if(isEmpty()){
			System.out.println("Node is empty");
			return null;
		}
		else{
			Node tmp = front;
			front= front.next;
			return tmp;
		}
	}

	public void printQueue(){
		if(isEmpty()){
			System.out.println("Node is empty");
		}
		else{
			Node cur =front;
			while(cur != null){
				System.out.print("["+cur.data+"]");
				cur = cur.next;
			}
			System.out.println();
		}
=======
		front.next=back; 
	}

	public void enqueue(int data){
		Node nNode = new Node()
	}

	public Node dequeue(){
		
		return null;
	}

	public void printQueue(){
>>>>>>> origin/master
		
	}

	public boolean isEmpty(){
<<<<<<< HEAD
		if(front == null)
			return true;
		else
			return false;
=======
		if(front == null){
			return true;
		} else {
			return false;
		}
>>>>>>> origin/master
	}

}

package queue;


public class Queue_prob {
	private Node front;
	private Node back;
	
	private class Node{
		private int data;
		private Node next;
		Node(int data){
			this.data = data;
		}
	}
	public Queue_prob() {
		front = null;
		back = null;
		front.next=back; 
	}

	public void enqueue(int data){
		Node nNode = new Node()
	}

	public Node dequeue(){
		
		return null;
	}

	public void printQueue(){
		
	}

	public boolean isEmpty(){
		if(front == null){
			return true;
		} else {
			return false;
		}
	}

}

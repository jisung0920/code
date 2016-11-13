package queue;


public class Queue_prob {
	
	Node front;
	Node back;
	
	private class Node{
		int data;
		Node next;
		private Node(int data){
			this.data = data;
		}
	}
	public Queue_prob() {
		front = null;
		back = null;
		
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
		
	}

	public boolean isEmpty(){
		if(front == null)
			return true;
		else
			return false;
	}

}

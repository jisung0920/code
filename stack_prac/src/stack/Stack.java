package stack;

public class Stack {       
    private Node top; 
    private int s;
    private class Node {
        private String data;
        private Node next;
        Node(String data){
        	this.data = data;
        }
    }

    public Stack() {
    	s =0;
    	top = null;   	
    }


    public int size(){
    	return s;
    }

    public boolean isEmpty(){
    	if(top == null)
    		return true;
    	else
    		return false;
    }

    public void push(String data){
    	Node nNode = new Node(data);
    	if(isEmpty())
    		top = nNode;
    	else{
    		nNode.next =top;
    		top =nNode;
    	}
    	s++;
    }

    public String top() {
    	if(isEmpty())
    		return null;
    	else
    		return top.data;
    }



    public Node pop(){
    	if(isEmpty())
    		return null;
    	else{
    		Node tmp = top;
    		top = top.next;
    		s--;
    		return tmp;
    	}
    }
   


    
    public void printStack(){
    	if(isEmpty())
    		System.out.println("stack is empty");
    	else{
    		Node cur=top;
    		while(cur != null){
    			System.out.print("["+cur.data+"]");
    			cur = cur.next;
    		}
    		System.out.println();
    	}
    		
    }


}

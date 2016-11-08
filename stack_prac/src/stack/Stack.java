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
        top = null;
        s=0;
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
    	if(size()<1)
    		top=nNode;
    	else{
    		nNode.next=top;
    		top=nNode;
    	}
    	s++;
    }

    public String top() {
    	System.out.println("Top data ="+top.data);
    	return top.data;
    }



    public Node pop(){
    	Node tmp = top;
    	top = top.next;
    	s--;
    	return tmp;
    }
   


    
    public void printStack(){
    	Node cur = top;
    	for(int i=0; i<size();i++){
    		System.out.print('['+cur.data+']');
    		cur=cur.next;
    	}
    	System.out.println();
    }


}
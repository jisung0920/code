package tree;


public class BST {
	private Node root=null;
	
	private class Node{
		private int key;
		private Node left_child;
		private Node right_child;
		private Node parent;
		Node(int key){
			this.key = key;
			this.left_child=null;
			this.right_child=null;

		}
	}
	
	public void insert(int key){
		if(this.search(key) != null){
			System.out.println(key + " is already in the tree");
			return;
		}
		Node newNode = new Node(key);	// assume the data is same as key
		Node cur =root;
		Node par = null;
		
		if(root == null){
			root = newNode;
			return ;
		}
		
		
		while(true){
			par = cur;
			if(cur.key>key){
				cur=cur.left_child;
				if(cur==null){ 
					par.left_child=newNode;
					return ;
				}
			}
			else{
				cur = cur.right_child;
				if(cur==null){
					par.right_child=newNode;
					return ;
				}
			}
		}
		
			
	}
	public void delete(int key){
		

		Node par = root;
		Node cur = root;
		boolean dir = true;
		
		if(this.search(key)==null)
			return ;
		
		while(true){	
			if(cur.key==key)
				break;
			par =cur;
			if(cur.key>key){
				cur=cur.left_child;
				dir =true;
			}
			else{
				cur=cur.right_child;
				dir =false;
			}
			
		}//find delete Node
		System.out.println(cur.key);
		
		if(cur.left_child==null && cur.right_child==null){
			if(dir)
				par.left_child=null;
			else if(cur == root)
				root = null;
			else
				par.right_child=null;
			System.out.println("case 1");
		}
		
		else if(cur.left_child !=null && cur.right_child!= null){
			Node scc= cur.left_child;
			Node scc_par = null;
			
			while(scc.right_child!=null){
				scc_par = scc;
				scc=scc.right_child;
			}
			
			scc_par.right_child=null;
		
			cur.key=scc.key;
			
			

			
			System.out.println("case 2 / "+scc.key+"/");
		}
		else{
			Node sub;
			if(cur.left_child!=null)
				sub = cur.left_child;
			else
				sub = cur.right_child;
			
			cur =null;
				
			if(dir)
				par.left_child = sub;
			
			else
				par.right_child =sub;
			
			sub.parent = par;
			System.out.println("case 3 :"+par.key+"/"+sub.key);
			
		}

		
		
	}
	

	public Node search(int key){

		Node cur =root;
		
		while(cur!=null){
			if(cur.key==key)
				return cur;
			else if(cur.key>key)
				cur=cur.left_child;
			else 
				cur= cur.right_child;
		}
		return cur;
	}
	public void printPreorder(Node node){
		if(node == null)
			return ;
		
		System.out.printf("%d ",node.key);
		printPreorder(node.left_child);
		printPreorder(node.right_child);
		
	}
	public void printInorder(Node node){
		if(node == null)
			return ;
		
		printInorder(node.left_child);
		System.out.printf("%d ",node.key);
		printInorder(node.right_child);
			
	}
	public void printPostorder(Node node){
		if(node == null)
			return ;
		printPostorder(node.left_child);
		printPostorder(node.right_child);
		System.out.printf("%d ",node.key);				
	}
	public Node getRoot(){
		return root;
	}
}
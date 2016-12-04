package tree;


public class BST {
	private Node root=null;
	private boolean dir;
	private class Node{
		private int key;
		private Node left_child;
		private Node right_child;
		private Node parent;

		Node(int key){
			this.key = key;
			this.left_child=null;
			this.right_child=null;
			this.parent = null;

		}
		
	}
	
	public void insert(int key){
		Node cur =root;
		if(root == null){
			makeRoot(key);
			return ;
		}
		Node par = cur;
		while(cur !=null){
			par=cur;
			if(cur.key>key){
				cur=cur.left_child;
				dir=true;
			}
			else{
				cur=cur.right_child;
				dir=false;
			}
		}
		if(dir)
			makeLeftNode(par, key);
		else
			makeRightNode(par, key);
	}
	public void delete(int key){
		Node del = search(key);
		if(del==null)
			return ;
		Node par =del.parent;
		if(externalNode(del)){
			if(dir)
				par.left_child=null;
			else
				par.right_child=null;
		}
		else if(del.left_child != null && del.right_child != null){
			Node cur = del.left_child;
			while(cur.right_child !=null)
				cur =cur.right_child;
			replaceNode(del, cur);
		}
		else{
			if(del.left_child !=null)
				replaceNode(del, del.left_child);
			else
				replaceNode(del, del.right_child);
		}

	}
	

	public Node search(int key){
		Node cur = root;
		while(cur != null){
			if(cur.key==key)
				return cur;
			else if(cur.key>key){
				cur=cur.left_child;
				dir =true;
			}
			else{
				cur = cur.right_child;
				dir =false;
			}
		}
		return null;

	}
	public void printPreorder(Node node){
		if(node == null)
			return ;
		System.out.print("["+node.key+"]");
		printPreorder(node.left_child);
		printPreorder(node.right_child);
		
	}
	
	public void printInorder(Node node){
		if(node == null)
			return;
		printInorder(node.left_child);
		System.out.print("["+node.key+"]");	
		printInorder(node.right_child);
	}
	
	public void printPostorder(Node node){
		if(node == null)
			return;
		printPostorder(node.left_child);
		System.out.print("["+node.key+"]");
		printPostorder(node.right_child);
	}
	
	public Node getRoot(){
		return root;
	}
	
	public boolean externalNode(Node node){
		if(node.left_child == null && node.right_child == null)
			return true;
		else
			return false;
	}
	public void makeRoot(int key){
		Node nNode = new Node(key);
		root = nNode;
	}
	
	public void makeLeftNode(Node par,int key){
		Node nNode = new Node(key);
		par.left_child = nNode;
		nNode.parent = par;
	}
	public void makeRightNode(Node par,int key){
		Node nNode = new Node(key);
		par.right_child = nNode;
		nNode.parent = par;
	}
	
	public void replaceNode(Node del,Node cur){
		if(cur == null){
			del = null;
			return ;
		}
		del.key = cur.key;
		if(cur.parent.left_child ==cur)
			cur.parent.left_child =null;
		else if(cur.parent.right_child == cur)
			cur.parent.right_child =null;
	}
	

}

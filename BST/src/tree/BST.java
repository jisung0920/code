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
			newNode.parent=null;
			root = newNode;
			return ;
		}
		
		
		while(true){
			par = cur;
			if(cur.key>key){
				cur=cur.left_child;
				if(cur==null){ 
					newNode.parent=par;
					par.left_child=newNode;

					return ;
				}
			}
			else{
				cur = cur.right_child;
				if(cur==null){
					newNode.parent =par;
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

		
		//cur 는 삭제할 노드, par는 삭제할 노드의 부모노드
		//dir 가 참이면 par의 왼쪽 자식이 cur이다
		
		if(cur.left_child==null && cur.right_child==null){
			if(dir)
				par.left_child=null;
			else if(cur == root)
				root = null;
			else
				par.right_child=null;

		}//자식 노드가 없는 경우
		
		else if(cur.left_child !=null && cur.right_child!= null){
			Node scc= cur.left_child;
			
			while(scc.right_child!=null){
				scc=scc.right_child;
			}
			//삭제할 노드의 대체할 노드 scc 를 찾는다, scc의 부모노드는 scc_par이고 scc_par의 오른쪽 자식 노드가 scc이다

			if(scc!=cur.left_child){
				scc.left_child=cur.left_child;
				scc.right_child= cur.right_child;
			}
			else{
				cur.parent.left_child=scc;
				scc.right_child=cur.right_child;
				return ;
			}

			if(cur == root){
				root=scc;
			}
			else if(dir){
				par.left_child = scc;
			}
			else{
				par.right_child = scc;
			}
			
			scc.parent.right_child=null;

		}//자식노드가 2개 있는 경우
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

			
		}//자식 노드가 1 개인 경우

		
		
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

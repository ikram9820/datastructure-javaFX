package application;

import javax.swing.JOptionPane;

public class Tree <x> {
	public node <x> root;
	public String output;
	public Tree() {
		root=null;
		output="";
	}//end Tree()
	
	public void insert(x item) {
		node <x> temp = new node<x>(item);
		if(isEmpty()) {
			root=temp;
			return;
		}
		
		node<x> cur=root;
		while(cur!=null) {
			node <x> parent=cur;
			if(compare(item,cur.data)==-1)
			{
				cur=cur.left;
				
				if(cur==null) {
					parent.left=temp;
					parent.left.isLeft=true;
				}
			}//end if
			else {
				cur=cur.right;
		
				if(cur==null) {
					parent.right=temp;
					parent.right.isLeft=false;
				}
			}//end else
		}//end while()
		
	}//end insert()
	
	public x delete(x item) {
		if(isEmpty()) {
			JOptionPane.showMessageDialog(null,"Tree is empty");
			return null;
		}
		node<x> curr= root;
		node<x> parent= root ;
		boolean isLeft=true;
		while(curr.data!=item) {
			parent=curr;
			if(compare(item,curr.data)==-1) {
				curr=curr.left;
				isLeft=true;
			}
			else {
				curr=curr.right;
				isLeft=false;
			}
			if(curr==null) {
				JOptionPane.showMessageDialog(null,"node not found");
				return null;
			}
		}//end while()
//case 1
		if(curr.left==null&&curr.right==null) {
			if(curr==root)
				root=null;
			else if(isLeft)
				parent.left=null;
			else
				parent.right=null;
		}//end case 1
		
//case 2 right
		if(curr.left==null&&curr.right!=null) {
			if(curr==root)
				root=curr.right;
			else if(isLeft)
				parent.left=curr.right;
			else
				parent.right=curr.right;
		}//end case 2 right
//case 2 left 
		if(curr.left!=null&&curr.right==null) {
			if(curr==root)
				root=curr.left;
			else if(isLeft)
				parent.left=curr.left;
			else
				parent.right=curr.left;
		}//end case 2 left
//case 3
		if(curr.left!=null&&curr.right!=null) {
			node<x> min = getMin(curr.right);
			curr.data=min.data;
		
			node<x>temp =curr;
			if(temp.right==min)
				temp.right=min.right;
			else {
				temp=temp.right;
				while(temp.left!=min)
					temp=temp.left;
			
			temp.left=min.right;
			
			}
		}//end case 3
		return item;
	}//end delete()
	
	public void bft() {
		Queue<node<x>> q= new Queue<node<x>>(10);
		q.enqueue(root);
		while(!q.isEmpty()) {
			node<x> temp=q.dequeue();
			if(temp.left!=null)
			q.enqueue(temp.left);
			if(temp.right!=null)
			q.enqueue(temp.right);
		}
	}
	
	public node<x> getMin(node<x> curr){
		if(curr==null)
			return null;
		if(curr.left==null)
			return curr;
		
		while(curr.left!=null)
			curr=curr.left;
		
		return curr;
	}
	
	public x search(x item) {

		node<x> cur=root;
		while(cur.data!=item) {
			
			if(compare(item,cur.data)==-1)
			{
				cur=cur.left;
			
			}//end if
			else {
				
				cur=cur.right;
				
			}//end else
			if(cur==null)
				return null;
		}//end while()
		return item;
	}//end search()
	
	public void inorder(node <x> curr) {
		if(curr==null) 
			return;
		inorder(curr.left);
		output+=curr.data +" ";
		inorder(curr.right);		
	}//end inorder()
	
	public String display() {
		output="";
		inorder(root);
		return output;
	}
	 public int compare(x x1, x x2) {
			int prio = 0;
			if (x1 instanceof String) {
				prio = ((String) x1).compareTo((String) x2);

			} else if (x1 instanceof Integer) {
				if ((Integer) x1 > (Integer) x2)
					prio = 1;
				else if ((Integer) x1 < (Integer) x2)
					prio = -1;
				else
					prio = 0;
			}

			else if (x1 instanceof Double) {
				if ((Double) x1 > (Double) x2)
					prio = 1;
				else if ((Double) x1 < (Double) x2)
					prio = -1;
				else
					prio = 0;
			}

			else if (x1 instanceof Float) {
				if ((Float) x1 > (Float) x2)
					prio = 1;
				else if ((Float) x1 < (Float) x2)
					prio = -1;
				else
					prio = 0;
			}

			else
				JOptionPane.showMessageDialog(null, "there is no such type of datatype");

			return prio;
		}//end compare()
	
	 public boolean isEmpty() {
		return root==null;
	}//end isEmpty()
	
}//end Tree

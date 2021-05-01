package application;



import javax.swing.JOptionPane;

class node<T>{
	T data;
	node<T> right;
	node<T> left;
	double x=130,y=0;
	boolean isLeft=false;
	public node(T d) {
		data=d;
	}
	
	public void setRight(T data) {
		right.data=data;
	}
	
	public void setLeft(T data) {
		left.data=data;
	}
}

class LinkedList<X> {

	node<X> start;
	node<X> end;
	int nNodes;

	LinkedList() {
		start = null;
		end = null;
		nNodes = 0;
	}

	public void insertFirst(X item) {
		node<X> temp = new node<X>(item);
		nNodes++;
		if (start == null) {
			start = temp;
			end = temp;
		} else {
			temp.right = start;
			start.left = temp;
			start = temp;
		}
	}

	public void insertLast(X item) {
		node<X> temp = new node<X>(item);
		nNodes++;
		if (start == null) {
			start = temp;
			end = temp;
		} else {
			temp.left = end;
			end.right = temp;
			end = temp;
		}
	}

	public void insertAt(int index, X item) {
		node<X> temp = new node<X>(item);
		if (start == null) {
			start = temp;
			end = temp;
			nNodes++;

			return;
		}

		node<X> curr = getAt(index - 1);
		if (index <= 0) {

			curr.left = temp;
			temp.right = curr;
			start = temp;
			nNodes++;

			return;
		}
		if (curr.right == null) {

			curr.right = temp;
			temp.left = curr;
			end = temp;
			nNodes++;

			return;
		}

		temp.left = curr;
		temp.right = curr.right;
		curr.right.left = temp;
		curr.right = temp;
		nNodes++;

	}

	public void insertIn(X item) {
		node<X> temp = new node<X>(item);
		nNodes++;
		if (start == null) {
			start = temp;
			end = temp;
			return;
		}

		node<X> curr = start;
		while (curr != null && compare(curr.data, item) != 1) {
			curr = curr.right;
		}
		if (curr == null) {
			temp.left = end;
			end.right = temp;
			end = temp;
			return;
		}
		if (curr == start)
			start = temp;
		temp.right = curr;
		temp.left = curr.left;
		if (curr.left != null)
			curr.left.right = temp;
		curr.left = temp;

	}

	 public int compare(X x1, X x2) {
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
	}

	public X deleteFirst() {
		if (isEmpty()) {
			JOptionPane.showMessageDialog(null, "list is empty");
			return null;
		}

		X data = start.data;
		start = start.right;
		start.left = null;
		if (start == end)
			end = end.left;
		return data;
	}

	public X deleteLast() {
		if (isEmpty()) {
			JOptionPane.showMessageDialog(null, "list is empty");
			return null;
		}

		X data = end.data;
		end = end.left;
		end.right = null;
		if (start == end)
			start = start.right;
		return data;
	}

	public X deleteAt(int index) {
		if (isEmpty()) {
			JOptionPane.showMessageDialog(null, "list is empty");
			return null;
		}

		node<X> temp = getAt(index);
		X item = temp.data;

		if (temp == start) {
			start = temp.right;
			if (start != null)
				start.left = null;
			return item;
		}
		if (temp == end) {
			end = temp.left;
			if (end != null)
				end.right = null;
			return item;
		}
		temp.right.left = temp.left;
		temp.left.right = temp.right;

		return item;

	}

	public X delete(X item) {
		if (isEmpty()) {
			JOptionPane.showMessageDialog(null, "list is empty");
			return null;
		}
		node<X> temp = find(item);
		if (temp == null) {
			return null;
		}
		if (temp == start) {
			start = temp.right;
			if (start != null)
				start.left = null;
			return item;
		}
		if (temp == end) {
			end = temp.left;
			if (end != null)
				end.right = null;
			return item;
		}
		temp.right.left = temp.left;
		temp.left.right = temp.right;

		return item;
	}

	public node<X> find(X item) {
		if (isEmpty()) {
			JOptionPane.showMessageDialog(null, "list is empty");
			return null;
		}
		node<X> temp = start;
		while (temp.data != item) {

			if (temp.right == null) {
				return null;
			}
			temp = temp.right;
		}
		return temp;
	}

	public void insertionSort() {
		if (isEmpty()) {
			JOptionPane.showMessageDialog(null, "list is empty");
			return;
		}

		node<X> curr = start;
		start = null;
		while (curr != null) {
			insertIn(curr.data);
			curr = curr.right;
		}

	}

	public node<X> getAt(int index) {
		if (isEmpty()) {
			JOptionPane.showMessageDialog(null, "list is empty");
			return null;
		}

		int i = 0;
		node<X> temp = start;
		while (temp.right != null && i < index) {
			temp = temp.right;
			i++;
		}
		return temp;
	}

	public boolean isEmpty() {
		return start == null;
	}

	public String traverseForward() {
		if (isEmpty()) {
			JOptionPane.showMessageDialog(null, "list is empty");
			return "";
		}
		node<X> temp = start;
		String s = "";
		while (temp != null) {
			s += temp.data + " ";
			temp = temp.right;
		}
		return s;
	}

	public void traverseBackward() {
		if (isEmpty()) {
			JOptionPane.showMessageDialog(null, "list is empty");
			return;
		}
		node<X> temp = end;
		String s = "";
		while (temp != null) {
			s += temp.data + " ";
			temp = temp.left;

		}
		System.out.println(s);
	}
}
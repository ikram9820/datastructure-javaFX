package application;

import java.util.Scanner;


 class Stack<T> {
	private int top;
	private int cap;
	private T[] ch;

	@SuppressWarnings("unchecked")
	public Stack(int size) {
		top = -1;
		cap = size;
		ch = (T[]) new Object[cap];
	}

	public void push(T c) {
		if (top >= cap)
			System.out.println("stack is overflow");
		else {
			top++;
			ch[top] = c;
		} // end else
	}// end insert

	public T pop() {
		if (isEmpty()) {
			System.out.println("stack is underflow");
			return null;
		}
		T temp = ch[top];
		top--;
		return temp;
	}

	public boolean isEmpty() {
			return top == -1;
	}
	public boolean isFull() {
		return top==cap-1;
	}
	public T peak() {
		if (isEmpty()) {
			System.out.println("stack isunderflow");
			return null;
		}
		return ch[top];
	}
	
	public String traverse() {
		if(isEmpty())
			return "";
	    String data="";
	    for(int i=0;i<=top;i++)
	    	data=ch[i]+"\n"+data;
	    
	    return data;
	}
}// end Stack
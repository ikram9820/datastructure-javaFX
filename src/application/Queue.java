package application;

class Queue <x> {
	private int size;
	private int front, rear;
	private x[] arr;

	public Queue(int size) {
		this.size = size;
		rear = front = -1;
		arr = (x[])new Object[size];
	}

	public void enqueue(x item) {
		if (isFull())
			System.out.println("queue is full");
		else {
			if (isEmpty())
				rear = front = 0;
			else if (rear == size - 1)
				rear = 0;
			else
				rear++;
			arr[rear] = item;
		} // else
	}// end enqueue()

	public x dequeue() {
		if (isEmpty()) {
			System.out.println("queue is empty");
			return null;
		}
		x item = arr[front];
		if (rear == front)
			rear = front = -1;
		else if (front == size - 1)
			front = 0;
		else
			front++;
		return item;
	}

	public boolean isEmpty() {
		return (front == -1);
	}

	public boolean isFull() {
		return (front == 0 && rear == size - 1 || front == rear + 1);
	}

	public x front() {
		if (isEmpty()) {
			System.out.println("queue is empty");
			return null;
		}
		return arr[front];
	}

	public String traverse() {
		
		String data=" ";
		if (isEmpty())
			System.out.println("queue is empty");
		else {
			int j = front;
			for (int i = 0; i < nElements(); i++) {
				if (j == size)
					j = 0;
				data= arr[j]+" "+data;
				j++;

			} // end for
		} // end else
		return data;
	}// end display()

	public int nElements() {
		return (size - front + rear + 1) % size;
	}// end nElements()

	
}// end Queue class
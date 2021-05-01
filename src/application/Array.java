package application;

import javax.swing.JOptionPane;

class Array <x> {
	private x arr[];
	private int nElement;
	private int size;

	@SuppressWarnings("unchecked")
	public Array(int s) {
		size = s;
		arr = (x[]) new Object[size];
		nElement = 0;
	}
	public int getNelement() {
		return nElement;
	}
	public void insert(x data) {
		if(nElement>=size)
		{
			JOptionPane.showMessageDialog(null,"array is full");
		    return;
		}
		arr[nElement++]=data;
	}//end insert()
	
	public void insert(x data,int i) {
		if(nElement>=size)
		{
			JOptionPane.showMessageDialog(null,"array is full");
		    return;
		}
		if(i>nElement||i<0)
		{
			JOptionPane.showMessageDialog(null,"invalid index");
			return;
		}
	
		for(int j=nElement-1;j>=i;j--)
			arr[j+1]=arr[j];
		arr[i]=data;
		nElement++;
	}//end insert()
	
	
	public x delete(x data) {
		if(nElement==0)
		{
			JOptionPane.showMessageDialog(null,"array is empty");
			return null;
		}
		Integer index=search(data);
		
		if(index==null) {
			return null;
		}
		
		for(int j=index;j<nElement-1;j++)
			arr[j]=arr[j+1];
		nElement--;
		return data;
	}//end delete()
	
	public x deleteAt(int i) {
		if(nElement==0)
		{
			JOptionPane.showMessageDialog(null,"array is empty");
			return null;
		}
		if(i>nElement-1||i<0)
		{
			JOptionPane.showMessageDialog(null,"invalid index");
			return null;
		}
		x data=arr[i];
		for(int j=i;j<nElement-1;j++)
			arr[j]=arr[j+1];
		nElement--;
		return data;
	}//end deleteAt()
	
	public x getAt(int index) {
		if(nElement==0)
		{
			JOptionPane.showMessageDialog(null,"array is empty");
			return null;
		}
		if(index>nElement-1||index<0)
		{
			JOptionPane.showMessageDialog(null,"invalid index");
			return null;
		}
		return arr[index];
	}
	
	
	public Integer search(x data) {
		Integer index=null;
		for(Integer i=0;i<nElement;i++) {
			if(data==arr[i]){
				index=i;
				break;
				}
		}
		if(index==null) {
			JOptionPane.showMessageDialog(null,"data is not available");
			return null;
		}
		return index;
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
		}
	
	public Integer bSearch(x item) {
		int beg = 0, end = nElement-1, mid = (beg + end) / 2;
		while (beg < end && arr[mid] != item) {
			if (compare(item ,arr[mid])==-1)
				end = mid - 1;

			else
				beg = mid + 1;

			mid = (beg + end) / 2;
		} // end while loop
		if (arr[mid] != item)
			{
				JOptionPane.showMessageDialog(null,"data is not available");
				return null;
			}
		else
			return mid;
	}// end bSearch()

	public String travers() {
		String data="";
		for (int i = 0; i < nElement;i++)
		{
		 data+=i+":"+arr[i]+"\n";
		
		}
		 return data;
	}// end traverse ()

	public void bubbleSort() {
		for (int i=0;i<nElement-1;i++) {
			for(int j=0;j<nElement-i-1;j++) {
				if(compare(arr[j],arr[j+1])==1)
				{
					x temp =arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}//end if 
			}//end in for
		}//end out for
	}//end bubbleSort()
	
	public void selectionSort() {
		for (int i = 0; i < nElement-1; i++) {
			int imin = i;
			for (int j = i + 1; j < nElement; j++) {
				if (compare(arr[j] , arr[imin])==-1)
					imin = j;
			} // end in for loop
			x temp = arr[imin];
			arr[imin] = arr[i];
			arr[i] = temp;
		} // end out for loop
	}// end selectionSort()
	public void insertionSort() {
		for (int i=1;i<nElement;i++) {
		
			x temp = arr[i];
			int j =i-1;
			while(j>=0 &&compare(temp,arr[j])==-1)
				{arr[j+1]=arr[j];
				j--;
				 }//end in loop
			arr[j+1]=temp;
		}//end out loop
	}//end insert()
	
	public void quickSort(int start,int end) {
	
			if(start>=end)
				return;
			
				int pivot=partition(start,end);
				quickSort(start,pivot-1);
				quickSort(pivot+1,end);
		
	}//end quickSort()
	
	public int partition(int start,int end) {
		x pivot=arr[end];
		int pIndex=start; 
		for(int i=start;i<end;i++) {
			if(compare(arr[i],pivot)!=1 ){
				x temp=arr[i];
				arr[i]=arr[pIndex];
				arr[pIndex]=temp;
				pIndex++;
			}//end if
		}//end for
		x temp=arr[end];
		arr[end]=arr[pIndex];
		arr[pIndex]=temp;
		return pIndex;
	}//end partition()
	
}//end Arry class

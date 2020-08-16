
public class LinkedStack<T> implements StackADT<T> {

	private List<T> list; 
	
	public LinkedStack() {
		
		list = new List<T>();;
	}

	public void push(T element) {
		
		list.addFirst(element);
		
	}

	public T pop() {
		T n = list.getFirst();
		list.delete(0);
		return n;
	}
	

	public T peek() {
		return list.getFirst();
	}

	public boolean isEmpty() {

		if (list.length() == 0) 
			 return true;
		else
		return false;
	}

	public int size() {
		
		return list.length();
	}

}

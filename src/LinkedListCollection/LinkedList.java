package LinkedListCollection;

public interface LinkedList<T> {

		
	void addFirst(T data);
	
	void addLast(T data);
	
	void addAtPosition(int position, T data);
	
	void deleteFirst();
	
	void deleteLast();
	
	void deleteAtPosition(int position);
	
	int size();
	
	void getAll();
}

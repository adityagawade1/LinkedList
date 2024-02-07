package LinkedListCollection;

public class LinkedListImple {
	
	public static void main(String[] args) {
		
		LinkedList<String> sl = new SinglyLinkedList<>();
		sl.addFirst("Shubhada");
		sl.addLast("Neha");
		sl.addFirst("Aditya");
		sl.addFirst("Gawade");
		sl.addFirst("Ajay");
		sl.addFirst("Tathe");
		sl.deleteFirst();
		sl.deleteLast();
		sl.addAtPosition(4, "ABC");
		sl.deleteAtPosition(4);
		sl.getAll();
		System.out.println("Size "+sl.size());
	}
}

package LinkedListCollection;


public class SinglyLinkedList<T> implements LinkedList<T> {

	public class Node {
		private T data;
		private Node next;

		public Node(T data) {
			this.data = data;
		}
	}

	Node head = null;

	@Override
	public void addFirst(T data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	@Override
	public void addLast(T data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}

	@Override
	public void addAtPosition(int position, T data) {

		Node newNode = new Node(data);
		if (position <= 0 || position >= size() + 2) {
			return;
		}
		if (position == 1)
			addFirst(data);
		else if (position == size() + 1) {
			addLast(data);
		} else {
			Node temp = head;
			while (position - 2 != 0) {
				temp = temp.next;
				position--;
			}
			newNode.next = temp.next;
			temp.next = newNode;
		}

	}

	@Override
	public void deleteFirst() {
		if (head == null) {
			System.out.println("Linked list is empty");
			return;
		}
		if (size() == 1) {
			head = null;
		} else {
			head = head.next;
		}

	}

	@Override
	public void deleteLast() {
		if (head == null) {
			System.out.println("Empty linked list");
			return;
		}

		if (size() == 1) {
			head = null;
		} else {
			Node temp = head;

			while (temp.next.next != null) {
				temp = temp.next;
			}
			temp.next = null;
		}

	}

	@Override
	public void deleteAtPosition(int position) {
		if (position <= 0 || position > size() + 1) {
			System.out.println("Wrong linkedList");
		}
		if (position == 1) {
			deleteFirst();
		} else if (size() == position) {
			deleteLast();
		} else {
			Node temp = head;
			while (position - 2 != 0) {
				temp = temp.next;
				position--;
			}
			temp.next = temp.next.next;
		}

	}

	@Override
	public int size() {
		Node temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	@Override
	public void getAll() {
		if (head == null) {
			System.out.println("Linked list is empty");
		} else {
			Node temp = head;
			while (temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
		}

	}

}

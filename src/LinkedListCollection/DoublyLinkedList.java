package LinkedListCollection;


public class DoublyLinkedList<T> implements LinkedList<T> {

	class Node {
		/*
		 * data jo add kraycha ahe
		 */
		T data;
		/*
		 * previous node cha reference sathi
		 */
		Node previous;
		/*
		 * next node chya reference sathi
		 */
		Node next;

		public Node(T data) {
			this.data = data;
		}
	}

	/*
	 * head element linkedlist madhla sglyat phila element asto
	 */
	Node head = null;
	/*
	 * tail element linkedlist madhe sglyat last la asto
	 */
	Node tail = null;

	@Override
	public void addFirst(T data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head.previous = newNode;
			head = newNode;
		}

	}

	@Override
	public void addLast(T data) {

		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			tail = newNode;
		}

		tail.next = newNode;
		newNode.previous = tail;
		tail = newNode;

	}

	@Override
	public void addAtPosition(int position, T data) {
		if (size() <= 0 || position >= size() + 2) {
			System.out.println("invalid index");
			return;
		}

		Node temp = head;

		if (position == 1) {
			addFirst(data);
		} else if (position == size() + 1) {
			addLast(data);
		} else {
			Node newNode = new Node(data);
			while (position - 2 != 0) {
				temp = temp.next;
				position--;
			}
			temp.next.previous = newNode;
			newNode.next = temp.next;
			newNode.previous = temp;
			temp.next = newNode;

		}

	}

	@Override
	public void deleteFirst() {
		if (head == null) {
			System.out.println("Empty LinkedList");
			return;
		}
		if (head == tail) {
			head = null;
			tail = null;
			return;
		}

		Node temp = head;
		head = head.next;
		head.previous = null;
		temp.next = null;

	}

	@Override
	public void deleteLast() {
		if (head == null) {
			System.out.println("Empty linkedlist");
			return;
		}

		if (head == tail) {
			head = null;
			tail = null;
			return;
		}

		else {
			Node temp = tail;
			tail = tail.previous;
			tail.next = null;
			temp.previous = null;
		}

	}

	@Override
	public void deleteAtPosition(int position) {
		if (size() <= 0 || position >= size() + 1) {
			System.out.println("invalid index");
			return;
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
			temp.next.next.previous = temp;
			temp.next = temp.next.next;

		}

	}

	@Override
	public int size() {
		Node temp = head;
		int count = 0;

		if (head == null) {
			System.out.println("Empty linkedlist ");
			return 0;
		}

		while (temp != null) {
			temp = temp.next;
			count++;
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

	void reverseprintLinkedList() {

		if (tail == null) {
			System.out.println("Linked list is empty");
		} else {
			Node temp = tail;
			while (temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.previous;

			}
		}
	}

}

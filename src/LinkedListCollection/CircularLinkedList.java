package LinkedListCollection;

public class CircularLinkedList<T> implements LinkedList<T> {

	class CircularNode {
		T data;
		CircularNode next;

		public CircularNode(T data) {
			this.data = data;
		}
	}

	CircularNode head = null;

	@Override
	public void addFirst(T data) {
		CircularNode newNode = new CircularNode(data);
		if (head == null) {
			head = newNode;
			newNode.next = head;
		} else {
			CircularNode temp = head;

			while (head != temp.next) {
				temp = temp.next;
			}
			newNode.next = head;
			head = newNode;
			temp.next = newNode;
		}

	}

	@Override
	public void addLast(T data) {
		CircularNode newNode = new CircularNode(data);
		if (head == null) {
			head = newNode;
		} else {
			CircularNode temp = head;
			while (temp.next != head) {
				if (temp.next != null) {
					temp = temp.next;
				} else {
					break;
				}
			}
			temp.next = newNode;
			newNode.next = head;
		}

	}

	@Override
	public void addAtPosition(int position, T data) {
		if (position <= 0 || position >= size() + 2) {
			System.out.println("Invalid index");
			return;
		}

		if (position == 1) {
			addFirst(data);
		} else if (size() + 1 == position) {
			addLast(data);
		} else {
			CircularNode newNode = new CircularNode(data);
			CircularNode temp = head;

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
			System.out.println("empty linkedlist");
			return;
		} else {

			CircularNode temp = head;

			while (head != temp.next) {
				temp = temp.next;
			}
			head = head.next;
			temp.next = head;
		}

	}

	@Override
	public void deleteLast() {
		if (head == null) {
			System.out.println("empty linkedlist");
			return;
		} else {
			CircularNode temp = head;

			while (temp.next.next != head) {
				temp = temp.next;
			}
			temp.next = head;
		}

	}

	@Override
	public void deleteAtPosition(int position) {
		if (position <= 0 || position >= size() + 1) {
			System.out.println("invalid index");
		}
		if (position == 1) {
			deleteFirst();
		} else if (size() == position) {
			deleteLast();
		} else {
			CircularNode temp = head;

			while (position - 2 != 0) {
				temp = temp.next;
				position--;
			}
			temp.next = temp.next.next;
		}

	}

	@Override
	public int size() {
		int count = 0;
		if (head == null) {
			System.out.println("Empty list");
			return count;
		}

		else {
			CircularNode temp = head;

			do {
				count++;
				temp = temp.next;
			} while (temp != head);
		}
		return count;
	}

	@Override
	public void getAll() {
		CircularNode temp = head;

		do {
			System.out.println(temp.data);
			temp = temp.next;
		} while (temp != head);

	}

}

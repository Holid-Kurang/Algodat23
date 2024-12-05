package algodat;

class Node {
	int value;
	Node next = null;
	Node prev = null;

	Node(int value) {
		this.value = value;
	}
}

abstract class MyLinkedList {
	Node head;
	Node tail;

	abstract void addLast(int value);
	abstract void addFirst(int value);
	abstract void addAfter(int index, int value);
	abstract void delFirst();
	abstract void delLast();
	abstract void delByIndex(int index);
	abstract void print();
}

class singleLinkedList extends MyLinkedList {
	void addLast(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			tail = newNode;
			head = tail;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	void addFirst(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			tail = newNode;
			head = tail;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	void addAfter(int index, int value) {
		Node newNode = new Node(value);
		Node current = head;

		for (int i = 0; i < index; i++) {
			current = current.next;
			if (current == null) {
				return;
			}
		}
		if (head == null) {
			tail = newNode;
			head = tail;
		} else if (current.next != null) {
			newNode.next = current.next;
			current.next = newNode;
		} else if (current.next == null) {
			tail.next = newNode;
			tail = newNode;
		}
	}

	void delLast() {
		if (head != null) {
			Node current = head;
			while (current.next != tail) {
				current = current.next;
			}
			tail = current;
			tail.next = null;
		} else {
			return;
		}
	}

	void delFirst() {
		if (head != null) {
			Node current = head.next;
			head.next = null;
			head = current;
		} else {
			return;
		}
	}

	void delByIndex(int index) {
		Node current;
		if (head == null) {
			return;
		}
		if (index == 0) {
			current = head.next;
			head.next = null;
			head = current;
			return;
		}
		current = head;
		int i = 0;
		while (current != null && i < index - 1) {
			current = current.next;
			i++;
		}
		if (current == null || current.next == null) {
			return;
		}
		current.next = current.next.next;

	}

	void print() {
		Node current = head;
		while (current != null) {
			if (current.next == null) {
				System.out.print(current.value);
			} else {
				System.out.print(current.value + " -> ");
			}
			current = current.next;
		}
	}
}

class doubleLinkedList extends MyLinkedList {

	void addFirst(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			tail = newNode;
			head = tail;
		} else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
	}

	void addLast(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			tail = newNode;
			head = tail;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	}

	void addAfter(int index, int value) {
		Node newNode = new Node(value);
		Node current = head;

		for (int i = 0; i < index; i++) {
			current = current.next;
			if (current == null) {
				return;
			}
		}
		if (head == null) {
			tail = newNode;
			head = tail;
		} else if (current.next != null) {
			newNode.prev = current;
			newNode.next = current.next;
			current.next.prev = newNode;
			current.next = newNode;
		} else if (current.next == null) {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	}

	void delFirst() {
		if (head != null) {
			if(head==tail) {
				head=null;
				tail=null;
			}else {
				head = head.next;
				head.prev = null;
			}
		} else {
			return;
		}
	}

	void delLast() {
		if (head != null) {
			if(head==tail) {
				head=null;
				tail=null;
			}else {
				tail = tail.prev;
				tail.next.prev = null;
				tail.next = null;
			}
		} else {
			return;
		}
	}

	void delByIndex(int index) {
		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		if (current == head) {
			head = head.next;
			head.prev = null;
		} else if (current == tail || current.next == null) {
			tail = tail.prev;
			tail.next.prev = null;
			tail.next = null;
		} else {
			current.next.prev = current.prev;
			current.prev.next = current.next;
			current.next = null;
			current.prev = null;
		}
	}
	
	void swap(int a, int b) {
		Node current=head;
		Node Node1=null;
		while(current!=null) {
			if(current.value==a) {
				Node1 = current;
				break;
			}
			current=current.next;
		}
		current=head;
		Node Node2=null;
		while(current!=null) {
			if(current.value==b) {
				Node2 = current;
				break;
			}
			current=current.next;
		}
		
		if(Node1 == head && Node2 == Node1.next) {
			Node1.next=Node2.next;
			Node2.next.prev=Node2.prev;
			Node2.prev=null;
			Node2.next=Node1;
			Node1.prev=Node2;
		}else if(Node1 == Node2.prev && Node2 == tail) {
			
		}else if(Node1 == head && Node2 == tail) { //kedua nilai berada pada kedua ujung linked list
			
		}else if(Node1.next == Node2 && Node2.prev == Node1 && (Node1 == head || Node2 == tail)) { //
			
		}
	}
	
	doubleLinkedList merge(doubleLinkedList front, doubleLinkedList back) {
		front.tail.next = back.head;
		back.head.prev = front.tail;
		front.tail = back.tail;
		return front;
	}

	void print() {
		Node current = head;
		while (current != null) {
			if (current.next == null) {
				System.out.print(current.value);
			} else {
				System.out.print(current.value + " <-> ");
			}
			current = current.next;
		}
	}
}

class circularLinkedList extends MyLinkedList {
	void addLast(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			tail = newNode;
			head = tail;
			tail.next=head;
		} else {
			tail.next = newNode;
			tail = newNode;
			tail.next=head;
		}
	}

	void addFirst(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			tail = newNode;
			head = tail;
			tail.next=head;
		} else {
			newNode.next=head;
			head=newNode;
			tail.next=head;
		}
	}

	void addAfter(int index, int value) {
		Node newNode = new Node(value);
		tail.next=null;
		Node current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
			if (current == null) {
				tail.next=head;
				return;
			}
		}
		if (head == null) {
			tail = newNode;
			head = tail;
			tail.next=head;
		} else if (current == tail) {
			tail.next = newNode;
			tail = newNode;
			tail.next=head;
		}else{
			newNode.next = current.next;
			current.next = newNode;
		} 
		tail.next=head;
	}

	void delFirst() {
		if (head != null) {
			head=head.next;
			tail.next=head;
		} else {
			return;
		}
	}

	void delLast() {
		if (head != null) {
			Node current = head;
			while (current.next != tail) {
				current = current.next;
			}
			tail = current;
			tail.next = head;
		} else {
			return;
		}
	}

	void delByIndex(int index) {
		Node current;
		if (head == null) {
			return;
		}
		if (index == 0) {
			if (head == tail) {
	            head = null;
	            tail = null;
	        } else {
	            head = head.next;
	            tail.next = head;
	        }
	        return;
		}
		tail.next=null;
		current = head;
		int i = 0;
		while (current != null && i < index - 1) {
			current = current.next;
			i++;
		}
		if (current == null || current.next == null) {
			tail.next=head;
			return;
		}
		current.next = current.next.next;
		tail.next=head;
	}

	void print() {
		if (head != null) {
			Node current = head;
			while (current.next != head) {
				if (current.next == null) {
					System.out.print(current.value);
				} else {
					System.out.print(current.value + " -> ");
				}
				current = current.next;
			}
			System.out.print(current.value);
        }
	}
}

class orderedLinkedList{
	Node head, tail;
	
	boolean isEmpty() {
		if(head==null) {
			return true;
		}
		return false;
	}
	void add(int index, int value) {
		Node newNode = new Node(value);
		Node current = head;

		for (int i = 0; i < index; i++) {
			current = current.next;
			if (current == null) {
				return;
			}
		}
		if (head == null) {
			tail = newNode;
			head = tail;
		} else if (current.next != null) {
			newNode.next = current.next;
			current.next = newNode;
		} else if (current.next == null) {
			tail.next = newNode;
			tail = newNode;
		}
	}
	void sortedInsert(int value){
		Node newNode = new Node(value);
		if(isEmpty()) {
			tail = newNode;
			head = tail;
		}else if((Integer)head.value >= (Integer)newNode.value){
			newNode.next = head;
            head = newNode;
		}else {
			Node current = head;
			while (current.next != null && (Integer)current.next.value < (Integer)newNode.value) {
				current=current.next;
			}
			newNode.next=current.next;
			current.next=newNode;
		}
	}
	void sortedRemove(int index) {
		Node current;
		if (head == null) {
			return;
		}
		if (index == 0) {
			current = head.next;
			head.next = null;
			head = current;
			return;
		}
		current = head;
		int i = 0;
		while (current != null && i < index - 1) {
			current = current.next;
			i++;
		}
		if (current == null || current.next == null) {
			return;
		}
		current.next = current.next.next;
	}
	void print() {
		Node current = head;
		
		System.out.print("sorted : ");
		while (current != null) {
			if (current.next == null) {
				System.out.print(current.value);
			} else {
				System.out.print(current.value + " -> ");
			}
			current = current.next;
		}
	}
}
public class LLCustom {

	public static void main(String[] args) {
		// System.out.println("double linked list :");
		// doubleLinkedList list1 = new doubleLinkedList();
		// list1.addLast(1);
		// list1.addLast(2);
		// list1.addFirst(3);
		// list1.addFirst(4);
		// list1.addLast(5);
		// list1.addAfter(3, 64);
		// list1.delLast();
		// list1.delLast();
		// list1.delLast();
		// list1.delLast();
		// list1.delLast();
		// list1.delLast();
		// list1.print();
		// System.out.println();
		// System.out.println();
		
//		System.out.println("single linked list :");
//		singleLinkedList list2 = new singleLinkedList();
//		list2.addLast(1);
//		list2.addLast(2);
//		list2.addLast(3);
//		list2.addLast(4);
//		list2.addFirst(5);
//		list2.delByIndex(4);
//		list2.addAfter(1, 64);
//		list2.print();
//		System.out.println();
//		System.out.println();
//		
//		System.out.println("circular linked list :");
//		circularLinkedList list3 = new circularLinkedList();
//		list3.addLast(1);
//		list3.addLast(2);
//		list3.addLast(3);
//		list3.addLast(4);
//		list3.addFirst(5);
//		list3.delByIndex(3);
//		list3.addAfter(4, 65);
//		list3.addAfter(5, 71);
//		list3.print();
//		System.out.println();
//		System.out.println();
//		
		System.out.println("orderedlinked list :");
		orderedLinkedList list4 = new orderedLinkedList();
		list4.sortedInsert(3);
		list4.sortedInsert(1);
		list4.sortedInsert(1);
		list4.sortedInsert(9);
		list4.sortedInsert(10);
		list4.sortedInsert(7);
		list4.sortedInsert(5);
		list4.print();
		System.out.println();
	}
}

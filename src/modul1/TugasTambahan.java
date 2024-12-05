package modul1;


class Node {
	String value;
	Node next = null;

	Node(String value) {
		this.value = value;
	}
}


class singleLinkedList {
	Node head, tail;
	void addLast(String value) {
		Node newNode = new Node(value);
		if (head == null) {
			tail = newNode;
			head = tail;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	void addFirst(String value) {
		Node newNode = new Node(value);
		if (head == null) {
			tail = newNode;
			head = tail;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	void addAfter(String acuan, String value) {
		Node newNode = new Node(value);

		if (head==null) { //add if kosong
			tail = newNode;
			head = tail;
			return;
		} 
		
		Node current = head;
		while(current.value != acuan) {
			current=current.next;
			if(current==null) {
				System.out.println("tidak ada acuan yang bernilai : "+"'"+acuan+"'");
				return;
			}
		}
		if(current==head) {
			newNode.next = head.next;
			head.next=newNode;
		}else if (current==tail) {
			tail.next = newNode;
			tail = newNode;
		}else {
			newNode.next = current.next;
			current.next = newNode;
		}
	}

	void addBefore(String acuan, String value) {
		Node newNode = new Node(value);

		if (head==null) { //add if kosong
			tail = newNode;
			head = tail;
			return;
		}
		if(head.value==acuan) {
			newNode.next = head;
			head=newNode;
			return;
		}
		Node current = head;
		while(current.next.value != acuan) {
			current=current.next;
			if(current==null || current.next==null) {
				System.out.println("tidak ada acuan yang bernilai : "+"'"+acuan+"'");
				return;
			}
		}
		
		if(current==head) {
			newNode.next = head.next;
			head.next=newNode;
		}else if(current.next==tail){
			newNode.next = tail;
			current.next=newNode;
		}else {
			newNode.next = current.next;
			current.next = newNode;
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
	void delAfter(String acuan) {
		Node current = head;
        while (current != null && current.value!=acuan) {
            current = current.next;
        }

        if (current != null && current.next != null) {
            current.next = current.next.next;
        } else {
            System.out.println("Node tidak ditemukan atau tidak ada node setelah node "+"'"+acuan+"'");
        }
	}
	void delBefore(String acuan) {
		if (head == null || head.value==acuan) {
            System.out.println("Node tidak ditemukan atau tidak ada node sebelum node "+"'"+acuan+"'");
            return;
        }

        if (head.next != null && head.next.value==acuan) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.next != null) {
            if (current.next.next.value==acuan) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
        System.out.println("Node tidak ditemukan atau tidak ada node sebelum node "+"'"+acuan+"'");
	}

	singleLinkedList merge(singleLinkedList front,singleLinkedList middle, singleLinkedList back) {
		front.tail.next = middle.head;
		middle.tail.next = back.head;
		
		front.tail=back.tail;
		return front;
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

public class TugasTambahan {
	public static void main(String[] args) {
		singleLinkedList orang = new singleLinkedList();
		singleLinkedList orang2 = new singleLinkedList();
		singleLinkedList orang3 = new singleLinkedList();
		singleLinkedList mergeOrang= new singleLinkedList();

		orang.addFirst("holil");
		orang.addLast("fuhir");
		orang.addFirst("rehan");
		orang.addAfter("holil", "daos");
		orang.addBefore("rehan", "ario");
		orang.print();
		System.out.println();

		orang2.addFirst("irpan");
		orang2.addLast("ani");
		orang2.addFirst("ardi");
		orang2.addAfter("irpan", "beni");
		orang2.addBefore("beni", "sinta");
		orang2.print();
		System.out.println();

		orang3.addFirst("eni");
		orang3.addLast("agil");
		orang3.addFirst("zidan");
		orang3.addAfter("eni", "fadil");
		orang3.addBefore("eni", "cece");
		orang3.print();
		System.out.println();
		
		mergeOrang=mergeOrang.merge(orang, orang2, orang3);
		mergeOrang.print();
		System.out.println();
	}
}

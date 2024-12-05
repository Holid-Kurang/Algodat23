package modul5;


public class ListJalan {
	Jalan head, tail;

	void addLast(Kota asal, Kota tujuan, int jarak) {
		Jalan newJalan = new Jalan(asal, tujuan, jarak);

		if (head == null) {
			tail = newJalan;
			head = tail;
		} else {
			tail.next = newJalan;
			newJalan.prev = tail;
			tail = newJalan;
		}
	}

	void delLast() {
		if (head != null) {
			if (head == tail) {
				head = null;
				tail = null;
			} else {
				tail = tail.prev;
				tail.next.prev = null;
				tail.next = null;
			}
		} else {
			return;
		}
	}

	void del(String asal, String tujuan, int jarak){
		Jalan current = head;

		while (current != null) {
			if (current.asal.nama == asal && current.tujuan.nama == tujuan && current.jarak == jarak) {
				break;
			}
			current = current.next;
		}

		if (current == head) {
			head = head.next;
			if (head != null) {
				head.prev = null;
			}
		} else if (current == tail) {
			tail = tail.prev;
			if (tail != null) {
				tail.next = null;
			}
		} else if (current != null) {
			current.prev.next = current.next;
			current.next.prev = current.prev;
		}
	}

	boolean hasJalan(Kota asal, Kota tujuan){
		Jalan current = head;
		while (current != null) {
			if (current.asal == asal && current.tujuan == tujuan) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	boolean isAlreadyExist(Kota tujuan) {
		Jalan current = head;
		while (current != null) {
			if (current.asal == tujuan) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	void print() {
		Jalan current = head;
		while (current != null) {
			System.out.println(current.asal.nama + " - " + current.tujuan.nama + " - " + current.jarak);
			current = current.next;
		}
	}

	int minJarak() {
		if (head == null) {
			System.out.println("Linked list kosong.");
			return Integer.MIN_VALUE; // Nilai minimum untuk menandakan linked list kosong
		}

		int min = head.jarak;
		Jalan current = head;

		while (current != null) {
			if (min < current.jarak) {
				min = current.jarak;
			}
			current = current.next;
		}
		return min;
	}

	int size() {
		int count = 0;
		Jalan current = head;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	void selectionSort() {
		if (head == null || head.next == null)
			return;

		Jalan current = head;
		while (current != null) {
			Jalan maxNode = current;
			Jalan runner = current.next;

			while (runner != null) {

				if (runner.jarak < maxNode.jarak) { // Ubah dari '<' menjadi '>'
					maxNode = runner;
				}

				runner = runner.next;
			}

			Jalan temp = maxNode;

			if (maxNode != current) {
				swap(maxNode, current);
				current = temp;
			}
			current = current.next;
		}
	}

	void swap(Jalan Node1, Jalan Node2) {

		if (Node1 == null || Node2 == null) {
			return;
		}
		if (Node1 == head) {
			head = Node2;
		} else if (Node2 == head) {
			head = Node1;
		}
		if (Node1 == tail) {
			tail = Node2;
		} else if (Node2 == tail) {
			tail = Node1;
		}

		Jalan temp;

		temp = Node1.next; // Menyimpan node yang berada setelah Node1 ke dalam temp.
		Node1.next = Node2.next; // Menghubungkan Node1 ke node yang berada setelah Node2.
		Node2.next = temp; // Menghubungkan Node2 ke node yang sebelumnya berada setelah Node1.

		if (Node1.next != null) {
			Node1.next.prev = Node1;
		}
		if (Node2.next != null) {
			Node2.next.prev = Node2;
		}

		temp = Node1.prev;
		Node1.prev = Node2.prev; // Menghubungkan Node1 ke node yang berada sebelum Node2.
		Node2.prev = temp; // Menghubungkan Node2 ke node yang sebelumnya berada sebelum Node1.

		if (Node1.prev != null) {
			Node1.prev.next = Node1;
		}
		if (Node2.prev != null) {
			Node2.prev.next = Node2;
		}
	}

}

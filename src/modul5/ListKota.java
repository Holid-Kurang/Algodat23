package modul5;

public class ListKota {
	Kota head, tail;
	
	void addLast(String nama) {
		Kota newKota = new Kota(nama);

		if (head == null) {
			tail = newKota;
			head = tail;
		} else {
			tail.next = newKota;
			newKota.prev = tail;
			tail = newKota;
		}
	}

	void addFirst(String nama) {
		Kota newKota = new Kota(nama);
		if (head == null) {
			tail = newKota;
			head = tail;
		} else {
			newKota.next = head;
			head.prev = newKota;
			head = newKota;
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
	
	boolean hasKota(String nama) {
		Kota current = head;
		while (current != null) {
			if (current.nama.equals(nama)) {
				return true;
			}
			current = current.next;
		}
		return false;
	}
	
	void print() {
		Kota currentKota = head;
		while (currentKota != null) {
			System.out.println("Kota " + currentKota.nama);
			currentKota = currentKota.next;
		}
	}
	
	int size() {
		int count = 0;
		Kota current = head;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}
	
	int getIndex(String nama) {
		Kota current = head;
		int index = 0;
		while (current != null) {
			if (current.nama.equals(nama)) {
				return index;
			}
			index++;
			current = current.next;
		}
		return -1; // Return -1 if not found
	}
	
	
}

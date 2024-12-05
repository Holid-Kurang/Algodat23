package modul5;

public class KotaNode {

    Kota kota;
    boolean visited = false;
    int jarak = Integer.MAX_VALUE;
    Kota path = null;

    KotaNode next, prev;

    KotaNode(Kota kota) {
        this.kota = kota;
    }

    KotaNode(Kota kota, int jarak) {
        this.kota = kota;
        this.jarak = jarak;
    }

    KotaNode(Kota kota, int jarak, boolean visited) {
        this.kota = kota;
        this.jarak = jarak;
        this.visited = visited;
    }
}

class ListKotaNode {

    KotaNode head, tail;

    boolean isEmpty() {
        return head == null;
    }

    void addFirst(Kota kota) {
		KotaNode newKota = new KotaNode(kota);
		if (head == null) {
			tail = newKota;
			head = tail;
		} else {
			newKota.next = head;
			head.prev = newKota;
			head = newKota;
		}
	}

    void addLast(Kota kota) {
        KotaNode newKota = new KotaNode(kota);

        if (head == null) {
            tail = newKota;
            head = tail;
        } else {
            tail.next = newKota;
            newKota.prev = tail;
            tail = newKota;
        }
    }

    void addLast(Kota kota, int jarak, boolean visited) {
        KotaNode newKota = new KotaNode(kota, jarak, visited);

        if (head == null) {
            tail = newKota;
            head = tail;
        } else {
            tail.next = newKota;
            newKota.prev = tail;
            tail = newKota;
        }
    }

    int size() {
        int count = 0;
        KotaNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    KotaNode findKota(String nama) {
        KotaNode current = head;
        while (current != null) {
            if (current.kota.nama.equals(nama)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    boolean hasKota(String nama) {
        KotaNode current = head;
        while (current != null) {
            if (current.kota.nama.equals(nama)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    void priorityEnqueue(Kota kota, int jarak) {
        KotaNode newKota = new KotaNode(kota, jarak);

        if (head == null) {
            tail = newKota;
            head = tail;
        } else {
            if (newKota.jarak < head.jarak) {
                newKota.next = head;
                head.prev = newKota;
                head = newKota;
            } else {
                KotaNode current = head;
                while (current.next != null && current.next.jarak < newKota.jarak) {
                    current = current.next;
                }
                newKota.next = current.next;
                if (current.next != null) {
                    current.next.prev = newKota;
                }
                current.next = newKota;
                newKota.prev = current;
                if (newKota.next == null) {
                    tail = newKota;
                }
            }
        }
    }

    void enqueue(Kota kota) {
        KotaNode newKota = new KotaNode(kota);

        if (head == null) {
            tail = newKota;
            head = tail;
        } else {
            tail.next = newKota;
            newKota.prev = tail;
            tail = newKota;
        }
    }

    KotaNode dequeue() {
        if (head == null) {
            return null;
        } else {
            KotaNode temp = head;
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return temp;
        }
    }

}

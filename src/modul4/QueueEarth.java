package modul4;

//mendefinisikan kelas QueueEarth, yang mengimplementasikan struktur data antrian (queue) yang sederhana. 
public class QueueEarth {
	// ListEarth head dan ListEarth tail, yang mewakili kepala (head) dan ekor
	// (tail) dari antrian.
	ListEarth head, tail;

	// Method enqueue digunakan untuk menambahkan elemen baru ke antrian.
	void enqueue(Earth current) {
		// sebuah ListEarth baru dibuat dengan current sebagai nilai elemennya
		ListEarth newNode = new ListEarth(current);

		// Jika head masih kosong (null),
		if (head == null) {
			// maka tail dan head akan diatur ke newNode.
			tail = newNode;
			head = tail;
		}

		else {
			// Jika tidak, newNode akan ditambahkan ke belakang antrian dengan mengatur
			// tail.next ke newNode,
			tail.next = newNode;
			// dan tail akan diperbarui menjadi newNode.
			tail = newNode;
		}
	}

	// Method dequeue menghapus elemen pertama dari antrian dan mengembalikan node
	// yang dihapus.
	ListEarth dequeue() {
		// Jika head tidak kosong
		if (head != null) {
			// variabel temp menunjuk ke head,
			ListEarth temp = head;
			// kemudian head diupdate ke elemen berikutnya di antrian (head.next)
			// Hasilnya adalah temp, yang berisi elemen yang dihapus dari antrian
			head = head.next;

			return temp;
		} else {
			// Jika head kosong (null), maka method ini akan mengembalikan null karena tidak
			// ada yang bisa dihapus dari antrian kosong.
			return null;
		}
	}
}

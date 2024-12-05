package modul3;

public class WeaponWarrior {
	String nama;
	int stok;
	int harga;

	WeaponWarrior next;
	WeaponWarrior prev;

	WeaponWarrior(String nama, int stok, int harga) {
		this.nama = nama;
		this.stok = stok;
		this.harga = harga;
	}
}

// String nama, int stok, int harga
// nama, stok, harga
class DoubleWarrior {
	/*
	 * dilakukan inisialisasi kelas WeaponWarrior dengan nama head untuk mengacu ke
	 * elemen awal pada doublelinkedlist dan tail untuk mengacu ke elemen akhir pada
	 * doublelinkedlist
	 */
	WeaponWarrior head, tail;

	/*
	 * fungsi metode addFirst pada kelas doublelinkedlist dibawah bertujuan untuk
	 * menambah elemen / node baru pada bagian depan atau awal double linked list
	 * 
	 */
	void addFirst(String nama, int stok, int harga) {
		// Membuat node baru newWeaponWarrior dengan nilai-nilai yang diterima
		// (nama senjata, stok senjata dan harga senhata).
		WeaponWarrior newWeaponWarrior = new WeaponWarrior(nama, stok, harga);
		/*
		 * Memeriksa apakah head (kepala) dari linked list kosong. Jika iya (linked list
		 * kosong), node baru newWeaponWarrior diatur sebagai kepala (head) dan ekor
		 * (tail) dari linked list karena hanya ada satu node.
		 */
		if (head == null) {
			tail = newWeaponWarrior;
			head = tail;
		}
		/*
		 * Jika linked list tidak kosong, newWeaponWarrior yang baru ditambahkan harus
		 * dihubungkan ke kepala(elemen awal) yang ada sebelumnya.
		 */
		else {
			// menentukan bahwa newWeaponWarrior akan mengikuti node berikutnya dari head.
			newWeaponWarrior.next = head;
			// mendefinisikan bahwa node yang sebelumnya adalah kepala (head) akan memiliki
			// node newWeaponWarrior sebagai node sebelumnya.
			head.prev = newWeaponWarrior;
			// mengatur newNodebuku sebagai head(elemen) baru pada linked list
			head = newWeaponWarrior;
		}
	}

	/*
	 * metode addLast pada kelas doublelinkedlist dibawah bertujuan untuk menambah
	 * elemen / node baru pada bagian belakang atau akhir double linked list
	 */
	void addLast(String nama, int stok, int harga) {
		// Membuat node baru newWeaponWarrior dengan nilai-nilai yang diterima
		// (nama senjata, stok senjata dan harga senhata).
		WeaponWarrior newWeaponWarrior = new WeaponWarrior(nama, stok, harga);
		/*
		 * Memeriksa apakah head (kepala) dari linked list kosong. Jika iya (linked list
		 * kosong), node baru newWeaponWarrior diatur sebagai kepala (head) dan ekor
		 * (tail) dari linked list karena hanya ada satu node.
		 */
		if (head == null) {
			tail = newWeaponWarrior;
			head = tail;
		}
		// Jika linked list sudah memiliki node atau elemen,
		else {
			// newWeaponWarrior ditambahkan setelah node terakhir (tail).
			tail.next = newWeaponWarrior;
			/*
			 * newWeaponWarrior diatur sebagai node sebelumnya (prev) dari node berikutnya
			 * (tail) dan kemudian dijadikan node terakhir dalam linked list (tail di-update
			 * menjadi newWeaponWarrior).
			 */
			newWeaponWarrior.prev = tail;
			tail = newWeaponWarrior;
		}
	}

	/*
	 * method addAfter dalam linked list menambahkan node setelah suatu indeks
	 * tertentu pada linked list tersebut.
	 */
	void addAfter(int index, String nama, int stok, int harga) {
		// Membuat node baru newWeaponWarrior dengan nilai-nilai yang diterima
		// (nama senjata, stok senjata dan harga senhata).
		WeaponWarrior newWeaponWarrior = new WeaponWarrior(nama, stok, harga);

		// Mendeklarasikan current sebagai node awal, yaitu head double dari linked
		// list.
		WeaponWarrior current = head;

		// melakukan iterasi untuk mencari node pada posisi indeks tertentu dalam linked
		// list
		for (int i = 0; i < index; i++) {
			// untuk memindahkan current ke node berikutnya.
			current = current.next;

			// Jika current menjadi null, maka kita telah melebihi
			// indeks yang ada dan langsung keluar dari metode.
			if (current == null) {
				return;
			}
		}

		/*
		 * pengkondisian dibawah untuk mengatur newNode akan di tambahkan pada posisi
		 * indeks tertentu dari linked list
		 */

		/*
		 * Jika linked list kosong (pertama kali), maka newWeaponWarrior menjadi head
		 * dan tail dari linked list.
		 */
		if (head == null) {
			tail = newWeaponWarrior;
			head = tail;
		}
		/*
		 * Jika current bukan node terakhir dalam linked list, maka newWeaponWarrior
		 * akan dimasukkan di antara current dan current.next.
		 */
		else if (current.next != null) {
			newWeaponWarrior.prev = current;
			newWeaponWarrior.next = current.next;
			current.next.prev = newWeaponWarrior;
			current.next = newWeaponWarrior;
		}
		/*
		 * Jika current adalah node terakhir, maka newWeaponWarrior akan ditambahkan
		 * setelah tail.
		 */
		else if (current.next == null) {
			tail.next = newWeaponWarrior;
			newWeaponWarrior.prev = tail;
			tail = newWeaponWarrior;
		}
	}

	/*
	 * Fungsi delFirst bertujuan menghapus node pertama dari sebuah doubly linked
	 * list.
	 */
	void delFirst() {
		// kondisi untuk memeriksa apakah linked list tidak kosong.
		// Jika head tidak kosong (berisi node), maka operasi penghapusan akan
		// dilakukan.
		if (head != null) {
			// jika elemen hanya berjumlah 1 elemen yaitu ketika head sama dengan tail
			if (head == tail) {
				// head diatur atau di set menjadi kosong atau null
				head = null;
				// tail diatur atau di set menjadi kosong atau null
				tail = null;
			} else {
				// memindahkan referensi head ke node berikutnya dari node pertama (node yang
				// akan dihapus).
				// dengan melakukan ini, kita secara efektif menghapus node pertama dari linked
				// list.
				head = head.next;

				// atribut prev pada node yang baru dijadikan node pertama (sekarang head)
				// diatur
				// menjadi null untuk memutuskan referensi yang ada sebelumnya.
				head.prev = null;
			}
		}
		/*
		 * Jika linked list kosong (tidak ada node), atau jika node pertama sudah
		 * dihapus, fungsi akan segera berakhir dengan pernyataan return.
		 */
		else {
			return;
		}
	}

	/*
	 * Fungsi delLast bertujuan menghapus node terkahir(tail) dari sebuah doubly
	 * linked list.
	 */
	void delLast() {
		// kondisi untuk memeriksa apakah linked list tidak kosong.
		// Jika head tidak kosong (berisi node), maka operasi penghapusan akan
		// dilakukan.
		if (head != null) {
			// jika elemen hanya berjumlah 1 elemen yaitu ketika head sama dengan tail
			if (head == tail) {
				// head diatur atau di set menjadi kosong atau null
				head = null;
				// tail diatur atau di set menjadi kosong atau null
				tail = null;
			} else {
				// memindahkan referensi tail ke node sebelumnya dari node terakhir (node yang
				// akan dihapus).
				tail = tail.prev;

				// atribut prev pada node yang akan dihapus diatur menjadi null untuk memutuskan
				// refrensi sebelumnya
				tail.next.prev = null;

				// refrensi selanjutnya untuk tail yang baru diatur menjadi null untuk
				// memutuskan refrensi sebelumnya
				tail.next = null;
			}
		}
		/*
		 * Jika linked list kosong (tidak ada node), atau jika node terkahir sudah
		 * dihapus, fungsi akan segera berakhir dengan pernyataan return.
		 */
		else {
			return;
		}
	}

	/*
	 * delByIndex adalah metode yang berfungsi untuk menghapus elemen dari linked
	 * list dengan memanfaatkan indeks (index) sebagai penanda posisi elemen yang
	 * akan dihapus.
	 */
	void delByIndex(int index) {
		// Mendeklarasikan current sebagai node awal, yaitu head double dari linked
		// list.
		WeaponWarrior current = head;

		// melakukan iterasi untuk mencari node pada posisi indeks tertentu dalam linked
		// list
		for (int i = 0; i < index; i++) {
			// current di set untuk memindahkan current ke node berikutnya.
			current = current.next;
		}

		// jika elemen hanya berjumlah 1 elemen yaitu ketika head sama dengan tail
		if (head == tail) {
			// head diatur atau di set menjadi kosong atau null
			head = null;
			// tail diatur atau di set menjadi kosong atau null
			tail = null;
		}
		// current == head): Jika elemen yang ditemukan adalah head,
		else if (current == head) {
			// maka head akan dipindahkan ke elemen setelahnya
			head = head.next;
			// head.prev (biasanya null) akan diatur ke null untuk memutuskan refrensi
			// sebelumnya pada head (elemen awal).
			head.prev = null;
		}
		/*
		 * Jika elemen yang ditemukan adalah tail atau elemen tersebut merupakan elemen
		 * terakhir (ditandai dengan current.next yang null),
		 */
		else if (current == tail || current.next == null) {
			// maka tail akan dipindahkan ke elemen sebelumnya (tail = tail.prev).
			tail = tail.prev;

			// Setelahnya, pengaturan prev dari tail.next (yang awalnya adalah tail) akan
			// dihapus
			// dan diatur ke null, serta mengatur tail.next menjadi null.
			tail.next.prev = null;
			tail.next = null;
		}

		// Jika elemen yang ditemukan terletak di tengah linked list (bukan head atau
		// tail),
		else {
			current.next.prev = current.prev;
			current.prev.next = current.next;
			current.next = null;
			current.prev = null;
		}
	}

	void printStok() {
		WeaponWarrior current = head;
		while (current != null) {
			System.out.println("id   : " + current);
			System.out.println("nama : " + current.nama);
			System.out.println("stok : " + current.stok);
			System.out.println();
			current = current.next;
		}
	}

	void printHarga() {
		WeaponWarrior current = head;
		while (current != null) {
			System.out.println("id   : " + current);
			System.out.println("nama : " + current.nama);
			System.out.println("harga: " + current.harga);
			System.out.println();
			current = current.next;
		}
	}

	void print() {
		WeaponWarrior current = head;
		while (current != null) {
			System.out.println("nama : " + current.nama);
			System.out.println("stok : " + current.stok);
			System.out.println("harga: " + current.harga);
			System.out.println();
			current = current.next;
		}
	}

	// Fungsi swap pada kode yang diberikan bertujuan untuk
	// menukar posisi dua node (Node1 dan Node2) dalam double linked list
	void swap(WeaponWarrior Node1, WeaponWarrior Node2) {

		// melakukan pengecekan apakah Node1 atau Node2 kosong (null).
		// Jika salah satu dari keduanya kosong, maka
		// tidak ada yang perlu dilakukan dalam proses pertukaran.
		if (Node1 == null || Node2 == null) {
			// sehingga fungsi langsung mengembalikan nilai tanpa melakukan operasi
			// pertukaran apapun
			return;
		}
		// Jika Node1 adalah head, maka head diubah menjadi Node2
		if (Node1 == head) {
			head = Node2;
		}
		// jika Node2 adalah head, maka head diubah menjadi Node1.
		else if (Node2 == head) {
			head = Node1;
		}
		// Jika Node1 adalah tail, maka tail diubah menjadi Node2
		if (Node1 == tail) {
			tail = Node2;
		}
		// jika Node2 adalah tail, maka tail diubah menjadi Node1.
		else if (Node2 == tail) {
			tail = Node1;
		}

		// Swapping Node1 and Node2
		// Mendeklarasikan variabel sementara temp bertipe WeaponWarrior.
		WeaponWarrior temp;

		temp = Node1.next; // Menyimpan node yang berada setelah Node1 ke dalam temp.
		Node1.next = Node2.next; // Menghubungkan Node1 ke node yang berada setelah Node2.
		Node2.next = temp; // Menghubungkan Node2 ke node yang sebelumnya berada setelah Node1.

		// Jika node yang berada setelah Node1 tidak kosong, atur prev node tersebut
		// menjadi Node1.
		if (Node1.next != null) {
			Node1.next.prev = Node1;
		}
		// Jika node yang berada setelah Node2 tidak kosong, atur prev node tersebut
		// menjadi Node2.
		if (Node2.next != null) {
			Node2.next.prev = Node2;
		}

		// Menyimpan node yang berada sebelum Node1 ke dalam temp.
		temp = Node1.prev;
		Node1.prev = Node2.prev; // Menghubungkan Node1 ke node yang berada sebelum Node2.
		Node2.prev = temp; // Menghubungkan Node2 ke node yang sebelumnya berada sebelum Node1.

		// Jika node yang berada sebelum Node1 tidak kosong, atur next node tersebut
		// menjadi Node1.
		if (Node1.prev != null) {
			Node1.prev.next = Node1;
		}
		// Jika node yang berada sebelum Node2 tidak kosong, atur next node tersebut
		// menjadi Node2.
		if (Node2.prev != null) {
			Node2.prev.next = Node2;
		}
	}

	// fungsi linearSearch(int targetStok) melakukan pencarian linear atau pencarian
	// berurutan dalam linked list WeaponWarrior berdasarkan stok atau stok yang
	// ditargetkan.
	WeaponWarrior linearSearch(int targetStok) { // menerima satu argumen berupa nilai targetStok yang ingin dicari di
													// dalam linked list WeaponWarrior.

		// Membuat sebuah variabel current yang merupakan referensi ke head
		// atau awal dari linked list. Variabel ini akan digunakan untuk melintasi
		// linked list selama pencarian.
		WeaponWarrior current = head;

		// Memulai perulangan untuk memeriksa setiap elemen dalam linked list.
		// Perulangan
		// akan berlangsung selama current tidak bernilai null, artinya masih ada elemen
		// yang diperiksa.
		while (current != null) {
			// Memeriksa apakah nilai stok dari current sama dengan targetStok yang ingin
			// dicari.
			if (current.stok == targetStok) {
				// Jika nilai stok dari current sama dengan targetStok, maka current
				// dikembalikan sebagai hasil pencarian
				return current;
			}
			// current dipindahkan ke elemen berikutnya dalam linked list untuk melanjutkan
			// pencarian.
			current = current.next;
		}
		// Jika perulangan selesai dan tidak ada elemen lain dalam linked list
		// yang memiliki nilai stok sesuai dengan targetStok, maka fungsi mengembalikan
		// null
		return null;
	}

	// fungsi findIndex(int targetStok) bertujuan untuk
	// mencari indeks dari node yang memiliki nilai stok yang sama dengan targetStok
	int findIndex(int targetStok) {

		// Membuat sebuah variabel current yang merupakan referensi ke head
		// atau awal dari linked list. Variabel ini akan digunakan untuk melintasi
		// linked list selama pencarian.
		WeaponWarrior current = head;

		// Menginisialisasi variabel i (sebagai counter) dengan nilai 0 yang akan
		// digunakan untuk melacak indeks dari node saat traversal linked list.
		int i = 0;

		// Memulai perulangan while untuk melakukan iterasi melalui linked list hingga
		// mencapai akhir (sampai current menjadi null).
		while (current != null) {
			// Setiap iterasi, variabel i akan bertambah satu, merepresentasikan indeks saat
			// ini dari node dalam linked list.
			i++;

			// memeriksa apakah nilai stok dari node saat ini (current.stok) sama dengan
			// targetStok yang ingin dicari.
			if (current.stok == targetStok) {
				// Jika ya, fungsi akan mengembalikan indeks (i) saat ini sebagai posisi dari
				// node yang memiliki nilai stok yang dicari.
				return i;
			}
			// Memindahkan pointer current ke node berikutnya dalam linked list untuk
			// melanjutkan iterasi.
			current = current.next;
		}
		return -1;
	}

	WeaponWarrior middleNode(WeaponWarrior start, WeaponWarrior last) { // menerima dua parameter, start dan last, yang
		// merepresentasikan dua node dalam linked list.
		// Jika start adalah null, maka fungsi mengembalikan null.
		if (start == null)
			return null;

		// Pointer slow bergerak satu langkah setiap iterasi
		WeaponWarrior slow = start;
		// pointer fast bergerak dua langkah.
		WeaponWarrior fast = start.next;

		// Looping berlangsung selama fast bukan last.
		while (fast != last) {

			fast = fast.next;

			// Saat fast bukan last, pointer slow bergeser satu langkah dan fast bergeser
			// dua langkah.
			if (fast != last) {
				slow = slow.next;
				fast = fast.next;
			}
		}
		// mengembalikan slow, yang merupakan node tengah di antara start dan last.
		return slow;
	}

	WeaponWarrior binarySearch(WeaponWarrior head, int value) {
		WeaponWarrior start = head;
		WeaponWarrior last = null;

		if (start.stok == value) {
			return start;
		}

		do {
			WeaponWarrior mid = middleNode(start, last);

			if (mid == null)
				return null;
			if (mid.stok == value)
				return mid;

			else if (mid.stok < value) {
				start = mid.next;
			} else
				last = mid;
		} while (last == null || last != start);

		return null;
	}

	WeaponWarrior sortedInsertDesc(WeaponWarrior awal, WeaponWarrior newNode) {
		WeaponWarrior current;

		if (awal == null)
			awal = newNode;

		else if (awal.stok >= newNode.stok) {
			newNode.next = awal;
			newNode.next.prev = newNode;
			awal = newNode;
		}

		else {
			current = awal;

			while (current.next != null && current.next.stok < newNode.stok)
				current = current.next;

			newNode.next = current.next;

			if (current.next != null)
				newNode.next.prev = newNode;

			current.next = newNode;
			newNode.prev = current;
		}
		return awal;
	}

	void insertionSortDesc() {
		// DESCENDING
		WeaponWarrior sorted = null;
		WeaponWarrior current = head;
		while (current != null) {

			WeaponWarrior next = current.next;

			current.prev = current.next = null;

			sorted = sortedInsertDesc(sorted, current);
			current = next;
		}

		head = sorted;
	}

	WeaponWarrior sortedInsertAsc(WeaponWarrior awal, WeaponWarrior newNode) {
		WeaponWarrior current;

		if (awal == null)
			awal = newNode;

		else if (awal.stok <= newNode.stok) {
			newNode.next = awal;
			newNode.next.prev = newNode;
			awal = newNode;
		}

		else {
			current = awal;

			while (current.next != null && current.next.stok > newNode.stok)
				current = current.next;

			newNode.next = current.next;

			if (current.next != null)
				newNode.next.prev = newNode;

			current.next = newNode;
			newNode.prev = current;
		}
		return awal;
	}

	void insertionSortAsc() {
		// ASCENDING
		WeaponWarrior sorted = null;
		WeaponWarrior current = head;
		while (current != null) {

			WeaponWarrior next = current.next;

			current.prev = current.next = null;

			sorted = sortedInsertAsc(sorted, current);
			current = next;
		}

		head = sorted;
	}

	// fungsi bubblesort() di bawah adalah implementasi algoritma Bubble Sort pada
	// sebuah double linked list.
	void bubbleSort() {
		// memeriksa apakah linked list kosong atau hanya memiliki satu elemen.
		if (head == null || head.next == null)
			// Jika iya, tidak ada yang perlu diurutkan, sehingga fungsi akan langsung
			// mengembalikan nilai.
			return;

		// Membuat variabel swapped yang akan menandai apakah terjadi pertukaran elemen
		// saat iterasi dilakukan.
		boolean swapped;
		// Mendeklarasikan last sebagai pointer yang akan menunjuk ke elemen terakhir
		// dalam proses iterasi.
		WeaponWarrior last = null;

		do { // Memulai blok do-while

			// Menginisialisasi variabel swapped ke false di setiap iterasi baru
			// untuk menandai bahwa belum ada pertukaran elemen yang dilakukan.
			swapped = false;
			// Inisialisasi pointer current untuk menunjuk ke head (awal) dari linked list.
			WeaponWarrior current = head;

			// Memulai iterasi melalui linked list sampai last. Ini akan memeriksa elemen
			// saat ini dengan elemen berikutnya.
			while (current.next != last) {
				// Memeriksa apakah nilai stok dari current lebih besar dari stok elemen
				// berikutnya.
				if (current.stok > current.next.stok) {
					// Jika iya, akan dilakukan pertukaran elemen.
					// Memanggil fungsi swap untuk menukar posisi dua elemen.
					swap(current, current.next);

					// Menggerakkan pointer current ke elemen sebelumnya setelah pertukaran
					// dilakukan.
					current = current.prev;

					// Menandai bahwa ada pertukaran yang terjadi dalam iterasi ini.
					swapped = true;
				}

				// Memindahkan pointer current ke elemen berikutnya dalam linked list.
				current = current.next;
			}

			// Memperbarui last menjadi elemen terakhir yang telah diperiksa.
			last = current;

			// Mengulangi proses iterasi sampai tidak ada lagi pertukaran
			// yang dilakukan dalam satu iterasi, menandakan bahwa linked list sudah
			// terurut.
		} while (swapped);

	}

	void quickSort(WeaponWarrior awal, WeaponWarrior atas) {
		if (awal != atas && atas != null && awal != atas.next) {
			WeaponWarrior pivot = partition(awal, atas);
			quickSort(awal, pivot.prev);
			quickSort(pivot.next, atas);
		}
	}

	WeaponWarrior partition(WeaponWarrior awal, WeaponWarrior atas) {
	    WeaponWarrior pivot = atas;
	    WeaponWarrior i = awal.prev;
	    WeaponWarrior curr = awal;

	    while (curr != atas) {
	        if (curr.stok <= pivot.stok) {
	            if (i == null) {
	                i = awal;
	            } else {
	                i = i.next;
	            }

	            if (i != curr) {
	                swap(i, curr);
	            }
	        }
	        curr = curr.next;
	    }

	    if (i == null) {
	        i = awal;
	    } else {
	        i = i.next;
	    }

	    if (i != atas) {
	        swap(i, atas);
	    }

	    return i;
	}

	// deklarasi dari fungsi mergeSort yang menerima sebagai input node pertama dari
	// linked list dan mengembalikan node pertama dari linked list yang telah
	// diurutkan.
	public WeaponWarrior mergeSort(WeaponWarrior head) {
		// ASCENDING

		// Jika linked list kosong atau hanya memiliki satu node, maka langsung
		if (head == null || head.next == null)
			// mengembalikan head karena sudah dianggap terurut.
			return head;

		// Mendapatkan node tengah dari linked list menggunakan fungsi getMiddle.
		WeaponWarrior middle = getMiddle(head);
		// Menyimpan referensi ke node setelah tengah untuk membagi linked list menjadi
		// dua bagian.
		WeaponWarrior nextMiddle = middle.next;
		// Memutuskan koneksi dari node tengah ke node setelahnya untuk membagi linked
		// list menjadi dua bagian terpisah.
		middle.next = null;

		// Rekursi untuk membagi dan mengurutkan bagian kiri dari linked list dari head
		// hingga middle.
		WeaponWarrior left = mergeSort(head);
		// Rekursi untuk membagi dan mengurutkan bagian kanan dari linked list dari
		// nextMiddle hingga node terakhir.
		WeaponWarrior right = mergeSort(nextMiddle);

		// Menggabungkan dan mengurutkan dua bagian terurut dari linked list menggunakan
		// fungsi merge yang akan mengembalikan linked list yang sudah diurutkan secara
		// keseluruhan.
		return merge(left, right);
	}

	// fungsi getMiddle berfungsi untuk mendapatkan node tengah dari linked list.
	// yang menerima node pertama dari linked list dan mengembalikan node tengah
	// dari linked list.
	private WeaponWarrior getMiddle(WeaponWarrior head) {
		// Jika linked list kosong, maka langsung mengembalikan head.
		if (head == null)
			return head;

		// Membuat dua node penunjuk (slow dan fast) yang awalnya menunjuk ke node
		// pertama dari linked list.
		WeaponWarrior slow = head, fast = head;

		// Melakukan iterasi untuk mencari node tengah. Kondisi fast.next != null
		// memastikan bahwa fast bukan node terakhir dan fast.next.next != null
		// memastikan bahwa setidaknya masih ada dua node setelah fast.
		while (fast.next != null && fast.next.next != null) {
			// Node slow maju satu langkah setiap iterasi.
			slow = slow.next;
			// Node fast maju dua langkah setiap iterasi untuk mencapai tengah linked list
			// dengan kecepatan dua kali lipat dari slow.
			fast = fast.next.next;
		}
		// Ketika loop selesai, slow akan berada di tengah linked list dan kemudian akan
		// dikembalikan sebagai node tengah dari linked list.
		return slow;
	}

	// Fungsi merge yang menggabungkan dua bagian terurut dari linked list dan
	// mengembalikan node awal dari linked list yang sudah digabungkan.
	private WeaponWarrior merge(WeaponWarrior left, WeaponWarrior right) {
		// Inisialisasi variabel result yang akan menyimpan node awal dari linked list
		// yang sudah digabungkan.
		WeaponWarrior result = null;

		// Jika bagian kiri dari linked list kosong,
		if (left == null)
			// kembalikan bagian kanan karena sudah terurut dan tidak perlu digabung.
			return right;
		// Jika bagian kanan dari linked list kosong,
		if (right == null)
			// kembalikan bagian kiri karena sudah terurut dan tidak perlu digabung.
			return left;

		// Membandingkan nilai stok (sebagai kunci pengurutan) dari node pada bagian
		// kiri dengan node pada bagian kanan.
		if (left.stok <= right.stok) {
			// Jika nilai stok pada node bagian kiri lebih kecil atau sama dengan nilai stok
			// pada node bagian kanan, node pertama yang akan menjadi bagian awal dari hasil
			// penggabungan adalah node kiri.
			result = left;
			// Menggabungkan bagian berikutnya dari bagian kiri dengan keseluruhan bagian
			// kanan menggunakan rekursi.
			result.next = merge(left.next, right);
			// Mengatur referensi ke node sebelumnya pada node yang akan digabungkan dengan
			// memperbarui prev.
			result.next.prev = result;
		} else { // Jika nilai stok pada node bagian kanan lebih kecil dari node bagian kiri,
			// Node pertama yang akan menjadi bagian awal dari hasil penggabungan adalah
			// node kanan.
			result = right;
			// Menggabungkan bagian berikutnya dari bagian kanan dengan keseluruhan bagian
			// kiri menggunakan rekursi.
			result.next = merge(left, right.next);
			// Mengatur referensi ke node sebelumnya pada node yang akan digabungkan dengan
			// memperbarui prev.
			result.next.prev = result;
		}
		// Mengembalikan node awal dari linked list yang sudah digabungkan secara
		// terurut.
		return result;
	}

}

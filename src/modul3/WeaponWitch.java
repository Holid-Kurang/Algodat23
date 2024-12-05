package modul3;

public class WeaponWitch {
	String nama;
	int stok;
	int harga;
	boolean pivotflag = false;
	WeaponWitch next;
	WeaponWitch prev;

	WeaponWitch(String nama, int stok, int harga) {
		this.nama = nama;
		this.stok = stok;
		this.harga = harga;
	}

}

class DoubleWitch {
	/*
	 * dilakukan inisialisasi kelas WeaponWitch dengan nama head untuk mengacu ke
	 * elemen awal pada doublelinkedlist dan tail untuk mengacu ke elemen akhir pada
	 * doublelinkedlist
	 */
	WeaponWitch head, tail;

	/*
	 * fungsi metode addFirst pada kelas doublelinkedlist dibawah bertujuan untuk
	 * menambah elemen / node baru pada bagian depan atau awal double linked list
	 * 
	 */
	void addFirst(String nama, int stok, int harga) {
		// Membuat node baru newWeaponWitch dengan nilai-nilai yang diterima
		// (nama senjata, stok senjata dan harga senhata).
		WeaponWitch newWeaponWitch = new WeaponWitch(nama, stok, harga);
		/*
		 * Memeriksa apakah head (kepala) dari linked list kosong. Jika iya (linked list
		 * kosong), node baru newWeaponWitch diatur sebagai kepala (head) dan ekor
		 * (tail) dari linked list karena hanya ada satu node.
		 */
		if (head == null) {
			tail = newWeaponWitch;
			head = tail;
		}
		/*
		 * Jika linked list tidak kosong, newWeaponWitch yang baru ditambahkan harus
		 * dihubungkan ke kepala(elemen awal) yang ada sebelumnya.
		 */
		else {
			// menentukan bahwa newWeaponWitch akan mengikuti node berikutnya dari head.
			newWeaponWitch.next = head;
			// mendefinisikan bahwa node yang sebelumnya adalah kepala (head) akan memiliki
			// node newWeaponWitch sebagai node sebelumnya.
			head.prev = newWeaponWitch;
			// mengatur newNodebuku sebagai head(elemen) baru pada linked list
			head = newWeaponWitch;
		}
	}

	/*
	 * metode addLast pada kelas doublelinkedlist dibawah bertujuan untuk menambah
	 * elemen / node baru pada bagian belakang atau akhir double linked list
	 */
	void addLast(String nama, int stok, int harga) {
		// Membuat node baru newWeaponWitch dengan nilai-nilai yang diterima
		// (nama senjata, stok senjata dan harga senhata).
		WeaponWitch newWeaponWitch = new WeaponWitch(nama, stok, harga);
		/*
		 * Memeriksa apakah head (kepala) dari linked list kosong. Jika iya (linked list
		 * kosong), node baru newWeaponWitch diatur sebagai kepala (head) dan ekor
		 * (tail) dari linked list karena hanya ada satu node.
		 */
		if (head == null) {
			tail = newWeaponWitch;
			head = tail;
		}
		// Jika linked list sudah memiliki node atau elemen,
		else {
			// newWeaponWitch ditambahkan setelah node terakhir (tail).
			tail.next = newWeaponWitch;
			/*
			 * newWeaponWitch diatur sebagai node sebelumnya (prev) dari node berikutnya
			 * (tail) dan kemudian dijadikan node terakhir dalam linked list (tail di-update
			 * menjadi newWeaponWitch).
			 */
			newWeaponWitch.prev = tail;
			tail = newWeaponWitch;
		}
	}

	/*
	 * method addAfter dalam linked list menambahkan node setelah suatu indeks
	 * tertentu pada linked list tersebut.
	 */
	void addAfter(int index, String nama, int stok, int harga) {
		// Membuat node baru newWeaponWitch dengan nilai-nilai yang diterima
		// (nama senjata, stok senjata dan harga senhata).
		WeaponWitch newWeaponWitch = new WeaponWitch(nama, stok, harga);

		// Mendeklarasikan current sebagai node awal, yaitu head double dari linked
		// list.
		WeaponWitch current = head;

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
		 * Jika linked list kosong (pertama kali), maka newWeaponWitch menjadi head dan
		 * tail dari linked list.
		 */
		if (head == null) {
			tail = newWeaponWitch;
			head = tail;
		}
		/*
		 * Jika current bukan node terakhir dalam linked list, maka newWeaponWitch akan
		 * dimasukkan di antara current dan current.next.
		 */
		else if (current.next != null) {
			newWeaponWitch.prev = current;
			newWeaponWitch.next = current.next;
			current.next.prev = newWeaponWitch;
			current.next = newWeaponWitch;
		}
		/*
		 * Jika current adalah node terakhir, maka newWeaponWitch akan ditambahkan
		 * setelah tail.
		 */
		else if (current.next == null) {
			tail.next = newWeaponWitch;
			newWeaponWitch.prev = tail;
			tail = newWeaponWitch;
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
		WeaponWitch current = head;

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
		WeaponWitch current = head;
		while (current != null) {
			System.out.println("id   : " + current);
			System.out.println("nama : " + current.nama);
			System.out.println("stok : " + current.stok);
			System.out.println();
			current = current.next;
		}
	}

	void printHarga() {
		WeaponWitch current = head;
		while (current != null) {
			System.out.println("id   : " + current);
			System.out.println("nama : " + current.nama);
			System.out.println("harga: " + current.harga);
			System.out.println();
			current = current.next;
		}
	}

	void print() {
		WeaponWitch current = head;
		while (current != null) {
			System.out.println("nama : " + current.nama);
			System.out.println("stok : " + current.stok);
			System.out.println("harga: " + current.harga);
			System.out.println();
			current = current.next;
		}
	}

	// fungsi findIndex(int targetStok) bertujuan untuk
	// mencari indeks dari node yang memiliki nilai stok yang sama dengan targetStok
	int findIndex(int targetHarga) {

		// Membuat sebuah variabel current yang merupakan referensi ke head
		// atau awal dari linked list. Variabel ini akan digunakan untuk melintasi
		// linked list selama pencarian.
		WeaponWitch current = head;

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
			if (current.harga == targetHarga) {
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

	// middleNode merupakan fungsi yang mencari dan mengembalikan node tengah di
	// antara dua node dalam linked list.
	WeaponWitch middleNode(WeaponWitch start, WeaponWitch last) { // menerima dua parameter, start dan last, yang
																	// merepresentasikan dua node dalam linked list.
		// Jika start adalah null, maka fungsi mengembalikan null.
		if (start == null)
			return null;

		// Pointer slow bergerak satu langkah setiap iterasi
		WeaponWitch slow = start;
		// pointer fast bergerak dua langkah.
		WeaponWitch fast = start.next;

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

	// binarySearch adalah fungsi pencarian biner dalam linked list.
	// Fungsi ini menerima dua parameter, head yang merupakan awal dari linked list
	// dan value yang akan dicari.
	WeaponWitch binarySearch(WeaponWitch head, int value) {

		// inisialisasi dua node, start yang merepresentasikan awal linked list, dan
		// last yang awalnya diatur ke null.
		WeaponWitch start = head;
		WeaponWitch last = null;

		// terdapat sebuah loop do-while yang berjalan selama last masih null atau last
		// tidak sama dengan start.
		do {
			// menggunakan middleNode untuk mencari mid, yaitu node tengah di antara start
			// dan last.
			WeaponWitch mid = middleNode(start, last);

			// Jika mid adalah null,
			if (mid == null)
				// maka fungsi mengembalikan null.
				return null;
			// Jika nilai dari harga pada mid sama dengan value,
			if (mid.harga == value)
				// maka fungsi mengembalikan mid.
				return mid;

			// Jika nilai dari harga pada mid lebih besar dari value,
			else if (mid.harga > value) {
				// maka pointer start diperbarui menjadi mid.next.
				start = mid.next;
			}
			// Jika tidak
			else
				// maka last diatur menjadi mid.
				last = mid;
		} while (last == null || last != start);

		// Jika looping selesai dan last sama dengan start, maka fungsi mengembalikan
		// null.
		// Jika tidak ditemukan nilai yang dicari, fungsi juga mengembalikan null.
		return null;
	}

	// Mendefinisikan fungsi untuk melakukan algoritma selection sort.
	void selectionSort() {
		// DESCENDING

		// jika linked list kosong atau hanya memiliki satu elemen, maka tidak perlu
		// dilakukan pengurutan.
		if (head == null || head.next == null)
			return;

		// Menginisialisasi node saat ini sebagai node pertama dari linked list.
		WeaponWitch current = head;
		// Looping akan terus berjalan selama node saat ini tidak kosong.
		while (current != null) {
			// Menginisialisasi node maxNode dengan node saat ini.
			WeaponWitch maxNode = current;
			// Menginisialisasi node runner dengan node berikutnya dari node saat ini.
			WeaponWitch runner = current.next;

			// Looping yang akan memindahkan runner ke node berikutnya selama node runner
			// tidak kosong.
			while (runner != null) {

				// Jika stok pada runner lebih besar dari maxNode
				if (runner.stok > maxNode.stok) { // Ubah dari '<' menjadi '>'
					// aka maxNode akan diubah menjadi runner.
					maxNode = runner;
				}

				// Pemindahan ke node berikutnya dalam linked list untuk membandingkan nilai
				// stok selanjutnya.
				runner = runner.next;
			}

			// Menginisialisasi objek sementara (temp )dengan node maxNode.
			WeaponWitch temp = maxNode;

			// Jika maxNode bukanlah node saat ini (current),
			if (maxNode != current) {
				// Swap data of current and maxNode
				// maka dilakukan pertukaran data antara maxNode dan current
				swap(maxNode, current);

				// current diatur kembali ke temp (nilai sebelum pertukaran).
				current = temp;
			}
			// Pemindahan ke node berikutnya dalam linked list untuk membandingkan nilai
			// stok selanjutnya.
			current = current.next;
		}
	}

	// Fungsi swap pada kode yang diberikan bertujuan untuk
	// menukar posisi dua node (Node1 dan Node2) dalam double linked list
	void swap(WeaponWitch Node1, WeaponWitch Node2) {

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
		// Mendeklarasikan variabel sementara temp bertipe WeaponWitch.
		WeaponWitch temp;

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

	WeaponWitch sortedInsert(WeaponWitch awal, WeaponWitch newNode) {
		WeaponWitch current;

		if (awal == null)
			awal = newNode;

		else if (awal.harga <= newNode.harga) {
			newNode.next = awal;
			newNode.next.prev = newNode;
			awal = newNode;
		}

		else {
			current = awal;

			while (current.next != null && current.next.harga > newNode.harga)
				current = current.next;

			newNode.next = current.next;

			if (current.next != null)
				newNode.next.prev = newNode;

			current.next = newNode;
			newNode.prev = current;
		}
		return awal;
	}

	void insertionSort() {
		// DESCENDING
		WeaponWitch sorted = null;
		WeaponWitch current = head;
		while (current != null) {

			WeaponWitch next = current.next;

			current.prev = current.next = null;

			sorted = sortedInsert(sorted, current);
			current = next;
		}

		head = sorted;
	}

	// metode size() ini bekerja menghitung jumlah total elemen, dan mengembalikan
	// jumlah elemen
	int size() {
		// mendeklarasikan sebuah variabel temp dari tipe WeaponWitch dan
		// menginisialisasinya dengan head. Variabel temp ini digunakan untuk melakukan
		// perulangan melalui linked list.
		WeaponWitch temp = head;

		// Membuat variabel count bertipe int yang awalnya diatur ke nilai 0.
		int count = 0;
		// sebuah loop while. Loop ini akan terus berjalan selama temp (yang menunjukkan
		// pada node saat ini dalam linked list) tidak kosong atau null.
		while (temp != null) {
			// Pada setiap iterasi loop, nilai dari count akan ditambah satu. Ini berarti
			// bahwa setiap kali loop dijalankan, kami menambahkan satu pada jumlah elemen
			// yang terhitung.
			count++;

			// temp diperbarui untuk menunjuk ke node berikutnya dalam linked list. Dengan
			// melakukan ini, kita bergerak maju dalam linked list untuk menghitung jumlah
			// total elemen.
			temp = temp.next;
		}
		// Setelah loop selesai berjalan (karena temp menjadi null saat mencapai akhir
		// linked list), metode ini mengembalikan nilai dari count. Nilai ini mewakili
		// jumlah total elemen dalam linked list.
		return count;
	}

	void shellSort() {
		// Variabel n diinisialisasi dengan ukuran total elemen dalam linked list.
		// Fungsi size() digunakan untuk mengembalikan jumlah total elemen dalam linked
		// list.
		int n = size();

		// Menghitung interval awal untuk shell sort

		// Variabel interval diinisialisasi dengan nilai 1. Ini adalah interval awal
		// untuk algoritma shell sort.
		int interval = 1;

		// Perulangan untuk menghitung interval yang akan digunakan untuk shell sort.
		// Interval diupdate dengan mengalikan nilai interval sebelumnya dengan 3 dan
		// menambahkannya dengan 1, hingga interval mencapai sepertiga dari total elemen
		// dalam linked list.
		while (interval < n / 3) {
			interval = interval * 3 + 1;
		}

		// Perulangan untuk melakukan sorting dengan menggunakan algoritma shell sort.
		// Ini akan terus berjalan selama nilai interval lebih besar dari 0.
		while (interval > 0) {
			// Perulangan luar yang melintasi elemen-elemen dalam linked list, dimulai dari
			// interval hingga elemen terakhir.
			for (int outer = interval; outer < n; outer++) {
				// Variabel temp menyimpan nilai elemen pada indeks outer. Fungsi getNodeAt()
				// digunakan untuk mendapatkan elemen pada posisi yang ditentukan.
				WeaponWitch temp = getNodeAt(outer);

				// Variabel inner diinisialisasi dengan nilai outer.
				int inner = outer;

				// Perbandingan dan penukaran
				// Perulangan dalam untuk membandingkan nilai elemen dan menukar mereka jika
				// diperlukan. Proses ini berjalan selama nilai inner lebih besar dari interval
				// - 1 (agar tidak keluar dari indeks batas) dan nilai harga elemen pada posisi
				// inner - interval lebih besar dari atau sama dengan harga elemen yang disimpan
				// di temp.
				while (inner > interval - 1 && getNodeAt(inner - interval).harga >= temp.harga) {
					// Jika kondisi pada poin sebelumnya terpenuhi, fungsi swap dipanggil untuk
					// menukar dua elemen dalam linked list.
					swap(getNodeAt(inner), getNodeAt(inner - interval));
					// Nilai inner dikurangi dengan nilai interval untuk melanjutkan perulangan ke
					// elemen berikutnya.
					inner -= interval;
				}
			}
			interval = (interval - 1) / 3; // Mengurangi interval
		}
	}

	// deklarasi fungsi getNodeAt yang mengembalikan sebuah node dari jenis
	// WeaponWitch dan menerima satu parameter berupa index.
	WeaponWitch getNodeAt(int index) {
		// Membuat variabel sementara (temp) yang diinisialisasi dengan nilai dari head.
		// Pada awalnya, temp menunjuk pada node pertama di dalam linked list.
		WeaponWitch temp = head;

		// Loop for yang akan melakukan iterasi sebanyak index kali. Ini berguna untuk
		// mencari node pada posisi yang sesuai.
		for (int i = 0; i < index && temp != null; i++) {
			// Menggerakkan temp ke node selanjutnya di dalam linked list. Setiap iterasi
			// ini memindahkan temp ke node berikutnya dalam list.
			temp = temp.next;
		}
		// Mengembalikan nilai dari variabel temp. Pada saat loop selesai, temp menunjuk
		// pada node yang berada pada posisi index yang diinginkan dalam linked list,
		// atau null jika node tersebut tidak ditemukan (misalnya, jika index melebihi
		// panjang linked list).
		return temp;
	}

	void quickSort(WeaponWitch awal, WeaponWitch atas) {
	    if (awal != atas && atas != null && awal != atas.next) {
	        WeaponWitch pivot = partition(awal, atas);
	        quickSort(awal, pivot.prev);
	        quickSort(pivot.next, atas);
	    }
	}

	WeaponWitch partition(WeaponWitch awal, WeaponWitch atas) {
	    WeaponWitch pivot = atas;
	    WeaponWitch curr = awal;
	    WeaponWitch i = awal.prev;

	    while (curr != pivot) {
	        if (curr.stok <= pivot.stok) {
	        	if (i == null) {
	        	    i = awal;
	        	} else {
	        	    i = i.next;
	        	}
	        	int temp = i.stok;
	            i.stok = curr.stok;
	            curr.stok = temp;
	        }
	        curr = curr.next;
	    }

	    if (i == null) {
	        i = awal;
	    } else {
	        i = i.next;
	    }
	    int temp = i.stok;
	    i.stok = pivot.stok;
	    pivot.stok = temp;

	    return i;
	}

	// deklarasi dari fungsi mergeSort yang menerima sebagai input node pertama dari
	// linked list dan mengembalikan node pertama dari linked list yang telah
	// diurutkan.
	public WeaponWitch mergeSort(WeaponWitch head) {
		// ASCENDING

		// Jika linked list kosong atau hanya memiliki satu node, maka langsung
		if (head == null || head.next == null)
			// mengembalikan head karena sudah dianggap terurut.
			return head;

		// Mendapatkan node tengah dari linked list menggunakan fungsi getMiddle.
		WeaponWitch middle = getMiddle(head);
		// Menyimpan referensi ke node setelah tengah untuk membagi linked list menjadi
		// dua bagian.
		WeaponWitch nextMiddle = middle.next;
		// Memutuskan koneksi dari node tengah ke node setelahnya untuk membagi linked
		// list menjadi dua bagian terpisah.
		middle.next = null;

		// Rekursi untuk membagi dan mengurutkan bagian kiri dari linked list dari head
		// hingga middle.
		WeaponWitch left = mergeSort(head);
		// Rekursi untuk membagi dan mengurutkan bagian kanan dari linked list dari
		// nextMiddle hingga node terakhir.
		WeaponWitch right = mergeSort(nextMiddle);

		// Menggabungkan dan mengurutkan dua bagian terurut dari linked list menggunakan
		// fungsi merge yang akan mengembalikan linked list yang sudah diurutkan secara
		// keseluruhan.
		return merge(left, right);
	}

	// fungsi getMiddle berfungsi untuk mendapatkan node tengah dari linked list.
	// yang menerima node pertama dari linked list dan mengembalikan node tengah
	// dari linked list.
	private WeaponWitch getMiddle(WeaponWitch head) {
		// Jika linked list kosong, maka langsung mengembalikan head.
		if (head == null)
			return head;

		// Membuat dua node penunjuk (slow dan fast) yang awalnya menunjuk ke node
		// pertama dari linked list.
		WeaponWitch slow = head, fast = head;

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
	private WeaponWitch merge(WeaponWitch left, WeaponWitch right) {
		// Inisialisasi variabel result yang akan menyimpan node awal dari linked list
		// yang sudah digabungkan.
		WeaponWitch result = null;

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
package modul1;

/* class NodeBuku dibawah berperan sebagai tempat atau wadah untuk menyimpan informasi
 * informasi tentang buku dan mengelola hubungan antara node node buku dalam doublelinkedlist
 * 
 */
class NodeBuku {
	/*
	 * variabel variabel atau atribut dibawah akan 
	 * menyimpan informasi terkait dengan sebuah buku dengan tipe data object.
	 * 
	 * Object nama, penulis, bahasa, halaman, ratings, dan kategori adalah atribut 
	 * (variabel) yang menyimpan informasi terkait dengan sebuah buku. 
	 * Masing-masing atribut ini menampung informasi seperti nama buku, 
	 * penulis, bahasa buku, jumlah halaman, peringkat, dan kategori buku.
	 */
	Object nama;
	Object penulis;
	Object bahasa;
	Object halaman;
	Object ratings;
	Object kategori;
	
	/* 
	 * NodeBuku next dan NodeBuku prev adalah atribut yang mengacu pada node berikutnya (next) 
	 * dan sebelumnya (prev) dalam struktur linked list (untuk linked list jenis double linked list). 
	 * Dalam konteks linked list, next dan prev menyimpan referensi ke node berikutnya dan sebelumnya dalam urutan terkait.
	 */
	NodeBuku next = null;
	NodeBuku prev = null;
	
	/*
	 * methode constructor(NodeBuku) dibawah digunakan untuk membuat node baru ketika objek dari kelas NodeBuku
	 * diinisialisasi. saat membuat objek node baru, methode constructor menerima parameter seperti, nama, penulis, 
	 * bahasa, halaman, ratings, dan kategori, dan kemudian menginisialisasi atribut-atribut node 
	 * tersebut dengan nilai yang diberikan dalam parameter konstruktor..
	 */
	NodeBuku(Object nama, Object penulis, Object bahasa, Object halaman, Object ratings, Object kategori) {
		this.nama = nama;
		this.penulis = penulis;
		this.bahasa = bahasa;
		this.halaman = halaman;
		this.ratings = ratings;
		this.kategori = kategori;
	}
}
class doubleLinkedList {
	/*
	 * dilakukan inisialisasi kelas Nodebuku dengan nama head untuk mengacu ke elemen awal pada doublelinkedlist
	 * dan tail untuk mengacu ke elemen akhir pada doublelinkedlist
	 */
	NodeBuku head, tail;
	
	/* fungsi metode addFirst pada kelas doublelinkedlist dibawah bertujuan untuk menambah elemen / node baru
	 * pada bagian depan atau awal double linked list
	 * 
	 */
	void addFirst(Object nama, Object penulis, Object bahasa, Object halaman, Object ratings, Object kategori) {
		//Membuat node baru newNodeBuku dengan nilai-nilai yang diterima 
		//(nama buku, penulis, bahasa, jumlah halaman, rating, dan kategori).
		NodeBuku newNodeBuku = new NodeBuku( nama, penulis, bahasa, halaman, ratings, kategori);
		/*
		 * Memeriksa apakah head (kepala) dari linked list kosong. Jika iya (linked list kosong), 
		 * node baru newNodeBuku diatur sebagai kepala (head) dan ekor (tail) 
		 * dari linked list karena hanya ada satu node.
		 */
		if (head == null) {
			tail = newNodeBuku;
			head = tail;
		} 
		/*
		 * Jika linked list tidak kosong, newNodeBuku yang baru ditambahkan harus dihubungkan ke kepala(elemen awal) yang ada sebelumnya.
		 */
		else {
			//menentukan bahwa newNodeBuku akan mengikuti node berikutnya dari head.
			newNodeBuku.next = head;
			//mendefinisikan bahwa node yang sebelumnya adalah kepala (head) akan memiliki node newNodeBuku sebagai node sebelumnya.
			head.prev = newNodeBuku;
			//mengatur newNodebuku sebagai head(elemen) baru pada linked list
			head = newNodeBuku;
		}
	}
	
	/* metode addLast pada kelas doublelinkedlist dibawah bertujuan untuk menambah elemen / node baru
	 * pada bagian belakang atau akhir double linked list
	 */
	void addLast(Object nama, Object penulis, Object bahasa, Object halaman, Object ratings, Object kategori) {
		//Membuat node baru newNodeBuku dengan nilai-nilai yang diterima 
		//(nama buku, penulis, bahasa, jumlah halaman, rating, dan kategori).
		NodeBuku newNodeBuku = new NodeBuku( nama, penulis, bahasa, halaman, ratings, kategori);
		/*
		 * Memeriksa apakah head (kepala) dari linked list kosong. Jika iya (linked list kosong), 
		 * node baru newNodeBuku diatur sebagai kepala (head) dan ekor (tail) 
		 * dari linked list karena hanya ada satu node.
		 */
		if (head == null) {
			tail = newNodeBuku;
			head = tail;
		} 
		//Jika linked list sudah memiliki node atau elemen, 
		else {
			//newNodeBuku ditambahkan setelah node terakhir (tail).
			tail.next = newNodeBuku;
			/*
			 * newNodeBuku diatur sebagai node sebelumnya (prev) dari node berikutnya (tail) 
			 * dan kemudian dijadikan node terakhir dalam linked list (tail di-update menjadi newNodeBuku).
			 */
			newNodeBuku.prev = tail;
			tail = newNodeBuku;
		}
	}

	/*
	 * method addAfter dalam linked list menambahkan node setelah suatu indeks tertentu pada linked list tersebut.
	 */
	void addAfter(int index, Object nama, Object penulis, Object bahasa, Object halaman, Object ratings, Object kategori) {
		//Membuat node baru newNodeBuku dengan nilai-nilai yang diterima 
		//Parameter yang diberikan untuk membuat node baru adalah nama, penulis, bahasa, halaman, ratings, dan kategori.
		NodeBuku newNodeBuku = new NodeBuku( nama, penulis, bahasa, halaman, ratings, kategori);
		
		//Mendeklarasikan current sebagai node awal, yaitu head double dari linked list.
		NodeBuku current = head;
		
		//melakukan iterasi untuk mencari node pada posisi indeks tertentu dalam linked list
		for (int i = 0; i < index; i++) {
			//untuk memindahkan current ke node berikutnya.
			current = current.next;
			
			//Jika current menjadi null, maka kita telah melebihi 
			//indeks yang ada dan langsung keluar dari metode.
			if (current == null) {
				return;
			}
		}
		
		/*
		 * pengkondisian dibawah untuk mengatur newNode akan di tambahkan pada 
		 * posisi indeks tertentu dari linked list
		 */
		
		/*
		 * Jika linked list kosong (pertama kali), maka newNodeBuku menjadi head dan tail dari linked list.
		 */
		if (head == null) {
			tail = newNodeBuku;
			head = tail;
		} 
		/*
		 * Jika current bukan node terakhir dalam linked list, 
		 * maka newNodeBuku akan dimasukkan di antara current dan current.next.
		 */
		else if (current.next != null) {
			newNodeBuku.prev = current;
			newNodeBuku.next = current.next;
			current.next.prev = newNodeBuku;
			current.next = newNodeBuku;
		} 
		/*
		 * Jika current adalah node terakhir, maka newNodeBuku akan ditambahkan setelah tail.
		 */
		else if (current.next == null) {
			tail.next = newNodeBuku;
			newNodeBuku.prev = tail;
			tail = newNodeBuku;
		}
	}
	
	/*
	 * Fungsi delFirst bertujuan menghapus node pertama dari sebuah doubly linked list.
	 */
	void delFirst() {
		//kondisi untuk memeriksa apakah linked list tidak kosong. 
		//Jika head tidak kosong (berisi node), maka operasi penghapusan akan dilakukan.
		if (head != null) {
			//jika elemen hanya berjumlah 1 elemen yaitu ketika head sama dengan tail
			if (head == tail) {
				//head diatur atau di set menjadi kosong atau null
				head = null;
				//tail diatur atau di set menjadi kosong atau null
				tail = null;
			}else {
				//memindahkan referensi head ke node berikutnya dari node pertama (node yang akan dihapus). 
				//dengan melakukan ini, kita secara efektif menghapus node pertama dari linked list.
				head = head.next;
				
				//atribut prev pada node yang baru dijadikan node pertama (sekarang head) diatur 
				//menjadi null untuk memutuskan referensi yang ada sebelumnya.
				head.prev = null;
			}
		} 
		/*
		 * Jika linked list kosong (tidak ada node), atau jika node pertama 
		 * sudah dihapus, fungsi akan segera berakhir dengan pernyataan return.
		 */
		else {
			return;
		}
	}

	/*
	 * Fungsi delLast bertujuan menghapus node terkahir(tail) dari sebuah doubly linked list.
	 */
	void delLast() {
		//kondisi untuk memeriksa apakah linked list tidak kosong. 
		//Jika head tidak kosong (berisi node), maka operasi penghapusan akan dilakukan.
		if (head != null) {
			//jika elemen hanya berjumlah 1 elemen yaitu ketika head sama dengan tail
			if (head == tail) {
				//head diatur atau di set menjadi kosong atau null
				head = null;
				//tail diatur atau di set menjadi kosong atau null
				tail = null;
			} 
			else {
				//memindahkan referensi tail ke node sebelumnya dari node terakhir (node yang akan dihapus). 
				tail = tail.prev;
				
				//atribut prev pada node yang akan dihapus diatur menjadi null untuk memutuskan refrensi sebelumnya
				tail.next.prev = null;
				
				//refrensi selanjutnya untuk tail yang baru diatur menjadi null untuk memutuskan refrensi sebelumnya
				tail.next = null;
			}
		} 
		/*
		 * Jika linked list kosong (tidak ada node), atau jika node terkahir 
		 * sudah dihapus, fungsi akan segera berakhir dengan pernyataan return.
		 */
		else {
			return;
		}
	}

	/*
	 * delByIndex adalah metode yang berfungsi untuk menghapus elemen dari linked list 
	 * dengan memanfaatkan indeks (index) sebagai penanda posisi elemen yang akan dihapus.
	 */
	void delByIndex(int index) {
		//Mendeklarasikan current sebagai node awal, yaitu head double dari linked list.
		NodeBuku current = head;
		
		//melakukan iterasi untuk mencari node pada posisi indeks tertentu dalam linked list
		for (int i = 0; i < index; i++) {
			//current di set untuk memindahkan current ke node berikutnya.
			current = current.next;
		}

		//jika elemen hanya berjumlah 1 elemen yaitu ketika head sama dengan tail
		if (head == tail) {
			//head diatur atau di set menjadi kosong atau null
			head = null;
			//tail diatur atau di set menjadi kosong atau null
			tail = null;
		} 
		//current == head): Jika elemen yang ditemukan adalah head, 
		else if (current == head) {
			//maka head akan dipindahkan ke elemen setelahnya 
			head = head.next;
			//head.prev (biasanya null) akan diatur ke null untuk memutuskan refrensi sebelumnya pada head (elemen awal).
			head.prev = null;
		} 
		/*
		 * Jika elemen yang ditemukan adalah tail atau elemen tersebut merupakan elemen terakhir 
		 * (ditandai dengan current.next yang null), 
		 */
		else if (current == tail || current.next == null) {
			//maka tail akan dipindahkan ke elemen sebelumnya (tail = tail.prev).
			tail = tail.prev;
			
			//Setelahnya, pengaturan prev dari tail.next (yang awalnya adalah tail) akan dihapus 
			//dan diatur ke null, serta mengatur tail.next menjadi null.
			tail.next.prev = null;
			tail.next = null;
		} 
		
		//Jika elemen yang ditemukan terletak di tengah linked list (bukan head atau tail),
		else {
			current.next.prev = current.prev;
			current.prev.next = current.next;
			current.next = null;
			current.prev = null;
		}
	}

	/*
	 * fungsi print() adalah mencetak informasi yang terdapat pada setiap node dalam linked list, 
	 * berupa detail dari buku yang disimpan di doubleLinkedList
	 */
	void print() {
		//Mendeklarasikan current sebagai node awal, yaitu head double dari linked list.
		//untuk dijadikan sebagai penyimpanan sementara node awal (head)
		NodeBuku current = head;
		
		/*
		 * Melalui loop while, proses pencetakan dimulai dengan memeriksa apakah current tidak kosong. 
		 * Jika node saat ini yang sedang diproses bukanlah null 
		 * (yang menandakan akhir dari linked list), maka loop akan dijalankan.
		 */
		while (current != null) {
			if (current.next == null) {
				System.out.println("--------------------------");
				System.out.println(current.nama);
				System.out.println(current.penulis);
				System.out.println(current.bahasa);
				System.out.println(current.halaman);
				System.out.println(current.ratings);
				System.out.println(current.kategori);
				System.out.println("--------------------------");
			} else {
				System.out.println("--------------------------");
				System.out.println(current.nama);
				System.out.println(current.penulis);
				System.out.println(current.bahasa);
				System.out.println(current.halaman);
				System.out.println(current.ratings);
				System.out.println(current.kategori);
			}
			/*
			 * Setelah mencetak informasi dari node saat ini, variabel 
			 * current diperbarui untuk menunjuk ke node berikutnya 
			 * dalam linked list, sehingga proses pencetakan dapat dilanjutkan.
			 */
			current = current.next;
		}
		System.out.println();
	}
}


/*
 * class NodeRak adalah deklarasi dari kelas NodeRak, yang menyimpan informasi 
 * tentang rak dan buku yang disimpan di dalamnya.
 * 
 * Kelas NodeRak ini digunakan dalam struktur data linked list yang berisi 
 * informasi mengenai rak dan buku-buku yang disimpan di dalamnya. Setiap node menyimpan 
 * informasi tentang rak tertentu dan referensi ke linked list doubleLinkedList 
 * yang berisi daftar buku dalam rak tersebut.
 */
class NodeRak{
	/*
	 * Mendefinisikan objek buku dengan tipe doubleLinkedList. 
	 * Ini adalah referensi ke linked list doubleLinkedList yang berisi informasi buku. 
	 */
	doubleLinkedList buku;
	
	//Mendefinisikan variabel namaRak sebagai String. Ini akan menyimpan nama rak.
	String namaRak;
	
	//NodeRak next;: Membuat referensi ke node berikutnya dalam linked list NodeRak. 
	NodeRak next;
	//NodeRak prev;: Membuat referensi ke node sebelumnya dalam linked list NodeRak.
	NodeRak prev;
	
	/*
	 * NodeRak(doubleLinkedList buku, String namaRak) adalah konstruktor untuk kelas NodeRak. 
	 * Ketika objek NodeRak dibuat, konstruktor ini dijalankan. 
	 * Ini mengambil dua parameter: buku dari jenis 
	 * doubleLinkedList dan namaRak dari jenis String. Saat objek NodeRak dibuat, 
	 * kedua nilai ini diatur sesuai dengan parameter yang diterima.
	 */
	NodeRak(doubleLinkedList buku, String namaRak){
		this.buku=buku;
		this.namaRak=namaRak;
	}
}
class circularLinkedList{
	/*
	 * dilakukan inisialisasi kelas NodeRak dengan nama head untuk mengacu ke elemen awal pada circularLinkedList
	 * dan tail untuk mengacu ke elemen akhir pada circularLinkedList
	 */
	NodeRak head, tail;
	
	/*
	 * Metode addLast dalam kelas circularLinkedList digunakan untuk menambahkan elemen 
	 * rak buku ke bagian terakhir dari linked list yang berbasis sirkular.
	 */
	void addLast(doubleLinkedList value, String namaRak) {
		/*
		 * Membuat sebuah instance baru dari kelas NodeRak yang merepresentasikan rak buku baru dengan parameter 
		 * yang diberikan, yaitu doubleLinkedList value (berisi informasi buku) dan String namaRak (nama rak baru).
		 */
		NodeRak newNodeRak = new NodeRak(value,namaRak);
		
		/*
		 * Jika head (pengait pertama pada linked list) masih kosong (null), maka elemen rak buku baru akan menjadi 
		 * elemen pertama dalam linked list, sehingga head dan tail akan menunjuk ke elemen rak buku baru tersebut.
		 */
		if (head == null) {
			tail = newNodeRak;
			head = tail;
			/*
			 * terdapat dua reference tambahan yang diperlukan untuk mengatur hubungan siklik, yaitu tail.next = head 
			 * dan head.prev = tail. Hal ini membuatnya menjadi satu-satunya elemen dalam linked list berbasis sirkular.
			 */
			tail.next=head;
			head.prev=tail;
		} 
		//Jika linked list tidak kosong, elemen rak buku 
		//baru akan diletakkan di belakang (menjadi elemen terakhir).
		else {
			tail.next = newNodeRak; //berguna untuk membuat reference dari elemen terakhir (tail) ke elemen rak buku baru.
			newNodeRak.prev = tail; // berguna untuk membuat reference dari elemen rak buku baru ke elemen terakhir (tail) sebelumnya.
			
			//tail diperbarui untuk menunjuk pada elemen rak buku yang baru ditambahkan.
			tail = newNodeRak;
			
			/*
			 * tail.next = head dan head.prev = tail berguna untuk Memperbarui 
			 * reference yang diperlukan untuk menjadikan elemen terakhir (tail) 
			 * menghubungkan ke elemen pertama (head) dan sebaliknya untuk membentuk hubungan siklik.
			 */
			tail.next=head;
			head.prev=tail;
		}
	}

	void addFirst(doubleLinkedList value, String namaRak) {
		/*
		 * Membuat sebuah instance baru dari kelas NodeRak yang merepresentasikan rak buku baru dengan parameter 
		 * yang diberikan, yaitu doubleLinkedList value (berisi informasi buku) dan String namaRak (nama rak baru).
		 */
		NodeRak newNodeRak = new NodeRak(value,namaRak);
		
		/*
		 * Jika head (pengait pertama pada linked list) masih kosong (null), maka elemen rak buku baru akan menjadi 
		 * elemen pertama dalam linked list, sehingga head dan tail akan menunjuk ke elemen rak buku baru tersebut.
		 */
		if (head == null) {
			tail = newNodeRak;
			head = tail;
			
			/*
			 * terdapat dua reference tambahan yang diperlukan untuk mengatur hubungan siklik, yaitu tail.next = head 
			 * dan head.prev = tail. Hal ini membuatnya menjadi satu-satunya elemen dalam linked list berbasis sirkular.
			 */
			tail.next=head;
			head.prev=tail;
		} 
		/*
		 * Jika linked list tidak kosong, elemen rak buku baru akan diletakkan di depan (menjadi elemen pertama).
		 */
		else {
			
			newNodeRak.next=head; // Menjadikan elemen rak buku baru menunjuk ke elemen yang menjadi pengait pertama saat ini (head).
			head=newNodeRak; // Memperbarui elemen pertama (head) sehingga menunjuk pada elemen rak buku yang baru ditambahkan.
			
			/*
			 * tail.next = head dan head.prev = tail berguna untuk Memperbarui 
			 * reference yang diperlukan untuk menjadikan elemen terakhir (tail) 
			 * menghubungkan ke elemen pertama (head) dan sebaliknya untuk membentuk hubungan siklik.
			 */
			tail.next=head;
			head.prev=tail;
		}
	}

	/*
	 * addAfter dalam kelas circularLinkedList digunakan untuk menambahkan elemen rak buku 
	 * setelah indeks tertentu dalam linked list berbasis sirkular
	 */
	void addAfter(int index, doubleLinkedList value, String namaRak) {
		/*
		 * Membuat sebuah instance baru dari kelas NodeRak yang merepresentasikan rak buku baru dengan parameter 
		 * yang diberikan, yaitu doubleLinkedList value (berisi informasi buku) dan String namaRak (nama rak baru).
		 */
		NodeRak newNodeRak = new NodeRak(value,namaRak);
		
		/*
		 *tail.next di set menjadi null untuk mengetahui batas dari banyak elemen pada linked list ketika melakukan iterasi 
		 */
		tail.next=null;

		//Mendeklarasikan current sebagai node awal, yaitu head double dari linked list.
		//untuk dijadikan sebagai penyimpanan sementara node awal (head)
		NodeRak current = head;
		
		//melakukan perulangan untuk menemukan posisi (indeks) di mana elemen rak buku akan ditambahkan
		for (int i = 0; i < index; i++) {
			//current di set menjadi current selanjutnya dalam Perulangan untuk memindahkan current ke indeks yang dituju.
			current = current.next;
			
			/*
			 * Jika current menjadi null, artinya telah mencapai akhir dari linked list atau 
			 * indeks yang diminta melebihi jumlah elemen dalam linked list.
			 */
			if (current == null) {
				
				/*
				 * Dalam kondisi ini, akan dilakukan reference next dari tail ke head untuk membentuk siklus dan kemudian fungsi dihentikan (return).
				 */
				tail.next=head;
				return;
			}
		}
		
		//Mengecek kondisi linked list apakah kosong atau tidak
		
		/*
		 * Jika linked list kosong, maka elemen rak buku baru akan menjadi satu-satunya elemen dalam linked list.
		 */
		if (head == null) {
			//head dan tail akan menunjuk ke elemen rak buku baru tersebut.
			tail = newNodeRak;
			head = tail;
			
			/*
			 * Kemudian, terdapat dua pengait tambahan yang diperlukan untuk mengatur 
			 * hubungan siklik, yaitu tail.next = head dan head.prev = tail.
			 */
			tail.next=head;
			head.prev=tail;
		} 
//		jika elemen yang dituju merupakan elemen terakhir(tail) pada linked list
		else if (current == tail) {
			//Membuat pengait dari tail ke elemen rak buku baru (newNodeRak) untuk menambahkannya sebagai elemen terakhir.
			tail.next = newNodeRak;
			
			//tail diperbarui untuk menunjuk ke elemen rak buku yang baru ditambahkan.
			tail = newNodeRak;
			
			/*
			 * Membuat hubungan siklik dengan tail.next = head dan head.prev = tail untuk menutup lingkaran.
			 */
			tail.next=head;
			head.prev=tail;
		}
		/*
		 * Jika current bukan node terakhir dalam linked list, 
		 * maka newNodeBuku akan dimasukkan di antara current dan current.next.
		 */
		else{
			newNodeRak.prev = current;
			newNodeRak.next = current.next;
			current.next.prev = newNodeRak;
			current.next = newNodeRak;
		} 
		
//		Setelah menambahkan elemen, tail.next diset kembali ke head untuk memastikan bahwa linked list bersifat siklik.
		tail.next=head;
	}

	/*
	 * Metode delFirst dalam kelas circularLinkedList digunakan untuk menghapus 
	 * elemen pertama (head) dari linked list yang berbasis sirkular.
	 */
	void delFirst() {
//		head tidak kosong (null), artinya linked list memiliki elemen.
		if (head != null) {
			//jika elemen hanya berjumlah 1 elemen yaitu ketika head sama dengan tail
			if (head == tail) {
				//head diatur atau di set menjadi kosong atau null
				head = null;
				//tail diatur atau di set menjadi kosong atau null
				tail = null;
			} 
//			jika elemen linked list berjumlah lebih dari 1
			else {
				//head (elemen awal) di atur menjadi elemen berikutnya sehingga elemen awal yang sebelumnya terhapus
				head = head.next;
				
//				referensi selanjutnya dari tail (elemen akhir) di atur menjadi merujuk ke elemen awal (head)
//				dan referensi sebelumnya dari head yang baru di rujuk ke tail
				tail.next = head;
				head.prev=tail;
			}
		}
		
		//Jika head kosong, maka tidak ada operasi yang perlu dilakukan, 
		//sehingga metode akan langsung mengembalikan eksekusi.
		else {
			return;
		}
	}

	/*
	 * Metode delLast dalam kelas circularLinkedList digunakan untuk menghapus 
	 * elemen terkahir (tail) dari linked list yang berbasis sirkular.
	 */
	void delLast() {
//		head tidak kosong (null), artinya linked list memiliki elemen.
		if (head != null) {
			//jika elemen pada linked list hanya berjumlah 1 elemen yaitu ketika head sama dengan tail
			if (head == tail) {
				//head diatur atau di set menjadi kosong atau null
	            head = null;
	          //tail diatur atau di set menjadi kosong atau null
	            tail = null;
	        } 
			//jika elemen pada linked list hanya berjumlah lebih dari 1 elemen
			else {
				//memindahkan referensi tail ke node sebelumnya dari node terakhir (node yang akan dihapus). 
	        	tail=tail.prev;
//	        	merujuk tail yang baru, referensi selanjutnya ke head (elemen awal)
	        	tail.next=head;
	        	
	        	//untuk head refrensi sebelumnya merujuk ke tail(elemen akhir) yang baru
	        	head.prev=tail;
	        }
		}
		//Jika head kosong, maka tidak ada operasi yang perlu dilakukan, 
				//sehingga metode akan langsung mengembalikan eksekusi.
		else {
			return;
		}
	}

	/*
	 * delByIndex adalah metode yang berfungsi untuk menghapus elemen dari linked list 
	 * dengan memanfaatkan indeks (index) sebagai penanda posisi elemen yang akan dihapus.
	 */
	void delByIndex(int index) {
		//Mendeklarasikan current sebagai node awal, yaitu head double dari linked list.
		NodeRak current= head;;
		
		//jika head masih kosong (null), maka tidak ada yang dapat dihapus dari linked list.
		if (head == null) {
			return;
		}
		
		if (index == 0) { //Kondisi yang menangani penghapusan elemen pada indeks 0 (elemen pertama).
			
			/*
			 * Jika head dan tail menunjuk ke satu elemen yang merupakan elemen tunggal dalam linked list, 
			 */
			if (head == tail) {
//				maka kedua pengait (head dan tail) akan diatur ke null, karena elemen tunggal itu akan dihapus.
				head = null;
	            tail = null;
	        } 
			
			else {
				/*
				 * head akan diatur untuk menunjuk pada elemen selanjutnya, dan beberapa pengait 
				 * akan diperbarui untuk menjaga hubungan siklik dalam linked list. seperti tail.next = head dan head.prev=tail
				 */
	            head = head.next;
	            tail.next = head;
	            head.prev=tail;
	        }
	        return;
		}
		
		/*
		 * jika index bukan 0, maka pengecekan dilakukan berdasarkan urutan indeks elemen yang ingin dihapus.
		 */
		
		//referensi selanjutnya dari next di set menjadi null terlebih dahulu
		//tail.next di set menjadi null untuk mengetahui batas dari banyak elemen pada linked list ketika melakukan iterasi 
		tail.next=null;
		int i = 0;
		
		/*
		 * iterasi dilakukan sebanyak index untuk menemukan elemen yang akan dihapus. 
		 * Pencarian dilakukan hingga node yang sebelum elemen yang ingin dihapus ditemukan.
		 */
		while (current != null && i < index - 1) {
			current = current.next;
			i++;
		}
		
		/*
		 * Jika current atau current.next (elemen yang ingin dihapus) adalah null, atau elemen 
		 * setelahnya adalah null, itu berarti elemen yang akan dihapus berada di ujung linked list.
		 */
		if (current == null || current.next == null) {
			//tail.next akan diatur kembali ke head untuk mempertahankan hubungan siklik.
			tail.next=head;
			//dan metode akan berakhir atau dikembalikan langsung
			return;
		}
		//Jika elemen yang ingin dihapus ditemukan, maka pengait akan diubah untuk melewati node yang akan dihapus.
		current.next = current.next.next;
		
		//Terakhir, pengait tail.next akan diatur kembali ke head untuk mempertahankan hubungan siklik pada linked list.
		tail.next=head;
	}
	/*
	 * Metode print pada kelas circularLinkedList digunakan untuk menampilkan 
	 * informasi dari semua rak buku yang ada di dalam linked list yang berbasis sirkular.
	 */
	void print() {
		/*
		 * Metode print pada kelas circularLinkedList digunakan untuk menampilkan informasi dari semua rak buku
		 * Kondisi Awal: if (head != null): Memeriksa apakah linked list yang diwakili oleh head tidak kosong. 
		 * Jika kondisi ini terpenuhi, maka proses pencetakan informasi rak buku dapat dimulai. yang ada di dalam linked list yang berbasis sirkular.
		 */
		if (head != null) {
			/*
			 * Menginisialisasi variabel current sebagai elemen pertama dari linked list 
			 * (rak buku pertama), yang kemudian akan digunakan untuk menelusuri seluruh linked list.
			 */
			NodeRak current = head;
			
			/*
			 * do akan menjalankan blok kode setidaknya sekali sebelum 
			 * mengevaluasi kondisi. Pada langkah pertama, blok ini 
			 * akan dijalankan tanpa memeriksa kondisi.
			 */
			do {
				//Mencetak informasi nama rak buku saat ini yang diperoleh dari atribut namaRak pada current.
				System.out.println("[Rak " + current.namaRak + "]"); 
				
				/*
				 * current.buku.print() adlaah metode print() yang terdapat di kelas doubleLinkedList yang terasosiasi 
				 * dengan rak buku yang sedang ditunjuk oleh current. Hal ini akan mencetak semua informasi buku yang ada di rak tersebut.
				 */
				current.buku.print();
				
				/*
				 * current.buku.print();: Memanggil metode print() yang terdapat di kelas doubleLinkedList 
				 * yang terasosiasi dengan rak buku yang sedang ditunjukMemindahkan current ke rak buku 
				 * berikutnya dalam linked list (ke elemen rak buku selanjutnya dalam siklik), sehingga 
				 * proses ini akan terus berlanjut hingga current kembali ke head. oleh current. Hal 
				 * ini akan mencetak semua informasi buku yang ada di rak tersebut.
				 */
				current = current.next;
				
				//proses akan berhenti saat current kembali menunjuk ke elemen head.
			} while (current != head);
		}
	}
}
public class linkedlist {

	public static void main(String[] args) {
		doubleLinkedList bukukategori1 = new doubleLinkedList();
		doubleLinkedList bukukategori2 = new doubleLinkedList();
		doubleLinkedList bukukategori3 = new doubleLinkedList();
		doubleLinkedList bukukategori4 = new doubleLinkedList();
		circularLinkedList rak = new circularLinkedList();
		
		bukukategori1.addLast("A Princess of Mars", "Edgar Rice Burroughs", "Inggris", 176, 4.5, "Science & Fiction");
		bukukategori1.addLast("The Machine Stops", "E.M. Forster", "Inggris", 36, 4.5, "Science & Fiction");
		bukukategori1.addLast("Anthem", "Ayn Rand", "Inggris", 70, 4, "Science & Fiction");
		bukukategori1.addLast("The Mysterious Island", "Julis Verne", "Indonesia", 492, 5, "Science & Fiction");
		bukukategori1.addLast("At the Earth’s Core", "Edgar Rice Burroughs", "Inggris", 131, 4.5, "Science & Fiction");
		
		//kiky tidak menaruh buku yang princess of mars dan mysterious island
//		bukukategori1.delByIndex(0);
//		bukukategori1.delByIndex(2);
//		rak.addLast(bukukategori1,"Science & Fiction");
//		rak.print(); // output kasus pertama
		
		bukukategori2.addFirst("Walden", "Henry David Thoreau", "Indonesia", 244, 4, "Biographies");
		bukukategori2.addFirst("Alexander The Great", "Jacob Abbott", "Indonesia", 231, 5, "Biographies");
		bukukategori2.addFirst("My Life and Work", "Henry Ford", "Inggris", 233, 4.5, "Biographies");
		bukukategori2.addFirst("Abraham Lincoln", "Thomas Mears Eddy", "Inggris", 29, 5, "Biographies");
		bukukategori2.addFirst("Adventures in Friendship", "David Grayson", "Inggris", 140, 4, "Biographies");
		
		bukukategori1.addAfter(0, "A Princess of Mars", "Edgar Rice Burroughs", "Inggris", 176, 4.5, "Science & Fiction");
		bukukategori1.addAfter(2, "The Mysterious Island", "Julis Verne", "Indonesia", 492, 5, "Science & Fiction");
//		rak.addLast(bukukategori1,"Science & Fiction");
//		rak.addLast(bukukategori2,"Biographies");
//		rak.print(); // output kasus kedua
		
		bukukategori3.addLast("Time Machine", "H.G Wells", "Indonesia", 78, 4, "Fantasy");
		bukukategori3.addLast("All the Way to Fairyland", "Evelyn Sharp", "Inggris", 125, 3, "Fantasy");
		bukukategori3.addLast("The Return of Tarzan", "Edgar Rice Burroughs", "Inggris", 240, 4.8, "Fantasy");
		bukukategori3.addLast("The Book of Wonder", "Lord Dunsay", "Indonesia", 58, 3.5, "Fantasy");
		bukukategori3.addLast("Adventures of Pinocchio", "Carlo Collodi", "Indonesia", 136, 4.2, "Fantasy");
		bukukategori3.addAfter(0, "Adventures of Huckleberry Finn", "Mark Twain", "Indonesia", 305, 5, "Action & Adventure");
//		rak.addLast(bukukategori3, "Fantasy");
//		rak.print(); // output kasus ketiga
		
		bukukategori4.addLast("Fast as the wind", "Nat Gould", "Indonesia", 172, 3, "Action & Adventure");
		bukukategori4.addLast("Around The World", "Jules Verne", "Indonesia", 198, 4.5, "Action & Adventure");
		bukukategori4.addLast("A Tale of Two Cities", "Charles Dickens", "Inggris", 355, 4.3, "Action & Adventure");
		bukukategori4.addLast("Robin Crusoe", "Daniel Defoe ", "Indonesia", 143, 4, "Action & Adventure");
//		rak.addLast(bukukategori4, "Action & Adventure");
//		rak.print(); // output kasus keempat
		
		rak.addLast(bukukategori1,"Science & Fiction");
		rak.addLast(bukukategori2,"Biographies");
		rak.addLast(bukukategori3, "Fantasy");
		rak.addLast(bukukategori4, "Action & Adventure");
//		rak.print(); //menampilkan semua isi rak
		
		//kasus ketika temen kiky (rama) meminjam buku 
//		bukukategori3.delByIndex(2);
//		rak.addLast(bukukategori3, "Fantasy");
//		rak.print();
		
		//kasus ketika rak action & adventure di makan rayap sehingga harus dipindakan ke rak biografy
		bukukategori2.addLast("Fast as the wind", "Nat Gould", "Indonesia", 172, 3, "Action & Adventure");
		bukukategori2.addLast("Around The World", "Jules Verne", "Indonesia", 198, 4.5, "Action & Adventure");
		bukukategori2.addLast("A Tale of Two Cities", "Charles Dickens", "Inggris", 355, 4.3, "Action & Adventure");
		bukukategori2.addLast("Robin Crusoe", "Daniel Defoe ", "Indonesia", 143, 4, "Action & Adventure");
//		rak.addLast(bukukategori2,"Biographies");
//		rak.print(); 

	}

}

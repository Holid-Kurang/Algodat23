package modul2;

/*
 * kelas pakaian dibawah merepresentasikan informasi dari pakaian.
 * berupa jenis pakaian dan waktu yang dibutuhkan untuk menyetrika
 */
class Pakaian{
	/*
	 * variabel jenis dengan tipe data string akan menyimpan informasi jenis 
	 * pakaian seperti "Baju", "Celana", "Kemeja", dan lain sebagainya.
	 */
	String jenis;
	/*
	 * variabel waktu dengan tipe data integer akan menyimpan 
	 * informasi waktu yang diperlukan untuk menyetrika pakaian.
	 */
	int waktu;
	
	/*
	 * Pakaian next: merupakan bagian dari struktur data linked list yang mengacu pada 
	 * pakaian selanjutnya dalam linked list, jika digunakan sebagai bagian dari struktur data tersebut.
	 */
	Pakaian next;
	
	/*
	 * consntructor dibawah merupakan metode yang digunakan untuk membuat objek Pakaian 
	 * menerima dua argumen: jenis (representasi string dari jenis pakaian) dan 
	 * waktu (waktu yang diperlukan untuk menyetrika pakaian).
	 */
	Pakaian(String jenis,int waktu){
//		Saat objek Pakaian dibuat, jenis dan waktu akan diatur sesuai dengan nilai yang diberikan.
		this.jenis=jenis;
		this.waktu=waktu;
	}
}

/*
 * class stackPakaian dibawah digunakan untuk menyusun elemen-elemen atau informasi dari pakaian
 * yang disusun secara stack yang berisi operasi-operasi umum dari stack: push untuk menambahkan 
 * pakaian ke dalam stack, pop untuk mengambil pakaian dari stack, popAll untuk mengeluarkan semua 
 * pakaian dari stack, dan print untuk menampilkan daftar pakaian yang ada di dalam stack.
 */
class stackPakaian{
	
	/*
	 * dilakukan inisialisasi kelas Pakaian dengan nama head untuk mengacu ke elemen awal pada linked list
	 * dan tail untuk mengacu ke elemen akhir pada linked list
	 */
	Pakaian head, tail;
	
	/*
	 * method bernama Size() dibawah menghitung jumlah elemen atau node dalam 
	 * struktur data linked list yang direpresentasikan oleh class stackPakaian
	 */
	int Size() {
		/*
		 * sebuah variabel lokal size dengan tipe data integer dengan 
		 * nilai awal 0 yang digunakan untuk menyimpan jumlah elemen dalam linked list.
		 */
		int size=0;
		
		/*
		 * Variabel current bertipe Pakaian (elemen dari linked list) 
		 * yang ditetapkan sebagai head yang merepresentasikan elemen pertama dari linked list.
		 */
		Pakaian current =head;
		
		/*
		 * loop while yang akan terus berjalan selama current tidak bernilai null, artinyaa 
		 * berarti loop akan berjalan sampai current mencapai elemen terakhir di linked list.
		 */
		while(current!=null) {
			/*
			 *  setiap kali loop berjalan, nilai dari size akan ditambah 1, 
			 *  yang menunjukkan bahwa setiap kali menemukan sebuah node, hitungan size akan bertambah.
			 */
			size++;
			/*
			 *  setiap iterasi dari loop, current diperbarui untuk merujuk pada elemen 
			 *  selanjutnya di linked list dengan cara menetapkan current ke next dari node saat ini.
			 */
			current=current.next;
		}
		/*
		 * setelah loop selesai, method akan mengembalikan nilai dari size, 
		 * yang merupakan jumlah elemen dalam linked list pada saat itu.
		 */
		return size;
	}
	
	/*
	 * method push dibawah berfungsi untuk menambahkan elemen baru ke dalam tumpukan.
	 * yang menerima parameter jenis dan waktu sebagai informasi yang akan dimasukkan kedalam kelas pakaian
	 */
	void push(String jenis, int waktu) {
		/*
		 * membuat objek Pakaian baru dengan atribut jenis dan waktu yang diberikan.
		 * Objek Pakaian baru ini akan dimasukkan ke dalam tumpukan (stackPakaian).
		 */
		Pakaian jemuran = new Pakaian(jenis,waktu);
		System.out.println("Menambahkan "+"'"+jenis+"'");
		System.out.println();
		
		//Mengecek apakah tumpukan kosong (head-nya null) atau tidak.
		if(head==null) {
			//Jika tumpukan kosong, maka elemen pertama (head) dan terakhir 
			//(tail) dari tumpukan diatur sebagai elemen baru.
			tail = jemuran;
			head = tail;
		}else {
			//Jika tumpukan tidak kosong, elemen baru dibuat dan 
			//dihubungkan sebagai elemen teratas tumpukan, yaitu sebagai head.
			
			//Menyimpan elemen baru yang ingin dimasukkan ke dalam variabel jemuran.
			//Mengatur elemen baru ini agar mengarah pada elemen yang ada di head 
			//saat ini (elemen paling atas sebelum penambahan).
			jemuran.next=head;
			/*
			 * menggeser head tumpukan ke elemen baru yang ditambahkan 
			 * yang artinya, elemen baru menjadi elemen teratas baru dari tumpukan.
			 */
			head=jemuran;
		}
	}
	
	/*
	 * metode pop dibawah berfungsi menghilangkan atau 'menyetrika' pakaian 
	 * yang berada paling atas dalam tumpukan, diikuti 
	 * dengan perubahan penunjuk ke pakaian di bawahnya
	 */
	void pop() {
		//mencetak bahwa pakaian yang paling atas dalam tumpukan (stack) sedang disetrika
		System.out.println("Menyetrika Pakaian yang paling atas");
		
		/*
		 * blok kode dibawah bertujuan untuk memindahkan penunjuk ke pakaian berikutnya yang ada 
		 * di tumpukan. Dalam konteks tumpukan, operasi pop menghapus atau 'menyetrika'
		 * pakaian yang ada di atas tumpukan, yang ditandai dengan perpindahan penunjuk head ke elemen berikutnya
		 */
		head=head.next;
		//setelah operasi selesai akan memanggil metode print()
		//untuk menampilkan daftar pakaian yang tersisa di tumpukan setelah operasi pop
		print();
	}
	
	/*
	 *  fungsi popAll() bertujuan untuk menyetrika semua pakaian yang ada dalam tumpukan 
	 *  (stack) dengan mengeluarkan satu per satu dari puncak tumpukan hingga tumpukan kosong
	 */
	void popAll() {
		//mencetak pesan "Lanjut Menyetrika" yang memberitahukan bahwa proses menyetrika pakaian akan dilanjutkan.
		System.out.println("Lanjut Menyetrika");
		
		/*
		 * melakukan  loop for yang melakukan iterasi sebanyak jumlah pakaian yang ada dalam tumpukan
		 * iterasi dilakukan dengan variabel i yang dimulai dari 0 hingga Size() 
		 * (jumlah pakaian dalam tumpukan). ini memungkinkan fungsi untuk mengakses setiap pakaian dalam tumpukan secara berurutan.
		 */
		for(int i=0; i<Size(); i++) {
			/*
			 * head (puncak tumpukan) digeser ke pakaian berikutnya dalam 
			 * setiap iterasi dengan head = head.next. Hal ini menunjukkan 
			 * bahwa pakaian teratas dikeluarkan dari tumpukan. Kemudian, fungsi print() 
			 * dipanggil untuk menampilkan pakaian yang tersisa dalam tumpukan setelah penghapusan.
			 */
			head=head.next;
			print();
		}
		//setelah loop selesai
		/*
		 * terdapat pernyataan head = head.next yang digunakan untuk 
		 * menghapus pakaian terakhir yang masih tersisa dalam tumpukan. 
		 */
		head=head.next;
		/*
		 *  fungsi print() dipanggil lagi untuk menampilkan tumpukan kosong 
		 *  (setelah semua pakaian dikeluarkan) atau pakaian teratas yang tersisa dalam tumpukan.
		 */
		print();
	}
	
	/*
	 * method print() bertujuan untuk menampilkan pakaian yang ada di dalam "stackPakaian" atau 
	 * dalam konteks implementasi kode yang disediakan, yaitu dalam sebuah struktur data berupa stack.
	 */
	void print() {
		/*
		 *  variabel totalWaktu dengan nilai awal 0 yang akan digunakan untuk menghitung 
		 *  total waktu yang dibutuhkan untuk menyetrika semua pakaian yang ada di dalam keranjang.
		 */
		int totalWaktu=0;
		
		//menampilkan pesan bahwa program akan menampilkan daftar pakaian yang ada di keranjang (stack).
		System.out.println("Pakaian yang ada di keranjang");
		
		//variabel current yang merupakan node awal dari stack atau kepala (head) dari struktur data stack yang berisi pakaian.
		Pakaian current = head;
		
		/*
		 * melakukan perulangan while yang akan mengecek setiap node dalam stack 
		 * pengecekan dilakukan hingga current menjadi null, yang menunjukkan akhir dari stack.
		 */
		while(current!=null) {
			/*
			 * isi dari variabel totalWaktu ditambahkan dengan nilai waktu dari pakaian saat ini ke dalam totalWaktu
			 * ini akan mengakumulasi waktu dari setiap pakaian yang ada di dalam stack.
			 */
			totalWaktu+=current.waktu;
			
			/*
			 * menampilkan informasi tentang pakaian yang sedang ditampilkan, 
			 * termasuk jenis pakaian dan waktu yang dibutuhkan untuk menyetrikanya dalam detik.
			 */
			System.out.println("--"+current.jenis+" - Waktu : "+current.waktu+" Detik");
			/*
			 *  setiap iterasi dari loop, current diperbarui untuk merujuk pada elemen 
			 *  selanjutnya di linked list dengan cara menetapkan current ke next dari node saat ini.
			 */
			current=current.next;
		}
		//Setelah perulangan selesai
		//maka totalWaktu akan berisi jumlah total waktu dari semua pakaian yang ada di keranjang
		//setelah itu ditampilkan total waktu yang dibutuhkan untuk menyetrika seluruh pakaian yang ada di dalam keranjang.
		System.out.println("Total Waktu : "+totalWaktu);
		System.out.println();
	}
}


public class Nomor1 {

	public static void main(String[] args) {
		stackPakaian jemuran = new stackPakaian();
		jemuran.push("Baju", 10);
		jemuran.push("Celana", 15);
		jemuran.push("Kemeja", 20);
		
		jemuran.print();
		jemuran.pop();
		jemuran.push("Hoodie", 12);
		jemuran.print();
		
		jemuran.popAll();
	}

}

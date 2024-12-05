package modul2;

class NodeMakanan{
	/*
	 * variabel makanan dibawah akan 
	 * menyimpan informasi terkait dengan sebuah makanan yang dipesan dengan tipe data String.
	 */
	String makanan;
	
	/* 
	 * NodeMakanan next adalah atribut yang mengacu pada node berikutnya (next) 
	 * dalam struktur linked list . 
	 * Dalam konteks linked list, next menyimpan referensi ke node berikutnya dalam urutan terkait.
	 */
	NodeMakanan next;
	
	/*
	 * Konstruktor NodeMakanan(String makanan) menerima satu argumen bertipe String. Ketika sebuah 
	 * objek dari kelas NodeMakanan dibuat, konstruktor ini akan menginisialisasi 
	 * atribut makanan sesuai dengan nilai yang diterima sebagai argumen.
	 */
	NodeMakanan(String makanan){
		this.makanan=makanan;
	}
}

//Kelas StackMakanan merepresentasikan struktur data stack yang menyimpan daftar pesanan makanan.
class StackMakanan{
	/*
	 * dilakukan inisialisasi kelas NodeMakanan dengan nama head untuk mengacu ke elemen awal pada linked list
	 * dan tail untuk mengacu ke elemen akhir pada linked list
	 */
	NodeMakanan head, tail;
	
	/*
	 * Metode push di bawah merupakan bagian dari kelas StackMakanan yang berfungsi 
	 * untuk menambahkan elemen ke dalam struktur data tumpukan (stack).
	 */
	void push(String makanan) {
		
		/*
		 * Membuat node baru dengan makanan sebagai data yang akan ditambahkan ke dalam stack.
		 */
		NodeMakanan  pesenMakan= new NodeMakanan (makanan);
		
		//Jika tumpukan masih kosong (head tidak menunjuk ke node apapun)
		if(head==null) {
			// node baru menjadi elemen pertama dalam stack. head dan tail menunjuk ke node ini.
			tail = pesenMakan;
			head = tail;
		}
		// jika tumpukan sudah memiliki elemen
		// node baru akan ditambahkan di atas tumpukan yang sudah ada.
		else {
			/*
			 * mengatur next dari node baru (pesenMakan.next) agar menunjuk ke node yang sedang 
			 * menjadi elemen paling atas sebelumnya (head), dan kemudian head menunjuk ke 
			 * node baru. sehingga, node baru menjadi elemen terbaru yang berada di atas tumpukan.
			 */
			pesenMakan.next=head;
			head=pesenMakan;
		}
	}
	
	//Metode pop() bertujuan untuk menghapus elemen teratas dari stack.
	void pop() {
		/*
		 * kode di bawah menggeser referensi head (atau penunjuk teratas 
		 * stack) ke elemen berikutnya dalam stack. sehingga, elemen yang 
		 * tadinya berada di posisi teratas (paling atas) akan dihilangkan dari struktur data stack.
		 */
		head=head.next;
	}
	/*
	 * metode print() berfungsi untuk mencetak seluruh isi dari struktur data Stack yang terdiri dari NodeMakanan
	 */
	void print() {
		
		//variabel current yang merupakan node awal dari stack atau kepala (head) dari struktur data stack yang berisi makanan.
		NodeMakanan current = head;
		System.out.print("[");
		
		/*
		 * melakukan perulangan while yang akan mengecek setiap node dalam stack 
		 * pengecekan dilakukan hingga current menjadi null, yang menunjukkan akhir dari stack.
		 */
		while(current!=null) {
			
			/*
			 * Dalam setiap iterasi, kode memeriksa apakah current bukan merupakan elemen terakhir dalam stack
			 */
			if(current.next!=null) {
				//mencetak nilai dari makanan yang ada di node current, diikuti dengan tanda koma dan spasi , .
				System.out.print(current.makanan+", ");
			}else {
				//mencetak nilai makanan dari current, tetapi tanpa tanda koma dan spasi.
				System.out.print(current.makanan);
			}
			//setelah pengecekan, kode menggeser current ke elemen selanjutnya (node berikutnya).
			current=current.next;
		}
		System.out.println("]");
	}
}
class NodePesanan{
	/*
	 * variabel Pelanggan dengan tipe data string akan menyimpan nama pelanggan yang melakukan pesanan.
	 */
	String Pelanggan;
	
	//objek makanan dengan tipe data atau kelas StackMakanan akan menyimpan daftar pesanan makanan yang dipesan oleh pelanggan.
	StackMakanan makanan;
	
	/*
	 * NodePesanan selesai menunjuk ke simpul lain yang merepresentasikan pesanan yang telah selesai. Hal ini 
	 * memungkinkan untuk menggabungkan simpul-simpul yang telah selesai dengan antrian yang lain.
	 */
	NodePesanan selesai;
	
	/* 
	 * NodePesanan next adalah atribut yang mengacu pada node berikutnya (next) 
	 * dalam struktur linked list . 
	 * Dalam konteks linked list, next menyimpan referensi ke node berikutnya dalam urutan terkait.
	 */
	NodePesanan next;
	
	/*
	 * Konstruktor di bawah menerima simpul pesanan yang telah selesai. 
	 * Digunakan untuk membuat simpul baru yang menunjuk ke pesanan yang selesai.
	 */
	NodePesanan(NodePesanan pesananSelesai){
		this.selesai=pesananSelesai;
	}
	
	/*
	 * Konstruktor diabwah menerima nama pelanggan dan daftar makanan yang dipesan. 
	 * Digunakan untuk membuat simpul baru dalam antrian.
	 */
	NodePesanan(String Pelanggan, StackMakanan makanan){
		this.Pelanggan=Pelanggan;
		this.makanan=makanan;
	}
}

//Kelas QueuePesanan mewakili struktur data queue yang menyimpan pesanan pelanggan beserta makanan yang dipesan.
class QueuePesanan{
	
	/*
	 * dilakukan inisialisasi kelas NodePesanan dengan nama head untuk mengacu ke elemen awal pada linked list
	 * dan tail untuk mengacu ke elemen akhir pada linked list
	 */
	NodePesanan head,tail;
	
	
	//Metode enqueue bertanggung jawab untuk menambahkan pesanan pelanggan baru ke dalam antrian.
	/*
	 * Metode ini menerima dua parameter Pelanggan yang merupakan nama pelanggan baru yang melakukan pemesanan, 
	 * dan makanan yang merupakan pesanan makanan pelanggan tersebut.
	 */
	void enqueue(String Pelanggan, StackMakanan makanan) {
		
		//objek NodePesanan baru dibuat dengan parameter Pelanggan (nama pelanggan) dan makanan (daftar pesanan makanan).
		NodePesanan newNode = new NodePesanan(Pelanggan, makanan);
		
		//mencetak informasi bahwa pelanggan dengan nama tertentu telah datang untuk memesan makanan.
		System.out.println(Pelanggan+" datang untuk pesan");
		
		//Pengecekan apakah antrian kosong (head tidak menunjuk ke node manapun).
		if(head==null) {
			//Jika kondisi ini terpenuhi, maka head dan tail diarahkan ke node pesanan baru.
			tail = newNode;
			head = tail;
		}else {
			//Jika antrian sudah memiliki elemen, node pesanan baru diarahkan ke node yang berada di belakang (disebut tail).
			tail.next=newNode;
			
			//Node tail (ujung antrian) diarahkan ke node pesanan baru, sehingga node pesanan baru menjadi node paling belakang dalam antrian.
			tail=newNode;
		}
	}
	
	/*
	 * Metode dequeue() ini memungkinkan pengambilan pesanan terdepan dari antrian, menampilkan detail pesanan tersebut, 
	 * dan memindahkan antrian ke pesanan berikutnya (jika ada). Jika antrian kosong, maka metode ini mengembalikan nilai null.
	 */
	NodePesanan dequeue() {
		/*
		 * mengecek apakah antrian memiliki pesanan atau masih kosong. 
		 * jika antrian tidak kosong (head bukan null), maka lanjut ke langkah-langkah berikutnya.
		 */
		if (head != null) {
			//NodePesanan current = head; menyimpan referensi ke pesanan pertama di dalam antrian (disebut current).
			NodePesanan current = head;
			
			System.out.println("Pesanan diproses:");
			//menampilkan nama pelanggan yang memesan pesanan di depan antrian.
			System.out.println("--Ordered By : "+head.Pelanggan);
			System.out.print("--Items  : ");
			
			/*
			 * mencetak semua item makanan yang dipesan oleh pelanggan dengan menggunakan metode print() dari objek makanan yang merupakan tipe StackMakanan.
			 */
			head.makanan.print();
			System.out.println();
			
			//menggeser referensi head ke pesanan selanjutnya (antrian maju ke pesanan berikutnya).
			head=head.next;
			
			//mengembalikan pesanan yang telah diproses.
			return current;
		}
		
		/*
		 * jika antrian kosong (head == null), metode dequeue() 
		 * akan mengembalikan nilai null karena tidak ada pesanan yang dapat diambil.
		 */
		return null;
	}
	
	/*
	 * dequeueBatal() digunakan untuk menghapus pesanan dari antrian jika pelanggan 
	 * memutuskan untuk membatalkannya, memindahkan head ke pesanan selanjutnya, 
	 * dan menghentikan proses jika tidak ada pesanan yang tersisa dalam antrian.
	 */
	void dequeueBatal() {
		//Memeriksa apakah head (elemen pertama/anterian paling depan) tidak kosong, yaitu head != null.
		if (head != null) {
			//Mencetak pesan yang menyatakan bahwa pelanggan di bagian depan antrian membatalkan pesanannya dengan menggunaka
			System.out.println(head.Pelanggan+" membatalkan pesanan");
			System.out.println();
			
			/*
			 * melanjutkan untuk memindahkan head ke elemen berikutnya dalam antrian menggunakan head = head.next; 
			 * ini dilakukan untuk memindahkan atau menghapus pelanggan yang membatalkan pesanannya dari antrian.
			 */
			head=head.next;
		} 
		//Jika antrian kosong
		else {
			//return; akan langsung menghentikan eksekusi metode jika antrian sudah kosong (misalnya tidak ada pesanan yang dapat dibatalkan).
			return;
		}
	}
	
	//Metode print() yang ada di kelas QueuePesanan bertujuan untuk mencetak seluruh pesanan yang ada dalam antrian.
	void print() {
		
		//NodePesanan current = head; menyimpan referensi ke pesanan pertama di dalam antrian (disebut current).
		NodePesanan current = head;
		
		//System.out.println("Antrian Pesanan :"); mencetak header atau label untuk menunjukkan bahwa yang akan dicetak adalah antrian pesanan.
		System.out.println("Antrian Pesanan :");
		
		//Memeriksa apakah head (elemen pertama/anterian paling depan) tidak kosong, yaitu head != null.
		if(head!=null) {
			
			//melakukan perulangan untuk setiap node pesanan dalam antrian.
			while(current!=null) {
				/*
				 * mencetak nama pelanggan yang memesan dan
				 * memanggil metode print() dari kelas StackMakanan yang 
				 * digunakan untuk mencetak detail makanan yang dipesan oleh pelanggan.
				 */
				System.out.print(current.Pelanggan+" : "); current.makanan.print();
				
				//memindahkan pointer current ke node pesanan selanjutnya dalam antrian.
				current=current.next;
			}System.out.println();
		}
		//Jika antrian kosong
		else {
			//mencetak pesan yang mengindikasikan bahwa antrian tidak memiliki pesanan.
			System.out.println("antrian kosong");
			System.out.println();
		}
	}

}

//Kelas QueuePesananSelesai dibawah digunakan untuk mengelola pesanan yang telah selesai diproses.
class QueuePesananSelesai{
	
	/*
	 * dilakukan inisialisasi kelas NodePesanan dengan nama head untuk mengacu ke elemen awal pada linked list
	 * dan tail untuk mengacu ke elemen akhir pada linked list
	 */
	NodePesanan head,tail;
	
	/*
	 * Method enqueue(NodePesanan current) menambahkan pesanan yang telah selesai ke dalam antrian pesanan yang telah selesai.
	 */
	void enqueue(NodePesanan current) {
		//NodePesanan baru dibuat dengan menggunakan data dari current.
		NodePesanan newNode = new NodePesanan(current);
		
		//Pengecekan apakah antrian kosong (head tidak menunjuk ke node manapun).
		if(head==null) {
			//Jika kondisi ini terpenuhi, maka head dan tail diarahkan ke node pesanan baru.
			tail = newNode;
			head = tail;
		}else {
			//Jika antrian sudah memiliki elemen, node pesanan baru diarahkan ke node yang berada di belakang (disebut tail).
			tail.next=newNode;
			
			////Node tail (ujung antrian) diarahkan ke node pesanan baru, sehingga node pesanan baru menjadi node paling belakang dalam antrian.
			tail=newNode;
		}
	}
	/*
	 * metode print() bertujuan untuk mencetak daftar pesanan yang telah selesai diproses.
	 */
	void print() {
		/*
		 *  inisialisasi variabel current sebagai penunjuk ke node pertama dari 
		 *  daftar pesanan yang telah selesai diproses (head merupakan 
		 *  node pertama dalam antrian pesanan selesai).
		 */
		NodePesanan current = head;
		
		/*
		 * mencetak pesan output yang memberi informasi bahwa daftar pesanan yang akan dicetak merupakan pesanan yang telah selesai.
		 */
		System.out.println("Pesanan selesai :");
		
		//melakukan looping yang akan melakukan iterasi melalui setiap node dari daftar pesanan yang telah selesai.
		while(current!=null) {
			//mencetak nama pelanggan yang terkait dengan pesanan tersebut.
			System.out.print(current.selesai.Pelanggan+" : "); 
			
			//memanggil metode print() dari objek makanan yang merupakan 
			//instance dari StackMakanan pada node selesai
			//hal ini bertujuan untuk mencetak daftar makanan yang telah dipesan oleh pelanggan.
			current.selesai.makanan.print();
			
			//menggeser variabel current ke node selanjutnya.
			current=current.next;
		}System.out.println();
	}
}
public class Nomor2 {

	public static void main(String[] args) {
		StackMakanan pesanan1 = new StackMakanan();
		StackMakanan pesanan2 = new StackMakanan();
		StackMakanan pesanan3 = new StackMakanan();
		StackMakanan pesanan4 = new StackMakanan();
		
		pesanan1.push("Kentang");
		pesanan1.push("Air Mineral");
		pesanan1.push("Nasi Goreng");
		
		pesanan2.push("Air Mineral");
		pesanan2.push("Sosis");
		pesanan2.push("Teh Manis");
		pesanan2.push("Mie Goreng");
		
		pesanan3.push("Air Mineral");
		pesanan3.push("Kentang");
		
		pesanan4.push("Air Mineral");
		pesanan4.push("Sosis");
		pesanan4.push("Teh Manis");
		pesanan4.push("Nasi Goreng");
		
		QueuePesanan antrian = new QueuePesanan();
		QueuePesananSelesai pesananSelesai = new QueuePesananSelesai();
		antrian.enqueue("Rashford", pesanan1);
		antrian.enqueue("Jimin", pesanan2);
		antrian.enqueue("Marquez", pesanan3);
		antrian.enqueue("Ayanokoji", pesanan4);
		
		antrian.print();
		
		pesananSelesai.enqueue(antrian.dequeue());
		StackMakanan pesanan5 = new StackMakanan();
		pesanan5.push("Es Teh");
		pesanan5.push("Nasi Kuning");
		antrian.enqueue("Kiky", pesanan5);
		
		pesananSelesai.enqueue(antrian.dequeue());
		antrian.dequeueBatal();
		pesananSelesai.enqueue(antrian.dequeue());
		pesananSelesai.enqueue(antrian.dequeue());
		
		pesananSelesai.print();
		antrian.print();

	}

}

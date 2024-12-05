package modul2;

class ListLaguDeque {
	String lagu;
	String artis;
	ListLaguDeque next;

	ListLaguDeque(String lagu, String artis) {
		this.lagu = lagu;
		this.artis = artis;
	}
}

class LaguDeque {
	ListLaguDeque head, tail;

	void enqueue(String lagu, String artis) {
		ListLaguDeque newNode = new ListLaguDeque(lagu, artis);
		if (head == null) {
			tail = newNode;
			head = tail;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	void dequeue() {
		if (head != null) {
			head = head.next;
		} else {
			return;
		}
	}
	ListLaguDeque getLast() {
		return tail;
	}
	ListLaguDeque getFirst() {
		return head;
	}
	void print() {
		ListLaguDeque current = head;
		if (head != null) {
			System.out.print("[");
			while (current != null) {
				if (current.next != null) {
					System.out.print(current.lagu + " - [" + current.artis + "], ");
				} else {
					System.out.print(current.lagu + " - [" + current.artis + "]");
				}
				current = current.next;
			}
			System.out.print("]");
			System.out.println();
		}
	}
}

class ListArtistStack {
	String nama;
	LaguDeque lagulagu;
	ListArtistStack next;
	
	
	ListArtistStack(String nama, LaguDeque lagulagu) {
		this.nama = nama;
		this.lagulagu = lagulagu;
	}
}

class ArtisStack {
	ListArtistStack head, tail;

	void push(String nama, LaguDeque lagulagu) {
		ListArtistStack newArtist = new ListArtistStack(nama,lagulagu);
		if (head == null) {
			tail = newArtist;
			head = tail;
		}else {
			newArtist.next = head;
			head = newArtist;
		}
	}
	void pop() {
		if(head!=null) {
			head =head.next;
		}return;
	}
	void print() {
		ListArtistStack current =head;
		if (head != null) {
			while (current != null) {
				System.out.print("- "+current.nama+ " : "); 
				current.lagulagu.print();
				current = current.next;
			}
			System.out.println();
		}
	}
	
}

class Playlist{
	String namaPlaylist;
	String nama;
	String lagu;
	
	Playlist next;
	Playlist(String namaPlaylist){
		this.namaPlaylist=namaPlaylist;
	}
	Playlist (String nama,String lagu){
		this.nama=nama;
		this.lagu=lagu;
	}
}
class PlaylistQueue{
	Playlist head, tail;

	void enqueue(String lagu, String artis) {
		Playlist newNode = new Playlist(lagu, artis);
		if (head == null) {
			tail = newNode;
			head = tail;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	void dequeue() {
		if (head != null) {
			head = head.next;
		} else {
			return;
		}
	}

	void print() {
		Playlist current = head;
		if (head != null) {
			while (current != null) {
				System.out.println(" - ");
				current = current.next;
			}
			System.out.println();
		}
	}
}
public class Nomor3 {

	public static void main(String[] args) {
		ArtisStack artists = new ArtisStack ();
		LaguDeque indigo = new LaguDeque();
		LaguDeque one = new LaguDeque();
		LaguDeque zutomayo= new LaguDeque();
		LaguDeque paramore= new LaguDeque();
		
		indigo.enqueue("omoikiri", "indigo la End");
		indigo.enqueue("toorigoi", "indigo la End");
		
		one.enqueue("prove", "ONE OK ROCK");
		one.enqueue("save your self", "ONE OK ROCK");
		one.enqueue("gravity", "ONE OK ROCK");
		
		zutomayo.enqueue("obenkyou shitoteiyo", "Zutomayo");
		zutomayo.enqueue("kan saete kuyahiiwa", "Zutomayo");
		
		paramore.enqueue("decode","Paramore");
		paramore.enqueue("hard times","Paramore");
		
		artists.push("indigo la End", indigo);
		artists.push("ONE OK ROCK", one);
		artists.push("Zutomayo", zutomayo);
		artists.push("Paramore", paramore);
		
		artists.print();
		
		
	}

}

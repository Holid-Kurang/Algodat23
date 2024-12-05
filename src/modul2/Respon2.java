package modul2;

class Orang{
	int estimasi;
	int tujuanLantai;
	Orang next;
	Orang prev;
	Orang(int estimasi,int tujuanLantai){
		this.estimasi=estimasi;
		this.tujuanLantai=tujuanLantai;
	}
}
class Queue{
	Orang head,tail;
	void enqueue(int estimasi,int tujuanLantai) {
		Orang masuk = new Orang(estimasi, tujuanLantai);
		if(head==null) {
			tail = masuk;
			head = tail;
		}else {
			tail.next=masuk;
			masuk.prev=tail;
			tail=masuk;
		}
	}
	
	Orang dequeue() {
		Orang current =head;
		head=head.next;
//		penguranganWaktu();
		return current;
	}
	int size() {
		int i=0;
		Orang current = head;
		while(current!=null) {
			i++;
			current=current.next;
		}return i;
	}
	void keluarAntrian() {
		Orang current=head;
		while(current!=null) {
			if(current.estimasi==0) {
				if (head == tail) {
					head = null;
					tail = null;
				} else if (current == head) {
					head = head.next;
					head.prev = null;
				} else if (current == tail || current.next == null) {
					tail = tail.prev;
					tail.next.prev = null;
					tail.next = null;
				} else {
					current.next.prev = current.prev;
					current.prev.next = current.next;
					current.next = null;
					current.prev = null;
				}
				
				current=head;
			}
			current=current.next;
		}
	}
	void penguranganWaktu() {
		Orang current = head;
		while(current !=null) {
			current.estimasi--;
			current=current.next;
		}
	}
	void print() {
		int i=size();
		if(head!=null) {
			Orang current =head;
			while(current!= null) {
				System.out.print(i+"(estimasi waktu: "+current.estimasi+" tujuan : "+current.tujuanLantai+") ");
				current=current.next;
				i--;
			}System.out.println();
		}else {
			System.out.println("antrian kosong");
		}
	}
}
public class Respon2 {
	public static void main(String[] args) {
		Queue lantai1 = new Queue();
		Queue lantai2 = new Queue();
		Queue lantai3 = new Queue();
		int posisiLift=1;
		
		lantai1.enqueue(2, 3);
		lantai1.enqueue(3, 2);
		lantai1.enqueue(1, 3);
		lantai1.enqueue(5, 3);
		lantai1.enqueue(6, 2);
		
		lantai2.enqueue(1, 1);
		lantai2.enqueue(5, 3);
		lantai2.enqueue(7, 1);
		lantai2.enqueue(3, 3);
		lantai2.enqueue(2, 3);
		
		lantai3.enqueue(3, 1);
		lantai3.enqueue(1, 2);
		lantai3.enqueue(4, 1);
		lantai3.enqueue(5, 2);
		lantai3.enqueue(8, 1);

		lantai3.print();
		lantai2.print();
		lantai1.print();
		
		System.out.println();
		System.out.println();
		
		while(lantai1.head!=null && lantai2.head!=null && lantai3.head!=null) {
			lantai1.keluarAntrian();
			lantai2.keluarAntrian();
			lantai3.keluarAntrian();
			if(posisiLift==1) {
				System.out.print("   lantai 3 "); lantai3.print();
				System.out.print("   lantai 2 "); lantai2.print();
				System.out.print("[1]lantai 1 "); lantai1.print();
			}else if(posisiLift==2) {
				System.out.print("   lantai 3 "); lantai3.print();
				System.out.print("[2]lantai 2 "); lantai2.print();
				System.out.print("   lantai 1 "); lantai1.print();
			}else if(posisiLift==3) {
				System.out.print("[3]lantai 3 "); lantai3.print();
				System.out.print("   lantai 2 "); lantai2.print();
				System.out.print("   lantai 1 "); lantai1.print();
			}
			System.out.println();
	
			if(posisiLift==1) {
				posisiLift=lantai1.dequeue().tujuanLantai;
			}else if(posisiLift==2) {
				posisiLift=lantai2.dequeue().tujuanLantai;
			}else if(posisiLift==3) {
				posisiLift=lantai3.dequeue().tujuanLantai;
			}
			lantai1.penguranganWaktu();
			lantai2.penguranganWaktu();
			lantai3.penguranganWaktu();
			
		
		}
		if(posisiLift==1) {
			System.out.print("   lantai 3 "); lantai3.print();
			System.out.print("   lantai 2 "); lantai2.print();
			System.out.print("[1]lantai 1 "); lantai1.print();
		}else if(posisiLift==2) {
			System.out.print("   lantai 3 "); lantai3.print();
			System.out.print("[2]lantai 2 "); lantai2.print();
			System.out.print("   lantai 1 "); lantai1.print();
		}else if(posisiLift==3) {
			System.out.print("[3]lantai 3 "); lantai3.print();
			System.out.print("   lantai 2 "); lantai2.print();
			System.out.print("   lantai 1 "); lantai1.print();
		}
	}
}

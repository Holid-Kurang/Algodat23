package modul2;


class Kue{
	int ukuran;
	Kue next;
	
	Kue(int ukuran){
		this.ukuran=ukuran;
	}
}
class StackKue{
	Kue head, tail;
	void push(int ukuran) {
		Kue kue = new Kue(ukuran);
		if(head==null) {
			tail=kue;
			head=tail;
		}else {
			kue.next=head;
			head=kue;
		}
	}
	void pushAfter(int ukuran) {
		Kue kue = new Kue(ukuran);
		if(head==null) {
			tail=kue;
			head=tail;
		}else {
			StackKue current = new StackKue();
	        while (head != null && head.ukuran < ukuran) {
	            current.push(head.ukuran);
	            this.pop();
	        }
	        kue.next = head;
	        head = kue;
	        while (current.head != null) {
	            this.push(current.pop().ukuran);
	            
	        }
		}
	}
	Kue pop() {
		Kue current = head;
		head=head.next;
		return current;
	}
	void print() {
		Kue current = head;
		if(head!=null) {
			while(current!=null) {
				System.out.println(current.ukuran);
				current=current.next;
			}System.out.println();
		}else {
			System.out.println("kotak kosong");
			System.out.println();
		}
	}
}

public class Respon1 {
	public static void main(String[] args) {
		StackKue kotaksalah = new StackKue();
		StackKue kotakbantu = new StackKue();
		StackKue kotakbenar = new StackKue();
		
		kotaksalah.push(5);
		kotaksalah.push(4);
		kotaksalah.push(2);
		kotaksalah.print();
		System.out.println("ketika ingin menumpuk kue berukuran 3 tetapi dibawahnya terdapat kue\nyang lebih kecil dari kue berukuran 3");
		System.out.println("maka tumpukan kue harus dikeluarkna terlebih dahulu");
		System.out.println("sampai kue yang dibawahnya berukuran lebih besar dari kue yang ingin dimasukkan");
		kotaksalah.pushAfter(3);
		kotaksalah.push(1);
		System.out.println("------------------------------------");
		System.out.println("kotak salah : ");
		kotaksalah.print();
		System.out.println("kotak bantu : ");
		kotakbantu.print(); 
		System.out.println("kotak bener : ");
		kotakbenar.print(); 
		System.out.println("------------------------------------");
		
		while(kotaksalah.head!=null) {
			kotakbantu.push(kotaksalah.pop().ukuran);
		}
		System.out.println("kotak salah : ");
		kotaksalah.print();
		System.out.println("kotak bantu : ");
		kotakbantu.print(); 
		System.out.println("kotak bener : ");
		kotakbenar.print(); 
		System.out.println("------------------------------------");
		
		
		while(kotakbantu.head!=null) {
			kotakbenar.push(kotakbantu.pop().ukuran);
		}
		System.out.println("kotak salah : ");
		kotaksalah.print();
		System.out.println("kotak bantu : ");
		kotakbantu.print(); 
		System.out.println("kotak bener : ");
		kotakbenar.print(); 
		
	}
}

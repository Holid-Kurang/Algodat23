package modul1;


class Bomb {
	char nama;
	int range;
	int index;
	Bomb next;

	Bomb(char nama, int range, int index) {
		this.nama = nama;
		this.range = range;
		this.index = index;
	}
}

class BombList {
	Bomb head, tail;
	int i=0;
	
	int size() {
		Bomb current=head;
		int i=1;
		while(current!=null) {
			i++;
			current=current.next;
		}
		return i;
	}
	
	public void addBom(char nama, int range) {
		Bomb newBomb = new Bomb(nama, range, i);
		if (head == null) {
			tail = newBomb;
			head = tail;
		} else {
			tail.next = newBomb;
			tail = newBomb;
		}
		i++;
	}

	public void meledak(char nama) {
		Bomb current = head;
		if(head.nama == nama) {
			if(current.range==0) {
				head=head.next;
				return;
			}else {
				int simpanRange = current.range/2;
				for(int i=0; i<=simpanRange; i++) {
					if(current.range>0 && current.index!=0) {
						simpanRange+=current.range/2;
					}
					current=current.next;
				}
				for(int i=0; i<=simpanRange; i++) {
					head=head.next;
				}
				return;
			}
		}else if(tail.nama==nama) {
			if(tail.range==0) {
				while (current.next != tail) {
					current = current.next;
				}
				tail = current;
				tail.next = null;
				return;
			}else {
				int simpanRange = tail.range/2;
				for(int i=0; i<size()-(tail.range/2)-2;i++) {
					current=current.next;
				}
				System.out.println(current.index);
				while(current!=null) {
					
					if(current.range>0 && current!=tail) {
						simpanRange+=current.range/2;
					}
					current=current.next;
				}
				System.out.println(simpanRange);
				current=head;
				for(int i=0; i<size()-simpanRange-3;i++) {
					current=current.next;
				}current.next=null;

				return;
			}
		}
		
		while (current != null) {
			if (current.next.nama == nama) {
				break;
			}
			current = current.next;
		}

		if (current.next.range == 0) {
			current.next = current.next.next;
		} else {
			int simpan = current.next.range / 2;
			current = current.next;
			current.range /= 2;
			for (int i = 0; i < simpan; i++) {
				if(current.next.next != null) {
					current.next = current.next.next;
				}
			}
			
			simpan = current.range;
			current = head;
			while (current != null) {
				if (current.range > 0 ) {
					simpan += current.range / 2;
				}
				current = current.next;
			}

			current = head;
			do {
				Bomb currentCek = current;
				for (int i = 0; i < simpan + 1; i++) {
					if(currentCek.next!=null) {
						currentCek = currentCek.next;
					}
				}
				if (currentCek.range == simpan || currentCek.nama== nama) {
					break;
				}
				current= current.next;
			} while (true);
			
			for (int i = 0; i < simpan + 1; i++) {
	               current.next = current.next.next;
			}
		}
	}

	void print() {
		Bomb current = head;
		while (current != null) {
			System.out.print(current.nama + " ");
			current = current.next;
		}System.out.println();
	}
}

public class Responbom {

	public static void main(String[] args) {
		BombList list = new BombList();
		list.addBom('a', 0);
		list.addBom('b', 0);
		list.addBom('c', 0);
		list.addBom('d', 0);
		list.addBom('e', 2);
		list.addBom('f', 0);
		list.addBom('g', 4);
		list.addBom('h', 0);
		list.addBom('i', 0);
		list.addBom('j', 0);
		list.addBom('k', 0);
		list.print();
		list.meledak('g');
		list.print();
	}

}

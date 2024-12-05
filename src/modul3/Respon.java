package modul3;

public class Respon {

	public static void main(String[] args) {
		DoubleWarrior senjataWarrior = new DoubleWarrior();

		senjataWarrior.addLast("Wind of Nature", 25, 2350);
		senjataWarrior.addLast("Golden Staff", 27, 2350);
		senjataWarrior.addLast("Rose Gold Meteor", 17, 2350);
		senjataWarrior.addLast("Bloodlust Axe", 9, 2350);
		senjataWarrior.addLast("Hunter Strike", 15, 2350);
		senjataWarrior.addLast("Blade of Despair", 23, 2350);
		senjataWarrior.addLast("Haas's Claws", 19, 2350);
		senjataWarrior.addLast("Sea Halberd", 6, 2030);
		senjataWarrior.addLast("Malefic Roar", 3, 2350);
		senjataWarrior.addLast("Demon Hunter Sword", 8, 1970);
		senjataWarrior.addLast("Scarlet Phantom", 16, 2350);
		senjataWarrior.addLast("Windtaker", 12, 2350);
		senjataWarrior.addLast("Endles Battle", 4, 2350);
		senjataWarrior.addLast("Berserker Fury", 3, 2350);

		// INSERTION SORT ASC & DESC
//		System.out.println("====[BEFORE]====");
//		senjataWarrior.printStok();
//		System.out.println("====[Insertion sort DESC]");
//		senjataWarrior.insertionSortDesc();
//		senjataWarrior.printStok();
//		System.out.println("====[Insertion sort ASC]");
//		senjataWarrior.insertionSortAsc();
//		senjataWarrior.printStok();

		// QUICK SORT ASC
//		System.out.println("====[BEFORE]====");
//		senjataWarrior.printStok();
		senjataWarrior.quickSort(senjataWarrior.head, senjataWarrior.tail);
		System.out.println("====[AFTER]====");
		senjataWarrior.printStok();

		// LINEAR SEARCH 
//		WeaponWarrior current = senjataWarrior.head;
//        int i=1;
//		while (current != null) {
//            if (current.stok % 2 == 1) {
//                // Senjata dengan stok ganjil ditemukan
//            	System.out.println("senjata dengan stok "+current.stok+" ditemukan pada posisi ke-"+i);
//            	System.out.println("id = "+current);
//            	System.out.println("nama = "+current.nama);
//            	System.out.println("stok = "+current.stok);
//            	System.out.println();
//            }
//            i++;
//            current = current.next;
//        }
		
		// BINARY SEARCH 
//		WeaponWarrior findWeapon = senjataWarrior.binarySearch(senjataWarrior.head , 15);
//		int findIndex = senjataWarrior.findIndex(15);
//		System.out.println("senjata dengan stok 15 ditemukan pada posisi ke - "+findIndex);
//		System.out.println("nama : "+findWeapon.nama);
//		System.out.println("stok : "+findWeapon.stok);
//		System.out.println("harga : "+findWeapon.harga);
	}

}

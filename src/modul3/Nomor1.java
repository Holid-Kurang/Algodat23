package modul3;

public class Nomor1 {

	public static void main(String[] args) {
		DoubleWarrior senjataWarrior = new DoubleWarrior();
		
		senjataWarrior.addLast("Demon Hunter Sword", 8, 1970);
		senjataWarrior.addLast("Sea Halberd", 19, 2030);
		senjataWarrior.addLast("Malefic Roar", 3, 2350);
		senjataWarrior.addLast("Haas's Claws", 19, 2350);
		senjataWarrior.addLast("Berserker Fury", 3, 2350);
		senjataWarrior.addLast("Endles Battle", 4, 2350);
		senjataWarrior.addLast("Windtaker", 12, 2350);
		senjataWarrior.addLast("Scarlet Phantom", 16, 2350);
		senjataWarrior.addLast("Blade of Despair", 23, 2350);
		senjataWarrior.addLast("Hunter Strike", 15, 2350);
		senjataWarrior.addLast("Bloodlust Axe", 9, 2350);
		senjataWarrior.addLast("Rose Gold Meteor", 17, 2350);
		senjataWarrior.addLast("Golden Staff", 27, 2350);
		senjataWarrior.addLast("Wind of Nature", 25, 2350);
		System.out.println("[---BEFORE---]");
		senjataWarrior.printStok();
		
		System.out.println("Stok yang ingin dicari : 17");
		WeaponWarrior findWeapon = senjataWarrior.linearSearch(17);
		int findPosition = senjataWarrior.findIndex(17);
		System.out.println("senjata stok 17 ditemukan pada posisi ke - "+findPosition);
		System.out.println("nama : "+findWeapon.nama);
		System.out.println("stok : "+findWeapon.stok);
		System.out.println("harga : "+findWeapon.harga);

		// BUBBLE SORT
		senjataWarrior.bubbleSort();
		System.out.println();
		System.out.println("[---AFTER---]");
		senjataWarrior.printStok();
		
	}

}

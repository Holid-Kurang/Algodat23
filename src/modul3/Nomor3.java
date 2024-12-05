package modul3;

public class Nomor3 {

	public static void main(String[] args) {
		DoubleWitch senjataWitch = new DoubleWitch();
		senjataWitch.addLast("Enchanted Talisman", 9, 1870);
		senjataWitch.addLast("Divine Glaive", 11, 1970);
		senjataWitch.addLast("Winter Trucheon", 14, 1910);
		senjataWitch.addLast("Feather of Heaven", 1, 2030);
		senjataWitch.addLast("Holy Crystal", 0, 2180);
		senjataWitch.addLast("Genius Wand", 6, 2000);
		senjataWitch.addLast("Necklace of Durance", 10, 2110);
		senjataWitch.addLast("Concentrated Energy", 12, 2020);
		senjataWitch.addLast("Ice Queen Wand", 18, 2240);
		senjataWitch.addLast("Glowing Hand", 16, 2120);
		senjataWitch.addLast("Calamity Repear", 15, 1950);
		senjataWitch.addLast("Clock of Destiny", 19, 1950);
		senjataWitch.addLast("Blood Wings", 20, 3000);
		senjataWitch.addLast("Fleeting Time", 21, 2050);
		senjataWitch.addLast("Lighting Turncheon", 17, 2250);
		
		//INSERTION SORT
		System.out.println("[---BEFORE---]");
		senjataWitch.printHarga();

		senjataWitch.insertionSort();
		System.out.println("[---AFTER---]");
		senjataWitch.printHarga();

		System.out.println("Harga yang ingin dicari : 2020");
		WeaponWitch findWeapon = senjataWitch.binarySearch(senjataWitch.head ,2020);
		int findIndex = senjataWitch.findIndex(2020);
		System.out.println("senjata harga 2020 ditemukan pada posisi ke - "+findIndex);
		System.out.println("nama : "+findWeapon.nama);
		System.out.println("stok : "+findWeapon.stok);
		System.out.println("harga : "+findWeapon.harga);
		
		System.out.println();
		System.out.println("terletak setelah ");
		System.out.println("nama : "+findWeapon.prev.nama);
		System.out.println("stok : "+findWeapon.prev.stok);
		System.out.println("harga : "+findWeapon.prev.harga);
		
		System.out.println();
		System.out.println("terletak sebelum ");
		System.out.println("nama : "+findWeapon.next.nama);
		System.out.println("stok : "+findWeapon.next.stok);
		System.out.println("harga : "+findWeapon.next.harga);
	
	}

}

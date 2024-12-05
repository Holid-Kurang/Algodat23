package modul3;

public class Nomor4 {

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
		System.out.println("[---BEFORE---]");
		senjataWitch.printHarga();
	
		System.out.println("[---AFTER---]");
		senjataWitch.shellSort();
		senjataWitch.printHarga();
	}

}

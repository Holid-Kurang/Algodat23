package modul3;

public class Nomor2 {

	public static void main(String[] args) {
		DoubleWitch senjataWitch = new DoubleWitch();
		senjataWitch.addLast("Enchanted Talisman", 9, 0);
		senjataWitch.addLast("Divine Glaive", 11, 0);
		senjataWitch.addLast("Winter Trucheon", 14, 0);
		senjataWitch.addLast("Feather of Heaven", 1, 0);
		senjataWitch.addLast("Holy Crystal", 0, 0);
		senjataWitch.addLast("Genius Wand", 6, 0);
		senjataWitch.addLast("Necklace of Durance", 10, 0);
		senjataWitch.addLast("Concentrated Energy", 12, 0);
		senjataWitch.addLast("Ice Queen Wand", 18, 0);
		senjataWitch.addLast("Glowing Hand", 16, 0);
		senjataWitch.addLast("Calamity Repear", 15, 0);
		senjataWitch.addLast("Clock of Destiny", 19, 0);
		senjataWitch.addLast("Blood Wings", 20, 0);
		senjataWitch.addLast("Fleeting Time", 21, 0);
		senjataWitch.addLast("Lighting Turncheon", 17, 0);
		
		//SELECTION SORT
		System.out.println("[---BEFORE---]");
		senjataWitch.printStok();
		
		System.out.println("[---AFTER---]");
		senjataWitch.selectionSort();
		senjataWitch.printStok();
		
	}

}

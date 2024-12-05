package modul3;

public class Nomor6 {

	public static void main(String[] args) {
		DoubleWitch senjataWitch = new DoubleWitch();
		System.out.println("[---BEFORE---]");
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
		System.out.println("[WITCH]");
		senjataWitch.print();
		
		DoubleWarrior senjataWarrior = new DoubleWarrior();
		senjataWarrior.addLast("Demon Hunter Sword", 8, 1970);
		senjataWarrior.addLast("Sea Halberd", 8, 2030);
		senjataWarrior.addLast("Malefic Roar", 2, 2350);
		senjataWarrior.addLast("Haas's Claws", 19, 2350);
		senjataWarrior.addLast("Berserker Fury", 7, 2350);
		senjataWarrior.addLast("Endles Battle", 4, 2350);
		senjataWarrior.addLast("Windtaker", 12, 2350);
		senjataWarrior.addLast("Scarlet Phantom", 16, 2350);
		senjataWarrior.addLast("Blade of Despair", 23, 2350);
		senjataWarrior.addLast("Hunter Strike", 15, 2350);
		senjataWarrior.addLast("Bloodlust Axe", 9, 2350);
		senjataWarrior.addLast("Rose Gold Meteor", 17, 2350);
		senjataWarrior.addLast("Golden Staff", 27, 2350);
		senjataWarrior.addLast("Wind of Nature", 25, 2350);
		System.out.println("[WARRIOR]");
		senjataWarrior.print();
		
		
		System.out.println("[---AFTER---]");
		senjataWarrior.mergeSort(senjataWarrior.head);
		senjataWitch.mergeSort(senjataWitch.head);
		System.out.println("[WARRIOR]");
		senjataWarrior.print();
		System.out.println("[WITCH]");
		senjataWitch.print();
	}

}

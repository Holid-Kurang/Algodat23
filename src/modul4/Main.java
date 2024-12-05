package modul4;

public class Main {
	public static void main(String[] args) {
		// NOMOR 111111111111111111111111111111111111111111111111111111111111111111
		Pohon tree = new Pohon("Earth-616");
		tree.insert("Earth-616", "Earth-1610", "Earth-1228");

		tree.insert("Earth-1610", "Earth-65", "Earth-199999");
		tree.insert("Earth-1228", "Earth-295", "Earth-6311");

		tree.insert("Earth-199999", "Earth-311", "Earth-982");
		tree.insert("Earth-295", "Earth-18119", "Earth-2149");

		tree.insert("Earth-311", "Earth-801", "");
		tree.insert("Earth-18119", "Earth-1611", "");
		tree.insert("Earth-2149", "Earth-807128", "Earth-5631");
		
		System.out.println("All Universe (Pre Order)");
		tree.preOrder(tree.root);
		System.out.println();
		System.out.println("All Universe (In Order)");
		tree.inOrder(tree.root);
		System.out.println();
		System.out.println("All Universe (Post Order)");
		tree.postOrder(tree.root);
		System.out.println();
		
		// NOMOR 2222222222222222222222222222222222222222222222222222222222222222222
		ListHero hero616 = new ListHero();
		hero616.addLast("spiderman", 85);
		hero616.addLast("iron man", 92);
		hero616.addLast("captain america", 88);
		hero616.addLast("thor", 95);
		hero616.addLast("hulk", 97);
		hero616.addLast("black widow", 82);
		hero616.addLast("hawkeye", 80);
		hero616.addLast("mr. fantastic", 90);

		ListHero hero1228 = new ListHero();
		hero1228.addLast("mr. fantastic", 91);
		hero1228.addLast("invisible women", 84);
		hero1228.addLast("human torch", 87);
		hero1228.addLast("the thing", 89);

		ListHero hero311 = new ListHero();
		hero311.addLast("spiderman", 92);
		hero311.addLast("captain america", 89);
		hero311.addLast("black widow", 82);

		ListHero hero65 = new ListHero();
		hero65.addLast("spider-gwen", 86);
		hero65.addLast("spiderwomen", 83);

		ListHero hero801 = new ListHero();
		hero801.addLast("iron man", 85);
		hero801.addLast("captain america", 88);
		hero801.addLast("doctor strange", 83);

		ListHero hero1610 = new ListHero();
		hero1610.addLast("spider-miles", 87);
		hero1610.addLast("wolverine", 92);
		hero1610.addLast("spider-miles", 89);

		ListHero hero199999 = new ListHero();
		hero199999.addLast("iron man", 89);
		hero199999.addLast("captain america", 87);
		hero199999.addLast("thor", 94);
		hero199999.addLast("hulk", 96);
		hero199999.addLast("scarlet witch", 99);

		ListHero hero982 = new ListHero();
		hero982.addLast("spider-girl", 79);

		ListHero hero6311 = new ListHero();
		hero6311.addLast("spider-noir", 87);
		hero6311.addLast("daredevil", 83);

		ListHero hero295 = new ListHero();
		hero295.addLast("cyclops", 89);
		hero295.addLast("wolverine", 92);

		ListHero hero2149 = new ListHero();
		hero2149.addLast("scarlet witch", 98);
		hero2149.addLast("captain america", 91);
		hero2149.addLast("iron man", 84);

		ListHero hero1611 = new ListHero();
		hero1611.addLast("iron man", 87);
		hero1611.addLast("captain america", 90);
		hero1611.addLast("thor", 94);
		hero1611.addLast("hulk", 98);

		ListHero hero18119 = new ListHero();
		hero18119.addLast("spider-miles", 88);
		hero18119.addLast("spider-B.parker", 86);
		hero18119.addLast("spider-gwen", 84);
		hero18119.addLast("spider-ham", 80);

		ListHero hero807128 = new ListHero();
		hero807128.addLast("wolverine", 95);
		hero807128.addLast("hawkeye", 89);

		ListHero hero5631 = new ListHero();
		hero5631.addLast("black panther", 88);
		hero5631.addLast("scarlet witch", 90);

		tree.insertHero("Earth-616", hero616);
		tree.insertHero("Earth-1610", hero1610);
		tree.insertHero("Earth-65", hero65);
		tree.insertHero("Earth-199999", hero199999);
		tree.insertHero("Earth-311", hero311);
		tree.insertHero("Earth-801", hero801);
		tree.insertHero("Earth-982", hero982);
		tree.insertHero("Earth-1228", hero1228);
		tree.insertHero("Earth-295", hero295);
		tree.insertHero("Earth-18119", hero18119);
		tree.insertHero("Earth-1611", hero1611);
		tree.insertHero("Earth-2149", hero2149);
		tree.insertHero("Earth-807128", hero807128);
		tree.insertHero("Earth-5631", hero5631);
		tree.insertHero("Earth-6311", hero6311);
		
		System.out.println("Highest Power Hero In All Universe : ");
		System.out.println(
				tree.search(tree.root, "Earth-616").universe + " : " + tree.levelOrderBFS(tree.root, "Earth-616").hero
						+ " >> " + tree.levelOrderBFS(tree.root, "Earth-616").power);
		System.out.println(
				tree.search(tree.root, "Earth-1610").universe + " : " + tree.levelOrderBFS(tree.root, "Earth-1610").hero
				+ " >> " + tree.levelOrderBFS(tree.root, "Earth-1610").power);
		System.out.println(
				tree.search(tree.root, "Earth-295").universe + " : " + tree.levelOrderBFS(tree.root, "Earth-295").hero
				+ " >> " + tree.levelOrderBFS(tree.root, "Earth-295").power);
		System.out.println(
				tree.search(tree.root, "Earth-18119").universe + " : " + tree.levelOrderBFS(tree.root, "Earth-18119").hero
				+ " >> " + tree.levelOrderBFS(tree.root, "Earth-18119").power);
		System.out.println(
				tree.search(tree.root, "Earth-1228").universe + " : " + tree.levelOrderBFS(tree.root, "Earth-1228").hero
				+ " >> " + tree.levelOrderBFS(tree.root, "Earth-1228").power);
		System.out.println(
				tree.search(tree.root, "Earth-65").universe + " : " + tree.levelOrderBFS(tree.root, "Earth-65").hero
				+ " >> " + tree.levelOrderBFS(tree.root, "Earth-65").power);
		System.out.println(
				tree.search(tree.root, "Earth-199999").universe + " : " + tree.levelOrderBFS(tree.root, "Earth-199999").hero
				+ " >> " + tree.levelOrderBFS(tree.root, "Earth-199999").power);
		System.out.println(
				tree.search(tree.root, "Earth-2149").universe + " : " + tree.levelOrderBFS(tree.root, "Earth-2149").hero
				+ " >> " + tree.levelOrderBFS(tree.root, "Earth-2149").power);
		System.out.println(
				tree.search(tree.root, "Earth-807128").universe + " : " + tree.levelOrderBFS(tree.root, "Earth-807128").hero
				+ " >> " + tree.levelOrderBFS(tree.root, "Earth-807128").power);
		System.out.println(
				tree.search(tree.root, "Earth-311").universe + " : " + tree.levelOrderBFS(tree.root, "Earth-311").hero
				+ " >> " + tree.levelOrderBFS(tree.root, "Earth-311").power);
		System.out.println(
				tree.search(tree.root, "Earth-801").universe + " : " + tree.levelOrderBFS(tree.root, "Earth-801").hero
				+ " >> " + tree.levelOrderBFS(tree.root, "Earth-801").power);
		System.out.println(
				tree.search(tree.root, "Earth-982").universe + " : " + tree.levelOrderBFS(tree.root, "Earth-982").hero
				+ " >> " + tree.levelOrderBFS(tree.root, "Earth-982").power);
		System.out.println(
				tree.search(tree.root, "Earth-6311").universe + " : " + tree.levelOrderBFS(tree.root, "Earth-6311").hero
				+ " >> " + tree.levelOrderBFS(tree.root, "Earth-6311").power);
		System.out.println(
				tree.search(tree.root, "Earth-1611").universe + " : " + tree.levelOrderBFS(tree.root, "Earth-1611").hero
				+ " >> " + tree.levelOrderBFS(tree.root, "Earth-1611").power);
		System.out.println(
				tree.search(tree.root, "Earth-5631").universe + " : " + tree.levelOrderBFS(tree.root, "Earth-5631").hero
				+ " >> " + tree.levelOrderBFS(tree.root, "Earth-5631").power);
		System.out.println();
		
		// menampilkan semua universe secara Level-Order
		// beserta dengan hero terkuat yang dimilikinya
		System.out.println("(Level Order) Highest Power Hero In All Universe : ");
		tree.levelOrder(tree.root);
		System.out.println();
		
		//NOMOR 333333333333333333333333333333333333333333333333333333333333333
		System.out.println("All Universe (Pre Order) Before Delete Earth-295");
		tree.preOrder(tree.root);
		tree.delete("Earth-295");
		System.out.println();
		System.out.println("All Universe (Pre Order) After Delete Earth-295");
		tree.preOrder(tree.root);
	}
}

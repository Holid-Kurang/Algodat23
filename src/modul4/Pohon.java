package modul4;

public class Pohon {
	Earth root;

	Pohon(String uni) {
		root = new Earth(uni);
	}

	// DFS : Pre-Order, In-Order, Post-Order
	// Pre-order traversal
	public void preOrder(Earth node) {
		if (node == null)
			return;

		if (node.left == null && node.right == null) {
			System.out.println(node.universe + " : -");
		} else if (node.left == null) {
			System.out.println(node.universe + " : " + node.right.universe);
		} else if (node.right == null) {
			System.out.println(node.universe + " : " + node.left.universe);
		} else {
			System.out.println(node.universe + " : " + node.left.universe + ", " + node.right.universe);
		}

		preOrder(node.left);
		preOrder(node.right);
	}

	// In-order traversal
	public void inOrder(Earth node) {
		if (node == null)
			return;

		inOrder(node.left);
		if (node.left == null && node.right == null) {
			System.out.println(node.universe + " : -");
		} else if (node.left == null) {
			System.out.println(node.universe + " : " + node.right.universe);
		} else if (node.right == null) {
			System.out.println(node.universe + " : " + node.left.universe);
		} else {
			System.out.println(node.universe + " : " + node.left.universe + ", " + node.right.universe);

		}
		inOrder(node.right);
	}

	// Post-order traversal
	public void postOrder(Earth node) {
		if (node == null)
			return;

		postOrder(node.left);
		postOrder(node.right);
		if (node.left == null && node.right == null) {
			System.out.println(node.universe + " : -");
		} else if (node.left == null) {
			System.out.println(node.universe + " : " + node.right.universe);
		} else if (node.right == null) {
			System.out.println(node.universe + " : " + node.left.universe);
		} else {
			System.out.println(node.universe + " : " + node.left.universe + ", " + node.right.universe);

		}
	}

	// BFS : level-order
	// Level-order traversal
	// metode ini akan menampilkan semua universe secara Level-Order
	// beserta dengan hero terkuat yang dimilikinya
	public void levelOrder(Earth root) {
		if (root == null)
			return;

		QueueEarth queue = new QueueEarth();
		queue.enqueue(root);

		while (queue.head != null) {
			Earth tempEarth = queue.dequeue().earth;
			ListHero listHero = tempEarth.earthHero;
			System.out.println(tempEarth.universe + " : " + listHero.searchStrongest().hero + " >> "
					+ listHero.searchStrongest().power + " Power");

			if (tempEarth.left != null) {
				queue.enqueue(tempEarth.left);
			}

			if (tempEarth.right != null) {
				queue.enqueue(tempEarth.right);
			}
		}
	}

	// metode ini akan mencari universe/earth yang dituju secara BFS atau level
	// order
	// dan akan mengembalikan sebuah nilai Hero yang terkuat dalam earth/universe
	// yang dituju
	public Hero levelOrderBFS(Earth root, String earth) {
		if (root == null)
			return null;

		QueueEarth queue = new QueueEarth();
		queue.enqueue(root);

		while (queue.head != null) {
			Earth tempEarth = queue.dequeue().earth;
			if (tempEarth.universe.equals(earth)) {
				return tempEarth.earthHero.searchStrongest();
			}
			if (tempEarth.left != null) {
				queue.enqueue(tempEarth.left);
			}

			if (tempEarth.right != null) {
				queue.enqueue(tempEarth.right);
			}
		}
		return null;
	}

	// search earth with pre-order or DFS
	Earth search(Earth node, String key) {
		if (node == null || node.universe.equals(key)) {
			return node;
		}

		Earth leftResult = search(node.left, key);
		if (leftResult != null) {
			return leftResult;
		}

		return search(node.right, key);
	}

	void insert(String parent, String left, String right) {
		Earth benih = search(root, parent);
		if (benih != null) {
			if (left != null && !left.isEmpty()) {
				benih.left = new Earth(left, benih);
			}
			if (right != null && !right.isEmpty()) {
				benih.right = new Earth(right, benih);
			}
		}
	}
	
	void insertHero(String parent, ListHero hero) {
		Earth benih = search(root, parent);
		benih.earthHero = hero;
	}

	Earth searchParent(Earth node, String child) {
		if (node == null || (node.left != null && node.left.universe.equals(child))
				|| (node.right != null && node.right.universe.equals(child))) {
			return node;
		}

		Earth leftResult = searchParent(node.left, child);
		if (leftResult != null) {
			return leftResult;
		}

		return searchParent(node.right, child);
	}

	void delete(String key) {
		Earth parent = searchParent(root, key);
		Earth nodeToDelete = search(root, key);

		if(nodeToDelete.left==null && nodeToDelete.right==null ) {
			if (parent.left == nodeToDelete) {
				parent.left=null;
			} else if (parent.right == nodeToDelete) {
				parent.right=null;
			}
		}
		// Hapus node dan gantikan dengan child yang memiliki total power terbesar
		if (nodeToDelete != null) {
			Earth childWithMaxPower = nodeToDelete.left;
			if (nodeToDelete.right != null
					&& nodeToDelete.right.earthHero.totalPower() > childWithMaxPower.earthHero.totalPower()) {
				childWithMaxPower = nodeToDelete.right;
			}
			if (childWithMaxPower != null) {
				if (parent.left == nodeToDelete) {
					parent.left = childWithMaxPower;
					childWithMaxPower.right = nodeToDelete.right;
				} else if (parent.right == nodeToDelete) {
					parent.right = childWithMaxPower;
					childWithMaxPower.left = nodeToDelete.left;
				}
			} else {
				if (parent.left == nodeToDelete) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			}
		}
	}
}

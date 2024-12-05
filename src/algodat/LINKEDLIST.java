package algodat;
import java.util.LinkedList;

 class LINKEDLIST {

	public static void main(String[] args) {
		// Membuat objek LinkedList
        LinkedList<String> linkedList = new LinkedList<>();

        // Menambahkan elemen ke akhir linked list
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Orange");
        linkedList.addLast("gedang");
        // Menambahkan elemen di awal linked list
        linkedList.addFirst("Grapes");

        // Menambahkan elemen di indeks tertentu
        linkedList.add(2, "Mango");
        // Menghapus elemen di awal linked list
        linkedList.removeFirst();

        // Menghapus elemen di indeks tertentu
        linkedList.remove(2);
        System.out.println(linkedList);

        // Mengambil elemen di indeks tertentu
        String fruit = linkedList.get(1);
        System.out.println("Fruit at index 1: " + fruit); // Output: Fruit at index 1: Orange

        // Menghitung jumlah elemen dalam linked list
        int size = linkedList.size();
        System.out.println("Size of linked list: " + size); // Output: Size of linked list: 3

        // Menampilkan semua elemen dalam linked list menggunakan perulangan for-each
        System.out.println("Linked list elements:");
        for (String item : linkedList) {
            System.out.println(item);
        }
	}

}

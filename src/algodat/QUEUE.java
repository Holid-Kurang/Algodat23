package algodat;
import java.util.LinkedList;
import java.util.Queue;

public class QUEUE {

	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<>();

        // Menambahkan elemen ke akhir queue menggunakan offer()
        queue.offer("Alice");
        queue.offer("Bob");
        queue.offer("Charlie");
        System.out.println(queue);
        // Mengambil dan menghapus elemen dari awal queue menggunakan poll()
        String dequeuedElement = queue.poll();
        System.out.println("Dequeued element: " + dequeuedElement); // Output: Dequeued element: Alice
        System.out.println(queue);

        // Melihat elemen di awal queue tanpa menghapusnya menggunakan peek()
        String frontElement = queue.peek();
        System.out.println("Front element: " + frontElement); // Output: Front element: Bob

        // Memeriksa apakah queue kosong menggunakan isEmpty()
        boolean isEmpty = queue.isEmpty();
        System.out.println("Is queue empty? " + isEmpty); // Output: Is queue empty? false

        // Menghitung jumlah elemen dalam queue menggunakan size()
        int size = queue.size();
        System.out.println("Size of queue: " + size); // Output: Size of queue: 2
	}

}

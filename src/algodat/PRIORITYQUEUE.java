package algodat;
import java.util.Collections;
import java.util.PriorityQueue;

public class PRIORITYQUEUE {

	public static void main(String[] args) {
		// Membuat PriorityQueue dengan tipe Integer (Prioritas terendah ke teratas)
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        // Menambahkan elemen ke PriorityQueue
        priorityQueue.offer(123);
        priorityQueue.offer(321);
        priorityQueue.offer(1);
        priorityQueue.offer(3);

        // Mengeluarkan elemen dengan prioritas tertinggi
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll()); // Output: 10, 20, 30, 40
        }
	}

}

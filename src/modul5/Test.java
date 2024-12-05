// void dijkstra(String start, String finish) {
//     int totalKota = kotaList.size();
//     int[] jarak = new int[totalKota];
//     boolean[] visited = new boolean[totalKota];
//     int[] prev = new int[totalKota];

//     for (int i = 0; i < totalKota; i++) {
//         jarak[i] = Integer.MAX_VALUE;
//         visited[i] = false;
//         prev[i] = -1;
//     }

//     jarak[getIndex(start)] = 0;

//     for (int i = 0; i < totalKota - 1; i++) {
//         int minJarak = Integer.MAX_VALUE;
//         int minIndex = -1;

//         for (int j = 0; j < totalKota; j++) {
//             if (!visited[j] && jarak[j] <= minJarak) {
//                 minJarak = jarak[j];
//                 minIndex = j;
//             }
//         }

//         visited[minIndex] = true;

//         Kota currentKota = getKotaByIndex(minIndex);
//         Jalan currentJalan = currentKota.jalan.head;
//         while (currentJalan != null) {
//             int tujuanIndex = getIndex(currentJalan.tujuan.nama);
//             if (!visited[tujuanIndex] && jarak[minIndex] != Integer.MAX_VALUE && jarak[minIndex] + currentJalan.jarak < jarak[tujuanIndex]) {
//                 jarak[tujuanIndex] = jarak[minIndex] + currentJalan.jarak;
//                 prev[tujuanIndex] = minIndex;
//             }
//             currentJalan = currentJalan.next;
//         }
//     }

//     System.out.println(
//             "Jarak terdekat dari " + start + " ke " + finish + " adalah " + jarak[getIndex(finish)]);

//     int index = getIndex(finish);
//     ListKota shortestPath = new ListKota();
//     while (index != -1) {
//         shortestPath.addFirst(getKotaByIndex(index).nama);
//         index = prev[index];
//     }
//     while (shortestPath.head != null) {
//         System.out.print(shortestPath.head.nama);
//         if (shortestPath.head.next != null) {
//             System.out.print(" => ");
//         }
//         shortestPath.head = shortestPath.head.next;
//     }
// }

// void dijkstra(String start) {
//     int totalKota = kotaList.size();
//     int[] jarak = new int[totalKota];
//     boolean[] visited = new boolean[totalKota];
//     int[] prev = new int[totalKota];

//     for (int i = 0; i < totalKota; i++) {
//         jarak[i] = Integer.MAX_VALUE;
//         visited[i] = false;
//         prev[i] = -1;
//     }

//     jarak[getIndex(start)] = 0;

//     for (int i = 0; i < totalKota - 1; i++) {
//         int minJarak = Integer.MAX_VALUE;
//         int minIndex = -1;

//         for (int j = 0; j < totalKota; j++) {
//             if (!visited[j] && jarak[j] <= minJarak) {
//                 minJarak = jarak[j];
//                 minIndex = j;
//             }
//         }

//         visited[minIndex] = true;

//         Kota currentKota = getKotaByIndex(minIndex);
//         Jalan currentJalan = currentKota.jalan.head;
//         while (currentJalan != null) {
//             int tujuanIndex = getIndex(currentJalan.tujuan.nama);
//             if (!visited[tujuanIndex] && jarak[minIndex] != Integer.MAX_VALUE && jarak[minIndex] + currentJalan.jarak < jarak[tujuanIndex]) {
//                 jarak[tujuanIndex] = jarak[minIndex] + currentJalan.jarak;
//                 prev[tujuanIndex] = minIndex;
//             }
//             currentJalan = currentJalan.next;
//         }
//     }

//     System.out.println("Jarak terdekat dari " + start + " ke semua kota:");
//     for (int i = 0; i < totalKota; i++) {
//         System.out.println("Jarak dari " + start + " ke " + getKotaByIndex(i).nama + " adalah " + jarak[i]);
//     }
// }
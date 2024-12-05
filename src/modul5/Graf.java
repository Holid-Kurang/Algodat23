package modul5;

public class Graf {

    ListKota kotaList;

    Graf() {
        kotaList = new ListKota();
    }

    void addKota(String nama) {
        if (!kotaList.hasKota(nama)) {
            kotaList.addLast(nama);
        }
    }

    void addEdge(String from, String to, int weight) {
        if (!kotaList.hasKota(from)) {
            addKota(from);
        }
        if (!kotaList.hasKota(to)) {
            addKota(to);
        }

        Kota fromKota = getKota(from);
        Kota toKota = getKota(to);

        fromKota.addTetangga(fromKota, toKota, weight);
        toKota.addTetangga(toKota, fromKota, weight);
    }

    void delEdge(String asal, String tujuan, int jarak) {
        Kota currentKota = kotaList.head;
        while (currentKota != null) {
            Jalan currentJalan = currentKota.jalan.head;
            while (currentJalan != null) {
                if (currentJalan.asal.nama.equals(asal) && currentJalan.tujuan.nama.equals(tujuan)
                        && currentJalan.jarak == jarak) {
                    currentKota.jalan.del(asal, tujuan, jarak);
                    delEdge(tujuan, asal, jarak);
                    return;
                }
                currentJalan = currentJalan.next;
            }
            currentKota = currentKota.next;
        }
    }

    Kota getKota(String nama) {
        Kota current = kotaList.head;
        while (current != null) {
            if (current.nama == nama) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    Kota getKotaByIndex(int index) {
        Kota current = kotaList.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    int getIndex(String nama) {
        Kota current = kotaList.head;
        int index = 0;
        while (current != null) {
            if (current.nama.equals(nama)) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1; // Return -1 if not found
    }

    void printGraph() {
        Kota currentKota = kotaList.head;
        while (currentKota != null) {
            System.out.print("Kota " + currentKota.nama + " terhubung ke: ");
            Jalan currentJalan = currentKota.jalan.head;
            while (currentJalan != null) {
                System.out.print(currentJalan.tujuan.nama + " (Jarak: " + currentJalan.jarak + ") ");
                currentJalan = currentJalan.next;
            }
            System.out.println();
            currentKota = currentKota.next;
        }
    }

    void primMST(String start) {
        int totalKota = kotaList.size();
        boolean[] visited = new boolean[totalKota];
        ListKotaNode kotaInMST = new ListKotaNode();
        ListJalan MST = new ListJalan();

        // titik awal
        Kota startKota = getKota(start);
        kotaInMST.addLast(startKota);
        visited[getIndex(startKota.nama)] = true;

        while (kotaInMST.size() < totalKota) {
            int minJarak = Integer.MAX_VALUE;
            Jalan selectedJalan = null;

            KotaNode currentMST = kotaInMST.head;
            while (currentMST != null) {
                Jalan currentJalan = currentMST.kota.jalan.head;

                while (currentJalan != null) {
                    Kota tujuan = currentJalan.tujuan;

                    if (!visited[getIndex(tujuan.nama)] && currentJalan.jarak < minJarak) {
                        minJarak = currentJalan.jarak;
                        selectedJalan = currentJalan;
                    }
                    currentJalan = currentJalan.next;
                }

                currentMST = currentMST.next;
            }

            MST.addLast(selectedJalan.asal, selectedJalan.tujuan, selectedJalan.jarak);
            kotaInMST.addLast(selectedJalan.tujuan);
            visited[getIndex(selectedJalan.tujuan.nama)] = true;
        }
        System.out.println("Prim Minimum Spanning Tree:");
        MST.print();

        Jalan currentMST = MST.head;
        Graf minTraversal = new Graf();
        while (currentMST != null) {
            minTraversal.addEdge(currentMST.asal.nama, currentMST.tujuan.nama, currentMST.jarak);
            currentMST = currentMST.next;
        }
    }

    void kruskalMST() {
        // Membuat list sementara untuk menyimpan semua jalan
        ListJalan MSTtemp = new ListJalan();
        // Membuat graf sementara untuk mengecek siklus
        Graf grafTemp = new Graf();

        // Mengiterasi semua kota dalam graf
        Kota currentKota = kotaList.head;
        while (currentKota != null) {
            // Mengiterasi semua jalan yang terhubung dengan kota saat ini
            Jalan currentJalan = currentKota.jalan.head;
            while (currentJalan != null) {
                // Jika jalan belum ada di MSTtemp, tambahkan
                if (!MSTtemp.isAlreadyExist(currentJalan.tujuan)) {
                    MSTtemp.addLast(currentJalan.asal, currentJalan.tujuan, currentJalan.jarak);
                }
                currentJalan = currentJalan.next;
            }
            currentKota = currentKota.next;
        }

        // Membuat list untuk menyimpan MST akhir
        ListJalan MST = new ListJalan();
        int totalKota = kotaList.size();
        // Loop sampai MST memiliki totalKota - 1 jalan
        while (MST.size() < totalKota - 1) {
            int minJarak = Integer.MAX_VALUE;
            Jalan selectedJalan = null;

            // Mencari jalan dengan jarak minimum yang tidak membentuk siklus
            Jalan currentMST = MSTtemp.head;
            while (currentMST != null) {
                if (minJarak > currentMST.jarak && !grafTemp.isCyclist()
                        && !MST.hasJalan(currentMST.asal, currentMST.tujuan)) {
                    minJarak = currentMST.jarak;
                    selectedJalan = currentMST;
                }
                currentMST = currentMST.next;
            }
            // Menambahkan jalan yang dipilih ke MST
            MST.addLast(selectedJalan.asal, selectedJalan.tujuan, selectedJalan.jarak);

            // Menambahkan jalan ke graf sementara untuk mengecek siklus
            grafTemp.addEdge(selectedJalan.asal.nama, selectedJalan.tujuan.nama, selectedJalan.jarak);
            // Jika menambahkan jalan tersebut membentuk siklus, hapus jalan tersebut
            if (grafTemp.isCyclist()) {
                grafTemp.delEdge(selectedJalan.asal.nama, selectedJalan.tujuan.nama, selectedJalan.jarak);
                MSTtemp.del(selectedJalan.asal.nama, selectedJalan.tujuan.nama, selectedJalan.jarak);
                MST.delLast();
            }
        }
        // Mencetak hasil MST
        System.out.println("Kruskal Minimum Spanning Tree:");
        MST.print();
        int sum = 0;
        Jalan currentMST = MST.head;
        // Menghitung total jarak dalam MST
        while (currentMST != null) {
            sum += currentMST.jarak;
            currentMST = currentMST.next;
        }
        // Mencetak total jarak
        System.out.println("Dengan Total: " + sum);
    }

    boolean isCyclist() {
        boolean[] visited = new boolean[kotaList.size()];

        // Cek untuk setiap kota yang belum dikunjungi
        for (int i = 0; i < kotaList.size(); i++) {
            if (!visited[i]) {
                if (isCyclistUtil(getKotaByIndex(i), -1, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isCyclistUtil(Kota kota, int parent, boolean[] visited) {
        visited[getIndex(kota.nama)] = true;

        Jalan currentJalan = kota.jalan.head;
        while (currentJalan != null) {
            Kota tetangga = currentJalan.tujuan;
            int tetanggaIndex = getIndex(tetangga.nama);

            if (!visited[tetanggaIndex]) {
                if (isCyclistUtil(tetangga, getIndex(kota.nama), visited)) {
                    return true;
                }
            } else if (tetanggaIndex != parent) {
                return true;
            }

            currentJalan = currentJalan.next;
        }

        return false;
    }

    void minimumTraversal(String start) {
        Kota startKota = getKota(start);

        if (startKota == null) {
            System.out.println("Lokasi Tidak Ditemukan");
            return;
        }

        System.out.print(start);
        ListKotaNode visited = new ListKotaNode();
        minimumTraversalUtil(startKota, visited);
    }

    private void minimumTraversalUtil(Kota currentKota, ListKotaNode visited) {
        visited.addLast(currentKota);
        Jalan minJalan = null;
        int minJarak = Integer.MAX_VALUE;

        Jalan currentJalan = currentKota.jalan.head;
        while (currentJalan != null) {
            if (!visited.hasKota(currentJalan.tujuan.nama) && currentJalan.jarak <= minJarak) {
                minJalan = currentJalan;
                minJarak = currentJalan.jarak;
            }
            currentJalan = currentJalan.next;
        }

        if (minJalan != null) {
            System.out.print(" => " + minJalan.tujuan.nama);
            minimumTraversalUtil(minJalan.tujuan, visited);
        } else {
            KotaNode temp = visited.tail.prev;
            while (temp != null) {
                minJalan = null;
                minJarak = Integer.MAX_VALUE;

                currentJalan = temp.kota.jalan.head;
                while (currentJalan != null) {
                    if (!visited.hasKota(currentJalan.tujuan.nama) && currentJalan.jarak <= minJarak) {
                        minJalan = currentJalan;
                        minJarak = currentJalan.jarak;
                    }
                    currentJalan = currentJalan.next;
                }
                if (minJalan != null) {
                    System.out.print(" => " + minJalan.tujuan.nama);
                    minimumTraversalUtil(minJalan.tujuan, visited);
                    return;
                }
                temp = temp.prev;
            }
        }
    }

    void maximumTraversal(String start) {
        Kota startKota = getKota(start);

        if (startKota == null) {
            System.out.println("Lokasi Tidak Ditemukan");
            return;
        }

        System.out.print(start);
        ListKotaNode visited = new ListKotaNode();
        maximumTraversalUtil(startKota, visited);
    }

    private void maximumTraversalUtil(Kota currentKota, ListKotaNode visited) {
        visited.addLast(currentKota);
        Jalan maxJalan = null;
        int maxJarak = Integer.MIN_VALUE;

        Jalan currentJalan = currentKota.jalan.head;
        while (currentJalan != null) {
            if (!visited.hasKota(currentJalan.tujuan.nama) && currentJalan.jarak >= maxJarak) {
                maxJalan = currentJalan;
                maxJarak = currentJalan.jarak;
            }
            currentJalan = currentJalan.next;
        }

        if (maxJalan != null) {
            System.out.print(" => " + maxJalan.tujuan.nama);
            maximumTraversalUtil(maxJalan.tujuan, visited);
        } else {
            KotaNode temp = visited.tail.prev;
            while (temp != null) {
                maxJalan = null;
                maxJarak = Integer.MIN_VALUE;

                currentJalan = temp.kota.jalan.head;
                while (currentJalan != null) {
                    if (!visited.hasKota(currentJalan.tujuan.nama) && currentJalan.jarak >= maxJarak) {
                        maxJalan = currentJalan;
                        maxJarak = currentJalan.jarak;
                    }
                    currentJalan = currentJalan.next;
                }
                if (maxJalan != null) {
                    System.out.print(" => " + maxJalan.tujuan.nama);
                    maximumTraversalUtil(maxJalan.tujuan, visited);
                    return;
                }
                temp = temp.prev;
            }
        }
    }

    void dijkstra(String start, String finish) {

        ListKotaNode allKota = new ListKotaNode();
        ListKotaNode priorityQueue = new ListKotaNode();
		ListKotaNode shortestPath = new ListKotaNode();
        // memasukkan semua kota ke dalam list
        Kota currentKota = kotaList.head;
        while (currentKota != null) {
			if (currentKota.nama.equals(start)) {
				// jika kota saat ini adalah kota awal, maka jarak diinisialisasi dengan 0
				// dan visited diinisialisasi dengan true
				allKota.addLast(currentKota, 0, true);
				priorityQueue.priorityEnqueue(currentKota, 0);
			} else {
				allKota.addLast(currentKota);
			}
			shortestPath.addLast(currentKota);
			currentKota = currentKota.next;
		}
        while (!priorityQueue.isEmpty()) {
            KotaNode minJarak = priorityQueue.dequeue();
            allKota.findKota(minJarak.kota.nama).visited = true;

            Jalan currentJalan = minJarak.kota.jalan.head;
            while (currentJalan != null) {
                Kota tetanggaTujuan = currentJalan.tujuan;
                if (!allKota.findKota(tetanggaTujuan.nama).visited) {
                    int jarakBaru = minJarak.jarak + currentJalan.jarak;
                    if (jarakBaru < allKota.findKota(tetanggaTujuan.nama).jarak) {
                        allKota.findKota(tetanggaTujuan.nama).jarak = jarakBaru;
                        priorityQueue.priorityEnqueue(tetanggaTujuan, jarakBaru);
						shortestPath.findKota(tetanggaTujuan.nama).path = minJarak.kota;
                    }
                }
                currentJalan = currentJalan.next;
            }
        }

		// mencetak jalur dari start ke finish dan total
		System.out.println("Jarak terdekat dari " + start + " ke " + finish + " adalah " + allKota.findKota(finish).jarak);
		System.out.print("Dengan Rute: ");
		KotaNode currentKotaNode = shortestPath.findKota(finish);
		ListKotaNode reversePath = new ListKotaNode();
		while (currentKotaNode != null) {
			if (currentKotaNode.path != null) {
				reversePath.addFirst(currentKota);
				currentKotaNode = shortestPath.findKota(currentKotaNode.path.nama);
			}else {
				System.out.println();
				currentKotaNode = null;
				
			}
		}

		while (!reversePath.isEmpty()) {
			System.out.print(reversePath.dequeue().kota.nama);
			if (!reversePath.isEmpty()) {
				System.out.print(" => ");
			}
		}
    }

    void DFS(String start) {
        Kota startKota = getKota(start);
        int size = kotaList.size();
        boolean[] visited = new boolean[size];

        DFSUtil(startKota, visited);
    }

    void DFSUtil(Kota kota, boolean[] visited) {
        System.out.print(kota.nama + " ");
        visited[getIndex(kota.nama)] = true;

        Jalan currentJalan = kota.jalan.head;
        while (currentJalan != null) {
            Kota tetangga = currentJalan.tujuan;
            int index = getIndex(tetangga.nama);
            if (!visited[index]) {
                DFSUtil(tetangga, visited); // Rekursif untuk kota tetangga yang belum dikunjungi
            }
            currentJalan = currentJalan.next;
        }
    }

    void BFS(String start) {
        Kota startKota = getKota(start);
        int size = kotaList.size();
        boolean[] visited = new boolean[size];
        // Queue<Kota> queue = new LinkedList<>();
        ListKotaNode queue = new ListKotaNode();

        // Tandai kota awal sebagai sudah dikunjungi dan tambahkan ke dalam queue
        visited[getIndex(start)] = true;
        queue.enqueue(startKota);

        while (!queue.isEmpty()) {
            // Keluarkan kota dari queue dan tampilkan namanya
            Kota current = queue.dequeue().kota;
            System.out.print(current.nama + " ");

            // Dapatkan semua tetangga dari kota saat ini
            Jalan currentJalan = current.jalan.head;
            while (currentJalan != null) {
                Kota tetangga = currentJalan.tujuan;
                int index = getIndex(tetangga.nama);

                // Jika tetangga belum dikunjungi, tandai sebagai sudah dikunjungi dan tambahkan
                // ke dalam queue
                if (!visited[index]) {
                    visited[index] = true;
                    queue.enqueue(tetangga);
                }
                currentJalan = currentJalan.next;
            }
        }
    }

}

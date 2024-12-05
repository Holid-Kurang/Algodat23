package modul4;

public class ListEarth {
	// Atribut pertama adalah Earth earth, yang merupakan objek dari kelas Earth.
	// Atribut ini menyimpan referensi ke objek Earth yang terkait dengan simpul
	// tertentu dalam struktur pohon.
	Earth earth;

	// atribut ListEarth next, yang juga merupakan objek dari kelas ListEarth.
	// Atribut next ini menunjukkan ke simpul (node) berikutnya dalam sebuah daftar
	// yang terhubung
	ListEarth next;

	// konstruktor ListEarth yang mengambil parameter Earth earth. Ketika objek
	// ListEarth dibuat, konstruktor ini akan menginisialisasi nilai atribut earth
	// dari objek ListEarth yang sedang dibuat dengan nilai yang diterima dari
	// parameter konstruktor.
	ListEarth(Earth earth) {
		this.earth = earth;
	}

}
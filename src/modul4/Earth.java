package modul4;

public class Earth {
	String universe;
	ListHero earthHero;
	
	Earth parent;
	Earth left;
	Earth right;

	Earth(String universe) {
		this.universe = universe;
	}
	Earth(String universe, Earth parent) {
		this.universe = universe;
		this.parent=parent;
	}
}

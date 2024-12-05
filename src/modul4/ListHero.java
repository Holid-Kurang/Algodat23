package modul4;

public class ListHero {
	Hero head, tail;

	void addLast(String hero, int power) {
		Hero newHero = new Hero(hero, power);

		if (head == null) {
			tail = newHero;
			head = tail;
		} else {
			tail.next = newHero;
			tail = newHero;
		}
	}

	void delLast() {
		if (head != null) {
			Hero current = head;
			while (current.next != tail) {
				current = current.next;
			}
			tail = current;
			tail.next = null;
		} else {
			return;
		}
	}

	int totalPower() {
		Hero current = head;
		int total = 0;
		while (current != null) {
			total += current.power;
			current = current.next;
		}
		return total;
	}

	Hero searchStrongest() {
		Hero current = head;
		int power = 0;
		while (current != null) {
			if (current.power > power) {
				power = current.power;
			}
			current = current.next;
		}
		current = head;
		while (current != null) {
			if (current.power == power) {
				return current;
			}
			current = current.next;
		}
		return null;
	}
}

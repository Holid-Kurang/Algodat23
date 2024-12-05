package algodat;

public class SORTING {
	public static void mergeSort(int[]array) {
		
		if(array.length<=1) return;
		
		int middle=array.length/2;
		int[] leftArray = new int[middle];
		int[] rightArray = new int[array.length - middle];
		
		for(int i=0, j=0; i<array.length; i++) {
			if(i<middle) {
				leftArray[i] = array[i];
			}else {
				rightArray[j] = array[i];
				j++;
			}
		}
		mergeSort(leftArray);
		mergeSort(rightArray);
		merge(leftArray, rightArray, array);
	}
	public static void merge(int[] leftArray, int[] rightArray, int[] array) {
		int leftSize = array.length/2;
		int rightSize = array.length - leftSize;
		int i=0, l=0, r=0;

		while(l<leftSize && r<rightSize) {
			if(leftArray[l] < rightArray[r]) {
				array[i] = leftArray[l];
				l++;
			}else {
				array[i] = rightArray[r];
				r++;
			}
			i++; 
		}
		while(l<leftSize||r<rightSize) {
			if(l<leftSize) {
				array[i] = leftArray[l];
				i++; 
				l++;
			}else if(r<rightSize) {
				array[i] = rightArray[r];
				i++; 
				r++;
			}
		}
	}
	
	public static void main(String[] args) {
		int array[]= {8,2,5,3,4,7,6,1};
		mergeSort(array);
		for(int i =0 ; i<array.length; i++) {
			System.out.print(array[i]+ " ");
		}
	}

}
//class Nodesss {
//    int data;
//    Nodesss prev, next;
//
//    Nodesss(int data) {
//        this.data = data;
//        prev = next = null;
//    }
//}
//
//public class SORTING {
//    Nodesss head;
//
//    public void addNodesss(int data) {
//        Nodesss newNodesss = new Nodesss(data);
//        if (head == null) {
//            head = newNodesss;
//            return;
//        }
//
//        Nodesss last = head;
//        while (last.next != null) {
//            last = last.next;
//        }
//        last.next = newNodesss;
//        newNodesss.prev = last;
//    }
//
//    public Nodesss getMiddle(Nodesss head) {
//        if (head == null)
//            return head;
//
//        Nodesss slow = head, fast = head;
//        while (fast.next != null && fast.next.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return slow;
//    }
//
//    public Nodesss merge(Nodesss left, Nodesss right) {
//        Nodesss result = null;
//        if (left == null)
//            return right;
//        if (right == null)
//            return left;
//
//        if (left.data <= right.data) {
//            result = left;
//            result.next = merge(left.next, right);
//            result.next.prev = result;
//        } else {
//            result = right;
//            result.next = merge(left, right.next);
//            result.next.prev = result;
//        }
//        return result;
//    }
//
//    public Nodesss mergeSort(Nodesss head) {
//        if (head == null || head.next == null)
//            return head;
//
//        Nodesss middle = getMiddle(head);
//        Nodesss nextMiddle = middle.next;
//        middle.next = null;
//
//        Nodesss left = mergeSort(head);
//        Nodesss right = mergeSort(nextMiddle);
//
//        return merge(left, right);
//    }
//
//    public void printList(Nodesss node) {
//        while (node != null) {
//        	System.out.println(node);
//            System.out.println(node.data + " ");
//            node = node.next;
//        }
//    }
//
//    public static void main(String[] args) {
//    	SORTING list = new SORTING();
//        list.addNodesss(8);
//        list.addNodesss(2);
//        list.addNodesss(5);
//        list.addNodesss(3);
//        list.addNodesss(4);
//        list.addNodesss(7);
//        list.addNodesss(6);
//        list.addNodesss(1);
//
//        System.out.println("Original linked list:");
//        list.printList(list.head);
//
//        list.head = list.mergeSort(list.head);
//        System.out.println("\nSorted linked list:");
//        list.printList(list.head);
//    }
//}


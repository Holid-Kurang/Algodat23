package algodat;
import java.util.LinkedList;
//import java.util.Stack;
public class STACK {

	public static void main(String[] args) {
		// stack = LIFO data structure. Last-In First-Out
		//               stores objects into a sort of "vertical tower"
		//		  push() to add objects to the top
		//		  pop() to remove objects from the top
				
		// uses of stacks?
		// 1. undo/redo features in text editors
		// 2. moving back/forward through browser history
		// 3. backtracking algorithms (maze, file directories)
		// 4. calling functions (call stack)
		LinkedList<String> stack = new LinkedList<String>();
		
		System.out.println(stack.isEmpty());		
		stack.push("Minecraft");
		stack.push("Skyrim");
		stack.push("DOOM");
		stack.push("Borderlands");
		stack.push("FFVII");
		System.out.println(stack.isEmpty());
		
//		String myFavGame = stack.pop();
		System.out.println(stack.peek());	
//		System.out.println(stack.search("Fallout76"));
		System.out.println(stack);
	}

}

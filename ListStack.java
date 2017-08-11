import java.util.*;

public class ListStack<T> {

	public ArrayList<T> stackList;

	public int top = 0;

	public ListStack() {
		stackList = new ArrayList<T>();
	}

	public void add(T data) {
		stackList.add(data);
		this.top++;
	}

	public T pop() {
		T item = stackList.remove(top - 1);
		this.top--;
		return item;
	}

	public void peek() {
		System.out.println(stackList.get(top - 1));
	}

	public static void main(String[] args) {
		// System.out.println("Works");
		ListStack<Integer> stack = new ListStack<Integer>();
		stack.add(1);
		stack.add(2);
		stack.peek();
		stack.pop();
		stack.peek();


	}
	



}
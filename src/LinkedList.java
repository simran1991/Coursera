
public class LinkedList1 {

	private static int counter = 0;
	private Node head;

	public void add(Object data) {
		if (head == null) {
			head = new Node(data);
		} 
			Node currentNode = head;
			Node tempNode = new Node(data);
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(tempNode);
		
		incrementCounter();
	}

	public void add(Object data, int index) {
		Node curentNode = head;
		Node tempNode = new Node(data);
		if (curentNode != null) {
			for (int i = 0; i < index && curentNode.getNext() != null; i++) {
				curentNode = curentNode.getNext();
			}
			tempNode.setNext(curentNode.getNext());
			curentNode.setNext(tempNode);
			incrementCounter();
		}
	}

	public Object getObject(int index) {
		Node currentNode = head;
		for (int i = 0; i <= index; i++) {
			if (currentNode.getNext() == null)
				return null;
			currentNode = currentNode.getNext();
		}
		return currentNode.getData();

	}

	public boolean remove(int index) {
		Node currentNode = head;
		if (currentNode != null) {
			for (int i = 0; i < index; i++) {
				if (currentNode.getNext() == null)
					return false;
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(currentNode.getNext().getNext());
			decrementCounter();
			return true;
		}
		return false;
	}

	public int size() {
		return getCounter();
	}

	public String toString() {
		String output = "";

		if (head != null) {
			Node currentNode = head.getNext();
			while (currentNode != null) {
				output += "[" + currentNode.getData().toString() + "]";
				currentNode = currentNode.getNext();
			}

		}
		return output;
	}

	public void incrementCounter() {
		setCounter(getCounter() + 1);
	}

	public void decrementCounter() {
		setCounter(getCounter() - 1);
	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		LinkedList.counter = counter;
	}
	
	public static void main(String[] args) {
		 
		// Default constructor - let's put "0" into head element.
		LinkedList linkedList = new LinkedList();
 
		// add more elements to LinkedList
		linkedList.add("1");
		linkedList.add("2");
		linkedList.add("3");
		linkedList.add("4");
		linkedList.add("5");
 
		
		System.out.println("Print: linkedList: \t\t" + linkedList);
		System.out.println(".size(): \t\t\t\t" + linkedList.size());
		System.out.println(".get(3): \t\t\t\t" + linkedList.getObject(3) + " (get element at index:3 - list starts from 0)");
		System.out.println(".remove(2): \t\t\t\t" + linkedList.remove(2) + " (element removed)");
		System.out.println(".get(3): \t\t\t\t" + linkedList.getObject(4) + " (get element at index:3 - list starts from 0)");
		System.out.println(".size(): \t\t\t\t" + linkedList.size());
		System.out.println("Print again: linkedList: \t" + linkedList);
	}
}

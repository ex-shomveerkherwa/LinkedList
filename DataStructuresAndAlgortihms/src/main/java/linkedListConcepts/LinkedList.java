package linkedListConcepts;

import java.util.Scanner;

public class LinkedList {
	
	static LinkNode head = null;
	static int count ;
	static Scanner reader = new Scanner(System.in);
	
	public static void main(String[] args){
		boolean choice = true;
		do{
			switch(showOptions()) {
			case 1 :	Display();
						break;
			case 2 : 	Insert();
						break;
			case 3 : 	ListHelper.PopulateList();
						break;
			case 4 :	ListHelper.reverseList();
						break;
			case 5 :	ListHelper.reverseTillPosition();
						break;
			default:	System.out.println("Select a valid input");
			}
			System.out.println("Wish to continue ? 1/0");
			choice = reader.nextInt() == 1 ? true : false ;
		}while(choice);
		System.out.println("Ta:Ta");
	}

	private static int showOptions() {
		System.out.println("LinkedList Options");
		System.out.println(" 1\t Display List\n 2\t Insert into List\n 3\t Populate List\n 4\t Reverse the List\n 0\t Quit\n");
		System.out.println("5\t Reverse the list from a given position\n");
		System.out.println("Select an option");
		
		return reader.nextInt();
	}
	
	private static void Insert() {
		System.out.println("Enter the number to insert");
		int inputNumber = reader.nextInt();
		LinkNode inputNode = new LinkNode(inputNumber);
		
		System.out.println("Enter the position where the element has be inserted in the list of size "+count);
		int position = reader.nextInt();
		
		LinkNode traverseNode = head ;  //taking a reference node to travese the list
		
		if(count == 0){
			head = inputNode;
			inputNode.setNeighbour(null);
			count++;
			return;
		}
		if(position < 0 || position > count) {	//Adding element at last of the list
			System.out.println("Adding the element at last ");
			while(true) {
				if(traverseNode.getNeighbour() != null){
					traverseNode = traverseNode.getNeighbour();
					continue;
				}
				else {
					traverseNode.setNeighbour(inputNode);
					inputNode.setNeighbour(null);
					break;
				}
			}
			count++;
			return;
		}
		if( position == 1) {
			inputNode.setNeighbour(head);
			head = inputNode;
			count++;
			return;
		}
		else{
			int loopCount = 1 ;	//To keep track of current position in the loop
			while(true){
				if(traverseNode.getNeighbour() != null && loopCount < position    ) {
					traverseNode = traverseNode.getNeighbour();
					loopCount++;
					continue;
				}
				inputNode.setNeighbour(traverseNode.getNeighbour());
				traverseNode.setNeighbour(inputNode);
				break;
			}
			count++;
			return;
		}
		
	}


	//Method to generate all the contents of the list
	private static void Display() {
		LinkNode currentNode = head;
		while(currentNode != null) {
			System.out.print(currentNode.getData() +"\t-->");
			currentNode = currentNode.getNeighbour();
		}
		System.out.println("\nDone displaying all the "+count+" results");
	}
}

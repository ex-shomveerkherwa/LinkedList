package linkedListConcepts;

public class ListHelper {
	
	public static void PopulateList() {
		int[] randomInput ={5,8,3,9,2};
		for(int inputNumber : randomInput){
			LinkNode currentNode = new LinkNode(inputNumber);
			currentNode.setNeighbour(null);
			if(LinkedList.head == null){
				LinkedList.head = currentNode;
			}
			else {
				LinkNode traverseNode = LinkedList.head;
				while(true) {
					if(traverseNode.getNeighbour() != null) {
						traverseNode = traverseNode.getNeighbour();
						continue;
					}
					else
						break;
				}
				traverseNode.setNeighbour(currentNode);
			}
			LinkedList.count++;
		}
	}
	
	public static void reverseList(){
		if(LinkedList.head == null) {
			System.out.println("List id empty , nothing to reverse");
			return;
		}
		else{
			LinkNode currentNode = LinkedList.head;
			LinkNode nextNode = null;
			LinkNode previousNode = null;
			
			while(true){
				if(currentNode.getNeighbour() != null){
					nextNode = currentNode.getNeighbour();
					currentNode.setNeighbour(previousNode);
					previousNode = currentNode;
					currentNode = nextNode;
					continue;
				}
				else {
					LinkedList.head = currentNode;
					currentNode.setNeighbour(previousNode);
					break;
				}
			}
			System.out.println("Done reversing");
		}
		return;
	}
	
	public static void reverseTillPosition(){
		System.out.println("Enter a position leass than "+LinkedList.count+" from which the list should be reversed");
		int position = LinkedList.reader.nextInt();
		
		if(position > LinkedList.count){
			System.out.println("return bcoz of invalid input");
			return;
		}
		LinkNode currentNode = LinkedList.head;
		int loopCount = 1;
		LinkNode previousNode = null;
		LinkNode nextNode = null;
		
		while(true){
			if(currentNode.getNeighbour() != null && loopCount < position) {
				nextNode = currentNode.getNeighbour();
				currentNode.setNeighbour(previousNode);
				previousNode = currentNode;
				currentNode = nextNode;
				loopCount++;
				continue;
			} else {
				LinkedList.head.setNeighbour(currentNode.getNeighbour());
				LinkedList.head = currentNode;
				currentNode.setNeighbour(previousNode);
				break;
			}
		}
		return;
	}
}

package semThree_assignment;

public class SinglyLinkedList {
	 public static class Node{
		 	Node next;
	        int data;
	        Node(int data){
	            this.data= data;
	            this.next= null;

	        }
	    }

	    Node head= null;
	    Node tail= null;
	    int size = 0;
	public void addNode(int data){
		size++;
	    Node newnode = new Node(data);
	    if(head == null){
	        head = tail= newnode;
	    }

	    else{
	        tail.next = newnode; // for head: newnode.next = head; head = newnode;
	        tail = newnode;
	    }
	}
	public int getSize() {
		return size;
	}
	
	public int getDataAtAnyPos(int pos) {
		Node current = head;
		for(int i=1; i<=pos; i++) {
			current = current.next;
		}
		return current.data;
	}
	
	public static void main(String [] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.addNode(10);
		list.addNode(20);
		System.out.println(list.getDataAtAnyPos(1));
		
	}
}

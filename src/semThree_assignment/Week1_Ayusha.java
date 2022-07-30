package semThree_assignment;

import semThree_assignment.SinglyLinkedList.Node;

public class Week1_Ayusha {

	SinglyLinkedList[] arr;

    Week1_Ayusha(SinglyLinkedList[] arr) {
        this.arr = arr;
    }

    SinglyLinkedList MergeAll() {
        // This function itterates through all the linked lists and merges them into one
        // linked list.
        SinglyLinkedList resultedList = arr[0];
        
        SinglyLinkedList mergedList; // This linked list is used to store the two merged linked list.
        
        for (int i = 1; i < arr.length; i++) {
        	
        	// Merge the current linked list with the final output list.
            mergedList = Merge(resultedList, arr[i]);
            resultedList = mergedList;
        }
        return resultedList;
    }

    SinglyLinkedList Merge(SinglyLinkedList arrayA, SinglyLinkedList arrayB) {
       
        SinglyLinkedList output = new SinglyLinkedList();
        Node first_iteration = arrayA.head;
        Node second_iteration = arrayB.head;
        
        while (first_iteration != null) {
            // itterate through the first linked list.
            output.addNode(first_iteration.data);
            first_iteration = first_iteration.next;
        }
        while (second_iteration != null) {
            // itterate through the second linked list.
            output.addNode(second_iteration.data);
            second_iteration = second_iteration.next; 
        }
        return sortedLL(output);
    }

    SinglyLinkedList sortedLL(SinglyLinkedList list) {
        // Node current will point to head
        Node temp = list.head, 
        index = null; 
        int current; 

        if (list.head == null) {
            return null;
        } else {
            while (temp != null) {
                // Node index will point to node next to current
                index = temp.next;

                while (index != null) {
                    // If current node's data is greater than index's node data, swap the data
                    // between them
                    if (temp.data > index.data) {
                        current = temp.data;
                        temp.data = index.data;
                        index.data = current;
                    }
                    index = index.next;
                }
                temp = temp.next;
            }
        }
        return list;
    }

    void Median() {
        int median = (MergeAll().getSize() + 1) / 2; 
        // Get the median of the linked list.
        System.out.println("Median is : " + MergeAll().getDataAtAnyPos(median));
    }
    
    
// Driver Class
    public static void main(String[] args) {
        //creating 3 linked lists
        SinglyLinkedList[] arr = new SinglyLinkedList[3];
        SinglyLinkedList L1 = new SinglyLinkedList();
        SinglyLinkedList L2 = new SinglyLinkedList();
        SinglyLinkedList L3 = new SinglyLinkedList();

        //adding nodes to the linked lists
        L1.addNode(2);
        L1.addNode(4);
        L1.addNode(7);
        L1.addNode(5);
        L1.addNode(10);
        L2.addNode(3);
        L2.addNode(2);
        L2.addNode(7);
        L2.addNode(9);
        L3.addNode(12);
        L3.addNode(5);
        L3.addNode(6);
        L3.addNode(9);
        
        //passing the linked lists as arrays
        arr[0] = L1;
        arr[1] = L2;
        arr[2] = L3;
        
        Week1_Ayusha assignment = new Week1_Ayusha(arr);
        assignment.Median();
        
    }
}

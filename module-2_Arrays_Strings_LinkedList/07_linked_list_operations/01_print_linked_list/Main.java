class Node {
    int data;
    Node next;
    Node(int x) {
        data = x;
        next = null;
    }
}

class Solution {
    // Function to display the elements of a linked list in same line
    void printList(Node head) {
        // add code here.
        Node t = head;
        while(t != null) {
            System.out.print(t.data + " ");
            t = t.next;
        }
    }
}
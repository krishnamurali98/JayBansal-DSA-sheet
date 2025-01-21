class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}
class Solution {
    int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode p1 = head1;
        SinglyLinkedListNode p2 = head2;
        
        while(p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if(p1 == null)
                p1 = head2;
            if(p2 == null)
                p2 = head1;
        }
        return p1.data;
    }
}
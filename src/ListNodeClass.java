public class ListNodeClass {
    int val;
    ListNodeClass next;

    ListNodeClass(int x) {
        val = x;
    }


//1. Remove Duplicates from Sorted List
//Given a sorted linked list, delete all
// duplicates such that each element appear only once.

    public ListNodeClass deleteDuplicates1(ListNodeClass head) {
        ListNodeClass dummy = new ListNodeClass(Integer.MIN_VALUE);
        dummy.next = head;
        ListNodeClass pre = dummy;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                pre.next = head.next;
            } else {
                pre = pre.next;
            }
            head = head.next;
        }

        return dummy.next;
    }

    //2. Remove Duplicates from Sorted List II
//Given a sorted linked list, delete all NodeClasss that have duplicate numbers, leaving
//only distinct numbers from the original list
    public ListNodeClass deleteDuplicates2(ListNodeClass head) {
        ListNodeClass dummy = new ListNodeClass(0);
        dummy.next = head;
        ListNodeClass prev = dummy;
        ListNodeClass current = head;

        while (current != null) {
            boolean isDuplicate = false;
            while (current.next != null && current.val == current.next.val) {
                isDuplicate = true;
                current = current.next;
            }
            if (isDuplicate) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }
        return dummy.next;
    }
    //    3. Reverse Linked List
//    Reverse a linked list
    public ListNodeClass reverseLinkedList (ListNodeClass head){
        ListNodeClass prev = null;
        ListNodeClass current = head;
        ListNodeClass next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
}
// Problem 1 - Linked List Reverse 
 public Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node current = head;
        Node prev = null;
        Node next = current.next;

        while (next != null) {
            current.next = prev;
            prev = current;
            current = next;
            next = next.next;
        }

        current.next = prev;

        return current;
    }
}

// Time Complexity - O(listSize) - constant amount of work done for each node
// Space Complexity - O(1)  - no extra space used, only updating links of existing nodes

package org.way2it.data_structures.linked_list;

public class LinkedList {

    // Represents the first node of this list
    // Should be initialized when first value is added
    private Node head;

    // Represents the number of values that were added to this list
    private int length = 0;

    public LinkedList() {
    }

    // Should add new value to the end of the list and increment length
    public void add(String value) {
        Node node = new Node();
        Node currentNode = head;
        if (head == null){
            head = node;
            head.value=value;
        }
        else {
            while(currentNode.next != null){
                currentNode = currentNode.next;
            }
            node.value = value;
            currentNode.next = node;
        }
        length++;
        // TODO implement me
    }

    // Should add new value next to specified afterValue, increment length and return true
    // If afterValue is not present in list - do nothing and return false.
    public boolean addAfter(String value, String afterValue) {
        boolean out = false;
        if (contains(afterValue)){
            Node node = new Node();
            Node currentNode = head;
            while (!currentNode.value.equals(afterValue)) {
                currentNode = currentNode.next;
                if (currentNode.value.equals(afterValue)) {
                    node.value = value;
                    node.next = currentNode.next;
                    currentNode.next = node;
                    length++;
                    out = true;
                }
            }
        }
        // TODO implement me
        return out;
    }

    // Should return true if value exists in this list, false - otherwise
    public boolean contains(String value) {
        Node currentNode = head;
        boolean out = false;
        for(int  i = 0;  i < length; i++) {
            if (value.equals(currentNode.value)){
                out = true;
            }
            else {
                currentNode = currentNode.next;
            }
        }
        // TODO implement me
        return out;
    }

    // Should remove first occurrence of the specified value from this list and decrement the length
    // If value existed and was removed - return true, false - otherwise
    public boolean remove(String value) {
        boolean out = false;
        if (contains(value)) {
            Node currentNode = head;
            if (currentNode.value.equals(value)) {  // Если первый узел равен value
                head = currentNode.next;            // следующий узел становится головой
            }
            else {
                while (!currentNode.next.value.equals(value)) {
                    currentNode = currentNode.next;
                }
                currentNode.next = currentNode.next.next;
            }
            length--;
            out = true;
        }
        // TODO implement me
        return out;
    }

    public int getLength() {
        return length;
    }

    private static class Node {
        String value;
        Node next;
    }
}

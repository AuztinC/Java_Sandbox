package lists;

public class LinkedList implements List {
    private int size = 0;
    private Node head = null;

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    @Override
    public void add(int value) {
        Node newNode = new Node(value);
        Node current = head;
        if (head == null)
            head = newNode;
        else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    @Override
    public void add(int value, int index) {
        Node newNode = new Node(value);
        Node current = head;
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException();
        if (index == 0) {
            head = newNode;
            newNode.next = current;
        } else {
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void remove(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        if (index == 0 && head != null)
            head = head.next;
        else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    @Override
    public int get(int index) {
        Node current = head;
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        else {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        }
        return current.value;
    }

    public void BubbleSort(ArrayList list){
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = 0; j < list.size()-1; j++) {
                if(list.get(j) > list.get(j+1)){
                    int larger = list.get(j);
                    int smaller = list.get(j+1);
                    list.remove(j+1);
                    list.remove(j);
                    list.add(smaller, j);
                    list.add(larger, j+1);
                }
            }
        }
    }

}

/*24.3 (IMPLEMENT A DOUBLY LINKED LIST) 
The MyLinkedList class used in Listing 24.5 is a one-way directional linked list that enables one-way traversal of the list. 
Modify the Node class to add the new data field name previous to refer to the previous node in the list, as follows:

public class Node<E> {
    E element;
    Node<E> next;
    Node<E> previous;

    public Node(E e) {
        element = e;
    }
}
Implement a new class named TwoWayLinkedList that uses a doubly linked list to store elements. 
Define TwoWayLinkedList to implements MyList. 
You need to implement all the methods defined in MyLinkedList as well as the methods listIterator() and listIterator(int index). 
Both return an instance of java.util.ListIterator<E> (see Figure 20.4). 
The former sets the cursor to the head of the list and the latter to the element at the specified index. 
Test your new class using this code from https://liveexample.pearsoncmg.com/test/Exercise24_03.txt.*/

import java.util.ListIterator;
import java.util.NoSuchElementException;

class Node<E> {
    E element;
    Node<E> next;
    Node<E> previous;

    public Node(E e) {
        element = e;
    }
}

final class TwoWayLinkedList<E> implements MyList<E> {
    private Node<E> head, tail;
    private int size = 0;

    /** Create a default list */
    public TwoWayLinkedList() {}

    /** Create a list from an array of objects */
    public TwoWayLinkedList(E[] objects) {
        for (E e : objects) {
            addLast(e);
        }
    }

    /** Return the head element in the list */
    public E getFirst() {
        if (size == 0) {
            return null;
        }
        return head.element;
    }

    /** Return the last element in the list */
    public E getLast() {
        if (size == 0) {
            return null;
        }
        return tail.element;
    }

    /** Add an element to the beginning of the list */
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        size++;
    }

    /** Add an element to the end of the list */
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }

    /** Add a new element at the specified index in this list */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            addFirst(e);
        } else if (index == size) {
            addLast(e);
        } else {
            Node<E> newNode = new Node<>(e);
            Node<E> current = getNode(index);
            newNode.previous = current.previous;
            newNode.next = current;
            current.previous.next = newNode;
            current.previous = newNode;
            size++;
        }
    }

    /** Remove the head node and return the object that is contained in the removed node. */
    public E removeFirst() {
        if (size == 0) {
            return null;
        }
        E temp = head.element;
        head = head.next;
        if (head != null) {
            head.previous = null;
        } else {
            tail = null; // List became empty
        }
        size--;
        return temp;
    }

    /** Remove the last node and return the object that is contained in the removed node. */
    public E removeLast() {
        if (size == 0) {
            return null;
        }
        E temp = tail.element;
        tail = tail.previous;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null; // List became empty
        }
        size--;
        return temp;
    }

    /** Remove the element at the specified position in this list. Return the element that was removed from the list. */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<E> current = getNode(index);
            E temp = current.element;
            current.previous.next = current.next;
            current.next.previous = current.previous;
            size--;
            return temp;
        }
    }

    /** Get the node at a specified index */
    private Node<E> getNode(int index) {
        Node<E> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.previous;
            }
        }
        return current;
    }

    /** Return the element from this list at the specified index */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return getNode(index).element;
    }

    /** Return the index of the first matching element in this list. Return -1 if no match. */
    public int indexOf(Object e) {
        Node<E> current = head;
        for (int index = 0; index < size; index++) {
            if (current.element.equals(e)) {
                return index;
            }
            current = current.next;
        }
        return -1;
    }

    /** Return the index of the last matching element in this list. Return -1 if no match. */
    public int lastIndexOf(Object e) {
        Node<E> current = tail;
        for (int index = size - 1; index >= 0; index--) {
            if (current.element.equals(e)) {
                return index;
            }
            current = current.previous;
        }
        return -1;
    }

    /** Replace the element at the specified position in this list with the specified element. */
    public E set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> current = getNode(index);
        E oldElement = current.element;
        current.element = e;
        return oldElement;
    }

    /** Clear the list */
    public void clear() {
        head = tail = null;
        size = 0;
    }

    /** Return the size of the list */
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    public ListIterator<E> listIterator() {
        return new LinkedListIterator();
    }

    public ListIterator<E> listIterator(int index) {
        return new LinkedListIterator(index);
    }

    private class LinkedListIterator implements ListIterator<E> {
        private Node<E> current = head;
        private int currentIndex = 0;

        public LinkedListIterator() {}

        public LinkedListIterator(int index) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
            currentIndex = index;
            current = getNode(currentIndex);
        }

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E e = current.element;
            current = current.next;
            currentIndex++;
            return e;
        }

        @Override
        public boolean hasPrevious() {
            return currentIndex > 0;
        }

        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            current = (current == null) ? tail : current.previous;
            currentIndex--;
            return current.element;
        }

        @Override
        public int nextIndex() {
            return currentIndex;
        }

        @Override
        public int previousIndex() {
            return currentIndex - 1;
        }

        @Override
        public void remove() {
            if (currentIndex == 0) {
                throw new IllegalStateException();
            }
            TwoWayLinkedList.this.remove(currentIndex - 1);
            currentIndex--;
        }

        @Override
        public void set(E e) {
            if (currentIndex == 0) {
                throw new IllegalStateException();
            }
            TwoWayLinkedList.this.set(currentIndex - 1, e);
        }

        @Override
        public void add(E e) {
            TwoWayLinkedList.this.add(currentIndex, e);
            currentIndex++;
        }
    }


}

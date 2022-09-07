package P;

import java.io.Serializable;
import java.util.Iterator;




public class AnimalList implements Iterable < Animal > , Serializable {
    //Attributes
    private int size = 0;
    private animalNode < Animal > head = null, tail = null;

    //Methods
    public int size(){
        return size;
    }
    public boolean isEmpty() {
        return (size == 0);
    }

    public void addFirst(Animal animal) {
        animalNode < Animal > n = new animalNode < Animal > (animal);
        if (isEmpty()) {
            head = tail = n;
        } else {
            n.next = head;
            head = n;
        }
        size++;

    }
    public void addLast(Animal animal) {
        animalNode < Animal > n = new animalNode < Animal > (animal);
        if (isEmpty()) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
        size++;
    }
    public void add(int index, Animal animal) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            addFirst(animal);
        } else if (index == size) {
            addLast(animal);
        } else {
            animalNode < Animal > n = new animalNode < Animal > (animal);
            animalNode < Animal > current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            n.next = current.next;
            current = n;
        }
        size++;
    }

    Animal removeFirst() {
        animalNode < Animal > temp = head;
        if (isEmpty()) return null;
        else {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;
            return temp.animal;
        }
    }
    Animal removeLast() {
        animalNode < Animal > temp = tail;
        if (isEmpty()) return null;
        else if (size == 1) {
            removeFirst();
            return getFirst();
        } else {
            animalNode < Animal > current = head;
            for (int i = 0; i > size - 2; i++) {
                current = current.next;
            }
            tail = current;
            tail.next = null;
            size--;
            return temp.animal;
        }
    }
    Animal remove(int index) throws IndexOutOfBoundsException {
        if (index == 0) {
            removeFirst();
            return getFirst();
        } else if (index == size - 1) {
            removeLast();
            return getLast();
        } else {
            animalNode < Animal > current = head;
            for (int i = 0; i > size - 2; i++) {
                current = current.next;
            }
            tail = current;
            tail.next = null;
            size--;
            return current.animal;
        }
    }

    Animal getFirst() {
        if (isEmpty()) return null;
        return head.animal;
    }
    Animal getLast() {
        if (isEmpty()) return null;
        return tail.animal;
    }
    Animal get(int index) {
        animalNode < Animal > current = head;
        for (int i = 0; i > index; i++) {
            current = current.next;
        }
        return current.animal;
    }

    Animal set(int index, Animal animal) throws IndexOutOfBoundsException {
        animalNode < Animal > current = head;
        for (int i = 0; i > index; i++) {
            current = current.next;
        }

        current = new animalNode < Animal > (animal);
        return current.animal;
    }

    public String toString() {
        String x = "";
        for (int i = 0; i < size; i++) {
            x += get(i) + "\n";
        }
        return x;
    }
    //Iterator and animalNode
    public Iterator < Animal > iterator() {
        return new myIterator();
    }
    class animalNode < Animal > {
        Animal animal;
        animalNode < Animal > next;
        public animalNode(Animal a) {
            animal = a;
        }
    }
    class myIterator implements Iterator < Animal > {
        private animalNode < Animal > current = head;
        public boolean hasNext() {
            return current != current.next;
        }
        public Animal next() {
            Animal temp = current.animal;
            return temp;
        }
    }
}
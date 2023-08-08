package hashtable;

import java.util.ArrayList;

public class HashTable {
    private ArrayList<Contact> phoneBook;
    private int capacity;

    public HashTable(int capacity) {
        this.phoneBook = new ArrayList<>(capacity);
        this.capacity = capacity;
    }

    public ArrayList<Contact> getPhoneBook() {
        return phoneBook;
    }

    public void add(Contact c) {
        int index = this.generateHash(c.getName());
        if (this.phoneBook.get(index) != null) {
            System.out.println("index ocupado colision");
        } else {
            this.phoneBook.set(index, c);
        }

    }

    // TODO
    public void delete() {

    }

    public Contact getElement(String name) {
        int index = this.generateHash(name);
        return this.phoneBook.get(index);
    }

    private int generateHash(String value) {
        int sumValue = 0;
        for (int i = 0; i < value.length(); i++) {
            sumValue += value.toLowerCase().charAt(i) * i;
            // System.out.println(
            // "Para " + value.toLowerCase().charAt(i) + " ascii value: " + (int)
            // value.toLowerCase().charAt(i));
        }
        // System.out.println("suma: " + sumValue + " modulo: " + sumValue %
        // this.capacity);
        // System.out.println("size: "+this.phoneBook.size());

        return (int) sumValue % this.capacity;
    }

    public boolean validateFactor() {
        int elements = 0;
        for (int i = 0; i < this.phoneBook.size(); i++) {
            if (this.phoneBook.get(i) != null) {
                elements++;
            }
        }
        // System.out.println((1.0 * elements) / this.capacity);
        return (1.0 * elements) / this.capacity >= 0.75;
    }

    public void viewContent() {
        System.out.println("Tamaño de la agenda: " + this.phoneBook.size());
        for (int i = 0; i < this.phoneBook.size(); i++) {
            if (this.phoneBook.get(i) != null) {
                System.out.println(i + " " + this.phoneBook.get(i).getName());
            } else {
                System.out.println(i + " " + this.phoneBook.get(i));
            }
        }
    }

    public boolean isEmpty() {
        return this.phoneBook.size() == 0;
    }

    public void fill() {
        for (int i = 0; i < this.capacity; i++) {
            this.phoneBook.add(null);
        }
    }
}

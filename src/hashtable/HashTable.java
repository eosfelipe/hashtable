package hashtable;

import java.util.ArrayList;

public class HashTable {
    private ArrayList<Contact> phoneBook;
    private int capacity;


    public HashTable(int capacity){
        this.phoneBook = new ArrayList<>(capacity);
        this.capacity = capacity -1;
    }

    public ArrayList<Contact> getPhoneBook() {
        return phoneBook;
    }

    public void add(Contact c){
        int index = this.generateHash(c.getName());
        this.phoneBook.add(index,c);
    }

    //TODO
    public void delete(){

    }

    public Contact getElement(String name){
        int hashCode = this.generateHash(name);
        return this.phoneBook.get(hashCode);
    }

    private int generateHash(String value){
        int sumValue = 0;
        for(int i = 0; i < value.length(); i++){
            sumValue += value.toLowerCase().charAt(i) * i;
            //System.out.println("Para "+value.charAt(i)+" ascii value: "+(int) value.charAt(i));
        }
        //System.out.println("suma: "+sumValue+" modulo: "+sumValue%10);
        //System.out.println("size: "+this.phoneBook.size());

        return (int) sumValue % this.capacity;
    }

    public boolean validateFactor(){
        int elements = 0;
        for(int i = 0; i < this.phoneBook.size(); i++){
            if(this.phoneBook.get(i) != null){
                elements++;
            }
        }
        //System.out.println((1.0 * elements) / this.capacity);
        return (1.0 * elements) / this.capacity >= 0.75;
    }

    public void viewContent(){
        for (int i = 0; i < this.phoneBook.size(); i++) {
            if(this.phoneBook.get(i) != null){
                System.out.println(this.phoneBook.get(i).getName());
            }else {
                System.out.println(this.phoneBook.get(i));
            }
        }
    }

    public boolean isEmpty(){
        return this.phoneBook.size() == 0;
    }

    public void fill(){
        for (int i = 0; i < this.capacity; i++){
            this.phoneBook.add(null);
        }
    }
}

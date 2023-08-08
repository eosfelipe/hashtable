import hashtable.Contact;
import hashtable.HashTable;

import java.util.Scanner;

public class Main {

    public static void print(String text) {
        System.out.println(text);
    }

    public static void main(String[] args) {

        String value = "";
        Scanner in = new Scanner(System.in);
        HashTable h = new HashTable(10);
        h.fill();

        // agregar elementos de ejemplo
        h.add(new Contact("Marcos", "9999123456"));
        h.add(new Contact("Carlos", "9999123456"));
        h.add(new Contact("Felipe", "9999123456"));
        h.add(new Contact("Luiss", "9999123456"));
        h.add(new Contact("Cristina", "9999123456"));
        h.add(new Contact("Yadira", "9999123456"));
        h.add(new Contact("Lulu", "9999123456"));
        h.add(new Contact("Lule", "9999123456"));

        if (h.validateFactor()) {
            print("WARNING!!!! El factor de carga supera el 75% de la capacidad");
            h.viewContent();
        } else {
            print("OK");
            h.viewContent();
        }

        // print("*********Agenda UNIR*********");
        // print("Deseas agregar un contacto nuevo? SI(S) / NO(N)");
        // value = in.nextLine();

        // if (value.equalsIgnoreCase("s")) {
        // print("Nombre: ");
        // String name = in.nextLine();
        // print("Teléfono: ");
        // String phone = in.nextLine();
        // print("Correo electronico: ");
        // String email = in.nextLine();
        // Contact c = new Contact(name, phone, email);
        // h.add(c);
        // print("\n");
        // if (h.validateFactor()) {
        // print("WARNING!!!! El factor de carga supera el 75% de la capacidad");
        // }
        // h.viewContent();
        // } else
        // return;
    }
}
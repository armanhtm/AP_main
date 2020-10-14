package ap3;

import java.util.Scanner;

public class Main {
    public static Phonebook first = new Phonebook();

    public static void add(String name) {
        Info info = new Info();
        Scanner input = new Scanner(System.in);
        int counter;
        String temp;
        System.out.println("Please enter work info: ");
        temp = input.nextLine();
        info.setwork(temp);
        counter = 1;
        do {
            System.out.println("Please enter group " + counter + " or enter to finish: ");
            temp = input.nextLine();
            if (!temp.isEmpty()) {
                info.setgroup(temp);
                counter++;
            }
        }
        while (!temp.isEmpty());
        counter = 1;
        do {
            System.out.println("Please enter email " + counter + " or enter to finish: ");
            temp = input.nextLine();
            if (!temp.isEmpty()) {
                info.setemail(temp);
                counter++;
            }
        }
        while (!temp.isEmpty());
        counter = 1;
        do {
            if (counter != 1)
                System.out.println("Please enter phone " + counter + " or enter to finish: ");
            else
                System.out.println("Please enter phone " + counter);
            temp = input.nextLine();
            if (!temp.isEmpty()) {
                info.setphone(temp);
                counter++;
            }
        }
        while (!temp.isEmpty() || counter == 1);
        first.addContact(name, info);
        System.out.println("contact saved");
    }

    public static void delete(String name) {
        if (first.deleteContact(name))
            System.out.println("ok");
        else
            System.out.println("Not found");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String command;
        String[] name;
        while (true) {
            System.out.println("enter your command please");
            command = input.nextLine();
            if (command.contains(" -a ")) {
                name = command.split(" -a ");
                add(name[1]);
            }
            else if (command.contains(" -r ")) {
                name = command.split(" -r ");
                delete(name[1]);
            }
            else if (command.contains(" -g ")) {
                name = command.split(" -g ");
                first.printContacts(name[1]);
            }
            else if (command.contains(" -c ")) {
                name = command.split(" -c ");
                first.printContact(name[1]);
            }
            else if (command.equals("show")) {
                first.printContacts();
            }
            else if (command.equals("exit")) {
                break;
            }
            else {
                System.out.println("invalid command or syntax");
            }
        }
    }
}



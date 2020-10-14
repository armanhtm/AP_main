package ap3;

import java.util.HashMap;

/**
 * @author Arman Hatami
 * <p>
 * information of contact in phonebook
 */
public class Phonebook {
    private HashMap<String, Info> contacts = new HashMap<String, Info>();

    public boolean addContact(String name, Info info) {
        contacts.put(name, info);
        return true;
    }

    public Info findContact(String name) {
        return contacts.get(name);
    }

    public boolean deleteContact(String name) {
        if (!contacts.containsKey(name))
            return false;
        contacts.remove(name);
        return true;
    }

    public HashMap<String, Info> findContacts(String group) {
        HashMap<String, Info> groups = new HashMap<String, Info>();
        for (String name : contacts.keySet())
            if (contacts.get(name).getgroups().contains(group))
                groups.put(name, contacts.get(name));
        return groups;
    }

    public void printContacts() {
        for (String name : contacts.keySet()) {
            System.out.print("user\n" + name);
            contacts.get(name).printInfo();
        }
    }

    public void printContacts(String group) {
        HashMap<String, Info> groups = findContacts(group);
        System.out.println("list of user in this group");
        for (String name : groups.keySet()) {
            System.out.print("user\n" + name);
            groups.get(name).printInfo();
        }
    }

    public void printContact(String name) {
        Info info = findContact(name);
        if (info != null) {
            System.out.print(name);
            info.printInfo();
        }
    }
}


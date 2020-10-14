package ap3;

import java.util.ArrayList;

/**
 * @author Arman Hatami
 * <p>
 * information of contact in phonebook
 */
public class Info {
    private String workInfo;
    private ArrayList<String> groups = new ArrayList<String>();
    private ArrayList<String> emails = new ArrayList<String>();
    private ArrayList<String> phones = new ArrayList<String>();

    /*
     *printing the contact info
     */
    public void printInfo() {
        int i;
        System.out.println(" : " + workInfo + "\nphones:");
        for (i = 0; i < phones.size(); i++)
            System.out.println(i + 1 + " -> " + phones.get(i));
        System.out.println("groups:");
        for (i = 0; i < groups.size(); i++)
            System.out.println(i + 1 + " -> " + groups.get(i));
        System.out.println("emails:");
        for (i = 0; i < emails.size(); i++)
            System.out.println(i + 1 + " -> " + emails.get(i));
        System.out.println("_____________________________________");

    }

    public ArrayList<String> getgroups() {
        return groups;
    }

    public void setwork(String work) {
        workInfo = work;
    }

    public void setemail(String email) {
        emails.add(email);
    }

    public void setphone(String phone) {
        phones.add(phone);
    }

    public void setgroup(String group) {
        groups.add(group);
    }

}


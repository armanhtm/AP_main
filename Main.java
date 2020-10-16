/**
 * @author arman hatami
 * Coursera User ID:  123456
 * Last modified:     1/1/2019
 * this the main class that finally we can define a hotel and rooms and guests
 */

package hotel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String select;
        Hotel main = new Hotel();
        Room a = new Room(101, "Single", "SEA", 430);
        Room b = new Room(102, "Double", "FOREST", 650);
        main.addRoom(a);
        main.addRoom(b);
        while (true) {
            System.out.println("1.check in a new guest");
            System.out.println("2.check out a guest");
            System.out.println("3.show available rooms");
            System.out.println("4.add a new room");
            System.out.println("5.exit\n");
            System.out.print("enter your command : ");
            select = input.nextLine();
            switch (select) {
                case "1":
                    Guest guestIn = new Guest();
                    main.checkIn(guestIn);
                    break;
                case "2":
                    Guest guestOut = new Guest();
                    String name;
                    System.out.println("enter your name");
                    name = input.nextLine();
                    guestOut.setName(name);
                    System.out.println(
                            "we hope you enjoyed your resident\nyour total cost : " + main
                                    .checkOut(guestOut) + "$");
                    break;
                case "3":
                    main.roomList();
                    break;
                case "4":
                    main.newRoom();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("invalid entry");
            }
            System.out.println("\n\n__________________________________\n");
        }

    }
}

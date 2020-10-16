/**
 * @author arman hatami
 * Coursera User ID:  123456
 * Last modified:     1/1/2019
 * this class defines the whole hotel and its rooms and guests as its adjectives
 */

package hotel;

import java.util.ArrayList;
import java.util.Scanner;

public class Hotel {
    private ArrayList<Room> rooms = new ArrayList<Room>();
    private ArrayList<Guest> guests = new ArrayList<Guest>();

    /**
     * adding a room to our hotel
     *
     * @param room class room
     */
    public void addRoom(Room room) {
        rooms.add(room);
    }

    /**
     * it prints all the information of rooms we have in our hotel
     */
    public void roomList() {
        for (Room room : rooms)
            room.printInfo();
    }

    /**
     * it returns the list of rooms as an arraylist
     *
     * @return rooms list of rooms
     */
    public ArrayList<Room> getRoomList() {
        return rooms;
    }

    /**
     * it returns the list of guests as an arraylist
     *
     * @return rooms list of guests
     */
    public ArrayList<Guest> getGuestList() {
        return guests;
    }

    /**
     * it reserves a room for a guest for a particular date
     *
     * @param guest the information of our check in guest
     * @param date  the requested date by check in guest
     * @param type  the requested type by check in guest
     * @param view  the requested view by check in guest
     */
    public void reserve(Guest guest, Dates date, Room.Type type, Room.View view) {
        for (Room room : rooms)
            if (!room.isReserved(date) && room.getType() == type && room.getView() == view) {
                guest.bookHotel(room);
                System.out.println(
                        "room number " + room.getNumber() + " is reserved for " + guest.getName());
                guests.add(guest);
                room.reserve(date);
                return;
            }
        System.out.println("there is no room with this adjectives for that date");
    }

    /**
     * it gets all the information and data we need from new check in guest
     *
     * @param guest the new guest we want to add to our guest
     */
    public void checkIn(Guest guest) {
        Scanner input = new Scanner(System.in);
        String temp;
        System.out.println("enter your name please");
        temp = input.nextLine();
        guest.setName(temp);
        System.out
                .println("enter type of room you want (Single ,Double ,Triple ,Quad ,Queen ,King)");
        temp = input.nextLine();
        Room.Type type = Room.Type.valueOf(temp);
        System.out.println("enter the view you want for our room (SEA ,FOREST ,BUILDING)");
        temp = input.nextLine();
        Room.View view = Room.View.valueOf(temp);
        Dates date = new Dates();
        System.out.println("enter the start time of your resident");
        temp = input.nextLine();
        date.setStartDay(temp);
        System.out.println("enter the finish time of your resident");
        temp = input.nextLine();
        date.setFinishDay(temp);
        reserve(guest, date, type, view);
    }

    /**
     * it returns the cost that our check out guest should pay
     *
     * @return cost the cost of using room
     */
    public double checkOut(Guest guest) {
        for (Guest gst : guests)
            if (gst.getName().equals(guest.getName())) {
                double cost;
                cost = gst.getRoom().getPrice() * gst.getRoom().dayCount();
                Dates date = new Dates();
                date.setStartDay("0");
                date.setFinishDay("0");
                gst.getRoom().reserve(date);
                guests.remove(gst);
                return cost;
            }
        return 0;
    }

    /**
     * it will add a complete new room to the hotel
     */
    public void newRoom() {
        Scanner input = new Scanner(System.in);
        int number = 0, flag = 0;
        double price;
        String tType;
        String tView;
        System.out.println("enter the number of new room");
        while (flag == 0) {
            number = input.nextInt();
            input.nextLine();
            for (Room room : rooms)
                if (room.getNumber() == number) {
                    System.out.println("repetitive try again");
                    continue;
                }
            flag = 1;
        }
        System.out
                .println("enter the type of new room (Single ,Double ,Triple ,Quad ,Queen ,King)");
        tType = input.nextLine();
        System.out.println("enter the view of new room (SEA ,FOREST ,BUILDING)");
        tView = input.nextLine();
        System.out.println("enter the price of new room per night");
        price = input.nextDouble();
        input.nextLine();
        Room room = new Room(number, tType, tView, price);
        addRoom(room);
        System.out.println("new room is added successfully");
    }

}

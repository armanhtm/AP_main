/**
 * @author arman hatami
 * Coursera User ID:  123456
 * this class define a guest with its adjectives and fields
 * ***************************************************************************
 */

package hotel;

public class Guest {
    private String name;
    private Room room;

    /**
     * setting the name
     *
     * @param name setting the name of guest
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * it returns the name of guest
     *
     * @return it returns the name our guest
     */
    public String getName() {
        return name;
    }

    /**
     * it books a room for our guest
     *
     * @param room it defines a room for our guest
     */
    public void bookHotel(Room room) {
        this.room = room;
    }

    /**
     * it returns the room that our guest is living in
     *
     * @return room
     */
    public Room getRoom() {
        return room;
    }
}

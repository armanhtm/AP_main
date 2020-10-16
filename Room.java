/**
 * @author arman hatami
 * Coursera User ID:  123456
 * this class define a room with its specific adjectives
 * ***************************************************************************
 */

package hotel;

public class Room {
    private int number;

    /**
     * this is a list of different views we have
     */
    enum View {
        SEA,
        FOREST,
        BULDING
    }

    /**
     * this is a list of different types of room we have
     */
    enum Type {
        Single,
        Double,
        Triple,
        Quad,
        Queen,
        King

    }

    private Type type;
    private View view;
    private Dates day = new Dates();
    private double price;

    /**
     * constructor of room class
     *
     * @param number the number of this room
     * @param type   the type of this room
     * @param view   the view of this room
     * @param price  the price for each night for this room
     */
    public Room(int number, String type, String view, double price) {
        this.number = number;
        this.type = Type.valueOf(type);
        this.view = View.valueOf(view);
        this.price = price;
        day.setStartDay("0");
        day.setFinishDay("0");
    }

    /**
     * this print all data and information about this room
     */
    public void printInfo() {
        System.out.println("room number : " + number);
        System.out.println("type of room : " + type);
        System.out.println("view of room : " + view);
        if (dayCount() != 0)
            System.out.println("this room is reserved : " + day.getDaysToStay());
        else
            System.out.println("this room is still empty");
        System.out.println("price per night for this room : " + price + " $");
        System.out.println("__________________________________");
    }

    /**
     * adding date to this room field of date
     *
     * @param date
     */
    public void reserve(Dates date) {
        day = date;
    }

    /**
     * string to digits convertor
     *
     * @param input string that we want to convert to digits
     */
    public static double Atoi(String input) {
        double res = 0;

        for (int i = 0; i < input.length(); ++i)
            res = res * 10 + input.charAt(i) - '0';

        return res;
    }

    /**
     * it tells us if this room is full at that particular date or not
     *
     * @param date the date we want to check
     * @return boolean it returns true if room is full
     */
    public boolean isReserved(Dates date) {
        double reqFirst = Atoi(date.getStartDate());
        double reqEnd = Atoi(date.getFinishDate());
        double resFirst = Atoi(day.getStartDate());
        double resEnd = Atoi(day.getFinishDate());
        if (reqFirst < resFirst && reqEnd < resFirst)
            return false;
        else if (reqFirst > resEnd && reqEnd > resEnd)
            return false;
        else
            return true;
    }

    /**
     * returns the view of this room
     *
     * @return view
     */
    public View getView() {
        return view;
    }

    /**
     * returns the type of this room
     *
     * @return type
     */
    public Type getType() {
        return type;
    }

    /**
     * returns the number of this room
     *
     * @return number
     */
    public int getNumber() {
        return number;
    }

    /**
     * returns the number of days between start and finish day
     *
     * @return count of days
     */
    public double dayCount() {
        double begin;
        int sumBegin = 0;
        double end;
        int sumEnd = 0;
        begin = Atoi(day.getStartDate());
        end = Atoi(day.getFinishDate());
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                sumBegin += (int) begin % 100;
                sumEnd += (int) end % 100;
            }
            if (i == 1) {
                if (begin % 100 <= 6)
                    sumBegin += (int) (begin % 100) * 31;
                else if (begin % 100 <= 11)
                    sumBegin += (int) (begin % 100) * 30;
                else
                    sumBegin += (int) (begin % 100) * 29;
                if (end % 100 <= 6)
                    sumEnd += (int) (end % 100) * 31;
                else if (end % 100 <= 11)
                    sumEnd += (int) (end % 100) * 30;
                else
                    sumEnd += (int) (end % 100) * 29;
            }
            if (i == 2) {
                sumBegin += (int) (begin % 100) * 365;
                sumEnd += (int) (end % 100) * 365;
            }
            if (i == 3) {
                sumBegin += (int) (begin % 100) * 365 * 100;
                sumEnd += (int) (end % 100) * 365 * 100;
            }
            begin /= 100;
            end /= 100;
        }
        return sumEnd - sumBegin;
    }

    /**
     * returns the price of this room for each night
     *
     * @return price
     */
    public double getPrice() {
        return price;
    }
}

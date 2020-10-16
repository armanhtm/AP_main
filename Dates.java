/**
 * @author arman hatami
 * Coursera User ID:  123456
 * in this class we define a structure for our date input
 * ***************************************************************************
 */

package hotel;

public class Dates {
    private String daysToStay;
    private String start;
    private String finish;

    /**
     * setting the first day
     *
     * @param begin the start day of resident time
     */
    public void setStartDay(String begin) {
        this.start = begin;
    }

    /**
     * it returns the first day
     *
     * @return start returns the date of start time of resident time
     */
    public String getStartDate() {
        return start;
    }

    /**
     * setting the last day
     *
     * @param end the last day of resident date
     */
    public void setFinishDay(String end) {
        this.finish = end;
    }

    /**
     * it returns the last day
     *
     * @return it returns the date of finish time of resident time
     */
    public String getFinishDate() {
        return finish;
    }

    /**
     * setting resident date
     *
     * @param end the last day of resident date
     */
    public void setDaysToStay(String end) {
        daysToStay = start.concat(" to " + end);
    }

    /**
     * it returns resident date
     *
     * @return it returns the string of resident date
     */
    public String getDaysToStay() {
        setDaysToStay(finish);
        return daysToStay;
    }

}

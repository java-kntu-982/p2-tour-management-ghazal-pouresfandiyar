package ir.ac.kntu;

/**
 * Date class has 3 private parameters(year,month,day)
 */
public class Date {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        checkAndSetDate(year, month, day);
    }
    public Date(Date date) {
        this.year = date.year;
        this.month = date.month;
        this.day = date.day;
    }
    public Date(){}

    /**
     * This method will set year ,month and day if they are valid
     * @param year  It's a positive integer
     * @param month It's a positive integer
     * @param day   It's a positive integer
     */
    private void checkAndSetDate(int year, int month, int day) {
        if (checkInputs(year, month, day)) {
            this.year = year;
            this.month = month;
            this.day = day;
        } else {
            this.year = 0;
            this.month = 1;
            this.day = 1;
        }
    }

    /**
     * @param year  It can be any positive integer
     * @param month It should be an integer more than 0 and less than 13
     * @param day   It depends on the month but totally it can be an integer between 0 and 32(more than 0 and less than 32)
     * @return A boolean(If there isn't any problem in Inputs it returns true)
     */
    private boolean checkInputs(int year, int month, int day) {
        if (month < 1 || month > 12 || day < 1 || day > 31 || month > 6
                && day == 31) {
            return false;
        }
        return month != 12 || day != 30 || isLeapYear(year);
    }

    public void setDate(int year, int month, int day) {
        checkAndSetDate(year, month, day);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        checkAndSetDate(year, this.month, this.day);
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        checkAndSetDate(this.year, month, this.day);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        checkAndSetDate(this.year, this.month, day);
    }

    /**
     * @return A printed format of date
     */
    public String toString() {
        return day + "/" + month + "/" + year;
    }

    /**
     * @return The date of next day
     */
    public Date nextDay() {
        Date curDate = new Date(this);
        Date nextDate = new Date(this);
        if (curDate.month == 12) {
            handleTheLastMonth(curDate, nextDate);
        } else if (curDate.day < 30) {
            nextDate.day++;
        } else if (curDate.day == 30 && curDate.month < 7) {
            nextDate.day++;
        }
        else {
            nextDate.day = 1;
            nextDate.month++;
        }
        return nextDate;
    }

    /**
     * @param curDate  It shows the current date
     * @param nextDate It shows the next date
     */
    private void handleTheLastMonth(Date curDate, Date nextDate) {
        int endOfMonthDay = 29;
        if (isLeapYear(curDate.year)) {
            endOfMonthDay = 30;
        }
        if (curDate.day == endOfMonthDay) {
            nextDate.year++;
            nextDate.month = 1;
            nextDate.day = 1;
        } else {
            nextDate.day++;
        }
    }

    /**
     * @param year It's a positive integer
     * @return A boolean to show if the param year is leap or not
     */
    private boolean isLeapYear(int year) {
        int firstFraction, secondFraction;
        final double a = 0.025d;
        final double b = 266d;
        double c, d;
        if (year > 0) {
            c = ((year + 38) % 2820) * 0.24219 + a;
            d = ((year + 39) % 2820) * 0.24219 + a;
        } else if (year < 0) {
            c = ((year + 39) % 2820) * 0.24219 + a;
            d = ((year + 40) % 2820) * 0.24219 + a;
        } else {
            return false;
        }
        firstFraction = (int) ((c - Math.floor(c)) * 1000);
        secondFraction = (int) ((d - Math.floor(d)) * 1000);
        return firstFraction <= b && secondFraction > b;
    }



}
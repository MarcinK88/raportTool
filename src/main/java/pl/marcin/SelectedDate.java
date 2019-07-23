package pl.marcin;

public class SelectedDate {

    int year;
    String month;
    int monthInt;

    public SelectedDate() {
    }

    public SelectedDate(int year, String month, int monthInt) {
        this.year = year;
        this.month = month;
        this.monthInt = monthInt;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getMonthInt() {
        return monthInt;
    }

    public void setMonthInt(int monthInt) {
        this.monthInt = monthInt;
    }
}

package kalendarz;

import java.util.GregorianCalendar;

public class Calendar {

    public Window window;

    private int year;
    private int month;

    public Calendar()
    {
        GregorianCalendar cal = new GregorianCalendar();
        year = cal.get(GregorianCalendar.YEAR);
        month = cal.get(GregorianCalendar.MONTH);
        window = new Window(this);
    }

    public int get_year() { return year; }
    public int get_month() { return month; }

    public void year_inc()
    {
        year++;
        window.act();
    }
    public void year_dec()
    {
        year--;
        window.act();
    }
    public void month_inc()
    {
        month = get_next_month();
        year = get_next_months_year();
        window.act();
    }
    public void month_dec()
    {
        month = get_prev_month();
        year = get_prev_months_year();
        window.act();
    }
    public void set_month(int m)
    {
        month = m;
        window.act();
    }
    public void set_year(int y)
    {
        year = y;
        window.act();
    }


    public int get_next_month()
    {
        if(month == 12) return 1;
        else return month+1;
    }
    public int get_prev_month()
    {
        if(month == 1) return 12;
        else return month-1;
    }
    public int get_next_months_year()
    {
        if(month == 12) return year+1;
        else return year;
    }
    public int get_prev_months_year()
    {
        if(month == 1) return year-1;
        else return year;
    }


}

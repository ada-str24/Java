package kalendarz;

import javax.swing.*;

public class List extends AbstractListModel {

    private int month;
    private int year;

    public List(int m,int y)
    {
        month = m;
        year = y;
    }

    public int getSize()
    {
        return Miesiac.days_of_the_month(month,year);
    }

    public String getElementAt(int index)
    {
        index += 1;
        if((year == 1582) && (month == 10))
        {
            if(index>4) index += 10;
        }
        String s = Miesiac.nazwy_dni[Miesiac.day_of_the_week(index,month,year)];
        s += (",  " + String.valueOf(index) + " ");
        s += Miesiac.nazwy_miesiecy_odm[month];
        return s;
    }

    public void act(int m,int y)
    {
        month = m;
        year = y;
        fireContentsChanged(this,0,0);
    }

}

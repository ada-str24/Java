package kalendarz;

import java.util.Date;
import java.util.GregorianCalendar;

public class Miesiac {


    public static String[] nazwy_miesiecy = {"","Styczeń","Luty","Marzec","Kwiecień","Maj","Czerwiec","Lipiec","Sierpień","Wrzesień","Październik","Listopad","Grudzień"};
    public static String[] nazwy_miesiecy_odm = {"","Stycznia","Lutego","Marca","Kwietnia","Maja","Czerwca","Lipca","Sierpnia","Września","Pażdziernika","Listopada","Grudnia"};

    public static String[] nazwy_dni = {"","Poniedziałek","Wtorek","Sroda","Czwartek","Piątek","Sobota","Niedziela"};

    public static int day_of_the_week(int day, int month, int year)
    {
        GregorianCalendar cal = new GregorianCalendar(year,month-1,day-1);
        int weekday = cal.get(GregorianCalendar.DAY_OF_WEEK);
        return weekday;

    }
    public static int days_of_the_month(int month, int year)
    {
        if((year==1582) && (month==10)) return 21;
        if((month==1) || (month==3) || (month==5) || (month==7) || (month==8) || (month==10) || (month==12)) return 31;
        if((month==4) || (month==6) || (month==9) || (month==11)) return 30;
        if(year%4 != 0) return 28;
        if(year%400 == 0) return 29;
        if(year%100 == 0) return 28;
        return 29;
    }



    private static int act = 1;
    private static int end;
    private static boolean special = false;

    public static void new_day_stream(int m, int y)
    {
        act = 1;
        if((y == 1582) && (m == 10)) special = true;
        else special = false;
        end = Miesiac.days_of_the_month(m,y);
    }
    public static String next_day()
    {
        if((special) && (act>4))
        {
            act++;
            return String.valueOf(act-1+10);
        }
        act++;
        return String.valueOf((act-1));
    }
    public static boolean stream_end()
    {
        if(act == end+1) return true;
        return false;
    }
}

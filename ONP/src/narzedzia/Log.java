package narzedzia;

public class Log extends Funkcja2arg {
    public Log()
    {
        super();
    }
    public double oblicz() throws WyjatekONP
    {
        if(brak_arg>0) throw new BladLiczbyArgumentow("Za mało argumentów dla funkcji Log");////////////////////////////////////////////////////////
        if(arg1 <= 0) throw new WyjatekLog("Podstawa logarytmu musi być dodatnia");
        if(arg2 <= 0) throw new WyjatekLog("Liczba logarytmowana musi być dodatnia");
        if(arg1 == 1) throw new WyjatekLog("Podstawa logarytmu nie może być równa 1");
        return (Math.log(arg2) / Math.log(arg1));

    }
}

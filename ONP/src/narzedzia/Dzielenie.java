package narzedzia;

public class Dzielenie extends Funkcja2arg{
    public Dzielenie()
    {
        super();
    }
    public double oblicz() throws WyjatekONP
    {
        if(brak_arg>0) throw new BladLiczbyArgumentow("Za mało argumentów");////////////////////////////////////////////////////////
        if(arg2 == 0)  throw new Dzielenieprzez0();
        return arg1 / arg2;
    }
}

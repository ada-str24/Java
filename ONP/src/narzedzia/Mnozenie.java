package narzedzia;

public class Mnozenie extends Funkcja2arg{
    public Mnozenie()
    {
        super();
    }
    public double oblicz() throws BladLiczbyArgumentow
    {
        if(brak_arg>0) throw new BladLiczbyArgumentow("Za mało argumentów dla funkcji *");////////////////////////////////////////////////////////
        return arg1 * arg2;
    }
}

package narzedzia;

public class Odejmowanie extends Funkcja2arg{
    public Odejmowanie()
    {
        super();
    }
    public double oblicz() throws BladLiczbyArgumentow
    {
        if(brak_arg>0) throw new BladLiczbyArgumentow("Za mało argumentów dla funkcji -");////////////////////////////////////////////////////////
        return arg1 - arg2;
    }
}

package narzedzia;

public class Pow extends Funkcja2arg {
    public Pow()
    {
        super();
    }
    public double oblicz() throws BladLiczbyArgumentow
    {
        if(brak_arg>0) throw new BladLiczbyArgumentow("Za mało argumentów dla funkcji Pow");////////////////////////////////////////////////////////
        return Math.pow(arg1 , arg2);
    }
}

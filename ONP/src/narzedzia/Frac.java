package narzedzia;

public class Frac extends Funkcja1arg{
    public Frac()
    {
        super();
    }
    public double oblicz() throws BladLiczbyArgumentow
    {
        if(brak_arg>0) throw new BladLiczbyArgumentow("Funkcja Abs ma za mało argumentów");///////////////////////////////////////////////
        return arg1 - Math.floor(arg1);
    }
}

package narzedzia;

public class Cos extends Funkcja1arg{
    public Cos()
    {
        super();
    }
    public double oblicz() throws BladLiczbyArgumentow
    {
        if(brak_arg>0) throw new BladLiczbyArgumentow("Funkcja Abs ma za mało argumentów");///////////////////////////////////////////////
        return Math.cos(arg1);
    }
}

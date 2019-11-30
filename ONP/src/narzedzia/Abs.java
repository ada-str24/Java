package narzedzia;

public class Abs extends Funkcja1arg{
    public Abs()
    {
        super();
    }
    public double oblicz() throws BladLiczbyArgumentow
    {
        if(brak_arg>0) throw new BladLiczbyArgumentow("Funkcja Abs ma za mało argumentów");///////////////////////////////////////////////
        return Math.abs(arg1);
    }
}

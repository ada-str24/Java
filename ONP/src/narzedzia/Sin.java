package narzedzia;

public class Sin extends Funkcja1arg{
    public Sin()
    {
        super();
    }
    public double oblicz() throws BladLiczbyArgumentow
    {
        if(brak_arg>0) throw new BladLiczbyArgumentow("Funkcja Abs ma za mało argumentów");///////////////////////////////////////////////
        return Math.sin(arg1);
    }
}

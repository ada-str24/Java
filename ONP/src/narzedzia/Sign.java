package narzedzia;

public class Sign extends Funkcja1arg {
    public Sign()
    {
        super();
    }
    public double oblicz() throws BladLiczbyArgumentow
    {
        if(brak_arg>0) throw new BladLiczbyArgumentow("Funkcja Abs ma za mało argumentów");///////////////////////////////////////////////
        return Math.signum(arg1);
    }
}

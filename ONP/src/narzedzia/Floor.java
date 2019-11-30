package narzedzia;

public class Floor extends Funkcja1arg {
    public Floor()
    {
        super();
    }
    public double oblicz() throws BladLiczbyArgumentow
    {
        if(brak_arg>0) throw new BladLiczbyArgumentow("Funkcja Abs ma za mało argumentów");///////////////////////////////////////////////
        return Math.floor(arg1);
    }
}

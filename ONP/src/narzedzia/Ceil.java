package narzedzia;

public class Ceil extends Funkcja1arg {
    public Ceil()
    {
        super();
    }
    public double oblicz() throws BladLiczbyArgumentow
    {
        if(brak_arg>0) throw new BladLiczbyArgumentow("Funkcja Abs ma za mało argumentów");///////////////////////////////////////////////
        return Math.ceil(arg1);
    }
}

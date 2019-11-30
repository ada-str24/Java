package narzedzia;

public class Dodawanie extends Funkcja2arg {
    public Dodawanie()
    {
        super();
    }
    public double oblicz() throws BladLiczbyArgumentow
    {
        if(brak_arg>0) throw new BladLiczbyArgumentow("Funkcja + ma za mało argumentów");////////////////////////////////////////////////////////
        return arg1 + arg2;
    }
}

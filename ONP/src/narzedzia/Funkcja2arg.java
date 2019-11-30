package narzedzia;

public abstract class Funkcja2arg extends Funkcja1arg {
    protected double arg2;
    public Funkcja2arg()
    {
        brak_arg=2;
    }
    public int arnosc()
    {
        return 2;
    }
    public void dodajArgument(double arg) throws BladLiczbyArgumentow
    {
        if(brak_arg==2)
        {
            arg2 = arg;
        }
        else if(brak_arg==1)
        {
            arg1 = arg;
        }
        else throw new BladLiczbyArgumentow("Funkcja jest dwuargumentowa");
        brak_arg--;
    }
}

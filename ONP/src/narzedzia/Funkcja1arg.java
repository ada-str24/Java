package narzedzia;

public abstract class Funkcja1arg extends Funkcja{
    protected double arg1;
    protected int brak_arg;
    public Funkcja1arg()
    {
        brak_arg=1;
    }
    public int arnosc()
    {
        return 1;
    }
    public int brakujaceArgumenty()
    {
        return brak_arg;
    }
    public void dodajArgument(double arg) throws BladLiczbyArgumentow
    {
        if(brak_arg==1)
        {
            arg1 = arg;
        }
        else throw new BladLiczbyArgumentow("Funkcja jest jednoargumentowa");
        brak_arg--;
    }
}

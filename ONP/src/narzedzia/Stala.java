package narzedzia;

public abstract class Stala extends Funkcja{
    public int arnosc()
    {
        return 0;
    }
    public int brakujaceArgumenty()
    {
        return 0;
    }
    public void dodajArgument(double d) throws BladLiczbyArgumentow
    {
        throw new BladLiczbyArgumentow("Funkcja jest zeroargumentowa");
    }
}

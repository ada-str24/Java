package narzedzia;

public class Liczba extends Operand{

    private double wartosc;

    public Liczba(double val)
    {
        wartosc=val;
    }
    public double oblicz()
    {
        return wartosc;
    }
}

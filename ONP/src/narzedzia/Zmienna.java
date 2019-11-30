package narzedzia;

public class Zmienna extends Operand {
    private Zbior zmienne;
    private String nazwa;
    public Zmienna(String s,Zbior z)
    {
        zmienne = z;
        nazwa = s;
    }
    public void przypisz(double val)
    {
        zmienne.dodaj(nazwa,val);
    }
    public double oblicz() throws BrakZmiennej
    {
        return zmienne.odczytaj(nazwa);
    }
}

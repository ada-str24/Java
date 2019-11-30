package narzedzia;
import java.util.ArrayDeque;

public class Stos {
    private ArrayDeque<Double> kolejka;
    public Stos()
    {
        kolejka = new ArrayDeque<Double>();
    }
    public void dodaj(Double x)
    {
        kolejka.addLast(x);
    }
    public Double wyjmij() throws NiepoprawneONP
    {
        if(kolejka.isEmpty()) throw new NiepoprawneONP();
        Double d = kolejka.getLast();
        kolejka.removeLast();
        return d;
    }
}

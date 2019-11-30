package narzedzia;
import java.util.ArrayDeque;

public class Kolejka {
    private ArrayDeque<Symbol> kolejka;
    public Kolejka()
    {
        kolejka = new ArrayDeque<Symbol>();
    }
    public void dodaj(Symbol s)
    {
        kolejka.addLast(s);
    }
    public Symbol wyjmij() throws NiepoprawneONP
    {
        if(kolejka.isEmpty()) throw new NiepoprawneONP();
        Symbol s = kolejka.getFirst();
        kolejka.removeFirst();
        return s;
    }
    public Symbol popatrz() throws NiepoprawneONP
    {
        if(kolejka.isEmpty()) throw new NiepoprawneONP();
        return kolejka.getFirst();
    }
    public boolean pusta()
    {
        return kolejka.isEmpty();
    }
    public int rozmiar()
    {
        return kolejka.size();
    }
}

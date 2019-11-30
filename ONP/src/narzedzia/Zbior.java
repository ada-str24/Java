package narzedzia;
import java.util.*;



public class Zbior {
    private TreeMap<String, Double> zbior;
    public Zbior()
    {
        zbior = new TreeMap<String,Double>();
    }
    public void dodaj(String s, double val)
    {
        zbior.put(s,val);
    }
    public double odczytaj(String s) throws BrakZmiennej
    {
        double wynik;
        try{
            return zbior.get(s);
        }catch(Exception e){
            throw new BrakZmiennej(s);
        }
    }
    public void usun(String s)
    {
        zbior.remove(s);
    }
    public void wyczysc()
    {
        zbior.clear();
    }
}

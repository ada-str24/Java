package narzedzia;

public class Max extends Funkcja2arg{
    public Max()
    {
        super();
    }
    public double oblicz() throws BladLiczbyArgumentow
    {
        if(brak_arg>0) throw new BladLiczbyArgumentow("Za mało argumentów dla funkcji Max");
        return Math.max(arg1 , arg2);
    }
}

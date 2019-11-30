package narzedzia;

public class Min extends Funkcja2arg {
    public Min()
    {
        super();
    }
    public double oblicz() throws BladLiczbyArgumentow
    {
        if(brak_arg>0) throw new BladLiczbyArgumentow("Za mało argumentów dla funkcji Min");////////////////////////////////////////////////////////
        return Math.min(arg1 , arg2);
    }
}

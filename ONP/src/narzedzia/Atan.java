package narzedzia;

public class Atan extends Funkcja1arg{
    public Atan()
    {
        super();
    }
    public double oblicz() throws WyjatekONP
    {
        if(brak_arg>0) throw new BladLiczbyArgumentow("Funkcja Abs ma za mało argumentów");
        try{
            return Math.atan(arg1);
        }
        catch(Exception e){
            throw new WyjatekNumeryczny("Atan dla Argumentu nie istnieje");
        }
    }
}

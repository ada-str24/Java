package narzedzia;
import java.util.logging.*;

public class Wyrazenie {
    public boolean obliczalny=true;
    private Kolejka kolejka; // kolejka symboli wyrażenia ONP (elementy typu Symbol)
    private Stos stos; // stos z wynikami pośrednimi obliczeń (elementy typu Double)
    private static Zbior zmienne = new Zbior();
    private static Logger logger = Logger.getLogger(Wyrazenie.class.getName());
    public Wyrazenie (String onp) throws WyjatekONP
    {
        if (logger.getHandlers().length == 0)
        {
            try {
                Handler handler = new FileHandler("calc.log", true);
                handler.setFormatter(new SimpleFormatter());
                logger.addHandler(handler);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        String symbols [] = onp.split(" ");
        if(symbols[0].equals("calc"))
        {
            logger.log(Level.INFO, onp);
            kolejka = new Kolejka();
            for(int i=1;i<symbols.length;i++)
            {
                String symbol = symbols[i];
                if (symbol.equals("+"))         kolejka.dodaj(new Dodawanie());
                else if (symbol.equals("-"))    kolejka.dodaj(new Odejmowanie());
                else if (symbol.equals("*"))    kolejka.dodaj(new Mnozenie());
                else if(symbol.equals("/"))     kolejka.dodaj(new Dzielenie());
                else if(symbol.equals("power")) kolejka.dodaj(new Pow());
                else if(symbol.equals("log"))   kolejka.dodaj(new Log());
                else if(symbol.equals("max"))   kolejka.dodaj(new Max());
                else if(symbol.equals("min"))   kolejka.dodaj(new Min());
                else if(symbol.equals("abs"))   kolejka.dodaj(new Abs());
                else if(symbol.equals("sgn"))   kolejka.dodaj(new Sign());
                else if(symbol.equals("floor")) kolejka.dodaj(new Floor());
                else if(symbol.equals("ceil"))  kolejka.dodaj(new Ceil());
                else if(symbol.equals("frac"))  kolejka.dodaj(new Frac());
                else if(symbol.equals("sin"))   kolejka.dodaj(new Sin());
                else if(symbol.equals("cos"))   kolejka.dodaj(new Cos());
                else if(symbol.equals("atan"))  kolejka.dodaj(new Atan());
                else if(symbol.equals("pi"))    kolejka.dodaj(new Pi());
                else if(symbol.equals("phi"))    kolejka.dodaj(new Phi());
                else if(symbol.equals("e"))    kolejka.dodaj(new E());
                //else if(symbol.equals(""))    kolejka.dodaj(new );
                else if (isNumeric(symbol))     kolejka.dodaj(new Liczba(Double.parseDouble(symbol)));
                else if (symbol.equals("="))    kolejka.dodaj(new Przypisanie());
                else    kolejka.dodaj(new Zmienna(symbol, zmienne));
            }
            stos = new Stos();
        }
        else if(symbols[0].equals("clear"))
        {
            if(symbols.length == 1)
                zmienne.wyczysc();
            for(int i=1;i<symbols.length;i++)
            {
                zmienne.usun(symbols[i]);
            }
            obliczalny=false;
        }
        else
            throw new NiepoprawneONP();
    }
    public double policz() throws Exception
    {
        if(obliczalny == false) return 0;
        if(kolejka.rozmiar()==1)
        {
            Symbol s = kolejka.wyjmij();
            if(s instanceof Zmienna)
                return ((Zmienna)s).oblicz();
            else throw new NiepoprawneONP();
        }
        while(kolejka.pusta()==false)
        {
            Symbol s = kolejka.wyjmij();
            if(s instanceof Operand)
            {
                if((s instanceof Zmienna) && ((kolejka.popatrz() instanceof Przypisanie)))
                {
                    Przypisanie p = (Przypisanie)kolejka.wyjmij();
                    double val = stos.wyjmij();
                    p.przypisz(val,(Zmienna)s);
                    stos.dodaj(val);
                }
                else
                    stos.dodaj(s.oblicz());
            }
            else {
                Funkcja f = (Funkcja) s;
                while (f.brakujaceArgumenty() > 0) {
                    f.dodajArgument(stos.wyjmij());
                }
                stos.dodaj(f.oblicz());
            }
        }
        double wynik = stos.wyjmij();
        if(kolejka.pusta() == false)
            throw new Exception("błędne wyrażenie onp");
        return wynik;
    }

    private boolean isNumeric(String s)
    {
        try
        {
            double d = Double.parseDouble(s);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }

}

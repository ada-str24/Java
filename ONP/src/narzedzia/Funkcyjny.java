package narzedzia;

/**
 * Interfejs dla funkcji
 */
public interface Funkcyjny extends Obliczalny{
    /**
     *  Metoda zwracająca arność funkcji
     * @return arność
     */
    int arnosc ();

    /**
     * Metoda sprawdzająca ile jeszcze argumentów brakuje funkcji
     * @return Liczba argumentów brakujących
     */
    int brakujaceArgumenty ();

    /**
     * Metoda umożliwiająca dodawanie argumentów dla funkcji
     * @param x argument dla funkcji
     * @throws BladLiczbyArgumentow chcemy dodać za dużo argumentów
     */
    void dodajArgument (double x) throws BladLiczbyArgumentow;
}

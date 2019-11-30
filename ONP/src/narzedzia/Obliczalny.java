package narzedzia;

/**
 * Interfejs umożliwiający obliczanie symboli
 */
public interface Obliczalny {
    /**
     * metoda do obliczania wartości symbolu
     * @return wartość
     * @throws WyjatekONP
     */
    double oblicz() throws WyjatekONP;
}

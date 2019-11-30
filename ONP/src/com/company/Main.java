package com.company;
import narzedzia.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            try {
                String s = scanner.nextLine();
                String symbols [] = s.split(" ");
                assert((symbols[0].equals("exit")) || (symbols[0].equals("calc")) || (symbols[0].equals("clear"))) : "nie ma takiego polecenia";
                if(symbols[0].equals("exit"))
                    break;
                try {
                    Wyrazenie w = new Wyrazenie(s);
                    if(w.obliczalny)
                        System.out.println(w.policz());
                } catch (Exception e) {
                    System.out.println(e);
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
}

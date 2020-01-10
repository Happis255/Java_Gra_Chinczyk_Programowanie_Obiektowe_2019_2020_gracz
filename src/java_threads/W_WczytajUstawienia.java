package java_threads;

import java_pliki.Ustawienia;

import java.io.*;

public class W_WczytajUstawienia extends Thread {

    private Ustawienia ust;

    public W_WczytajUstawienia(Ustawienia c) {
        ust = c;
    }

    /* Watek odpowiedzialny jest za otworzenie strumienia do pliku bitowego
    zawierajacego informacje o wczesniej zapisanych ustawieniach, a nastepnie
    wczytaniu ich i zapisaniu w obiekcie przechowywujacym dane o ustawieniach */
    public void run() {

        /* Otwieranie pliku z ustawieniami */
        DataInputStream strumien = null;
        int war = 0;
        String filePath = ".\\settings\\setting.txt";

        try {

            File plik = new File(filePath);

            if (plik.createNewFile())
                System.out.println("ERROR0000001 STOP");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            strumien = new DataInputStream(new FileInputStream(filePath));
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku ustawien.");
        }

        try {
            /* 1. Rozdzielczosc */
            war = strumien.readInt();
            ust.rozdzielczosc = war;

            /* 2. Jakosc grafiki */
            war = strumien.readInt();
            ust.jakosc = war;

            /* 3. Tryb okna */
            war = strumien.readInt();
            ust.tryb_okna = war;

            /* 4. Liczba graczy */
            war = strumien.readInt();
            ust.liczba_graczy = war;

            /* 5. Kolor gracza 1 */
            war = strumien.readInt();
            ust.kolor_1 = war;

            /* 6. Kolor gracza 2*/
            war = strumien.readInt();
            ust.kolor_2 = war;

            /* 7. Kolor gracza 3 */
            war = strumien.readInt();
            ust.kolor_3 = war;

            /* 8. Kolor gracza 4 */
            war = strumien.readInt();
            ust.kolor_4 = war;

            /* 9. Glosnosc */
            war = strumien.readInt();
            ust.glosnosc = war;

            /* 10. Jakosc dzwieku */
            war = strumien.readInt();
            ust.jakosc_dzwieku = war;

            /* 11. Sluchawki 3D  */
            war = strumien.readInt();
            ust.sluchawki_3D = war;

        }
        catch (IOException e) {
            System.out.println("Blad strumienia");
        }

        try {
            if (strumien != null)
                strumien.close();

        } catch (IOException e) {
            System.out.println("Blad zamykania strumienia");
        }
    }
}





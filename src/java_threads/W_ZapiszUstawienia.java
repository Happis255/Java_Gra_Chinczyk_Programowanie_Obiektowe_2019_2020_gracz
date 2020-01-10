package java_threads;

import java_pliki.Ustawienia;

import java.io.*;

public class W_ZapiszUstawienia extends Thread {

    private Ustawienia ust;

    public W_ZapiszUstawienia(Ustawienia c) {
        ust = c;
    }

    /* Watek odpowiedzialny jest za utworzenie pliku i zapianiu w nim ustawien
    * odczytanych z klasy obiektu ust klasy java_pliki.Ustawienia */
    public void run() {

        DataOutputStream strumien = null;
        int war = 0;
        String filePath = ".\\settings\\setting.txt";
        String folderPath = ".\\settings";
        try {

            File plik = new File(filePath);
            File folder = new File(folderPath);
            folder.mkdir();
            plik.createNewFile();

        } catch (IOException e) {
            System.out.print("Nie mozna utworzyc pliku.");
            return;
        }

        try {
            strumien = new DataOutputStream(new FileOutputStream(filePath));
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku ustawien.");
            return;
        }

        try {
            /* 1. Rozdzielczosc */
            strumien.writeInt(ust.rozdzielczosc);

            /* 2. Jakosc grafiki */
            strumien.writeInt(ust.jakosc);

            /* 3. Tryb okna */
            strumien.writeInt(ust.tryb_okna);

            /* 4. Liczba graczy */
            strumien.writeInt(ust.liczba_graczy);

            /* 5. Kolor gracza 1 */
            strumien.writeInt(ust.kolor_1);

            /* 6. Kolor gracza 2*/
            strumien.writeInt(ust.kolor_2);

            /* 7. Kolor gracza 3 */
            strumien.writeInt(ust.kolor_3);

            /* 8. Kolor gracza 4 */
            strumien.writeInt(ust.kolor_4);

            /* 9. Glosnosc */
            strumien.writeInt(ust.glosnosc);

            /* 10. Jakosc dzwieku */
            strumien.writeInt(ust.jakosc_dzwieku);

            /* 11. Sluchawki 3D  */
            strumien.writeInt(ust.sluchawki_3D);

        } catch (IOException e) {
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


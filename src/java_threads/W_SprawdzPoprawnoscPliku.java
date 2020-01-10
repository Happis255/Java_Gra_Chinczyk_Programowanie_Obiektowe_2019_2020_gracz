package java_threads;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.Callable;

public class W_SprawdzPoprawnoscPliku implements Callable {

    public Object call() throws Exception {

        /* Otwieranie pliku z ustawieniami */
        DataInputStream strumien = null;
        int war = 0;
        int k1, k2, k3, k4 = 0;

        String filePath = ".\\settings\\setting.txt";

        try {

            strumien = new DataInputStream(new FileInputStream(filePath));

            /* 1. Rozdzielczosc - wartosc 0/1/2 */
            war = strumien.readInt();
            if (war < 0 || war > 2) return 2;
            /* 2. Jakosc grafiki - wartosc 0/1 */
            war = strumien.readInt();
            if (war < 0 || war > 1) return 2;
            /* 3. Tryb okna - wartosc 0/1 */
            war = strumien.readInt();
            if (war < 0 || war > 1) return 2;
            /* 4. Liczba graczy - wartosc 0/1/2 */
            war = strumien.readInt();
            if (war < 0 || war > 2) return 2;
            /* 5. Kolor gracza 1 - wartosc 0-8 */
            k1 = strumien.readInt();
            if (k1 < 0 || k1 > 8) return 2;
            /* 6. Kolor gracza 2 - wartosc 0-8 i inna niz g1*/
            k2 = strumien.readInt();
            if (k2 < 0 || k2 > 8) return 2;
            /* 7. Kolor gracza 3 - wartosc 0-8 i inna niz g1/g2 */
            k3 = strumien.readInt();
            if (k3 < 0 || k3 > 8) return 2;
            /* 8. Kolor gracza 4 - wartosc 0-8 i inna niz g1/g2/g3 */
            k4 = strumien.readInt();
            if (k4 < 0 || k4 > 8) return 2;
            /* 9. Glosnosc - wartosc 0-4 */
            war = strumien.readInt();
            if (war < 0 || war > 4) return 2;
            /* 10. Jakosc dzwieku - wartosc 0/1 */
            war = strumien.readInt();
            if (war < 0 || war > 1) return 2;
            /* 11. Sluchawki 3D - wartosc 0/1 */
            war = strumien.readInt();
            if (war < 0 || war > 1) return 2;
            return 1;

        } catch (FileNotFoundException e) {

            System.out.println("Nie znaleziono pliku ustawien.");
            return 0;

        } finally {

            if (strumien != null) {
                strumien.close();
            }
        }
    }
}

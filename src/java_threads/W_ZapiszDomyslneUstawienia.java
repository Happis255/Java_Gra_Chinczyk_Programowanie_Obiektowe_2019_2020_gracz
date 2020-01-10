package java_threads;

import java_pliki.Ustawienia;

public class W_ZapiszDomyslneUstawienia extends Thread {

    private Ustawienia ust;

    public W_ZapiszDomyslneUstawienia(Ustawienia c) {
        ust = c;
    }

    /* Watek odpowiedzialny jest za resetowanie ustawien obiektu java_pliki.Ustawienia */
    public void run() {

            /* Resetowanie ustawien */
            ust.rozdzielczosc = 0;
            ust.jakosc = 0;
            ust.tryb_okna = 0;
            ust.liczba_graczy = 2;
            ust.kolor_1 = 0;
            ust.kolor_2 = 1;
            ust.kolor_3 = 2;
            ust.kolor_4 = 3;
            ust.glosnosc = 4;
            ust.jakosc_dzwieku = 0;
            ust.sluchawki_3D = 1;
    }
}
package java_pliki;

import java_threads.W_SprawdzPoprawnoscPliku;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Ustawienia {

    /* Czesc graficzna */
    public int rozdzielczosc;
    public int jakosc;
    public int tryb_okna;

    /* Czesc rozgrywki */
    public int liczba_graczy;
    public int kolor_1;
    public int kolor_2;
    public int kolor_3;
    public int kolor_4;

    /* Czesc muzyki */
    public int glosnosc;
    public int jakosc_dzwieku;
    public int sluchawki_3D;

    /* Tablica przechowywujaca nazwy danych opcji */
    public String [][]settings_tab = new String[11][];

    public Ustawienia(){
        this.settings_tab[0] = new String[3];  //rozdzielczosc
        this.settings_tab[1] = new String[2];  //jakosc
        this.settings_tab[2] = new String[2];  //tryb okna
        this.settings_tab[3] = new String[3];  //liczba graczy
        this.settings_tab[4] = new String[9]; // kolor dla gracza 1
        this.settings_tab[5] = new String[9]; // kolor dla gracza 2
        this.settings_tab[6] = new String[9]; // kolor dla gracza 3
        this.settings_tab[7] = new String[9]; // kolor dla gracza 4
        this.settings_tab[8] = new String[5];  //glosnosc
        this.settings_tab[9] = new String[2];  //jakosc dzwieku
        this.settings_tab[10] = new String[2]; //sluchawki 3D

        /* Wprowadzenie odpowiednich nazw dla danych opcji */
        /* Czesc graficzna */
        this.settings_tab[0][0] = "1920x1080";
        this.settings_tab[0][1] = "1280x720";
        this.settings_tab[0][2] = "1600x900";
        this.settings_tab[1][0] = "Niska";
        this.settings_tab[1][1] = "Wysoka";
        this.settings_tab[2][0] = "W oknie";
        this.settings_tab[2][1] = "Pelny ekran";

        /* Czesc rozgrywki */
        this.settings_tab[3][0] = "2";
        this.settings_tab[3][1] = "3";
        this.settings_tab[3][2] = "4";

        this.settings_tab[4][0] = this.settings_tab[5][0] = this.settings_tab[6][0] = this.settings_tab[7][0] = "Niebieski";
        this.settings_tab[4][1] = this.settings_tab[5][1] = this.settings_tab[6][1] = this.settings_tab[7][1] = "Zielony";
        this.settings_tab[4][2] = this.settings_tab[5][2] = this.settings_tab[6][2] = this.settings_tab[7][2] = "Czerwony";
        this.settings_tab[4][3] = this.settings_tab[5][3] = this.settings_tab[6][3] = this.settings_tab[7][3] = "Rozowy";
        this.settings_tab[4][4] = this.settings_tab[5][4] = this.settings_tab[6][4] = this.settings_tab[7][4] = "Fioletowy";
        this.settings_tab[4][5] = this.settings_tab[5][5] = this.settings_tab[6][5] = this.settings_tab[7][5] = "Pomaranczowy";
        this.settings_tab[4][6] = this.settings_tab[5][6] = this.settings_tab[6][6] = this.settings_tab[7][6] = "Blekitny";
        this.settings_tab[4][7] = this.settings_tab[5][7] = this.settings_tab[6][7] = this.settings_tab[7][7] = "Gradient Niebiesko-Magneta";
        this.settings_tab[4][8] = this.settings_tab[5][8] = this.settings_tab[6][8] = this.settings_tab[7][8] = "Gradient Zolto-Pomaranczowy";

        /* Czesc muzyki */
        this.settings_tab[8][0] = "0%";
        this.settings_tab[8][1] = "25%";
        this.settings_tab[8][2] = "50%";
        this.settings_tab[8][3] = "75%";
        this.settings_tab[8][4] = "100%";

        this.settings_tab[9][0] = "Niska";
        this.settings_tab[9][1] = "Wysoka";

        this.settings_tab[10][0] = "Tak";
        this.settings_tab[10][1] = "Nie";
    }

    public void m_ustaw_default(){
        this.rozdzielczosc = 0;
        this.jakosc = 1;
        this.tryb_okna = 1;
        this.liczba_graczy = 0;
        this.kolor_1 = 0;
        this.kolor_2 = 1;
        this.kolor_3 = 2;
        this.kolor_4 = 3;
        this.glosnosc = 5;
        this.jakosc_dzwieku = 1;
        this.sluchawki_3D = 1;
    }

    /* Metoda pozwalajaca na okreslenie sytuacji zwiazanej z plikiem ustawien, zwraca:
     - 0 gdy plik nie zostal znaleziony
     - 1 gdy zostal znaleziony i zawiera poprawne dane
     - 2 gdy zostal znaleziony ale zawiera bledne dane */
    public int m_pierwsze_uruchomienie() {

        int result = 0;

        Callable sprawdzanie_pliku = new W_SprawdzPoprawnoscPliku();
        FutureTask ft = new FutureTask(sprawdzanie_pliku);
        Thread t = new Thread(ft);
        t.start();

        /* Odczytywanie wyniku watku */
        try {
            result = (int) ft.get();
        } catch (ExecutionException | InterruptedException e) {
            System.out.println("Nastapil blad...");
        }
        return result;
    }

}

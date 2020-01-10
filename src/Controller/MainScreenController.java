package Controller;

import java_pliki.Rozgrywka;
import java_pliki.Ustawienia;
import java_threads.W_WczytajUstawienia;
import java_threads.W_ZapiszDomyslneUstawienia;
import java_threads.W_ZapiszUstawienia;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class MainScreenController {

    /* Przechowuje dane dot. ustawień gry */
    private Ustawienia ustawienia;

    /* Informacje o rozgrywce */
    private Rozgrywka rozgrywka;

    public Rozgrywka getRozgrywka() {
        return rozgrywka;
    }

    public void setRozgrywka(Rozgrywka rozgrywka){
        this.rozgrywka = rozgrywka;
    }

    @FXML
    private StackPane MainStackPane;

    @FXML
    public void initialize(){
        loadSettings();
        switchScreen("menu", true);
    }

    public Ustawienia getUstawienia() {
        return ustawienia;
    }

    public void setUstawienia(Ustawienia ustawienia) {
        this.ustawienia = ustawienia;
    }

    /* Animacja przejścia okien z białego ekranu do ekranu normalnego */
    public static void FadeIn(int time, Node X){
        FadeTransition fadein = new FadeTransition();
        fadein.setDuration(Duration.millis(time));
        fadein.setNode(X);
        fadein.setFromValue(0);
        fadein.setToValue(1);
        fadein.play();
    }

    /* Metoda odpowiedzialna za ładowanie nowego okna aplikacji */
    public void setScreen(Pane pane){
        MainStackPane.getChildren().clear();
        MainStackPane.getChildren().add(pane);
    }

    /* Metoda odpowiedzialna za ładowanie ustawień aplikacji podczas pierwszego uruchomienia */
    private void loadSettings() {

        /* Sprawdzanie, czy istnieje plik z ustawieniami. Jeśli nie, utworzony zostanie domyślni plik,
        jeśli jednak plik istnieje - wczytane zostaną ostatnio zapisane zmiany */
        ustawienia = new Ustawienia();
        int status_ustawien = ustawienia.m_pierwsze_uruchomienie();                                //SPRAWDZANIE

        if (status_ustawien == 1) {

            /* Uruchomienie watku zapisujacego odczytane dane z pliku do obiektu */
            W_WczytajUstawienia wczytywanie = new W_WczytajUstawienia(ustawienia);                 //WCZYYWANIE
            wczytywanie.start();
            /* Oczekiwanie na zakonczenie watku i powiadomienie */
            try {
                wczytywanie.join();
            } catch (InterruptedException e){
                System.out.println("Blad 0001");
            }
            System.out.print("Wczytano ustawienia");
        } else {

            /* Ustawienie ustawien na wartosci domyslne i zapisanie ich w pliku */
            W_ZapiszDomyslneUstawienia resetowanie = new W_ZapiszDomyslneUstawienia(ustawienia);  //RESETOWANIE
            W_ZapiszUstawienia zapisywanie = new W_ZapiszUstawienia(ustawienia);                  //TWORZENIE PLIKU

            resetowanie.start();

            /* Oczekiwanie na zakonczenie watkow */
            try {
                resetowanie.join();
            } catch (InterruptedException e){
                System.out.println("Blad 0001");
            }

            zapisywanie.start();

            try {
                zapisywanie.join();
            } catch (InterruptedException e){
                System.out.println("Blad 0001");
            }
            /* Powiadomienie */
            System.out.print("Zresetowano ustawienia oraz utworzono nowy plik z ustawieniami");
        }
    }

    /* Zwraca odpowiedni FXMLLoader określony przez Stringa */
    public FXMLLoader getFXMLLoader(String loaderResource){
        FXMLLoader loader = null;
        if (loaderResource.equals("menu"))
            loader = new FXMLLoader(this.getClass().getResource("/fxml/Menu.fxml"));
        if (loaderResource.equals("wyniki"))
            loader = new FXMLLoader(this.getClass().getResource("/fxml/Tabela_Wyników.fxml"));
        if (loaderResource.equals("ustawienia"))
            loader = new FXMLLoader(this.getClass().getResource("/fxml/Ustawienia.fxml"));
        if (loaderResource.equals("gra"))
            loader = new FXMLLoader(this.getClass().getResource("/fxml/Gra.fxml"));
        if (loader == null) loader = new FXMLLoader(this.getClass().getResource("/fxml/Menu.fxml"));
        return loader;
    }

    /* Metoda odpowiedzialna za ładowanie nowego okna aplikacji */
    public void switchScreen(String loaderResource, boolean fadeAnimation){

        FXMLLoader loader = getFXMLLoader(loaderResource);
        Pane pane = null;

        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* Tworzenie odpowiedniego controllera */
        /* Tworzenie kontrolera menu */
        if (loaderResource.equals("menu")){
            MenuScreenController menuController = loader.getController();
            menuController.setMainController(this);
        }

        /* Tworzenie kontrolera tabeli wynikow */
        if (loaderResource.equals("wyniki")) {
            WynikiController menuController = loader.getController();
            menuController.setMainController(this);
            menuController.load_results();
        }

        /* Tworzenie kontrolera ustawien */
        if (loaderResource.equals("ustawienia")) {
            UstawieniaController menuController = loader.getController();
            menuController.load_settings();
            menuController.setMainController(this);
            menuController.readSettings();
        }

        if (loaderResource.equals("gra")) {
            GameController menuController = loader.getController();
            menuController.setMainController(this);
            menuController.setRozgrywka(this.rozgrywka);
            menuController.graStart();
        }

        setScreen(pane);
        if (fadeAnimation) {
            FadeIn(3000, MainStackPane.getChildren().get(0));
        }
    }

    /* Służy do odświeżania okna po załadowaniu wyników danego gracza w tabeli wyników */
    public void switchScreenPlayer(String nick){

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/Tabela_Wyników.fxml"));
        Pane pane = null;

        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        WynikiController wyniki = loader.getController();
        wyniki.load_playerResults(nick);
        wyniki.setMainController(this);
        setScreen(pane);
    }

    /* Honks! */
    static void gooseHonking() {
        Random rand = new Random();
        int rand_int = rand.nextInt(3);
        String musicFile = null;

        switch (rand_int){
            case 0: musicFile = "src/multimedia/h1.mp3";
                break;
            case 1: musicFile = "src/multimedia/h2.mp3";
                break;
            case 2: musicFile = "src/multimedia/h3.mp3";
        }
        System.out.println(rand_int);
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }
}

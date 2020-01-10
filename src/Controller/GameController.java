package Controller;

import java_pliki.Gracz;
import java_pliki.Rozgrywka;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class GameController {

    public ImageView pionek1_1;
    public ImageView pionek1_2;
    public ImageView pionek1_3;
    public ImageView pionek1_4;

    public ImageView pionek2_1;
    public ImageView pionek2_2;
    public ImageView pionek2_3;
    public ImageView pionek2_4;

    public ImageView pionek3_1;
    public ImageView pionek3_3;
    public ImageView pionek3_2;
    public ImageView pionek3_4;

    public ImageView pionek4_1;
    public ImageView pionek4_2;
    public ImageView pionek4_3;
    public ImageView pionek4_4;

    private ImageView tablica_pionkow[][] = new ImageView[4][4];

    public Text nazwa_gracza_3;
    public Text nazwa_gracza_2;
    public Text nazwa_gracza_4;
    public Text nazwa_gracza_1;

    public Text Informacja_Big;
    public Text info_kostka;

    private MainScreenController mainController;
    public void setMainController(MainScreenController mainController) {
        this.mainController = mainController;
    }

    /* Informacje o rozgrywce */
    private Rozgrywka rozgrywka;

    public Rozgrywka getRozgrywka() {
        return rozgrywka;
    }

    public void setRozgrywka(Rozgrywka rozgrywka){
        this.rozgrywka = rozgrywka;
    }

    private void set_wartosc_kostki(int a) {
        info_kostka.setText("Wyrzocono: " + a);
    }

    private int odczytaj_kosc() {
        int a = 0;
        try {
            a = (Integer) rozgrywka.getDis().readObject();
        } catch (Exception e){
            e.printStackTrace();
        }
        return a;
    }

    public void graStart(){

        System.out.println(mainController);
        Gracz[] tablica_graczy = new Gracz[4];
        tablica_graczy = rozgrywka.getTab_g();

        nazwa_gracza_1.setText(tablica_graczy[0].getNazwa_gracza());
        nazwa_gracza_2.setText(tablica_graczy[1].getNazwa_gracza());
        nazwa_gracza_3.setText(tablica_graczy[2].getNazwa_gracza());
        nazwa_gracza_4.setText(tablica_graczy[3].getNazwa_gracza());
        int wyrzucona_kostka = 0;

        Informacja_Big.setText("Zaczyna gracz pierwszy!");

        /* Odczytywanie kostki */

        wyrzucona_kostka = odczytaj_kosc();
        set_wartosc_kostki(wyrzucona_kostka);

        setTablicaPionkow();
        refreshPionki();
    }

    private void setTablicaPionkow(){

        tablica_pionkow[0][0] = pionek1_1;
        tablica_pionkow[0][1] = pionek1_2;
        tablica_pionkow[0][2] = pionek1_3;
        tablica_pionkow[0][3] = pionek1_4;

        tablica_pionkow[1][0] = pionek2_1;
        tablica_pionkow[1][1] = pionek2_2;
        tablica_pionkow[1][2] = pionek2_3;
        tablica_pionkow[1][3] = pionek2_4;

        tablica_pionkow[2][0] = pionek3_1;
        tablica_pionkow[2][1] = pionek3_2;
        tablica_pionkow[2][2] = pionek3_3;
        tablica_pionkow[2][3] = pionek3_4;

        tablica_pionkow[3][0] = pionek4_1;
        tablica_pionkow[3][1] = pionek4_2;
        tablica_pionkow[3][2] = pionek4_3;
        tablica_pionkow[3][3] = pionek4_4;


    }

    private void refreshPionki() {
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){

                System.out.println(rozgrywka.getTab_p()[rozgrywka.getTab_g()[i].getTablica_pionkow()[j].getNumer_pola()].getPosition_x());
                System.out.println(rozgrywka.getTab_p()[rozgrywka.getTab_g()[i].getTablica_pionkow()[j].getNumer_pola()].getPosition_y());

                tablica_pionkow[i][j].setLayoutX(rozgrywka.getTab_p()[rozgrywka.getTab_g()[i].getTablica_pionkow()[j].getNumer_pola()].getPosition_x());
                tablica_pionkow[i][j].setLayoutY(rozgrywka.getTab_p()[rozgrywka.getTab_g()[i].getTablica_pionkow()[j].getNumer_pola()].getPosition_y());
            }
        }
    }
}

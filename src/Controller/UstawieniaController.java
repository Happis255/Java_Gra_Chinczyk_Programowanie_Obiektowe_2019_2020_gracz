package Controller;

import java_threads.W_ZapiszDomyslneUstawienia;
import java_threads.W_ZapiszUstawienia;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class UstawieniaController {

    @FXML
    public Text opcja1;
    @FXML
    public Text opcja2;
    @FXML
    public Text opcja3;
    @FXML
    public Text opcja4;
    @FXML
    public Text opcja5;
    @FXML
    public Text opcja6;
    @FXML
    public Text opcja7;
    @FXML
    public Text opcja8;
    @FXML
    public Text opcja9;
    @FXML
    public Text opcja10;
    @FXML
    public Text opcja11;

    private MainScreenController mainController;
    public void setMainController(MainScreenController mainController) {
        this.mainController = mainController;
    }

    public void readSettings(){
        opcja1.setText("1.  Rozdzielczosc: " + mainController.getUstawienia().settings_tab[0][mainController.getUstawienia().rozdzielczosc]);
        opcja2.setText("2.  Jakosc grafiki: " + mainController.getUstawienia().settings_tab[1][mainController.getUstawienia().jakosc]);
        opcja3.setText("3.  Tryb okna: " + mainController.getUstawienia().settings_tab[2][mainController.getUstawienia().tryb_okna]);
        opcja4.setText("4.  Liczba graczy: " + mainController.getUstawienia().settings_tab[3][mainController.getUstawienia().liczba_graczy]);
        opcja5.setText("5.  Kolor gracza #1: " + mainController.getUstawienia().settings_tab[4][mainController.getUstawienia().kolor_1]);
        opcja6.setText("6.  Kolor gracza #2: " + mainController.getUstawienia().settings_tab[5][mainController.getUstawienia().kolor_2]);
        opcja7.setText("7.  Kolor gracza #3: " + mainController.getUstawienia().settings_tab[6][mainController.getUstawienia().kolor_3]);
        opcja8.setText("8.  Kolor gracza #4: " + mainController.getUstawienia().settings_tab[7][mainController.getUstawienia().kolor_4]);
        opcja9.setText("9.  Poziom glosnosci: " + mainController.getUstawienia().settings_tab[8][mainController.getUstawienia().glosnosc]);
        opcja10.setText("10. Jakosc dzwieku: " + mainController.getUstawienia().settings_tab[9][mainController.getUstawienia().jakosc_dzwieku]);
        opcja11.setText("11. Obsluga sluchawek 3D: " + mainController.getUstawienia().settings_tab[10][mainController.getUstawienia().sluchawki_3D]);
    }

    public void initialize(){

    }

    @FXML // ustawienie opcji 1
    public void grafika_l(MouseEvent mouseEvent) {

        mainController.getUstawienia().rozdzielczosc--;
        if (mainController.getUstawienia().rozdzielczosc == -1)
            mainController.getUstawienia().rozdzielczosc = 2;

        /* Odswiez ekran */
        mainController.switchScreen("ustawienia", false);
    }

    @FXML // ustawienie opcji 1
    public void grafika_p(MouseEvent mouseEvent) {

        mainController.getUstawienia().rozdzielczosc++;
        if (mainController.getUstawienia().rozdzielczosc == 3)
            mainController.getUstawienia().rozdzielczosc = 0;

        /* Odswiez ekran */
        mainController.switchScreen("ustawienia", false);
    }

    @FXML // ustawienie opcji 2
    public void jakosc_l(MouseEvent mouseEvent) {

        mainController.getUstawienia().jakosc--;
        if (mainController.getUstawienia().jakosc == -1)
            mainController.getUstawienia().jakosc = 1;

        /* Odswiez ekran */
        mainController.switchScreen("ustawienia", false);
    }

    @FXML // ustawienie opcji 2
    public void jakosc_p(MouseEvent mouseEvent) {

        mainController.getUstawienia().jakosc++;
        if (mainController.getUstawienia().jakosc == 2)
            mainController.getUstawienia().jakosc = 0;

        /* Odswiez ekran */
        mainController.switchScreen("ustawienia", false);
    }

    @FXML // ustawienie opcji 3
    public void okno_l(MouseEvent mouseEvent) {

        mainController.getUstawienia().tryb_okna--;
        if (mainController.getUstawienia().tryb_okna == -1)
            mainController.getUstawienia().tryb_okna = 1;

        /* Odswiez ekran */
        mainController.switchScreen("ustawienia", false);
    }

    @FXML // ustawienie opcji 3
    public void okno_p(MouseEvent mouseEvent) {

        mainController.getUstawienia().tryb_okna++;
        if (mainController.getUstawienia().tryb_okna == 2)
            mainController.getUstawienia().tryb_okna = 0;

        /* Odswiez ekran */
        mainController.switchScreen("ustawienia", false);
    }

    @FXML // ustawienie opcji 4
    public void liczba_l(MouseEvent mouseEvent) {

        mainController.getUstawienia().liczba_graczy--;
        if (mainController.getUstawienia().liczba_graczy == -1)
            mainController.getUstawienia().liczba_graczy = 2;

        /* Odswiez ekran */
        mainController.switchScreen("ustawienia", false);
    }

    @FXML // ustawienie opcji 4
    public void liczba_p(MouseEvent mouseEvent) {

        mainController.getUstawienia().liczba_graczy++;
        if (mainController.getUstawienia().liczba_graczy == 3)
            mainController.getUstawienia().liczba_graczy = 0;

        /* Odswiez ekran */
        mainController.switchScreen("ustawienia", false);
    }

    @FXML // ustawienie opcji 5
    public void gracz_1_l(MouseEvent mouseEvent) {

        mainController.getUstawienia().kolor_1--;
        if (mainController.getUstawienia().kolor_1 == -1)
            mainController.getUstawienia().kolor_1 = 8;

        /* Odswiez ekran */
        mainController.switchScreen("ustawienia", false);
    }

    @FXML // ustawienie opcji 5
    public void gracz_1_p(MouseEvent mouseEvent) {

        mainController.getUstawienia().kolor_1++;
        if (mainController.getUstawienia().kolor_1 == 9)
            mainController.getUstawienia().kolor_1 = 0;

        /* Odswiez ekran */
        mainController.switchScreen("ustawienia", false);
    }

    @FXML // ustawienie opcji 6
    public void gracz_2_l(MouseEvent mouseEvent) {

        mainController.getUstawienia().kolor_2--;
        if (mainController.getUstawienia().kolor_2 == -1)
            mainController.getUstawienia().kolor_2 = 8;

        /* Odswiez ekran */
        mainController.switchScreen("ustawienia", false);
    }

    @FXML // ustawienie opcji 6
    public void gracz_2_p(MouseEvent mouseEvent) {

        mainController.getUstawienia().kolor_2++;
        if (mainController.getUstawienia().kolor_2 == 9)
            mainController.getUstawienia().kolor_2 = 0;

        /* Odswiez ekran */
        mainController.switchScreen("ustawienia", false);
    }

    @FXML // ustawienie opcji 7
    public void gracz_3_l(MouseEvent mouseEvent) {

        mainController.getUstawienia().kolor_3--;
        if (mainController.getUstawienia().kolor_3 == -1)
            mainController.getUstawienia().kolor_3 = 8;

        /* Odswiez ekran */
        mainController.switchScreen("ustawienia", false);
    }

    @FXML // ustawienie opcji 7
    public void gracz_3_p(MouseEvent mouseEvent) {

        mainController.getUstawienia().kolor_3++;
        if (mainController.getUstawienia().kolor_3 == 9)
            mainController.getUstawienia().kolor_3 = 0;

        /* Odswiez ekran */
        mainController.switchScreen("ustawienia", false);
    }

    @FXML // ustawienie opcji 8
    public void gracz_4_l(MouseEvent mouseEvent) {

        mainController.getUstawienia().kolor_4--;
        if (mainController.getUstawienia().kolor_4 == -1)
            mainController.getUstawienia().kolor_4 = 8;

        /* Odswiez ekran */
        mainController.switchScreen("ustawienia", false);
    }

    @FXML  // ustawienie opcji 8
    public void gracz_4_p(MouseEvent mouseEvent) {

        mainController.getUstawienia().kolor_4++;
        if (mainController.getUstawienia().kolor_4 == 9)
            mainController.getUstawienia().kolor_4 = 0;

        /* Odswiez ekran */
        mainController.switchScreen("ustawienia", false);
    }

    @FXML // ustawienie opcji 9
    public void muzyka_l(MouseEvent mouseEvent) {

        mainController.getUstawienia().glosnosc--;
        if (mainController.getUstawienia().glosnosc == -1)
            mainController.getUstawienia().glosnosc = 4;

        /* Odswiez ekran */
        mainController.switchScreen("ustawienia", false);
    }

    @FXML // ustawienie opcji 9
    public void muzyka_p(MouseEvent mouseEvent) {

        mainController.getUstawienia().glosnosc++;
        if (mainController.getUstawienia().glosnosc == 5)
            mainController.getUstawienia().glosnosc = 0;

        /* Odswiez ekran */
        mainController.switchScreen("ustawienia", false);
    }

    @FXML // ustawienie opcji 10
    public void muzyka_jakosc_l(MouseEvent mouseEvent) {

        mainController.getUstawienia().jakosc_dzwieku--;
        if (mainController.getUstawienia().jakosc_dzwieku == -1)
            mainController.getUstawienia().jakosc_dzwieku = 1;

        /* Odswiez ekran */
        mainController.switchScreen("ustawienia", false);
    }

    @FXML // ustawienie opcji 10
    public void muzyka_jakosc_p(MouseEvent mouseEvent) {

        mainController.getUstawienia().jakosc_dzwieku++;
        if (mainController.getUstawienia().jakosc_dzwieku == 2)
            mainController.getUstawienia().jakosc_dzwieku = 0;

        /* Odswiez ekran */
        mainController.switchScreen("ustawienia", false);
    }

    @FXML // ustawienie opcji 11
    public void obsluga3d_l(MouseEvent mouseEvent) {

        mainController.getUstawienia().sluchawki_3D--;
        if (mainController.getUstawienia().sluchawki_3D == -1)
            mainController.getUstawienia().sluchawki_3D = 1;

        /* Odswiez ekran */
        mainController.switchScreen("ustawienia", false);
    }

    @FXML // ustawienie opcji 11
    public void obsluga3d_p(MouseEvent mouseEvent) {

        mainController.getUstawienia().sluchawki_3D++;
        if (mainController.getUstawienia().sluchawki_3D == 2)
            mainController.getUstawienia().sluchawki_3D = 0;

        /* Odswiez ekran */
        mainController.switchScreen("ustawienia", false);
    }

    @FXML //ustawia ustawienia defaultowe
    public void setDef(ActionEvent actionEvent) {
        W_ZapiszDomyslneUstawienia resetowanie = new W_ZapiszDomyslneUstawienia(mainController.getUstawienia());
        resetowanie.start();
        try {
            resetowanie.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainController.switchScreen("ustawienia", false);
    }

    @FXML //powrót do menu
    public void backToMenu(ActionEvent actionEvent) {

        /* Zapisujemy ustawienia do pliku */
        W_ZapiszUstawienia zapisywanie = new W_ZapiszUstawienia(mainController.getUstawienia());
        zapisywanie.start();

        try {
            zapisywanie.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        /* Powrot do menu */
        mainController.switchScreen("menu", true);
    }

    @FXML
    public void gooseHonks(MouseEvent mouseEvent) {
        MainScreenController.gooseHonking();
    }

    public void load_settings() {
    }
}

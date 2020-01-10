package Controller;

import java_pliki.Gracz;
import java_pliki.Pola;
import java_pliki.Rozgrywka;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class MenuScreenController {

    public TextField player_nick;
    private MainScreenController mainController;
    InetAddress inetAddres;
    Socket socket;

    public void setMainController(MainScreenController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void OpenResults(){
        mainController.switchScreen("wyniki", true);
    }

    @FXML
    public void OpenSettings(){
        mainController.switchScreen("ustawienia", true);
    }

    @FXML
    public void exit(){
        Platform.exit();
        System.exit(0);
    }

    @FXML
    public void StartGame(){

        String player_name = player_nick.getText();
        System.out.println(player_name);
        if (player_name.length() > 0){
            try {
                gameInit(player_name);
                mainController.switchScreen("gra", true);
            } catch (IOException e) {
                e.printStackTrace();
                mainController.switchScreen("menu", true);
            }
        }
}

    private void gameInit(String player_name) throws IOException {
        Rozgrywka kontroler_gry = new Rozgrywka();
        try {

            this.inetAddres = InetAddress.getByName("localhost");
            this.socket= new Socket(inetAddres, 5056);

            ObjectOutputStream dos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream dis = new ObjectInputStream(socket.getInputStream());

            kontroler_gry.setNumer_gracza((Integer) dis.readObject());

            System.out.println("Nadano mi numer: " + kontroler_gry.getNumer_gracza());

            /* Wysyłamy nazwe naszego gracza */
            dos.writeObject(player_name);
            dos.flush();
            Gracz [] tablica_graczy = new Gracz[4];

            /* Pobieramy dane o pozostalych graczach w grze */

            for (int i = 0; i < 4; i++) {
                tablica_graczy[i] = (Gracz) dis.readObject();
            }

            kontroler_gry.setTab_g(tablica_graczy);

            for (int i = 0; i < 4; i++) {
                System.out.println("W grze znajduje się: " +  kontroler_gry.getTab_g()[i]);
            }

            /* Pobieram dane o polach */
            Pola[] tab_pola = new Pola[72];
            for (int i = 0; i < 72; i++){
               tab_pola[i] = (Pola) dis.readObject();
            }
            kontroler_gry.setTab_p(tab_pola);

            for (int i = 0; i < 72; i++) {
                System.out.println("W grze mamy pola: " +  kontroler_gry.getTab_p()[i] + kontroler_gry.getTab_p()[i].getPosition_x() + kontroler_gry.getTab_p()[i].getPosition_y());
            }

            kontroler_gry.setDis(dis);
            kontroler_gry.setDos(dos);

            mainController.setRozgrywka(kontroler_gry);

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    public void goose_honk(){
        MainScreenController.gooseHonking();
    }

    private static Pola[]  m_odczytaj_pola(Pola tab_p[], ObjectInputStream object_dis) throws IOException, ClassNotFoundException {
        tab_p = (Pola[]) object_dis.readObject();
        return tab_p;
    }

    private static Gracz[] m_odczytaj_Graczy(Gracz[] tab_graczy, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        tab_graczy = new Gracz[4];
        tab_graczy = (Gracz[]) objectInputStream.readObject();
        return tab_graczy;
    }

}

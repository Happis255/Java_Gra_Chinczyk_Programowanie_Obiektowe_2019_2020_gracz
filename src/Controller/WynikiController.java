package Controller;

import java_pliki.DataBaseConnector;
import java_pliki.ModelTabeli;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class WynikiController {

    @FXML
    public TextField player_nick;

    @FXML
    public TableView <ModelTabeli> tabela_wynikow;

    @FXML
    public TableColumn <ModelTabeli, String> nazwa_gracza;

    @FXML
    public TableColumn <ModelTabeli, Integer> wynik;

    @FXML
    public TableColumn <ModelTabeli, Integer> id_wyniku;

    @FXML
    public TableColumn <ModelTabeli, Date> data;

    @FXML
    private MainScreenController mainController;

    private ObservableList<ModelTabeli> lista_danych = FXCollections.observableArrayList();

    public void setMainController(MainScreenController mainController) {
        this.mainController = mainController;
    }

    /* Otworzenie tabeli wynikow - zaladowanie top 10 do tabeli */
    public void initialize(){
    }

    public void load_results(){
        DataBaseConnector dbmanager = new DataBaseConnector();
        try {
            ResultSet resultSet = dbmanager.getTopFull();
            while(resultSet.next()){
                lista_danych.add(new ModelTabeli(
                        resultSet.getInt("id_wyniku"),
                        resultSet.getDate("data"),
                        resultSet.getString("nazwa_gracza"),
                        resultSet.getInt("wynik")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        setCellValuesFactory();
    }

    public void load_playerResults(String nick){
        DataBaseConnector dbmanager = new DataBaseConnector();
        try {
            ResultSet resultSet = dbmanager.getResultNickname(nick);
            lista_danych.clear();
            while(resultSet.next()){
                lista_danych.add(new ModelTabeli(
                        resultSet.getInt("id_wyniku"),
                        resultSet.getDate("data"),
                        resultSet.getString("nazwa_gracza"),
                        resultSet.getInt("wynik")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        setCellValuesFactory();
    }

    private void setCellValuesFactory() {
        nazwa_gracza.setCellValueFactory(new PropertyValueFactory<>("nazwa_gracza"));
        wynik.setCellValueFactory(new PropertyValueFactory<>("wynik"));
        id_wyniku.setCellValueFactory(new PropertyValueFactory<>("id_wyniku"));
        data.setCellValueFactory(new PropertyValueFactory<>("data"));
        tabela_wynikow.setItems(lista_danych);
    }


    @FXML //powrót do menu
    public void backToMenu(){
        mainController.switchScreen("menu", true);
    }

    @FXML //wyswietlenie punktów wybranego gracza
    public void OpenResults(){
        String nick = player_nick.getText();
        if (nick != null){
            mainController.switchScreenPlayer(nick);
        }
    }

    @FXML //usuwanie wybranego row'a
    public void RemoveResult(){
        /* Pobieramy zaznaczony row */
        ModelTabeli zaznaczony = tabela_wynikow.getSelectionModel().getSelectedItem();
        if (zaznaczony != null) {
            int id_do_usuniecia = zaznaczony.getId_wyniku();

            /* Wywolujemy usuwanie row'a */
            DataBaseConnector dbmanager = new DataBaseConnector();
            try {
                dbmanager.deleteResult(id_do_usuniecia);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            /* Odswiezamy widok */
            mainController.switchScreen("wyniki", false);
        }
    }

    public void gooseHonks() {
        MainScreenController.gooseHonking();
        mainController.switchScreen("wyniki", false);
    }
}


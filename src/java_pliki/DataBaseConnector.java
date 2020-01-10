package java_pliki;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class DataBaseConnector {
    protected Connection connection;
    protected HashMap<String, PreparedStatement> statements;

    public DataBaseConnector(){
        connection = DataBaseManager.getConnection();
        statements = DataBaseManager.getStatements();
    }

    /* Metoda odpowiedzialna za dodawanie wyniku do bazy danych */
    public void addResult(String kolor, int wynik) throws SQLException {

        PreparedStatement exeStatement;
        exeStatement = statements.get("dodaj_wynik");
        exeStatement.setString(1, kolor);
        exeStatement.setInt(2, wynik);
        exeStatement.executeUpdate();
    }

    /* Metoda odpowiedzialna za pobieranie wyników z bazy danych w kolejności ilości punktów */
    public ResultSet getTopFull() throws SQLException {

        PreparedStatement exeStatement;
        ResultSet resultSet;
        exeStatement = statements.get("top_10");
        resultSet = exeStatement.executeQuery();

        return resultSet;
    }

    /* *Pobieranie wyniku gracza o wybranym kolorze */
    public ResultSet getResultNickname(String nick_gracza) throws SQLException {

        PreparedStatement exeStatement;
        ResultSet resultSet;
        exeStatement = statements.get("pokaz_wynik_graczy");
        exeStatement.setString(1, nick_gracza);
        resultSet = exeStatement.executeQuery();
        return resultSet;
    }

    /* Metoda odpowiedzialna za usuwanie wyniku o podanym ID */
    public void deleteResult(int id) throws SQLException {

        PreparedStatement exeStatement;
        exeStatement = statements.get("usun_wynik");
        exeStatement.setInt(1, id);
        exeStatement.executeUpdate();
    }

}
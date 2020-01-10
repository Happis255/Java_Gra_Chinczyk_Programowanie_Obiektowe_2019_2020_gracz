package java_pliki;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

public class DataBaseManager {
    private final static String DB_URL = "jdbc:mysql://127.0.0.1:3306/chinczyk";
    private final static String USER_NAME = "root";
    private final static String USER_PASSWD = "";
    private final static String DB_DRIVER = "com.mysql.jdbc.Driver";

    private static Connection connection;
    private static HashMap<String, PreparedStatement> statements;

    static{
        try {
            Class.forName(DB_DRIVER);
            statements = new HashMap<>();
            connection = DriverManager.getConnection(DB_URL, USER_NAME, USER_PASSWD);

            /* Stejtmenty */

            /* 1. Pobierz z tabeli wyników top 10tki */
            statements.put("top_10", connection.prepareStatement("{call wyswietl_top()}"));

            /* 2. Pobierz z tabeli wyniki gracza o kolorze = x */
            statements.put("pokaz_wynik_graczy", connection.prepareStatement("{call wyswietl_gracza(?)}"));

            /* 3. Załaduj do bazy danych wynik z wybranego meczu */
            statements.put("dodaj_wynik", connection.prepareStatement("{call dodaj_wynik(?, ?)}"));

            /* 4. Usuń z bazy danych dany wynik o id = x*/
            statements.put("usun_wynik", connection.prepareStatement("{call usun(?)}"));

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String, PreparedStatement> getStatements(){
        return statements;
    }

    public static Connection getConnection(){
        return connection;
    }
}

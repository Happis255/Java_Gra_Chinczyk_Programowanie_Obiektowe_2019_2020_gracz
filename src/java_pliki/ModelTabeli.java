package java_pliki;

import java.util.Date;

public class ModelTabeli {

    public ModelTabeli(int id_wyniku, Date data, String nazwa_gracza, int wynik) {
        this.nazwa_gracza = nazwa_gracza;
        this.wynik = wynik;
        this.id_wyniku = id_wyniku;
        this.data = data;
    }

    public String getNazwa_gracza() {
        return nazwa_gracza;
    }

    public void setNazwa_gracza(String nazwa_gracza) {
        this.nazwa_gracza = nazwa_gracza;
    }

    public int getWynik() {
        return wynik;
    }

    public void setWynik(int wynik) {
        this.wynik = wynik;
    }

    public int getId_wyniku() {
        return id_wyniku;
    }

    public void setId_wyniku(int id_wyniku) {
        this.id_wyniku = id_wyniku;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    private String nazwa_gracza;
    private int wynik;
    private int id_wyniku;
    private Date data;
}

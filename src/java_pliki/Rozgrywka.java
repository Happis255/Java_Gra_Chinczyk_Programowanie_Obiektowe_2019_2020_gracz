package java_pliki;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Rozgrywka {

    private Gracz[] tablica_graczy = new Gracz[4];
    private int numer_gracza;
    private InetAddress ip;
    private Socket s;
    private Gracz[] tab_g = new Gracz[4];
    private Pola[] tab_p = new Pola[72];

    ObjectOutputStream dos;
    ObjectInputStream dis;

    public ObjectOutputStream getDos() {
        return dos;
    }

    public void setDos(ObjectOutputStream dos) {
        this.dos = dos;
    }

    public ObjectInputStream getDis() {
        return dis;
    }

    public void setDis(ObjectInputStream dis) {
        this.dis = dis;
    }

    private Gracz[] getTablica_graczy() {
        return tablica_graczy;
    }

    public void setTablica_graczy(Gracz[] tablica_graczy) {
        this.tablica_graczy = tablica_graczy;
    }

    public int getNumer_gracza() {
        return numer_gracza;
    }

    public void setNumer_gracza(int numer_gracza) {
        this.numer_gracza = numer_gracza;
    }

    public InetAddress getIp() {
        return ip;
    }

    public void setIp(InetAddress ip) {
        this.ip = ip;
    }

    public Socket getS() {
        return s;
    }

    public void setS(Socket s) {
        this.s = s;
    }

    public Gracz[] getTab_g() {
        return tab_g;
    }

    public void setTab_g(Gracz[] tab_g) {
        this.tab_g = tab_g;
    }

    public Pola[] getTab_p() {
        return tab_p;
    }

    public void setTab_p(Pola[] tab_p) {
        this.tab_p = tab_p;
    }
}

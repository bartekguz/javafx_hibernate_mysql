package BazaDanych;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "transakcje")
public class Transakcje implements Serializable {

    private static final long serialVersionUID = -300020L;

    @Column(name = "id_transakcji", unique = true, nullable = false, columnDefinition = "bigint(6)")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_transakcji;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_klienta", nullable = false)
    private Klienci klienci;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nr_vin", nullable = false)
    private Samochody vin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pracownika", nullable = false)
    private Pracownicy pracownicy;

    @Column(name = "data_transakcji", nullable = false, columnDefinition = "varchar(100)")
    private String data_transakcji;

    @Column(name = "rodzaj_transakcji", nullable = false, columnDefinition = "varchar(100)")
    private String rodzaj_transakcji;

    public Transakcje() {
    }

    public Transakcje(Klienci klienci, Samochody vin, Pracownicy pracownicy, String data_transakcji, String rodzaj_transakcji) {
        this.klienci = klienci;
        this.vin = vin;
        this.pracownicy = pracownicy;
        this.data_transakcji = data_transakcji;
        this.rodzaj_transakcji = rodzaj_transakcji;
    }

    public long getId_transakcji() {
        return id_transakcji;
    }

    public void setId_transakcji(long id_transakcji) {
        this.id_transakcji = id_transakcji;
    }

    public Klienci getKlienci() {
        return klienci;
    }

    public void setKlienci(Klienci klienci) {
        this.klienci = klienci;
    }

    public Samochody getVin() {
        return vin;
    }

    public void setVin(Samochody vin) {
        this.vin = vin;
    }

    public Pracownicy getPracownicy() {
        return pracownicy;
    }

    public void setPracownicy(Pracownicy pracownicy) {
        this.pracownicy = pracownicy;
    }

    public String getData_transakcji() {
        return data_transakcji;
    }

    public void setData_transakcji(String data_transakcji) {
        this.data_transakcji = data_transakcji;
    }

    public String getRodzaj_transakcji() {
        return rodzaj_transakcji;
    }

    public void setRodzaj_transakcji(String rodzaj_transakcji) {
        this.rodzaj_transakcji = rodzaj_transakcji;
    }

    @Override
    public String toString() {
        return "Transakcje{" +
                "id_transakcji=" + id_transakcji +
                ", klienci=" + klienci +
                ", vin=" + vin +
                ", pracownicy=" + pracownicy +
                ", data_transakcji=" + data_transakcji +
                ", rodzaj_transakcji='" + rodzaj_transakcji + '\'' +
                '}';
    }
}

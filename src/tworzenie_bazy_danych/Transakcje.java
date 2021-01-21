package tworzenie_bazy_danych;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Transakcje")
public class Transakcje implements Serializable {

    private static final long serialVersionUID = -300020L;

    @Column(name = "id_transakcji", unique = true, nullable = false, columnDefinition = "bigint(6)")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTransakcji;

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
    private String dataTransakcji;

    @Column(name = "rodzaj_transakcji", nullable = false, columnDefinition = "varchar(100)")
    private String rodzajTransakcji;

    public Transakcje() {
    }

    public Transakcje(long idTransakcji, Klienci klienci, Samochody vin, Pracownicy pracownicy, String dataTransakcji, String rodzajTransakcji) {
        this.idTransakcji = idTransakcji;
        this.klienci = klienci;
        this.vin = vin;
        this.pracownicy = pracownicy;
        this.dataTransakcji = dataTransakcji;
        this.rodzajTransakcji = rodzajTransakcji;
    }

    public long getIdTransakcji() {
        return idTransakcji;
    }

    public void setIdTransakcji(long idTransakcji) {
        this.idTransakcji = idTransakcji;
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

    public String getDataTransakcji() {
        return dataTransakcji;
    }

    public void setDataTransakcji(String dataTransakcji) {
        this.dataTransakcji = dataTransakcji;
    }

    public String getRodzajTransakcji() {
        return rodzajTransakcji;
    }

    public void setRodzajTransakcji(String rodzajTransakcji) {
        this.rodzajTransakcji = rodzajTransakcji;
    }

    

    @Override
    public String toString() {
        return "Transakcje{" +
                "idTransakcji=" + idTransakcji +
                ", klienci=" + klienci +
                ", vin=" + vin +
                ", pracownicy=" + pracownicy +
                ", dataTransakcji=" + dataTransakcji +
                ", rodzajTransakcji='" + rodzajTransakcji + '\'' +
                '}';
    }
}

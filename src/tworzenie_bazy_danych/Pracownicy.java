package tworzenie_bazy_danych;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Pracownicy")
public class Pracownicy implements Serializable {

    private static final long serialVersionUID = -300025L;

    @Column(name = "id_pracownika", unique = true, nullable = false, columnDefinition = "bigint(6)")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_pracownika;

    @Column(name = "imie", nullable = false, columnDefinition = "varchar(100)")
    private String imie;

    @Column(name = "nazwisko", nullable = false, columnDefinition = "varchar(100)")
    private String nazwisko;

    @Column(name = "data_zatrudnienia", nullable = false, columnDefinition = "varchar(100)")
    private String data_zatrudnienia;

    @Column(name = "zarobki", nullable = false, columnDefinition = "bigint(100)")
    private long zarobki;

    @Column(name = "numer_telefonu", nullable = false, columnDefinition = "bigint(100)")
    private long numer_telefonu;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pracownicy")
    private Set<Transakcje> transakcje;

    public Pracownicy() {
    }

    public Pracownicy(String imie, String nazwisko, String data_zatrudnienia, long zarobki, long numer_telefonu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.data_zatrudnienia = data_zatrudnienia;
        this.zarobki = zarobki;
        this.numer_telefonu = numer_telefonu;
    }

    public Pracownicy(String imie, String nazwisko, String data_zatrudnienia, long zarobki, long numer_telefonu, Set<Transakcje> transakcje) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.data_zatrudnienia = data_zatrudnienia;
        this.zarobki = zarobki;
        this.numer_telefonu = numer_telefonu;
        this.transakcje = transakcje;
    }

    public long getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(long id_pracownika) {
        this.id_pracownika = id_pracownika;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getData_zatrudnienia() {
        return data_zatrudnienia;
    }

    public void setData_zatrudnienia(String data_zatrudnienia) {
        this.data_zatrudnienia = data_zatrudnienia;
    }

    public long getZarobki() {
        return zarobki;
    }

    public void setZarobki(long zarobki) {
        this.zarobki = zarobki;
    }

    public long getNumer_telefonu() {
        return numer_telefonu;
    }

    public void setNumer_telefonu(long numer_telefonu) {
        this.numer_telefonu = numer_telefonu;
    }

    public Set<Transakcje> getTransakcje() {
        return transakcje;
    }

    public void setTransakcje(Set<Transakcje> transakcje) {
        this.transakcje = transakcje;
    }

    

    @Override
    public String toString() {
        return "Pracownicy{" +
                "id_pracownika=" + id_pracownika +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", data_zatrudnienia=" + data_zatrudnienia +
                ", zarobki=" + zarobki +
                ", numer_telefonu='" + numer_telefonu + '\'' +
                ", transakcje=" + transakcje +
                '}';
    }
}

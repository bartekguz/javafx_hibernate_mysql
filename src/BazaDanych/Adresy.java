package BazaDanych;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "adresy")
public class Adresy implements Serializable {

    private static final long serialVersionUID = -300035L;

    @Id
    @Column(name = "id_adresu", unique = true, nullable = false, columnDefinition = "bigint(6)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_adresu;

    @Column(name = "nazwa_miejscowosci", nullable = false, columnDefinition = "varchar(100)")
    private String nazwa_miejscowosci;

    @Column(name = "kod_pocztowy", nullable = false, columnDefinition = "varchar(100)")
    private String kod_pocztowy;

    @Column(name = "nazwa_wojewodztwa", columnDefinition = "varchar(100)")
    private String nazwa_wojewodztwa;

    @Column(name = "nazwa_ulicy", nullable = false, columnDefinition = "varchar(100)")
    private String nazwa_ulicy;

    @Column(name = "numer_domu", nullable = false, columnDefinition = "varchar(100)")
    private String numer_domu;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "adresy") 
    private List<Klienci> klienci;

    public Adresy() {
    }

    public Adresy(String nazwa_miejscowosci, String kod_pocztowy, String nazwa_wojewodztwa, String nazwa_ulicy, String numer_domu) {
        this.nazwa_miejscowosci = nazwa_miejscowosci;
        this.kod_pocztowy = kod_pocztowy;
        this.nazwa_wojewodztwa = nazwa_wojewodztwa;
        this.nazwa_ulicy = nazwa_ulicy;
        this.numer_domu = numer_domu;
    }

    public Adresy(String nazwa_miejscowosci, String kod_pocztowy, String nazwa_wojewodztwa, String nazwa_ulicy, String numer_domu, List<Klienci> klienci) {
        this.nazwa_miejscowosci = nazwa_miejscowosci;
        this.kod_pocztowy = kod_pocztowy;
        this.nazwa_wojewodztwa = nazwa_wojewodztwa;
        this.nazwa_ulicy = nazwa_ulicy;
        this.numer_domu = numer_domu;
        this.klienci = klienci;
    }
    

    public Long getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(Long id_adresu) {
        this.id_adresu = id_adresu;
    }

    public String getNazwa_miejscowosci() {
        return nazwa_miejscowosci;
    }

    public void setNazwa_miejscowosci(String nazwa_miejscowosci) {
        this.nazwa_miejscowosci = nazwa_miejscowosci;
    }

    public String getKod_pocztowy() {
        return kod_pocztowy;
    }

    public void setKod_pocztowy(String kod_pocztowy) {
        this.kod_pocztowy = kod_pocztowy;
    }

    public String getNazwa_wojewodztwa() {
        return nazwa_wojewodztwa;
    }

    public void setNazwa_wojewodztwa(String nazwa_wojewodztwa) {
        this.nazwa_wojewodztwa = nazwa_wojewodztwa;
    }

    public String getNazwa_ulicy() {
        return nazwa_ulicy;
    }

    public void setNazwa_ulicy(String nazwa_ulicy) {
        this.nazwa_ulicy = nazwa_ulicy;
    }

    public String getNumer_domu() {
        return numer_domu;
    }

    public void setNumer_domu(String numer_domu) {
        this.numer_domu = numer_domu;
    }

    public List<Klienci> getKlienci() {
        return klienci;
    }

    public void setKlienci(List<Klienci> klienci) {
        this.klienci = klienci;
    }

    @Override
    public String toString() {
        return "Adresy{" 
                + "id_adresu=" + id_adresu 
                + ", nazwa_miejscowosci=" + nazwa_miejscowosci 
                + ", kod_pocztowy=" + kod_pocztowy 
                + ", nazwa_wojewodztwa=" + nazwa_wojewodztwa 
                + ", nazwa_ulicy=" + nazwa_ulicy 
                + ", numer_domu=" + numer_domu 
//                + ", klienci=" + klienci 
                + '}';
    }
    
    
}

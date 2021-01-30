package BazaDanych;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "klienci")
public class Klienci implements Serializable {

    private static final long serialVersionUID = -300030L;

    @Column(name = "id_klienta", unique = true, nullable = false, columnDefinition = "bigint(6)")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_klienta;

    @Column(name = "imie", nullable = false, columnDefinition = "varchar(100)")
    private String imie;

    @Column(name = "nazwisko", nullable = false, columnDefinition = "varchar(100)")
    private String nazwisko;

    @Column(name = "pesel", columnDefinition = "bigint(100)")
    private Long pesel;

    @Column(name = "nip", columnDefinition = "bigint(100)")
    private Long nip;

    @Column(name = "numer_telefonu", nullable = false, columnDefinition = "bigint(100)")
    private Long numer_telefonu;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_adresu", nullable = false)
    private Adresy adresy;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "klienci")
    private List<Transakcje> transakcje;
    
    public Klienci() {
    }

    public Klienci(String imie, String nazwisko, long pesel, long nip, long numer_telefonu, Adresy adresy, List<Transakcje> transakcje) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.nip = nip;
        this.numer_telefonu = numer_telefonu;
        this.adresy = adresy;
        this.transakcje = transakcje;
    }
    
    public Klienci(String imie, String nazwisko, long pesel, long nip, long numer_telefonu, Adresy adresy) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.nip = nip;
        this.numer_telefonu = numer_telefonu;
        this.adresy = adresy;
    }

    public Klienci(String imie, String nazwisko, long pesel, long nip, long numer_telefonu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.nip = nip;
        this.numer_telefonu = numer_telefonu;
    }

    public void addTransakcja(Transakcje transakcja) {
        transakcje.add(transakcja);
        transakcja.setKlienci(this);
    }
    
    public void removeTransakcja(Transakcje transakcja) {
        transakcje.remove(transakcja);
        transakcja.setKlienci(null);
    }
    
    public long getId_klienta() {
        return id_klienta;
    }

    public void setId_klienta(Long id_klienta) {
        this.id_klienta = id_klienta;
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

    public long getPesel() {
        return pesel;
    }

    public void setPesel(Long pesel) {
        this.pesel = pesel;
    }

    public long getNip() {
        return nip;
    }

    public void setNip(Long nip) {
        this.nip = nip;
    }

    public long getNumer_telefonu() {
        return numer_telefonu;
    }

    public void setNumer_telefonu(Long numer_telefonu) {
        this.numer_telefonu = numer_telefonu;
    }

    public Adresy getAdresy() {
        return adresy;
    }

    public void setAdresy(Adresy adresy) {
        this.adresy = adresy;
    }

    public List<Transakcje> getTransakcje() {
        return transakcje;
    }

    public void setTransakcje(List<Transakcje> transakcje) {
        this.transakcje = transakcje;
    }

    

    @Override
    public String toString() {
        return "Klienci{" 
                + "id_klienta=" + id_klienta 
                + ", imie=" + imie 
                + ", nazwisko=" + nazwisko 
                + ", pesel=" + pesel 
                + ", nip=" + nip 
                + ", numer_telefonu=" + numer_telefonu 
                + ", transakcje=" + transakcje + '}';
    }

    
}

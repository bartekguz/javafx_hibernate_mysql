package tworzenie_bazy_danych;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Klienci")
public class Klienci implements Serializable {

    private static final long serialVersionUID = -300030L;

    @Column(name = "id_klienta", unique = true, nullable = false, columnDefinition = "bigint(6)")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idKlienta;

    @Column(name = "imie", nullable = false, columnDefinition = "varchar(100)")
    private String imie;

    @Column(name = "nazwisko", nullable = false, columnDefinition = "varchar(100)")
    private String nazwisko;

    @Column(name = "pesel", columnDefinition = "bigint(100)")
    private long pesel;

    @Column(name = "nip", columnDefinition = "bigint(100)")
    private long nip;

    @Column(name = "numer_telefonu", nullable = false, columnDefinition = "bigint(100)")
    private long numerTelefonu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_adresu", nullable = false)
    private Adresy adresy;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "klienci")
    private Set<Transakcje> transakcje;
    
    public Klienci() {
    }

    public Klienci(String imie, String nazwisko, long pesel, long nip, long numerTelefonu, Adresy adresy) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.nip = nip;
        this.numerTelefonu = numerTelefonu;
        this.adresy = adresy;
    }

    public Klienci(String imie, String nazwisko, long pesel, long nip, long numerTelefonu, Adresy adresy, Set<Transakcje> transakcje) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.nip = nip;
        this.numerTelefonu = numerTelefonu;
        this.adresy = adresy;
        this.transakcje = transakcje;
    }
    

    public long getIdKlienta() {
        return idKlienta;
    }

    public void setIdKlienta(long idKlienta) {
        this.idKlienta = idKlienta;
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

    public void setPesel(long pesel) {
        this.pesel = pesel;
    }

    public long getNip() {
        return nip;
    }

    public void setNip(long nip) {
        this.nip = nip;
    }

    public long getNumerTelefonu() {
        return numerTelefonu;
    }

    public void setNumerTelefonu(long numerTelefonu) {
        this.numerTelefonu = numerTelefonu;
    }

    public Adresy getAdresy() {
        return adresy;
    }

    public void setAdresy(Adresy adresy) {
        this.adresy = adresy;
    }

    public Set<Transakcje> getTransakcje() {
        return transakcje;
    }

    public void setTransakcje(Set<Transakcje> transakcje) {
        this.transakcje = transakcje;
    }

    

    @Override
    public String toString() {
        return "Klienci{" 
                + "idKlienta=" + idKlienta 
                + ", imie=" + imie 
                + ", nazwisko=" + nazwisko 
                + ", pesel=" + pesel 
                + ", nip=" + nip 
                + ", numerTelefonu=" + numerTelefonu 
                + ", adresy=" + adresy 
                + ", transakcje=" + transakcje + '}';
    }

    
}

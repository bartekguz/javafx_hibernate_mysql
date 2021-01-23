package BazaDanych;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "samochody")
public class Samochody implements Serializable {

    private static final long serialVersionUID = -300010L;

    @Column(name = "nr_vin", unique = true, nullable = false, columnDefinition = "varchar(100)")
    @Id
    private String nr_vin;

    @Column(name = "marka", nullable = true, columnDefinition = "varchar(100) default ' '")
    private String marka;

    @Column(name = "model", nullable = true, columnDefinition = "varchar(100) default ' '")
    private String model;

    @Column(name = "typ", nullable = true, columnDefinition = "varchar(100) default ' '")
    private String typ;

    @Column(name = "rok_produkcji", nullable = true, columnDefinition = "int(100) default '0'")
    private long rok_produkcji;

    @Column(name = "kolor", nullable = true, columnDefinition = "varchar(100) default ' '")
    private String kolor;

    @Column(name = "cena", nullable = true, columnDefinition = "bigint(100) default '0'")
    private long cena;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_silnika", nullable = true)
    private Silniki silniki;

    @OneToMany(cascade={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.LAZY, mappedBy = "vin")
    private Set<Transakcje> transakcje;

    public Samochody() { }

    public Samochody(String marka, String model, String typ, long rok_produkcji, String kolor, long cena, Silniki silniki) {
        this.marka = marka;
        this.model = model;
        this.typ = typ;
        this.rok_produkcji = rok_produkcji;
        this.kolor = kolor;
        this.cena = cena;
        this.silniki = silniki;
    }

    public Samochody(String marka, String model, String typ, long rok_produkcji, String kolor, long cena, Silniki silniki, Set<Transakcje> transakcje) {
        this.marka = marka;
        this.model = model;
        this.typ = typ;
        this.rok_produkcji = rok_produkcji;
        this.kolor = kolor;
        this.cena = cena;
        this.silniki = silniki;
        this.transakcje = transakcje;
    }
    
    

    public String getNr_vin() {
        return nr_vin;
    }

    public void setNr_vin(String nr_vin) {
        this.nr_vin = nr_vin;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public long getRok_produkcji() {
        return rok_produkcji;
    }

    public void setRokProdukcji(long rok_produkcji) {
        this.rok_produkcji = rok_produkcji;
    }

    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public long getCena() {
        return cena;
    }

    public void setCena(long cena) {
        this.cena = cena;
    }

    public Silniki getSilniki() {
        return silniki;
    }

    public void setSilniki(Silniki silniki) {
        this.silniki = silniki;
    }

    public Set<Transakcje> getTransakcje() {
        return transakcje;
    }

    public void setTransakcje(Set<Transakcje> transakcje) {
        this.transakcje = transakcje;
    }

    

    @Override
    public String toString() {
        return "Samochody{" +
                "nr_vin=" + nr_vin +
                ", marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", typ='" + typ + '\'' +
                ", rok_produkcji=" + rok_produkcji +
                ", kolor='" + kolor + '\'' +
                ", cena='" + cena + '\'' +
                ", silniki=" + silniki +
                '}';
    }

}


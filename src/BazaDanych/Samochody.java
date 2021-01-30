package BazaDanych;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "samochody")
public class Samochody implements Serializable {

    private static final Long serialVersionUID = -300010L;

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
    private Long rok_produkcji;

    @Column(name = "kolor", nullable = true, columnDefinition = "varchar(100) default ' '")
    private String kolor;

    @Column(name = "cena", nullable = true, columnDefinition = "bigint(100) default '0'")
    private Long cena;

    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_silnika", nullable = true)
    private Silniki silniki;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "vin")
    private List<Transakcje> transakcje;

    public Samochody() { }

    public Samochody(String nr_vin, String marka, String model, String typ, Long rok_produkcji, String kolor, Long cena, Silniki silniki, List<Transakcje> transakcje) {
        this.nr_vin = nr_vin;
        this.marka = marka;
        this.model = model;
        this.typ = typ;
        this.rok_produkcji = rok_produkcji;
        this.kolor = kolor;
        this.cena = cena;
        this.silniki = silniki;
        this.transakcje = transakcje;
    }
    
    public Samochody(String nr_vin, String marka, String model, String typ, Long rok_produkcji, String kolor, Long cena, Silniki silniki) {
        this.nr_vin = nr_vin;
        this.marka = marka;
        this.model = model;
        this.typ = typ;
        this.rok_produkcji = rok_produkcji;
        this.kolor = kolor;
        this.cena = cena;
        this.silniki = silniki;
    }

    public Samochody(String nr_vin, String marka, String model, String typ, Long rok_produkcji, String kolor, Long cena) {
        this.nr_vin = nr_vin;
        this.marka = marka;
        this.model = model;
        this.typ = typ;
        this.rok_produkcji = rok_produkcji;
        this.kolor = kolor;
        this.cena = cena;
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

    public void setRok_produkcji(Long rok_produkcji) {
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

    public void setCena(Long cena) {
        this.cena = cena;
    }

    public Silniki getSilniki() {
        return silniki;
    }

    public void setSilniki(Silniki silniki) {
        this.silniki = silniki;
    }

    public List<Transakcje> getTransakcje() {
        return transakcje;
    }

    public void setTransakcje(List<Transakcje> transakcje) {
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


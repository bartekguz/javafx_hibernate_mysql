package BazaDanych;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "silniki")
public class Silniki implements Serializable {

    private static final long serialVersionUID = -300015L;

    @Column(name = "id_silnika", unique = true, nullable = false, columnDefinition = "bigint(6)")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_silnika;

    @Column(name = "pojemnosc_silnika", nullable = false, columnDefinition = "varchar(100)")
    private String pojemnosc_silnika;

    @Column(name = "rodzaj_paliwa", nullable = false, columnDefinition = "varchar(100)")
    private String rodzaj_paliwa;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "silniki")
    private List<Samochody> samochody;

    public Silniki() { }

    public Silniki(String pojemnosc_silnika, String rodzaj_paliwa) {
        this.pojemnosc_silnika = pojemnosc_silnika;
        this.rodzaj_paliwa = rodzaj_paliwa;
    }

    public Silniki(String pojemnosc_silnika, String rodzaj_paliwa, List<Samochody> samochody) {
        this.pojemnosc_silnika = pojemnosc_silnika;
        this.rodzaj_paliwa = rodzaj_paliwa;
        this.samochody = samochody;
    }

    public void addSamochod(Samochody samochod) {
        samochody.add(samochod);
        samochod.setSilniki(this);
    }
    
    public void removeSamochod(Samochody samochod) {
        samochody.remove(samochod);
        samochod.setSilniki(null);
    }
    
    public long getId_silnika() {
        return id_silnika;
    }

    public void setId_silnika(Long id_silnika) {
        this.id_silnika = id_silnika;
    }

    public String getPojemnosc_silnika() {
        return pojemnosc_silnika;
    }

    public void setPojemnosc_silnika(String pojemnosc_silnika) {
        this.pojemnosc_silnika = pojemnosc_silnika;
    }

    public String getRodzaj_paliwa() {
        return rodzaj_paliwa;
    }

    public void setRodzaj_paliwa(String rodzaj_paliwa) {
        this.rodzaj_paliwa = rodzaj_paliwa;
    }  

    public List<Samochody> getSamochody() {
        return samochody;
    }

    public void setSamochody(List<Samochody> samochody) {
        this.samochody = samochody;
    }

    @Override
    public String toString() {
        return " id_silnika=" + id_silnika 
                + "\n pojemnosc_silnika=" + pojemnosc_silnika 
                + "\n rodzaj_paliwa=" + rodzaj_paliwa;
    }
}
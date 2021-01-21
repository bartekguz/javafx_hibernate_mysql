package BazaDanych;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "silniki")
public class Silniki implements Serializable {

    private static final long serialVersionUID = -300015L;

    @Column(name = "id_silnika", unique = true, nullable = false, columnDefinition = "bigint(6)")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSilnika;

    @Column(name = "pojemnosc_silnika", nullable = false, columnDefinition = "varchar(100)")
    private String pojemnoscSilnika;

    @Column(name = "rodzaj_paliwa", nullable = false, columnDefinition = "varchar(100)")
    private String rodzajPaliwa;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "silniki")
    private Set<Samochody> samochody;

    public Silniki() { }

    public Silniki(String pojemnoscSilnika, String rodzajPaliwa) {
        this.pojemnoscSilnika = pojemnoscSilnika;
        this.rodzajPaliwa = rodzajPaliwa;
    }

    public Silniki(String pojemnoscSilnika, String rodzajPaliwa, Set<Samochody> samochody) {
        this.pojemnoscSilnika = pojemnoscSilnika;
        this.rodzajPaliwa = rodzajPaliwa;
        this.samochody = samochody;
    }

    public String getPojemnoscSilnika() {
        return pojemnoscSilnika;
    }

    public void setPojemnoscSilnika(String pojemnoscSilnika) {
        this.pojemnoscSilnika = pojemnoscSilnika;
    }

    public String getRodzajPaliwa() {
        return rodzajPaliwa;
    }

    public void setRodzajPaliwa(String rodzajPaliwa) {
        this.rodzajPaliwa = rodzajPaliwa;
    }

    public Set<Samochody> getSamochody() {
        return samochody;
    }

    public void setSamochody(Set<Samochody> samochody) {
        this.samochody = samochody;
    }

    @Override
    public String toString() {
        return "Silniki{" +
                "idSilnika=" + idSilnika +
                ", pojemnoscSilnika='" + pojemnoscSilnika + '\'' +
                ", rodzajPaliwa='" + rodzajPaliwa + '\'' +
                '}';
    }
}

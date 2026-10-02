package currencyconverter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "currency")
public class Currency {

    @Id
    @Column(name = "abbreviation", length = 10, nullable = false)
    private String abbreviation;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "rate", nullable = false)
    private double rate;

    public Currency() {}

    public Currency(String abbreviation, String name, double rate) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.rate = rate;
    }

    public String getAbbreviation() { return abbreviation; }
    public String getName() { return name; }
    public double getRate() { return rate; }

    @Override
    public String toString() {
        return abbreviation + " - " + name;
    }
}
package billionaires.springbootbillionaires.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.validation.constraints.NotBlank;

@Entity
public class Billionaire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long rank;
    //@NotBlank(message = "Name is mandatory")
    private String name;
   // @NotBlank(message = "networth is mandatory")
    private String networth;
    // @NotBlank(message = "companiesowned is mandatory")
    private String companiesowned;

    public  Billionaire() {

    }

    public Billionaire(long rank,String name, String networth, String companiesowned) {
        this.name = name;
        this.rank = rank;
        this.networth = networth;
        this.companiesowned = companiesowned;
    }
    public void setId(long id) {

        this.id = id;
    }

    public long getId() {

        return id;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }

    public long getRank() {
        return rank;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNetworth(String networth) {
        this.networth = networth;
    }

    public String getName() {
        return name;
    }

    public String getNetworth() {
        return networth;
    }

    public String getCompaniesowned() {
        return companiesowned;
    }

    public void setCompaniesowned(String companiesOwned) {
        this.companiesowned = companiesOwned;
    }

    @Override
    public String toString() {
        return "Billionaire{" +
                "rank=" + rank +
                ", name='" + name + '\'' +
                ", networth='" + networth + '\'' +
                ", companiesowned='" + companiesowned + '\'' +
                '}';
    }


}

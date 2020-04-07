package billionaires.springbootbillionaires.entities;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Blob;
//import javax.validation.constraints.NotBlank;

@Entity
public class Billionaire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
   // @NotBlank(message = "networth is mandatory")
    private Double networth;
    // @NotBlank(message = "companiesowned is mandatory")
    private String companiesowned;
     private Blob icon;
    public  Billionaire() {

    }

    public Billionaire(String name, Double networth, String companiesowned,Blob icon) {
        this.name = name;
        this.networth = networth;
        this.companiesowned = companiesowned;
        this.icon = icon;
    }
    public void setId(long id) {

        this.id = id;
    }

    public long getId() {

        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNetworth(Double networth) {
        this.networth = networth;
    }

    public String getName() {
        return name;
    }

    public Double getNetworth() {
        return networth;
    }

    public String getCompaniesowned() {
        return companiesowned;
    }

    public void setCompaniesowned(String companiesOwned) {
        this.companiesowned = companiesOwned;
    }
    public void setIcon(Blob icon) {

        this.icon = icon;
    }

    public Blob getIcon() {

        return icon;
    }


    @Override
    public String toString() {
        return "Billionaire{" +
                ", name='" + name + '\'' +
                ", networth='" + networth + '\'' +
                ", companiesowned='" + companiesowned + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }


}

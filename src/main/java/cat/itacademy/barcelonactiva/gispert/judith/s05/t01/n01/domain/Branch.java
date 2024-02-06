package cat.itacademy.barcelonactiva.gispert.judith.s05.t01.n01.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "branch")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pk_BranchId;

    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "country", nullable = false, length = 50)
    private String country;

    public Branch(){}
    public Branch(String name, String country){
        this.name = name;
        this.country = country;
    }

    public int getPk_BranchId(){return pk_BranchId;}
    public String getName(){return name;}
    public String getCountry(){return country;}
    public void setId(int id){
        this.pk_BranchId = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setCountry(String country){
        this.country = country;
    }

    @Override
    public String toString(){return "Id: " + pk_BranchId
            + ", Name: " + name + " - Country: " + country;}
}

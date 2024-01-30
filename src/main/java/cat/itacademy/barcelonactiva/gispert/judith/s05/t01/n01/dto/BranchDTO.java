package cat.itacademy.barcelonactiva.gispert.judith.s05.t01.n01.dto;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t01.n01.domain.Branch;
import jakarta.persistence.Column;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BranchDTO {
    @Column(name = "id", nullable = false)
    private int pk_BranchId;
    @Column(name = "type", nullable = false, length = 50)
    private String type;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "country", nullable = false, length = 50)
    private String country;
    private final static List<String> countriesUE = new ArrayList<>(Arrays.asList("Austria", "Belgium", "Bulgaria", "Croatia", "Republic of Cyprus",
            "Czech Republic", "Denmark", "Estonia", "Finland", "France", "Germany", "Greece", "Hungary", "Ireland", "Italy",
            "Latvia", "Lithuania", "Luxembourg", "Malta", "Netherlands", "Poland", "Portugal", "Romania", "Slovakia",
            "Slovenia", "Spain", "Sweden"));
    public BranchDTO(){}
    public BranchDTO(String name, String country) {
        this.name = name;
        this.country = country;
        type = searchType();
    }

    public int getId(){return pk_BranchId;}
    public String getType(){return type;}
    public String getName(){return name;}
    public String getCountry(){return country;}
    public List<String> getCountriesUE(){return countriesUE;}
    public void setId(int id){
        this.pk_BranchId = id;
    }
    public void setType(String type){
        this.type = type;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setCountry(String country){
        this.country = country;
    }

    public String searchType(){
        boolean exist = countriesUE.contains(country);
        if (!exist){
            type = "Outside UE";
        } else {
            type = "UE";
        }
        return type;
    }


}

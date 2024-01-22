package cat.itacademy.barcelonactiva.gispert.judith.s05.t01.n01.dto;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t01.n01.domain.Branch;
import jakarta.persistence.Column;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BranchDTO extends Branch {
    @Column(name = "type", nullable = false, length = 50)
    private String type;
    private final static List<String> countriesUE = new ArrayList<>(Arrays.asList("Austria", "Belgium", "Bulgaria", "Croatia", "Republic of Cyprus",
            "Czech Republic", "Denmark", "Estonia", "Finland", "France", "Germany", "Greece", "Hungary", "Ireland", "Italy",
            "Latvia", "Lithuania", "Luxembourg", "Malta", "Netherlands", "Poland", "Portugal", "Romania", "Slovakia",
            "Slovenia", "Spain", "Sweden"));
    public BranchDTO(String name, String country) {
        super(name, country);
        this.type = searchType();
    }

    public String getType(){return type;}
    public List<String> getCountriesUE(){return countriesUE;}
    public void setType(String type){
        this.type = type;
    }

    public String searchType(){
        boolean exist = countriesUE.contains(getCountry());
        if (!exist){
            type = "Outside UE";
        } else {
            type = "UE";
        }
        return type;
    }


}

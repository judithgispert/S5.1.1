package cat.itacademy.barcelonactiva.gispert.judith.s05.t01.n01.dto;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t01.n01.domain.Branch;
import jakarta.persistence.Column;

public class BranchDTO extends Branch {
    @Column(name = "name", nullable = false, length = 50)
    private String type;
    public BranchDTO(String name, String country) {
        super(name, country);
    }
}

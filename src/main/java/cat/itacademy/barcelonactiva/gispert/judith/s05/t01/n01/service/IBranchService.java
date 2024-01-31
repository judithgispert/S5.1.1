package cat.itacademy.barcelonactiva.gispert.judith.s05.t01.n01.service;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t01.n01.dto.BranchDTO;

import java.util.List;


public interface IBranchService {
    public void createBranchOffice(BranchDTO branchDTO);
    public BranchDTO getBranchOfficeById(int id);
    public List<BranchDTO> getBranchOffices();
    public BranchDTO updateBranchOffice(BranchDTO newBranchDTO, int id);
    public void deleteBranchOffice(int id);


}

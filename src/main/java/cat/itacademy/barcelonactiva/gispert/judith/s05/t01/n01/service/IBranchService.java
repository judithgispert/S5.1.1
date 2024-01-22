package cat.itacademy.barcelonactiva.gispert.judith.s05.t01.n01.service;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t01.n01.domain.Branch;

import java.util.List;


public interface IBranchService {
    public void createBranch(Branch branch);
    public Branch getBranchById(int id);
    public List<Branch> getBranches();
    public Branch updateBranch(Branch newBranch);
    public void deleteBranch(int id);


}

package cat.itacademy.barcelonactiva.gispert.judith.s05.t01.n01.service.impl;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t01.n01.domain.Branch;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t01.n01.dto.BranchDTO;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t01.n01.exceptions.BranchNotFoundException;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t01.n01.repository.IBranchRepository;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t01.n01.service.IBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BranchServiceImpl implements IBranchService {
    @Autowired
    private IBranchRepository branchRepository;


    @Override
    public void createBranchOffice(BranchDTO branchDto) {
        Branch branch = branchDTOBranchOffice(branchDto);
        branchRepository.save(branch);
    }

    @Override
    public BranchDTO getBranchOfficeById(int id) {
        Optional<Branch> branch = branchRepository.findById(id);
        if(branch.isPresent()){
            return branchOfficeBranchDTO(branch.get());
        }else{
            throw new BranchNotFoundException("The id: " + id + ", doesn't correspond to any branch office.");
        }
    }

    @Override
    public List<BranchDTO> getBranchOffices() {
        List<Branch> branchOffices = branchRepository.findAll();
        List<BranchDTO> branchDtos = new ArrayList<>();
        for (Branch branchOffice : branchOffices) {
            branchDtos.add(branchOfficeBranchDTO(branchOffice));
        }
        return branchDtos;
    }

    @Override
    public BranchDTO updateBranchOffice(BranchDTO branchDto, int id) {
        Branch newBranch = branchDTOBranchOffice(branchDto);
        Optional<Branch> branch = branchRepository.findById(id);
        if(branch.isPresent()){
            Branch updatedBranch = branch.get();
            updatedBranch.setName(newBranch.getName());
            updatedBranch.setCountry(newBranch.getCountry());
            branchRepository.save(updatedBranch);
            return branchOfficeBranchDTO(updatedBranch);

        } else {
            throw new BranchNotFoundException("The id: " + id + ", doesn't correspond to any branch office.");
        }
    }

    @Override
    public void deleteBranchOffice(int id) {
        Optional<Branch> branch = branchRepository.findById(id);
        if(branch.isPresent()){
            branchRepository.deleteById(id);
        } else{
            throw new BranchNotFoundException("The id: " + id + ", doesn't correspond to any branch office.");
        }
    }

    private static Branch branchDTOBranchOffice(BranchDTO branchDto){
        Branch branch = new Branch();
        branch.setId(branchDto.getId());
        branch.setName(branchDto.getName());
        branch.setCountry(branchDto.getCountry());
        return branch;
    }
    private static BranchDTO branchOfficeBranchDTO(Branch branch){
        BranchDTO branchDto = new BranchDTO();
        branchDto.setId(branch.getPk_BranchId());
        branchDto.setName(branch.getName());
        branchDto.setCountry(branch.getCountry());
        branchDto.setType(branchDto.searchType());
        return branchDto;
    }
}

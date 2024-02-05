package cat.itacademy.barcelonactiva.gispert.judith.s05.t01.n01.contoller;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t01.n01.dto.BranchDTO;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t01.n01.service.impl.BranchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/branchOffice")
public class BranchController {

    @Autowired
    private BranchServiceImpl branchService;

    @GetMapping()
    public String startWeb(){
        return "startWeb";
    }
    @GetMapping("/")
    public String listAllView(Model model){
        List<BranchDTO> branchDTOList = branchService.getBranchOffices();
        model.addAttribute("branchDTOList", branchDTOList);
        return "listView";
    }
    @GetMapping("/getOneBranchOffice/{id}")
    public String viewOne(@PathVariable(value="id") int id, Model model){
        model.addAttribute("branchDTO", branchService.getBranchOfficeById(id));
        return "getOne";
    }
    @GetMapping("/createBranch")
    public String createBranch(Model model){
        BranchDTO branchDTO = new BranchDTO();
        model.addAttribute("branchDTO", branchDTO);
        return "createBranch";
    }
    @PostMapping("/addBranch")
    public String showSavedBranch(@ModelAttribute("branchDto") BranchDTO branchDTO){
        branchService.createBranchOffice(branchDTO);
        return "redirect:/api/branchOffice/";
    }
    @GetMapping("/showUpdateBranch/{id}")
    public String showUpdateBranch(@PathVariable(value="id") int id, Model model){
        model.addAttribute("branchDTO", branchService.getBranchOfficeById(id));
        return "updateBranch";
    }
    @PostMapping("/updateBranch/{id}")
    public String updatedBranch(@PathVariable(value="id") int id, @ModelAttribute("branchDTO") BranchDTO branchDTO){
        branchService.updateBranchOffice(branchDTO, id);
        return "redirect:/api/branchOffice/";
    }
    @GetMapping("/deleteBranch/{id}")
    public String deleteBranch(@PathVariable(value="id")int id){
        branchService.deleteBranchOffice(id);
        return "redirect:/api/branchOffice/";
    }
}

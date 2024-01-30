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

    @GetMapping("/")
    public String listAllView(Model model){
        List<BranchDTO> branchDTOList = branchService.getBranchOffices();
        model.addAttribute("branchDTOList", branchDTOList);
        return "listView";
    }
    @GetMapping("/createBranch")
    public String createBranch(Model model){
        BranchDTO branchDto = new BranchDTO();
        model.addAttribute("branchDto", branchDto);
        return "createBranch";
    }
    @PostMapping("/addBranch")
    public String showSavedBranch(@ModelAttribute("branchDto") BranchDTO branchDto){
        branchService.createBranchOffice(branchDto);
        return "redirect:/api/branchOffice/";
    }
    @GetMapping("/updateBranch/{id}")
    public String updateBranch(@PathVariable int id, Model model){
        model.addAttribute("branchDto", branchService.getBranchOfficeById(id));
        return "updateBranch";
    }
    @PostMapping("/branch/{id}")
    public String showUpdatedBranch(@PathVariable int id, @ModelAttribute("branchDto") BranchDTO branchDto){
        branchService.updateBranchOffice(branchDto, id);
        return "redirect:/api/branchOffice/";
    }
    @GetMapping("/branch/{id}")
    public String deleteBranch(@PathVariable int id){
        branchService.deleteBranchOffice(id);
        return "redirect:/api/branchOffice/";
    }


}

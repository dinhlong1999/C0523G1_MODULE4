package com.example.seminar_test2.controller;

import com.example.seminar_test2.model.Origin;
import com.example.seminar_test2.model.Pig;
import com.example.seminar_test2.model.PigDTO;
import com.example.seminar_test2.service.IOriginService;
import com.example.seminar_test2.service.IPigService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class PigController {

    @Autowired
    private IPigService pigService;

    @Autowired
    private IOriginService originService;

    @GetMapping
    public String showList(Model model){
        List<Pig> pigList = pigService.findAll();
        model.addAttribute("pigList",pigList);
        return "showlist";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int idDelete){
        pigService.delete(idDelete);
        return "redirect:/";
    }
    @PostMapping("/output")
    public String outPut(@RequestParam String date, @RequestParam int idOut){
        Pig pig = pigService.getPigById(idOut);
        pig.setTimeOutput(date);
        pig.setWeightOut("100");
        pigService.save(pig);
        return "redirect:/";
    }
    @GetMapping("/edit")
    public String edit(@RequestParam int id,Model model){
        Pig pig = pigService.getPigById(id);
        PigDTO pigDTO = new PigDTO();
        BeanUtils.copyProperties(pig,pigDTO);
        List<Origin> originList = originService.findAll();
        model.addAttribute("pigDTO",pigDTO);
        model.addAttribute("originList",originList);
        return "edit";
    }
    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute PigDTO pigDTO, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            List<Origin> originList = originService.findAll();
            model.addAttribute("originList",originList);
            return "edit";
        }
        Pig pig = new Pig();
        BeanUtils.copyProperties(pigDTO,pig);
        pigService.save(pig);
        return "redirect:/";
    }
}

package com.example.seminar_test.controller;

import com.example.seminar_test.model.Car;
import com.example.seminar_test.model.CarDTO;
import com.example.seminar_test.model.TypeCar;
import com.example.seminar_test.service.ICarService;
import com.example.seminar_test.service.ITypeCarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    private ICarService carService;

    @Autowired
    private ITypeCarService typeCarService;

//    @GetMapping
//    public String showList(Model model){
//        List<Car> carList = carService.findAll();
//        model.addAttribute("carList",carList);
//        return "show-list";
//    }
    @GetMapping
    public String showList(@RequestParam(required = false,defaultValue = "0")int page,
                           @RequestParam(required = false,defaultValue = "") String nameSearch, Model model){
        Pageable pageable = PageRequest.of(page,2, Sort.by("name").descending());
        Page<Car> showListPage = carService.findCarByNameContaining(pageable,nameSearch);
        model.addAttribute("showListPage",showListPage);
        model.addAttribute("nameSearch",nameSearch);
        return "show-list";
    }


    @GetMapping("/create")
    public String showFormCreate(Model model){
        List<TypeCar> typeCarList = typeCarService.showListType();
        model.addAttribute("CarDTO",new CarDTO());
        model.addAttribute("typeCarList",typeCarList);
        return "showFormCreate";
    }
    @PostMapping("/create")
    public String save(@Valid @ModelAttribute CarDTO carDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "showFormCreate";
        }
        Car car = new Car();
        BeanUtils.copyProperties(carDTO,car);
        carService.save(car);
        redirectAttributes.addFlashAttribute("message","ok");
        return "redirect:/";
    }
}

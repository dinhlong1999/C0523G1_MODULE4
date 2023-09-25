package com.example.exercise2.controller;

import com.example.exercise2.model.Song;
import com.example.exercise2.model.SongDTO;
import com.example.exercise2.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class SongController {

    @Autowired
    private ISongService songService;

    @GetMapping("create")
    public String showFormCreate(Model model){
        model.addAttribute("songDTO", new SongDTO());
        return "create";
    }

    @GetMapping("list")
    public String showList(Model model){
        List<Song> songList = songService.findAll();
        model.addAttribute("songList",songList);
        return "list";
    }
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute SongDTO songDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        new SongDTO().validate(songDTO,bindingResult);
        if(bindingResult.hasErrors()){
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDTO,song);
        songService.save(song);
        redirectAttributes.addFlashAttribute("message","ok");
        return "redirect:/list";

    }
}

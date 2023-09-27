package com.example.exercise2.controller;

import com.example.exercise2.model.Song;
import com.example.exercise2.dto.SongDTO;
import com.example.exercise2.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        redirectAttributes.addFlashAttribute("message","Create success");
        return "redirect:/list";

    }
    @GetMapping("/song/{id}/edit")
    public String showFormEdit(@PathVariable int id, Model model){
        Song song = songService.findById(id);
        SongDTO songDTO = new SongDTO();
        BeanUtils.copyProperties(song,songDTO);
        model.addAttribute("songDTO",songDTO );
        return "edit";
    }
    @PostMapping("/song/edit")
    public String edit(@Valid @ModelAttribute SongDTO songDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        new SongDTO().validate(songDTO,bindingResult);
        if (bindingResult.hasErrors()){
            return "edit";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDTO,song);
        songService.save(song);
        redirectAttributes.addFlashAttribute("message","Edit success");
        return "redirect:/list";
    }
}

package com.codegym.controller;

import com.codegym.dto.MusicDto;
import com.codegym.model.Music;
import com.codegym.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
public class MusicController {

    @Autowired
    private IMusicService iMusicService;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("musicList", iMusicService.findAll());
        return "/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("musicDto", new MusicDto());
        return "/create";
    }

    @PostMapping("/create")
    public String createMusic(@ModelAttribute(value = "musicDto") @Valid MusicDto musicDto,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {

        new MusicDto().validate(musicDto, bindingResult);

        if (bindingResult.hasErrors()) {
            return "/create";
        }

        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        iMusicService.save(music);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công!");
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String showEdit(@RequestParam int id, Model model) {
        model.addAttribute("musicDto", iMusicService.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String editMusic(@ModelAttribute(value = "musicDto") @Valid MusicDto musicDto,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {

        new MusicDto().validate(musicDto, bindingResult);

        if (bindingResult.hasErrors()) {
            return "/edit";
        }

        Music music = new Music();
        music.setId(musicDto.getId());
        BeanUtils.copyProperties(musicDto, music);
        iMusicService.save(music);
        redirectAttributes.addFlashAttribute("mess", "Edit thành công!");
        return "redirect:/";
    }
}

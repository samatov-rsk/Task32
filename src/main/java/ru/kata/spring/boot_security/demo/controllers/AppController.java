package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.configs.service.DaoService;
import ru.kata.spring.boot_security.demo.models.User;


@Controller
@RequestMapping("/users")
public class AppController {

    private final DaoService daoService;

    @Autowired
    public AppController(DaoService daoService) {

        this.daoService = daoService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("users", daoService.getAllUsers());
        return "index";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") Integer userId, Model model) {
        model.addAttribute("user", daoService.getUserById(userId));
        return "show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        daoService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Integer userId) {
        model.addAttribute("user", daoService.getUserById(userId));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Integer userId) {
        daoService.updateUser(userId, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Integer userId) {
        daoService.removeUser(userId);
        return "redirect:/users";
    }
}

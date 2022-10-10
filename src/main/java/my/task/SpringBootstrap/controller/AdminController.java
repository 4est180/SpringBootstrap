package my.task.SpringBootstrap.controller;

import my.task.SpringBootstrap.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import my.task.SpringBootstrap.model.User;
import my.task.SpringBootstrap.service.UserService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String index(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());
        model.addAttribute("user", user);
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("newUser", new User());
        return "role_admin";
    }

    @PostMapping
    public String create(@ModelAttribute("newUser") @Valid User user,
                         @RequestParam(value = "roles_Id") String[] roles, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "role_admin";
        }

        user.setRoles(Arrays.stream(roles).map(Role::new).collect(Collectors.toSet()));
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user,
                         @RequestParam(value = "roles_Id") String[] roles, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "role_admin";
        }

        user.setRoles(Arrays.stream(roles).map(Role::new).collect(Collectors.toSet()));
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.removeUserById(id);
        return "redirect:/admin";
    }
}
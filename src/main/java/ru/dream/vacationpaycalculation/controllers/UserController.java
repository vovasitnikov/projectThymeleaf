package ru.dream.vacationpaycalculation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.dream.vacationpaycalculation.entity.User;
import ru.dream.vacationpaycalculation.service.UserService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Controller
@RequestMapping("/users") //наименование URL, по которому переход будет
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/index";
    }

    @GetMapping("/{id}") //наименование URL, по которому переход будет
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id).get());
        return "users/show";
    }

    @GetMapping("/callFormCreateNewUser") //наименование URL, по которому переход будет.
    public String newUser(@ModelAttribute("user") User user) {
        return "users/formCreateNewUser"; // вызов html формы для создания нового пользователя
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users"; //наименование URL, по которому переход будет
    }


    @GetMapping("/calculacte")
    public ResponseEntity<Double> getAverageSalary(@RequestParam(value = "averageSalaryPerMonth") Double averageSalaryPerMonth,
                                                   @RequestParam(value = "countDays") Integer countDays){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getAverageSalary(averageSalaryPerMonth, countDays));
    }
}
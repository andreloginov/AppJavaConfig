package com.myApp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.myApp.entity.Employee;
import com.myApp.service.EmployeeService;

@Controller
public class EmployeeController {
    // Constructor based Dependency Injection
    private EmployeeService employeeService;

    public EmployeeController() {

    }

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @RequestMapping("/home")
    public String showAllEmployees() {

        return "home";
    }

    @RequestMapping("/")
    public String showAllEmployees(Model model) {
        List<Employee> list = employeeService.getAllEmployees();
        model.addAttribute("listEmployees", list);

        return "show_all";
    }
    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {

        model.addAttribute("employee", new Employee());

        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }





    // Get All Users
    /*@RequestMapping(value = "/allUsers", method = RequestMethod.POST)
    public ModelAndView displayAllUser() {
        System.out.println("User Page Requested : All Users");
        ModelAndView mv = new ModelAndView();
        List userList = userService.getAllUsers();
        mv.addObject("userList", userList);
        mv.setViewName("allUsers");
        return mv;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public ModelAndView displayNewUserForm() {
        ModelAndView mv = new ModelAndView("addUser");
        mv.addObject("headerMessage", "Add User Details");
        mv.addObject("user", new User());
        return mv;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ModelAndView saveNewUser(@ModelAttribute User user, BindingResult result) {
        ModelAndView mv = new ModelAndView("redirect:/home");

        if (result.hasErrors()) {
            return new ModelAndView("error");
        }
        boolean isAdded = userService.saveUser(user);
        if (isAdded) {
            mv.addObject("message", "New user successfully added");
        } else {
            return new ModelAndView("error");
        }

        return mv;
    }

    @RequestMapping(value = "/editUser/{id}", method = RequestMethod.GET)
    public ModelAndView displayEditUserForm(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView("/editUser");
        User user = userService.getUserById(id);
        mv.addObject("headerMessage", "Edit User Details");
        mv.addObject("user", user);
        return mv;
    }

    @RequestMapping(value = "/editUser/{id}", method = RequestMethod.POST)
    public ModelAndView saveEditedUser(@ModelAttribute User user, BindingResult result) {
        ModelAndView mv = new ModelAndView("redirect:/home");

        if (result.hasErrors()) {
            System.out.println(result.toString());
            return new ModelAndView("error");
        }
        boolean isSaved = userService.saveUser(user);
        if (!isSaved) {

            return new ModelAndView("error");
        }

        return mv;
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUserById(@PathVariable Long id) {
        boolean isDeleted = userService.deleteUserById(id);
        System.out.println("User deletion respone: " + isDeleted);
        ModelAndView mv = new ModelAndView("redirect:/home");
        return mv;}*/



}
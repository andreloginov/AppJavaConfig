package com.myApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.myApp.entity.Employee;
import com.myApp.service.EmployeeService;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @RequestMapping("/")
    public String showAllEmployees(Model model) {

        model.addAttribute("listEmployees", employeeService.getAllEmployees());

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
    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model) {

        model.addAttribute("employee", employeeService.getEmpFromId(id));

        return "employee-info";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id, Model model) {
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
}
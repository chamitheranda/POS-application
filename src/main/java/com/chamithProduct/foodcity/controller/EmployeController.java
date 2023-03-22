package com.chamithProduct.foodcity.controller;

import com.chamithProduct.foodcity.dto.requestDTO.EmployeRequestDTO;
import com.chamithProduct.foodcity.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/employe")
public class EmployeController {
    @Autowired
    private EmployeService employeService;
    @PostMapping(path = "/save")
    private String  saveEmploye(@RequestBody EmployeRequestDTO employeRequestDTO){
        String  text = employeService.addEmploye(employeRequestDTO);
        return text;
    }
}

package com.chamithProduct.foodcity.service.impl;

import com.chamithProduct.foodcity.dto.requestDTO.EmployeRequestDTO;
import com.chamithProduct.foodcity.entity.Employe;
import com.chamithProduct.foodcity.repo.EmployeRepo;
import com.chamithProduct.foodcity.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeServiceIMPL implements EmployeService {

    @Autowired
    private EmployeRepo employeRepo;
    @Override
    public String addEmploye(EmployeRequestDTO employeRequestDTO) {
        Employe employe = new Employe(
                employeRequestDTO.getEmployeAge(),
                employeRequestDTO.getAddrss(),
                employeRequestDTO.getContactNumber(),
                employeRequestDTO.isActiveState()
        );
        if (!employeRepo.existsById(employe.getEmployeID())) {
            employeRepo.save(employe);
            return employe.getEmployeID() + " Saved ";
        } else {
            System.out.println("customer id is exists ");
            return  "  this id is exists";
        }
    }



}

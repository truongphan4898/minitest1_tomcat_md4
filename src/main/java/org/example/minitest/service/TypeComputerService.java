package org.example.minitest.service;


import org.example.minitest.model.TypeComputer;
import org.example.minitest.repository.ITypeComputer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeComputerService implements ITypeComputerService {
    @Autowired
    private ITypeComputer typeComputer;

    @Override
    public List<TypeComputer> listTypeComputer() {
        return typeComputer.findAll();
    }

}

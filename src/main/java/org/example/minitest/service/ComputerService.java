package org.example.minitest.service;

import org.example.minitest.model.Computer;
import org.example.minitest.repository.IComputer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ComputerService implements IComputerService {

    @Autowired
    private IComputer iComputer;


    @Override
    public List<Computer> listComputer() {
        return iComputer.findAll();
    }

    @Override
    public void addComputer(Computer computer) {
        iComputer.save(computer);
    }

    @Override
    public void deleteComputer(int id) {
        iComputer.deleteById(id);
    }

    @Override
    public Computer info(int id) {
        return iComputer.findById(id).get();
    }

    @Override
    public Page<Computer> search(String name, Pageable pageable) {
        return iComputer.findComputerByNameComputerContains(name,pageable);
    }
}


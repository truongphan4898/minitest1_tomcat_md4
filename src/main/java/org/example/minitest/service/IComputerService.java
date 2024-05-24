package org.example.minitest.service;




import org.example.minitest.model.Computer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IComputerService {
    List<Computer> listComputer();
    void addComputer(Computer computer);
    void deleteComputer(int id);

    Computer info(int id);

    Page<Computer> search(String name, Pageable pageable);

}

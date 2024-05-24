package org.example.minitest.repository;

import org.example.minitest.model.Computer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface IComputer extends JpaRepository<Computer, Integer> {
   Page<Computer>findComputerByNameComputerContains(String name,Pageable pageable);

}

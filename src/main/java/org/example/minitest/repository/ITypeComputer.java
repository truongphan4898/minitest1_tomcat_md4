package org.example.minitest.repository;

import org.example.minitest.model.TypeComputer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeComputer extends JpaRepository<TypeComputer,Integer> {
}


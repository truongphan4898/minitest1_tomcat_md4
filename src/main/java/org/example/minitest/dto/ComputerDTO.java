package org.example.minitest.dto;


import org.example.minitest.model.TypeComputer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class ComputerDTO {
    int id;

    @Pattern(regexp = "^CG.{6}$", message = " Code bắt đầu bằng chữ CG và có 8 ký tự")
    String codeComputer;
    @NotBlank(message = " không được để trống")
    String nameComputer;
    @NotBlank(message = " không được để trống")
    String producer;

    TypeComputer typeComputer;

    public ComputerDTO() {
    }

    public ComputerDTO(int id, String codeComputer, String nameComputer, String producer, TypeComputer typeComputer) {
        this.id = id;
        this.codeComputer = codeComputer;
        this.nameComputer = nameComputer;
        this.producer = producer;
        this.typeComputer = typeComputer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeComputer() {
        return codeComputer;
    }

    public void setCodeComputer(String codeComputer) {
        this.codeComputer = codeComputer;
    }

    public String getNameComputer() {
        return nameComputer;
    }

    public void setNameComputer(String nameComputer) {
        this.nameComputer = nameComputer;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public TypeComputer getTypeComputer() {
        return typeComputer;
    }

    public void setTypeComputer(TypeComputer typeComputer) {
        this.typeComputer = typeComputer;
    }
}
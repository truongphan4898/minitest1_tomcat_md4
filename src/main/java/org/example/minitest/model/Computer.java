package org.example.minitest.model;





import javax.persistence.*;

@Entity

public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String codeComputer;

    String nameComputer;

    String producer;
    @ManyToOne()
    @JoinColumn(name = "id_loai_sp")
    TypeComputer typeComputer;

    public Computer() {
    }

    public Computer(int id, String codeComputer, String nameComputer, String producer, TypeComputer typeComputer) {
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

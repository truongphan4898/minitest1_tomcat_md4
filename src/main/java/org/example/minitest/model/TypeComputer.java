package org.example.minitest.model;





import javax.persistence.*;
import java.util.Set;

@Entity

public class TypeComputer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String nameTypeComputer;
    @OneToMany(mappedBy = "typeComputer")
    private Set<Computer> computers;

    public TypeComputer() {
    }

    public TypeComputer(int id, String nameTypeComputer, Set<Computer> computers) {
        this.id = id;
        this.nameTypeComputer = nameTypeComputer;
        this.computers = computers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameTypeComputer() {
        return nameTypeComputer;
    }

    public void setNameTypeComputer(String nameTypeComputer) {
        this.nameTypeComputer = nameTypeComputer;
    }

    public Set<Computer> getComputers() {
        return computers;
    }

    public void setComputers(Set<Computer> computers) {
        this.computers = computers;
    }
}

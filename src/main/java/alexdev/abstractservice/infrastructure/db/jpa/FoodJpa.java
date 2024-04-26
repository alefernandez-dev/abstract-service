package alexdev.abstractservice.infrastructure.db.jpa;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "FOOD")
public class FoodJpa implements Serializable {
    @Id
    UUID id;
    @Column(nullable = false, unique = true)
    String name;
    @Column(nullable = false)
    String difficulty;

    public FoodJpa() {
    }

    public FoodJpa(UUID id, String name, String difficulty) {
        this.id = id;
        this.name = name;
        this.difficulty = difficulty;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}

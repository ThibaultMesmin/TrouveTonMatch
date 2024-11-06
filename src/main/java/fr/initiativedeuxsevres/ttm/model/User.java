package fr.initiativedeuxsevres.ttm.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="`user`")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String role;

    @ManyToOne
    @JoinColumn(name = "parrain_id")
    private User parrain;
    @OneToMany(mappedBy = "parrain")
    private List<User> porteurs;

}

package flog.instagram_clone_coding.domain;

import jakarta.persistence.*;


@Entity
public class Users {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String username;

    private String password;
}

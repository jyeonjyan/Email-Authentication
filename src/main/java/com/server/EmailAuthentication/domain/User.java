package com.server.EmailAuthentication.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseTime {
    @Id //AI
    @Column(name = "userIdx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long userIdx;

    @Column(unique = true)
    private String userEmail;

    @Column(name = "password")
    private String password;

    @Column(unique = true)
    private String userName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salt_id")
    private Salt salt;
}

package com.server.EmailAuthentication.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Map;

@Entity
@Builder
@Getter
@Setter
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

    @Column
    private boolean authStatus = false;
}

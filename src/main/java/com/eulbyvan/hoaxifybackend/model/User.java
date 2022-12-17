package com.eulbyvan.hoaxifybackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 12/12/2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sys_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Display name is mandatory")
    @NotNull(message = "Display name cannot be null")
    @Size(min = 3, max = 255)
    @Column(name = "display_name", length = 100, nullable = false)
    private String displayName;
    @NotBlank(message = "username is mandatory")
    @NotNull(message = "username cannot be null")
    @Size(min = 3, max = 255)
    @Column(name = "username", unique = true, nullable = false)
    private String username;
    @NotBlank(message = "password is mandatory")
    @NotNull(message = "password cannot be null")
    @Size(min = 8, max = 255)
    @Column(name = "password", nullable = false)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "password must be a combination of uppercase letters, lowercase letters, symbols, and numbers")
    private String password;
}

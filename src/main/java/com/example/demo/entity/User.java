package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "users") // Correspond à votre table SQL
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "first_name", length = 255)
  private String firstName;

  @Column(name = "last_name", length = 255)
  private String lastName;

  @Column(name = "user_name", length = 50) // Correspond à votre VARCHAR(50)
  private String userName;

  @Column(unique = true, nullable = false, length = 255)
  private String email;

  // La relation Many-to-Many
  @ManyToMany
  @JoinTable(
      name = "subscriptions", // Nom de la table de liaison SQL
      joinColumns = @JoinColumn(name = "user_id"), // Colonne de cette table
      inverseJoinColumns = @JoinColumn(name = "course_id") // Colonne de la table liée
      )
  private Set<Course> courses = new HashSet<>();
}

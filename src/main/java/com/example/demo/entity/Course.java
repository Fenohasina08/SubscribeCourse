package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(nullable = false, length = 255)
  private String title;

  @Column(name = "start_date")
  private Instant startDate;

  @Column(name = "end_date")
  private Instant endDate;

  // La relation inverse : on ne gère pas la table de liaison ici
  @ManyToMany(mappedBy = "courses")
  private Set<User> users = new HashSet<>();
}

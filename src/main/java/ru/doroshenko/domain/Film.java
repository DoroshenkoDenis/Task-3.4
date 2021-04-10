package ru.doroshenko.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Film {
  private int id;
  private int filmId;
  private String filmName;
  private String genre;
  private String imageUrl;
}

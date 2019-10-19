package com.myght.flatsharing.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
  private Integer id;
  private String firstName;
  private String middleName;
  private String lastName;

  private String login;
  private String password;

  private Boolean enabled;
  private Boolean accountExpired;
}

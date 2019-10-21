package com.myght.flatsharing.models.user;

import com.myght.flatsharing.models.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
@Data
@NoArgsConstructor
public class Credentials {
  @Id
  private Integer userId;
  private String login;
  private String password;
  private String salt;

  private Boolean expired;

  @MapsId
  @OneToOne(mappedBy = "credentials")
  private User user;
}

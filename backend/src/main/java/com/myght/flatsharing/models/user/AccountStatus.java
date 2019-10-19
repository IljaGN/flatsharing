package com.myght.flatsharing.models.user;

import com.myght.flatsharing.models.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account_statuses")
@Data
@NoArgsConstructor
public class AccountStatus {
  @Id
  private Integer userId;
  private Boolean enabled;
  private Boolean locked;
  private Boolean expired;

  @MapsId
  @OneToOne
  private User user;
}

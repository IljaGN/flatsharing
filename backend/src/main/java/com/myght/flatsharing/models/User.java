package com.myght.flatsharing.models;

import com.myght.flatsharing.dto.UserDto;
import com.myght.flatsharing.models.user.AccountStatus;
import com.myght.flatsharing.models.user.Credentials;
import com.myght.flatsharing.models.user.Role;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User implements UserDetails {
  @Id
  @SequenceGenerator(name = "pk_seq", sequenceName = "users_seq", allocationSize = 1)
  @GeneratedValue(generator = "pk_seq", strategy = GenerationType.SEQUENCE)
  private Integer id;

  private String firstName;
  private String middleName;
  private String lastName;

  @OneToOne(cascade = CascadeType.ALL)
  @PrimaryKeyJoinColumn
  private Credentials credentials;

  @OneToOne(cascade = CascadeType.ALL)
  @PrimaryKeyJoinColumn
  private AccountStatus status;

  @Transient
  private List<Role> authorities;
//  private List ads;
//  private List selfAds;
//  private List documents;

  public UserDto toDto() {
    return new UserDto(
        id,
        firstName,
        middleName,
        lastName,
        credentials.getLogin(),
        credentials.getPassword(),
        status.getEnabled(),
        status.getExpired()
    );
  }

  @Override
  public String getPassword() {
    return credentials.getPassword();
  }

  @Override
  public String getUsername() {
    return credentials.getLogin();
  }

  @Override
  public boolean isAccountNonExpired() {
    return !status.getExpired();
  }

  @Override
  public boolean isAccountNonLocked() {
    return !status.getLocked();
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return !credentials.getExpired();
  }

  @Override
  public boolean isEnabled() {
    return status.getEnabled();
  }
}

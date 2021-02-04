package com.microdemo.customer.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "USER_AUTH")
public class UserAuth {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "USER_ID", updatable = false, nullable = false, unique = true)
  private Customer user;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "ROLE_ID", updatable = false, nullable = false)
  private Role role;

  @Column(name = "PASSWD")
  private String passwd;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    UserAuth customer = (UserAuth) o;

    return id.equals(customer.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }

}
package com.easyprocess.core.org;

import java.util.Objects;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {

  private String userId;
  private String userName;

  @Override
  public boolean equals(Object o) {
    if (this == o) {return true;}
    if (o == null || getClass() != o.getClass()) {return false;}
    User user = (User) o;
    return Objects.equals(userId, user.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId);
  }
}

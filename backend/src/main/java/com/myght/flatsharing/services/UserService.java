package com.myght.flatsharing.services;

import com.myght.flatsharing.models.User;
import com.myght.flatsharing.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;

  public User getUser() {
    return userRepository.getOne(1);
  }
}

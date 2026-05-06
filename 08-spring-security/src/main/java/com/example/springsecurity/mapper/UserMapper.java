package com.example.springsecurity.mapper;

import com.example.springsecurity.entity.Role;
import com.example.springsecurity.entity.User;
import com.example.springsecurity.model.ApiModels.UserDto;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface UserMapper {

  @Mapping(target = "roles", source = "roles", qualifiedByName = "rolesToNames")
  UserDto toUserDto(User user);

  @Named("rolesToNames")
  default Set<String> rolesToNames(Set<Role> roles) {
    if (roles == null) {
      return null;
    }
    return roles.stream()
        .map(Role::getName)
        .collect(Collectors.toSet());
  }
}

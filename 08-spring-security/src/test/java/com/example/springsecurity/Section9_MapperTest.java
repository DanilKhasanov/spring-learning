package com.example.springsecurity;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.springsecurity.entity.Role;
import com.example.springsecurity.entity.User;
import com.example.springsecurity.mapper.UserMapper;
import com.example.springsecurity.model.ApiModels.UserDto;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class Section9_MapperTest {

  private final UserMapper userMapper;

  public Section9_MapperTest(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  @Test
  void shouldMapUserToUserDtoWithRoleNames() {
    // given
    Role role1 = new Role();
    role1.setName("ROLE_USER");

    Role role2 = new Role();
    role2.setName("ROLE_ADMIN");

    User user = new User();
    user.setId(1L);
    user.setUsername("john");
    user.setRoles(Set.of(role1, role2));

    // when
    UserDto dto = userMapper.toUserDto(user);

    // then
    assertThat(dto).isNotNull();
    assertThat(dto.id()).isEqualTo(1L);
    assertThat(dto.username()).isEqualTo("john");
    assertThat(dto.roles())
        .containsExactlyInAnyOrder("ROLE_USER", "ROLE_ADMIN");
  }
}
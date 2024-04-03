package org.chronopm.chronopmspringapi.services;

import org.chronopm.chronopmspringapi.dtos.UserDto;
import org.chronopm.chronopmspringapi.mappers.UserMapper;
import org.chronopm.chronopmspringapi.models.DeleteResponse;
import org.chronopm.chronopmspringapi.models.User;
import org.chronopm.chronopmspringapi.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements EntityService<UserDto> {
    private final IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getById(String id) {
        return UserMapper.mapToDto(getUserById(id));
    }

    @Override
    public UserDto create(UserDto dto) {
        var user = userRepository.save(UserMapper.mapToModel(dto));
        return UserMapper.mapToDto(user);
    }

    @Override
    public UserDto update(UserDto dto, String id) {
        var user = getUserById(id);
        var updateUser = UserMapper.mapForUpdate(dto);
        updateUser.setId(user.getId());
        userRepository.save(updateUser);
        return UserMapper.mapToDto(updateUser);
    }

    @Override
    public DeleteResponse<UserDto> delete(String id) {
        var userDto = UserMapper.mapToDto(getUserById(id));
        userRepository.deleteById(id);

        return DeleteResponse.<UserDto>builder()
                .entity(userDto)
                .message("Deleted Successful")
                .build();
    }

    private User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));

    }
}

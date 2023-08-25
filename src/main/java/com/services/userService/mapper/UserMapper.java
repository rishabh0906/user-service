package com.services.userService.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import com.services.userService.models.User;
import com.services.userService.models.UserPayload;

@Mapper(componentModel = "spring" , nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL )
public interface UserMapper {

    public UserPayload toPayload(User source);

    public User toUser(UserPayload source);


    
}

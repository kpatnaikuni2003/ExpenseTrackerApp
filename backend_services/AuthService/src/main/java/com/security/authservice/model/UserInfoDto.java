package com.security.authservice.model;

import com.security.authservice.entities.UserInfo;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming (PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserInfoDto extends UserInfo
{

    @Nonnull
    private String firstName; // first_name

    @Nonnull
    private String lastName; //last_name

    @Nonnull
    private Long phoneNumber;

    @Nonnull
    private String email; // email


}

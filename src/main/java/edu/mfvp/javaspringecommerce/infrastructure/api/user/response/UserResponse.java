package edu.mfvp.javaspringecommerce.infrastructure.api.user.response;

public record UserResponse(
    Long id,
    String name,
    String email,
    String phone
) {

}

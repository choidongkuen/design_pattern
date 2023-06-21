package com.example.designpattern.dto.order;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequestDto {

    @NotNull
    private Long userId;

    @NotNull
    private Long productId;

    @NotBlank
    @Size(max = 255)
    private String receiver;

    @NotBlank
    @Size(max = 255)
    private String sender;

    @NotBlank
    @Size(max = 255)
    private String telephone;

    @Size(max = 255)
    private String orderComment;
}

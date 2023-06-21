package com.example.designpattern.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequestDto {

    @NotBlank
    @Size(max = 255)
    private String name;

    @NotNull
    private Integer price;

    @NotNull
    private Integer salePrice;
}

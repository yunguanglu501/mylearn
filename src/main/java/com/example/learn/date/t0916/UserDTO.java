package com.example.learn.date.t0916;

/**
 * UserDTO
 *
 * @author wcy
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String name;
    private String sex;
}

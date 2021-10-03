package com.itechart;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(includeFieldNames = false)
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
//@Data(staticConstructor = "of")
public class UserDtoV2 {

    @Setter(AccessLevel.PACKAGE)
    private Long id;
    private String name;
    private String lastName;
    private Integer age;
}

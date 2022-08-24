package com.sofka.JavaBackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "cyclist")
@NoArgsConstructor
@AllArgsConstructor
public class Cyclist {
    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String cyclistNumber;
    private String teamCode;
    private String nationality;
}

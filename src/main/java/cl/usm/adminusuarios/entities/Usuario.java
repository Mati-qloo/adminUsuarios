package cl.usm.adminusuarios.entities;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Encrypted;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "usuarios")
public class Usuario implements Serializable {
    @Id
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    private String clave;
}

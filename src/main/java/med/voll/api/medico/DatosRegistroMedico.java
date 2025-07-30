package med.voll.api.medico;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.direccion.DatosDireccion;

// La anotación not blank es para strings.
public record DatosRegistroMedico(@NotBlank String nombre,
                                  @NotBlank @Email String email, // con la anotación Email considera que tenga formato de email.
                                  @NotBlank String telefono,
                                  @NotBlank @Pattern(regexp = "\\d{9,12}") String documento,
                                  @NotNull Especialidad especialidad, // aquí se debe validar con not null por que es un enum.
                                  @JsonAlias("direccion") @NotNull @Valid DatosDireccion datosDireccion) {
}

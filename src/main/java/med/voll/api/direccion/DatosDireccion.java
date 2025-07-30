package med.voll.api.direccion;


import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DatosDireccion(@NotBlank String calle,
                             String numero,
                             String complemento,
                             @NotBlank String barrio,
                             @JsonAlias("codigo_postal") @NotBlank @Pattern(regexp = "\\d{1,4}") String codigoPostal,
                             @NotBlank String ciudad,
                             @NotBlank String estado) {
}

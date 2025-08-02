package med.voll.api.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.direccion.DatosDireccion;

public record DatosActualizacionMedico(
        @NotNull Long id, // el id siempre debe venir
        String nombre,
        String telefono,
        DatosDireccion direccion
) {

}

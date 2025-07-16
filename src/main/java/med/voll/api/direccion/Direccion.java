package med.voll.api.direccion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public record Direccion(String calle,
                        String numero,
                        String complemento,
                        String barrio,
                        String codigoPostal,
                        String ciudad,
                        String estado) {
}

package med.voll.api.direccion;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter // crea internamente los getters de los atributos
@NoArgsConstructor // crea un contructor vacio
@AllArgsConstructor // crea un contructor con todos los atributos
public class Direccion {
    private String calle;
    private String numero;
    private String complemento;
    private String barrio;


    private String codigo_postal;
    private String ciudad;
    private String estado;


    public Direccion(DatosDireccion datosDireccion) {
        this.calle = datosDireccion.calle();
        this.numero = datosDireccion.numero();
        this.complemento  = datosDireccion.complemento();
        this.barrio = datosDireccion.barrio();
        this.codigo_postal = datosDireccion.codigoPostal();
        this.ciudad = datosDireccion.ciudad();
        this.estado = datosDireccion.estado();
    }

    public void actualizarDireccion(DatosDireccion direccion) {

        if (direccion.calle() != null) {
            this.calle = direccion.calle();
        }

        if (direccion.numero() != null && !direccion.numero().isBlank()) {
            this.numero = direccion.numero();
        }

        if (direccion.complemento() != null) {
            this.complemento = direccion.complemento();
        }

        if (direccion.barrio() != null && !direccion.barrio().isBlank()) {
            this.barrio = direccion.barrio();
        }

        if (direccion.codigoPostal() != null && !direccion.codigoPostal().isBlank()) {
            this.codigo_postal = direccion.codigoPostal();
        }

        if (direccion.ciudad() != null && !direccion.ciudad().isBlank()) {
            this.ciudad = direccion.ciudad();
        }

        if (direccion.estado() != null && !direccion.estado().isBlank()) {
            this.estado = direccion.estado();
        }
    }
}

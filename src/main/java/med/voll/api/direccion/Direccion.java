package med.voll.api.direccion;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
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


    public Direccion() {
    }

    public Direccion(DatosDireccion datosDireccion) {
        this.calle = datosDireccion.calle();
        this.numero = datosDireccion.numero();
        this.complemento  = datosDireccion.complemento();
        this.barrio = datosDireccion.barrio();
        this.codigo_postal = datosDireccion.codigoPostal();
        this.ciudad = datosDireccion.ciudad();
        this.estado = datosDireccion.estado();
    }
}

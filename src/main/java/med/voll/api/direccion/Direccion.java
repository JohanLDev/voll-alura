package med.voll.api.direccion;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter // crea internamente los getters de los atributos
@NoArgsConstructor // crea un contructor vacio
@AllArgsConstructor // crea un contructor con todos los atributos
@Embeddable
public class Direccion {
    private String calle;
    private String numero;
    private String complemento;
    private String barrio;
    private String codigoPostal;
    private String ciudad;
    private String estado;
}

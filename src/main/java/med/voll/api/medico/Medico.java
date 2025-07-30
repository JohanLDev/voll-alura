package med.voll.api.medico;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.direccion.Direccion;

@Table(name = "medicos")
@Entity(name = "Medico")
@AllArgsConstructor // crea un contructor con todos los atributos
@EqualsAndHashCode(of = "id")
@Getter // crea internamente los getters de los atributos
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nombre;
    private String email;
    private String documento;
    private String telefono;

    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;

    // esta anotación indica que los atributos de dirección son solo campos de la tabla médico
    @Embedded
    private Direccion direccion;

    public Medico() {
    }

    public Medico(DatosRegistroMedico datos) {
        this.id = null;
        this.nombre = datos.nombre();
        this.email = datos.email();
        this.documento = datos.documento();
        this.especialidad = datos.especialidad();
        this.direccion = new Direccion(datos.datosDireccion());
        this.telefono = datos.telefono();
    }
}

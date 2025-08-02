package med.voll.api.medico;

public record DatosListaMedico(
        Long id,
        String nombre,
        String telefono,
        String email,
        String documento,
        Especialidad especialidad
) {

    public DatosListaMedico(Medico medico) {
        this(
                medico.getId(),
                medico.getNombre(),
                medico.getTelefono(),
                medico.getEmail(),
                medico.getDocumento(),
                medico.getEspecialidad());
    }
}

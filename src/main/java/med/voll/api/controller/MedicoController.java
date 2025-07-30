package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DatosRegistroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    // Inyección de dependencias.
    @Autowired
    private MedicoRepository repository;

    // Debe ir siempre el transactional si queremos registrar datos en la base de datos.
    // La anotación valid es para que considere validar las validaciones que están dentro del objeto parámetro.
    @Transactional
    @PostMapping()
    public void registrar(@RequestBody  @Valid DatosRegistroMedico datos){
        repository.save(new Medico(datos));
    }

}

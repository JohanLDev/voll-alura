package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DatosListaMedico;
import med.voll.api.medico.DatosRegistroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    // Inyección de dependencias.
    @Autowired
    private MedicoRepository repository;

    // Debe ir siempre el transactional si queremos registrar o modificar datos en la base de datos.
    // La anotación valid es para que considere validar las validaciones que están dentro del objeto parámetro.
    @Transactional
    @PostMapping()
    public void registrar(@RequestBody  @Valid DatosRegistroMedico datos){
        repository.save(new Medico(datos));
    }


    @GetMapping
    public List<DatosListaMedico> listar(){
        return repository.findAll()
                .stream()
                .map(DatosListaMedico::new)
                .toList();
    }

}

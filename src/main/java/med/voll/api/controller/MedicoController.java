package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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


//    @GetMapping
//    public List<DatosListaMedico> listar(){
//        return repository.findAll().stream().map(DatosListaMedico::new).toList();
//    }

    // Devolver con paginación para que asi limite la cantidad de resultados.
    // Por defecto se consultaran solo 10 resultados y ordenados por nombre de manera ascendente.
    @GetMapping
    public Page<DatosListaMedico> listar(@PageableDefault(size = 10, sort = {"nombre"}) Pageable paginacion){
        return repository.findAll(paginacion).map(DatosListaMedico::new);
    }

    @Transactional
    @PutMapping
    public void actualizar(@RequestBody  @Valid DatosActualizacionMedico datos){
        // MARAVILLOSO: Solo por la notación transactional, esto se actualiza automaticamente
        // Internamente sabe que obtenemos el médico por referencia, y al actualizar el objeto, este lo actualizará.
          var medico = repository.getReferenceById(datos.id());
          medico.actualizarInformaciones(datos);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.eliminar();
    }

}

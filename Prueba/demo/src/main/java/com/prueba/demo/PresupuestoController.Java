import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/presupuestos")
public class PresupuestoController {

    @Autowired
    private PresupuestoService presupuestoService;

    @GetMapping
    public ResponseEntity<List<Presupuesto>> getAllPresupuestos() {
        List<Presupuesto> presupuestos = presupuestoService.getAllPresupuestos();
        return new ResponseEntity<>(presupuestos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Presupuesto> getPresupuestoById(@PathVariable("id") Long id) {
        Optional<Presupuesto> presupuesto = presupuestoService.getPresupuestoById(id);
        return presupuesto.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Presupuesto> createPresupuesto(@RequestBody Presupuesto presupuesto) {
        Presupuesto createdPresupuesto = presupuestoService.createPresupuesto(presupuesto);
        return new ResponseEntity<>(createdPresupuesto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Presupuesto> updatePresupuesto(@PathVariable("id") Long id, @RequestBody Presupuesto presupuesto) {
        Presupuesto updatedPresupuesto = presupuestoService.updatePresupuesto(id, presupuesto);
        return new ResponseEntity<>(updatedPresupuesto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePresupuesto(@PathVariable("id") Long id) {
        presupuestoService.deletePresupuesto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

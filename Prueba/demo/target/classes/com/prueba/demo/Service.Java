import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class Service {

    @Autowired
    private PresupuestoRepository presupuestoRepository;

    public List<Presupuesto> getAllPresupuestos() {
        return presupuestoRepository.findAll();
    }

    public Optional<Presupuesto> getPresupuestoById(Long id) {
        return presupuestoRepository.findById(id);
    }

    public Presupuesto createPresupuesto(Presupuesto presupuesto) {
        return presupuestoRepository.save(presupuesto);
    }

    public Presupuesto updatePresupuesto(Long id, Presupuesto presupuesto) {
        presupuesto.setId(id);
        return presupuestoRepository.save(presupuesto);
    }

    public void deletePresupuesto(Long id) {
        presupuestoRepository.deleteById(id);
    }
}

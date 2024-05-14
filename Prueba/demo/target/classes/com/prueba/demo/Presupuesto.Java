import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "presupuesto")
public class Presupuesto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private BigDecimal donacion;
    
    @Column(nullable = false)
    private BigDecimal gasto;
    
    @Column(nullable = false)
    private BigDecimal ingreso;
    
    @Column(nullable = false)
    private BigDecimal total;

    // Constructores, getters y setters
    
    public Presupuesto() {
        // Constructor vacío requerido por JPA
    }

    public Presupuesto(BigDecimal donacion, BigDecimal gasto, BigDecimal ingreso) {
        this.donacion = donacion;
        this.gasto = gasto;
        this.ingreso = ingreso;
        this.total = calcularTotal();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getDonacion() {
        return donacion;
    }

    public void setDonacion(BigDecimal donacion) {
        this.donacion = donacion;
        this.total = calcularTotal();
    }

    public BigDecimal getGasto() {
        return gasto;
    }

    public void setGasto(BigDecimal gasto) {
        this.gasto = gasto;
        this.total = calcularTotal();
    }

    public BigDecimal getIngreso() {
        return ingreso;
    }

    public void setIngreso(BigDecimal ingreso) {
        this.ingreso = ingreso;
        this.total = calcularTotal();
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    // Método para calcular el total
    private BigDecimal calcularTotal() {
        return donacion + ingreso - gasto;
    }
}

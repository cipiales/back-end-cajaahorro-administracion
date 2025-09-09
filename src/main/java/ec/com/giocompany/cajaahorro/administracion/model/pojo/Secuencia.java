package ec.com.giocompany.cajaahorro.administracion.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor  // <-- NECESARIO para que Jackson pueda crear la instancia
@AllArgsConstructor
public class Secuencia {

    private String codigoSecuencia;
    private String nombreSecuencia;
    private String descripcionSecuencia;
    private String valorSecuencia;
}

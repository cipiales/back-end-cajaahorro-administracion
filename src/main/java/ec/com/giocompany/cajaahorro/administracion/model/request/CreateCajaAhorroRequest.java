package ec.com.giocompany.cajaahorro.administracion.model.request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCajaAhorroRequest {
    private String estado;
    private String nombreCajaAhorro;
    private Integer numeroSocios;
    private Integer tiempoCiclo;
    private String usuarioRegistro;
    private Timestamp fechaRegistro;
    private String usuarioModificacion;
    private Timestamp fechaActualizacion;
    private Integer diaSemanaReunion;
    private Integer tiempociclo;
}

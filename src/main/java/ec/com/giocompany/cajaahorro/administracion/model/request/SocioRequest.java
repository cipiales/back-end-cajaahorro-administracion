package ec.com.giocompany.cajaahorro.administracion.model.request;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SocioRequest {
    private String cedulaIdentidad;
    private String direccion;
    private String estado;
    private String primerApellido;
    private String primerNombre;
    private String segundoApellido;
    private String segundoNombre;
    private String sexo;
    private String nombreCompleto;
    private String telefonoCelular;
    private String telefonoConvencional;
    private String codigoSocio;
    private String usuarioRegistro;
    private Timestamp fechaRegistro;
    private String usuarioModificacion;
    private Timestamp fechaActualizacion;
}

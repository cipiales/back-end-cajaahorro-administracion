package ec.com.giocompany.cajaahorro.administracion.model.request;

import ec.com.giocompany.cajaahorro.administracion.model.pojo.Socio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCuentaRequest {


	private String cedulaIdentidad;
	private String estado;
	private String codigoCajaAhorro;
	private String usuarioRegistro;
	private Timestamp fechaRegistro;
	private String usuarioModificacion;
	private Timestamp fechaActualizacion;

	private SocioRequest socio;

	/*private String direccion;

	private String primerApellido;
	private String primerNombre;
	private String segundoApellido;
	private String segundoNombre;
	private String sexo;
	private String nombreCompleto;
	private String telefonoCelular;
	private String telefonoConvencional;
	private String codigoSocio;*/






	//private Socio socio;
}

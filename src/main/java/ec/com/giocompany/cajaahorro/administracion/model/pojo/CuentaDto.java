package ec.com.giocompany.cajaahorro.administracion.model.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CuentaDto {
	private String codigoCuenta;
	private String cedulaIdentidad;
	private String estado;
	private String codigoCajaAhorro;
	private String usuarioRegistro;
	private Timestamp fechaRegistro;
	private String usuarioModificacion;
	private Timestamp fechaModificacion;
	private Socio socio;

}

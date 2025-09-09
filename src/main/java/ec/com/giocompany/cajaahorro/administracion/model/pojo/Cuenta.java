package ec.com.giocompany.cajaahorro.administracion.model.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Entity
@Table(name = "gscatcuenta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

public class Cuenta {

	@Id
	@Column(name = "CODIGOCUENTA", nullable = false)
	private String codigoCuenta;



	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CEDULAIDENTIDAD", referencedColumnName = "cedulaidentidad")
	private Socio socio;

	@Column(name="USUARIOREGISTRO", nullable=false)
	private String usuarioRegistro;
	@Column(name="FECHAREGISTRO", nullable=false)
	private Timestamp fechaRegistro;
	@Column(name="USUARIOACTUALIZACION", nullable=true)
	private String usuarioModificacion;
	@Column(name="FECHAACTUALIZACION", nullable=true)
	private Timestamp fechaModificacion;
	/*Fin Auditoria*/
	@Column(name="ESTADO", nullable=false)
	private String estado;
	@Column(name="CODIGOCAJAAHORRO", nullable=true)
	private String codigoCajaAhorro;
	/*@ManyToOne
	@JoinColumn(name = "CEDULAIDENTIDAD")*/







	public void update(ec.com.giocompany.cajaahorro.administracion.model.pojo.CuentaDto cuentaDto) {
		//this.id = cuentaDto.;
		//this.socio.getCedulaIdentidad() = cuentaDto.getCodigoCuenta();
		this.codigoCuenta = cuentaDto.getCodigoCuenta();
		this.codigoCajaAhorro = cuentaDto.getCodigoCajaAhorro();
		this.estado = cuentaDto.getEstado();
		this.usuarioRegistro = cuentaDto.getUsuarioRegistro();
		this.usuarioModificacion = cuentaDto.getUsuarioModificacion();
		this.fechaRegistro = cuentaDto.getFechaRegistro();
		this.fechaModificacion = cuentaDto.getFechaModificacion();
		this.socio = cuentaDto.getSocio();
	}

}

package ec.com.giocompany.cajaahorro.administracion.model.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "gscatsocio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Socio {


    @Id
    @Column(name = "cedulaidentidad", nullable = false)
    private String cedulaIdentidad;

    @Column(name="DIRECCION")
    private String direccion;
    @Column(name="ESTADO")
    private String estado;
    @Column(name="PRIMERAPELLIDO")
    private String primerApellido;
    @Column(name="PRIMERNOMBRE")
    private String primerNombre;
    @Column(name="SEGUNDOAPELLIDO")
    private String segundoApellido;
    @Column(name="SEGUNDONOMBRE")
    private String segundoNombre;
    @Column(name="SEXO")
    private String sexo;
    @Column(name="NOMBRECOMPLETO")
    private String nombreCompleto;
    @Column(name="TELEFONOCELULAR")
    private String telefonoCelular;
    @Column(name="TELEFONOCONVENCIONAL")
    private String telefonoConvencional;
    @Column(name="CODIGOSOCIO")
    private String codigoSocio;
    /*Auditoria*/
    @Column(name="USUARIOREGISTRO", nullable=false)
    private String usuarioRegistro;
    @Column(name="FECHAREGISTRO", nullable=false)
    private Timestamp fechaRegistro;
    @Column(name="USUARIOACTUALIZACION", nullable=true)
    private String usuarioModificacion;
    @Column(name="FECHAACTUALIZACION", nullable=true)
    private Timestamp fechaModificacion;
    /*Fin Auditoria*/


}

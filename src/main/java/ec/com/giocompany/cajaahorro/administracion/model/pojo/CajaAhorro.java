package ec.com.giocompany.cajaahorro.administracion.model.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "gscatcajaahorro")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CajaAhorro {
    @Id
    @Column(name="CODIGOCAJAAHORRO", nullable=false)
    private String codigoCajaAhorro;
    @Column(name="ESTADO", nullable=false)
    private String estado;
    @Column(name="NOMBRECAJAAHORRO", nullable=false)
    private String nombreCajaAhorro;
    @Column(name="NUMEROSOCIOS",nullable=true )
    private Integer numeroSocios;
    @Column(name="TIEMPOCICLO",nullable=true )
    private Integer tiempoCiclo;
    @Column(name="USUARIOREGISTRO", nullable=false)
    private String usuarioRegistro;
    @Column(name="FECHAREGISTRO", nullable=false)
    private Timestamp fechaRegistro;
    @Column(name="USUARIOACTUALIZACION", nullable=true)
    private String usuarioModificacion;
    @Column(name="FECHAACTUALIZACION", nullable=true)
    private Timestamp fechaModificacion;
    @Column(name="DIASEMANAREUNION" ,nullable=true)
    private Integer diaSemanaReunion;

}




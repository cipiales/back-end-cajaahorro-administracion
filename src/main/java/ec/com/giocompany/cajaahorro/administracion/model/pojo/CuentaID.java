package ec.com.giocompany.cajaahorro.administracion.model.pojo;


import java.io.Serializable;
import java.util.Objects;

public class CuentaID implements Serializable {
    private String codigoCuenta;
    private String cedulaIdentidad; // NO 'socio'


    public CuentaID() {}

    public CuentaID(String codigoCuenta, String cedulaIdentidad) {
        this.codigoCuenta = codigoCuenta;
        this.cedulaIdentidad = cedulaIdentidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CuentaID)) return false;
        CuentaID that = (CuentaID) o;
        return Objects.equals(codigoCuenta, that.codigoCuenta) &&
                Objects.equals(cedulaIdentidad, that.cedulaIdentidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoCuenta, cedulaIdentidad);
    }
}

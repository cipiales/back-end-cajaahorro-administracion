package ec.com.giocompany.cajaahorro.administracion.service;

import ec.com.giocompany.cajaahorro.administracion.model.pojo.CajaAhorro;
import ec.com.giocompany.cajaahorro.administracion.model.pojo.Cuenta;
import ec.com.giocompany.cajaahorro.administracion.model.request.CreateCajaAhorroRequest;
import ec.com.giocompany.cajaahorro.administracion.model.request.CreateCuentaRequest;

import java.util.List;

public interface AdministracionService {
	
	//List<User> getProducts(String name, String country, String description, Boolean visible);
	
	Cuenta buscarUsuario(String userId);

	List<Cuenta> getCuentas(String codigoCuenta, String cedulaIdentidad, String estado,String codigoCajaAhorro);
	//Boolean removeProduct(String productId);
	
	Cuenta createCuenta(CreateCuentaRequest request);

	CajaAhorro createCajaAhorro(CreateCajaAhorroRequest request);

	List<CajaAhorro> getCajasAhorro(String codigoCajaAhorro, String nombreCajaAhorro, String estado);


	//User updateProduct(String productId, String updateRequest);

	//User updateProduct(String productId, UserDto updateRequest);

}

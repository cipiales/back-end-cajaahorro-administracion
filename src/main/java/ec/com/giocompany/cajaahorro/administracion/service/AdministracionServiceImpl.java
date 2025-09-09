package ec.com.giocompany.cajaahorro.administracion.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import ec.com.giocompany.cajaahorro.administracion.data.CajaAhorroRepository;
import ec.com.giocompany.cajaahorro.administracion.data.CajaAhorroRepository;
import ec.com.giocompany.cajaahorro.administracion.data.CuentaRepository;
import ec.com.giocompany.cajaahorro.administracion.facade.SecuenciaFacade;
import ec.com.giocompany.cajaahorro.administracion.model.pojo.CajaAhorro;
import ec.com.giocompany.cajaahorro.administracion.model.pojo.Secuencia;
import ec.com.giocompany.cajaahorro.administracion.model.pojo.Socio;
import ec.com.giocompany.cajaahorro.administracion.model.request.CreateCajaAhorroRequest;
import ec.com.giocompany.cajaahorro.administracion.model.request.CreateCuentaRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.giocompany.cajaahorro.administracion.model.pojo.Cuenta;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Slf4j
public class AdministracionServiceImpl implements ec.com.giocompany.cajaahorro.administracion.service.AdministracionService {

	@Autowired
	private CuentaRepository repository;

	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private SecuenciaFacade secuenciaFacade;
	@Autowired
	private CajaAhorroRepository repositoryCajaAhorro;



	@Override
	public Cuenta buscarUsuario(String userId) {
		return repository.buscarUsuarioPorId(userId);
	}

	@Override
	public List<Cuenta>getCuentas(String codigoCuenta, String numeroIdentificacion, String estado,String codigoCajaAhorro) {

		return repository.getCuentas(codigoCuenta,numeroIdentificacion,estado,codigoCajaAhorro);
	}




	@Override
	@Transactional
	public Cuenta createCuenta(CreateCuentaRequest request) {
		if (request == null || !StringUtils.hasLength(request.getEstado()) ||
				!StringUtils.hasLength(request.getCodigoCajaAhorro()) ||
				request.getFechaRegistro() == null ||
				request.getUsuarioRegistro() == null) {

			return null;
		}

		Secuencia secuencia = secuenciaFacade.getSecuencia("SECUENCIA_CUENTA");

		Socio socio =new Socio();
		socio.setCedulaIdentidad(request.getSocio().getCedulaIdentidad());
		Cuenta cuenta = Cuenta.builder()
				.codigoCuenta(secuencia.getValorSecuencia())

				.codigoCajaAhorro(request.getCodigoCajaAhorro())
				.estado(request.getEstado())
				.usuarioRegistro(request.getUsuarioRegistro())
				.fechaRegistro(request.getFechaRegistro())
				.socio(socio)
				.build();
		return repository.save(cuenta);
	}

	@Override
	public CajaAhorro createCajaAhorro(CreateCajaAhorroRequest request) {
		if (request == null || !StringUtils.hasLength(request.getEstado()) ||
				!StringUtils.hasLength(request.getNombreCajaAhorro()) ||
				request.getFechaRegistro() == null ||
				request.getUsuarioRegistro() == null) {

			return null;
		}

		Secuencia secuencia = secuenciaFacade.getSecuencia("SECUENCIA_CAJA");


		CajaAhorro cajaAhorro = CajaAhorro.builder()
				.codigoCajaAhorro(secuencia.getValorSecuencia())
				.nombreCajaAhorro(request.getNombreCajaAhorro())
				.estado(request.getEstado())
				.usuarioRegistro(request.getUsuarioRegistro())
				.fechaRegistro(request.getFechaRegistro())
				.diaSemanaReunion(request.getDiaSemanaReunion())
				.tiempoCiclo(request.getTiempoCiclo())
				.numeroSocios(request.getNumeroSocios())
				.build();
		return repositoryCajaAhorro.save(cajaAhorro);
	}

	@Override
	public List<CajaAhorro> getCajasAhorro(String codigoCajaAhorro, String nombreCajaAhorro, String estado) {
		return repositoryCajaAhorro.getCajasAhorro(codigoCajaAhorro,nombreCajaAhorro,estado);
	}










	/*@Override
	public User updateProduct(String productId, String request) {

		//PATCH se implementa en este caso mediante Merge Patch: https://datatracker.ietf.org/doc/html/rfc7386
		User product = repository.getById(Long.valueOf(productId));
		if (product != null) {
			try {
				JsonMergePatch jsonMergePatch = JsonMergePatch.fromJson(objectMapper.readTree(request));
				JsonNode target = jsonMergePatch.apply(objectMapper.readTree(objectMapper.writeValueAsString(product)));
				User patched = objectMapper.treeToValue(target, User.class);
				repository.save(patched);
				return patched;
			} catch (JsonProcessingException | JsonPatchException e) {
				log.error("Error updating product {}", productId, e);
                return null;
            }
        } else {
			return null;
		}
	}

	@Override
	public User updateProduct(String productId, UserDto updateRequest) {
		User product = repository.getById(Long.valueOf(productId));
		if (product != null) {
			product.update(updateRequest);
			repository.save(product);
			return product;
		} else {
			return null;
		}
	}*/

}

package ec.com.giocompany.cajaahorro.administracion.data;

import ec.com.giocompany.cajaahorro.administracion.model.pojo.CajaAhorro;
import org.springframework.data.jpa.repository.JpaRepository;
import ec.com.giocompany.cajaahorro.administracion.model.pojo.Cuenta;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

interface CajaAhorroJpaRepository extends JpaRepository<CajaAhorro, Long>, JpaSpecificationExecutor<CajaAhorro> {


	/*List<User> findByName(String name);

	List<User> findByCountry(String country);

	List<User> findByVisible(Boolean visible);

	List<User> findByNameAndCountry(String name, String country);*/

}

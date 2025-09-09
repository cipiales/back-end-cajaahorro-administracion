package ec.com.giocompany.cajaahorro.administracion.data;

import org.springframework.data.jpa.repository.JpaRepository;
import ec.com.giocompany.cajaahorro.administracion.model.pojo.Cuenta;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

interface CuentaJpaRepository extends JpaRepository<Cuenta, Long>, JpaSpecificationExecutor<Cuenta> {


	/*List<User> findByName(String name);

	List<User> findByCountry(String country);

	List<User> findByVisible(Boolean visible);

	List<User> findByNameAndCountry(String name, String country);*/

}

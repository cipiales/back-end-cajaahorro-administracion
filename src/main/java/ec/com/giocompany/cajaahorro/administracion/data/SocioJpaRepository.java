package ec.com.giocompany.cajaahorro.administracion.data;
import ec.com.giocompany.cajaahorro.administracion.model.pojo.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.Optional;

interface SocioJpaRepository extends JpaRepository<Socio, Long>, JpaSpecificationExecutor<Socio> {

    Optional<Socio> findByCedulaIdentidad(String cedulaIdentidad);

	/*List<User> findByName(String name);

	List<User> findByCountry(String country);

	List<User> findByVisible(Boolean visible);

	List<User> findByNameAndCountry(String name, String country);*/

}

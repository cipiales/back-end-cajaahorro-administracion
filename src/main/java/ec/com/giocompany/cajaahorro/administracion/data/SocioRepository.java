package ec.com.giocompany.cajaahorro.administracion.data;

import ec.com.giocompany.cajaahorro.administracion.data.utils.SearchCriteria;
import ec.com.giocompany.cajaahorro.administracion.data.utils.SearchOperation;
import ec.com.giocompany.cajaahorro.administracion.data.utils.SearchStatement;
import ec.com.giocompany.cajaahorro.administracion.model.pojo.Cuenta;
import ec.com.giocompany.cajaahorro.administracion.model.pojo.Socio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
@RequiredArgsConstructor


@RestController

@Slf4j
public class SocioRepository {

    private final SocioJpaRepository repository;
    public Socio getById(Long id) {
        return repository.findById(id).orElse(null);
    }
    public Socio save(Socio socio) {
        return repository.save(socio);
    }


    public Optional<Socio> findByCedulaIdentidad(String cedulaIdentidad) {
        return  repository.findByCedulaIdentidad(cedulaIdentidad);
    }
}

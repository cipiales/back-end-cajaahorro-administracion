package ec.com.giocompany.cajaahorro.administracion.data;

import ec.com.giocompany.cajaahorro.administracion.data.utils.SearchCriteria;
import ec.com.giocompany.cajaahorro.administracion.data.utils.SearchOperation;
import ec.com.giocompany.cajaahorro.administracion.data.utils.SearchStatement;
import ec.com.giocompany.cajaahorro.administracion.model.pojo.Cuenta;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor


@RestController

@Slf4j
public class CuentaRepository {

    private final CuentaJpaRepository repository;

    public Cuenta getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Cuenta buscarUsuarioPorId(String  userId) {
        SearchCriteria<Cuenta> spec = new SearchCriteria<>();
        if (StringUtils.isNotBlank(userId)) {
            spec.add(new SearchStatement("userId", userId, SearchOperation.MATCH));
        }

        List<Cuenta> resultados = repository.findAll(spec);
        log.info("resultados:", resultados);

        if (resultados == null) {
            return null;  // No encontrado
        } else if (resultados.size() != 1) {
            return null; // No encontrado
        } else {
            return resultados.get(0);  // Devuelve el encontrado
        }
    }


    public List<Cuenta>  getCuentas1(String  codigoCuenta, String cedulaIdentidad,String estado) {
        SearchCriteria<Cuenta> spec = new SearchCriteria<>();

        if (StringUtils.isNotBlank(codigoCuenta)) {
            log.info("Ingresa por esta opcion 1");
            spec.add(new SearchStatement("codigoCuenta", codigoCuenta, SearchOperation.EQUAL));
        }
        if (StringUtils.isNotBlank(cedulaIdentidad)) {
            log.info("Ingresa por esta opcion 2");
            spec.add(new SearchStatement("socio.cedulaIdentidad", cedulaIdentidad, SearchOperation.EQUAL));
        }
        if (StringUtils.isNotBlank(estado)) {
            log.info("Ingresa por esta opcion 3");
            spec.add(new SearchStatement("estado", estado, SearchOperation.EQUAL));
        }

        log.info("cedulaIdentidad 123:", cedulaIdentidad);

        //spec.add(new SearchStatement("estado", estado, SearchOperation.EQUAL));

        List<Cuenta> resultados = repository.findAll(spec);

        log.info("resultados cuentas:", resultados);

        if (resultados == null) {
            return null;  // No encontrado
        } else if (resultados.size() != 1) {
            return null; // No encontrado
        } else {
            return resultados;  // Devuelve el encontrado
        }
    }


    public List<Cuenta>  getCuentas(String  codigoCuenta, String cedulaIdentidad,String estado,String codigoCajaAhorro) {
          SearchCriteria<Cuenta> spec = new SearchCriteria<>();
        if (!Objects.equals(codigoCuenta, "")) {
            spec.add(new SearchStatement("codigoCuenta", codigoCuenta, SearchOperation.EQUAL));
        }
        if (!Objects.equals(estado, "")) {
            spec.add(new SearchStatement("estado", estado, SearchOperation.EQUAL));
        }
        if (!Objects.equals(cedulaIdentidad, "")) {
            spec.add(new SearchStatement("socio.cedulaIdentidad", cedulaIdentidad,SearchOperation.EQUAL));
        }

        if (!Objects.equals(codigoCajaAhorro, "")) {
            spec.add(new SearchStatement("codigoCajaAhorro", codigoCajaAhorro, SearchOperation.EQUAL));
        }
        List<Cuenta> resultados = repository.findAll(spec);
        return resultados;
    }

    public Cuenta save(Cuenta cuenta) {
        return repository.save(cuenta);
    }




}

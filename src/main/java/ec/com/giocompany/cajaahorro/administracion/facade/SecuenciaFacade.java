package ec.com.giocompany.cajaahorro.administracion.facade;


import ec.com.giocompany.cajaahorro.administracion.model.pojo.Secuencia;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
@Slf4j
public class SecuenciaFacade {

    @Value("${getSecuencia.url}")
    private String getSecuenciaUrl;

    private final RestTemplate restTemplate;


    public Secuencia getSecuencia(String nombreSecuencia) {
        Secuencia secuencia = new Secuencia();
        secuencia.setNombreSecuencia(nombreSecuencia);
        secuencia.setDescripcionSecuencia(nombreSecuencia);

        try {
            log.info("Enviando solicitud POST a {} con body {}", getSecuenciaUrl, secuencia);
            return restTemplate.postForObject(getSecuenciaUrl, secuencia, Secuencia.class);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.error("Error HTTP: {}, ID {}", e.getStatusCode(), nombreSecuencia);
            return null;
        } catch (Exception e) {
            log.error("Error inesperado: {}, ID {}", e.getMessage(), nombreSecuencia);
            return null;
        }
    }
}

package ec.com.giocompany.cajaahorro.administracion.controller;

import java.util.List;
import java.util.Map;
import java.util.Collections;

import ec.com.giocompany.cajaahorro.administracion.model.pojo.CajaAhorro;
import ec.com.giocompany.cajaahorro.administracion.model.request.CreateCajaAhorroRequest;
import ec.com.giocompany.cajaahorro.administracion.model.request.CreateCuentaRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ec.com.giocompany.cajaahorro.administracion.model.pojo.Cuenta;
import ec.com.giocompany.cajaahorro.administracion.service.AdministracionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@RestController
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Cuentas Controller", description = "Microservicio encargado de exponer operaciones CRUD sobre productos alojados en una base de datos en memoria.")
public class AdministracionController {

    private final AdministracionService service;

    @GetMapping("/cuenta")
    @Operation(
            operationId = "obtener cuentas",
            description = "Operacion de lectura",
            summary = "Se devuelve listado de cuentas  almacenado en la base de datos.")
    @ApiResponse(
            responseCode = "200",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cuenta.class)))

    public ResponseEntity<List<Cuenta>> getCuentas(
            @RequestHeader Map<String, String> headers,
            @Parameter(name = "codigoCuenta", description = "Numero de  Cuenta", example = "2256895", required = false)
            @RequestParam(required = false) String codigoCuenta,
            @Parameter(name = "estado", description = "Estado de  Cuenta", example = "ACT", required = false)
            @RequestParam(required = false) String estado,
            @Parameter(name = "cedulaIdentidad", description = "Identificacion del dueñoo de la cuenta", example = "1003187851", required = false)
            @RequestParam(required = false) String cedulaIdentidad,
            @Parameter(name = "codigoCajaAhorro", description = "Codigo caja de ahorro", example = "2256895", required = false)
            @RequestParam(required = false) String codigoCajaAhorro
            ) {

        log.info("headers: {}", headers);
        log.info("codigoCuenta: ", codigoCuenta);
        log.info("cedulaIdentidad: ", cedulaIdentidad);
        log.info("estado: ", estado);
        log.info("codigoCajaAhorro: ", codigoCajaAhorro);
        List<Cuenta> cuentas = service.getCuentas(codigoCuenta, cedulaIdentidad,estado,codigoCajaAhorro);
        if (cuentas != null) {
            return ResponseEntity.ok(cuentas);
        } else {
            return ResponseEntity.ok(Collections.emptyList());
        }
    }

   /* @GetMapping("/users/{userId}")
    @Operation(
            operationId = "Obtener un usuario",
            description = "Operacion de lectura",
            summary = "Se devuelve un usuario a partir de su identificador.")
    @ApiResponse(
            responseCode = "200",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cuenta.class)))
    @ApiResponse(
            responseCode = "404",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "No se ha encontrado el usuario con el identificador indicado.")

    public ResponseEntity<Cuenta> buscarUsuario(@PathVariable String userId) {

        log.info("Request received for product {}", userId);
        Cuenta user = service.buscarUsuario(userId);

        log.info("Usuario Encontrado:", user);

        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }

    }*/
/*
    @DeleteMapping("/products/{productId}")
    @Operation(
            operationId = "Eliminar un producto",
            description = "Operacion de escritura",
            summary = "Se elimina un producto a partir de su identificador.")
    @ApiResponse(
            responseCode = "200",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)))
    @ApiResponse(
            responseCode = "404",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "No se ha encontrado el producto con el identificador indicado.")
    public ResponseEntity<Void> deleteProduct(@PathVariable String productId) {

        Boolean removed = service.removeProduct(productId);

        if (Boolean.TRUE.equals(removed)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }
*/

    @PostMapping("/cuenta")
    @Operation(
            operationId = "Insertar una cuenta",
            description = "Operacion de escritura",
            summary = "Se crea una cuenta a partir de sus datos.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos del producto a crear.",
                    required = true,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CreateCuentaRequest.class))))
    @ApiResponse(
            responseCode = "201",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cuenta.class)))
    @ApiResponse(
            responseCode = "400",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "Datos incorrectos introducidos.")
    @ApiResponse(
            responseCode = "404",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "No se ha encontrado el producto con el identificador indicado.")
    public ResponseEntity<Cuenta> addCuenta(@RequestBody CreateCuentaRequest request) {

        Cuenta createdCuenta = service.createCuenta(request);

        if (createdCuenta != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCuenta);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    @PostMapping("/cajaahorro")
    @Operation(
            operationId = "Insertar una nueva cajaahorro",
            description = "Operacion de escritura",
            summary = "Se crea una nueva caja ahorro a partir de sus datos.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos del producto a crear.",
                    required = true,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CreateCuentaRequest.class))))
    @ApiResponse(
            responseCode = "201",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cuenta.class)))
    @ApiResponse(
            responseCode = "400",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "Datos incorrectos introducidos.")
    @ApiResponse(
            responseCode = "404",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "No se ha encontrado el producto con el identificador indicado.")
    public ResponseEntity<CajaAhorro> addCajaAhorro(@RequestBody CreateCajaAhorroRequest request) {

        CajaAhorro createdCajaAhorro = service.createCajaAhorro(request);

        if (createdCajaAhorro != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCajaAhorro);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/cajaahorro")
    @Operation(
            operationId = "obtener cajaahorro",
            description = "Operacion de lectura",
            summary = "Se devuelve listado de cajaahorro  almacenado en la base de datos.")
    @ApiResponse(
            responseCode = "200",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Cuenta.class)))

    public ResponseEntity<List<CajaAhorro>> getCajasAhorro(
            @RequestHeader Map<String, String> headers,
            @Parameter(name = "codigoCajaAhorro", description = "Numero de  Caja Ahorro", example = "2256895", required = false)
            @RequestParam(required = false) String codigoCajaAhorro,
            @Parameter(name = "estado", description = "Estado de  Cuenta", example = "ACT", required = false)
            @RequestParam(required = false) String estado,
            @Parameter(name = "nombreCajaAhorro", description = "Nombre de la caja de ahorro", example = "Mujeres Unidas", required = false)
            @RequestParam(required = false) String nombreCajaAhorro) {

        log.info("headers: {}", headers);
        log.info("codigoCajaAhorro: ", codigoCajaAhorro);
        log.info("estado: ", estado);
        log.info("nombreCajaAhorro: ", nombreCajaAhorro);
        List<CajaAhorro> cajaAhorros = service.getCajasAhorro(codigoCajaAhorro, nombreCajaAhorro,estado);
        if (cajaAhorros != null) {
            return ResponseEntity.ok(cajaAhorros);
        } else {
            return ResponseEntity.ok(Collections.emptyList());
        }
    }



    /*
    @PatchMapping("/products/{productId}")
    @Operation(
            operationId = "Modificar parcialmente un producto",
            description = "RFC 7386. Operacion de escritura",
            summary = "RFC 7386. Se modifica parcialmente un producto.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos del producto a crear.",
                    required = true,
                    content = @Content(mediaType = "application/merge-patch+json", schema = @Schema(implementation = String.class))))
    @ApiResponse(
            responseCode = "200",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)))
    @ApiResponse(
            responseCode = "400",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "Producto inválido o datos incorrectos introducidos.")
    public ResponseEntity<User> patchProduct(@PathVariable String productId, @RequestBody String patchBody) {

        User patched = service.updateProduct(productId, patchBody);
        if (patched != null) {
            return ResponseEntity.ok(patched);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    @PutMapping("/products/{productId}")
    @Operation(
            operationId = "Modificar totalmente un producto",
            description = "Operacion de escritura",
            summary = "Se modifica totalmente un producto.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos del producto a actualizar.",
                    required = true,
                    content = @Content(mediaType = "application/merge-patch+json", schema = @Schema(implementation = UserDto.class))))
    @ApiResponse(
            responseCode = "200",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)))
    @ApiResponse(
            responseCode = "404",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "Producto no encontrado.")
    public ResponseEntity<User> updateProduct(@PathVariable String productId, @RequestBody UserDto body) {

        User updated = service.updateProduct(productId, body);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

   /* @PostMapping("/roles")
    @Operation(
            operationId = "Insertar un producto",
            description = "Operacion de escritura",
            summary = "Se crea un producto a partir de sus datos.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos del producto a crear.",
                    required = true,
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CreateUserRequest.class))))
    @ApiResponse(
            responseCode = "201",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)))
    @ApiResponse(
            responseCode = "400",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "Datos incorrectos introducidos.")
    @ApiResponse(
            responseCode = "404",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Void.class)),
            description = "No se ha encontrado el producto con el identificador indicado.")
    public ResponseEntity<User> addProduct(@RequestBody CreateUserRequest request) {

        User createdProduct = service.createProduct(request);

        if (createdProduct != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }*/



}

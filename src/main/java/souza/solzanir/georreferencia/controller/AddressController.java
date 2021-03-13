package souza.solzanir.georreferencia.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import souza.solzanir.georreferencia.model.dto.AddressRequestDTO;
import souza.solzanir.georreferencia.model.dto.AddressResponseDTO;
import souza.solzanir.georreferencia.service.AddressService;

import java.net.URI;
import java.util.List;

import static java.lang.String.format;
import static java.util.Objects.nonNull;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/public/")
public class AddressController {

    @Autowired
    private AddressService service;

    @ApiOperation(
            value = "Novo Endereço",
            notes = "Cadastro de novo endereço na base de dados",
            response = AddressResponseDTO.class
    )
    @PostMapping("/v1/address")
    public ResponseEntity<AddressResponseDTO> save(@Validated @RequestBody final AddressRequestDTO address) {
        AddressResponseDTO response = service.save(address);
        return ResponseEntity
                .created(URI.create(format("/api/public/v1/address/%d", response.getId())))
                .body(response);
    }

    @ApiOperation(
            value = "Obter Endereço por id",
            notes = "Recupera na base de dados o endereço referente ao id informado",
            response = AddressResponseDTO.class
    )
    @GetMapping("/v1/address/{id}")
    public ResponseEntity<AddressResponseDTO> getById(@PathVariable("id") Long addressId) {
        AddressResponseDTO response = service.getById(addressId);

        if (nonNull(response)) {
            return ResponseEntity.ok().body(response);

        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @ApiOperation(
            value = "Obter Endereço por CEP",
            notes = "Recupera na base de dados os endereços referentes ao CEP informado",
            response = AddressResponseDTO.class
    )
    @GetMapping("/v1/address/zipcode/{zipcode}")
    public ResponseEntity<List<AddressResponseDTO>> getByZipcode(@PathVariable("zipcode") Integer zipcode) {
        List<AddressResponseDTO> response = service.getByZipcode(zipcode);

        if (!response.isEmpty()) {
            return ResponseEntity.ok().body(response);

        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @ApiOperation(
            value = "Atualizar Endereço",
            notes = "Atualiza endereço na base de dados conforme valores informado",
            response = AddressResponseDTO.class
    )
    @PutMapping("/v1/address")
    public ResponseEntity<AddressResponseDTO> update(@Validated @RequestBody final AddressRequestDTO address) {
        AddressResponseDTO response = service.save(address);
        return ResponseEntity.ok().body(response);
    }

    @ApiOperation(
            value = "Remover Endereço",
            notes = "Remove o endereço referente ao id informado"
    )
    @DeleteMapping("/v1/address/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long addressId) {
        service.delete(addressId);
        return ResponseEntity.noContent().build();
    }
}
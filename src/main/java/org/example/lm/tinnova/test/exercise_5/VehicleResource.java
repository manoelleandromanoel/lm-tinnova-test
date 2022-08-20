package org.example.lm.tinnova.test.exercise_5;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.example.lm.tinnova.test.exercise_5.dto.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "Veiculos", tags = {"veiculos"})
@RequestMapping("/veiculos")
public interface VehicleResource {

    @ApiOperation(value = "Retorna todos os veículos", nickname = "getVehicles", notes = "Essa operação retorna todos os veículos.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso ao retornar todos os veículos",
            response = VehiclesResponseDTO.class)})
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<VehiclesResponseDTO> getVehicles();

    @ApiOperation(value = "Retorna os detalhes do veículo", nickname = "getVehicleById", notes = "Essa operação retorna os detalhes do veículo.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso ao retornar os detalhes do veículo",
            response = VehicleResponseDTO.class)})
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<VehicleResponseDTO> getVehicleById(
            @PathVariable(name = "id") Long vehicleId
    );

    @ApiOperation(value = "Adiciona um novo veículo", nickname = "postOrUpdateVehicle", notes = "Essa operação adiciona um novo veículo.")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Sucesso ao adicionar um novo veículo",
            response = VehicleResponseDTO.class)})
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<VehicleResponseDTO> postVehicle(
            @RequestBody VehicleRequestDTO vehicleRequestDTO
    );

    @ApiOperation(value = "Atualiza os dados de um veículo", nickname = "putVehicle", notes = "Essa operação atualiza os dados de um veículo.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso ao atualizar os dados de um veículo",
            response = VehicleResponseDTO.class)})
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<VehicleResponseDTO> putVehicle(
            @PathVariable(name = "id") Long vehicleId,
            @RequestBody VehicleRequestDTO vehicleRequestDTO
    );

    @ApiOperation(value = "Atualiza apenas alguns dados do veículo", nickname = "patchVehicle", notes = "Essa operação atualiza apenas alguns dados do veículo.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso ao atualiza apenas alguns dados do veículo",
            response = VehicleResponseDTO.class)})
    @PatchMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<VehicleResponseDTO> patchVehicle(
            @PathVariable(name = "id") Long vehicleId,
            @RequestBody PatchVehicleRequestDTO patchVehicleRequestDTO
    ) throws Exception;

    @ApiOperation(value = "Apaga o veículo", nickname = "deleteVehicle", notes = "Essa operação apaga o veículo.")
    @ApiResponses(value = {@ApiResponse(code = 204, message = "Sucesso ao apagar o veículo")})
    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> deleteVehicle(
            @PathVariable(name = "id") Long vehicleId
    ) throws Exception;

    @ApiOperation(value = "Exibe a informação de quantos veículos estão como não vendidos na base",
            nickname = "getVehiclesAvailable", notes = "Essa operação exibe a informação de quantos veículos estão como não vendidos na base.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso ao exibir a quantidade de veículos não vendidos na base",
            response = Long.class)})
    @GetMapping(value = "/disponiveis")
    ResponseEntity<Long> getVehiclesAvailable();

    @ApiOperation(value = "Exibe a informação da distribuição de veículos por década de fabricação",
            nickname = "getVehiclesByDecadeOfManufacture", notes = "Essa operação exibe a informação da distribuição de veículos por década de fabricação.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso ao retornar os veículos por década de fabricação",
            response = VehiclesByDecadeOfManufactureResponseDTO.class)})
    @GetMapping(value = "/fabricacao", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<VehiclesByDecadeOfManufactureResponseDTO> getVehiclesByDecadeOfManufacture();

    @ApiOperation(value = "Exibe a informação da distribuição de veículos por fabricante", nickname = "getVehiclesByManufacturer",
            notes = "Essa operação exibe a informação da distribuição de veículos por fabricante.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso ao exibir a distribuição de veículos por fabricante",
            response = VehiclesByManufacturer.class)})
    @GetMapping(value = "/fabricante", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<VehiclesByManufacturer> getVehiclesByManufacturer();

    @ApiOperation(value = "Exibe os carros registrados durante a última semana", nickname = "getVehiclesRegisteredInTheLastWeek",
            notes = "Essa operação exibe os carros registrados durante a última semana.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso ao exibir os carros registrados durante a última semana",
            response = VehiclesResponseDTO.class)})
    @GetMapping(value = "/ultimaSemana", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<VehiclesResponseDTO> getVehiclesRegisteredInTheLastWeek();
}

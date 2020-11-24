package br.com.cliente.rest;

import br.com.cliente.model.Cliente;
import br.com.cliente.model.ServicoPrestado;
import br.com.cliente.rest.dto.ServicoPrestadoDTO;
import br.com.cliente.service.ServicoPrestadosService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/servicos-prestados")
public class ServicoPrestacoController {

    @Autowired
    ServicoPrestadosService servicoPrestadosService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ServicoPrestado> salvar(@RequestBody @Valid ServicoPrestadoDTO servicoPrestadoDTO){
        ServicoPrestado servicoPrestado = servicoPrestadosService.salvar(servicoPrestadoDTO);
        return ResponseEntity.ok(servicoPrestado);
    }

    @GetMapping
    public List<ServicoPrestado> pesquisar(
            @RequestParam(value = "nome", required = false, defaultValue = "") String nome,
            @RequestParam(value = "mes", required = false) Integer mes
    ){
        return servicoPrestadosService.pesquisar(nome, mes);
    }

}

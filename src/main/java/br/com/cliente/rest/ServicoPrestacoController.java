package br.com.cliente.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cliente.model.ServicoPrestado;
import br.com.cliente.rest.dto.ServicoPrestadoDTO;
import br.com.cliente.service.ServicoPrestadosService;

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

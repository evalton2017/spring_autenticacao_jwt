package br.com.cliente.rest;

import br.com.cliente.model.Cliente;
import br.com.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    ClienteService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cliente> salvar(@RequestBody @Valid Cliente cliente){
       service.salvar(cliente);
       return ResponseEntity.ok(cliente);
    }

    @GetMapping
    public List<Cliente> clientes(){
        return service.lista();
    }

    @GetMapping("{id}")
    public Cliente cliente(@PathVariable("id")  Long id){
        return service.consultar(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"cliente não encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id")  Long id){
        service.deletar(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Long id, @RequestBody @Valid Cliente cliente){
        service.atualizar(id,cliente);
    }

}

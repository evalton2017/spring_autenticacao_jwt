package br.com.cliente;

import br.com.cliente.config.InternacionalizacaoConfig;
import br.com.cliente.model.Cliente;
import br.com.cliente.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@SpringBootApplication
public class ClienteApplication {

    @Autowired ClienteRepository repository;

    @Autowired
    InternacionalizacaoConfig internacionalizacaoConfig;

    public static void main(String[] args) {
        SpringApplication.run(ClienteApplication.class, args);
    }
}

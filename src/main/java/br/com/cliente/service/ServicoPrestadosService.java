package br.com.cliente.service;

import br.com.cliente.model.Cliente;
import br.com.cliente.model.ServicoPrestado;
import br.com.cliente.model.repository.ServicoPrestadoRepository;
import br.com.cliente.rest.dto.ServicoPrestadoDTO;
import br.com.cliente.util.BigDecimalConverter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ServicoPrestadosService {

    @Autowired
    ServicoPrestadoRepository repository;

    @Autowired
    ClienteService clienteService;


    public ServicoPrestado salvar(ServicoPrestadoDTO dto){
        LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        ServicoPrestado servicoPrestado = new ServicoPrestado();
        Cliente cliente = clienteService.buscarCliente(dto.getIdCliente());
        servicoPrestado.setDescricao(dto.getDescricao());
        servicoPrestado.setData(data);
        servicoPrestado.setCliente(cliente);
        servicoPrestado.setValor(BigDecimalConverter.converter(dto.getPreco()));
        repository.save(servicoPrestado);
        return servicoPrestado;

    }

    public List<ServicoPrestado> pesquisar(String nome, Integer mes){
        return repository.findByNomeClienteEMes("%"+nome+"%", mes);
    }


}

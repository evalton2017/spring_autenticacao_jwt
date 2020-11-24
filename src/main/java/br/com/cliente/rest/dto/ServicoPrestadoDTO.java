package br.com.cliente.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class ServicoPrestadoDTO {
    @NotEmpty
    private String descricao;
    private String preco;

    @NotEmpty(message = "{campo.data.obrigatorio}")
    private String data;
    private Long idCliente;
}

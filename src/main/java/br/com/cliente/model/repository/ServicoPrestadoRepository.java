package br.com.cliente.model.repository;

import br.com.cliente.model.ServicoPrestado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Long> {

    @Query("select  s from ServicoPrestado  s join s.cliente c where upper(c.nome) like upper(:nome) and MONTH(s.data) =:mes ")
    List<ServicoPrestado> findByNomeClienteEMes(
            @Param("nome") String nome,
            @Param("mes") Integer mes);
}

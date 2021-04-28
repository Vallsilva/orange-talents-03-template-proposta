package br.com.zupacademy.valeria.propostas.propostas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PropostaRepository extends JpaRepository<PropostaModel, Long> {

    Optional<PropostaModel> findByDocumento(String documento);
}

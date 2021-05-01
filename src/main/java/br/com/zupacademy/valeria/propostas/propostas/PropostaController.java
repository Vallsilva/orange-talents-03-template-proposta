package br.com.zupacademy.valeria.propostas.propostas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/proposta")
public class PropostaController {

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private EnviaProposta enviaProposta;

    @PostMapping
    public ResponseEntity<?> criaEEnviaProposta(@RequestBody @Valid PropostaRequest request, UriComponentsBuilder uriComponents){

        if (propostaRepository.findByDocumento(request.getDocumento()).isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }

        PropostaModel propostaModel = request.toModel();

        propostaRepository.save(propostaModel);

        EnviaSolicitacaoProposta enviaSolicitacao = new EnviaSolicitacaoProposta(propostaModel);

        RetornoSolicitacaoProposta retornoSolicitacaoProposta = enviaProposta.enviaProposta(enviaSolicitacao);


        PropostaResponse propostaResponse = new PropostaResponse(propostaModel, retornoSolicitacaoProposta);

        return ResponseEntity.created(uriComponents.path("proposta/{id}").buildAndExpand(propostaModel.getId()).toUri()).body(propostaResponse);
    }






}

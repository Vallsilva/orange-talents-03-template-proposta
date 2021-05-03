package br.com.zupacademy.valeria.propostas.propostas;

import br.com.zupacademy.valeria.propostas.propostas.atrela.AtrelaProposta;
import br.com.zupacademy.valeria.propostas.propostas.atrela.RetornoCartaoGerado;
import br.com.zupacademy.valeria.propostas.propostas.consulta.EnviaProposta;
import br.com.zupacademy.valeria.propostas.propostas.consulta.EnviaSolicitacaoProposta;
import br.com.zupacademy.valeria.propostas.propostas.consulta.RetornoSolicitacaoProposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/proposta")
public class PropostaController {

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private EnviaProposta enviaProposta;

    @Autowired
    private AtrelaProposta atrelaProposta;

    @PostMapping
    public ResponseEntity<?> criaEEnviaProposta(@RequestBody @Valid PropostaRequest request, UriComponentsBuilder uriComponents){

        if (propostaRepository.findByDocumento(request.getDocumento()).isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }

        PropostaModel propostaModel = request.toModel();
        propostaRepository.save(propostaModel);

        EnviaSolicitacaoProposta enviaSolicitacao = new EnviaSolicitacaoProposta(propostaModel);

        RetornoSolicitacaoProposta retornoSolicitacaoProposta = enviaProposta.enviaProposta(enviaSolicitacao);

        if (retornoSolicitacaoProposta.getResultadoSolicitacao().equals(new String("COM_RESTRICAO"))){
            return ResponseEntity.badRequest().build();
        }

        RetornoCartaoGerado cartaoGerado = atrelaProposta.atrelaCartaoAProposta(enviaSolicitacao);

        PropostaResponse propostaResponse = new PropostaResponse(propostaModel, retornoSolicitacaoProposta, cartaoGerado);

        return ResponseEntity.created(uriComponents.path("proposta/{id}").buildAndExpand(propostaModel.getId()).toUri()).body(propostaResponse);
    }




}

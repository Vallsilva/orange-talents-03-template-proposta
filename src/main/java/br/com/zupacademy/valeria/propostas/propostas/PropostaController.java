package br.com.zupacademy.valeria.propostas.propostas;

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

    @PostMapping
    public ResponseEntity<?> criaProposta(@RequestBody @Valid PropostaRequest request, UriComponentsBuilder uriComponents){

        if (propostaRepository.findByDocumento(request.getDocumento()).isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        }
        PropostaModel propostaModel = request.toModel();

        propostaRepository.save(propostaModel);

        PropostaResponse propostaResponse = new PropostaResponse(propostaModel);

        return ResponseEntity.created(uriComponents.path("proposta/{id}").buildAndExpand(propostaModel.getId()).toUri()).body(propostaResponse);
    }
}

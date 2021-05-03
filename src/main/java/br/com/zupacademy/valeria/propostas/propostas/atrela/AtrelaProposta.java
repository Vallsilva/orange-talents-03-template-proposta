package br.com.zupacademy.valeria.propostas.propostas.atrela;

import br.com.zupacademy.valeria.propostas.propostas.consulta.EnviaSolicitacaoProposta;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "http://localhost:8888", name = "AtrelaPropostaaCartao")
public interface AtrelaProposta {

    @RequestMapping(method = RequestMethod.POST, value = "/api/cartoes")
    RetornoCartaoGerado atrelaCartaoAProposta(EnviaSolicitacaoProposta proposta);
}

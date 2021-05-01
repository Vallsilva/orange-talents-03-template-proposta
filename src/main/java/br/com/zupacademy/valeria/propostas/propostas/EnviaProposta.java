package br.com.zupacademy.valeria.propostas.propostas;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(url = "http://localhost:9999", name = "solicitaRestricaoCartao")
public interface EnviaProposta {


    @RequestMapping(method = RequestMethod.POST, value = "/api/solicitacao")
    RetornoSolicitacaoProposta enviaProposta(EnviaSolicitacaoProposta enviaSolicitacao);
}

package br.com.zupacademy.valeria.propostas.propostas;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

public class DefineTipoPessoa implements DefaultGroupSequenceProvider<PropostaRequest>{


    @Override
    public List<Class<?>> getValidationGroups(PropostaRequest request) {
        List<Class<?>> grupos = new ArrayList<>();
        if (hasTipoPessoa(request)){
            if (request.isPF()){
                grupos.add(PessoaFisica.class);
            } else if (request.isPJ()){
                grupos.add(PessoaJuridica.class);
            }
        }

        grupos.add(PropostaRequest.class);

        return grupos;
    }

    private boolean hasTipoPessoa(PropostaRequest propostaRequest){
        return nonNull(propostaRequest) && nonNull(propostaRequest.getTipoPessoa());
    }
}

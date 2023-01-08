package br.com.fbm.ceps.fbmceps.services.v2;

import java.sql.Timestamp;
import java.time.Instant;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import br.com.fbm.ceps.fbmceps.data.vo.v2.ProcessoVOV2;
import br.com.fbm.ceps.fbmceps.repository.ProcessoRepository;

@SpringBootTest
public class ProcessoServiceV2Test {
    
    @Autowired
    ProcessoServiceV2 service;

    @Autowired
    ProcessoRepository repository;

    @Test
    public void retornarProcessoExistente(){

        ProcessoVOV2 pv = service.buscarPorId(74L);

        Assertions.assertNotNull(pv, "Método de busca executado com sucesso...");
        Assertions.assertNotNull(pv.getIdFaixa(), "Verificando existência da faixa selecionada...");
        
    }

    @Test
    public void retornarLinksResponse(){

        ProcessoVOV2 pv = service.buscarPorId(74L);

        Assertions.assertEquals( false, pv.getLinks().isEmpty(), "Links retornados...");

    }

    @Test
    public void validarSalvarPesquisarEDeletar(){

        //Testa se salvou com sucesso
        Timestamp t = Timestamp.from(Instant.now());

        ProcessoVOV2 objRequest = new ProcessoVOV2();

        objRequest.setAtivo(true);
        objRequest.setIdFaixa(44L);
        objRequest.setDtInicio(t);
        objRequest.setDtFim(t);
        objRequest.setDescStatus("AP");

        ProcessoVOV2 responseSave = service.salvar(objRequest);

        Assertions.assertNotNull(responseSave, "Método salvar executado...");
        Assertions.assertNotNull(responseSave.getKey(), "Id do processo recuperado...");

        //Testa se está sendo possível pesquisar o registro salvo
        ProcessoVOV2 responseBusca = service.buscarPorId(responseSave.getKey());

        Assertions.assertNotNull(responseBusca, "Método pesquisarPorId executado...");
        Assertions.assertEquals(responseSave.getKey(), responseBusca.getKey(), "Id do processo recuperado...");

        //Testa se deletou com sucesso
        service.deletar(responseBusca.getKey());

        ProcessoVOV2 responsePesquisaDelete = service.buscarPorId(responseBusca.getKey());

        Assertions.assertEquals(null, responsePesquisaDelete.getKey(), "Registro deletado...");

    }

}

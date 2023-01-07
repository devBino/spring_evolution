package br.com.fbm.ceps.fbmceps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fbm.ceps.fbmceps.models.ProcessoModel;

@Repository
public interface ProcessoRepository extends JpaRepository<ProcessoModel, Long> {}

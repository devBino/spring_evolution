package br.com.fbm.ceps.fbmceps.repository;

import org.springframework.stereotype.Repository;

import br.com.fbm.ceps.fbmceps.models.CidadeModel;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CidadeRepository extends JpaRepository<CidadeModel, Long>{}

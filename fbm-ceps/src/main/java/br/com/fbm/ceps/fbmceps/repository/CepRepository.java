package br.com.fbm.ceps.fbmceps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fbm.ceps.fbmceps.models.CepModel;

@Repository
public interface CepRepository extends JpaRepository<CepModel, Long> {}

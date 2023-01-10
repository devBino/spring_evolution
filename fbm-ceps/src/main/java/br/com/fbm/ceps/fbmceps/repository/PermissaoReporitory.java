package br.com.fbm.ceps.fbmceps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fbm.ceps.fbmceps.models.PermissaoModel;

@Repository
public interface PermissaoReporitory extends JpaRepository<PermissaoModel, Long> {}

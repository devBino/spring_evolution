package br.com.fbm.agenda.fbmagenda.repositories.iface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fbm.agenda.fbmagenda.models.ContatoModelDB;

@Repository
public interface ContatoModelDBRepository extends JpaRepository<ContatoModelDB, Long> {}

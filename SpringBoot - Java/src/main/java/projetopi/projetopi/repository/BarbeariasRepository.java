package projetopi.projetopi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projetopi.projetopi.entity.Barbearia;
import projetopi.projetopi.dto.response.InfoBarbearia;
import projetopi.projetopi.dto.response.InfoEndereco;

import java.util.List;

public interface BarbeariasRepository extends JpaRepository<Barbearia, Integer> {



      @Query("SELECT new Barbearia(b.nomeNegocio, b.emailNegocio, b.celularNegocio, b.cnpj, b.cpf, b.descricao) FROM Barbearia b WHERE b.id = :id")
      List<InfoBarbearia> findByInfoBarbearia(@Param("id") Integer id);

      @Query("SELECT new Barbearia(b.endereco) FROM Barbearia b WHERE b.id = :id")
      List<InfoEndereco> findByInfoEndereco(@Param("id") Integer id);

      Barbearia findByCpf(String cpf);

      Barbearia findByNomeNegocio(String nomeNegocio);


}
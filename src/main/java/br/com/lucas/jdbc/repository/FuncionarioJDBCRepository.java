package br.com.lucas.jdbc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.lucas.jdbc.model.Funcionario;

@Repository
public class FuncionarioJDBCRepository {
	
	@Autowired
    JdbcTemplate jdbcTemplate;

    class FuncionarioRowMapper implements RowMapper < Funcionario> {
        @Override
        public Funcionario mapRow(ResultSet rs, int rowNum) throws SQLException {
            Funcionario funcionario = new Funcionario();
            funcionario.setId(rs.getLong("id"));
            funcionario.setPrimeiroNome(rs.getString("primeiroNome"));
            funcionario.setUltimoNome(rs.getString("ultimoNome"));
            funcionario.setEmail(rs.getString("email"));
            return funcionario;
        }
    }

    public List < Funcionario > findAll() {
        return jdbcTemplate.query("select * from funcionarios", new FuncionarioRowMapper());
    }

    public Optional < Funcionario > findById(long id) {
        return Optional.of(jdbcTemplate.queryForObject("select * from funcionarios where id=?", new Object[] {
                id
            },
            new BeanPropertyRowMapper < Funcionario > (Funcionario.class)));
    }

    public int deleteById(long id) {
        return jdbcTemplate.update("delete from funcionarios where id=?", new Object[] {
            id
        });
    }

    public int insert(Funcionario funcionario) {
        return jdbcTemplate.update("insert into funcionarios (id, primeiroNome, ultimoNome, email) " + "values(?, ?, ?, ?)",
            new Object[] {
                funcionario.getId(), funcionario.getPrimeiroNome(), funcionario.getUltimoNome(), funcionario.getEmail()
            });
    }

    public int update(Funcionario funcionario) {
        return jdbcTemplate.update("update funcionarios " + " set primeiroNome = ?, ultimoNome = ?, email = ? " + " where id = ?",
            new Object[] {
                funcionario.getPrimeiroNome(), funcionario.getUltimoNome(), funcionario.getEmail(), funcionario.getId()
            });
    }
}
	

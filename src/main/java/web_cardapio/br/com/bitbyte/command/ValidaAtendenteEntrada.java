package web_cardapio.br.com.bitbyte.command;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import web_cardapio.br.com.bitbyte.dao.AtendenteDao;
import web_cardapio.br.com.bitbyte.exceptions.AtendenteNaoEncontradoException;
import web_cardapio.br.com.bitbyte.exceptions.BBIException;
import web_cardapio.br.com.bitbyte.models.Atendente;
import web_cardapio.br.com.bitbyte.models.Entrada;

@Component
public class ValidaAtendenteEntrada {

	@Autowired
	private AtendenteDao atendenteDao;

	public Boolean execute(Entrada entrada) throws SQLException, BBIException {
		Atendente atendente = entrada.getAtendente();
		if (atendente == null) {
			throw new AtendenteNaoEncontradoException("Usuário ou senha incorretos. ");
		}
		String usuario = atendente.getUsuario();
		String senha = atendente.getSenha();

		Atendente atendenteBuscado = atendenteDao.getAtendenteByUsuarioAndSenha(usuario, senha);

		if (atendenteBuscado == null) {
			throw new AtendenteNaoEncontradoException("Usuário ou senha incorretos. ");
		}
		return true;
	}

}

package web_cardapio.br.com.bitbyte.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web_cardapio.br.com.bitbyte.dao.PesquisaDao;
import web_cardapio.br.com.bitbyte.dao.RespostaDao;
import web_cardapio.br.com.bitbyte.models.RespostasPesquisa;
import web_cardapio.br.com.bitbyte.sqlcommons.Generator;

@Service
public class PesquisaService {
	
	@Autowired
	private PesquisaDao pesquisaDao;
	
	@Autowired
	private RespostaDao respostaDao;
	
	@Autowired
	private Generator generator;
	
	public void insertResultados(RespostasPesquisa respostas) throws SQLException 
	{
		int id = generator.gerarIdPesquisa();
		respostas.setIdPesquisa(id);
		
		pesquisaDao.insertResultados(respostas);
		respostaDao.salvarRespostas(respostas);
	}

}

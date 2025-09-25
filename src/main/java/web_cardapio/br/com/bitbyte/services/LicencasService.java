package web_cardapio.br.com.bitbyte.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web_cardapio.br.com.bitbyte.connection.ConnectionFactory;
import web_cardapio.br.com.bitbyte.models.Atendente;
import web_cardapio.br.com.bitbyte.models.Dispositivo;
import web_cardapio.br.com.bitbyte.sqlcommons.Generator;

@Service
public class LicencasService {
	
	@Autowired
	private ConnectionFactory connectionFactory;
	
	@Autowired
	private Generator generator;
	
	public void insertOrUpdateDispositivo(Dispositivo disp) throws SQLException 
	{
		Optional<Dispositivo> opt = getDispositivo(disp.getSerial(), disp.getTipo());
		
		if(opt.isPresent()) {
			return;
		}
		
		insertDispositivo(disp);
	}
	
	public void insertDispositivo(Dispositivo disp) throws SQLException 
	{
		String sql = 
				" INSERT INTO tblicencas ( " +
				" id, " +
				" serial, " +
				" tipo ) " +
				" VALUES (?, ?, ?) ";
			
			try(Connection conn = connectionFactory.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql))
			{
				pst.setInt(1, generator.gerarIntId(Generator.LICENCA));
				pst.setString(2, disp.getSerial());
				pst.setString(3, disp.getTipo());
				pst.executeUpdate();
			}
	}
	
	public Optional<Dispositivo> getDispositivo(String serial, String tipo) throws SQLException
	{
		String sql = 
				" SELECT " +
				" id, " +
				" serial, " +
				" tipo, " +
				" liberado " +
				" FROM tblicencas " +
				" WHERE " +
				" serial = '" +serial + "' AND " +
				" tipo = '" +tipo + "'";
		
		try(Connection conn = connectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery())
		{
			if(rs.next()) {
				Dispositivo dispositivo = new Dispositivo()
					.setId(rs.getLong("id"))
					.setSerial(rs.getString("serial"))
					.setTipo(rs.getString("tipo"))
					.setLiberado("S".equals(rs.getString("liberado")));
				
				return Optional.of(dispositivo);
			}
			return Optional.empty();
		}
	}

}

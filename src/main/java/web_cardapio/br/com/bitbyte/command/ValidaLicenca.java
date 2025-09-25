package web_cardapio.br.com.bitbyte.command;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import web_cardapio.br.com.bitbyte.exceptions.BBIException;
import web_cardapio.br.com.bitbyte.exceptions.DispositivoSemLicencaException;
import web_cardapio.br.com.bitbyte.models.Dispositivo;
import web_cardapio.br.com.bitbyte.services.LicencasService;

@Component
public class ValidaLicenca {
	
	@Autowired
	private LicencasService licencaService;
	
	public boolean execute(Dispositivo dispositivo) throws SQLException, BBIException
	{
		if(dispositivo == null) {
			throw new IllegalStateException("Não foi possível validar dispositivo habilitado. Informações do dispositivo ausentes.");
		}
		String serial = dispositivo.getSerial();
		String tipo = dispositivo.getTipo();
		
		StringBuilder sb = new StringBuilder();
		sb.append("Serial: ").append(serial)
		.append("\n\n")
		.append("Dispositivo não habilitado para utilização, entre em contato com a BBIFood.")
		.append("\n")
		.append("(11) 3963-5055");
		
		String msg = sb.toString();
		
		Optional<Dispositivo> optDisp = licencaService.getDispositivo(serial, tipo);
		if(!optDisp.isPresent()) 
		{
			dispositivo.setLiberado(false);
			licencaService.insertOrUpdateDispositivo(dispositivo);
			throw new DispositivoSemLicencaException(msg);
		}
		
		Dispositivo disp = optDisp.get();
		if(!disp.isLiberado()) 
		{
			throw new DispositivoSemLicencaException(msg);
		}
		
		return true;
	}

}

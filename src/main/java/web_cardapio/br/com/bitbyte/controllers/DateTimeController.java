package web_cardapio.br.com.bitbyte.controllers;

import java.util.Calendar;
import java.util.Locale;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web_cardapio.br.com.bitbyte.models.Retorno;

@RestController
@RequestMapping("time")
public class DateTimeController {
	
	@GetMapping
	@Produces(MediaType.APPLICATION_JSON)
	public Retorno<Long> getCalendar() 
	{
		Retorno<Long> retornoCalendar = new Retorno<>();
		Calendar calendar = Calendar.getInstance(new Locale("pt", "BR"));
		retornoCalendar.setValue(calendar.getTimeInMillis());
		retornoCalendar.setStatus(200);
		return retornoCalendar;
	}

}

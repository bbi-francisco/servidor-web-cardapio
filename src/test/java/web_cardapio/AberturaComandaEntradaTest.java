package web_cardapio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import web_cardapio.br.com.bitbyte.command.ValidaAtendenteEntrada;
import web_cardapio.br.com.bitbyte.command.ValidaCaixaAberto;
import web_cardapio.br.com.bitbyte.command.ValidaComandaBloqueada;
import web_cardapio.br.com.bitbyte.command.ValidaComandaFechada;
import web_cardapio.br.com.bitbyte.command.ValidaComandaNaoAberta;
import web_cardapio.br.com.bitbyte.command.ValidaIntervaloComanda;
import web_cardapio.br.com.bitbyte.command.ValidaLicenca;
import web_cardapio.br.com.bitbyte.command.ValidaLimiteComanda;
import web_cardapio.br.com.bitbyte.dao.ComandaDao;
import web_cardapio.br.com.bitbyte.enums.BBIStatus;
import web_cardapio.br.com.bitbyte.exceptions.BBIException;
import web_cardapio.br.com.bitbyte.exceptions.ComandaNaoAbertaException;
import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.models.ComandaInvalida;
import web_cardapio.br.com.bitbyte.models.Entrada;
import web_cardapio.br.com.bitbyte.repositories.BbiParamService;
import web_cardapio.br.com.bitbyte.repositories.ParametrosService;
import web_cardapio.br.com.bitbyte.results.EntradaResult;
import web_cardapio.br.com.bitbyte.services.tablet.AbrirComandasEntrada;
import static org.mockito.BDDMockito.*;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class AberturaComandaEntradaTest {
	
	@Mock
	ParametrosService paramService;
	
	@Mock
	ValidaCaixaAberto validaCaixaAberto;

	@Mock
	ValidaAtendenteEntrada validaAtendenteEntrada;

	@Mock
	ValidaComandaBloqueada validaComandaBloqueada;

	@Mock
	ValidaComandaFechada validaComandaFechada;

	@Mock
	ValidaIntervaloComanda validaIntervaloComanda;

	@Mock
	ValidaLimiteComanda validaLimiteComanda;

	@Mock
	ValidaComandaNaoAberta validaComandaNaoAberta;
	
	@Mock
	ValidaLicenca validaLicenca;
	
	@Mock
	BbiParamService bbiParamService;
	
	@Mock
	ComandaDao comandaDao;
	
	@InjectMocks
	AbrirComandasEntrada abrirComandasService;
	
	Entrada entrada;
	Comanda comanda;
	
	@BeforeEach
	void setup() {
		comanda = new Comanda().setNumero(5);
		List<Comanda> comandas = Arrays.asList(comanda);
		entrada = new Entrada().setComandas(comandas);
	}
	
	@DisplayName("Given Utiliza Abertura De Comanda And Comanda Nao Aberta When Entrar Then Throw ComandaNaoAbertaException")
	@Test
	void testGivenUtilizaAberturaDeComandaAndComandaNaoAberta_WhenEntrar_ThenThrowComandaNaoAbertaException() throws SQLException, BBIException 
	{
		//Given / Arrange
		given(bbiParamService.aberturaComanda()).willReturn(true);
		
		given(validaComandaNaoAberta.execute(any(Comanda.class)))
		.willThrow(ComandaNaoAbertaException.class);
		
		//When / Act
		EntradaResult entradaResult = abrirComandasService.abrir(entrada);
		
		//Then / Assert
		List<Comanda> comandasInvalidas = entradaResult.getComandasInvalidas();
		assertEquals(comandasInvalidas.size(), 1);
		
		Comanda comandaErro = comandasInvalidas.get(0);
		ComandaInvalida errorObj = comandaErro.getComandaInvalida();
		assertNotNull(errorObj);
		
		assertEquals(errorObj.getStatus(), BBIStatus.Comanda.COMANDA_NAO_ABERTA);
		verify(comandaDao, never()).insertOrUpdateComandas(anyList());
		
		List<Comanda> comandasEmAberto = entradaResult.getComandasEmAberto();
		assertEquals(comandasEmAberto.size(), 0);
	}

	@DisplayName("Given Utiliza Abertura De Comanda And Comanda Aberta When Entrar Then Update Comanda And Proceed")
	@Test
	void testGivenUtilizaAberturaDeComandaAndComandaAberta_WhenEntrar_ThenProceed() throws SQLException, BBIException {
		//Given / Arrange
		given(bbiParamService.aberturaComanda()).willReturn(true);
		given(comandaDao.selectComandaByNumero(anyInt())).willReturn(comanda);
		
		//When / Act
		EntradaResult entradaResult = abrirComandasService.abrir(entrada);
		
		//Then / Assert
		List<Comanda> comandasInvalidas = entradaResult.getComandasInvalidas();
		assertEquals(comandasInvalidas.size(), 0);
		
		verify(comandaDao, times(1)).insertOrUpdateComandas(anyList());
		
		List<Comanda> comandasEmAberto = entradaResult.getComandasEmAberto();
		assertEquals(comandasEmAberto.size(), 1);
	}
	
	@DisplayName("Given Nao Utiliza Abertura De Comanda And Comanda Nao Aberta When Entrar Then Abrir Comanda")
	@Test
	void testGivenNaoUtilizaAberturaDeComandaAndComandaNaoAberta_WhenEntrar_ThenAbrirComanda() throws SQLException, BBIException 
	{
		//Given / Arrange
		given(bbiParamService.aberturaComanda()).willReturn(false);
		
		//When / Act
		EntradaResult entradaResult = abrirComandasService.abrir(entrada);
		
		//Then / Assert
		List<Comanda> comandasInvalidas = entradaResult.getComandasInvalidas();
		assertEquals(comandasInvalidas.size(), 0);
		
		verify(validaComandaNaoAberta, never()).execute(any(Comanda.class));
		verify(comandaDao, times(1)).insertOrUpdateComandas(anyList());
		
		List<Comanda> comandasEmAberto = entradaResult.getComandasEmAberto();
		assertEquals(comandasEmAberto.size(), 0);
	}
	
	@DisplayName("Given Nao Utiliza Abertura De Comanda And Comanda Aberta When Entrar Then Proceed")
	@Test
	void testGivenNaoUtilizaAberturaDeComandaAndComandaNaoAberta_WhenEntrar_ThenProceed() throws SQLException, BBIException 
	{
		//Given / Arrange
		given(bbiParamService.aberturaComanda()).willReturn(false);
		given(comandaDao.selectComandaByNumero(anyInt())).willReturn(comanda);
		
		//When / Act
		EntradaResult entradaResult = abrirComandasService.abrir(entrada);
		
		//Then / Assert
		List<Comanda> comandasInvalidas = entradaResult.getComandasInvalidas();
		assertEquals(comandasInvalidas.size(), 0);
		
		verify(comandaDao, times(1)).insertOrUpdateComandas(anyList());
		
		List<Comanda> comandasEmAberto = entradaResult.getComandasEmAberto();
		assertEquals(comandasEmAberto.size(), 1);
	}

}

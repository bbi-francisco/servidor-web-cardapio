/*
 * package web_cardapio;
 * 
 * import static org.junit.jupiter.api.Assertions.assertThrows; import static
 * org.junit.jupiter.api.Assertions.assertTrue; import static
 * org.mockito.Mockito.when;
 * 
 * import java.sql.SQLException; import java.util.Arrays; import
 * java.util.Collection;
 * 
 * import org.junit.jupiter.api.BeforeEach; import
 * org.junit.jupiter.api.DisplayName; import
 * org.junit.jupiter.params.ParameterizedTest; import
 * org.junit.jupiter.params.provider.MethodSource; import
 * org.mockito.InjectMocks; import org.mockito.Mock; import
 * org.mockito.MockitoAnnotations;
 * 
 * import web_cardapio.br.com.bitbyte.command.ValidaComandaFechada; import
 * web_cardapio.br.com.bitbyte.dao.ComandaDao; import
 * web_cardapio.br.com.bitbyte.estatico.Parametros; import
 * web_cardapio.br.com.bitbyte.exceptions.ComandaException; import
 * web_cardapio.br.com.bitbyte.exceptions.ComandaFechadaException; import
 * web_cardapio.br.com.bitbyte.models.Comanda; import
 * web_cardapio.br.com.bitbyte.models.FechamentoComanda; import
 * web_cardapio.br.com.bitbyte.repositories.ParametrosService;
 * 
 * public class ComandaFechadaTest {
 * 
 * @Mock ComandaDao comandaDao;
 * 
 * @Mock ParametrosService parametrosService;
 * 
 * @InjectMocks ValidaComandaFechada validaComandaFechada;
 * 
 * @BeforeEach public void setUp() { MockitoAnnotations.openMocks(this); }
 * 
 * public static Collection<Object[]> dataSetComandaAberta(){ return
 * Arrays.asList(new Object[][] { { true, false }, { true, true }, { false,
 * false }, { false, true } }); }
 * 
 * public static Collection<Object[]> dataSetComandaFechada(){ return
 * Arrays.asList(new Object[][] { { true, false }, { true, true }, { false,
 * false }, { false, true } }); }
 * 
 * @ParameterizedTest
 * 
 * @MethodSource(value = "dataSetComandaAberta")
 * 
 * @DisplayName("When Comanda Is Aberta Then Always Ok") public void
 * whenComandaIsNotFechadaThenAlwaysOk(boolean bloqComandaAposFx, boolean
 * validaBloqComandaAposFx) throws ComandaException, SQLException {
 * 
 * int numComanda = 1; Comanda c = new Comanda().setNumero(numComanda);
 * 
 * when(comandaDao.verificarComandaFechada(numComanda)) .thenReturn(new
 * FechamentoComanda().setFechada(false));
 * 
 * when(parametrosService.getBoolean(Parametros.BLOQ_COMANDA_APOS_FX))
 * .thenReturn(bloqComandaAposFx);
 * 
 * assertTrue(validaComandaFechada.execute(c, validaBloqComandaAposFx)); }
 * 
 * @ParameterizedTest
 * 
 * @MethodSource(value = "dataSetComandaFechada")
 * 
 * @DisplayName("When Comanda Is Fechada Throw Exception If BloqComandaAposFx And ValidaBloqComandaAposFx"
 * ) public void whenComandaIsFechadaThenAlwaysOk(boolean bloqComandaAposFx,
 * boolean validaBloqComandaAposFx) throws ComandaException, SQLException {
 * 
 * int numComanda = 1; Comanda c = new Comanda().setNumero(numComanda);
 * 
 * when(comandaDao.verificarComandaFechada(numComanda)) .thenReturn(new
 * FechamentoComanda().setFechada(true));
 * 
 * when(parametrosService.getBoolean(Parametros.BLOQ_COMANDA_APOS_FX))
 * .thenReturn(bloqComandaAposFx);
 * 
 * if(bloqComandaAposFx && validaBloqComandaAposFx) {
 * assertThrows(ComandaFechadaException.class, () ->
 * validaComandaFechada.execute(c, validaBloqComandaAposFx)); }else {
 * assertTrue(validaComandaFechada.execute(c, validaBloqComandaAposFx)); } }
 * 
 * }
 */
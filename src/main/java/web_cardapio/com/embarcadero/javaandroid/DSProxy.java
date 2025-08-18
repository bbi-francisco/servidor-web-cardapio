// 
// Created by the DataSnap proxy generator.
// 27/08/2019 09:36:20
// 
package web_cardapio.com.embarcadero.javaandroid;

import web_cardapio.br.com.bitbyte.cupomfiscal.CupomFiscal;

public class DSProxy
{
	public static class TSvrMethod extends DSAdmin
	{
		public TSvrMethod(DSRESTConnection Connection)
		{
			super(Connection);
		}

		private DSRESTParameterMetaData[] TSvrMethod_DSServerModuleCreate_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_DSServerModuleCreate_Metadata()
		{
			if (TSvrMethod_DSServerModuleCreate_Metadata == null)
			{
				TSvrMethod_DSServerModuleCreate_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("Sender", DSRESTParamDirection.Input,
								DBXDataTypes.JsonValueType, "TObject"), };
			}
			return TSvrMethod_DSServerModuleCreate_Metadata;
		}

		/**
		 * @param Sender
		 *            [in] - Type on server: TObject
		 */
		public void DSServerModuleCreate(TJSONObject Sender) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.POST);
			cmd.setText("TSvrMethod.DSServerModuleCreate");
			cmd.prepare(get_TSvrMethod_DSServerModuleCreate_Metadata());
			cmd.getParameter(0).getValue().SetAsJSONValue(Sender);
			getConnection().execute(cmd);
			return;
		}

		private DSRESTParameterMetaData[] TSvrMethod_SalvaLogErros_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_SalvaLogErros_Metadata()
		{
			if (TSvrMethod_SalvaLogErros_Metadata == null)
			{
				TSvrMethod_SalvaLogErros_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("sMsg", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"), };
			}
			return TSvrMethod_SalvaLogErros_Metadata;
		}

		/**
		 * @param sMsg
		 *            [in] - Type on server: string
		 */
		public void SalvaLogErros(String sMsg) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.SalvaLogErros");
			cmd.prepare(get_TSvrMethod_SalvaLogErros_Metadata());
			cmd.getParameter(0).getValue().SetAsString(sMsg);
			getConnection().execute(cmd);
			return;
		}

		private DSRESTParameterMetaData[] TSvrMethod_EchoString_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_EchoString_Metadata()
		{
			if (TSvrMethod_EchoString_Metadata == null)
			{
				TSvrMethod_EchoString_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("Value", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.WideStringType, "string"), };
			}
			return TSvrMethod_EchoString_Metadata;
		}

		/**
		 * @param Value
		 *            [in] - Type on server: string
		 * @return result - Type on server: string
		 */
		public String EchoString(String Value) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.EchoString");
			cmd.prepare(get_TSvrMethod_EchoString_Metadata());
			cmd.getParameter(0).getValue().SetAsString(Value);
			getConnection().execute(cmd);
			return cmd.getParameter(1).getValue().GetAsString();
		}

		private DSRESTParameterMetaData[] TSvrMethod_ReverseString_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_ReverseString_Metadata()
		{
			if (TSvrMethod_ReverseString_Metadata == null)
			{
				TSvrMethod_ReverseString_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("Value", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.WideStringType, "string"), };
			}
			return TSvrMethod_ReverseString_Metadata;
		}

		/**
		 * @param Value
		 *            [in] - Type on server: string
		 * @return result - Type on server: string
		 */
		public String ReverseString(String Value) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.ReverseString");
			cmd.prepare(get_TSvrMethod_ReverseString_Metadata());
			cmd.getParameter(0).getValue().SetAsString(Value);
			getConnection().execute(cmd);
			return cmd.getParameter(1).getValue().GetAsString();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetProduto_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetProduto_Metadata()
		{
			if (TSvrMethod_GetProduto_Metadata == null)
			{
				TSvrMethod_GetProduto_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pCodOrDesc", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pPesquisa", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pMaioridade", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pTipoPesqCodProd", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetProduto_Metadata;
		}

		/**
		 * @param pCodOrDesc
		 *            [in] - Type on server: string
		 * @param pPesquisa
		 *            [in] - Type on server: string
		 * @param pMaioridade
		 *            [in] - Type on server: string
		 * @param pTipoPesqCodProd
		 *            [in] - Type on server: string
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetProduto(String pCodOrDesc, String pPesquisa, String pMaioridade,
				String pTipoPesqCodProd) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetProduto");
			cmd.prepare(get_TSvrMethod_GetProduto_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pCodOrDesc);
			cmd.getParameter(1).getValue().SetAsString(pPesquisa);
			cmd.getParameter(2).getValue().SetAsString(pMaioridade);
			cmd.getParameter(3).getValue().SetAsString(pTipoPesqCodProd);
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(4).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetMeioProduto_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetMeioProduto_Metadata()
		{
			if (TSvrMethod_GetMeioProduto_Metadata == null)
			{
				TSvrMethod_GetMeioProduto_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pCodOrDesc", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pPesquisa", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pMaioridade", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pTipoPesqCodProd", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pGrupo", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetMeioProduto_Metadata;
		}

		/**
		 * @param pCodOrDesc
		 *            [in] - Type on server: string
		 * @param pPesquisa
		 *            [in] - Type on server: string
		 * @param pMaioridade
		 *            [in] - Type on server: string
		 * @param pTipoPesqCodProd
		 *            [in] - Type on server: string
		 * @param pGrupo
		 *            [in] - Type on server: string
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetMeioProduto(String pCodOrDesc, String pPesquisa, String pMaioridade,
				String pTipoPesqCodProd, String pGrupo) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetMeioProduto");
			cmd.prepare(get_TSvrMethod_GetMeioProduto_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pCodOrDesc);
			cmd.getParameter(1).getValue().SetAsString(pPesquisa);
			cmd.getParameter(2).getValue().SetAsString(pMaioridade);
			cmd.getParameter(3).getValue().SetAsString(pTipoPesqCodProd);
			cmd.getParameter(4).getValue().SetAsString(pGrupo);
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(5).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_insertMontagem_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_insertMontagem_Metadata()
		{
			if (TSvrMethod_insertMontagem_Metadata == null)
			{
				TSvrMethod_insertMontagem_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("viagem", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("mesa", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("taxaAtendimento", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("idFuncionario", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("comanda", DSRESTParamDirection.Input,
								DBXDataTypes.Int32Type, "Integer"),
						new DSRESTParameterMetaData("seqItemPai", DSRESTParamDirection.Input,
								DBXDataTypes.Int32Type, "Integer"),
						new DSRESTParameterMetaData("seqPeso", DSRESTParamDirection.Input,
								DBXDataTypes.Int32Type, "Integer"),
						new DSRESTParameterMetaData("montagem", DSRESTParamDirection.Input,
								DBXDataTypes.JsonValueType, "TJSONValue"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.WideStringType, "string"), };
			}
			return TSvrMethod_insertMontagem_Metadata;
		}

		/**
		 * @param viagem
		 *            [in] - Type on server: string
		 * @param mesa
		 *            [in] - Type on server: string
		 * @param taxaAtendimento
		 *            [in] - Type on server: string
		 * @param idFuncionario
		 *            [in] - Type on server: string
		 * @param comanda
		 *            [in] - Type on server: Integer
		 * @param seqItemPai
		 *            [in] - Type on server: Integer
		 * @param seqPeso
		 *            [in] - Type on server: Integer
		 * @param montagem
		 *            [in] - Type on server: TJSONValue
		 * @return result - Type on server: string
		 */
		public String insertMontagem(String viagem, String mesa, String taxaAtendimento,
				String idFuncionario, int comanda, int seqItemPai, int seqPeso, TJSONValue montagem)
				throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.POST);
			cmd.setText("TSvrMethod.insertMontagem");
			cmd.prepare(get_TSvrMethod_insertMontagem_Metadata());
			cmd.getParameter(0).getValue().SetAsString(viagem);
			cmd.getParameter(1).getValue().SetAsString(mesa);
			cmd.getParameter(2).getValue().SetAsString(taxaAtendimento);
			cmd.getParameter(3).getValue().SetAsString(idFuncionario);
			cmd.getParameter(4).getValue().SetAsInt32(comanda);
			cmd.getParameter(5).getValue().SetAsInt32(seqItemPai);
			cmd.getParameter(6).getValue().SetAsInt32(seqPeso);
			cmd.getParameter(7).getValue().SetAsJSONValue(montagem);
			getConnection().execute(cmd);
			return cmd.getParameter(8).getValue().GetAsString();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetProdVariacao_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetProdVariacao_Metadata()
		{
			if (TSvrMethod_GetProdVariacao_Metadata == null)
			{
				TSvrMethod_GetProdVariacao_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pCodProd", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pMaioridade", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pTipoPesqCodProd", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pDescVariacao", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetProdVariacao_Metadata;
		}

		/**
		 * @param pCodProd
		 *            [in] - Type on server: string
		 * @param pMaioridade
		 *            [in] - Type on server: string
		 * @param pTipoPesqCodProd
		 *            [in] - Type on server: string
		 * @param pDescVariacao
		 *            [in] - Type on server: string
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetProdVariacao(String pCodProd, String pMaioridade,
				String pTipoPesqCodProd, String pDescVariacao) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetProdVariacao");
			cmd.prepare(get_TSvrMethod_GetProdVariacao_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pCodProd);
			cmd.getParameter(1).getValue().SetAsString(pMaioridade);
			cmd.getParameter(2).getValue().SetAsString(pTipoPesqCodProd);
			cmd.getParameter(3).getValue().SetAsString(pDescVariacao);
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(4).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_UpdateFinalizaComanda_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_UpdateFinalizaComanda_Metadata()
		{
			if (TSvrMethod_UpdateFinalizaComanda_Metadata == null)
			{
				TSvrMethod_UpdateFinalizaComanda_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pComanda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("Error", DSRESTParamDirection.Output,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.BooleanType, "Boolean"), };
			}
			return TSvrMethod_UpdateFinalizaComanda_Metadata;
		}

		/**
		 * @param pComanda
		 *            [in] - Type on server: string
		 * @param Error
		 *            [out] - Type on server: string
		 * @return result - Type on server: Boolean
		 */
		public static class UpdateFinalizaComandaReturns
		{
			public String Error;
			public boolean returnValue;
		}

		public UpdateFinalizaComandaReturns UpdateFinalizaComanda(String pComanda)
				throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.UpdateFinalizaComanda");
			cmd.prepare(get_TSvrMethod_UpdateFinalizaComanda_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pComanda);
			getConnection().execute(cmd);
			UpdateFinalizaComandaReturns ret = new UpdateFinalizaComandaReturns();
			ret.Error = cmd.getParameter(1).getValue().GetAsString();
			ret.returnValue = cmd.getParameter(2).getValue().GetAsBoolean();
			return ret;
		}

		private DSRESTParameterMetaData[] TSvrMethod_ConfigurarConexao_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_ConfigurarConexao_Metadata()
		{
			if (TSvrMethod_ConfigurarConexao_Metadata == null)
			{
				TSvrMethod_ConfigurarConexao_Metadata = new DSRESTParameterMetaData[] {};
			}
			return TSvrMethod_ConfigurarConexao_Metadata;
		}

		public void ConfigurarConexao() throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.ConfigurarConexao");
			cmd.prepare(get_TSvrMethod_ConfigurarConexao_Metadata());
			getConnection().execute(cmd);
			return;
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetComanda_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetComanda_Metadata()
		{
			if (TSvrMethod_GetComanda_Metadata == null)
			{
				TSvrMethod_GetComanda_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pComanda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetComanda_Metadata;
		}

		/**
		 * @param pComanda
		 *            [in] - Type on server: string
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetComanda(String pComanda) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetComanda");
			cmd.prepare(get_TSvrMethod_GetComanda_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pComanda);
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(1).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetComandaMesa_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetComandaMesa_Metadata()
		{
			if (TSvrMethod_GetComandaMesa_Metadata == null)
			{
				TSvrMethod_GetComandaMesa_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pComanda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetComandaMesa_Metadata;
		}

		/**
		 * @param pComanda
		 *            [in] - Type on server: string
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetComandaMesa(String pComanda) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetComandaMesa");
			cmd.prepare(get_TSvrMethod_GetComandaMesa_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pComanda);
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(1).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetProdutos_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetProdutos_Metadata()
		{
			if (TSvrMethod_GetProdutos_Metadata == null)
			{
				TSvrMethod_GetProdutos_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("restricao", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetProdutos_Metadata;
		}

		/**
		 * @param restricao
		 *            [in] - Type on server: string
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetProdutos(String restricao) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetProdutos");
			cmd.prepare(get_TSvrMethod_GetProdutos_Metadata());
			cmd.getParameter(0).getValue().SetAsString(restricao);
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(1).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetProdutoPorGrupo_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetProdutoPorGrupo_Metadata()
		{
			if (TSvrMethod_GetProdutoPorGrupo_Metadata == null)
			{
				TSvrMethod_GetProdutoPorGrupo_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pGrupo", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetProdutoPorGrupo_Metadata;
		}

		/**
		 * @param pGrupo
		 *            [in] - Type on server: string
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetProdutoPorGrupo(String pGrupo) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetProdutoPorGrupo");
			cmd.prepare(get_TSvrMethod_GetProdutoPorGrupo_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pGrupo);
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(1).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetProdutoPorGrupoNovo_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetProdutoPorGrupoNovo_Metadata()
		{
			if (TSvrMethod_GetProdutoPorGrupoNovo_Metadata == null)
			{
				TSvrMethod_GetProdutoPorGrupoNovo_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pGrupo", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pMaioridade", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetProdutoPorGrupoNovo_Metadata;
		}

		/**
		 * @param pGrupo
		 *            [in] - Type on server: string
		 * @param pMaioridade
		 *            [in] - Type on server: string
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetProdutoPorGrupoNovo(String pGrupo, String pMaioridade)
				throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetProdutoPorGrupoNovo");
			cmd.prepare(get_TSvrMethod_GetProdutoPorGrupoNovo_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pGrupo);
			cmd.getParameter(1).getValue().SetAsString(pMaioridade);
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(2).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetFechamentoID_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetFechamentoID_Metadata()
		{
			if (TSvrMethod_GetFechamentoID_Metadata == null)
			{
				TSvrMethod_GetFechamentoID_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetFechamentoID_Metadata;
		}

		/**
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetFechamentoID() throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetFechamentoID");
			cmd.prepare(get_TSvrMethod_GetFechamentoID_Metadata());
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(0).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_InsertContaFechamento_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_InsertContaFechamento_Metadata()
		{
			if (TSvrMethod_InsertContaFechamento_Metadata == null)
			{
				TSvrMethod_InsertContaFechamento_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pId", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pComanda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("data", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("hora", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_InsertContaFechamento_Metadata;
		}

		/**
		 * @param pId
		 *            [in] - Type on server: string
		 * @param pComanda
		 *            [in] - Type on server: string
		 * @param data
		 *            [in] - Type on server: string
		 * @param hora
		 *            [in] - Type on server: string
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader InsertContaFechamento(String pId, String pComanda, String data,
				String hora) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.InsertContaFechamento");
			cmd.prepare(get_TSvrMethod_InsertContaFechamento_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pId);
			cmd.getParameter(1).getValue().SetAsString(pComanda);
			cmd.getParameter(2).getValue().SetAsString(data);
			cmd.getParameter(3).getValue().SetAsString(hora);
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(4).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetFecharConta_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetFecharConta_Metadata()
		{
			if (TSvrMethod_GetFecharConta_Metadata == null)
			{
				TSvrMethod_GetFecharConta_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pComanda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pCodFunc", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pQtdPessoas", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("imprimir", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("Error", DSRESTParamDirection.Output,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.BooleanType, "Boolean"), };
			}
			return TSvrMethod_GetFecharConta_Metadata;
		}

		/**
		 * @param pComanda
		 *            [in] - Type on server: string
		 * @param pCodFunc
		 *            [in] - Type on server: string
		 * @param pQtdPessoas
		 *            [in] - Type on server: string
		 * @param imprimir
		 *            [in] - Type on server: string
		 * @param Error
		 *            [out] - Type on server: string
		 * @return result - Type on server: Boolean
		 */
		public static class GetFecharContaReturns
		{
			public String Error;
			public boolean returnValue;
		}

		public GetFecharContaReturns GetFecharConta(String pComanda, String pCodFunc,
				String pQtdPessoas, String imprimir) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetFecharConta");
			cmd.prepare(get_TSvrMethod_GetFecharConta_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pComanda);
			cmd.getParameter(1).getValue().SetAsString(pCodFunc);
			cmd.getParameter(2).getValue().SetAsString(pQtdPessoas);
			cmd.getParameter(3).getValue().SetAsString(imprimir);
			getConnection().execute(cmd);
			GetFecharContaReturns ret = new GetFecharContaReturns();
			ret.Error = cmd.getParameter(4).getValue().GetAsString();
			ret.returnValue = cmd.getParameter(5).getValue().GetAsBoolean();
			return ret;
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetRetiraAcresIngre_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetRetiraAcresIngre_Metadata()
		{
			if (TSvrMethod_GetRetiraAcresIngre_Metadata == null)
			{
				TSvrMethod_GetRetiraAcresIngre_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("sCodProd", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("sTipo", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("sCodIngre", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("sNumLista", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetRetiraAcresIngre_Metadata;
		}

		/**
		 * @param sCodProd
		 *            [in] - Type on server: string
		 * @param sTipo
		 *            [in] - Type on server: string
		 * @param sCodIngre
		 *            [in] - Type on server: string
		 * @param sNumLista
		 *            [in] - Type on server: string
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetRetiraAcresIngre(String sCodProd, String sTipo, String sCodIngre,
				String sNumLista) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetRetiraAcresIngre");
			cmd.prepare(get_TSvrMethod_GetRetiraAcresIngre_Metadata());
			cmd.getParameter(0).getValue().SetAsString(sCodProd);
			cmd.getParameter(1).getValue().SetAsString(sTipo);
			cmd.getParameter(2).getValue().SetAsString(sCodIngre);
			cmd.getParameter(3).getValue().SetAsString(sNumLista);
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(4).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GravarComanda_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GravarComanda2_Metadata()
		{
			if (TSvrMethod_GravarComanda_Metadata == null)
			{
				TSvrMethod_GravarComanda_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("Value", DSRESTParamDirection.Input,
								DBXDataTypes.JsonValueType, "TJSONObject"),
						new DSRESTParameterMetaData("sMensagem", DSRESTParamDirection.Output,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.WideStringType, "string"), };
			}
			return TSvrMethod_GravarComanda_Metadata;
		}

		/**
		 * @param Value
		 *            [in] - Type on server: TJSONObject
		 * @param sMensagem
		 *            [out] - Type on server: string
		 * @return result - Type on server: string
		 */
		public static class GravarComandaReturns
		{
			public String sMensagem;
			public String returnValue;
		}

		public GravarComandaReturns GravarComanda(TJSONObject Value) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.POST);
			cmd.setText("TSvrMethod.GravarComanda");
			cmd.prepare(get_TSvrMethod_GravarComanda2_Metadata());
			cmd.getParameter(0).getValue().SetAsJSONValue(Value);
			getConnection().execute(cmd);
			GravarComandaReturns ret = new GravarComandaReturns();
			ret.sMensagem = cmd.getParameter(1).getValue().GetAsString();
			ret.returnValue = cmd.getParameter(2).getValue().GetAsString();
			return ret;
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetMeioProd_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetMeioProd_Metadata()
		{
			if (TSvrMethod_GetMeioProd_Metadata == null)
			{
				TSvrMethod_GetMeioProd_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pComanda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pCodProd", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pQtd", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pMesa", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pQtdPessoas", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pCodFunc", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pTipoPesqCodProd", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("MsgRetorno", DSRESTParamDirection.Output,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.BooleanType, "Boolean"), };
			}
			return TSvrMethod_GetMeioProd_Metadata;
		}

		/**
		 * @param pComanda
		 *            [in] - Type on server: string
		 * @param pCodProd
		 *            [in] - Type on server: string
		 * @param pQtd
		 *            [in] - Type on server: string
		 * @param pMesa
		 *            [in] - Type on server: string
		 * @param pQtdPessoas
		 *            [in] - Type on server: string
		 * @param pCodFunc
		 *            [in] - Type on server: string
		 * @param pTipoPesqCodProd
		 *            [in] - Type on server: string
		 * @param MsgRetorno
		 *            [out] - Type on server: string
		 * @return result - Type on server: Boolean
		 */
		public static class GetMeioProdReturns
		{
			public String MsgRetorno;
			public boolean returnValue;
		}

		public GetMeioProdReturns GetMeioProd(String pComanda, String pCodProd, String pQtd,
				String pMesa, String pQtdPessoas, String pCodFunc, String pTipoPesqCodProd)
				throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetMeioProd");
			cmd.prepare(get_TSvrMethod_GetMeioProd_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pComanda);
			cmd.getParameter(1).getValue().SetAsString(pCodProd);
			cmd.getParameter(2).getValue().SetAsString(pQtd);
			cmd.getParameter(3).getValue().SetAsString(pMesa);
			cmd.getParameter(4).getValue().SetAsString(pQtdPessoas);
			cmd.getParameter(5).getValue().SetAsString(pCodFunc);
			cmd.getParameter(6).getValue().SetAsString(pTipoPesqCodProd);
			getConnection().execute(cmd);
			GetMeioProdReturns ret = new GetMeioProdReturns();
			ret.MsgRetorno = cmd.getParameter(7).getValue().GetAsString();
			ret.returnValue = cmd.getParameter(8).getValue().GetAsBoolean();
			return ret;
		}

		private DSRESTParameterMetaData[] TSvrMethod_BloqueiaValorComandaParametro_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_BloqueiaValorComandaParametro_Metadata()
		{
			if (TSvrMethod_BloqueiaValorComandaParametro_Metadata == null)
			{
				TSvrMethod_BloqueiaValorComandaParametro_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pComanda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.BooleanType, "Boolean"), };
			}
			return TSvrMethod_BloqueiaValorComandaParametro_Metadata;
		}

		/**
		 * @param pComanda
		 *            [in] - Type on server: string
		 * @return result - Type on server: Boolean
		 */
		public boolean BloqueiaValorComandaParametro(String pComanda) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.BloqueiaValorComandaParametro");
			cmd.prepare(get_TSvrMethod_BloqueiaValorComandaParametro_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pComanda);
			getConnection().execute(cmd);
			return cmd.getParameter(1).getValue().GetAsBoolean();
		}

		private DSRESTParameterMetaData[] TSvrMethod_BloqueiaValorComandaParametro2_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_BloqueiaValorComandaParametro2_Metadata()
		{
			if (TSvrMethod_BloqueiaValorComandaParametro2_Metadata == null)
			{
				TSvrMethod_BloqueiaValorComandaParametro2_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("Value", DSRESTParamDirection.Input,
								DBXDataTypes.JsonValueType, "TJSONObject"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.WideStringType, "string"), };
			}
			return TSvrMethod_BloqueiaValorComandaParametro2_Metadata;
		}

		/**
		 * @param Value
		 *            [in] - Type on server: TJSONObject
		 * @return result - Type on server: string
		 */
		public String BloqueiaValorComandaParametro2(TJSONObject Value) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.POST);
			cmd.setText("TSvrMethod.BloqueiaValorComandaParametro2");
			cmd.prepare(get_TSvrMethod_BloqueiaValorComandaParametro2_Metadata());
			cmd.getParameter(0).getValue().SetAsJSONValue(Value);
			getConnection().execute(cmd);
			return cmd.getParameter(1).getValue().GetAsString();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetInfoNroPessoas_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetInfoNroPessoas_Metadata()
		{
			if (TSvrMethod_GetInfoNroPessoas_Metadata == null)
			{
				TSvrMethod_GetInfoNroPessoas_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pComanda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetInfoNroPessoas_Metadata;
		}

		/**
		 * @param pComanda
		 *            [in] - Type on server: string
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetInfoNroPessoas(String pComanda) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetInfoNroPessoas");
			cmd.prepare(get_TSvrMethod_GetInfoNroPessoas_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pComanda);
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(1).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetCliente_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetCliente_Metadata()
		{
			if (TSvrMethod_GetCliente_Metadata == null)
			{
				TSvrMethod_GetCliente_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pCpf", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetCliente_Metadata;
		}

		/**
		 * @param pCpf
		 *            [in] - Type on server: string
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetCliente(String pCpf) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetCliente");
			cmd.prepare(get_TSvrMethod_GetCliente_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pCpf);
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(1).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetFila_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetFila_Metadata()
		{
			if (TSvrMethod_GetFila_Metadata == null)
			{
				TSvrMethod_GetFila_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetFila_Metadata;
		}

		/**
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetFila() throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetFila");
			cmd.prepare(get_TSvrMethod_GetFila_Metadata());
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(0).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_UpdateComanda_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_UpdateComanda_Metadata()
		{
			if (TSvrMethod_UpdateComanda_Metadata == null)
			{
				TSvrMethod_UpdateComanda_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pComanda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pNome", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pRg", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pCpf", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pDataNasc", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("Error", DSRESTParamDirection.Output,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.BooleanType, "Boolean"), };
			}
			return TSvrMethod_UpdateComanda_Metadata;
		}

		/**
		 * @param pComanda
		 *            [in] - Type on server: string
		 * @param pNome
		 *            [in] - Type on server: string
		 * @param pRg
		 *            [in] - Type on server: string
		 * @param pCpf
		 *            [in] - Type on server: string
		 * @param pDataNasc
		 *            [in] - Type on server: string
		 * @param Error
		 *            [out] - Type on server: string
		 * @return result - Type on server: Boolean
		 */
		public static class UpdateComandaReturns
		{
			public String Error;
			public boolean returnValue;
		}

		public UpdateComandaReturns UpdateComanda(String pComanda, String pNome, String pRg,
				String pCpf, String pDataNasc) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.UpdateComanda");
			cmd.prepare(get_TSvrMethod_UpdateComanda_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pComanda);
			cmd.getParameter(1).getValue().SetAsString(pNome);
			cmd.getParameter(2).getValue().SetAsString(pRg);
			cmd.getParameter(3).getValue().SetAsString(pCpf);
			cmd.getParameter(4).getValue().SetAsString(pDataNasc);
			getConnection().execute(cmd);
			UpdateComandaReturns ret = new UpdateComandaReturns();
			ret.Error = cmd.getParameter(5).getValue().GetAsString();
			ret.returnValue = cmd.getParameter(6).getValue().GetAsBoolean();
			return ret;
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetClienteComanda_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetClienteComanda_Metadata()
		{
			if (TSvrMethod_GetClienteComanda_Metadata == null)
			{
				TSvrMethod_GetClienteComanda_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pComanda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetClienteComanda_Metadata;
		}

		/**
		 * @param pComanda
		 *            [in] - Type on server: string
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetClienteComanda(String pComanda) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetClienteComanda");
			cmd.prepare(get_TSvrMethod_GetClienteComanda_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pComanda);
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(1).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_UpdateCliente_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_UpdateCliente_Metadata()
		{
			if (TSvrMethod_UpdateCliente_Metadata == null)
			{
				TSvrMethod_UpdateCliente_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pNome", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pRg", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pCpf", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pDataNasc", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pTelefone", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("Error", DSRESTParamDirection.Output,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.BooleanType, "Boolean"), };
			}
			return TSvrMethod_UpdateCliente_Metadata;
		}

		/**
		 * @param pNome
		 *            [in] - Type on server: string
		 * @param pRg
		 *            [in] - Type on server: string
		 * @param pCpf
		 *            [in] - Type on server: string
		 * @param pDataNasc
		 *            [in] - Type on server: string
		 * @param pTelefone
		 *            [in] - Type on server: string
		 * @param Error
		 *            [out] - Type on server: string
		 * @return result - Type on server: Boolean
		 */
		public static class UpdateClienteReturns
		{
			public String Error;
			public boolean returnValue;
		}

		public UpdateClienteReturns UpdateCliente(String pNome, String pRg, String pCpf,
				String pDataNasc, String pTelefone) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.UpdateCliente");
			cmd.prepare(get_TSvrMethod_UpdateCliente_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pNome);
			cmd.getParameter(1).getValue().SetAsString(pRg);
			cmd.getParameter(2).getValue().SetAsString(pCpf);
			cmd.getParameter(3).getValue().SetAsString(pDataNasc);
			cmd.getParameter(4).getValue().SetAsString(pTelefone);
			getConnection().execute(cmd);
			UpdateClienteReturns ret = new UpdateClienteReturns();
			ret.Error = cmd.getParameter(5).getValue().GetAsString();
			ret.returnValue = cmd.getParameter(6).getValue().GetAsBoolean();
			return ret;
		}

		private DSRESTParameterMetaData[] TSvrMethod_InsertComandaMobile_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_InsertComandaMobile_Metadata()
		{
			if (TSvrMethod_InsertComandaMobile_Metadata == null)
			{
				TSvrMethod_InsertComandaMobile_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pComanda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("Error", DSRESTParamDirection.Output,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.BooleanType, "Boolean"), };
			}
			return TSvrMethod_InsertComandaMobile_Metadata;
		}

		/**
		 * @param pComanda
		 *            [in] - Type on server: string
		 * @param Error
		 *            [out] - Type on server: string
		 * @return result - Type on server: Boolean
		 */
		public static class InsertComandaMobileReturns
		{
			public String Error;
			public boolean returnValue;
		}

		public InsertComandaMobileReturns InsertComandaMobile(String pComanda) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.InsertComandaMobile");
			cmd.prepare(get_TSvrMethod_InsertComandaMobile_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pComanda);
			getConnection().execute(cmd);
			InsertComandaMobileReturns ret = new InsertComandaMobileReturns();
			ret.Error = cmd.getParameter(1).getValue().GetAsString();
			ret.returnValue = cmd.getParameter(2).getValue().GetAsBoolean();
			return ret;
		}

		private DSRESTParameterMetaData[] TSvrMethod_ValidaComandaUid_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_ValidaComandaUid_Metadata()
		{
			if (TSvrMethod_ValidaComandaUid_Metadata == null)
			{
				TSvrMethod_ValidaComandaUid_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pUid", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.Int16Type, "integer"), };
			}
			return TSvrMethod_ValidaComandaUid_Metadata;
		}

		/**
		 * @param pUid
		 *            [in] - Type on server: string
		 * @return result - Type on server: integer
		 */
		public int ValidaComandaUid(String pUid) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.ValidaComandaUid");
			cmd.prepare(get_TSvrMethod_ValidaComandaUid_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pUid);
			getConnection().execute(cmd);
			return cmd.getParameter(1).getValue().GetAsInt16();
		}

		private DSRESTParameterMetaData[] TSvrMethod_ValidaTagUid_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_ValidaTagUid_Metadata()
		{
			if (TSvrMethod_ValidaTagUid_Metadata == null)
			{
				TSvrMethod_ValidaTagUid_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pUid", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_ValidaTagUid_Metadata;
		}

		/**
		 * @param pUid
		 *            [in] - Type on server: string
		 * @return result - Type on server: integer
		 */
		public TagUidReturn ValidaTagUid(String pUid) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.ValidaTagUid");
			cmd.prepare(get_TSvrMethod_ValidaTagUid_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pUid);
			getConnection().execute(cmd);
			TagUidReturn ret = new TagUidReturn();
			TDBXReader reader = (TDBXReader) cmd.getParameter(1).getValue().GetAsTable();
			reader.next();
			ret.setComanda(reader.getValue("COMANDA").GetAsInt32());
			ret.setUser(reader.getValue("NOME").GetAsString());
			return ret;
		}

		public static class TagUidReturn {
			private String user;
			private int comanda;

			public String getUser() {
				return user;
			}

			public void setUser(String user) {
				this.user = user;
			}

			public int getComanda() {
				return comanda;
			}

			public void setComanda(int comanda) {
				this.comanda = comanda;
			}
		}

		private DSRESTParameterMetaData[] TSvrMethod_UpdateComandaUid_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_UpdateComandaUid_Metadata()
		{
			if (TSvrMethod_UpdateComandaUid_Metadata == null)
			{
				TSvrMethod_UpdateComandaUid_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pUid", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pComanda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("Error", DSRESTParamDirection.Output,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.BooleanType, "Boolean"), };
			}
			return TSvrMethod_UpdateComandaUid_Metadata;
		}

		/**
		 * @param pUid
		 *            [in] - Type on server: string
		 * @param pComanda
		 *            [in] - Type on server: string
		 * @param Error
		 *            [out] - Type on server: string
		 * @return result - Type on server: Boolean
		 */
		public static class UpdateComandaUidReturns
		{
			public String Error;
			public boolean returnValue;
		}

		public UpdateComandaUidReturns UpdateComandaUid(String pUid, String pComanda)
				throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.UpdateComandaUid");
			cmd.prepare(get_TSvrMethod_UpdateComandaUid_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pUid);
			cmd.getParameter(1).getValue().SetAsString(pComanda);
			getConnection().execute(cmd);
			UpdateComandaUidReturns ret = new UpdateComandaUidReturns();
			ret.Error = cmd.getParameter(2).getValue().GetAsString();
			ret.returnValue = cmd.getParameter(3).getValue().GetAsBoolean();
			return ret;
		}

		private DSRESTParameterMetaData[] TSvrMethod_InsertComandaUid_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_InsertComandaUid_Metadata()
		{
			if (TSvrMethod_InsertComandaUid_Metadata == null)
			{
				TSvrMethod_InsertComandaUid_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("uid", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("Comanda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.BooleanType, "Boolean"), };
			}
			return TSvrMethod_InsertComandaUid_Metadata;
		}

		public boolean InsertComandaUid(String uid, String Comanda)
				throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.InsertComandaByUid");
			cmd.prepare(get_TSvrMethod_InsertComandaUid_Metadata());
			cmd.getParameter(0).getValue().SetAsString(uid);
			cmd.getParameter(1).getValue().SetAsString(Comanda);
			getConnection().execute(cmd);
			boolean retorno = cmd.getParameter(2).getValue().GetAsBoolean();
			return retorno;
		}

		private DSRESTParameterMetaData[] TSvrMethod_DeleteComanda_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_DeleteComanda_Metadata()
		{
			if (TSvrMethod_DeleteComanda_Metadata == null)
			{
				TSvrMethod_DeleteComanda_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pComanda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pVinculadoPeloAndroid",
								DSRESTParamDirection.Input, DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.BooleanType, "Boolean"), };
			}
			return TSvrMethod_DeleteComanda_Metadata;
		}

		/**
		 * @param pComanda
		 *            [in] - Type on server: string
		 * @param pVinculadoPeloAndroid
		 *            [in] - Type on server: string
		 * @return result - Type on server: Boolean
		 */
		public boolean DeleteComanda(String pComanda, String pVinculadoPeloAndroid)
				throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.DeleteComanda");
			cmd.prepare(get_TSvrMethod_DeleteComanda_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pComanda);
			cmd.getParameter(1).getValue().SetAsString(pVinculadoPeloAndroid);
			getConnection().execute(cmd);
			return cmd.getParameter(2).getValue().GetAsBoolean();
		}

		private DSRESTParameterMetaData[] TSvrMethod_Acerto_Estoque_Prod_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_Acerto_Estoque_Prod_Metadata()
		{
			if (TSvrMethod_Acerto_Estoque_Prod_Metadata == null)
			{
				TSvrMethod_Acerto_Estoque_Prod_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pCodProd", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pQtd", DSRESTParamDirection.Input,
								DBXDataTypes.DoubleType, "Double"),
						new DSRESTParameterMetaData("pEntSai", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.BooleanType, "Boolean"), };
			}
			return TSvrMethod_Acerto_Estoque_Prod_Metadata;
		}

		/**
		 * @param pCodProd
		 *            [in] - Type on server: string
		 * @param pQtd
		 *            [in] - Type on server: Double
		 * @param pEntSai
		 *            [in] - Type on server: string
		 * @return result - Type on server: Boolean
		 */
		public boolean Acerto_Estoque_Prod(String pCodProd, double pQtd, String pEntSai)
				throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.Acerto_Estoque_Prod");
			cmd.prepare(get_TSvrMethod_Acerto_Estoque_Prod_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pCodProd);
			cmd.getParameter(1).getValue().SetAsDouble(pQtd);
			cmd.getParameter(2).getValue().SetAsString(pEntSai);
			getConnection().execute(cmd);
			return cmd.getParameter(3).getValue().GetAsBoolean();
		}

		private DSRESTParameterMetaData[] TSvrMethod_Acerto_Estoque_Ingre_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_Acerto_Estoque_Ingre_Metadata()
		{
			if (TSvrMethod_Acerto_Estoque_Ingre_Metadata == null)
			{
				TSvrMethod_Acerto_Estoque_Ingre_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pCodIngre", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pQtd", DSRESTParamDirection.Input,
								DBXDataTypes.DoubleType, "Double"),
						new DSRESTParameterMetaData("pEntSai", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.BooleanType, "Boolean"), };
			}
			return TSvrMethod_Acerto_Estoque_Ingre_Metadata;
		}

		/**
		 * @param pCodIngre
		 *            [in] - Type on server: string
		 * @param pQtd
		 *            [in] - Type on server: Double
		 * @param pEntSai
		 *            [in] - Type on server: string
		 * @return result - Type on server: Boolean
		 */
		public boolean Acerto_Estoque_Ingre(String pCodIngre, double pQtd, String pEntSai)
				throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.Acerto_Estoque_Ingre");
			cmd.prepare(get_TSvrMethod_Acerto_Estoque_Ingre_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pCodIngre);
			cmd.getParameter(1).getValue().SetAsDouble(pQtd);
			cmd.getParameter(2).getValue().SetAsString(pEntSai);
			getConnection().execute(cmd);
			return cmd.getParameter(3).getValue().GetAsBoolean();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetBalancaValor_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetBalancaValor_Metadata()
		{
			if (TSvrMethod_GetBalancaValor_Metadata == null)
			{
				TSvrMethod_GetBalancaValor_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("idBalanca", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetBalancaValor_Metadata;
		}

		/**
		 * @param idBalanca
		 *            [in] - Type on server: string
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetBalancaValor(String idBalanca) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetBalancaValor");
			cmd.prepare(get_TSvrMethod_GetBalancaValor_Metadata());
			cmd.getParameter(0).getValue().SetAsString(idBalanca);
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(1).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_DeleteBalancaValor_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_DeleteBalancaValor_Metadata()
		{
			if (TSvrMethod_DeleteBalancaValor_Metadata == null)
			{
				TSvrMethod_DeleteBalancaValor_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("Value", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("idBalanca", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.BooleanType, "Boolean"), };
			}
			return TSvrMethod_DeleteBalancaValor_Metadata;
		}

		/**
		 * @param Value
		 *            [in] - Type on server: string
		 * @param idBalanca
		 *            [in] - Type on server: string
		 * @return result - Type on server: Boolean
		 */
		public boolean DeleteBalancaValor(String Value, String idBalanca) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.DeleteBalancaValor");
			cmd.prepare(get_TSvrMethod_DeleteBalancaValor_Metadata());
			cmd.getParameter(0).getValue().SetAsString(Value);
			cmd.getParameter(1).getValue().SetAsString(idBalanca);
			getConnection().execute(cmd);
			return cmd.getParameter(2).getValue().GetAsBoolean();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetListaBalancaValor_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetListaBalancaValor_Metadata()
		{
			if (TSvrMethod_GetListaBalancaValor_Metadata == null)
			{
				TSvrMethod_GetListaBalancaValor_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("idBalanca", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetListaBalancaValor_Metadata;
		}

		/**
		 * @param idBalanca
		 *            [in] - Type on server: string
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetListaBalancaValor(String idBalanca) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetListaBalancaValor");
			cmd.prepare(get_TSvrMethod_GetListaBalancaValor_Metadata());
			cmd.getParameter(0).getValue().SetAsString(idBalanca);
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(1).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_ConsultaProdutoSimples_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_ConsultaProdutoSimples_Metadata()
		{
			if (TSvrMethod_ConsultaProdutoSimples_Metadata == null)
			{
				TSvrMethod_ConsultaProdutoSimples_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_ConsultaProdutoSimples_Metadata;
		}

		/**
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader ConsultaProdutoSimples() throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.ConsultaProdutoSimples");
			cmd.prepare(get_TSvrMethod_ConsultaProdutoSimples_Metadata());
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(0).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_ConsultaTodosGrupos_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_ConsultaTodosGrupos_Metadata()
		{
			if (TSvrMethod_ConsultaTodosGrupos_Metadata == null)
			{
				TSvrMethod_ConsultaTodosGrupos_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_ConsultaTodosGrupos_Metadata;
		}

		/**
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader ConsultaTodosGrupos() throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.ConsultaTodosGrupos");
			cmd.prepare(get_TSvrMethod_ConsultaTodosGrupos_Metadata());
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(0).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_ConsultaTodosSubGrupos_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_ConsultaTodosSubGrupos_Metadata()
		{
			if (TSvrMethod_ConsultaTodosSubGrupos_Metadata == null)
			{
				TSvrMethod_ConsultaTodosSubGrupos_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_ConsultaTodosSubGrupos_Metadata;
		}

		/**
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader ConsultaTodosSubGrupos() throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.ConsultaTodosSubGrupos");
			cmd.prepare(get_TSvrMethod_ConsultaTodosSubGrupos_Metadata());
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(0).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_ConsultaSubGruposUsados_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_ConsultaSubGruposUsados_Metadata()
		{
			if (TSvrMethod_ConsultaSubGruposUsados_Metadata == null)
			{
				TSvrMethod_ConsultaSubGruposUsados_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("tipo", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_ConsultaSubGruposUsados_Metadata;
		}

		/**
		 * @param tipo
		 *            [in] - Type on server: string
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader ConsultaSubGruposUsados(String tipo) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.ConsultaSubGruposUsados");
			cmd.prepare(get_TSvrMethod_ConsultaSubGruposUsados_Metadata());
			cmd.getParameter(0).getValue().SetAsString(tipo);
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(1).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_ConsultaProduto_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_ConsultaProduto_Metadata()
		{
			if (TSvrMethod_ConsultaProduto_Metadata == null)
			{
				TSvrMethod_ConsultaProduto_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("idGrupo", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("idSubGrupo", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_ConsultaProduto_Metadata;
		}

		/**
		 * @param idGrupo
		 *            [in] - Type on server: string
		 * @param idSubGrupo
		 *            [in] - Type on server: string
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader ConsultaProduto(String idGrupo, String idSubGrupo) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.ConsultaProduto");
			cmd.prepare(get_TSvrMethod_ConsultaProduto_Metadata());
			cmd.getParameter(0).getValue().SetAsString(idGrupo);
			cmd.getParameter(1).getValue().SetAsString(idSubGrupo);
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(2).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_ConsultaMateriaPrima_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_ConsultaMateriaPrima_Metadata()
		{
			if (TSvrMethod_ConsultaMateriaPrima_Metadata == null)
			{
				TSvrMethod_ConsultaMateriaPrima_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("idGrupo", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("idSubGrupo", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_ConsultaMateriaPrima_Metadata;
		}

		/**
		 * @param idGrupo
		 *            [in] - Type on server: string
		 * @param idSubGrupo
		 *            [in] - Type on server: string
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader ConsultaMateriaPrima(String idGrupo, String idSubGrupo)
				throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.ConsultaMateriaPrima");
			cmd.prepare(get_TSvrMethod_ConsultaMateriaPrima_Metadata());
			cmd.getParameter(0).getValue().SetAsString(idGrupo);
			cmd.getParameter(1).getValue().SetAsString(idSubGrupo);
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(2).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetIDInventario_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetIDInventario_Metadata()
		{
			if (TSvrMethod_GetIDInventario_Metadata == null)
			{
				TSvrMethod_GetIDInventario_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetIDInventario_Metadata;
		}

		/**
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetIDInventario() throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetIDInventario");
			cmd.prepare(get_TSvrMethod_GetIDInventario_Metadata());
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(0).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_InsertInventario_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_InsertInventario_Metadata()
		{
			if (TSvrMethod_InsertInventario_Metadata == null)
			{
				TSvrMethod_InsertInventario_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("id", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("data", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("hora", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("usuario", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("tipo", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("data_contagem", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("hora_contagem", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("data_termino", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("hora_termino", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("finalizado", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_InsertInventario_Metadata;
		}

		/**
		 * @param id
		 *            [in] - Type on server: string
		 * @param data
		 *            [in] - Type on server: string
		 * @param hora
		 *            [in] - Type on server: string
		 * @param usuario
		 *            [in] - Type on server: string
		 * @param tipo
		 *            [in] - Type on server: string
		 * @param data_contagem
		 *            [in] - Type on server: string
		 * @param hora_contagem
		 *            [in] - Type on server: string
		 * @param data_termino
		 *            [in] - Type on server: string
		 * @param hora_termino
		 *            [in] - Type on server: string
		 * @param finalizado
		 *            [in] - Type on server: string
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader InsertInventario(String id, String data, String hora, String usuario,
				String tipo, String data_contagem, String hora_contagem, String data_termino,
				String hora_termino, String finalizado) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.InsertInventario");
			cmd.prepare(get_TSvrMethod_InsertInventario_Metadata());
			cmd.getParameter(0).getValue().SetAsString(id);
			cmd.getParameter(1).getValue().SetAsString(data);
			cmd.getParameter(2).getValue().SetAsString(hora);
			cmd.getParameter(3).getValue().SetAsString(usuario);
			cmd.getParameter(4).getValue().SetAsString(tipo);
			cmd.getParameter(5).getValue().SetAsString(data_contagem);
			cmd.getParameter(6).getValue().SetAsString(hora_contagem);
			cmd.getParameter(7).getValue().SetAsString(data_termino);
			cmd.getParameter(8).getValue().SetAsString(hora_termino);
			cmd.getParameter(9).getValue().SetAsString(finalizado);
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(10).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_InsertDetalheInventario_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_InsertDetalheInventario_Metadata()
		{
			if (TSvrMethod_InsertDetalheInventario_Metadata == null)
			{
				TSvrMethod_InsertDetalheInventario_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("id", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("codigo", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("desc", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("unidade", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("estoque", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("qtde_informada", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("vr_custo", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("vr_estoque_inf", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("vr_estoque_sis", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("vr_diferenca", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_InsertDetalheInventario_Metadata;
		}

		/**
		 * @param id
		 *            [in] - Type on server: string
		 * @param codigo
		 *            [in] - Type on server: string
		 * @param desc
		 *            [in] - Type on server: string
		 * @param unidade
		 *            [in] - Type on server: string
		 * @param estoque
		 *            [in] - Type on server: string
		 * @param qtde_informada
		 *            [in] - Type on server: string
		 * @param vr_custo
		 *            [in] - Type on server: string
		 * @param vr_estoque_inf
		 *            [in] - Type on server: string
		 * @param vr_estoque_sis
		 *            [in] - Type on server: string
		 * @param vr_diferenca
		 *            [in] - Type on server: string
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader InsertDetalheInventario(String id, String codigo, String desc,
				String unidade, String estoque, String qtde_informada, String vr_custo,
				String vr_estoque_inf, String vr_estoque_sis, String vr_diferenca)
				throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.InsertDetalheInventario");
			cmd.prepare(get_TSvrMethod_InsertDetalheInventario_Metadata());
			cmd.getParameter(0).getValue().SetAsString(id);
			cmd.getParameter(1).getValue().SetAsString(codigo);
			cmd.getParameter(2).getValue().SetAsString(desc);
			cmd.getParameter(3).getValue().SetAsString(unidade);
			cmd.getParameter(4).getValue().SetAsString(estoque);
			cmd.getParameter(5).getValue().SetAsString(qtde_informada);
			cmd.getParameter(6).getValue().SetAsString(vr_custo);
			cmd.getParameter(7).getValue().SetAsString(vr_estoque_inf);
			cmd.getParameter(8).getValue().SetAsString(vr_estoque_sis);
			cmd.getParameter(9).getValue().SetAsString(vr_diferenca);
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(10).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_UpdateEstoqueProduto_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_UpdateEstoqueProduto_Metadata()
		{
			if (TSvrMethod_UpdateEstoqueProduto_Metadata == null)
			{
				TSvrMethod_UpdateEstoqueProduto_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("codigo", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("estoque_informado", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_UpdateEstoqueProduto_Metadata;
		}

		/**
		 * @param codigo
		 *            [in] - Type on server: string
		 * @param estoque_informado
		 *            [in] - Type on server: string
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader UpdateEstoqueProduto(String codigo, String estoque_informado)
				throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.UpdateEstoqueProduto");
			cmd.prepare(get_TSvrMethod_UpdateEstoqueProduto_Metadata());
			cmd.getParameter(0).getValue().SetAsString(codigo);
			cmd.getParameter(1).getValue().SetAsString(estoque_informado);
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(2).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_UpdateEstoqueMateriaPrima_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_UpdateEstoqueMateriaPrima_Metadata()
		{
			if (TSvrMethod_UpdateEstoqueMateriaPrima_Metadata == null)
			{
				TSvrMethod_UpdateEstoqueMateriaPrima_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("codigo", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("estoque_informado", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_UpdateEstoqueMateriaPrima_Metadata;
		}

		/**
		 * @param codigo
		 *            [in] - Type on server: string
		 * @param estoque_informado
		 *            [in] - Type on server: string
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader UpdateEstoqueMateriaPrima(String codigo, String estoque_informado)
				throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.UpdateEstoqueMateriaPrima");
			cmd.prepare(get_TSvrMethod_UpdateEstoqueMateriaPrima_Metadata());
			cmd.getParameter(0).getValue().SetAsString(codigo);
			cmd.getParameter(1).getValue().SetAsString(estoque_informado);
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(2).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetIDEstoque_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetIDEstoque_Metadata()
		{
			if (TSvrMethod_GetIDEstoque_Metadata == null)
			{
				TSvrMethod_GetIDEstoque_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetIDEstoque_Metadata;
		}

		/**
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetIDEstoque() throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetIDEstoque");
			cmd.prepare(get_TSvrMethod_GetIDEstoque_Metadata());
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(0).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_InsertAcertoEstoque_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_InsertAcertoEstoque_Metadata()
		{
			if (TSvrMethod_InsertAcertoEstoque_Metadata == null)
			{
				TSvrMethod_InsertAcertoEstoque_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("id", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("tipo", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("data", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("hora", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("id_inv", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("usuario", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_InsertAcertoEstoque_Metadata;
		}

		/**
		 * @param id
		 *            [in] - Type on server: string
		 * @param tipo
		 *            [in] - Type on server: string
		 * @param data
		 *            [in] - Type on server: string
		 * @param hora
		 *            [in] - Type on server: string
		 * @param id_inv
		 *            [in] - Type on server: string
		 * @param usuario
		 *            [in] - Type on server: string
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader InsertAcertoEstoque(String id, String tipo, String data, String hora,
				String id_inv, String usuario) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.InsertAcertoEstoque");
			cmd.prepare(get_TSvrMethod_InsertAcertoEstoque_Metadata());
			cmd.getParameter(0).getValue().SetAsString(id);
			cmd.getParameter(1).getValue().SetAsString(tipo);
			cmd.getParameter(2).getValue().SetAsString(data);
			cmd.getParameter(3).getValue().SetAsString(hora);
			cmd.getParameter(4).getValue().SetAsString(id_inv);
			cmd.getParameter(5).getValue().SetAsString(usuario);
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(6).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_InsertAcertoEstoqueDetalhes_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_InsertAcertoEstoqueDetalhes_Metadata()
		{
			if (TSvrMethod_InsertAcertoEstoqueDetalhes_Metadata == null)
			{
				TSvrMethod_InsertAcertoEstoqueDetalhes_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("id", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("item", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("codigo_produto", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("estoque_anterior", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("diferenca", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("estoque_atual", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("tipo_item", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"), };
			}
			return TSvrMethod_InsertAcertoEstoqueDetalhes_Metadata;
		}

		/**
		 * @param id
		 *            [in] - Type on server: string
		 * @param item
		 *            [in] - Type on server: string
		 * @param codigo_produto
		 *            [in] - Type on server: string
		 * @param estoque_anterior
		 *            [in] - Type on server: string
		 * @param diferenca
		 *            [in] - Type on server: string
		 * @param estoque_atual
		 *            [in] - Type on server: string
		 * @param tipo_item
		 *            [in] - Type on server: string
		 */
		public void InsertAcertoEstoqueDetalhes(String id, String item, String codigo_produto,
				String estoque_anterior, String diferenca, String estoque_atual, String tipo_item)
				throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.InsertAcertoEstoqueDetalhes");
			cmd.prepare(get_TSvrMethod_InsertAcertoEstoqueDetalhes_Metadata());
			cmd.getParameter(0).getValue().SetAsString(id);
			cmd.getParameter(1).getValue().SetAsString(item);
			cmd.getParameter(2).getValue().SetAsString(codigo_produto);
			cmd.getParameter(3).getValue().SetAsString(estoque_anterior);
			cmd.getParameter(4).getValue().SetAsString(diferenca);
			cmd.getParameter(5).getValue().SetAsString(estoque_atual);
			cmd.getParameter(6).getValue().SetAsString(tipo_item);
			getConnection().execute(cmd);
			return;
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetUsuarioRealizaInventario_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetUsuarioRealizaInventario_Metadata()
		{
			if (TSvrMethod_GetUsuarioRealizaInventario_Metadata == null)
			{
				TSvrMethod_GetUsuarioRealizaInventario_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("usuario", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetUsuarioRealizaInventario_Metadata;
		}

		/**
		 * @param usuario
		 *            [in] - Type on server: string
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetUsuarioRealizaInventario(String usuario) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetUsuarioRealizaInventario");
			cmd.prepare(get_TSvrMethod_GetUsuarioRealizaInventario_Metadata());
			cmd.getParameter(0).getValue().SetAsString(usuario);
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(1).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetParametroRealizaInventario_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetParametroRealizaInventario_Metadata()
		{
			if (TSvrMethod_GetParametroRealizaInventario_Metadata == null)
			{
				TSvrMethod_GetParametroRealizaInventario_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetParametroRealizaInventario_Metadata;
		}

		/**
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetParametroRealizaInventario() throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetParametroRealizaInventario");
			cmd.prepare(get_TSvrMethod_GetParametroRealizaInventario_Metadata());
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(0).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetProdutoIngredienteObrigatorio_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetProdutoIngredienteObrigatorio_Metadata()
		{
			if (TSvrMethod_GetProdutoIngredienteObrigatorio_Metadata == null)
			{
				TSvrMethod_GetProdutoIngredienteObrigatorio_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("codprod", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("codpes", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetProdutoIngredienteObrigatorio_Metadata;
		}

		/**
		 * @param codprod
		 *            [in] - Type on server: string
		 * @param codpes
		 *            [in] - Type on server: string
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetProdutoIngredienteObrigatorio(String codprod, String codpes)
				throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetProdutoIngredienteObrigatorio");
			cmd.prepare(get_TSvrMethod_GetProdutoIngredienteObrigatorio_Metadata());
			cmd.getParameter(0).getValue().SetAsString(codprod);
			cmd.getParameter(1).getValue().SetAsString(codpes);
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(2).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_printInventario_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_printInventario_Metadata()
		{
			if (TSvrMethod_printInventario_Metadata == null)
			{
				TSvrMethod_printInventario_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_printInventario_Metadata;
		}

		/**
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader printInventario() throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.printInventario");
			cmd.prepare(get_TSvrMethod_printInventario_Metadata());
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(0).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetQuantidadeSubGrupos_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetQuantidadeSubGrupos_Metadata()
		{
			if (TSvrMethod_GetQuantidadeSubGrupos_Metadata == null)
			{
				TSvrMethod_GetQuantidadeSubGrupos_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetQuantidadeSubGrupos_Metadata;
		}

		/**
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetQuantidadeSubGrupos() throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetQuantidadeSubGrupos");
			cmd.prepare(get_TSvrMethod_GetQuantidadeSubGrupos_Metadata());
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(0).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_printTabelaDetalhes_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_printTabelaDetalhes_Metadata()
		{
			if (TSvrMethod_printTabelaDetalhes_Metadata == null)
			{
				TSvrMethod_printTabelaDetalhes_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_printTabelaDetalhes_Metadata;
		}

		/**
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader printTabelaDetalhes() throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.printTabelaDetalhes");
			cmd.prepare(get_TSvrMethod_printTabelaDetalhes_Metadata());
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(0).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetCombosGrupo_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetCombosGrupo_Metadata()
		{
			if (TSvrMethod_GetCombosGrupo_Metadata == null)
			{
				TSvrMethod_GetCombosGrupo_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetCombosGrupo_Metadata;
		}

		/**
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetCombosGrupo() throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetCombosGrupo");
			cmd.prepare(get_TSvrMethod_GetCombosGrupo_Metadata());
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(0).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetItensCombo_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetItensCombo_Metadata()
		{
			if (TSvrMethod_GetItensCombo_Metadata == null)
			{
				TSvrMethod_GetItensCombo_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetItensCombo_Metadata;
		}

		/**
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetItensCombo() throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetItensCombo");
			cmd.prepare(get_TSvrMethod_GetItensCombo_Metadata());
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(0).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetComboProdutos_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetComboProdutos_Metadata()
		{
			if (TSvrMethod_GetComboProdutos_Metadata == null)
			{
				TSvrMethod_GetComboProdutos_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetComboProdutos_Metadata;
		}

		/**
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetComboProdutos() throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetComboProdutos");
			cmd.prepare(get_TSvrMethod_GetComboProdutos_Metadata());
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(0).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetComboGrupos_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetComboGrupos_Metadata()
		{
			if (TSvrMethod_GetComboGrupos_Metadata == null)
			{
				TSvrMethod_GetComboGrupos_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetComboGrupos_Metadata;
		}

		/**
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetComboGrupos() throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetComboGrupos");
			cmd.prepare(get_TSvrMethod_GetComboGrupos_Metadata());
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(0).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetGrupoPorID_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetGrupoPorID_Metadata()
		{
			if (TSvrMethod_GetGrupoPorID_Metadata == null)
			{
				TSvrMethod_GetGrupoPorID_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("codigo_grupo", DSRESTParamDirection.Input,
								DBXDataTypes.Int32Type, "Integer"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetGrupoPorID_Metadata;
		}

		/**
		 * @param codigo_grupo
		 *            [in] - Type on server: Integer
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetGrupoPorID(int codigo_grupo) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetGrupoPorID");
			cmd.prepare(get_TSvrMethod_GetGrupoPorID_Metadata());
			cmd.getParameter(0).getValue().SetAsInt32(codigo_grupo);
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(1).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetComboGrupo_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetComboGrupo_Metadata()
		{
			if (TSvrMethod_GetComboGrupo_Metadata == null)
			{
				TSvrMethod_GetComboGrupo_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("codigo_grupo", DSRESTParamDirection.Input,
								DBXDataTypes.Int32Type, "Integer"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetComboGrupo_Metadata;
		}

		/**
		 * @param codigo_grupo
		 *            [in] - Type on server: Integer
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetComboGrupo(int codigo_grupo) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetComboGrupo");
			cmd.prepare(get_TSvrMethod_GetComboGrupo_Metadata());
			cmd.getParameter(0).getValue().SetAsInt32(codigo_grupo);
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(1).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetComboPorProduto_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetComboPorProduto_Metadata()
		{
			if (TSvrMethod_GetComboPorProduto_Metadata == null)
			{
				TSvrMethod_GetComboPorProduto_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("codigo_produto", DSRESTParamDirection.Input,
								DBXDataTypes.Int32Type, "Integer"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetComboPorProduto_Metadata;
		}

		/**
		 * @param codigo_produto
		 *            [in] - Type on server: Integer
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetComboPorProduto(int codigo_produto) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetComboPorProduto");
			cmd.prepare(get_TSvrMethod_GetComboPorProduto_Metadata());
			cmd.getParameter(0).getValue().SetAsInt32(codigo_produto);
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(1).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetTodosProdutosPorSubgrupo_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetTodosProdutosPorSubgrupo_Metadata()
		{
			if (TSvrMethod_GetTodosProdutosPorSubgrupo_Metadata == null)
			{
				TSvrMethod_GetTodosProdutosPorSubgrupo_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetTodosProdutosPorSubgrupo_Metadata;
		}

		/**
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetTodosProdutosPorSubgrupo() throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetTodosProdutosPorSubgrupo");
			cmd.prepare(get_TSvrMethod_GetTodosProdutosPorSubgrupo_Metadata());
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(0).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetUltimoSeqItem_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetUltimoSeqItem_Metadata()
		{
			if (TSvrMethod_GetUltimoSeqItem_Metadata == null)
			{
				TSvrMethod_GetUltimoSeqItem_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("comanda", DSRESTParamDirection.Input,
								DBXDataTypes.Int32Type, "Integer"),
						new DSRESTParameterMetaData("cod_produto", DSRESTParamDirection.Input,
								DBXDataTypes.Int32Type, "Integer"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetUltimoSeqItem_Metadata;
		}

		/**
		 * @param comanda
		 *            [in] - Type on server: Integer
		 * @param cod_produto
		 *            [in] - Type on server: Integer
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetUltimoSeqItem(int comanda, int cod_produto) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetUltimoSeqItem");
			cmd.prepare(get_TSvrMethod_GetUltimoSeqItem_Metadata());
			cmd.getParameter(0).getValue().SetAsInt32(comanda);
			cmd.getParameter(1).getValue().SetAsInt32(cod_produto);
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(2).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetEventosAtivos_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetEventosAtivos_Metadata()
		{
			if (TSvrMethod_GetEventosAtivos_Metadata == null)
			{
				TSvrMethod_GetEventosAtivos_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetEventosAtivos_Metadata;
		}

		/**
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetEventosAtivos() throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetEventosAtivos");
			cmd.prepare(get_TSvrMethod_GetEventosAtivos_Metadata());
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(0).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetProdutoValorEvento_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetProdutoValorEvento_Metadata()
		{
			if (TSvrMethod_GetProdutoValorEvento_Metadata == null)
			{
				TSvrMethod_GetProdutoValorEvento_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("id_evento", DSRESTParamDirection.Input,
								DBXDataTypes.Int32Type, "Integer"),
						new DSRESTParameterMetaData("codprod", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.CurrencyType, "Currency"), };
			}
			return TSvrMethod_GetProdutoValorEvento_Metadata;
		}

		/**
		 * @param id_evento
		 *            [in] - Type on server: Integer
		 * @param codprod
		 *            [in] - Type on server: string
		 * @return result - Type on server: Currency
		 */
		public double GetProdutoValorEvento(int id_evento, String codprod) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetProdutoValorEvento");
			cmd.prepare(get_TSvrMethod_GetProdutoValorEvento_Metadata());
			cmd.getParameter(0).getValue().SetAsInt32(id_evento);
			cmd.getParameter(1).getValue().SetAsString(codprod);
			getConnection().execute(cmd);
			return cmd.getParameter(2).getValue().GetAsCurrency();
		}

		private DSRESTParameterMetaData[] TSvrMethod_ExecuteQuery_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_ExecuteQuery_Metadata()
		{
			if (TSvrMethod_ExecuteQuery_Metadata == null)
			{
				TSvrMethod_ExecuteQuery_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("query", DSRESTParamDirection.Input,
								DBXDataTypes.JsonValueType, "TJSONObject"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_ExecuteQuery_Metadata;
		}

		/**
		 * @param query
		 *            [in] - Type on server: TJSONObject
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader ExecuteQuery(TJSONObject query) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.POST);
			cmd.setText("TSvrMethod.ExecuteQuery");
			cmd.prepare(get_TSvrMethod_ExecuteQuery_Metadata());
			cmd.getParameter(0).getValue().SetAsJSONValue(query);
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(1).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_ExecuteInsert_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_ExecuteInsert_Metadata()
		{
			if (TSvrMethod_ExecuteInsert_Metadata == null)
			{
				TSvrMethod_ExecuteInsert_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("command", DSRESTParamDirection.Input,
								DBXDataTypes.JsonValueType, "TJSONObject"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.WideStringType, "string"), };
			}
			return TSvrMethod_ExecuteInsert_Metadata;
		}

		/**
		 * @param command
		 *            [in] - Type on server: TJSONObject
		 * @return result - Type on server: string
		 */
		public String ExecuteInsert(TJSONObject command) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.POST);
			cmd.setText("TSvrMethod.ExecuteInsert");
			cmd.prepare(get_TSvrMethod_ExecuteInsert_Metadata());
			cmd.getParameter(0).getValue().SetAsJSONValue(command);
			getConnection().execute(cmd);
			return cmd.getParameter(1).getValue().GetAsString();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetParamSistema_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetParamSistema_Metadata()
		{
			if (TSvrMethod_GetParamSistema_Metadata == null)
			{
				TSvrMethod_GetParamSistema_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetParamSistema_Metadata;
		}

		/**
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetParamSistema() throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetParamSistema");
			cmd.prepare(get_TSvrMethod_GetParamSistema_Metadata());
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(0).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetParamSistemaNovo_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetParamSistemaNovo_Metadata()
		{
			if (TSvrMethod_GetParamSistemaNovo_Metadata == null)
			{
				TSvrMethod_GetParamSistemaNovo_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetParamSistemaNovo_Metadata;
		}

		/**
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetParamSistemaNovo() throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetParamSistemaNovo");
			cmd.prepare(get_TSvrMethod_GetParamSistemaNovo_Metadata());
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(0).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetUsuarioSenha_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetUsuarioSenha_Metadata()
		{
			if (TSvrMethod_GetUsuarioSenha_Metadata == null)
			{
				TSvrMethod_GetUsuarioSenha_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("Usuario", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("Senha", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.WideStringType, "string"), };
			}
			return TSvrMethod_GetUsuarioSenha_Metadata;
		}

		/**
		 * @param Usuario
		 *            [in] - Type on server: string
		 * @param Senha
		 *            [in] - Type on server: string
		 * @return result - Type on server: string
		 */
		public String GetUsuarioSenha(String Usuario, String Senha) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetUsuarioSenha");
			cmd.prepare(get_TSvrMethod_GetUsuarioSenha_Metadata());
			cmd.getParameter(0).getValue().SetAsString(Usuario);
			cmd.getParameter(1).getValue().SetAsString(Senha);
			getConnection().execute(cmd);
			return cmd.getParameter(2).getValue().GetAsString();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetAberturaComanda_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetAberturaComanda_Metadata()
		{
			if (TSvrMethod_GetAberturaComanda_Metadata == null)
			{
				TSvrMethod_GetAberturaComanda_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pComanda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("Maioridade", DSRESTParamDirection.Output,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.BooleanType, "Boolean"), };
			}
			return TSvrMethod_GetAberturaComanda_Metadata;
		}

		/**
		 * @param pComanda
		 *            [in] - Type on server: string
		 * @param Maioridade
		 *            [out] - Type on server: string
		 * @return result - Type on server: Boolean
		 */
		public static class GetAberturaComandaReturns
		{
			public String Maioridade;
			public boolean returnValue;
		}

		public GetAberturaComandaReturns GetAberturaComanda(String pComanda) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetAberturaComanda");
			cmd.prepare(get_TSvrMethod_GetAberturaComanda_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pComanda);
			getConnection().execute(cmd);
			GetAberturaComandaReturns ret = new GetAberturaComandaReturns();
			ret.Maioridade = cmd.getParameter(1).getValue().GetAsString();
			ret.returnValue = cmd.getParameter(2).getValue().GetAsBoolean();
			return ret;
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetAbreFechaCaixa_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetAbreFechaCaixa_Metadata()
		{
			if (TSvrMethod_GetAbreFechaCaixa_Metadata == null)
			{
				TSvrMethod_GetAbreFechaCaixa_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.BooleanType, "Boolean"), };
			}
			return TSvrMethod_GetAbreFechaCaixa_Metadata;
		}

		/**
		 * @return result - Type on server: Boolean
		 */
		public boolean GetAbreFechaCaixa() throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetAbreFechaCaixa");
			cmd.prepare(get_TSvrMethod_GetAbreFechaCaixa_Metadata());
			getConnection().execute(cmd);
			return cmd.getParameter(0).getValue().GetAsBoolean();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetBloqueioComanda_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetBloqueioComanda_Metadata()
		{
			if (TSvrMethod_GetBloqueioComanda_Metadata == null)
			{
				TSvrMethod_GetBloqueioComanda_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pComanda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.BooleanType, "Boolean"), };
			}
			return TSvrMethod_GetBloqueioComanda_Metadata;
		}

		/**
		 * @param pComanda
		 *            [in] - Type on server: string
		 * @return result - Type on server: Boolean
		 */
		public boolean GetBloqueioComanda(String pComanda) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetBloqueioComanda");
			cmd.prepare(get_TSvrMethod_GetBloqueioComanda_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pComanda);
			getConnection().execute(cmd);
			return cmd.getParameter(1).getValue().GetAsBoolean();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetBloqueioComandaFechada_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetBloqueioComandaFechada_Metadata()
		{
			if (TSvrMethod_GetBloqueioComandaFechada_Metadata == null)
			{
				TSvrMethod_GetBloqueioComandaFechada_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pComanda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.BooleanType, "Boolean"), };
			}
			return TSvrMethod_GetBloqueioComandaFechada_Metadata;
		}

		/**
		 * @param pComanda
		 *            [in] - Type on server: string
		 * @return result - Type on server: Boolean
		 */
		public boolean GetBloqueioComandaFechada(String pComanda) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetBloqueioComandaFechada");
			cmd.prepare(get_TSvrMethod_GetBloqueioComandaFechada_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pComanda);
			getConnection().execute(cmd);
			return cmd.getParameter(1).getValue().GetAsBoolean();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetCodigoClienteComanda_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetCodigoClienteComanda_Metadata()
		{
			if (TSvrMethod_GetCodigoClienteComanda_Metadata == null)
			{
				TSvrMethod_GetCodigoClienteComanda_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pComanda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.BooleanType, "Boolean"), };
			}
			return TSvrMethod_GetCodigoClienteComanda_Metadata;
		}

		/**
		 * @param pComanda
		 *            [in] - Type on server: string
		 * @return result - Type on server: Boolean
		 */
		public boolean GetCodigoClienteComanda(String pComanda) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetCodigoClienteComanda");
			cmd.prepare(get_TSvrMethod_GetCodigoClienteComanda_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pComanda);
			getConnection().execute(cmd);
			return cmd.getParameter(1).getValue().GetAsBoolean();
		}

		private DSRESTParameterMetaData[] TSvrMethod_UpdateUsuLogado_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_UpdateUsuLogado_Metadata()
		{
			if (TSvrMethod_UpdateUsuLogado_Metadata == null)
			{
				TSvrMethod_UpdateUsuLogado_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("codigo", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("status", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.BooleanType, "Boolean"), };
			}
			return TSvrMethod_UpdateUsuLogado_Metadata;
		}

		/**
		 * @param codigo
		 *            [in] - Type on server: string
		 * @param status
		 *            [in] - Type on server: string
		 * @return result - Type on server: Boolean
		 */
		public boolean UpdateUsuLogado(String codigo, String status) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.UpdateUsuLogado");
			cmd.prepare(get_TSvrMethod_UpdateUsuLogado_Metadata());
			cmd.getParameter(0).getValue().SetAsString(codigo);
			cmd.getParameter(1).getValue().SetAsString(status);
			getConnection().execute(cmd);
			return cmd.getParameter(2).getValue().GetAsBoolean();
		}

		private DSRESTParameterMetaData[] TSvrMethod_VerificaCaixaAberto_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_VerificaCaixaAberto_Metadata()
		{
			if (TSvrMethod_VerificaCaixaAberto_Metadata == null)
			{
				TSvrMethod_VerificaCaixaAberto_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("Value", DSRESTParamDirection.Input,
								DBXDataTypes.JsonValueType, "TJSONObject"),
						new DSRESTParameterMetaData("sMensagem", DSRESTParamDirection.Output,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.WideStringType, "string"), };
			}
			return TSvrMethod_VerificaCaixaAberto_Metadata;
		}

		/**
		 * @param Value
		 *            [in] - Type on server: TJSONObject
		 * @param sMensagem
		 *            [out] - Type on server: string
		 * @return result - Type on server: string
		 */
		public static class VerificaCaixaAbertoReturns
		{
			public String sMensagem;
			public String returnValue;
		}

		public VerificaCaixaAbertoReturns VerificaCaixaAberto(TJSONObject Value) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.POST);
			cmd.setText("TSvrMethod.VerificaCaixaAberto");
			cmd.prepare(get_TSvrMethod_VerificaCaixaAberto_Metadata());
			cmd.getParameter(0).getValue().SetAsJSONValue(Value);
			getConnection().execute(cmd);
			VerificaCaixaAbertoReturns ret = new VerificaCaixaAbertoReturns();
			ret.sMensagem = cmd.getParameter(1).getValue().GetAsString();
			ret.returnValue = cmd.getParameter(2).getValue().GetAsString();
			return ret;
		}

		private DSRESTParameterMetaData[] TSvrMethod_ImprimeAberturaCx_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_ImprimeAberturaCx_Metadata()
		{
			if (TSvrMethod_ImprimeAberturaCx_Metadata == null)
			{
				TSvrMethod_ImprimeAberturaCx_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("codCaixa", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("valIniCaixa", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("codFunc", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("obs", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.BooleanType, "Boolean"), };
			}
			return TSvrMethod_ImprimeAberturaCx_Metadata;
		}

		/**
		 * @param codCaixa
		 *            [in] - Type on server: string
		 * @param valIniCaixa
		 *            [in] - Type on server: string
		 * @param codFunc
		 *            [in] - Type on server: string
		 * @param obs
		 *            [in] - Type on server: string
		 * @return result - Type on server: Boolean
		 */
		public boolean ImprimeAberturaCx(String codCaixa, String valIniCaixa, String codFunc,
				String obs) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.ImprimeAberturaCx");
			cmd.prepare(get_TSvrMethod_ImprimeAberturaCx_Metadata());
			cmd.getParameter(0).getValue().SetAsString(codCaixa);
			cmd.getParameter(1).getValue().SetAsString(valIniCaixa);
			cmd.getParameter(2).getValue().SetAsString(codFunc);
			cmd.getParameter(3).getValue().SetAsString(obs);
			getConnection().execute(cmd);
			return cmd.getParameter(4).getValue().GetAsBoolean();
		}

		private DSRESTParameterMetaData[] TSvrMethod_AddSpace_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_AddSpace_Metadata()
		{
			if (TSvrMethod_AddSpace_Metadata == null)
			{
				TSvrMethod_AddSpace_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("S", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("Qtd", DSRESTParamDirection.Input,
								DBXDataTypes.Int32Type, "Integer"),
						new DSRESTParameterMetaData("Aling", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.WideStringType, "string"), };
			}
			return TSvrMethod_AddSpace_Metadata;
		}

		/**
		 * @param S
		 *            [in] - Type on server: string
		 * @param Qtd
		 *            [in] - Type on server: Integer
		 * @param Aling
		 *            [in] - Type on server: string
		 * @return result - Type on server: string
		 */
		public String AddSpace(String S, int Qtd, String Aling) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.AddSpace");
			cmd.prepare(get_TSvrMethod_AddSpace_Metadata());
			cmd.getParameter(0).getValue().SetAsString(S);
			cmd.getParameter(1).getValue().SetAsInt32(Qtd);
			cmd.getParameter(2).getValue().SetAsString(Aling);
			getConnection().execute(cmd);
			return cmd.getParameter(3).getValue().GetAsString();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetNumCaixaFunc_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetNumCaixaFunc_Metadata()
		{
			if (TSvrMethod_GetNumCaixaFunc_Metadata == null)
			{
				TSvrMethod_GetNumCaixaFunc_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("Codigo", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.WideStringType, "string"), };
			}
			return TSvrMethod_GetNumCaixaFunc_Metadata;
		}

		/**
		 * @param Codigo
		 *            [in] - Type on server: string
		 * @return result - Type on server: string
		 */
		public String GetNumCaixaFunc(String Codigo) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetNumCaixaFunc");
			cmd.prepare(get_TSvrMethod_GetNumCaixaFunc_Metadata());
			cmd.getParameter(0).getValue().SetAsString(Codigo);
			getConnection().execute(cmd);
			return cmd.getParameter(1).getValue().GetAsString();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetSangria_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetSangria_Metadata()
		{
			if (TSvrMethod_GetSangria_Metadata == null)
			{
				TSvrMethod_GetSangria_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("Value", DSRESTParamDirection.Input,
								DBXDataTypes.JsonValueType, "TJSONObject"),
						new DSRESTParameterMetaData("sMensagem", DSRESTParamDirection.Output,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.WideStringType, "string"), };
			}
			return TSvrMethod_GetSangria_Metadata;
		}

		/**
		 * @param Value
		 *            [in] - Type on server: TJSONObject
		 * @param sMensagem
		 *            [out] - Type on server: string
		 * @return result - Type on server: string
		 */
		public static class GetSangriaReturns
		{
			public String sMensagem;
			public String returnValue;
		}

		public GetSangriaReturns GetSangria(TJSONObject Value) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.POST);
			cmd.setText("TSvrMethod.GetSangria");
			cmd.prepare(get_TSvrMethod_GetSangria_Metadata());
			cmd.getParameter(0).getValue().SetAsJSONValue(Value);
			getConnection().execute(cmd);
			GetSangriaReturns ret = new GetSangriaReturns();
			ret.sMensagem = cmd.getParameter(1).getValue().GetAsString();
			ret.returnValue = cmd.getParameter(2).getValue().GetAsString();
			return ret;
		}

		private DSRESTParameterMetaData[] TSvrMethod_ImprimeSangria_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_ImprimeSangria_Metadata()
		{
			if (TSvrMethod_ImprimeSangria_Metadata == null)
			{
				TSvrMethod_ImprimeSangria_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("codCaixa", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("valor", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("codFunc", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("obs", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.BooleanType, "Boolean"), };
			}
			return TSvrMethod_ImprimeSangria_Metadata;
		}

		/**
		 * @param codCaixa
		 *            [in] - Type on server: string
		 * @param valor
		 *            [in] - Type on server: string
		 * @param codFunc
		 *            [in] - Type on server: string
		 * @param obs
		 *            [in] - Type on server: string
		 * @return result - Type on server: Boolean
		 */
		public boolean ImprimeSangria(String codCaixa, String valor, String codFunc, String obs)
				throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.ImprimeSangria");
			cmd.prepare(get_TSvrMethod_ImprimeSangria_Metadata());
			cmd.getParameter(0).getValue().SetAsString(codCaixa);
			cmd.getParameter(1).getValue().SetAsString(valor);
			cmd.getParameter(2).getValue().SetAsString(codFunc);
			cmd.getParameter(3).getValue().SetAsString(obs);
			getConnection().execute(cmd);
			return cmd.getParameter(4).getValue().GetAsBoolean();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetSuprimento_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetSuprimento_Metadata()
		{
			if (TSvrMethod_GetSuprimento_Metadata == null)
			{
				TSvrMethod_GetSuprimento_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("Value", DSRESTParamDirection.Input,
								DBXDataTypes.JsonValueType, "TJSONObject"),
						new DSRESTParameterMetaData("sMensagem", DSRESTParamDirection.Output,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.WideStringType, "string"), };
			}
			return TSvrMethod_GetSuprimento_Metadata;
		}

		/**
		 * @param Value
		 *            [in] - Type on server: TJSONObject
		 * @param sMensagem
		 *            [out] - Type on server: string
		 * @return result - Type on server: string
		 */
		public static class GetSuprimentoReturns
		{
			public String sMensagem;
			public String returnValue;
		}

		public GetSuprimentoReturns GetSuprimento(TJSONObject Value) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.POST);
			cmd.setText("TSvrMethod.GetSuprimento");
			cmd.prepare(get_TSvrMethod_GetSuprimento_Metadata());
			cmd.getParameter(0).getValue().SetAsJSONValue(Value);
			getConnection().execute(cmd);
			GetSuprimentoReturns ret = new GetSuprimentoReturns();
			ret.sMensagem = cmd.getParameter(1).getValue().GetAsString();
			ret.returnValue = cmd.getParameter(2).getValue().GetAsString();
			return ret;
		}

		private DSRESTParameterMetaData[] TSvrMethod_ImprimeSuprimento_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_ImprimeSuprimento_Metadata()
		{
			if (TSvrMethod_ImprimeSuprimento_Metadata == null)
			{
				TSvrMethod_ImprimeSuprimento_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("codCaixa", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("valor", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("codFunc", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("obs", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.BooleanType, "Boolean"), };
			}
			return TSvrMethod_ImprimeSuprimento_Metadata;
		}

		/**
		 * @param codCaixa
		 *            [in] - Type on server: string
		 * @param valor
		 *            [in] - Type on server: string
		 * @param codFunc
		 *            [in] - Type on server: string
		 * @param obs
		 *            [in] - Type on server: string
		 * @return result - Type on server: Boolean
		 */
		public boolean ImprimeSuprimento(String codCaixa, String valor, String codFunc, String obs)
				throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.ImprimeSuprimento");
			cmd.prepare(get_TSvrMethod_ImprimeSuprimento_Metadata());
			cmd.getParameter(0).getValue().SetAsString(codCaixa);
			cmd.getParameter(1).getValue().SetAsString(valor);
			cmd.getParameter(2).getValue().SetAsString(codFunc);
			cmd.getParameter(3).getValue().SetAsString(obs);
			getConnection().execute(cmd);
			return cmd.getParameter(4).getValue().GetAsBoolean();
		}

		private DSRESTParameterMetaData[] TSvrMethod_Transferir_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_Transferir_Metadata()
		{
			if (TSvrMethod_Transferir_Metadata == null)
			{
				TSvrMethod_Transferir_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("Value", DSRESTParamDirection.Input,
								DBXDataTypes.JsonValueType, "TJSONObject"),
						new DSRESTParameterMetaData("origem", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("destino", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("sMensagem", DSRESTParamDirection.Output,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.WideStringType, "string"), };
			}
			return TSvrMethod_Transferir_Metadata;
		}

		/**
		 * @param Value
		 *            [in] - Type on server: TJSONObject
		 * @param origem
		 *            [in] - Type on server: string
		 * @param destino
		 *            [in] - Type on server: string
		 * @param sMensagem
		 *            [out] - Type on server: string
		 * @return result - Type on server: string
		 */
		public static class TransferirReturns
		{
			public String sMensagem;
			public String returnValue;
		}

		public TransferirReturns Transferir(TJSONObject Value, String origem, String destino)
				throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.POST);
			cmd.setText("TSvrMethod.Transferir");
			cmd.prepare(get_TSvrMethod_Transferir_Metadata());
			cmd.getParameter(0).getValue().SetAsJSONValue(Value);
			cmd.getParameter(1).getValue().SetAsString(origem);
			cmd.getParameter(2).getValue().SetAsString(destino);
			getConnection().execute(cmd);
			TransferirReturns ret = new TransferirReturns();
			ret.sMensagem = cmd.getParameter(3).getValue().GetAsString();
			ret.returnValue = cmd.getParameter(4).getValue().GetAsString();
			return ret;
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetComandaTransf_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetComandaTransf_Metadata()
		{
			if (TSvrMethod_GetComandaTransf_Metadata == null)
			{
				TSvrMethod_GetComandaTransf_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pComanda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetComandaTransf_Metadata;
		}

		/**
		 * @param pComanda
		 *            [in] - Type on server: string
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetComandaTransf(String pComanda) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetComandaTransf");
			cmd.prepare(get_TSvrMethod_GetComandaTransf_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pComanda);
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(1).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_ValidaComandaAberta_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_ValidaComandaAberta_Metadata()
		{
			if (TSvrMethod_ValidaComandaAberta_Metadata == null)
			{
				TSvrMethod_ValidaComandaAberta_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pComanda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.BooleanType, "Boolean"), };
			}
			return TSvrMethod_ValidaComandaAberta_Metadata;
		}

		/**
		 * @param pComanda
		 *            [in] - Type on server: string
		 * @return result - Type on server: Boolean
		 */
		public boolean ValidaComandaAberta(String pComanda) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.ValidaComandaAberta");
			cmd.prepare(get_TSvrMethod_ValidaComandaAberta_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pComanda);
			getConnection().execute(cmd);
			return cmd.getParameter(1).getValue().GetAsBoolean();
		}

		private DSRESTParameterMetaData[] TSvrMethod_InsertComandaTransferencia_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_InsertComandaTransferencia_Metadata()
		{
			if (TSvrMethod_InsertComandaTransferencia_Metadata == null)
			{
				TSvrMethod_InsertComandaTransferencia_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pComanda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.BooleanType, "Boolean"), };
			}
			return TSvrMethod_InsertComandaTransferencia_Metadata;
		}

		/**
		 * @param pComanda
		 *            [in] - Type on server: string
		 * @return result - Type on server: Boolean
		 */
		public boolean InsertComandaTransferencia(String pComanda) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.InsertComandaTransferencia");
			cmd.prepare(get_TSvrMethod_InsertComandaTransferencia_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pComanda);
			getConnection().execute(cmd);
			return cmd.getParameter(1).getValue().GetAsBoolean();
		}

		private DSRESTParameterMetaData[] TSvrMethod_Pagamento_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_Pagamento_Metadata()
		{
			if (TSvrMethod_Pagamento_Metadata == null)
			{
				TSvrMethod_Pagamento_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("Value", DSRESTParamDirection.Input,
								DBXDataTypes.JsonValueType, "TJSONObject"),
						new DSRESTParameterMetaData("sMensagem", DSRESTParamDirection.Output,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("sXmlCupom", DSRESTParamDirection.Output,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.WideStringType, "string"), };
			}
			return TSvrMethod_Pagamento_Metadata;
		}

		/**
		 * @param Value
		 *            [in] - Type on server: TJSONObject
		 * @param sMensagem
		 *            [out] - Type on server: string
		 * @return result - Type on server: string
		 */
		public static class PagamentoReturns
		{
			public String sMensagem;
			public String sXmlCupom;
			public String returnValue;
		}

		public PagamentoReturns Pagamento(TJSONObject Value) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.POST);
			cmd.setText("TSvrMethod.Pagamento");
			cmd.prepare(get_TSvrMethod_Pagamento_Metadata());
			cmd.getParameter(0).getValue().SetAsJSONValue(Value);
			getConnection().execute(cmd);
			PagamentoReturns ret = new PagamentoReturns();
			ret.sMensagem = cmd.getParameter(1).getValue().GetAsString();
			ret.sXmlCupom = cmd.getParameter(2).getValue().GetAsString();
			ret.returnValue = cmd.getParameter(3).getValue().GetAsString();
			return ret;
		}

		private DSRESTParameterMetaData[] TSvrMethod_Envia_Cupom_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_Envia_Cupom_Metadata() {
			if (TSvrMethod_Envia_Cupom_Metadata == null)
			{
				TSvrMethod_Envia_Cupom_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("cpfCnpj", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("idVenda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
				};
			}
			return TSvrMethod_Envia_Cupom_Metadata;
		}

		public CupomFiscal Envia_Cupom(TJSONObject Value) throws DBXException {
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.POST);
			cmd.setText("TSvrMethod.{FUNCAO_CUPOM}");
			cmd.prepare(get_TSvrMethod_Envia_Cupom_Metadata());
			cmd.getParameter(0).getValue().SetAsJSONValue(Value);
			getConnection().execute(cmd);
			PagamentoReturns ret = new PagamentoReturns();
			ret.sMensagem = cmd.getParameter(1).getValue().GetAsString();
			ret.returnValue = cmd.getParameter(2).getValue().GetAsString();
			return null;
		}

		private DSRESTParameterMetaData[] TSvrMethod_Baixa_Comanda_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_Baixa_Comanda_Metadata()
		{
			if (TSvrMethod_Baixa_Comanda_Metadata == null)
			{
				TSvrMethod_Baixa_Comanda_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("comanda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("idCaixa", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.BooleanType, "Boolean"), };
			}
			return TSvrMethod_Baixa_Comanda_Metadata;
		}

		/**
		 * @param comanda
		 *            [in] - Type on server: string
		 * @param idCaixa
		 *            [in] - Type on server: string
		 * @return result - Type on server: Boolean
		 */
		public boolean Baixa_Comanda(String comanda, String idCaixa) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.Baixa_Comanda");
			cmd.prepare(get_TSvrMethod_Baixa_Comanda_Metadata());
			cmd.getParameter(0).getValue().SetAsString(comanda);
			cmd.getParameter(1).getValue().SetAsString(idCaixa);
			getConnection().execute(cmd);
			return cmd.getParameter(2).getValue().GetAsBoolean();
		}

		private DSRESTParameterMetaData[] TSvrMethod_ImprimeCupom_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_ImprimeCupom_Metadata()
		{
			if (TSvrMethod_ImprimeCupom_Metadata == null)
			{
				TSvrMethod_ImprimeCupom_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("cpfCnpj", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("idVenda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("tipoPedid", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("codCaixa", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.BooleanType, "Boolean"), };
			}
			return TSvrMethod_ImprimeCupom_Metadata;
		}

		/**
		 * @param cpfCnpj
		 *            [in] - Type on server: string
		 * @param idVenda
		 *            [in] - Type on server: string
		 * @param tipoPedid
		 *            [in] - Type on server: string
		 * @param codCaixa
		 *            [in] - Type on server: string
		 * @return result - Type on server: Boolean
		 */
		public boolean ImprimeCupom(String cpfCnpj, String idVenda, String tipoPedid,
				String codCaixa) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.ImprimeCupom");
			cmd.prepare(get_TSvrMethod_ImprimeCupom_Metadata());
			cmd.getParameter(0).getValue().SetAsString(cpfCnpj);
			cmd.getParameter(1).getValue().SetAsString(idVenda);
			cmd.getParameter(2).getValue().SetAsString(tipoPedid);
			cmd.getParameter(3).getValue().SetAsString(codCaixa);
			getConnection().execute(cmd);
			return cmd.getParameter(4).getValue().GetAsBoolean();
		}

		private DSRESTParameterMetaData[] TSvrMethod_ValidaCaixaAberto_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_ValidaCaixaAberto_Metadata()
		{
			if (TSvrMethod_ValidaCaixaAberto_Metadata == null)
			{
				TSvrMethod_ValidaCaixaAberto_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pCodUsu", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.BooleanType, "Boolean"), };
			}
			return TSvrMethod_ValidaCaixaAberto_Metadata;
		}

		/**
		 * @param pCodUsu
		 *            [in] - Type on server: string
		 * @return result - Type on server: Boolean
		 */
		public boolean ValidaCaixaAberto(String pCodUsu) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.ValidaCaixaAberto");
			cmd.prepare(get_TSvrMethod_ValidaCaixaAberto_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pCodUsu);
			getConnection().execute(cmd);
			return cmd.getParameter(1).getValue().GetAsBoolean();
		}

		private DSRESTParameterMetaData[] TSvrMethod_TransfereMesa_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_TransfereMesa_Metadata()
		{
			if (TSvrMethod_TransfereMesa_Metadata == null)
			{
				TSvrMethod_TransfereMesa_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pComanda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pComandaAntiga", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.BooleanType, "Boolean"), };
			}
			return TSvrMethod_TransfereMesa_Metadata;
		}

		/**
		 * @param pComanda
		 *            [in] - Type on server: string
		 * @param pComandaAntiga
		 *            [in] - Type on server: string
		 * @return result - Type on server: Boolean
		 */
		public boolean TransfereMesa(String pComanda, String pComandaAntiga) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.TransfereMesa");
			cmd.prepare(get_TSvrMethod_TransfereMesa_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pComanda);
			cmd.getParameter(1).getValue().SetAsString(pComandaAntiga);
			getConnection().execute(cmd);
			return cmd.getParameter(2).getValue().GetAsBoolean();
		}

		private DSRESTParameterMetaData[] TSvrMethod_ValidaTransMesa_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_ValidaTransMesa_Metadata()
		{
			if (TSvrMethod_ValidaTransMesa_Metadata == null)
			{
				TSvrMethod_ValidaTransMesa_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pComanda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.BooleanType, "Boolean"), };
			}
			return TSvrMethod_ValidaTransMesa_Metadata;
		}

		/**
		 * @param pComanda
		 *            [in] - Type on server: string
		 * @return result - Type on server: Boolean
		 */
		public boolean ValidaTransMesa(String pComanda) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.ValidaTransMesa");
			cmd.prepare(get_TSvrMethod_ValidaTransMesa_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pComanda);
			getConnection().execute(cmd);
			return cmd.getParameter(1).getValue().GetAsBoolean();
		}

		private DSRESTParameterMetaData[] TSvrMethod_AprovaTransferenciaMesa_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_AprovaTransferenciaMesa_Metadata()
		{
			if (TSvrMethod_AprovaTransferenciaMesa_Metadata == null)
			{
				TSvrMethod_AprovaTransferenciaMesa_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pComanda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pQtdPessoas", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pMesa", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.WideStringType, "string"), };
			}
			return TSvrMethod_AprovaTransferenciaMesa_Metadata;
		}

		/**
		 * @param pComanda
		 *            [in] - Type on server: string
		 * @param pQtdPessoas
		 *            [in] - Type on server: string
		 * @param pMesa
		 *            [in] - Type on server: string
		 * @return result - Type on server: string
		 */
		public String AprovaTransferenciaMesa(String pComanda, String pQtdPessoas, String pMesa)
				throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.AprovaTransferenciaMesa");
			cmd.prepare(get_TSvrMethod_AprovaTransferenciaMesa_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pComanda);
			cmd.getParameter(1).getValue().SetAsString(pQtdPessoas);
			cmd.getParameter(2).getValue().SetAsString(pMesa);
			getConnection().execute(cmd);
			return cmd.getParameter(3).getValue().GetAsString();
		}

		private DSRESTParameterMetaData[] TSvrMethod_ValidaMesaLiberada_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_ValidaMesaLiberada_Metadata()
		{
			if (TSvrMethod_ValidaMesaLiberada_Metadata == null)
			{
				TSvrMethod_ValidaMesaLiberada_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pComanda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.BooleanType, "Boolean"), };
			}
			return TSvrMethod_ValidaMesaLiberada_Metadata;
		}

		/**
		 * @param pComanda
		 *            [in] - Type on server: string
		 * @return result - Type on server: Boolean
		 */
		public boolean ValidaMesaLiberada(String pComanda) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.ValidaMesaLiberada");
			cmd.prepare(get_TSvrMethod_ValidaMesaLiberada_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pComanda);
			getConnection().execute(cmd);
			return cmd.getParameter(1).getValue().GetAsBoolean();
		}

		private DSRESTParameterMetaData[] TSvrMethod_ValidaImprimeMesaEspera_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_ValidaImprimeMesaEspera_Metadata()
		{
			if (TSvrMethod_ValidaImprimeMesaEspera_Metadata == null)
			{
				TSvrMethod_ValidaImprimeMesaEspera_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.BooleanType, "Boolean"), };
			}
			return TSvrMethod_ValidaImprimeMesaEspera_Metadata;
		}

		/**
		 * @return result - Type on server: Boolean
		 */
		public boolean ValidaImprimeMesaEspera() throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.ValidaImprimeMesaEspera");
			cmd.prepare(get_TSvrMethod_ValidaImprimeMesaEspera_Metadata());
			getConnection().execute(cmd);
			return cmd.getParameter(0).getValue().GetAsBoolean();
		}

		private DSRESTParameterMetaData[] TSvrMethod_ImprimeFechamento_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_ImprimeFechamento_Metadata()
		{
			if (TSvrMethod_ImprimeFechamento_Metadata == null)
			{
				TSvrMethod_ImprimeFechamento_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pComanda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pQtdPessoas", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.BooleanType, "Boolean"), };
			}
			return TSvrMethod_ImprimeFechamento_Metadata;
		}

		/**
		 * @param pComanda
		 *            [in] - Type on server: string
		 * @param pQtdPessoas
		 *            [in] - Type on server: string
		 * @return result - Type on server: Boolean
		 */
		public boolean ImprimeFechamento(String pComanda, String pQtdPessoas) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.ImprimeFechamento");
			cmd.prepare(get_TSvrMethod_ImprimeFechamento_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pComanda);
			cmd.getParameter(1).getValue().SetAsString(pQtdPessoas);
			getConnection().execute(cmd);
			return cmd.getParameter(2).getValue().GetAsBoolean();
		}

		private DSRESTParameterMetaData[] TSvrMethod_InsertComandaTransferenciaMesa_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_InsertComandaTransferenciaMesa_Metadata()
		{
			if (TSvrMethod_InsertComandaTransferenciaMesa_Metadata == null)
			{
				TSvrMethod_InsertComandaTransferenciaMesa_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pComanda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pQtdPessoas", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pMesa", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.BooleanType, "Boolean"), };
			}
			return TSvrMethod_InsertComandaTransferenciaMesa_Metadata;
		}

		/**
		 * @param pComanda
		 *            [in] - Type on server: string
		 * @param pQtdPessoas
		 *            [in] - Type on server: string
		 * @param pMesa
		 *            [in] - Type on server: string
		 * @return result - Type on server: Boolean
		 */
		public boolean InsertComandaTransferenciaMesa(String pComanda, String pQtdPessoas,
				String pMesa) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.InsertComandaTransferenciaMesa");
			cmd.prepare(get_TSvrMethod_InsertComandaTransferenciaMesa_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pComanda);
			cmd.getParameter(1).getValue().SetAsString(pQtdPessoas);
			cmd.getParameter(2).getValue().SetAsString(pMesa);
			getConnection().execute(cmd);
			return cmd.getParameter(3).getValue().GetAsBoolean();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetSubGrupo_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetSubGrupo_Metadata()
		{
			if (TSvrMethod_GetSubGrupo_Metadata == null)
			{
				TSvrMethod_GetSubGrupo_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetSubGrupo_Metadata;
		}

		/**
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetSubGrupo() throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetSubGrupo");
			cmd.prepare(get_TSvrMethod_GetSubGrupo_Metadata());
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(0).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_TransfereComanda_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_TransfereComanda_Metadata()
		{
			if (TSvrMethod_TransfereComanda_Metadata == null)
			{
				TSvrMethod_TransfereComanda_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("pComanda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("pComandaNova", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("sMensagem", DSRESTParamDirection.Output,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.WideStringType, "string"), };
			}
			return TSvrMethod_TransfereComanda_Metadata;
		}

		/**
		 * @param pComanda
		 *            [in] - Type on server: string
		 * @param pComandaNova
		 *            [in] - Type on server: string
		 * @param sMensagem
		 *            [out] - Type on server: string
		 * @return result - Type on server: string
		 */
		public static class TransfereComandaReturns
		{
			public String sMensagem;
			public String returnValue;
		}

		public TransfereComandaReturns TransfereComanda(String pComanda, String pComandaNova)
				throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.TransfereComanda");
			cmd.prepare(get_TSvrMethod_TransfereComanda_Metadata());
			cmd.getParameter(0).getValue().SetAsString(pComanda);
			cmd.getParameter(1).getValue().SetAsString(pComandaNova);
			getConnection().execute(cmd);
			TransfereComandaReturns ret = new TransfereComandaReturns();
			ret.sMensagem = cmd.getParameter(2).getValue().GetAsString();
			ret.returnValue = cmd.getParameter(3).getValue().GetAsString();
			return ret;
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetSeqComandaFechamento_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetSeqComandaFechamento_Metadata()
		{
			if (TSvrMethod_GetSeqComandaFechamento_Metadata == null)
			{
				TSvrMethod_GetSeqComandaFechamento_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("comanda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.WideStringType, "string"), };
			}
			return TSvrMethod_GetSeqComandaFechamento_Metadata;
		}

		/**
		 * @param comanda
		 *            [in] - Type on server: string
		 * @return result - Type on server: string
		 */
		public String GetSeqComandaFechamento(String comanda) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetSeqComandaFechamento");
			cmd.prepare(get_TSvrMethod_GetSeqComandaFechamento_Metadata());
			cmd.getParameter(0).getValue().SetAsString(comanda);
			getConnection().execute(cmd);
			return cmd.getParameter(1).getValue().GetAsString();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetListaComandaFechamento_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetListaComandaFechamento_Metadata()
		{
			if (TSvrMethod_GetListaComandaFechamento_Metadata == null)
			{
				TSvrMethod_GetListaComandaFechamento_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("seq", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.WideStringType, "string"), };
			}
			return TSvrMethod_GetListaComandaFechamento_Metadata;
		}

		/**
		 * @param seq
		 *            [in] - Type on server: string
		 * @return result - Type on server: string
		 */
		public String GetListaComandaFechamento(String seq) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetListaComandaFechamento");
			cmd.prepare(get_TSvrMethod_GetListaComandaFechamento_Metadata());
			cmd.getParameter(0).getValue().SetAsString(seq);
			getConnection().execute(cmd);
			return cmd.getParameter(1).getValue().GetAsString();
		}

		private DSRESTParameterMetaData[] TSvrMethod_CancelaItemComanda_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_CancelaItemComanda_Metadata()
		{
			if (TSvrMethod_CancelaItemComanda_Metadata == null)
			{
				TSvrMethod_CancelaItemComanda_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("devolucao", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("codfunc", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("motivo", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("comanda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("Value", DSRESTParamDirection.Input,
								DBXDataTypes.JsonValueType, "TJSONObject"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.WideStringType, "string"), };
			}
			return TSvrMethod_CancelaItemComanda_Metadata;
		}

		/**
		 * @param devolucao
		 *            [in] - Type on server: string
		 * @param codfunc
		 *            [in] - Type on server: string
		 * @param motivo
		 *            [in] - Type on server: string
		 * @param comanda
		 *            [in] - Type on server: string
		 * @param Value
		 *            [in] - Type on server: TJSONObject
		 * @return result - Type on server: string
		 */
		public String CancelaItemComanda(String devolucao, String codfunc, String motivo,
				String comanda, TJSONObject Value) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.POST);
			cmd.setText("TSvrMethod.CancelaItemComanda");
			cmd.prepare(get_TSvrMethod_CancelaItemComanda_Metadata());
			cmd.getParameter(0).getValue().SetAsString(devolucao);
			cmd.getParameter(1).getValue().SetAsString(codfunc);
			cmd.getParameter(2).getValue().SetAsString(motivo);
			cmd.getParameter(3).getValue().SetAsString(comanda);
			cmd.getParameter(4).getValue().SetAsJSONValue(Value);
			getConnection().execute(cmd);
			return cmd.getParameter(5).getValue().GetAsString();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetComandaAberta_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetComandaAberta_Metadata()
		{
			if (TSvrMethod_GetComandaAberta_Metadata == null)
			{
				TSvrMethod_GetComandaAberta_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("sComanda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("sMesa", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetComandaAberta_Metadata;
		}

		/**
		 * @param sComanda
		 *            [in] - Type on server: string
		 * @param sMesa
		 *            [in] - Type on server: string
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetComandaAberta(String sComanda, String sMesa) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetComandaAberta");
			cmd.prepare(get_TSvrMethod_GetComandaAberta_Metadata());
			cmd.getParameter(0).getValue().SetAsString(sComanda);
			cmd.getParameter(1).getValue().SetAsString(sMesa);
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(2).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetComandaFechada_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetComandaFechada_Metadata()
		{
			if (TSvrMethod_GetComandaFechada_Metadata == null)
			{
				TSvrMethod_GetComandaFechada_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("sComanda", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetComandaFechada_Metadata;
		}

		/**
		 * @param sComanda
		 *            [in] - Type on server: string
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetComandaFechada(String sComanda) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetComandaFechada");
			cmd.prepare(get_TSvrMethod_GetComandaFechada_Metadata());
			cmd.getParameter(0).getValue().SetAsString(sComanda);
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(1).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetData_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetData_Metadata()
		{
			if (TSvrMethod_GetData_Metadata == null)
			{
				TSvrMethod_GetData_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.WideStringType, "string"), };
			}
			return TSvrMethod_GetData_Metadata;
		}

		/**
		 * @return result - Type on server: string
		 */
		public String GetData() throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetData");
			cmd.prepare(get_TSvrMethod_GetData_Metadata());
			getConnection().execute(cmd);
			return cmd.getParameter(0).getValue().GetAsString();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetHora_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetHora_Metadata()
		{
			if (TSvrMethod_GetHora_Metadata == null)
			{
				TSvrMethod_GetHora_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.WideStringType, "string"), };
			}
			return TSvrMethod_GetHora_Metadata;
		}

		/**
		 * @return result - Type on server: string
		 */
		public String GetHora() throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetHora");
			cmd.prepare(get_TSvrMethod_GetHora_Metadata());
			getConnection().execute(cmd);
			return cmd.getParameter(0).getValue().GetAsString();
		}

		private DSRESTParameterMetaData[] TSvrMethod_Strftocurr_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_Strftocurr_Metadata()
		{
			if (TSvrMethod_Strftocurr_Metadata == null)
			{
				TSvrMethod_Strftocurr_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("valor", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.CurrencyType, "Currency"), };
			}
			return TSvrMethod_Strftocurr_Metadata;
		}

		/**
		 * @param valor
		 *            [in] - Type on server: string
		 * @return result - Type on server: Currency
		 */
		public double Strftocurr(String valor) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.Strftocurr");
			cmd.prepare(get_TSvrMethod_Strftocurr_Metadata());
			cmd.getParameter(0).getValue().SetAsString(valor);
			getConnection().execute(cmd);
			return cmd.getParameter(1).getValue().GetAsCurrency();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GerarIdPesquisa_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GerarIdPesquisa_Metadata()
		{
			if (TSvrMethod_GerarIdPesquisa_Metadata == null)
			{
				TSvrMethod_GerarIdPesquisa_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.Int32Type, "Integer"), };
			}
			return TSvrMethod_GerarIdPesquisa_Metadata;
		}

		/**
		 * @return result - Type on server: Integer
		 */
		public int GerarIdPesquisa() throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GerarIdPesquisa");
			cmd.prepare(get_TSvrMethod_GerarIdPesquisa_Metadata());
			getConnection().execute(cmd);
			return cmd.getParameter(0).getValue().GetAsInt32();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GerarIdPergunta_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GerarIdPergunta_Metadata()
		{
			if (TSvrMethod_GerarIdPergunta_Metadata == null)
			{
				TSvrMethod_GerarIdPergunta_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.Int32Type, "Integer"), };
			}
			return TSvrMethod_GerarIdPergunta_Metadata;
		}

		/**
		 * @return result - Type on server: Integer
		 */
		public int GerarIdPergunta() throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GerarIdPergunta");
			cmd.prepare(get_TSvrMethod_GerarIdPergunta_Metadata());
			getConnection().execute(cmd);
			return cmd.getParameter(0).getValue().GetAsInt32();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetPerguntas_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetPerguntas_Metadata()
		{
			if (TSvrMethod_GetPerguntas_Metadata == null)
			{
				TSvrMethod_GetPerguntas_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetPerguntas_Metadata;
		}

		/**
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetPerguntas() throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetPerguntas");
			cmd.prepare(get_TSvrMethod_GetPerguntas_Metadata());
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(0).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetAlternativas_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetAlternativas_Metadata()
		{
			if (TSvrMethod_GetAlternativas_Metadata == null)
			{
				TSvrMethod_GetAlternativas_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("idPergunta", DSRESTParamDirection.Input,
								DBXDataTypes.Int32Type, "Integer"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.TableType, "TDBXReader"), };
			}
			return TSvrMethod_GetAlternativas_Metadata;
		}

		/**
		 * @param idPergunta
		 *            [in] - Type on server: Integer
		 * @return result - Type on server: TDBXReader
		 */
		public TDBXReader GetAlternativas(int idPergunta) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetAlternativas");
			cmd.prepare(get_TSvrMethod_GetAlternativas_Metadata());
			cmd.getParameter(0).getValue().SetAsInt32(idPergunta);
			getConnection().execute(cmd);
			return (TDBXReader) cmd.getParameter(1).getValue().GetAsTable();
		}

		private DSRESTParameterMetaData[] TSvrMethod_InserirPesquisa_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_InserirPesquisa_Metadata()
		{
			if (TSvrMethod_InserirPesquisa_Metadata == null)
			{
				TSvrMethod_InserirPesquisa_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("cliente", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("fone", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("email", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("cidade", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("nascimento", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.WideStringType, "string"), };
			}
			return TSvrMethod_InserirPesquisa_Metadata;
		}

		/**
		 * @param cliente
		 *            [in] - Type on server: string
		 * @param fone
		 *            [in] - Type on server: string
		 * @param email
		 *            [in] - Type on server: string
		 * @param cidade
		 *            [in] - Type on server: string
		 * @param nascimento
		 *            [in] - Type on server: string
		 * @return result - Type on server: string
		 */
		public String InserirPesquisa(String cliente, String fone, String email, String cidade,
				String nascimento) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.InserirPesquisa");
			cmd.prepare(get_TSvrMethod_InserirPesquisa_Metadata());
			cmd.getParameter(0).getValue().SetAsString(cliente);
			cmd.getParameter(1).getValue().SetAsString(fone);
			cmd.getParameter(2).getValue().SetAsString(email);
			cmd.getParameter(3).getValue().SetAsString(cidade);
			cmd.getParameter(4).getValue().SetAsString(nascimento);
			getConnection().execute(cmd);
			return cmd.getParameter(5).getValue().GetAsString();
		}

		private DSRESTParameterMetaData[] TSvrMethod_InserirResposta_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_InserirResposta_Metadata()
		{
			if (TSvrMethod_InserirResposta_Metadata == null)
			{
				TSvrMethod_InserirResposta_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("idPesquisa", DSRESTParamDirection.Input,
								DBXDataTypes.Int32Type, "Integer"),
						new DSRESTParameterMetaData("idPergunta", DSRESTParamDirection.Input,
								DBXDataTypes.Int32Type, "Integer"),
						new DSRESTParameterMetaData("alternativa", DSRESTParamDirection.Input,
								DBXDataTypes.Int32Type, "Integer"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.WideStringType, "string"), };
			}
			return TSvrMethod_InserirResposta_Metadata;
		}

		/**
		 * @param idPesquisa
		 *            [in] - Type on server: Integer
		 * @param idPergunta
		 *            [in] - Type on server: Integer
		 * @param alternativa
		 *            [in] - Type on server: Integer
		 * @return result - Type on server: string
		 */
		public String InserirResposta(int idPesquisa, int idPergunta, int alternativa)
				throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.InserirResposta");
			cmd.prepare(get_TSvrMethod_InserirResposta_Metadata());
			cmd.getParameter(0).getValue().SetAsInt32(idPesquisa);
			cmd.getParameter(1).getValue().SetAsInt32(idPergunta);
			cmd.getParameter(2).getValue().SetAsInt32(alternativa);
			getConnection().execute(cmd);
			return cmd.getParameter(3).getValue().GetAsString();
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetImageFolderPath_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetImageFolderPath_Metadata()
		{
			if (TSvrMethod_GetImageFolderPath_Metadata == null)
			{
				TSvrMethod_GetImageFolderPath_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.WideStringType, "string"), };
			}
			return TSvrMethod_GetImageFolderPath_Metadata;
		}

		/**
		 * @return result - Type on server: string
		 */
		public String GetImageFolderPath() throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetImageFolderPath");
			cmd.prepare(get_TSvrMethod_GetImageFolderPath_Metadata());
			getConnection().execute(cmd);
			return cmd.getParameter(0).getValue().GetAsString();
		}

		private DSRESTParameterMetaData[] TSvrMethod_ImageToBase64_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_ImageToBase64_Metadata()
		{
			if (TSvrMethod_ImageToBase64_Metadata == null)
			{
				TSvrMethod_ImageToBase64_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("url", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("relative", DSRESTParamDirection.Input,
								DBXDataTypes.BooleanType, "Boolean"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.WideStringType, "string"), };
			}
			return TSvrMethod_ImageToBase64_Metadata;
		}

		/**
		 * @param url
		 *            [in] - Type on server: string
		 * @param relative
		 *            [in] - Type on server: Boolean
		 * @return result - Type on server: string
		 */
		public String ImageToBase64(String url, boolean relative) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.ImageToBase64");
			cmd.prepare(get_TSvrMethod_ImageToBase64_Metadata());
			cmd.getParameter(0).getValue().SetAsString(url);
			cmd.getParameter(1).getValue().SetAsBoolean(relative);
			getConnection().execute(cmd);
			return cmd.getParameter(2).getValue().GetAsString();
		}


		private DSRESTParameterMetaData[] TSvrMethod_SistemaLiberado_Metadata;
		private DSRESTParameterMetaData[] TSvrMethod_SistemaLiberado_Metadata() {
			if (TSvrMethod_SistemaLiberado_Metadata == null)
			{
				TSvrMethod_SistemaLiberado_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.WideStringType, "string"), };
			}
			return TSvrMethod_SistemaLiberado_Metadata;
		}

		public String SistemaLiberado() throws DBXException {
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.SistemaLiberado");
			cmd.prepare(TSvrMethod_SistemaLiberado_Metadata());
			getConnection().execute(cmd);
			return cmd.getParameter(0).getValue().GetAsString();
		}

		public static class EmiteCFeSATReturns
		{
			public String sPDV;
			public String sPDV_PreVenda;
		}

		private DSRESTParameterMetaData[] TSvrMethod_EmiteCFeSAT_Metadata;
		private DSRESTParameterMetaData[] get_TSvrMethod_EmiteCFeSAT_Metadata() {
			if (TSvrMethod_EmiteCFeSAT_Metadata == null)
			{
				TSvrMethod_EmiteCFeSAT_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("sPDV", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("sPDV_PreVenda", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.WideStringType, "string"), };
			}
			return TSvrMethod_EmiteCFeSAT_Metadata;
		}

		public EmiteCFeSATReturns emiteCFeSAT() throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.EmiteCFeSAT");
			cmd.prepare(get_TSvrMethod_EmiteCFeSAT_Metadata());
			getConnection().execute(cmd);
			EmiteCFeSATReturns ret = new EmiteCFeSATReturns();
			ret.sPDV = cmd.getParameter(0).getValue().GetAsString();
			ret.sPDV_PreVenda = cmd.getParameter(1).getValue().GetAsString();
			return ret;
		}

		private DSRESTParameterMetaData[] TSvrMethod_GetCreditoEasyChopp_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetCreditoEasyChopp_Metadata() {
			if (TSvrMethod_GetCreditoEasyChopp_Metadata == null)
			{
				TSvrMethod_GetCreditoEasyChopp_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("nrDocumento", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("idTag", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.WideStringType, "string"),
				};
			}
			return TSvrMethod_GetCreditoEasyChopp_Metadata;
		}

		public String GetCreditoEasyChopp(String idTag) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetCreditoEasyChopp");
			cmd.prepare(get_TSvrMethod_GetCreditoEasyChopp_Metadata());
			cmd.getParameter(0).getValue().SetAsString(" ");
			cmd.getParameter(1).getValue().SetAsString(idTag);

			getConnection().execute(cmd);
			return cmd.getParameter(2).getValue().GetAsString();
		}

		private DSRESTParameterMetaData[] TSvrMethod_AddCreditoEasyChopp_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_AddCreditoEasyChopp_Metadata() {
			if (TSvrMethod_AddCreditoEasyChopp_Metadata == null)
			{
				TSvrMethod_AddCreditoEasyChopp_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("idTag", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("vlValorCredito", DSRESTParamDirection.Input,
								DBXDataTypes.CurrencyType, "currency"),
						new DSRESTParameterMetaData("ID_Recebimento", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("idFormaPagamento", DSRESTParamDirection.Input,
								DBXDataTypes.Int32Type, "Integer"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.Int32Type, "Integer"),
				};
			}
			return TSvrMethod_AddCreditoEasyChopp_Metadata;
		}

		public Integer AddCreditoEasyChopp(String idTag, double vlValorCredito, String idRecebimento, int idFormaPagamento) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.AddCreditoEasyChopp");
			cmd.prepare(get_TSvrMethod_AddCreditoEasyChopp_Metadata());
			cmd.getParameter(0).getValue().SetAsString(idTag);
			cmd.getParameter(1).getValue().SetAsCurrency(vlValorCredito);
			cmd.getParameter(2).getValue().SetAsString(idRecebimento);
			cmd.getParameter(3).getValue().SetAsInt32(idFormaPagamento);

			getConnection().execute(cmd);
			return cmd.getParameter(4).getValue().GetAsInt32();
		}

		private DSRESTParameterMetaData[] TSvrMethod_AddDebitoEasyChopp_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_AddDebitoEasyChopp_Metadata() {
			if (TSvrMethod_AddDebitoEasyChopp_Metadata == null)
			{
				TSvrMethod_AddDebitoEasyChopp_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("idTag", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("vlValorDebito", DSRESTParamDirection.Input,
								DBXDataTypes.CurrencyType, "currency"),
						new DSRESTParameterMetaData("codAutorizacao", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.Int32Type, "Integer"),
				};
			}
			return TSvrMethod_AddDebitoEasyChopp_Metadata;
		}
		
		private DSRESTParameterMetaData[] TSvrMethod_AddDebitoEasyChopp2_Metadata;
		
		private DSRESTParameterMetaData[] get_TSvrMethod_AddDebitoEasyChopp2_Metadata() {
			if (TSvrMethod_AddDebitoEasyChopp2_Metadata == null)
			{
				TSvrMethod_AddDebitoEasyChopp2_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("idTag", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("vlValorDebito", DSRESTParamDirection.Input,
								DBXDataTypes.CurrencyType, "currency"),
						new DSRESTParameterMetaData("codAutorizacao", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.Int32Type, "Integer"),
				};
			}
			return TSvrMethod_AddDebitoEasyChopp2_Metadata;
		}

		public Integer AddDebitoEasyChopp(String idTag, double vlValorDebito, String codAutorizacao) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.AddDebitoEasyChopp");
			cmd.prepare(get_TSvrMethod_AddDebitoEasyChopp_Metadata());
			cmd.getParameter(0).getValue().SetAsString(idTag);
			cmd.getParameter(1).getValue().SetAsCurrency(vlValorDebito);
			cmd.getParameter(2).getValue().SetAsString(codAutorizacao);

			getConnection().execute(cmd);
			return cmd.getParameter(3).getValue().GetAsInt32();
		}
		
		public Integer AddDebitoEasyChopp2(String idTag, double vlValorDebito, String codAutorizacao) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.AddDebitoEasyChopp2");
			cmd.prepare(get_TSvrMethod_AddDebitoEasyChopp2_Metadata());
			cmd.getParameter(0).getValue().SetAsString(idTag);
			cmd.getParameter(1).getValue().SetAsCurrency(vlValorDebito);
			cmd.getParameter(2).getValue().SetAsString(codAutorizacao);

			getConnection().execute(cmd);
			return cmd.getParameter(3).getValue().GetAsInt32();
		}


		private DSRESTParameterMetaData[] TSvrMethod_GetTransacoesPendentesEasyChopp_Metadata;

		private DSRESTParameterMetaData[] get_TSvrMethod_GetTransacoesPendentesEasyChopp_Metadata() {
			if (TSvrMethod_GetTransacoesPendentesEasyChopp_Metadata == null)
			{
				TSvrMethod_GetTransacoesPendentesEasyChopp_Metadata = new DSRESTParameterMetaData[] {
						new DSRESTParameterMetaData("idTag", DSRESTParamDirection.Input,
								DBXDataTypes.WideStringType, "string"),
						new DSRESTParameterMetaData("", DSRESTParamDirection.ReturnValue,
								DBXDataTypes.Int32Type, "Integer"),
				};
			}
			return TSvrMethod_GetTransacoesPendentesEasyChopp_Metadata;
		}

		public Integer GetTransacoesPendentesEasyChopp(String idTag) throws DBXException
		{
			DSRESTCommand cmd = getConnection().CreateCommand();
			cmd.setRequestType(DSHTTPRequestType.GET);
			cmd.setText("TSvrMethod.GetTransacoesPendentesEasyChopp");
			cmd.prepare(get_TSvrMethod_GetTransacoesPendentesEasyChopp_Metadata());
			cmd.getParameter(0).getValue().SetAsString(idTag);

			getConnection().execute(cmd);
			return cmd.getParameter(1).getValue().GetAsInt32();
		}
	}
}

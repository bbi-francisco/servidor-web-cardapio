package web_cardapio.br.com.bitbyte.models.bbifood;

import web_cardapio.br.com.bitbyte.models.Endereco;
import web_cardapio.br.com.bitbyte.utils.StringFormatterBuilder;

public class EnderecoBBIFood {
	
	private Endereco endereco;
	private StringFormatterBuilder formatter;
	
	public EnderecoBBIFood(Endereco endereco) {
		this.endereco = endereco;
		formatter = new StringFormatterBuilder();
	}
	
	public String getEndereco() {
        return formatter
                .removerAcentos()
                .limitarCaracteres(60)
                .toUpperCase()
                .build(endereco.getEndereco());   
    }
	
	public String getCid()
    {
        return formatter
                .removerAcentos()
                .limitarCaracteres(60)
                .toUpperCase()
                .build(endereco.getCid());  
    }
    
    public String getEst()
    {
        return formatter
                .removerAcentos()
                .limitarCaracteres(2)
                .toUpperCase()
                .build(endereco.getEst());
    }
    
    public String getCep()
    {
        return formatter
                .removerAcentos()
                .limitarCaracteres(2)
                .toUpperCase()
                .build(endereco.getCep());
    }
    
    public String getBairro()
    {
        return formatter
                .removerAcentos()
                .limitarCaracteres(60)
                .toUpperCase()
                .build(endereco.getBairro());
    }
    
    public String getComplemento()
    {
        return formatter
                .removerAcentos()
                .limitarCaracteres(60)
                .toUpperCase()
                .build(endereco.getComplemento());
    }
    
    public int getNumero()
    {
        return endereco.getNumero();
    }

    public int getNumEnd()
    {
        return endereco.getNumEnd();
    }
    
    public String getPais()
    {
        return formatter
                .removerAcentos()
                .limitarCaracteres(60)
                .toUpperCase()
                .build(endereco.getPais());
    }
    
    public String getReferencia() {
        return formatter
                .removerAcentos()
                .limitarCaracteres(60)
                .toUpperCase()
                .build(endereco.getReferencia());
    }

}

package web_cardapio.br.com.bitbyte.format;

import java.text.ParseException;

import web_cardapio.br.com.bitbyte.datastructures.Cnpj;
import web_cardapio.br.com.bitbyte.datastructures.Cpf;
import web_cardapio.br.com.bitbyte.utils.NumberFormatter;

public class CpfCnpjFormatter 
{
    private final NumberFormatter numberFormatter;
    
    public CpfCnpjFormatter(){
        numberFormatter = new NumberFormatter();
    }
    
    public String format(String cadastro) throws ParseException, IllegalArgumentException
    {
        cadastro = cadastro != null ? cadastro : "";
        String rawCadastro = numberFormatter.getRawNumber(cadastro);
        Cadastro type = getType(rawCadastro);
        
        switch (type) {
            case CPF:
                return new Cpf(rawCadastro).getFormatted();
            case CNPJ:
                return  new Cnpj(rawCadastro).getFormatted();
            default:
                throw new IllegalArgumentException("O cpf/cnpj '" + cadastro + "' é inválido.");
        }
    }
    
    private Cadastro getType(String value){
        if(value.length() == 11){
            return Cadastro.CPF;
        }
        
        if(value.length() == 14){
            return Cadastro.CNPJ;
        }
        
        return Cadastro.INVALID;
    }
    
    private enum Cadastro{
        CPF(0),
        CNPJ(1),
        INVALID(2);
        
        private final int type;
        
        Cadastro(int type){
            this.type = type;
        }
    }
}
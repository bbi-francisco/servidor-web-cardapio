package web_cardapio.br.com.bitbyte.enums;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public enum TipoPagamento{

   DEBITO("DEBITO"),
   CREDITO("CREDITO"),
   RECEBIMENTO("RECEBIMENTO"),
   TICKET("TICKET"),
   DINHEIRO("DINHEIRO");

   private final String value;

   TipoPagamento(String value){
      this.value = value;
   }

   public String getValue() {
      return value;
   }

   public static boolean isDinheiro(String value)
   {
      String formattedValue = StringUtils.getEmptyIfNull(value)
              .toUpperCase()
              .trim();

      return DINHEIRO.getValue().equals(formattedValue);
   }

}
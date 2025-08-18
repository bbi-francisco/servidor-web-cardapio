package web_cardapio.br.com.bitbyte.cupomfiscal;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("MP")
public class MP {
        private int cMP;

        private String vMP;

        public int getcMP() {
            return cMP;
        }

        public void setcMP(int cMP) {
            this.cMP = cMP;
        }

        public String getvMP() {
            return vMP;
        }

        public void setvMP(String vMP) {
            this.vMP = vMP;
        }
}

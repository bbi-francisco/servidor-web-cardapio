package web_cardapio.br.com.bitbyte.cupomfiscal;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class infCFe {

    @XStreamAsAttribute
    @XStreamAlias("Id")
    private String Id;

    @XStreamAsAttribute
    @XStreamAlias("versao")
    private Double versao;

    @XStreamAsAttribute
    @XStreamAlias("versaoDadosEnt")
    private Double versaoDadosEnt;

    @XStreamAsAttribute
    @XStreamAlias("versaoSB")
    private Integer versaoSB;

    private Identificacao ide;

    private Emitente emit;

    private Destinatario dest;

    private Entrega entrega;

    @XStreamImplicit(itemFieldName="det")
    private List<Detalhamento> det;

    private Total total;

    private Pagamento pgto;

    private InfAdc infAdic;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Double getVersao() {
        return versao;
    }

    public void setVersao(Double versao) {
        this.versao = versao;
    }

    public Double getVersaoDadosEnt() {
        return versaoDadosEnt;
    }

    public void setVersaoDadosEnt(Double versaoDadosEnt) {
        this.versaoDadosEnt = versaoDadosEnt;
    }

    public Integer getVersaoSB() {
        return versaoSB;
    }

    public void setVersaoSB(Integer versaoSB) {
        this.versaoSB = versaoSB;
    }

    public Identificacao getIde() {
        return ide;
    }

    public void setIde(Identificacao ide) {
        this.ide = ide;
    }

    public Emitente getEmit() {
        return emit;
    }

    public void setEmit(Emitente emit) {
        this.emit = emit;
    }

    public Destinatario getDest() {
        return dest;
    }

    public void setDest(Destinatario dest) {
        this.dest = dest;
    }

    public List<Detalhamento> getDet() {
        return det;
    }

    public void setDet(List<Detalhamento> det) {
        this.det = det;
    }

    public Total getTotal() {
        return total;
    }

    public void setTotal(Total total) {
        this.total = total;
    }

    public Pagamento getPgto() {
        return pgto;
    }

    public void setPgto(Pagamento pgto) {
        this.pgto = pgto;
    }

    public InfAdc getInfAdic() {
        return infAdic;
    }

    public void setInfAdic(InfAdc infAdic) {
        this.infAdic = infAdic;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }
}

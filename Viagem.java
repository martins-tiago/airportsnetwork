/*
    @Viagem LP2
    @author Rui Moreira, Christophe Soares, Ana Ribeiro Gomes
    @Tiago Martins 24440, Goncalo Silva 26329
    @version 2.0
    @date 2017
 */
package edu.ufp.inf.lp2.projeto17;

import edu.princeton.cs.algs4.RedBlackBST;

public class Viagem {

    public Date datavoo;

    public Aeroporto origem;

    public Aeroporto destino;

    public Aviao aviao;

    public int lotacao;

    public float custoMonetario;

    public float custoTemporal;

    public float custoTotal;

    RedBlackBST<Integer, LigacaoAerea> ligacoesaereas = new RedBlackBST<>();

    public Viagem(Date datavoo, Aeroporto origem, Aeroporto destino, Aviao aviao, int lotacao, float custoMonetario, float custoTemporal, float custoTotal) {
        this.datavoo = datavoo;
        this.origem = origem;
        this.destino = destino;
        this.aviao = aviao;
        this.lotacao = lotacao;
        this.custoMonetario = custoMonetario;
        this.custoTemporal = custoTemporal;
        this.custoTotal = custoTotal;
    }

    public Viagem() {

    }

    public Date getDatavoo() {
        return datavoo;
    }

    public void setDatavoo(Date datavoo) {
        this.datavoo = datavoo;
    }

    public Aeroporto getOrigem() {
        return origem;
    }

    public void setOrigem(Aeroporto origem) {
        this.origem = origem;
    }

    public Aeroporto getDestino() {
        return destino;
    }

    public void setDestino(Aeroporto destino) {
        this.destino = destino;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    public int getLotacao() {
        return lotacao;
    }

    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }

    public float getCustoMonetario() {
        return custoMonetario;
    }

    public void setCustoMonetario(float custoMonetario) {
        this.custoMonetario = custoMonetario;
    }

    public float getCustoTemporal() {
        return custoTemporal;
    }

    public void setCustoTemporal(float custoTemporal) {
        this.custoTemporal = custoTemporal;
    }

    public float getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(float custoTotal) {
        this.custoTotal = custoTotal;
    }

    @Override
    public String toString() {
        return "Viagem{" + "datavoo=" + datavoo + "origem=" + origem + ", destino=" + destino + ", aviao=" + aviao + ", lotacao=" + lotacao + ", custoTotal=" + custoTotal + '}';
    }

}

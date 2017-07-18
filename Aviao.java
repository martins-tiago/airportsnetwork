/*
    @Aviao LP2
    @author Rui Moreira, Christophe Soares, Ana Ribeiro Gomes
    @Tiago Martins 24440, Goncalo Silva 26329
    @version 2.0
    @date 2017
 */
package edu.ufp.inf.lp2.projeto17;

import edu.princeton.cs.algs4.RedBlackBST;
import java.util.List;
import java.util.Spliterators;
import org.omg.PortableServer.LifespanPolicy;

/**
 * @brief class do Aviao
 */
public class Aviao {

    /**
     * @details class do Aviao
     *
     */
    private int idAviao;
    private String modelo;
    private String nome;
    private String companhiaAerea;
    private int velocidadeCruzeiro;
    private int altitudeCruzeiro;
    private int distanciaMaxima;
    private String codigoAeroporto;
    private int capacidadePassageiro;
    private int capacidadeDeposito;

    public Aviao() {
    }

    RedBlackBST<Date, Viagem> viagens = new RedBlackBST<>();

    public Aviao(int idAviao, String modelo, String nome, String companhiaAerea, int velocidadeCruzeiro, int altitudeCruzeiro, int distanciaMaxima, String codigoAeroporto, int capacidadePassageiro, int capacidadeDeposito) {
        this.idAviao = idAviao;
        this.modelo = modelo;
        this.nome = nome;
        this.companhiaAerea = companhiaAerea;
        this.velocidadeCruzeiro = velocidadeCruzeiro;
        this.altitudeCruzeiro = altitudeCruzeiro;
        this.distanciaMaxima = distanciaMaxima;
        this.codigoAeroporto = codigoAeroporto;
        this.capacidadePassageiro = capacidadePassageiro;
        this.capacidadeDeposito = capacidadeDeposito;
    }

    public int getIdAviao() {
        return idAviao;
    }

    public void setIdAviao(int idAviao) {
        this.idAviao = idAviao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCompanhiaAerea() {
        return companhiaAerea;
    }

    public void setCompanhiaAerea(String companhiaAerea) {
        this.companhiaAerea = companhiaAerea;
    }

    public int getVelocidadeCruzeiro() {
        return velocidadeCruzeiro;
    }

    public void setVelocidadeCruzeiro(int velocidadeCruzeiro) {
        this.velocidadeCruzeiro = velocidadeCruzeiro;
    }

    public int getAltitudeCruzeiro() {
        return altitudeCruzeiro;
    }

    public void setAltitudeCruzeiro(int altitudeCruzeiro) {
        this.altitudeCruzeiro = altitudeCruzeiro;
    }

    public int getDistanciaMaxima() {
        return distanciaMaxima;
    }

    public void setDistanciaMaxima(int distanciaMaxima) {
        this.distanciaMaxima = distanciaMaxima;
    }

    public String getCodigoAeroporto() {
        return codigoAeroporto;
    }

    public void setCodigoAeroporto(String codigoAeroporto) {
        this.codigoAeroporto = codigoAeroporto;
    }

    public int getCapacidadePassageiro() {
        return capacidadePassageiro;
    }

    public void setCapacidadePassageiro(int capacidadePassageiro) {
        this.capacidadePassageiro = capacidadePassageiro;
    }

    public int getCapacidadeDeposito() {
        return capacidadeDeposito;
    }

    public void setCapacidadeDeposito(int capacidadeDeposito) {
        this.capacidadeDeposito = capacidadeDeposito;
    }

    /**
     * @brief Função para converter o custo da distancia para o custo do tempo
     */
    public Double calculatempo(DirectedEdge e) {
        /**
         * @details Função para converter o custo da distancia para o custo do
         * tempo
         * @param DirectedEdge e
         */

        double flightDuration = 0.0;
        //weight - dist 
        LigacaoAerea ligacao = (LigacaoAerea) e;
        flightDuration = (e.weight() / this.velocidadeCruzeiro);
        return flightDuration;
    }

    /**
     * @brief Função para converter o custo da distancia para o custo monetario
     */
    public Double calculaeuros(DirectedEdge e) {
        /**
         * @details Função para converter o custo da distancia para o custo
         * monetario
         * @param DirectedEdge e
         */

        double flightDuration = 0.0;
        double lphopt = 8000;
        double aopt = this.altitudeCruzeiro;
        double aflight = 0.0;
        double lphextra = 0.0;
        double aflightlphextra = 0.0;
        double vtailwind = 0.0;
        int litrosalt = 0;
        int litrosven = 0;
        double distvent = 0;
        double flightconsumption = 0.0;

        flightDuration = calculatempo(e);
        lphopt = lphopt / 60;
        LigacaoAerea ligacao = (LigacaoAerea) e;
        aflight = ligacao.getTunelAereo();

        aflightlphextra = aflight;
        if (aflightlphextra > aopt) {
            while (aflightlphextra > aopt) {
                aflightlphextra = aflightlphextra - 1000;
                litrosalt = litrosalt + 200;
            }
        } else {
            while (aflightlphextra > aopt) {
                aflightlphextra = aflightlphextra + 1000;
                litrosalt = litrosalt + 200;
            }
        }
        lphextra = litrosalt / 60;
        vtailwind = ligacao.velocidadeVento;
        distvent = ligacao.weight();
        if (vtailwind > 0) {
            while (distvent > 1000) {
                distvent = distvent - 1000;
                litrosven = litrosven - 20;
            }
        } else {
            while (distvent > 1000) {
                distvent = distvent - 1000;
                litrosven = litrosven + 20;
            }
        }
        vtailwind = litrosven;

        flightconsumption = ((flightDuration * 10) * (lphopt + (Math.abs(aopt) - Math.abs(aflight)) / 1000) * lphextra + vtailwind * 20);

        return flightconsumption;
    }

    @Override
    public String toString() {
        return "Aviao{" + "idAviao=" + idAviao + ", modelo=" + modelo + ", nome=" + nome + ", companhiaAerea=" + companhiaAerea + ", velocidadeCruzeiro=" + velocidadeCruzeiro + ", altitudeCruzeiro=" + altitudeCruzeiro + ", distanciaMaxima=" + distanciaMaxima + ", codigoAeroporto=" + codigoAeroporto + ", capacidadePassageiro=" + capacidadePassageiro + ", capacidadeDeposito=" + capacidadeDeposito + '}';
    }
}

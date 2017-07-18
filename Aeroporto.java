/*
    @Aeroporto LP2
    @author Rui Moreira, Christophe Soares, Ana Ribeiro Gomes
    @Tiago Martins 24440, Goncalo Silva 26329
    @version 2.0
    @date 2017
 */
package edu.ufp.inf.lp2.projeto17;

import edu.princeton.cs.algs4.RedBlackBST;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

public class Aeroporto implements Serializable {

    private String nomeAeroporto;

    private String CodigoAeroporto;

    private String cidade;

    private String pais;

    private String continente;

    private float classificacao;

    private double latitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    private double longitude;

    public RedBlackBST<Integer, Aviao> avioes = new RedBlackBST<>();
    public RedBlackBST<Date, Viagem> viagens = new RedBlackBST<>();
    //bst de viagens

    public Aeroporto(String nomeAeroporto, String CodigoAeroporto, String cidade, String pais, String continente, float classificacao, double latitude, double longitude) {
        this.nomeAeroporto = nomeAeroporto;
        this.CodigoAeroporto = CodigoAeroporto;
        this.cidade = cidade;
        this.pais = pais;
        this.continente = continente;
        this.classificacao = classificacao;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Aeroporto() {

    }

    public String getNomeAeroporto() {
        return nomeAeroporto;
    }

    public void setNomeAeroporto(String nomeAeroporto) {
        this.nomeAeroporto = nomeAeroporto;
    }

    public String getCodigoAeroporto() {
        return CodigoAeroporto;
    }

    public void setCodigoAeroporto(String CodigoAeroporto) {
        this.CodigoAeroporto = CodigoAeroporto;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public float getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(float classificacao) {
        this.classificacao = classificacao;
    }

    /**
     * @brief Função Imprimir Avioes todos de um aeroporto
     */
    public void printAvioesofaeroporto() {

        /**
         * @details Função qu imprime avioes de um determinado Aeroporto
         */
        int cont = 0;

        /*for(Integer key : avioes.keys()){
          Aviao a = this.avioes.get(key);
      }*/
        for (int i = 0; i < this.avioes.size(); i++) {

            if (this.avioes.get(this.avioes.select(i)).getCodigoAeroporto().compareTo(this.getCodigoAeroporto()) == 0) {

                System.out.println(this.avioes.get(this.avioes.select(i)));
                cont++;
            }

        }

        if (cont == 0) {

            System.out.println("NAO HA AVIOES NESTE AEROPORTO!!");

        }

    }

    @Override
    public String toString() {
        return "Aeroporto{" + "nomeAeroporto=" + nomeAeroporto + ", CodigoAeroporto=" + CodigoAeroporto + ", cidade=" + cidade + ", pais=" + pais + ", continente=" + continente + ", classificacao=" + classificacao + '}';
    }

}

/*
    @LigacaoAerea LP2
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
import java.util.ArrayList;

public class LigacaoAerea extends DirectedEdge {

    public float velocidadeVento;

    public int tunelAereo; //altitude

    public LigacaoAerea(float velocidadeVento, int tunelAereo, int v, int w, double weight) {

        super(v, w, weight);
        this.velocidadeVento = velocidadeVento;
        this.tunelAereo = tunelAereo;
    }

    public float getVelocidadeVento() {
        return velocidadeVento;
    }

    public void setVelocidadeVento(float velocidadeVento) {
        this.velocidadeVento = velocidadeVento;
    }

    public int getTunelAereo() {
        return tunelAereo;
    }

    public void setTunelAereo(int tunelAereo) {
        this.tunelAereo = tunelAereo;
    }

}

/*
    @mainpage LP2
    @author Rui Moreira, Christophe Soares, Ana Ribeiro Gomes
    @Tiago Martins 24440, Goncalo Silva 26329
    @version 2.0
    @date 2017
 */
package edu.ufp.inf.lp2.projeto17;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import edu.ufp.inf.lp2.figgeo.Ponto;
import edu.ufp.inf.lp2.figgeo.Rectangulo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Writer;
import jdk.nashorn.internal.ir.ContinueNode;

/**
 * \brief Classe main
 */
public class Main {

    /**
     * @brief Função main
     *
     */
    public RedBlackBST<String, Aeroporto> aeroportos = new RedBlackBST<>();
    public RedBlackBST<Integer, Aviao> avioes = new RedBlackBST<>();
    public RedBlackBST<Date, Viagem> viagens = new RedBlackBST<>();
    public RedBlackBST<Integer, LigacaoAerea> ligacoesaereas = new RedBlackBST<>();

    public Main() {
    }

    public static void main(String[] args) throws IOException {

        Main m = new Main();
        String filename = "graph.txt";
        String delimiter = ";";
        SymbolDigraph sg = new SymbolDigraph(filename, delimiter);

        Aeroporto a = new Aeroporto();

        loadAeroportoFromAFile(m.aeroportos);
        loadAviaoFromAFile(m.aeroportos, m.avioes);

        //IMPRIMIR AEROPORTO
        //printAeroporto("OPO",aeroportos);
        //IMPRIMIR AVIOES TODOS
        //printAvioes(aeroportos);
        //IMPRIMIR TODOS OS AVIOES DO MAIN
        //printAvioesofMain(avioes);
        //IMPRIMIR AVIAO
        //printAviao("Wenceslau de Moraes",aeroportos);
        //IMPRIMIR AVIOES DE UM AEROPORTO
        //aeroportos.get("OPO").printAvioesofaeroporto();
        //IMPRIMIR AEROPORTOS DE UM PAIS
        //printAeoroportoPais("Portugal",aeroportos);
        addViagem(new Date(18, 2, 2017, 10, 20, 12), m.aeroportos.get("OPO"), m.aeroportos.get("AMS"), m.aeroportos.get("OPO").avioes.get(1), 90, 1000f, 2000f, 30000f, m.aeroportos, m.viagens, m.avioes);
        addViagem(new Date(20, 2, 2017, 11, 21, 22), m.aeroportos.get("AMS"), m.aeroportos.get("LGW"), m.aeroportos.get("AMS").avioes.get(1), 90, 1000f, 2000f, 30000f, m.aeroportos, m.viagens, m.avioes);
        addViagem(new Date(27, 2, 2017, 23, 12, 12), m.aeroportos.get("OPO"), m.aeroportos.get("REC"), m.aeroportos.get("OPO").avioes.get(2), 90, 1000f, 2000f, 30000f, m.aeroportos, m.viagens, m.avioes);
        addViagem(new Date(17, 3, 2017, 4, 4, 12), m.aeroportos.get("SCL"), m.aeroportos.get("OPO"), m.aeroportos.get("SCL").avioes.get(5), 170, 1000f, 2000f, 50000f, m.aeroportos, m.viagens, m.avioes);
        addViagem(new Date(10, 1, 2017, 10, 59, 8), m.aeroportos.get("LGW"), m.aeroportos.get("OPO"), m.aeroportos.get("LGW").avioes.get(7), 150, 1000f, 2000f, 60000f, m.aeroportos, m.viagens, m.avioes);
        addViagem(new Date(27, 2, 2017, 18, 19, 8), m.aeroportos.get("REC"), m.aeroportos.get("FCO"), m.aeroportos.get("REC").avioes.get(8), 80, 1000f, 2000f, 70000f, m.aeroportos, m.viagens, m.avioes);

        //ADICIONAR EDITAR E REMOVER VIAGEM
        //addViagem(new Date(12,4,2017,10,10,10),aeroportos.get("OPO"),aeroportos.get("AMS"),aeroportos.get("OPO").avioes.get(3),90,1000f,20f,30000f,aeroportos,viagens,avioes);
        //removeViagem(new Date(17,3,2017,4,4,12),aeroportos,viagens,avioes);
        //m.editViagem(new Date(10,1,2017,10,59,8),new Date(6,6,2017,12,12,12),m.aeroportos.get("OPO"),m.aeroportos.get("FCO"),m.aeroportos.get("OPO").avioes.get(4),90,1000f, 2000f,30000f,m.aeroportos,m.viagens,m.avioes);
        //ADICIONAR EDITAR E REMOVER AVIOES
        //addAviao(38,"GONGAS AIRBUS","GONCALO Mendes Pinto","TAP GONGAS Portugal",871,8000,16700,"OPO",380,274876,m.aeroportos,m.avioes);
        //editAviao("GONCALO Mendes Pinto",39,"TIAGO BUS","TIAGO Mendes Pinto","TAP TIAGO Portugal",871,8000,16700,"OPO",380,274876,m.aeroportos,m.viagens);
        //removeAviao("Fern�o Mendes Pinto",m.aeroportos,m.avioes,m.viagens);
        //ADICIONAR EDITAR E REMOVER AEROPORTO
        //addAeroporto("Goncalo Pards","ODA","Oliveira de Azemeis","Portugal","Europe",8.1f,m.aeroportos);
        //editAeroporto("OPO","bobcat","APA","EM PINHAO","Pertugal","Europs",0.3f,m.aeroportos,m.viagens);
        //removeAeroporto("OPO",aeroportos,avioes,viagens);
        //TESTAR ADICIONAR E REMOVER E EDITAR
        //printAeroporto("OPO",aeroportos);
        //printAvioes(aeroportos);
        //printViagensAvioes(aeroportos);
        //printViagensofMain(viagens);
        //printViagensAeroportos(aeroportos);
        //printAvioesofMain(avioes);
        //printAvioesofMain(avioes);
        //printViagensofMain(viagens);
        //printAvioes(aeroportos);
        //IMPRIMIR VIAGENS DA BST DO MAIN
        //printViagensofMain(viagens);
        //IMPRIMIR TODAS AS VIAGENS DOS AVIOES
        //printViagensAvioes(aeroportos);
        //ASSOCIAR VIAGENS DOS AVIOES AO AEROPORTO
        //AssociateViagensAvioestoAeroportos(aeroportos);
        //IMPRIMIR TODAS AS VIAGENS DOS AEROPORTOS
        //printViagensAeroportos(aeroportos);
        //IMPRIMIR VIAGENS COM UMA DETERMINADA ORIGEM OU DESTINO
        //printViagemwithorigemordestino("OPO",aeroportos);
        //IMPRIMIR VIAGENS DE UM DETERMINADO AVIAO
        //printViagemAviao("Amalia Rodrigues",aeroportos);
        //IMPRIMIR VIAGENS REALIZADAS ENTRE DATAS
        //printViagensBetweenDates(new Date(1,2,2017,10,20,12),new Date(28,2,2017,23,12,12),aeroportos);
        //IMPRIMIR AEROPORTO COM MAIS TRAFEGO
        //printAeroportoWithMoreTrafego(aeroportos);
        //IMPRIMIR O VOO QUE TRANSPORTOU MAIS PASSAGEIROS
        //printViagemWithMorePassageiros(aeroportos);
        //IMPRIMIR O AEROPORTO QUE TRANSPORTOU O MAIOR NUMERO DE PASSAGEIROS
        //printAeropWithMorePassageiros(aeroportos);
        //GUARDAR NUM FICHEIRO AEROPORTOS, AVIOES E VIAGENS
        //AeroportosToFile(m.aeroportos);
        //AvioesToFile(m.aeroportos);
        //ViagensToFile(m.aeroportos);
        //CUSTO VIAGEM EM EUROS
        //aeroportos.get("OPO").avio es.get(1).calularCustoViagem(800,2000,1500);
        //caminhomaiscurto("OPO","JNB",sg);
        //caminhomaisrapido("OPO","JNB",sg,m.avioes);
        //caminhomaiseconomico("OPO","ALG",sg,m.avioes);
        //AeroportosToBin(m.aeroportos);
        //AeroportosFromBin(m.aeroportos);
        //AvioesToBin(m.avioes);
        //AvioesFromBin(m.avioes);
        //ViagensToBin(m.viagens);
        //ViagensFromBin(m.viagens);
        //isC(sg, m.aeroportos);
    }

    /**
     * @brief Função para verificar se o grafo é conexo
     */
    public static void isC(SymbolDigraph sg, RedBlackBST<String, Aeroporto> aeroportos) {
        /**
         * @details Função para verificar se o grafo é conexo
         * @param SymbolDigraph sg
         * @param RedBlackBST<String, Aeroporto> Aeroporto contém a BST de
         * aeroportos
         */

        int cont = 0;
        for (int i = 0; i < aeroportos.size(); i++) {
            BreadthFirstDirectedPaths bfs = new BreadthFirstDirectedPaths(sg.G(), i);
            for (int j = 0; j < aeroportos.size(); j++) {
                bfs.getMarked();
                if (bfs.distTo(j) == 0) {
                    cont++;
                }
            }
            if (cont > 1) {
                System.out.println("O GRAFO NAO E CONEXO");
                return;
            }
            cont = 0;
        }
        System.out.println("O GRAFO E CONEXO!!");
    }

    /**
     * @brief Função para importar do ficheiro binario as viagens
     */
    public static void ViagensFromBin(RedBlackBST<Date, Viagem> viagens) {
        /**
         * @details Função para importar do ficheiro binario as viagens
         * @param RedBlackBST<Date, Viagem> viagens contém a BST de viagens
         */

        String fileName = "Viagens.bin";
        FileInputStream fis = null;
        DataInputStream dis = null;
        String linha;
        try {
            fis = new FileInputStream(fileName);
            dis = new DataInputStream(fis);
            while ((linha = dis.readLine()) != null) {
                String str[] = linha.split(";");
                for (int i = 0; i < str.length; i++) {
                    System.out.print(str[i]);
                    System.out.print(";");
                }
                System.out.println("");
            }
        } catch (Exception e) {
        }
    }

    /**
     * @brief Função para gravar um ficheiro binario de viagens
     */
    public static void ViagensToBin(RedBlackBST<Date, Viagem> viagens) {
        /**
         * @details Função para gravar um ficheiro binario de viagens
         * @param RedBlackBST<Date, Viagem> viagens contém a BST de viagens
         */

        File file = null;
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            String fileName = "Viagens.bin";
            file = new File(fileName);
            fos = new FileOutputStream(file);
            dos = new DataOutputStream(fos);
            for (Date via : viagens.keys()) {
                Viagem v = viagens.get(via);
                dos.writeChars(String.valueOf(v.getDatavoo()));
                dos.writeChars(";");
                dos.writeChars(v.getOrigem().getCodigoAeroporto());
                dos.writeChars(";");
                dos.writeChars(v.getDestino().getCodigoAeroporto());
                dos.writeChars(";");
                dos.writeChars(String.valueOf(v.getAviao().getIdAviao()));
                dos.writeChars(";");
                dos.writeChars(String.valueOf(v.getLotacao()));
                dos.writeChars(";");
                dos.writeChars(String.valueOf(v.getCustoMonetario()));
                dos.writeChars(";");
                dos.writeChars(String.valueOf(v.getCustoTemporal()));
                dos.writeChars(";");
                dos.writeChars(String.valueOf(v.getCustoTotal()));
                dos.writeChars("\n");
            }
        } catch (Exception e) {
            System.out.println("ERRO!!");
        }
    }

    /**
     * @brief Função para importar do ficheiro binario os aviões
     */
    public static void AvioesFromBin(RedBlackBST<Integer, Aviao> avioes) {
        /**
         * @details Função para importar do ficheiro binario os aviões
         * @param RedBlackBST<Integer, Aviao> avioes contém a BST de avioes
         */

        String fileName = "Avioes.bin";
        FileInputStream fis = null;
        DataInputStream dis = null;
        String linha;
        try {
            fis = new FileInputStream(fileName);
            dis = new DataInputStream(fis);
            while ((linha = dis.readLine()) != null) {
                String str[] = linha.split(";");
                for (int i = 0; i < str.length; i++) {
                    System.out.print(str[i]);
                    System.out.print(";");
                }
                System.out.println("");
            }
        } catch (Exception e) {
        }
    }

    /**
     * @brief Função para gravar um ficheiro binario dos avisoes
     */
    public static void AvioesToBin(RedBlackBST<Integer, Aviao> avioes) {
        /**
         * @details Função para importar do ficheiro binario os aviões
         * @param RedBlackBST<Integer, Aviao> avioes contém a BST de avioes
         */

        File file = null;
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            String fileName = "Avioes.bin";
            file = new File(fileName);
            fos = new FileOutputStream(file);
            dos = new DataOutputStream(fos);
            for (Integer avi : avioes.keys()) {
                Aviao a = avioes.get(avi);
                dos.writeChars(String.valueOf(a.getIdAviao()));
                dos.writeChars(";");
                dos.writeChars(a.getModelo());
                dos.writeChars(";");
                dos.writeChars(a.getNome());
                dos.writeChars(";");
                dos.writeChars(a.getCompanhiaAerea());
                dos.writeChars(";");
                dos.writeChars(String.valueOf(a.getVelocidadeCruzeiro()));
                dos.writeChars(";");
                dos.writeChars(String.valueOf(a.getAltitudeCruzeiro()));
                dos.writeChars(";");
                dos.writeChars(String.valueOf(a.getDistanciaMaxima()));
                dos.writeChars(";");
                dos.writeChars(a.getCodigoAeroporto());
                dos.writeChars(";");
                dos.writeChars(String.valueOf(a.getCapacidadePassageiro()));
                dos.writeChars(";");
                dos.writeChars(String.valueOf(a.getCapacidadeDeposito()));
                dos.writeChars("\n");
            }
        } catch (Exception e) {
            System.out.println("ERRO!!");
        }
    }

    /**
     * @brief Função para importar um ficheiro binario dos aeroportos
     */
    public static void AeroportosFromBin(RedBlackBST<String, Aeroporto> aeroportos) {
        /**
         * @details Função para importar um ficheiro binario dos aeroportos
         * @param RedBlackBST<String, Aeroporto> aeroportos contém a BST de
         * aeroportos
         */

        String fileName = "Aeroportos.bin";
        FileInputStream fis = null;
        DataInputStream dis = null;
        String linha;
        String continente = "";
        String nome = "";
        String cod_aerop = "";
        String cidade = "";
        String pais = "";
        try {
            fis = new FileInputStream(fileName);
            dis = new DataInputStream(fis);
            while ((linha = dis.readLine()) != null) {
                String str[] = linha.split(";");
                for (int i = 0; i < str.length; i++) {
                    System.out.print(str[i]);
                    System.out.print(";");
                    switch (i) {
                        case 0:
                            nome = str[i];
                            break;
                        case 1:
                            cod_aerop = str[i];
                            break;
                        case 2:
                            cidade = str[i];
                            break;
                        case 3:
                            pais = str[i];
                            break;
                        case 4:
                            continente = str[i];
                            break;
                        case 5:
                            float classificacao;
                            //classificacao = Float.parseFloat(str[i]);                          
                            break;
                        case 6:
                            double latitude;
                            //latitude = Float.parseFloat(str[i]);
                            break;
                        case 7:
                            double longitude;
                            //longitude = Float.parseFloat(str[i]);
                            //addAeroporto(nome,cod_aerop,cidade,pais,continente,classificacao,latitude,longitude,aeroportos);
                            break;
                    }
                }
                System.out.println("");
            }
        } catch (Exception e) {
        }
    }

    /**
     * @brief Função para gravar do ficheiro binario os aeroportos
     */
    public static void AeroportosToBin(RedBlackBST<String, Aeroporto> aeroportos) {

        /**
         * @details Função para gravar do ficheiro binario os aeroportos
         * @param RedBlackBST<String, Aeroporto> aeroportos contém a BST de
         * aeroportos
         */
        File file = null;
        FileOutputStream fos = null;
        DataOutputStream dos = null;

        try {

            String fileName = "Aeroportos.bin";
            file = new File(fileName);
            fos = new FileOutputStream(file);
            dos = new DataOutputStream(fos);

            for (String aerop : aeroportos.keys()) {

                Aeroporto a = aeroportos.get(aerop);

                dos.writeChars(a.getNomeAeroporto());
                dos.writeChars(";");
                dos.writeChars(a.getCodigoAeroporto());
                dos.writeChars(";");
                dos.writeChars(a.getCidade());
                dos.writeChars(";");
                dos.writeChars(a.getPais());
                dos.writeChars(";");
                dos.writeChars(a.getContinente());
                dos.writeChars(";");
                dos.writeChars(String.valueOf(a.getClassificacao()));
                dos.writeChars(";");
                dos.writeChars(String.valueOf(a.getLatitude()));
                dos.writeChars(";");
                dos.writeChars(String.valueOf(a.getLongitude()));
                dos.writeChars("\n");

            }

        } catch (Exception e) {

            System.out.println("ERRO!!");

        }
    }

    /**
     * @brief Função do caminho mais curto
     */
    public static void caminhomaiscurto(String aeroporto1, String aeroporto2, SymbolDigraph sg) {
        /**
         * @details Função do caminho mais curto
         * @param String aeroporto1
         * @param String aeroporto2
         * @param SymbolDigraph sg
         */

        DijkstraSP d = new DijkstraSP(sg.G(), sg.indexOf(aeroporto1));
        for (DirectedEdge e : d.pathTo(sg.indexOf(aeroporto2))) {
            //StdOut.print(e + "   ");
            System.out.println(sg.nameOf(e.from()) + "->" + sg.nameOf(e.to()) + " DIST " + e.weight());
        }
    }

    /**
     * @brief Função do caminho mais economico
     */
    public static void caminhomaiseconomico(String aeroporto1, String aeroporto2, SymbolDigraph sg, RedBlackBST<Integer, Aviao> avioes) {

        /**
         * @details Função do caminho mais economico
         * @param String aeroporto1
         * @param String aeroporto2
         * @param SymbolDigraph sg
         */
        int vmaior = 0;
        int aveloz = 0;

        for (Integer aviaokey : avioes.keys()) {

            Aviao a = avioes.get(aviaokey);

            if (a.getCodigoAeroporto().compareTo(aeroporto1) == 0) {

                if (a.getVelocidadeCruzeiro() > vmaior) {

                    vmaior = a.getVelocidadeCruzeiro();
                    aveloz = aviaokey;
                }
            }
        }
        Aviao a = avioes.get(aveloz);
        DijkstraSP d = new DijkstraSP(sg.G(), sg.indexOf(aeroporto1), 2, a);
        for (DirectedEdge e : d.pathTo(sg.indexOf(aeroporto2))) {
            System.out.println(sg.nameOf(e.from()) + "->" + sg.nameOf(e.to()) + " EUROS " + d.distTo(e.to()));
        }
    }

    /**
     * @brief Função do caminho mais rapido
     */
    public static void caminhomaisrapido(String aeroporto1, String aeroporto2, SymbolDigraph sg, RedBlackBST<Integer, Aviao> avioes) {

        int vmaior = 0;
        int aveloz = 0;

        for (Integer aviaokey : avioes.keys()) {

            Aviao a = avioes.get(aviaokey);

            if (a.getCodigoAeroporto().compareTo(aeroporto1) == 0) {

                if (a.getVelocidadeCruzeiro() > vmaior) {

                    vmaior = a.getVelocidadeCruzeiro();
                    aveloz = aviaokey;
                }
            }
        }

        Aviao a = avioes.get(aveloz);
        DijkstraSP d = new DijkstraSP(sg.G(), sg.indexOf(aeroporto1), 1, a);

        for (DirectedEdge e : d.pathTo(sg.indexOf(aeroporto2))) {
            System.out.println(sg.nameOf(e.from()) + "->" + sg.nameOf(e.to()) + " TEMPO " + d.distTo(e.to()));
        }
    }

    /**
     * @brief Função para Imprimir viagens do Main
     */
    public static void printViagensofMain(RedBlackBST<Date, Viagem> viagens) {
        /**
         * @details Função imprime viagens da BST de viagens do MAIN
         * @param RedBlackBST<Date,Viagem> viagens contém a BST de viagens
         */

        for (Date viakey : viagens.keys()) {

            Viagem v = viagens.get(viakey);
            System.out.println(v);

        }

    }

    /**
     * @brief Função Associar viagens avioes ao Main
     */
    public static void AssociateViagensofAvioestoMain(RedBlackBST<String, Aeroporto> aeroportos, RedBlackBST<Date, Viagem> viagens) {

        /**
         * @details Função associadora de viagens dos avioes à BST de viagens do
         * MAIN
         * @param RedBlackBST<String,Aeroporto> aeroportos contém a BST de
         * aeroportos
         * @param RedBlackBST<Date,Viagem> viagens contém a BST de viagens
         * @param RedBlackBST<Date, Viagem> viagens contém a BST de viagens
         */
        RedBlackBST<Date, Viagem> viagensaux = new RedBlackBST<>();

        for (Date vkey : viagens.keys()) {
            viagens.delete(vkey);
        }

        for (String aeropkey : aeroportos.keys()) {
            Aeroporto aerop = aeroportos.get(aeropkey);
            for (Integer aviaokey : aerop.avioes.keys()) {
                Aviao a = aerop.avioes.get(aviaokey);
                for (Date viakey : a.viagens.keys()) {
                    Viagem v = a.viagens.get(viakey);
                    viagens.put(viakey, v);
                }
            }
        }
    }

    /**
     * @brief Função AeroportosToFile
     */
    public static void AeroportosToFile(RedBlackBST<String, Aeroporto> aeroportos) {

        /**
         * @details Função que guarda informações da BST Aeroportos em ficheiro
         * @param RedBlackBST<String,Aeroporto> aeroportos contém a BST de
         * aeroportos
         */
        BufferedWriter bufferedWriter = null;
        try {

            File myFile = new File("airportsout.txt");

            if (!myFile.exists()) {
                myFile.createNewFile();
            }

            Writer writer = new FileWriter(myFile);
            bufferedWriter = new BufferedWriter(writer);

            for (int i = 0; i < aeroportos.size(); i++) {

                bufferedWriter.write(aeroportos.get(aeroportos.select(i)).getNomeAeroporto() + ";");
                bufferedWriter.write(aeroportos.get(aeroportos.select(i)).getCodigoAeroporto() + ";");
                bufferedWriter.write(aeroportos.get(aeroportos.select(i)).getCidade() + ";");
                bufferedWriter.write(aeroportos.get(aeroportos.select(i)).getPais() + ";");
                bufferedWriter.write(String.valueOf(aeroportos.get(aeroportos.select(i)).getClassificacao()) + ";");
                bufferedWriter.write(String.valueOf(aeroportos.get(aeroportos.select(i)).getLatitude()) + ";");
                bufferedWriter.write(String.valueOf(aeroportos.get(aeroportos.select(i)).getLongitude()) + ";");
                bufferedWriter.newLine();

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (Exception ex) {

            }
        }
    }

    /**
     * @brief Função ViagensToFile
     */
    public static void ViagensToFile(RedBlackBST<String, Aeroporto> aeroportos) {

        /**
         * @details Função que guarda informações da BST Viagens em ficheiro
         * @param RedBlackBST<String,Aeroporto> aeroportos contém a BST de
         * aeroportos
         */
        RedBlackBST<Integer, Aviao> avioesaux = new RedBlackBST<>();
        RedBlackBST<Date, Viagem> viagensaux = new RedBlackBST<>();

        BufferedWriter bufferedWriter = null;
        try {

            File myFile = new File("viagensout.txt");

            if (!myFile.exists()) {
                myFile.createNewFile();
            }

            Writer writer = new FileWriter(myFile);
            bufferedWriter = new BufferedWriter(writer);

            for (int i = 0; i < aeroportos.size(); i++) {

                avioesaux = aeroportos.get(aeroportos.select(i)).avioes;

                for (int j = 0; j < avioesaux.size(); j++) {

                    viagensaux = avioesaux.get(avioesaux.select(j)).viagens;

                    for (int k = 0; k < viagensaux.size(); k++) {

                        bufferedWriter.write(String.valueOf(viagensaux.get(viagensaux.select(k)).getDatavoo()) + ";");
                        bufferedWriter.write(String.valueOf(viagensaux.get(viagensaux.select(k)).getOrigem().getCodigoAeroporto()) + ";");
                        bufferedWriter.write(String.valueOf(viagensaux.get(viagensaux.select(k)).getDestino().getCodigoAeroporto()) + ";");
                        bufferedWriter.write(String.valueOf(viagensaux.get(viagensaux.select(k)).getAviao().getNome()) + ";");
                        bufferedWriter.write(String.valueOf(viagensaux.get(viagensaux.select(k)).getLotacao()) + ";");
                        bufferedWriter.write(String.valueOf(viagensaux.get(viagensaux.select(k)).getCustoMonetario()) + ";");
                        bufferedWriter.write(String.valueOf(viagensaux.get(viagensaux.select(k)).getCustoTemporal()) + ";");
                        bufferedWriter.write(String.valueOf(viagensaux.get(viagensaux.select(k)).getCustoTotal()) + ";");
                        bufferedWriter.newLine();

                    }

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (Exception ex) {

            }
        }
    }

    /**
     * @brief Função AvioesToFile
     */
    public static void AvioesToFile(RedBlackBST<String, Aeroporto> aeroportos) {

        /**
         * @details Função que guarda informações da BST Avioes em ficheiro
         * @param RedBlackBST<String,Aeroporto> aeroportos contém a BST de
         * aeroportos
         */
        RedBlackBST<Integer, Aviao> avioesaux = new RedBlackBST<>();

        BufferedWriter bufferedWriter = null;
        try {

            File myFile = new File("airplanesout.txt");

            if (!myFile.exists()) {
                myFile.createNewFile();
            }

            Writer writer = new FileWriter(myFile);
            bufferedWriter = new BufferedWriter(writer);

            for (int i = 0; i < aeroportos.size(); i++) {

                avioesaux = aeroportos.get(aeroportos.select(i)).avioes;

                for (int j = 0; j < avioesaux.size(); j++) {

                    bufferedWriter.write(String.valueOf(avioesaux.get(avioesaux.select(j)).getIdAviao()) + ";");
                    bufferedWriter.write(avioesaux.get(avioesaux.select(j)).getModelo() + ";");
                    bufferedWriter.write(avioesaux.get(avioesaux.select(j)).getNome() + ";");
                    bufferedWriter.write(avioesaux.get(avioesaux.select(j)).getCompanhiaAerea() + ";");
                    bufferedWriter.write(String.valueOf(avioesaux.get(avioesaux.select(j)).getVelocidadeCruzeiro()) + ";");
                    bufferedWriter.write(String.valueOf(avioesaux.get(avioesaux.select(j)).getAltitudeCruzeiro()) + ";");
                    bufferedWriter.write(String.valueOf(avioesaux.get(avioesaux.select(j)).getDistanciaMaxima()) + ";");
                    bufferedWriter.write(avioesaux.get(avioesaux.select(j)).getCodigoAeroporto() + ";");
                    bufferedWriter.write(String.valueOf(avioesaux.get(avioesaux.select(j)).getCapacidadePassageiro()) + ";");
                    bufferedWriter.write(String.valueOf(avioesaux.get(avioesaux.select(j)).getCapacidadeDeposito()) + ";");
                    bufferedWriter.newLine();

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (Exception ex) {

            }
        }
    }

    /**
     * @brief Função Editar Viagem
     */
    public static void editViagem(Date datavooanterior, Date datavoo, Aeroporto origem, Aeroporto destino, Aviao aviao, int lotacao, float custoMonetario, float custoTemporal, float custoTotal, RedBlackBST<String, Aeroporto> aeroportos, RedBlackBST<Date, Viagem> viagens, RedBlackBST<Integer, Aviao> avioes) {

        /**
         * @details Função que edita uma viagem existente fornecendo uma chave
         * da BST
         * @param Date datavooanterior data do voo a alterar
         * @param Date datavoo data do voo
         * @param Aeroporto origem origem do voo
         * @param Aeroporto destino destino do voo
         * @param int lotacao lotacao do voo
         * @param float customonetario customonetario do voo
         * @param float custotemporal custotemporal do voo
         * @param float custoTotal custo total do voo
         * @param RedBlackBST<String,Aeroporto> aeroportos contém a BST de
         * aeroportos
         */
        int cont = 0;

        RedBlackBST<Date, Viagem> viagensaux = new RedBlackBST<>();
        RedBlackBST<Integer, Aviao> avioesaux = new RedBlackBST<>();

        for (int i = 0; i < aeroportos.size(); i++) {

            avioesaux = aeroportos.get(aeroportos.select(i)).avioes;

            for (int j = 0; j < avioesaux.size(); j++) {

                viagensaux = avioesaux.get(avioesaux.select(j)).viagens;

                for (int k = 0; k < viagensaux.size(); k++) {

                    if (viagensaux.get(viagensaux.select(k)).getDatavoo().compareTo(datavooanterior) == 0) {
                        viagensaux.get(viagensaux.select(k)).setAviao(aviao);
                        viagensaux.get(viagensaux.select(k)).setCustoTotal(custoTotal);
                        viagensaux.get(viagensaux.select(k)).setDatavoo(datavoo);
                        viagensaux.get(viagensaux.select(k)).setDestino(destino);
                        viagensaux.get(viagensaux.select(k)).setLotacao(lotacao);
                        viagensaux.get(viagensaux.select(k)).setOrigem(origem);
                        viagensaux.get(viagensaux.select(k)).setCustoMonetario(custoMonetario);
                        viagensaux.get(viagensaux.select(k)).setCustoTemporal(custoTemporal);
                        AssociateViagensofAvioestoMain(aeroportos, viagens);
                        AssociateViagensMaintoAeroportos(aeroportos, viagens);
                        avioesaux.get(avioesaux.select(j)).setCodigoAeroporto(viagensaux.get(viagensaux.select(k)).getDestino().getCodigoAeroporto());
                        AssociateAvioesofAeroportotoMain(aeroportos, avioes);

                        return;

                    }

                }

            }

        }

        System.out.println("A VIAGEM NAO FOI ENCONTRADA!!");

    }

    /**
     * @brief Função Remover Viagem
     */
    public static void removeViagem(Date d, RedBlackBST<String, Aeroporto> aeroportos, RedBlackBST<Date, Viagem> viagens, RedBlackBST<Integer, Aviao> avioes) {

        /**
         * @details Função que remove uma viagem das BST
         * @param RedBlackBST<String,Aeroporto> aeroportos contém a BST de
         * aeroportos
         */
        RedBlackBST<Date, Viagem> viagensaerop = new RedBlackBST<>();
        RedBlackBST<Date, Viagem> viagensaux = new RedBlackBST<>();
        RedBlackBST<Integer, Aviao> avioesaux = new RedBlackBST<>();

        AssociateViagensMaintoAeroportos(aeroportos, viagens);

        for (int i = 0; i < aeroportos.size(); i++) {

            avioesaux = aeroportos.get(aeroportos.select(i)).avioes;

            for (int j = 0; j < avioesaux.size(); j++) {

                viagensaux = avioesaux.get(avioesaux.select(j)).viagens;

                for (int k = 0; k < viagensaux.size(); k++) {

                    if (viagensaux.get(viagensaux.select(k)).getDatavoo().compareTo(d) == 0) {

                        avioesaux.get(avioesaux.select(j)).setCodigoAeroporto(viagensaux.get(viagensaux.select(k)).getOrigem().getCodigoAeroporto());
                        AssociateAvioesofAeroportotoMain(aeroportos, avioes);
                        viagensaux.delete(d);
                        desassociateViagemofAeroporto(d, aeroportos);
                        AssociateViagensofAvioestoMain(aeroportos, viagens);
                        return;

                    }

                }

            }

        }

        System.out.println("A VIAGEM NAO FOI ENCONTRADA!!");

    }

    /**
     * @brief Funcao desassociar Viagem de um Aeroporto
     */
    public static void desassociateViagemofAeroporto(Date d, RedBlackBST<String, Aeroporto> aeroportos) {

        /**
         * @details Função para desassociar uma viagem de um aeroporto quando
         * esta é eliminada na BST dos AVIOES
         * @param Date d data da viagem (chave da BST)
         * @param RedBlackBST<String,Aeroporto> aeroportos contém a BST de
         * aeroportos
         */
        RedBlackBST<Date, Viagem> viagensaerop = new RedBlackBST<>();
        RedBlackBST<Date, Viagem> viagensaux = new RedBlackBST<>();
        RedBlackBST<Integer, Aviao> avioesaux = new RedBlackBST<>();

        for (int i = 0; i < aeroportos.size(); i++) {

            viagensaux = aeroportos.get(aeroportos.select(i)).viagens;

            for (int k = 0; k < viagensaux.size(); k++) {

                if (viagensaux.get(viagensaux.select(k)).getDatavoo().compareTo(d) == 0) {

                    viagensaux.delete(d);

                }

            }

        }
    }

    /**
     * @brief Função Associar Viagem dos Avioes ao aeroporto
     */
    public static void AssociateViagensMaintoAeroportos(RedBlackBST<String, Aeroporto> aeroportos, RedBlackBST<Date, Viagem> viagens) {

        /**
         * @details Função que associa a viagem do Aviaoao aeroporto para manter
         * a BASE de dados atualizadas em ambas as BST de viagens
         * @param RedBlackBST<String,Aeroporto> aeroportos contém a BST de
         * aeroportos
         * @param RedBlackBST<Date,Viagens> viagens contém a BST de viagens
         */
        for (String aeropkey : aeroportos.keys()) {

            Aeroporto aerop = aeroportos.get(aeropkey);

            for (Date vkey : aerop.viagens.keys()) {

                aerop.viagens.delete(vkey);

            }

        }

        for (Date vmain : viagens.keys()) {

            for (String aeropkey : aeroportos.keys()) {

                Aeroporto aerop = aeroportos.get(aeropkey);

                if (viagens.get(vmain).getOrigem().equals(aerop) || viagens.get(vmain).getDestino().equals(aerop)) {

                    aerop.viagens.put(vmain, viagens.get(vmain));

                }

            }

        }

    }

    /**
     * @brief Função Adicionar Viagem
     */
    public static void addViagem(Date datavoo, Aeroporto origem, Aeroporto destino, Aviao aviao, int lotacao, float custoMonetario, float custoTemporal, float custoTotal, RedBlackBST<String, Aeroporto> aeroportos, RedBlackBST<Date, Viagem> viagens, RedBlackBST<Integer, Aviao> avioes) {

        /**
         * @details Função que adiciona viagens à BST de viagens do AVIAO
         * @param Date datavoo data do voo
         * @param Aeroporto origem origem do voo
         * @param Aeroporto destino destino do voo
         * @param int lotacao lotacao do voo
         * @param float customonetario customonetario do voo
         * @param float custotemporal custotemporal do voo
         * @param float custoTotal custo total do voo
         * @param RedBlackBST<String,Aeroporto> aeroportos contém a BST de
         * aeroportos
         * @param RedBlackBST<Integer,Aviao> avioes contém a BST de avioes
         * * @param RedBlackBST<Date,Viagens> viagens contém a BST de viagens
         */
        int cont = 0;

        Viagem v = new Viagem(datavoo, origem, destino, aviao, lotacao, custoMonetario, custoTemporal, custoTotal);

        for (String aerokey : aeroportos.keys()) {

            Aeroporto aerop = aeroportos.get(aerokey);

            if (aerokey.compareTo(v.getOrigem().getCodigoAeroporto()) == 0) {

                for (Integer avikey : aerop.avioes.keys()) {

                    Aviao a = aerop.avioes.get(avikey);

                    try {

                        if (v.aviao.getIdAviao() == a.getIdAviao()) {

                            if (v.getLotacao() <= a.getCapacidadePassageiro()) {

                                for (Date viakey : a.viagens.keys()) {

                                    Viagem via = a.viagens.get(viakey);

                                    if (v.getDatavoo().compareTo(viakey) == 0) {

                                        break;

                                    }

                                }

                                a.viagens.put(v.getDatavoo(), v);
                                removeAviaoInstancia(a, aeroportos);
                                a.setCodigoAeroporto(v.getDestino().getCodigoAeroporto());
                                addAviaoInstancia(a, aeroportos);
                                AssociateAvioesofAeroportotoMain(aeroportos, avioes);
                                AssociateViagensofAvioestoMain(aeroportos, viagens);
                                AssociateViagensMaintoAeroportos(aeroportos, viagens);

                            } else {

                                System.out.println("A LOTACAO DA VIAGEM EXCEDE A CAPACIDADE DO AVIAO");
                                return;

                            }

                        }

                    } catch (NullPointerException e) {
                        System.out.print("O AVIAO DA VIAGEM A ADICIONAR NAO EXISTE\n");
                        break;
                    }

                }

            }

        }

    }

    /**
     * @brief Função Editar Aviao
     */
    public static void editAviao(String nomeaviao, int idAviao, String modelo, String nome, String companhiaAerea, int velocidadeCruzeiro, int altitudeCruzeiro, int distanciaMaxima, String codigoAeroporto, int capacidadePassageiro, int capacidadeDeposito, RedBlackBST<String, Aeroporto> aeroportos, RedBlackBST<Date, Viagem> viagens) {

        /**
         * @details Função que edita a BST dos avioes
         * @param String nomeaviao Aviao a editar
         * @param int idAviao chave do aviao
         * @param String modelo modeo do aviao
         * @param String nome nome do aviao
         * @param String companhiaAerea companhia aerea do aviao
         * @param int velocidadeCruzeiro velocidade de cruzeiro do aviao
         * @param int altitudeCruzeiro altitude de cruzeio do aviao
         * @param int distanciaMaximaint distanciamaxima do aviao
         * @param String codigoAeroporto codigo do aeroporto do aviao
         * @param int capacidadePassageiro capacidade de passageiros do aviao
         * @param int capacidadeDeposito capacidade de deposito do aviao
         * @param RedBlackBST<String,Aeroporto> aeroportos contém a BST de
         * aeroportos
         * * @param RedBlackBST<Date,Viagens> viagens contém a BST de viagens
         */
        Aviao a = new Aviao(idAviao, modelo, nome, companhiaAerea, velocidadeCruzeiro, altitudeCruzeiro, distanciaMaxima, codigoAeroporto, capacidadePassageiro, capacidadeDeposito);

        RedBlackBST<Date, Viagem> viagensaux = new RedBlackBST<>();
        RedBlackBST<Integer, Aviao> avioesaux = new RedBlackBST<>();

        for (int i = 0; i < aeroportos.size(); i++) {

            avioesaux = aeroportos.get(aeroportos.select(i)).avioes;

            for (int j = 0; j < avioesaux.size(); j++) {

                if (avioesaux.get(avioesaux.select(j)).getNome().compareTo(nomeaviao) == 0) {

                    viagensaux = avioesaux.get(avioesaux.select(j)).viagens;

                    for (int k = 0; k < viagensaux.size(); k++) {

                        if (viagensaux.get(viagensaux.select(j)).getAviao().getNome().compareTo(nomeaviao) == 0) {

                            viagensaux.get(viagensaux.select(j)).setAviao(a);

                        }

                    }

                    avioesaux.get(avioesaux.select(j)).setIdAviao(idAviao);
                    avioesaux.get(avioesaux.select(j)).setAltitudeCruzeiro(altitudeCruzeiro);
                    avioesaux.get(avioesaux.select(j)).setCapacidadeDeposito(capacidadeDeposito);
                    avioesaux.get(avioesaux.select(j)).setCapacidadePassageiro(capacidadePassageiro);
                    avioesaux.get(avioesaux.select(j)).setCodigoAeroporto(codigoAeroporto);
                    avioesaux.get(avioesaux.select(j)).setCompanhiaAerea(companhiaAerea);
                    avioesaux.get(avioesaux.select(j)).setDistanciaMaxima(distanciaMaxima);
                    avioesaux.get(avioesaux.select(j)).setModelo(modelo);
                    avioesaux.get(avioesaux.select(j)).setNome(nome);
                    avioesaux.get(avioesaux.select(j)).setVelocidadeCruzeiro(velocidadeCruzeiro);

                }

            }

        }

        AssociateViagensMaintoAeroportos(aeroportos, viagens);

    }

    /**
     * @brief Função Remover Aviao
     */
    public static void removeAviao(String nome, RedBlackBST<String, Aeroporto> aeroportos, RedBlackBST<Integer, Aviao> avioes, RedBlackBST<Date, Viagem> viagens) {

        /**
         * @details Função que elimina avioes da BST
         * @param String nome Aviao a remover
         * @param RedBlackBST<String,Aeroporto> aeroportos contém a BST de
         * aeroportos
         * @param RedBlackBST<Integer,Aviao> avioes contém a BST de avioes
         * * @param RedBlackBST<Date,Viagens> viagens contém a BST de viagens
         */
        RedBlackBST<Date, Viagem> viagensaux = new RedBlackBST<>();
        RedBlackBST<Integer, Aviao> avioesaux = new RedBlackBST<>();

        for (int i = 0; i < aeroportos.size(); i++) {

            avioesaux = aeroportos.get(aeroportos.select(i)).avioes;

            for (int j = 0; j < avioesaux.size(); j++) {

                viagensaux = avioesaux.get(avioesaux.select(j)).viagens;

                if (avioesaux.get(avioesaux.select(j)).getNome().compareTo(nome) == 0) {

                    for (int k = 0; k < viagensaux.size(); k++) {

                        viagensaux.delete(viagensaux.get(viagensaux.select(k)).getDatavoo());

                    }

                    avioesaux.delete(avioesaux.select(j));

                }

            }

        }
        AssociateViagensofAvioestoMain(aeroportos, viagens);
        AssociateViagensMaintoAeroportos(aeroportos, viagens);
        AssociateAvioesofAeroportotoMain(aeroportos, avioes);

    }

    /**
     * @brief Função Adicionar aviao como instancia (utilizada na função
     * adicionar viagem)
     */
    public static void addAviaoInstancia(Aviao a, RedBlackBST<String, Aeroporto> aeroportos) {

        /**
         * @details Função que adiciona avioes como instancias no Aeroporto
         * @param Aviao a Aviao que pretendemos adicionar
         * @param RedBlackBST<String,Aeroporto> aeroportos contém a BST de
         * aeroportos
         */
        RedBlackBST<Date, Viagem> viagensaux = new RedBlackBST<>();
        RedBlackBST<Integer, Aviao> avioesaux = new RedBlackBST<>();

        for (int i = 0; i < aeroportos.size(); i++) {

            if (aeroportos.get(aeroportos.select(i)).getCodigoAeroporto().compareTo(a.getCodigoAeroporto()) == 0) {

                avioesaux = aeroportos.get(aeroportos.select(i)).avioes;
                avioesaux.put(a.getIdAviao(), a);
                return;
            }

        }

        System.out.println("O AEROPORTO ONDE PRETENDE ADICIONAR O AVIAO NAO EXISTE!!");

    }

    /**
     * @brief Função Remover Aviao apartir de uma instancia (utilizada no
     * adicionar viagem)
     */
    public static void removeAviaoInstancia(Aviao a, RedBlackBST<String, Aeroporto> aeroportos) {

        /**
         * @details Função que remove avioes da BST
         * @param Aviao a Aviao que pretendemos remover
         * @param RedBlackBST<String,Aeroporto> aeroportos contém a BST de
         * aeroportos
         */
        for (String aeroporto : aeroportos.keys()) {

            Aeroporto auxA = aeroportos.get(aeroporto);

            for (Integer aviao : auxA.avioes.keys()) {

                Aviao auxB = auxA.avioes.get(aviao);

                if (auxB.equals(a)) {

                    auxA.avioes.delete(aviao);
                }
            }
        }
    }

    /**
     * @brief Função Adicionar Aviao
     */
    public static void addAviao(int idAviao, String modelo, String nome, String companhiaAerea, int velocidadeCruzeiro, int altitudeCruzeiro, int distanciaMaxima, String codigoAeroporto, int capacidadePassageiro, int capacidadeDeposito, RedBlackBST<String, Aeroporto> aeroportos, RedBlackBST<Integer, Aviao> avioes) {
        /**
         * @details Função que adiciona avioes à BST dos avioes
         * @param int idAviao chave do aviao
         * @param String modelo modeo do aviao
         * @param String nome nome do aviao
         * @param String companhiaAerea companhia aerea do aviao
         * @param int velocidadeCruzeiro velocidade de cruzeiro do aviao
         * @param int altitudeCruzeiro altitude de cruzeio do aviao
         * @param int distanciaMaximaint distanciamaxima do aviao
         * @param String codigoAeroporto codigo do aeroporto do aviao
         * @param int capacidadePassageiro capacidade de passageiros do aviao
         * @param int capacidadeDeposito capacidade de deposito do aviao
         * @param RedBlackBST<String,Aeroporto> aeroportos contém a BST de
         * aeroportos
         * @param RedBlackBST<Integer,Aviao> avioes contém a BST de avioes
         */

        Aviao a = new Aviao(idAviao, modelo, nome, companhiaAerea, velocidadeCruzeiro, altitudeCruzeiro, distanciaMaxima, codigoAeroporto, capacidadePassageiro, capacidadeDeposito);

        RedBlackBST<Date, Viagem> viagensaux = new RedBlackBST<>();
        RedBlackBST<Integer, Aviao> avioesaux = new RedBlackBST<>();

        for (int i = 0; i < aeroportos.size(); i++) {

            if (aeroportos.get(aeroportos.select(i)).getCodigoAeroporto().compareTo(codigoAeroporto) == 0) {

                avioesaux = aeroportos.get(aeroportos.select(i)).avioes;
                avioesaux.put(idAviao, a);
                AssociateAvioesofAeroportotoMain(aeroportos, avioes);
                return;
            }

        }

        System.out.println("O AEROPORTO ONDE PRETENDE ADICIONAR O AVIAO NAO EXISTE!!");

    }

    /**
     * @brief Função Adicionar aeroporto
     */
    public static void addAeroporto(String nome, String codigo, String cidade, String pais, String continente, float classificacao, double latitude, double longitude, RedBlackBST<String, Aeroporto> aeroportos) {

        /**
         * @details Função que adiciona aeroportos à BST dos aeroportos
         * @param String nome
         * @param String codigo
         * @param String cidade
         * @param String pais
         * @param String continente
         * @param float classificacao
         * @param RedBlackBST<String,Aeroporto> aeroportos contém a BST de
         * aeroportos
         */
        Aeroporto a = new Aeroporto(nome, codigo, cidade, pais, continente, classificacao, latitude, longitude);

        for (int i = 0; i < aeroportos.size(); i++) {

            if (a.equals(aeroportos.get(aeroportos.select(i)))) {

                System.out.println("O AEROPORTO JA EXISTE");
                return;

            }

        }

        aeroportos.put(codigo, a);
        //System.out.println(a.toString() + "\nFOI ADICIONADO COM SUCESSO");

    }

    /**
     * @brief Função Remover aeroporto
     */
    public static void removeAeroporto(String codigo, RedBlackBST<String, Aeroporto> aeroportos, RedBlackBST<Integer, Aviao> avioes, RedBlackBST<Date, Viagem> viagens) {

        /**
         * @details Função que remove aeroportos da BST dos aeroportos
         * @param String codigo
         * @param RedBlackBST<String,Aeroporto> aeroportos contém a BST de
         * aeroportos
         * @param RedBlackBST<Integer,Aviao> avioes contém a BST de avioes
         * * @param RedBlackBST<Date,Viagens> viagens contém a BST de viagens
         */
        RedBlackBST<Date, Viagem> viagensaux = new RedBlackBST<>();
        RedBlackBST<Integer, Aviao> avioesaux = new RedBlackBST<>();

        //AEROPORTOS
        for (int i = 0; i < aeroportos.size(); i++) {

            avioesaux = aeroportos.get(aeroportos.select(i)).avioes;

            for (int j = 0; j < avioesaux.size(); j++) {

                viagensaux = avioesaux.get(avioesaux.select(j)).viagens;

                for (int k = 0; k < viagensaux.size(); k++) {

                    if (viagensaux.get(viagensaux.select(k)).getOrigem().getCodigoAeroporto().compareTo(codigo) == 0 || viagensaux.get(viagensaux.select(k)).getDestino().getCodigoAeroporto().compareTo(codigo) == 0) {

                        viagensaux.delete(viagensaux.get(viagensaux.select(k)).getDatavoo());

                    }

                }

            }

        }

        AssociateViagensofAvioestoMain(aeroportos, viagens);
        AssociateViagensMaintoAeroportos(aeroportos, viagens);

        //AVIOES
        for (String aeropkey : aeroportos.keys()) {

            Aeroporto aerop = aeroportos.get(aeropkey);

            for (Integer akey : aerop.avioes.keys()) {

                if (aerop.avioes.get(akey).getCodigoAeroporto().compareTo(codigo) == 0) {

                    aerop.avioes.delete(akey);

                }

            }

        }

        AssociateAvioesofAeroportotoMain(aeroportos, avioes);

        for (String aeropkey : aeroportos.keys()) {

            if (aeropkey.compareTo(codigo) == 0) {

                aeroportos.delete(aeropkey);

            }

        }

    }

    /**
     * @brief Função Editar aeroporto
     */
    public static void editAeroporto(String codigoaerop, String nome, String codigo, String cidade, String pais, String continente, float classificacao, double latitude, double longitude, RedBlackBST<String, Aeroporto> aeroportos, RedBlackBST<Date, Viagem> viagens) {

        /**
         * @details Função que editar aeroportos à BST dos aeroportos
         * @param String codigoaerop Chave do Aeroporto a editar
         * @param String nome
         * @param String codigo
         * @param String cidade
         * @param String pais
         * @param String continente
         * @param float classificacao
         * @param RedBlackBST<String,Aeroporto> aeroportos contém a BST de
         * aeroportos
         * @param RedBlackBST<Date,Viagens> viagens contém a BST de viagens
         */
        Aeroporto a = new Aeroporto(nome, codigo, cidade, pais, continente, classificacao, latitude, longitude);

        RedBlackBST<Date, Viagem> viagensaux = new RedBlackBST<>();
        RedBlackBST<Integer, Aviao> avioesaux = new RedBlackBST<>();

        for (int i = 0; i < aeroportos.size(); i++) {

            if (aeroportos.get(aeroportos.select(i)).getCodigoAeroporto().compareTo(codigoaerop) == 0) {

                avioesaux = aeroportos.get(aeroportos.select(i)).avioes;

                for (int j = 0; j < avioesaux.size(); j++) {

                    viagensaux = avioesaux.get(avioesaux.select(j)).viagens;

                    for (int k = 0; k < viagensaux.size(); k++) {

                        if (viagensaux.get(viagensaux.select(k)).getOrigem().getCodigoAeroporto().compareTo(codigoaerop) == 0) {

                            viagensaux.get(viagensaux.select(k)).setOrigem(a);

                        }

                        if (viagensaux.get(viagensaux.select(k)).getDestino().getCodigoAeroporto().compareTo(codigoaerop) == 0) {

                            viagensaux.get(viagensaux.select(k)).setDestino(a);

                        }

                    }

                    avioesaux.get(avioesaux.select(j)).setCodigoAeroporto(codigo);

                }

                aeroportos.get(aeroportos.select(i)).setCodigoAeroporto(codigo);
                aeroportos.get(aeroportos.select(i)).setCidade(cidade);
                aeroportos.get(aeroportos.select(i)).setClassificacao(classificacao);
                aeroportos.get(aeroportos.select(i)).setContinente(continente);
                aeroportos.get(aeroportos.select(i)).setNomeAeroporto(nome);
                aeroportos.get(aeroportos.select(i)).setPais(pais);
                aeroportos.get(aeroportos.select(i)).setLatitude(latitude);
                aeroportos.get(aeroportos.select(i)).setLongitude(longitude);

            }

        }

        AssociateViagensMaintoAeroportos(aeroportos, viagens);

    }

    /**
     * @brief Função Carregar Aeroportos do ficheiro
     */
    public static void loadAeroportoFromAFile(RedBlackBST<String, Aeroporto> aeroportos) throws IOException {

        /**
         * @details Função que carregas os aeroportos na BST dos aeroportos
         * @param RedBlackBST<String,Aeroporto> aeroportos contém a BST de
         * aeroportos
         * @throws IOException
         */
        BufferedReader br = new BufferedReader(new FileReader("airports.txt"));
        String line = null;

        while ((line = br.readLine()) != null) {

            String lines[] = line.split(";");
            String nome = lines[0];
            String codigo = lines[1];
            String cidade = lines[2];
            String pais = lines[3];
            String continente = lines[4];
            float classificacao = Float.parseFloat(lines[5]);
            double latitude = Double.parseDouble(lines[6]);
            double longitude = Double.parseDouble(lines[7]);

            Aeroporto a = new Aeroporto(nome, codigo, cidade, pais, continente, classificacao, latitude, longitude);

            aeroportos.put(codigo, a);

        }

        br.close();

    }

    /**
     * @brief Função Carregar Aviões de um ficheiro
     */
    public static void loadAviaoFromAFile(RedBlackBST<String, Aeroporto> aeroportos, RedBlackBST<Integer, Aviao> avioes) throws IOException {
        /**
         * @details Função que carrega os avioes na BST presente no Aeroporto
         * @throw IOEsception
         */

        BufferedReader br = new BufferedReader(new FileReader("airplanes.txt"));
        String line = null;
        int i = 0;

        while ((line = br.readLine()) != null) {

            String lines[] = line.split(";");
            int id = Integer.parseInt(lines[0]);
            String modelo = lines[1];
            String nome = lines[2];
            String comanhiaaerea = lines[3];
            int velocidadecruz = Integer.parseInt(lines[4]);
            int altitudecruz = Integer.parseInt(lines[5]);
            int distanciamax = Integer.parseInt(lines[6]);
            String codaeroporto = lines[7];
            int capacidadepass = Integer.parseInt(lines[8]);
            int capacidadedep = Integer.parseInt(lines[9]);

            Aviao a = new Aviao(id, modelo, nome, comanhiaaerea, velocidadecruz, altitudecruz, distanciamax, codaeroporto, capacidadepass, capacidadedep);

            for (String key : aeroportos.keys()) {

                if (a.getCodigoAeroporto().compareTo(key) == 0) {

                    avioes.put(a.getIdAviao(), a);

                }

            }

        }

        AssociateAvioesofMaintoAeroporto(aeroportos, avioes);
        br.close();

    }

    /**
     * @brief Função associar avioes do aeroporto ao main
     */
    public static void AssociateAvioesofAeroportotoMain(RedBlackBST<String, Aeroporto> aeroportos, RedBlackBST<Integer, Aviao> avioes) {

        /**
         * @details Função associadora de avioes do aeroporto à Bst do MAIN
         * @param RedBlackBST<String,Aeroporto> aeroportos contém a BST de
         * aeroportos
         * @param RedBlackBST<Integer,Aviao> avioes contém a BST de avioes
         */
        RedBlackBST<Integer, Aviao> avioesaux = new RedBlackBST<>();

        for (Integer keyaviao : avioes.keys()) {

            avioes.delete(keyaviao);

        }

        for (String keyaerop : aeroportos.keys()) {

            Aeroporto aerop = aeroportos.get(keyaerop);

            for (Integer keyaviao : aerop.avioes.keys()) {

                Aviao a = aerop.avioes.get(keyaviao);
                avioes.put(keyaviao, a);

            }

        }

    }

    /**
     * @brief Função associar aviões à bst nos aeroportos
     */
    public static void AssociateAvioesofMaintoAeroporto(RedBlackBST<String, Aeroporto> aeroportos, RedBlackBST<Integer, Aviao> avioes) {

        /**
         * @details Função associadora de avioes à Bst de avioes do aeroporto
         * @param RedBlackBST<String,Aeroporto> aeroportos contém a BST de
         * aeroportos
         * @param RedBlackBST<Integer,Aviao> avioes contém a BST de avioes
         */
        RedBlackBST<Integer, Aviao> avioesaux = new RedBlackBST<>();

        for (String keyaerop : aeroportos.keys()) {

            Aeroporto aerop = aeroportos.get(keyaerop);

            for (Integer keyaviao : aerop.avioes.keys()) {

                aerop.avioes.delete(keyaviao);

            }

        }

        for (Integer keyaviao : avioes.keys()) {

            Aviao a = avioes.get(keyaviao);

            for (String keyaerop : aeroportos.keys()) {

                Aeroporto aerop = aeroportos.get(keyaerop);

                if (a.getCodigoAeroporto().compareTo(keyaerop) == 0) {

                    aeroportos.get(keyaerop).avioes.put(keyaviao, a);

                }

            }

        }

    }

    /**
     * @brief Função Imprimir Aeroportos
     */
    public static void printAeroportos(RedBlackBST<String, Aeroporto> aeroportos) {

        /**
         * @details Função que imprime os aeroportos todos
         * @param RedBlackBST<String,Aeroporto> aeroportos contém a BST de
         * aeroportos
         */
        if (aeroportos.size() != 0) {

            for (int i = 0; i < aeroportos.size(); i++) {

                System.out.println(aeroportos.get(aeroportos.select(i)));

            }

        } else {

            System.out.println("NAO HÁ AEROPORTOS PARA IMPRIMIR!!!");

        }

    }

    /**
     * @brief Função Imprimir Aeroporto
     */
    public static void printAeroporto(String codigo, RedBlackBST<String, Aeroporto> aeroportos) {

        /**
         * @details Função que imprime o aeroporto com codigo fornecido
         * @param RedBlackBST<String,Aeroporto> aeroportos contém a BST de
         * aeroportos
         */
        for (int i = 0; i < aeroportos.size(); i++) {

            if (aeroportos.get(aeroportos.select(i)).getCodigoAeroporto().compareTo(codigo) == 0) {

                System.out.println(aeroportos.get(aeroportos.select(i)));
                return;

            }

        }

        System.out.println("O AEROPORTO NAO FOI ENCONTRADO");

    }

    /**
     * @brief Função Imprimir Aeroporto de pais ou continente
     */
    public static void printAeoroportoPais(String paiscontinente, RedBlackBST<String, Aeroporto> aeroportos) {

        /**
         * @details Função que imprime um aeroporto de um determinado pais ou
         * continente passado por parametro
         * @param String paiscontinente recebe um pais ou continente
         * @param RedBlackBST<String,Aeroporto> aeroportos contém a BST de
         * aeroportos
         */
        for (int i = 0; i < aeroportos.size(); i++) {

            if (aeroportos.get(aeroportos.select(i)).getPais().compareTo(paiscontinente) == 0 || aeroportos.get(aeroportos.select(i)).getContinente().compareTo(paiscontinente) == 0) {

                System.out.println(aeroportos.get(aeroportos.select(i)));

            }

        }

    }

    /**
     * @brief Função Imprimir Avioes do Main
     */
    public static void printAvioesofMain(RedBlackBST<Integer, Aviao> avioes) {

        /**
         * @details Função que imprime todos os avioes do MAIN
         * @param RedBlackBST<Integer,Aviao> avioes contém a BST de avioes
         */
        for (Integer keyaviao : avioes.keys()) {

            Aviao a = avioes.get(keyaviao);

            System.out.println(a);

        }

    }

    /**
     * @brief Função Imprimir Avioes
     */
    public static void printAvioes(RedBlackBST<String, Aeroporto> aeroportos) {

        /**
         * @details Função que imprime todos os avioes
         * @param RedBlackBST<String,Aeroporto> aeroportos contém a BST de
         * aeroportos
         */
        RedBlackBST<Integer, Aviao> avioesaux = new RedBlackBST<>();

        for (int i = 0; i < aeroportos.size(); i++) {

            avioesaux = aeroportos.get(aeroportos.select(i)).avioes;

            for (int j = 0; j < avioesaux.size(); j++) {

                System.out.println(avioesaux.get(avioesaux.select(j)));

            }

        }

    }

    /**
     * @brief Função Imprimir Aviao
     */
    public static void printAviao(String nome, RedBlackBST<String, Aeroporto> aeroportos) {

        /**
         * @details Função que imprime um aviao com um determinado nome passado
         * por prametro
         * @param String nome Nome do aviao
         * @param RedBlackBST<String,Aeroporto> aeroportos contém a BST de
         * aeroportos
         */
        RedBlackBST<Integer, Aviao> avioesaux = new RedBlackBST<>();

        for (int i = 0; i < aeroportos.size(); i++) {

            avioesaux = aeroportos.get(aeroportos.select(i)).avioes;

            for (int j = 0; j < avioesaux.size(); j++) {

                if (avioesaux.get(avioesaux.select(j)).getNome().compareTo(nome) == 0) {

                    System.out.println(avioesaux.get(avioesaux.select(j)));
                    return;

                }

            }

        }

        System.out.println("O AVIAO NAO EXISTE!!!");

    }

    /**
     * @brief Função Imprimir Viagens dos Aeroportos
     */
    public static void printViagensAeroportos(RedBlackBST<String, Aeroporto> aeroportos) {

        /**
         * @details Função que imprime viagens de todos os Aeroportos
         * (utilizando a BST de viagens da classe AEROPORTO)
         * @param RedBlackBST<String,Aeroporto> aeroportos contém a BST de
         * aeroportos
         */
        RedBlackBST<Date, Viagem> viagensaux = new RedBlackBST<>();

        for (int i = 0; i < aeroportos.size(); i++) {

            viagensaux = aeroportos.get(aeroportos.select(i)).viagens;

            for (int j = 0; j < viagensaux.size(); j++) {

                System.out.println(viagensaux.get(viagensaux.select(j)));

            }

        }

    }

    /**
     * @brief Função Imprimir Viagens com Origem/destino
     */
    public static void printViagemwithorigemordestino(String nome, RedBlackBST<String, Aeroporto> aeroportos) {

        /**
         * @details Função que imprime viagens com Origem ou Destino num
         * aeroporto passado por parametro
         * @param String nome Nome do aeroporto
         * @param RedBlackBST<String,Aeroporto> aeroportos contém a BST de
         * aeroportos
         */
        RedBlackBST<Date, Viagem> viagensaux = new RedBlackBST<>();
        RedBlackBST<Integer, Aviao> avioesaux = new RedBlackBST<>();

        for (int i = 0; i < aeroportos.size(); i++) {

            avioesaux = aeroportos.get(aeroportos.select(i)).avioes;

            for (int j = 0; j < avioesaux.size(); j++) {

                viagensaux = avioesaux.get(avioesaux.select(j)).viagens;

                for (int k = 0; k < viagensaux.size(); k++) {

                    if (viagensaux.get(viagensaux.select(k)).getOrigem().getCodigoAeroporto().compareTo(nome) == 0 || viagensaux.get(viagensaux.select(k)).getDestino().getCodigoAeroporto().compareTo(nome) == 0) {

                        System.out.println(viagensaux.get(viagensaux.select(k)));

                    }
                }

            }

        }

    }

    /**
     * @brief Função Imprimir Viagens de um aviao
     */
    public static void printViagemAviao(String nome, RedBlackBST<String, Aeroporto> aeroportos) {

        /**
         * @details Função que imprime viagens de um determinado aviao passado
         * por param.
         * @param String nome Nome do aviao
         * @param RedBlackBST<String,Aeroporto> aeroportos contém a BST de
         * aeroportos
         */
        RedBlackBST<Date, Viagem> viagensaux = new RedBlackBST<>();
        RedBlackBST<Integer, Aviao> avioesaux = new RedBlackBST<>();

        for (int i = 0; i < aeroportos.size(); i++) {

            avioesaux = aeroportos.get(aeroportos.select(i)).avioes;

            for (int j = 0; j < avioesaux.size(); j++) {

                if (avioesaux.get(avioesaux.select(j)).getNome().compareTo(nome) == 0) {

                    viagensaux = avioesaux.get(avioesaux.select(j)).viagens;

                    for (int k = 0; k < viagensaux.size(); k++) {

                        System.out.println(viagensaux.get(viagensaux.select(k)));

                    }

                }

            }

        }

    }

    /**
     * @brief Função Imprimir TODAS as Viagens
     */
    public static void printViagensAvioes(RedBlackBST<String, Aeroporto> aeroportos) {

        /**
         * @details Função que imprime todas as viagens de todos os avioes (BST
         * da classe AVIAO)
         * @param RedBlackBST<String,Aeroporto> aeroportos contém a BST de
         * aeroportos
         */
        RedBlackBST<Date, Viagem> viagensaux = new RedBlackBST<>();
        RedBlackBST<Integer, Aviao> avioesaux = new RedBlackBST<>();

        for (int i = 0; i < aeroportos.size(); i++) {

            avioesaux = aeroportos.get(aeroportos.select(i)).avioes;

            for (int j = 0; j < avioesaux.size(); j++) {

                viagensaux = avioesaux.get(avioesaux.select(j)).viagens;

                for (int k = 0; k < viagensaux.size(); k++) {

                    System.out.println(viagensaux.get(viagensaux.select(k)));

                }

            }

        }

    }

    /**
     * @brief Função Imprimir Viagens entre 2as Datas
     */
    public static void printViagensBetweenDates(Date d1, Date d2, RedBlackBST<String, Aeroporto> aeroportos) {

        /**
         * @details Função que imprime todas as viagens entre um intervalo de
         * datas
         * @param Date d1 Data da primeira viagem do intervalo
         * @param Date d2 Data da ultima viagem do intervalo
         * @param RedBlackBST<String,Aeroporto> aeroportos contém a BST de
         * aeroportos
         */
        RedBlackBST<Date, Viagem> viagensaux = new RedBlackBST<>();
        RedBlackBST<Integer, Aviao> avioesaux = new RedBlackBST<>();

        for (int i = 0; i < aeroportos.size(); i++) {

            avioesaux = aeroportos.get(aeroportos.select(i)).avioes;

            for (int j = 0; j < avioesaux.size(); j++) {

                viagensaux = avioesaux.get(avioesaux.select(j)).viagens;

                for (int k = 0; k < viagensaux.size(); k++) {

                    if (viagensaux.get(viagensaux.select(k)).getDatavoo().compareTo(d1) >= 0 && viagensaux.get(viagensaux.select(k)).getDatavoo().compareTo(d2) == -1) {

                        System.out.println(viagensaux.get(viagensaux.select(k)));

                    }

                }

            }

        }

    }

    public static void printViagensBetweenDates1(Date d1, Date d2, RedBlackBST<Date, Viagem> viagens) {
        for (Date d : viagens.keys(d1, d2)) {

        }
    }

    /**
     * @brief Função Imprimir Aeroporto com mais Viagens
     */
    public static void printAeroportoWithMoreTrafego(RedBlackBST<String, Aeroporto> aeroportos) {

        /**
         * @details Função que imprime o aeroporto que possui mais viagens
         * @param RedBlackBST<String,Aeroporto> aeroportos contém a BST de
         * aeroportos
         */
        RedBlackBST<Date, Viagem> viagensaux = new RedBlackBST<>();
        RedBlackBST<Integer, Aviao> avioesaux = new RedBlackBST<>();

        int cont = 0;
        int maxcont = 0;
        int aerop = 0;

        for (int i = 0; i < aeroportos.size(); i++) {

            viagensaux = aeroportos.get(aeroportos.select(i)).viagens;

            //for(int j=0; j<avioesaux.size(); j++){
            // viagensaux=avioesaux.get(avioesaux.select(j)).viagens;
            if (viagensaux.size() > 0) {

                for (int k = 0; k < viagensaux.size(); k++) {

                    cont++;

                }

                if (cont > maxcont) {

                    maxcont = cont;
                    aerop = i;

                }
                cont = 0;

            }
            //}
        }

        if (maxcont == 0) {

            System.out.println("NAO HÁ VIAGENS!!");

        } else {

            System.out.println(aeroportos.get(aeroportos.select(aerop)));
        }

    }

    /**
     * @brief Função Imprimir Viagem com mais passageiros
     */
    public static void printViagemWithMorePassageiros(RedBlackBST<String, Aeroporto> aeroportos) {

        /**
         * @details Função que imprime viagem que transportou mais passageiros
         * @param RedBlackBST<String,Aeroporto> aeroportos contém a BST de
         * aeroportos
         */
        RedBlackBST<Date, Viagem> viagensaux = new RedBlackBST<>();
        RedBlackBST<Integer, Aviao> avioesaux = new RedBlackBST<>();
        Viagem voo = new Viagem();

        int maxlot = -1;
        int lot = 0;
        int aerop = 0;

        for (int i = 0; i < aeroportos.size(); i++) {

            avioesaux = aeroportos.get(aeroportos.select(i)).avioes;

            for (int j = 0; j < avioesaux.size(); j++) {

                viagensaux = avioesaux.get(avioesaux.select(j)).viagens;

                if (viagensaux.size() > 0) {

                    for (int k = 0; k < viagensaux.size(); k++) {

                        lot = viagensaux.get(viagensaux.select(k)).getLotacao();

                        if (i == 0 && k == 0) {

                            maxlot = lot;
                            voo = viagensaux.get(viagensaux.select(k));
                            aerop = i;

                        } else {

                            if (lot > maxlot) {

                                maxlot = lot;
                                voo = viagensaux.get(viagensaux.select(k));
                                aerop = i;

                            }

                        }

                    }

                }
            }
        }

        if (maxlot == -1) {

            System.out.println("NAO HÁ VIAGENS!!");

        } else {
            System.out.println(voo);
//System.out.println(viagensaux.get(viagensaux.select(voo)));
        }

    }

    /**
     * @brief Função Imprimir Aerop com mais passageiros
     */
    public static void printAeropWithMorePassageiros(RedBlackBST<String, Aeroporto> aeroportos) {

        /**
         * @details Função que imprime Aerop. com mais passageiros a viajar
         * @param RedBlackBST<String,Aeroporto> aeroportos contém a BST de
         * aeroportos
         */
        //VER COM BST DE VIAGENS NO AEROPORTO
        RedBlackBST<Date, Viagem> viagensaux = new RedBlackBST<>();
        RedBlackBST<Integer, Aviao> avioesaux = new RedBlackBST<>();

        int maxlot = -1;
        int lot = 0;
        int aerop = 0;

        for (int i = 0; i < aeroportos.size(); i++) {

            avioesaux = aeroportos.get(aeroportos.select(i)).avioes;

            for (int j = 0; j < avioesaux.size(); j++) {

                viagensaux = avioesaux.get(avioesaux.select(j)).viagens;

                if (viagensaux.size() > 0) {

                    for (int k = 0; k < viagensaux.size(); k++) {

                        lot = lot + viagensaux.get(viagensaux.select(k)).getLotacao();

                    }

                    if (lot > maxlot) {

                        maxlot = lot;
                        aerop = i;

                    }

                    lot = 0;

                }

            }

        }

        if (maxlot == -1) {

            System.out.println("NAO HÁ VIAGENS!!");

        } else {

            System.out.println(aeroportos.get(aeroportos.select(aerop)));

        }

    }

}

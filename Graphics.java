/*
    @Graphics LP2
    @author Rui Moreira, Christophe Soares, Ana Ribeiro Gomes
    @Tiago Martins 24440, Goncalo Silva 26329
    @version 2.0
    @date 2017
 */
package edu.ufp.inf.lp2.projeto17;

import edu.princeton.cs.algs4.RedBlackBST;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.geom.Line2D;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.geom.Ellipse2D;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * \brief Classe Graphics
 */
public class Graphics extends javax.swing.JFrame {

    Main m = new Main();

    /**
     * @brief Função Graphics
     *
     */
    public Graphics() throws IOException {
        initComponents();

        // primeira vez carrega do ficheiro e imprime
        try {
            Main.loadAeroportoFromAFile(m.aeroportos);
        } catch (IOException ex) {
            Logger.getLogger(Graphics.class.getName()).log(Level.SEVERE, null, ex);
        }
        Main.loadAviaoFromAFile(m.aeroportos, m.avioes);

        m.addViagem(new Date(18, 2, 2017, 10, 20, 12), m.aeroportos.get("OPO"), m.aeroportos.get("AMS"), m.aeroportos.get("OPO").avioes.get(1), 90, 1000f, 2000f, 30000f, m.aeroportos, m.viagens, m.avioes);
        m.addViagem(new Date(20, 2, 2017, 11, 21, 22), m.aeroportos.get("AMS"), m.aeroportos.get("LGW"), m.aeroportos.get("AMS").avioes.get(1), 90, 1000f, 2000f, 30000f, m.aeroportos, m.viagens, m.avioes);
        m.addViagem(new Date(27, 2, 2017, 23, 12, 12), m.aeroportos.get("OPO"), m.aeroportos.get("REC"), m.aeroportos.get("OPO").avioes.get(2), 90, 1000f, 2000f, 30000f, m.aeroportos, m.viagens, m.avioes);
        m.addViagem(new Date(17, 3, 2017, 4, 4, 12), m.aeroportos.get("SCL"), m.aeroportos.get("OPO"), m.aeroportos.get("SCL").avioes.get(5), 170, 1000f, 2000f, 50000f, m.aeroportos, m.viagens, m.avioes);
        m.addViagem(new Date(10, 1, 2017, 10, 59, 8), m.aeroportos.get("LGW"), m.aeroportos.get("OPO"), m.aeroportos.get("LGW").avioes.get(7), 150, 1000f, 2000f, 60000f, m.aeroportos, m.viagens, m.avioes);
        m.addViagem(new Date(27, 2, 2017, 18, 19, 8), m.aeroportos.get("REC"), m.aeroportos.get("FCO"), m.aeroportos.get("REC").avioes.get(8), 80, 1000f, 2000f, 70000f, m.aeroportos, m.viagens, m.avioes);

        DefaultTableModel model = (DefaultTableModel) jTableAerop.getModel();
        Object rowData[] = new Object[8];

        for (String aerop : m.aeroportos.keys()) {
            Aeroporto a = m.aeroportos.get(aerop);
            rowData[0] = a.getNomeAeroporto();
            rowData[1] = a.getCodigoAeroporto();
            rowData[2] = a.getCidade();
            rowData[3] = a.getPais();
            rowData[4] = a.getContinente();
            rowData[5] = a.getClassificacao();
            rowData[6] = a.getLatitude();
            rowData[7] = a.getLongitude();
            model.addRow(rowData);
        }

        DefaultTableModel modelaviao = (DefaultTableModel) jTableAvioes.getModel();
        Object rowDataavi[] = new Object[10];

        for (int avi : m.avioes.keys()) {
            Aviao a = m.avioes.get(avi);
            rowDataavi[0] = a.getIdAviao();
            rowDataavi[1] = a.getModelo();
            rowDataavi[2] = a.getNome();
            rowDataavi[3] = a.getCompanhiaAerea();
            rowDataavi[4] = a.getVelocidadeCruzeiro();
            rowDataavi[5] = a.getAltitudeCruzeiro();
            rowDataavi[6] = a.getDistanciaMaxima();
            rowDataavi[7] = a.getCodigoAeroporto();
            rowDataavi[8] = a.getCapacidadePassageiro();
            rowDataavi[9] = a.getCapacidadeDeposito();
            modelaviao.addRow(rowDataavi);
        }

        DefaultTableModel modelviagens = (DefaultTableModel) jTableViagens.getModel();
        Object rowDatavia[] = new Object[8];

        for (Date via : m.viagens.keys()) {
            Viagem v = m.viagens.get(via);
            rowDatavia[0] = String.valueOf(v.getDatavoo());
            rowDatavia[1] = v.getOrigem().getCodigoAeroporto();
            rowDatavia[2] = v.getDestino().getCodigoAeroporto();
            rowDatavia[3] = v.getAviao().getIdAviao();
            rowDatavia[4] = v.getLotacao();
            rowDatavia[5] = v.getCustoMonetario();
            rowDatavia[6] = v.getCustoTemporal();
            rowDatavia[7] = v.getCustoTotal();
            modelviagens.addRow(rowDatavia);
        }

        //ESCONDER OBJETOS
        editAeropInVisible();
        removeAeropInVisible();
        addAeropInVisible();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableAvioes = new javax.swing.JTable();
        jTextFieldIdAviao = new javax.swing.JTextField();
        jTextFieldModeloAviao = new javax.swing.JTextField();
        jTextFieldNomeAviao = new javax.swing.JTextField();
        jTextFieldCompanhiaAereaAviao = new javax.swing.JTextField();
        jTextFieldVelCruzAviao = new javax.swing.JTextField();
        jTextFieldAltCruzAviao = new javax.swing.JTextField();
        jTextFieldDistMaxAviao = new javax.swing.JTextField();
        jTextFieldCodAeropAviao = new javax.swing.JTextField();
        jTextFieldCapPassAviao = new javax.swing.JTextField();
        jTextFieldCapacDepAviao = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jButtonEditAviao = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jTextFieldNomeOldAviao = new javax.swing.JTextField();
        jButtonAviaoadd = new javax.swing.JButton();
        jTextFieldCapacDepAviaoadd = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTextFieldCapPassAviaoadd = new javax.swing.JTextField();
        jTextFieldCodAeropAviaoadd = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jTextFieldDistMaxAviaoadd = new javax.swing.JTextField();
        jTextFieldAltCruzAviaoadd = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jTextFieldVelCruzAviaoadd = new javax.swing.JTextField();
        jTextFieldCompanhiaAereaAviaoadd = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jTextFieldNomeAviaoadd = new javax.swing.JTextField();
        jTextFieldModeloAviaoadd = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jTextFieldIdAviaoadd = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jTextFieldAviaoRemov = new javax.swing.JTextField();
        jButtonRemovAviao = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        showaerop = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAerop = new javax.swing.JTable();
        editaerop = new javax.swing.JButton();
        jButtonRemovAerop = new javax.swing.JButton();
        jTextFieldNomeAeropNewEdit = new javax.swing.JTextField();
        jTextFieldcodAeropNewEdit = new javax.swing.JTextField();
        jTextFieldCidadeAeropNewEdit = new javax.swing.JTextField();
        jTextFieldPaisAeropNewEdit = new javax.swing.JTextField();
        jTextFieldContinenteAeropNewEdit = new javax.swing.JTextField();
        jTextFieldClassificAeropNewEdit = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldcodAeropOldEdit = new javax.swing.JTextField();
        jButtonEditAeropvalidate = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldCodAeropRemove = new javax.swing.JTextField();
        jButtonRemoveAerop = new javax.swing.JButton();
        jButtonAddaeropSeparator = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldcodAeropAdd = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldNomeAeropAdd = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldCidadeAeropAdd = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldPaisAeropAdd = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldContinenteAeropAdd = new javax.swing.JTextField();
        jTextFieldClassificAeropAdd = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jButtonaddAerop = new javax.swing.JButton();
        jTextFieldLatitudeAeropNewEdit = new javax.swing.JTextField();
        jTextFieldLongitudeAeropNewEdit = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jTextFieldLatitudeAeropAdd = new javax.swing.JTextField();
        jTextFieldLongitudeAeropAdd = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableViagens = new javax.swing.JTable();
        jLabel38 = new javax.swing.JLabel();
        jTextFieldAeropOrigemEdit = new javax.swing.JTextField();
        jTextFieldAeropDestinoEdit = new javax.swing.JTextField();
        jTextFieldAviaoEdit = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jTextFieldLotacaoEdit = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jTextFieldCustomonEdit = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jTextFieldCustotempEdit = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jTextFieldCustoTotalEdit = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jButtonAddviagem = new javax.swing.JButton();
        jLabel54 = new javax.swing.JLabel();
        jTextFieldDiaViagemEdit = new javax.swing.JTextField();
        jTextFieldMesViagemEdit = new javax.swing.JTextField();
        jTextFieldAnoViagemEdit = new javax.swing.JTextField();
        jTextFieldMinutoViagemEdit = new javax.swing.JTextField();
        jTextFieldHoraViagemEdit = new javax.swing.JTextField();
        jButtonRemoveViagem = new javax.swing.JButton();
        jTextFieldSegundoViagemEdit = new javax.swing.JTextField();
        jTextFieldAnoViagemEdit1 = new javax.swing.JTextField();
        jTextFieldSegundoViagemEdit1 = new javax.swing.JTextField();
        jTextFieldMinutoViagemEdit1 = new javax.swing.JTextField();
        jTextFieldMesViagemEdit1 = new javax.swing.JTextField();
        jTextFieldDiaViagemEdit1 = new javax.swing.JTextField();
        jTextFieldHoraViagemEdit1 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jTextFieldSegundoViagemAdd = new javax.swing.JTextField();
        jTextFieldDiaViagemAdd = new javax.swing.JTextField();
        jTextFieldMesViagemAdd = new javax.swing.JTextField();
        jTextFieldAnoViagemAdd = new javax.swing.JTextField();
        jTextFieldMinutoViagemAdd = new javax.swing.JTextField();
        jTextFieldHoraViagemAdd = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jTextFieldAeropOrigemAdd = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jTextFieldAeropDestinoAdd = new javax.swing.JTextField();
        jTextFieldAviaoAdd = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jTextFieldLotacaoAdd = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jTextFieldCustomonAdd = new javax.swing.JTextField();
        jTextFieldCustotempAdd = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jTextFieldCustoTotalAdd = new javax.swing.JTextField();
        jButtonEditViagem = new javax.swing.JButton();
        jTextFieldDiaViagemRem = new javax.swing.JTextField();
        jTextFieldMesViagemRem = new javax.swing.JTextField();
        jTextFieldAnoViagemRem = new javax.swing.JTextField();
        jTextFieldSegundoViagemRem = new javax.swing.JTextField();
        jTextFieldMinutoViagemRem = new javax.swing.JTextField();
        jTextFieldHoraViagemRem = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableAvioes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Aviao", "Modelo", "Nome", "Companhia Aerea", "Velocidade Cruzeiro", "Altitude Cruzeiro", "Distancia Maxima", "Cod Aerop", " Capacidade Passageiro", "Capacidade Deposito"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAvioes.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableAvioes);

        jTextFieldModeloAviao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldModeloAviaoActionPerformed(evt);
            }
        });

        jLabel16.setText("id");

        jLabel17.setText("Modelo");

        jLabel18.setText("Vel. Cruzeiro");

        jLabel19.setText("Nome");

        jLabel20.setText("Companhia Aerea");

        jLabel21.setText("Alt. Cruz");

        jLabel22.setText("Dist. Max.");

        jLabel23.setText("Cod Aerop");

        jLabel24.setText("Capac. Pass.");

        jLabel25.setText("Capac. Dep.");

        jButtonEditAviao.setText("EDITAR");
        jButtonEditAviao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditAviaoActionPerformed(evt);
            }
        });

        jLabel26.setText("Nome ANTIGO");

        jButtonAviaoadd.setText("ADICIONAR");
        jButtonAviaoadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAviaoaddActionPerformed(evt);
            }
        });

        jLabel27.setText("Capac. Dep.");

        jLabel28.setText("Capac. Pass.");

        jLabel29.setText("Cod Aerop");

        jLabel30.setText("Dist. Max.");

        jLabel31.setText("Alt. Cruz");

        jLabel32.setText("Vel. Cruzeiro");

        jLabel33.setText("Companhia Aerea");

        jLabel34.setText("Nome");

        jTextFieldModeloAviaoadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldModeloAviaoaddActionPerformed(evt);
            }
        });

        jLabel35.setText("Modelo");

        jLabel36.setText("id");

        jLabel37.setText("Nome REMOVER");

        jButtonRemovAviao.setText("REMOVER");
        jButtonRemovAviao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemovAviaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldIdAviaoadd)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextFieldModeloAviaoadd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNomeAviaoadd, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(jTextFieldCompanhiaAereaAviaoadd, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldVelCruzAviaoadd, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldAltCruzAviaoadd, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldDistMaxAviaoadd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jTextFieldCodAeropAviaoadd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel27))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextFieldCapPassAviaoadd, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldCapacDepAviaoadd, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAviaoadd))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNomeOldAviao, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldIdAviao)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(0, 180, Short.MAX_VALUE))
                            .addComponent(jTextFieldModeloAviao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNomeAviao, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jTextFieldCompanhiaAereaAviao, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldVelCruzAviao))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldAltCruzAviao))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldDistMaxAviao))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jTextFieldCodAeropAviao, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel25))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextFieldCapPassAviao, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldCapacDepAviao, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonEditAviao))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldAviaoRemov))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonRemovAviao)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldIdAviao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldModeloAviao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNomeAviao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCompanhiaAereaAviao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldVelCruzAviao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAltCruzAviao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDistMaxAviao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCodAeropAviao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCapPassAviao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCapacDepAviao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEditAviao)
                    .addComponent(jTextFieldNomeOldAviao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAviaoRemov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRemovAviao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel35)
                    .addComponent(jLabel34)
                    .addComponent(jLabel33)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel30)
                    .addComponent(jLabel29)
                    .addComponent(jLabel28)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldIdAviaoadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldModeloAviaoadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNomeAviaoadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCompanhiaAereaAviaoadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldVelCruzAviaoadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAltCruzAviaoadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDistMaxAviaoadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCodAeropAviaoadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCapPassAviaoadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCapacDepAviaoadd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAviaoadd))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("AVIOES", jPanel2);

        jLabel1.setText("AEROPORTOS");

        showaerop.setText("MOSTRAR AEROPORTOS");
        showaerop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showaeropActionPerformed(evt);
            }
        });

        jTableAerop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome Aerop.", "Codigo Aerop.", "Cidade", "Pais", "Continente", "Classificacao", "Latitude", "Longitude"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAerop.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableAerop);

        editaerop.setText("EDITAR AEROPORTO");
        editaerop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editaeropActionPerformed(evt);
            }
        });

        jButtonRemovAerop.setText("REMOVER AEROPORTO");
        jButtonRemovAerop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemovAeropActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome Aerop");

        jLabel3.setText("Cod Aerop NOVO");

        jLabel4.setText("Cidade NOVO");

        jLabel5.setText("Pais NOVO");

        jLabel6.setText("Continente NOVO");

        jLabel7.setText("Classificacao NOVO");

        jLabel8.setText("Cod Aerop A MUDAR");

        jButtonEditAeropvalidate.setText("EDITAR");
        jButtonEditAeropvalidate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditAeropvalidateActionPerformed(evt);
            }
        });

        jLabel9.setText("Cod Aerop A REMOVER");

        jButtonRemoveAerop.setText("REMOVER");
        jButtonRemoveAerop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveAeropActionPerformed(evt);
            }
        });

        jButtonAddaeropSeparator.setText("ADICIONAR AEROPORTO");
        jButtonAddaeropSeparator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddaeropSeparatorActionPerformed(evt);
            }
        });

        jLabel10.setText("Cod Aerop NOVO");

        jLabel11.setText("Nome Aerop");

        jLabel12.setText("Cidade NOVO");

        jLabel13.setText("Pais NOVO");

        jLabel14.setText("Continente NOVO");

        jLabel15.setText("Classificacao NOVO");

        jButtonaddAerop.setText("ADICIONAR");
        jButtonaddAerop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonaddAeropActionPerformed(evt);
            }
        });

        jLabel56.setText("Latitude");

        jLabel57.setText("Longitude");

        jTextFieldLatitudeAeropAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLatitudeAeropAddActionPerformed(evt);
            }
        });

        jLabel58.setText("Latitude");

        jLabel59.setText("Longitude");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(showaerop)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editaerop)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonRemovAerop)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonAddaeropSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel11))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jTextFieldCodAeropRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonRemoveAerop))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jTextFieldcodAeropAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(49, 49, 49)
                                                .addComponent(jTextFieldNomeAeropAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextFieldCidadeAeropAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel12))
                                                .addGap(35, 35, 35)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextFieldPaisAeropAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel13))))
                                        .addGap(36, 36, 36)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldContinenteAeropAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel14))
                                        .addGap(40, 40, 40)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jTextFieldClassificAeropAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(48, 48, 48)
                                                .addComponent(jTextFieldLatitudeAeropAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel15)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel58)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel59)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jTextFieldLongitudeAeropAdd)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButtonaddAerop)))))))
                        .addGap(11, 11, 11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jTextFieldcodAeropOldEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jTextFieldcodAeropNewEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldNomeAeropNewEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextFieldCidadeAeropNewEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldPaisAeropNewEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextFieldContinenteAeropNewEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldClassificAeropNewEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(52, 52, 52)
                                        .addComponent(jTextFieldLatitudeAeropNewEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(44, 44, 44)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel56)))
                                .addGap(18, 30, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextFieldLongitudeAeropNewEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonEditAeropvalidate))
                                    .addComponent(jLabel57))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showaerop)
                    .addComponent(editaerop)
                    .addComponent(jButtonRemovAerop)
                    .addComponent(jLabel1)
                    .addComponent(jButtonAddaeropSeparator))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel2)
                    .addComponent(jLabel56)
                    .addComponent(jLabel57))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldcodAeropNewEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCidadeAeropNewEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPaisAeropNewEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldContinenteAeropNewEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldClassificAeropNewEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldcodAeropOldEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEditAeropvalidate)
                    .addComponent(jTextFieldNomeAeropNewEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLatitudeAeropNewEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLongitudeAeropNewEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCodAeropRemove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRemoveAerop))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel11)
                    .addComponent(jLabel58)
                    .addComponent(jLabel59))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldcodAeropAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCidadeAeropAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldPaisAeropAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldContinenteAeropAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldClassificAeropAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonaddAerop)
                            .addComponent(jTextFieldLatitudeAeropAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldLongitudeAeropAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNomeAeropAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("AEROPORTOS", jPanel1);

        jTableViagens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data Voo", "Aerop. Origem", "Aerop. Destino", "Aviao", "lotacao", "Custo Monetario", "Custo Temporal", "Custo Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableViagens.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTableViagens);

        jLabel38.setText("Data da Viagem NOVA");

        jLabel41.setText("Aviao");

        jLabel42.setText("Lotacao");

        jLabel43.setText("Custo Monetario");

        jTextFieldCustotempEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCustotempEditActionPerformed(evt);
            }
        });

        jLabel44.setText("Custo Temporal");

        jLabel45.setText("Custo Total");

        jButtonAddviagem.setText("ADICIONAR");
        jButtonAddviagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddviagemActionPerformed(evt);
            }
        });

        jLabel54.setText("Data da Viagem ANTIGA");

        jButtonRemoveViagem.setText("REMOVER");
        jButtonRemoveViagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveViagemActionPerformed(evt);
            }
        });

        jLabel39.setText("Aerop. Origem");

        jLabel40.setText("Aerop. Destino");

        jLabel46.setText("Data da Viagem NOVA");

        jLabel47.setText("Aerop. Origem");

        jLabel48.setText("Aerop. Destino");

        jLabel49.setText("Aviao");

        jLabel50.setText("Lotacao");

        jLabel51.setText("Custo Monetario");

        jTextFieldCustotempAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCustotempAddActionPerformed(evt);
            }
        });

        jLabel52.setText("Custo Temporal");

        jLabel53.setText("Custo Total");

        jButtonEditViagem.setText("EDITAR");
        jButtonEditViagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditViagemActionPerformed(evt);
            }
        });

        jLabel55.setText("Data da Viagem NOVA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel54)
                        .addGap(102, 102, 102)
                        .addComponent(jButtonRemoveViagem)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1161, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jTextFieldDiaViagemEdit)
                                            .addComponent(jTextFieldHoraViagemEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextFieldMesViagemEdit)
                                            .addComponent(jTextFieldMinutoViagemEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldAnoViagemEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldSegundoViagemEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addComponent(jLabel38))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jTextFieldDiaViagemEdit1)
                                                    .addComponent(jTextFieldHoraViagemEdit1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jTextFieldMesViagemEdit1)
                                                    .addComponent(jTextFieldMinutoViagemEdit1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextFieldAnoViagemEdit1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextFieldSegundoViagemEdit1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(40, 40, 40)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jTextFieldAeropOrigemEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextFieldAeropDestinoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel39)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel40)))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addComponent(jLabel41)
                                                .addGap(26, 26, 26))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldAviaoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addComponent(jLabel42))
                                            .addComponent(jTextFieldLotacaoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextFieldCustomonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addComponent(jLabel46))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jTextFieldDiaViagemAdd)
                                                    .addComponent(jTextFieldHoraViagemAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jTextFieldMesViagemAdd)
                                                    .addComponent(jTextFieldMinutoViagemAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextFieldAnoViagemAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextFieldSegundoViagemAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(40, 40, 40)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jTextFieldAeropOrigemAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextFieldAeropDestinoAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel47)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel48)))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addComponent(jLabel49)
                                                .addGap(26, 26, 26))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldAviaoAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addComponent(jLabel50))
                                            .addComponent(jTextFieldLotacaoAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextFieldCustomonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(28, 28, 28)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextFieldCustotempAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(26, 26, 26)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel53)
                                            .addComponent(jTextFieldCustoTotalAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addComponent(jLabel55))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jTextFieldDiaViagemRem)
                                                    .addComponent(jTextFieldHoraViagemRem, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jTextFieldMesViagemRem)
                                                    .addComponent(jTextFieldMinutoViagemRem, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextFieldAnoViagemRem, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextFieldSegundoViagemRem, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextFieldCustotempEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(26, 26, 26)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel45)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jTextFieldCustoTotalEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButtonEditViagem))))
                                    .addComponent(jButtonAddviagem))
                                .addGap(49, 49, 49)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel38)
                                .addComponent(jLabel54))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel39)
                                .addComponent(jLabel40)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldDiaViagemEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldMesViagemEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldAnoViagemEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jTextFieldMinutoViagemEdit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldHoraViagemEdit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldSegundoViagemEdit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldDiaViagemEdit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldMesViagemEdit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldAnoViagemEdit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jTextFieldAeropOrigemEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldMinutoViagemEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldHoraViagemEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldSegundoViagemEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41)
                            .addComponent(jLabel42)
                            .addComponent(jLabel43)
                            .addComponent(jLabel44)
                            .addComponent(jLabel45))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldAeropDestinoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldAviaoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldLotacaoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCustomonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCustotempEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCustoTotalEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonEditViagem))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jButtonRemoveViagem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jLabel55)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldMinutoViagemRem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldHoraViagemRem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldSegundoViagemRem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldDiaViagemRem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldMesViagemRem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldAnoViagemRem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel47)
                                .addComponent(jLabel48)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(26, 26, 26)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldMinutoViagemAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldHoraViagemAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldSegundoViagemAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldDiaViagemAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldMesViagemAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldAnoViagemAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextFieldAeropOrigemAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49)
                            .addComponent(jLabel50)
                            .addComponent(jLabel51)
                            .addComponent(jLabel52)
                            .addComponent(jLabel53))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldAeropDestinoAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldAviaoAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldLotacaoAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCustomonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCustotempAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCustoTotalAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAddviagem))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("VIAGENS", jPanel3);

        jPanel4.setMaximumSize(new java.awt.Dimension(400, 400));
        jPanel4.setMinimumSize(new java.awt.Dimension(400, 400));
        jPanel4.setPreferredSize(new java.awt.Dimension(400, 400));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        jLabel61.setIcon(new javax.swing.ImageIcon("C:\\Users\\marti\\OneDrive\\NetBeansProjects\\lp2\\bgimage.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(534, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel61)
                .addGap(0, 288, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("GRAPH", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadTableAviao() {

        DefaultTableModel model = (DefaultTableModel) jTableAvioes.getModel();
        Object rowData[] = new Object[10];

        for (int avi : m.avioes.keys()) {
            Aviao a = m.avioes.get(avi);
            rowData[0] = a.getIdAviao();
            rowData[1] = a.getModelo();
            rowData[2] = a.getNome();
            rowData[3] = a.getCompanhiaAerea();
            rowData[4] = a.getVelocidadeCruzeiro();
            rowData[5] = a.getAltitudeCruzeiro();
            rowData[6] = a.getDistanciaMaxima();
            rowData[7] = a.getCodigoAeroporto();
            rowData[8] = a.getCapacidadePassageiro();
            rowData[9] = a.getCapacidadeDeposito();
            model.addRow(rowData);
        }

    }

    private void loadTableViagem() {

        DefaultTableModel modelviagens = (DefaultTableModel) jTableViagens.getModel();
        Object rowDatavia[] = new Object[8];

        for (Date via : m.viagens.keys()) {
            Viagem v = m.viagens.get(via);
            rowDatavia[0] = String.valueOf(v.getDatavoo());
            rowDatavia[1] = v.getOrigem().getCodigoAeroporto();
            rowDatavia[2] = v.getDestino().getCodigoAeroporto();
            rowDatavia[3] = v.getAviao().getIdAviao();
            rowDatavia[4] = v.getLotacao();
            rowDatavia[5] = v.getCustoMonetario();
            rowDatavia[6] = v.getCustoTemporal();
            rowDatavia[7] = v.getCustoTotal();
            modelviagens.addRow(rowDatavia);
        }

    }

    private void loadTable() {

        DefaultTableModel model = (DefaultTableModel) jTableAerop.getModel();
        Object rowData[] = new Object[8];

        for (String aerop : m.aeroportos.keys()) {
            Aeroporto a = m.aeroportos.get(aerop);
            rowData[0] = a.getNomeAeroporto();
            rowData[1] = a.getCodigoAeroporto();
            rowData[2] = a.getCidade();
            rowData[3] = a.getPais();
            rowData[4] = a.getContinente();
            rowData[5] = a.getClassificacao();
            rowData[6] = a.getLatitude();
            rowData[7] = a.getLongitude();
            model.addRow(rowData);
        }

    }

    private void clearTableAerop() {

        DefaultTableModel model = (DefaultTableModel) jTableAerop.getModel();

        while (model.getRowCount() > 0) {
            for (int i = 0; i < model.getRowCount(); i++) {

                model.removeRow(i);

            }
        }

    }

    private void clearTableViagem() {

        DefaultTableModel model = (DefaultTableModel) jTableViagens.getModel();

        while (model.getRowCount() > 0) {
            for (int i = 0; i < model.getRowCount(); i++) {

                model.removeRow(i);

            }
        }

    }

    private void clearTableAviao() {

        DefaultTableModel model = (DefaultTableModel) jTableAvioes.getModel();

        while (model.getRowCount() > 0) {
            for (int i = 0; i < model.getRowCount(); i++) {

                model.removeRow(i);

            }
        }

    }


    private void jTextFieldModeloAviaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldModeloAviaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldModeloAviaoActionPerformed

    private void jTextFieldModeloAviaoaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldModeloAviaoaddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldModeloAviaoaddActionPerformed

    private void jButtonEditAviaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditAviaoActionPerformed

        m.editAviao(jTextFieldNomeOldAviao.getText(), Integer.valueOf(jTextFieldIdAviao.getText()), jTextFieldModeloAviao.getText(), jTextFieldNomeAviao.getText(), jTextFieldCompanhiaAereaAviao.getText(), Integer.valueOf(jTextFieldVelCruzAviao.getText()), Integer.valueOf(jTextFieldAltCruzAviao.getText()), Integer.valueOf(jTextFieldDistMaxAviao.getText()), jTextFieldCodAeropAviao.getText(), Integer.valueOf(jTextFieldCapPassAviao.getText()), Integer.valueOf(jTextFieldCapacDepAviao.getText()), m.aeroportos, m.viagens);
        clearTableViagem();
        loadTableViagem();
        clearTableAerop();
        loadTable();
        clearTableAviao();
        loadTableAviao();
    }//GEN-LAST:event_jButtonEditAviaoActionPerformed

    private void jButtonRemovAviaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemovAviaoActionPerformed
        m.removeAviao(jTextFieldAviaoRemov.getText(), m.aeroportos, m.avioes, m.viagens);
        clearTableViagem();
        loadTableViagem();
        clearTableAerop();
        loadTable();
        clearTableAviao();
        loadTableAviao();
    }//GEN-LAST:event_jButtonRemovAviaoActionPerformed

    private void jButtonAviaoaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAviaoaddActionPerformed
        m.addAviao(Integer.valueOf(jTextFieldIdAviaoadd.getText()), jTextFieldModeloAviaoadd.getText(), jTextFieldNomeAviaoadd.getText(), jTextFieldCompanhiaAereaAviaoadd.getText(), Integer.valueOf(jTextFieldVelCruzAviaoadd.getText()), Integer.valueOf(jTextFieldAltCruzAviaoadd.getText()), Integer.valueOf(jTextFieldDistMaxAviaoadd.getText()), jTextFieldCodAeropAviaoadd.getText(), Integer.valueOf(jTextFieldCapPassAviaoadd.getText()), Integer.valueOf(jTextFieldCapacDepAviaoadd.getText()), m.aeroportos, m.avioes);
        clearTableViagem();
        loadTableViagem();
        clearTableAerop();
        loadTable();
        clearTableAviao();
        loadTableAviao();
    }//GEN-LAST:event_jButtonAviaoaddActionPerformed

    private void jButtonaddAeropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonaddAeropActionPerformed

        m.addAeroporto(jTextFieldNomeAeropAdd.getText(), jTextFieldcodAeropAdd.getText(), jTextFieldCidadeAeropAdd.getText(), jTextFieldPaisAeropAdd.getText(), jTextFieldContinenteAeropAdd.getText(), Float.valueOf(jTextFieldClassificAeropAdd.getText()), Double.valueOf(jTextFieldLatitudeAeropAdd.getText()), Double.valueOf(jTextFieldLongitudeAeropAdd.getText()), m.aeroportos);
        addAeropInVisible();
        clearTableViagem();
        loadTableViagem();
        clearTableAerop();
        loadTable();
        clearTableAviao();
        loadTableAviao();

    }//GEN-LAST:event_jButtonaddAeropActionPerformed

    private void jButtonAddaeropSeparatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddaeropSeparatorActionPerformed
        editAeropInVisible();
        removeAeropInVisible();
        addAeropVisible();
        clearTableViagem();
        loadTableViagem();
        clearTableAerop();
        loadTable();
        clearTableAviao();
        loadTableAviao();
    }//GEN-LAST:event_jButtonAddaeropSeparatorActionPerformed

    private void jButtonRemoveAeropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveAeropActionPerformed
        Main.removeAeroporto(jTextFieldCodAeropRemove.getText(), m.aeroportos, m.avioes, m.viagens);
        removeAeropInVisible();
        clearTableViagem();
        loadTableViagem();
        clearTableAerop();
        loadTable();
        clearTableAviao();
        loadTableAviao();
    }//GEN-LAST:event_jButtonRemoveAeropActionPerformed

    private void jButtonEditAeropvalidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditAeropvalidateActionPerformed

        Main.editAeroporto(jTextFieldcodAeropOldEdit.getText(), jTextFieldNomeAeropNewEdit.getText(), jTextFieldcodAeropNewEdit.getText(), jTextFieldCidadeAeropNewEdit.getText(), jTextFieldPaisAeropNewEdit.getText(), jTextFieldContinenteAeropNewEdit.getText(), Float.valueOf(jTextFieldClassificAeropNewEdit.getText()), Double.valueOf(jTextFieldLatitudeAeropNewEdit.getText()), Double.valueOf(jTextFieldLongitudeAeropNewEdit.getText()), m.aeroportos, m.viagens);

        editAeropInVisible();

        clearTableViagem();
        loadTableViagem();
        clearTableAerop();
        loadTable();
        clearTableAviao();
        loadTableAviao();

    }//GEN-LAST:event_jButtonEditAeropvalidateActionPerformed

    private void jButtonRemovAeropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemovAeropActionPerformed
        editAeropInVisible();
        removeAeropVisible();
        addAeropInVisible();

    }//GEN-LAST:event_jButtonRemovAeropActionPerformed

    private void editaeropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editaeropActionPerformed
        removeAeropInVisible();
        editAeropVisible();
        addAeropInVisible();

    }//GEN-LAST:event_editaeropActionPerformed

    private void showaeropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showaeropActionPerformed
        editAeropInVisible();
        removeAeropInVisible();
        clearTableAerop();
        loadTable();

    }//GEN-LAST:event_showaeropActionPerformed

    private void jTextFieldCustotempEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCustotempEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCustotempEditActionPerformed

    private void jButtonAddviagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddviagemActionPerformed
        m.addViagem(new Date(
                Integer.valueOf(jTextFieldDiaViagemAdd.getText()),
                Integer.valueOf(jTextFieldMesViagemAdd.getText()),
                Integer.valueOf(jTextFieldAnoViagemAdd.getText()),
                Integer.valueOf(jTextFieldHoraViagemAdd.getText()),
                Integer.valueOf(jTextFieldMinutoViagemAdd.getText()),
                Integer.valueOf(jTextFieldSegundoViagemAdd.getText())),
                m.aeroportos.get(jTextFieldAeropOrigemAdd.getText()),
                m.aeroportos.get(jTextFieldAeropDestinoAdd.getText()),
                m.aeroportos.get(jTextFieldAeropOrigemAdd.getText()).avioes.get(Integer.valueOf(jTextFieldAviaoAdd.getText())),
                Integer.valueOf(jTextFieldLotacaoAdd.getText()),
                Float.parseFloat(jTextFieldCustomonAdd.getText()),
                Float.parseFloat(jTextFieldCustotempAdd.getText()),
                Float.parseFloat(jTextFieldCustoTotalAdd.getText()),
                m.aeroportos, m.viagens, m.avioes);
        clearTableViagem();
        loadTableViagem();
        clearTableAerop();
        loadTable();
        clearTableAviao();
        loadTableAviao();
    }//GEN-LAST:event_jButtonAddviagemActionPerformed

    private void jTextFieldCustotempAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCustotempAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCustotempAddActionPerformed

    private void jButtonRemoveViagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveViagemActionPerformed

        m.removeViagem(new Date(Integer.valueOf(jTextFieldDiaViagemRem.getText()), Integer.valueOf(jTextFieldMesViagemRem.getText()), Integer.valueOf(jTextFieldAnoViagemRem.getText()), Integer.valueOf(jTextFieldHoraViagemRem.getText()), Integer.valueOf(jTextFieldMinutoViagemRem.getText()), Integer.valueOf(jTextFieldSegundoViagemRem.getText())), m.aeroportos, m.viagens, m.avioes);
        clearTableViagem();
        loadTableViagem();
        clearTableAerop();
        loadTable();
        clearTableAviao();
        loadTableAviao();
    }//GEN-LAST:event_jButtonRemoveViagemActionPerformed

    private void jButtonEditViagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditViagemActionPerformed

        m.editViagem(new Date(
                Integer.valueOf(jTextFieldDiaViagemEdit.getText()),
                Integer.valueOf(jTextFieldMesViagemEdit.getText()),
                Integer.valueOf(jTextFieldAnoViagemEdit.getText()),
                Integer.valueOf(jTextFieldHoraViagemEdit.getText()),
                Integer.valueOf(jTextFieldMinutoViagemEdit.getText()),
                Integer.valueOf(jTextFieldSegundoViagemEdit.getText())), new Date(
                Integer.valueOf(jTextFieldDiaViagemEdit1.getText()),
                Integer.valueOf(jTextFieldMesViagemEdit1.getText()),
                Integer.valueOf(jTextFieldAnoViagemEdit1.getText()),
                Integer.valueOf(jTextFieldHoraViagemEdit1.getText()),
                Integer.valueOf(jTextFieldMinutoViagemEdit1.getText()),
                Integer.valueOf(jTextFieldSegundoViagemEdit1.getText())),
                m.aeroportos.get(jTextFieldAeropOrigemEdit.getText()),
                m.aeroportos.get(jTextFieldAeropDestinoEdit.getText()),
                m.aeroportos.get(jTextFieldAeropOrigemEdit.getText()).avioes.get(Integer.valueOf(jTextFieldAviaoEdit.getText())),
                Integer.valueOf(jTextFieldLotacaoEdit.getText()),
                Float.parseFloat(jTextFieldCustomonEdit.getText()),
                Float.parseFloat(jTextFieldCustotempEdit.getText()),
                Float.parseFloat(jTextFieldCustoTotalEdit.getText()),
                m.aeroportos, m.viagens, m.avioes);
        clearTableViagem();
        loadTableViagem();
        clearTableAerop();
        loadTable();
        clearTableAviao();
        loadTableAviao();
    }//GEN-LAST:event_jButtonEditViagemActionPerformed

    private void jTextFieldLatitudeAeropAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLatitudeAeropAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLatitudeAeropAddActionPerformed


    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked

        java.awt.Graphics g = jPanel4.getGraphics();
        Graphics2D g2 = (Graphics2D) g;
        int sizex = 285;
        int sizey = 105;

        for (String aerop : m.aeroportos.keys()) {

            Aeroporto a = m.aeroportos.get(aerop);

            if (a.getCodigoAeroporto().compareTo("OPO") == 0) {

                g2.setStroke(new BasicStroke(4));
                g.setColor(Color.blue);
                g2.draw(new Line2D.Double(a.getLongitude() + sizex, a.getLatitude() + sizey, a.getLongitude() + sizex, a.getLatitude() + sizey));

            } else {

                g2.setStroke(new BasicStroke(4));
                g.setColor(Color.red);
                g2.draw(new Line2D.Double(a.getLongitude() + sizex, a.getLatitude() + sizey, a.getLongitude() + sizex, a.getLatitude() + sizey));

            }

        }

    }//GEN-LAST:event_jPanel4MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Graphics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Graphics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Graphics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Graphics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Graphics().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Graphics.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    private void editAeropInVisible() {

        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        jLabel6.setVisible(false);
        jLabel7.setVisible(false);
        jLabel8.setVisible(false);
        jTextFieldCidadeAeropNewEdit.setVisible(false);
        jTextFieldClassificAeropNewEdit.setVisible(false);
        jTextFieldContinenteAeropNewEdit.setVisible(false);
        jTextFieldNomeAeropNewEdit.setVisible(false);
        jTextFieldPaisAeropNewEdit.setVisible(false);
        jTextFieldcodAeropNewEdit.setVisible(false);
        jTextFieldcodAeropOldEdit.setVisible(false);
        jButtonEditAeropvalidate.setVisible(false);
        jTextFieldLongitudeAeropNewEdit.setVisible(false);
        jTextFieldLatitudeAeropNewEdit.setVisible(false);

    }

    private void addAeropVisible() {
        jLabel58.setVisible(true);
        jLabel59.setVisible(true);
        jLabel10.setVisible(true);
        jLabel11.setVisible(true);
        jLabel12.setVisible(true);
        jLabel13.setVisible(true);
        jLabel14.setVisible(true);
        jLabel15.setVisible(true);
        jTextFieldCidadeAeropAdd.setVisible(true);
        jTextFieldClassificAeropAdd.setVisible(true);
        jTextFieldContinenteAeropAdd.setVisible(true);
        jTextFieldNomeAeropAdd.setVisible(true);
        jTextFieldPaisAeropAdd.setVisible(true);
        jTextFieldcodAeropAdd.setVisible(true);
        jTextFieldcodAeropAdd.setVisible(true);
        jTextFieldLongitudeAeropAdd.setVisible(true);
        jTextFieldLatitudeAeropAdd.setVisible(true);
        jButtonaddAerop.setVisible(true);

    }

    private void addAeropInVisible() {
        jLabel58.setVisible(false);
        jLabel59.setVisible(false);
        jLabel10.setVisible(false);
        jLabel11.setVisible(false);
        jLabel12.setVisible(false);
        jLabel13.setVisible(false);
        jLabel14.setVisible(false);
        jLabel15.setVisible(false);
        jLabel56.setVisible(false);
        jLabel57.setVisible(false);
        jTextFieldCidadeAeropAdd.setVisible(false);
        jTextFieldClassificAeropAdd.setVisible(false);
        jTextFieldContinenteAeropAdd.setVisible(false);
        jTextFieldNomeAeropAdd.setVisible(false);
        jTextFieldPaisAeropAdd.setVisible(false);
        jTextFieldcodAeropAdd.setVisible(false);
        jTextFieldcodAeropAdd.setVisible(false);
        jTextFieldLongitudeAeropAdd.setVisible(false);
        jTextFieldLatitudeAeropAdd.setVisible(false);
        jButtonaddAerop.setVisible(false);

    }

    private void editAeropVisible() {

        jLabel2.setVisible(true);
        jLabel3.setVisible(true);
        jLabel4.setVisible(true);
        jLabel5.setVisible(true);
        jLabel6.setVisible(true);
        jLabel7.setVisible(true);
        jLabel8.setVisible(true);
        jLabel56.setVisible(true);
        jLabel57.setVisible(true);
        jTextFieldCidadeAeropNewEdit.setVisible(true);
        jTextFieldClassificAeropNewEdit.setVisible(true);
        jTextFieldContinenteAeropNewEdit.setVisible(true);
        jTextFieldNomeAeropNewEdit.setVisible(true);
        jTextFieldPaisAeropNewEdit.setVisible(true);
        jTextFieldcodAeropNewEdit.setVisible(true);
        jTextFieldLongitudeAeropNewEdit.setVisible(true);
        jTextFieldLatitudeAeropNewEdit.setVisible(true);
        jTextFieldcodAeropOldEdit.setVisible(true);
        jButtonEditAeropvalidate.setVisible(true);
        jButtonaddAerop.setVisible(true);

    }

    private void removeAeropVisible() {

        jLabel9.setVisible(true);
        jButtonRemoveAerop.setVisible(true);
        jTextFieldCodAeropRemove.setVisible(true);

    }

    private void removeAeropInVisible() {

        jLabel9.setVisible(false);
        jButtonRemoveAerop.setVisible(false);
        jTextFieldCodAeropRemove.setVisible(false);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editaerop;
    private javax.swing.JButton jButtonAddaeropSeparator;
    private javax.swing.JButton jButtonAddviagem;
    private javax.swing.JButton jButtonAviaoadd;
    private javax.swing.JButton jButtonEditAeropvalidate;
    private javax.swing.JButton jButtonEditAviao;
    private javax.swing.JButton jButtonEditViagem;
    private javax.swing.JButton jButtonRemovAerop;
    private javax.swing.JButton jButtonRemovAviao;
    private javax.swing.JButton jButtonRemoveAerop;
    private javax.swing.JButton jButtonRemoveViagem;
    private javax.swing.JButton jButtonaddAerop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableAerop;
    private javax.swing.JTable jTableAvioes;
    private javax.swing.JTable jTableViagens;
    private javax.swing.JTextField jTextFieldAeropDestinoAdd;
    private javax.swing.JTextField jTextFieldAeropDestinoEdit;
    private javax.swing.JTextField jTextFieldAeropOrigemAdd;
    private javax.swing.JTextField jTextFieldAeropOrigemEdit;
    private javax.swing.JTextField jTextFieldAltCruzAviao;
    private javax.swing.JTextField jTextFieldAltCruzAviaoadd;
    private javax.swing.JTextField jTextFieldAnoViagemAdd;
    private javax.swing.JTextField jTextFieldAnoViagemEdit;
    private javax.swing.JTextField jTextFieldAnoViagemEdit1;
    private javax.swing.JTextField jTextFieldAnoViagemRem;
    private javax.swing.JTextField jTextFieldAviaoAdd;
    private javax.swing.JTextField jTextFieldAviaoEdit;
    private javax.swing.JTextField jTextFieldAviaoRemov;
    private javax.swing.JTextField jTextFieldCapPassAviao;
    private javax.swing.JTextField jTextFieldCapPassAviaoadd;
    private javax.swing.JTextField jTextFieldCapacDepAviao;
    private javax.swing.JTextField jTextFieldCapacDepAviaoadd;
    private javax.swing.JTextField jTextFieldCidadeAeropAdd;
    private javax.swing.JTextField jTextFieldCidadeAeropNewEdit;
    private javax.swing.JTextField jTextFieldClassificAeropAdd;
    private javax.swing.JTextField jTextFieldClassificAeropNewEdit;
    private javax.swing.JTextField jTextFieldCodAeropAviao;
    private javax.swing.JTextField jTextFieldCodAeropAviaoadd;
    private javax.swing.JTextField jTextFieldCodAeropRemove;
    private javax.swing.JTextField jTextFieldCompanhiaAereaAviao;
    private javax.swing.JTextField jTextFieldCompanhiaAereaAviaoadd;
    private javax.swing.JTextField jTextFieldContinenteAeropAdd;
    private javax.swing.JTextField jTextFieldContinenteAeropNewEdit;
    private javax.swing.JTextField jTextFieldCustoTotalAdd;
    private javax.swing.JTextField jTextFieldCustoTotalEdit;
    private javax.swing.JTextField jTextFieldCustomonAdd;
    private javax.swing.JTextField jTextFieldCustomonEdit;
    private javax.swing.JTextField jTextFieldCustotempAdd;
    private javax.swing.JTextField jTextFieldCustotempEdit;
    private javax.swing.JTextField jTextFieldDiaViagemAdd;
    private javax.swing.JTextField jTextFieldDiaViagemEdit;
    private javax.swing.JTextField jTextFieldDiaViagemEdit1;
    private javax.swing.JTextField jTextFieldDiaViagemRem;
    private javax.swing.JTextField jTextFieldDistMaxAviao;
    private javax.swing.JTextField jTextFieldDistMaxAviaoadd;
    private javax.swing.JTextField jTextFieldHoraViagemAdd;
    private javax.swing.JTextField jTextFieldHoraViagemEdit;
    private javax.swing.JTextField jTextFieldHoraViagemEdit1;
    private javax.swing.JTextField jTextFieldHoraViagemRem;
    private javax.swing.JTextField jTextFieldIdAviao;
    private javax.swing.JTextField jTextFieldIdAviaoadd;
    private javax.swing.JTextField jTextFieldLatitudeAeropAdd;
    private javax.swing.JTextField jTextFieldLatitudeAeropNewEdit;
    private javax.swing.JTextField jTextFieldLongitudeAeropAdd;
    private javax.swing.JTextField jTextFieldLongitudeAeropNewEdit;
    private javax.swing.JTextField jTextFieldLotacaoAdd;
    private javax.swing.JTextField jTextFieldLotacaoEdit;
    private javax.swing.JTextField jTextFieldMesViagemAdd;
    private javax.swing.JTextField jTextFieldMesViagemEdit;
    private javax.swing.JTextField jTextFieldMesViagemEdit1;
    private javax.swing.JTextField jTextFieldMesViagemRem;
    private javax.swing.JTextField jTextFieldMinutoViagemAdd;
    private javax.swing.JTextField jTextFieldMinutoViagemEdit;
    private javax.swing.JTextField jTextFieldMinutoViagemEdit1;
    private javax.swing.JTextField jTextFieldMinutoViagemRem;
    private javax.swing.JTextField jTextFieldModeloAviao;
    private javax.swing.JTextField jTextFieldModeloAviaoadd;
    private javax.swing.JTextField jTextFieldNomeAeropAdd;
    private javax.swing.JTextField jTextFieldNomeAeropNewEdit;
    private javax.swing.JTextField jTextFieldNomeAviao;
    private javax.swing.JTextField jTextFieldNomeAviaoadd;
    private javax.swing.JTextField jTextFieldNomeOldAviao;
    private javax.swing.JTextField jTextFieldPaisAeropAdd;
    private javax.swing.JTextField jTextFieldPaisAeropNewEdit;
    private javax.swing.JTextField jTextFieldSegundoViagemAdd;
    private javax.swing.JTextField jTextFieldSegundoViagemEdit;
    private javax.swing.JTextField jTextFieldSegundoViagemEdit1;
    private javax.swing.JTextField jTextFieldSegundoViagemRem;
    private javax.swing.JTextField jTextFieldVelCruzAviao;
    private javax.swing.JTextField jTextFieldVelCruzAviaoadd;
    private javax.swing.JTextField jTextFieldcodAeropAdd;
    private javax.swing.JTextField jTextFieldcodAeropNewEdit;
    private javax.swing.JTextField jTextFieldcodAeropOldEdit;
    private javax.swing.JButton showaerop;
    // End of variables declaration//GEN-END:variables
}

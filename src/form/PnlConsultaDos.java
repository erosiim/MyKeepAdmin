package form;

import Fonts.Fuentes;
import datadashboard.DaoApartados;
import java.awt.BorderLayout;
import java.awt.FontFormatException;
import java.sql.SQLException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.*;
import org.jfree.data.general.DefaultPieDataset;

public class PnlConsultaDos extends javax.swing.JPanel {

    private Fuentes tipoDeFuentes;
    private DaoApartados api;

    /**
     * Creates new form Panel1
     */
    public PnlConsultaDos() throws FontFormatException, SQLException {
        initComponents();
        api = new DaoApartados();
        tipoDeFuentes = new Fuentes();
        jLabelSolicitudesPrestamos.setFont(tipoDeFuentes.fuente(tipoDeFuentes.quickBold, 0, 17));
        loadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabelSolicitudesPrestamos = new javax.swing.JLabel();
        panelLista = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(java.awt.Color.white);

        jLabelSolicitudesPrestamos.setBackground(new java.awt.Color(127, 145, 232));
        jLabelSolicitudesPrestamos.setFont(new java.awt.Font("Roboto Lt", 1, 18)); // NOI18N
        jLabelSolicitudesPrestamos.setForeground(java.awt.Color.white);
        jLabelSolicitudesPrestamos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSolicitudesPrestamos.setText("Reporte por edificio");
        jLabelSolicitudesPrestamos.setOpaque(true);

        panelLista.setBackground(java.awt.Color.white);
        panelLista.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelSolicitudesPrestamos, javax.swing.GroupLayout.DEFAULT_SIZE, 925, Short.MAX_VALUE)
            .addComponent(panelLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelSolicitudesPrestamos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelLista, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loadData() throws SQLException {
        System.out.println("Mostrando...");
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        //DefaultPieDataset data2 = new DefaultPieDataset();
        
        int recordsEdificio1 = api.getRecordsEdificio("1");
        int recordsEdificio2 = api.getRecordsEdificio("2");
        
        
        final String C1 = "Edificio 1";
        final String C2 = "Edificio 2";

        data.addValue(recordsEdificio1, C1, "Préstamos de edificio 1");
        data.addValue(recordsEdificio2, C2, "Préstamos de edificio 2");
        
//        data2.setValue(C1, recordsEdificio1);
//        data2.setValue(C2, recordsEdificio2);

        JFreeChart grafica = ChartFactory.createBarChart3D("Historial de préstamos por edificio", "Edificios", "Préstamos", data, PlotOrientation.VERTICAL, true, true, false);
        //JFreeChart grafica2 = ChartFactory.createPieChart("Historial de préstamos por edificio", data2, true, true, false);
        ChartPanel contenedor = new ChartPanel(grafica);
        panelLista.add(contenedor, BorderLayout.CENTER);
        panelLista.validate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelSolicitudesPrestamos;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelLista;
    // End of variables declaration//GEN-END:variables
}
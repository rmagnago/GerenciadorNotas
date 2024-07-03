package control;

import view.*;
import java.awt.Frame;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;

/**
 *
 * @author Rafael Magnago
 */
public class GerenciadorInterface {

    private final static GerenciadorInterface unicaInstancia = new GerenciadorInterface();
    private GerenciadorDominio gerDom;

    private DlgCadastrarAparelho cadAparelho = null;
    private DlgCadastrarCliente cadCliente = null;
    private DlgCadastrarVenda cadVenda = null;
    private DlgConsultarCliente consultCli = null;
    private DlgConsultarNotas consultNotas = null;
    private FramePrincipal frmPrincipal = null;

    public GerenciadorInterface() {

    }

    private JDialog abrirJanela(JDialog objDlg, Class classe) {

        try {
            if (objDlg == null) {
                objDlg = (JDialog) classe.getConstructor(Frame.class, boolean.class, GerenciadorInterface.class).newInstance(frmPrincipal, true, this);
            }
            objDlg.setVisible(true);
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            objDlg = null;
            JOptionPane.showMessageDialog(frmPrincipal, ex.getMessage());
        }
        return objDlg;

    }

    public static GerenciadorInterface getInstance() {
        return unicaInstancia;
    }

    public GerenciadorDominio getGerDom() {
        return gerDom;
    }

    public void abrirJanPrincipal() {
        if (frmPrincipal == null) {
            frmPrincipal = new FramePrincipal(this);
        }
        frmPrincipal.setVisible(true);
    }

    public void abrirJanelaCadAparelho() {
        abrirJanela(cadAparelho, DlgCadastrarAparelho.class);
    }

    public void abrirJanelaCadCliente() {
        abrirJanela(cadCliente, DlgCadastrarCliente.class);
    }

    public void abrirJanelaCadVenda() {
        abrirJanela(cadVenda, DlgCadastrarVenda.class);
    }

    public void abrirJanelaConsultarCliente() {
        abrirJanela(consultCli, DlgConsultarCliente.class);
    }

    public void abrirJanelaConsultarNotas() {
        abrirJanela(consultNotas, DlgConsultarNotas.class);
    }

    public void sair() {
        frmPrincipal.dispose();
    }

    public void carregarCombo(Class classe, JComboBox combo) {
        List lista;
        try {
            lista = gerDom.listar(classe);
            combo.setModel(new DefaultComboBoxModel(lista.toArray()));
        } catch (HibernateException ex) {
            JOptionPane.showMessageDialog(frmPrincipal, ex.getMessage());
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

            /*
            FlatDarkLaf dark = new FlatDarkLaf();
            javax.swing.UIManager.setLookAndFeel( dark );
             */
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>
        javax.swing.UIManager.put("OptionPane.yesButtonText", "Sim");
        javax.swing.UIManager.put("OptionPane.noButtonText", "Não");
        javax.swing.UIManager.put("OptionPane.cancelButtonText", "Cancelar");

        GerenciadorInterface gerIG = GerenciadorInterface.getInstance();
        gerIG.abrirJanPrincipal();

    }

}

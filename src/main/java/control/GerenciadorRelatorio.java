package control;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael Magnago
 
public class GerenciadorRelatorio {

    public void relatorioList(List lista, String relatorio) {

        try {
            InputStream rel = getClass().getResourceAsStream("../relatorios/" + relatorio);

            Map parametros = new HashMap();

            JRBeanCollectionDataSource dados = new JRBeanCollectionDataSource(lista);
            JasperPrint print;
            print = JasperFillManager.fillReport(relatorio, parametros, dados);

            if (print.getPages().size() > 0) {

                JasperViewer jrViewer = new JasperViewer(print, true);
                jrViewer.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "Relatorio vazio");
            }
        } catch (JRExeption erro) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir relatorio");

        }

    }
}
*/
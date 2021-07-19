import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.util.HashMap;
import java.util.Map;

public class PrintReport {
    public static void main(String[] args) {
        //03 parametros
        //texto01, texto02, texto03
        Map<String, Object> parametros =  new HashMap<>();
        parametros.put("texto01", "Unifaesp");
        parametros.put("texto02", "Centro");
        parametros.put("texto03", "Universitário");
        try {
            JasperReport relatorio = JasperCompileManager.compileReport("Relatorio02.jrxml");
            JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, new JREmptyDataSource());
           // JasperViewer print = new JasperViewer(impressao, false);
           // print.setTitle("Meu Relatório");
           // print.setVisible(true);
            JasperPrintManager.printPage(impressao, 0, false); // -> enviar para impressora padrão
        } catch (JRException e) {
            e.printStackTrace();
        }

    }
}


//    JasperReport relatorio = JasperCompileManager.compileReport(localArquivoXml);
//    JasperPrint impressao = JasperFillManager.fillReport(relatorio, params, new JREmptyDataSource());
//			JasperViewer jrviewer = new JasperViewer(impressao, false);
//			jrviewer.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
//			jrviewer.setTitle("Relatório de Operações");
//			jrviewer.setVisible(true);
//            JasperPrintManager.printPage(impressao, 0, false);
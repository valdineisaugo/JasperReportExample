import net.sf.jasperreports.engine.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PrintEtiqueta {
    public static void main(String[] args) {
        String origem, destino, localizador, endereco;
        Scanner teclado = new Scanner(System.in);//Leitura de dados pelo teclado
        System.out.println("Informe localizador 13 dígitos");
        localizador = teclado.nextLine();
        System.out.println("Informe Destino");
        destino = teclado.nextLine();
        System.out.println("Informe Origem");
        origem = teclado.nextLine();
        System.out.println("Informe Endereço");
        endereco = teclado.nextLine();
        //Coletar dados para map
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("localizador", localizador.toUpperCase());
        parametros.put("origem", origem.toUpperCase());
        parametros.put("destino", destino.toUpperCase());
        parametros.put("endereco", endereco.toUpperCase());
        //Enviar etiqueta para impressora padrão
        try {
            JasperReport relatorio = JasperCompileManager.compileReport("Etiqueta.jrxml");
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

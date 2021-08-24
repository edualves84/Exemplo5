package web;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Log {

    String dataHora;

    public void iniciarCSV(String dataHora) throws IOException {

       String [] cabecalho = {"data e hora", "casos de teste", "mensagem"};
       this.dataHora = dataHora;
       Writer escritor = Files.newBufferedWriter(Paths.get("target/logs/log -" +dataHora+ ".csv"));
       CSVWriter escritorCSV = new CSVWriter(escritor);
       escritorCSV.writeNext(cabecalho);
       escritorCSV.flush();
       escritor.close();

    }

     public void registrarCSV (String casoDeTeste, String mensagem) throws IOException {

      String dataHoraLog = new SimpleDateFormat("[yyy/MM/dd HH/mm/ss]").format(Calendar.getInstance().getTime());
      String [] linha = new String [] { dataHoraLog, casoDeTeste, mensagem};

      FileWriter escritor = new FileWriter("target/logs/log -"+dataHora+ ".csv", true);
      CSVWriter escritorCSV = new CSVWriter(escritor);
      escritorCSV.writeNext(linha);
      escritorCSV.flush();
      escritor.close();



     }

}

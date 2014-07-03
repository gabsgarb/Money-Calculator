package moneycalculator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class FileExchangeRateLoader implements ExchangeRateLoader {
    private File fileRates;
    private String path;

    public FileExchangeRateLoader(String path) {
        this.path = path;
    }

    public FileExchangeRateLoader(File file) {
        fileRates = file;
    }

    @Override
    public ExchangeRate[] load() {
        FileReader preReader;
        ExchangeRate[] result = null;
        try {
            if (fileRates == null) 
                fileRates = new File(path);
            preReader = new FileReader(fileRates);
            BufferedReader reader = new BufferedReader(preReader);
            String[] line = reader.readLine().split(" ");
            ArrayList<ExchangeRate> lista = new ArrayList<ExchangeRate>();
            while (line != null) {
                ExchangeRate actual = new ExchangeRate(line[0], Float.parseFloat(line[1]), line[2]);
                line = reader.readLine().split(" ");
                lista.add(actual);
            }
            result = new ExchangeRate[lista.size()];
            int n = 0;
            for (ExchangeRate exchangeRate : lista) {
                result[n++] = exchangeRate;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}


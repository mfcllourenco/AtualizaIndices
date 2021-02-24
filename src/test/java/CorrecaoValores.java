import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

public class CorrecaoValores {

    public Map<String, String> preencherCampos(String dataInicial, String dataFinal) {

        Map<String, String> mapIndices = new HashMap<>();

        String dataAtual = dataInicial;
        CalculoData calculoData = new CalculoData();

        String[] excessoes = {"082007", "092007", "102007", "112007", "122007",
                "012008", "022008", "032008", "042008", "052008", "062008",
                "022011", "032011",
                "032016", "042016", "052016"};

        while (!dataAtual.equals(dataFinal)) {

            if (!Arrays.asList(excessoes).contains(dataAtual)) {

                mapIndices.put(dataAtual.substring(2, 6) + dataAtual.substring(0, 2),
                        informarDados(dataAtual, dataFinal));

                $("input[value='Fazer nova pesquisa']").click();
            }

            dataAtual = calculoData.incrementaMes(dataAtual);
        }

        mapIndices.put(dataAtual.substring(2, 6) + dataAtual.substring(0, 2),
                informarDados(dataAtual, dataFinal));

        return mapIndices;
    }

    public String informarDados(String dataAtual, String dataFinal) {

        $("#selIndice").selectOption("INPC (IBGE) - a partir de 04/1979");
        $("input[name=dataInicial]").setValue(dataAtual);
        $("input[name=dataFinal]").setValue(dataFinal);
        $("input[name=valorCorrecao]").setValue("100000");

        $("input[value='Corrigir valor']").click();

        String indice = $("tr:nth-of-type(6) > td:nth-of-type(2)").getText();

        return indice;
    }
}

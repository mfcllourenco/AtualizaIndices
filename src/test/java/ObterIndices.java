import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.isChrome;

public class ObterIndices {

    @Test
    public void obterIndices() {
        String url = "https://www3.bcb.gov.br/CALCIDADAO/publico/exibirFormCorrecaoValores.do?method=exibirFormCorrecaoValores";

        isChrome();
        open(url);

        CorrecaoValores correcaoValores = new CorrecaoValores();
        SalvarArquivo salvarArquivo = new SalvarArquivo();
        ObterData obterData = new ObterData();

        String dataFinal = obterData.obterMesAnterior();

        salvarArquivo.salvarIndiceNoArquivo(
                correcaoValores.preencherCampos("111998", dataFinal)
        );
    }
}

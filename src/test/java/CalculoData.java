public class CalculoData {

    public String incrementaMes(String data) {

        Integer mes = Integer.valueOf(data.substring(0, 2));
        Integer ano = Integer.valueOf(data.substring(2, 6));

        if (mes < 12) {
            mes++;
        } else {
            mes = 1;
            ano++;
        }

        if (mes.toString().length() == 1) {
            data = "0" + mes.toString() + ano.toString();
        } else {
            data = mes.toString() + ano.toString();
        }

        return data;
    }
}

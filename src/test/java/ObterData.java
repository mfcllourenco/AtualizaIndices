import java.util.Calendar;

public class ObterData {

    public String obterMesAnterior() {

        Calendar now = Calendar.getInstance();
        now.add(Calendar.MONTH, -1);

        return now.toInstant().toString().substring(5, 7)
                .concat(now.toInstant().toString().substring(0, 4));
    }
}

import java.util.Arrays;
import java.util.List;

public class Repository {


    public List<ClientsData> clientsData() {

        return Arrays.asList(
                new ClientsData("foo", "buy", 0.50, "SGP", "19/09/2018", 200, 189.23),
                new ClientsData("bar", "buy", 0.35, "AED", "20/09/2018", 700, 34.85),
                new ClientsData("bar", "sell", 0.45, "SGP", "21/09/2017", 350, 200.95),
                new ClientsData("foo", "buy", 0.50, "SGP", "20/09/2018", 500, 80.25),
                new ClientsData("bar", "sell", 0.50, "AED", "19/09/2018", 400, 900.25),
                new ClientsData("foo", "buy", 0.90, "AED", "9/03/2011", 400, 900.25),
                new ClientsData("foo", "sell", 0.50, "SGP", "10/05/2009", 400, 900.25),
                new ClientsData("bar", "buy", 0.35, "SEK", "28/04/2017", 400, 900.25)
        );
    }
}

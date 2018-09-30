import java.util.List;

/**
 * Created by natna on 2018-09-28.
 */
public class GenerateMarketReport {


    public static void main(String[] args) {

        CalculateSettledAmount calculateSettledAmount = new CalculateSettledAmount();
        calculateSettledAmount.calculateAmount();
        List<ClientsData> incomingSettledData = calculateSettledAmount.getIncomingSettledData();
        List<ClientsData> outgoingSettledList = calculateSettledAmount.getOutgoingSettledData();

        System.out.println("------Incoming List----------------");
        System.out.println(" Entity \t Instruction \t Instruction Date \t Settlement Date \t Amount ");
        for (int i = 0; i < incomingSettledData.size(); i++) {

            System.out.print(i + 1 + ". ");
            System.out.println(incomingSettledData.get(i));
        }
        System.out.println("-------Outgoing List--------");
        for (int i = 0; i < outgoingSettledList.size(); i++) {
            System.out.print(i + 1 + ". ");
            System.out.println(outgoingSettledList.get(i));

        }

    }

}


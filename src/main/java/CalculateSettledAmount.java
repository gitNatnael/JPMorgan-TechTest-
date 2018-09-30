import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class CalculateSettledAmount {


    private static List<ClientsData> incomingSettledData = new ArrayList();
    private static List<ClientsData> outgoingSettledData = new ArrayList();



    // calculate amount in dollar, it create an object and add in the lists by identifying if it is incoming or outgoing
    public void calculateAmount() {
        double amountInUSD;
        String settlementDate = null;
        String instructionDate;
        Repository repository=new Repository();
        List<ClientsData> clientsData = repository.clientsData();

        for (ClientsData d : clientsData) {
            amountInUSD = d.getAgreedFX() * d.getUnits() * d.getPricePerUnit();
            instructionDate = d.getInstructionDate();

            try {
                settlementDate = CalculateSettledAmount.calculateSettlementDate(instructionDate, d.getCurrency());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (d.getInstruction().equalsIgnoreCase("buy")) {
                ClientsData data = new ClientsData(d.getItem(), d.getInstruction(), instructionDate, settlementDate, amountInUSD);
                CalculateSettledAmount.outgoingSettledData.add(data);

            } else {

                ClientsData data = new ClientsData(d.getItem(), d.getInstruction(), instructionDate, settlementDate, amountInUSD);
                CalculateSettledAmount.incomingSettledData.add(data);
            }
        }
    }


    //checking the next settlement date

    private static String calculateSettlementDate(String instructionDate, String currency) throws ParseException {

        String dateOfSettlement = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate localDate = LocalDate.parse(instructionDate, formatter);

        if (currency.equalsIgnoreCase("AED") || currency.equalsIgnoreCase("SAR")) {

            if (localDate.getDayOfWeek().getValue() == 4) {
                localDate = localDate.plusDays(3);
                dateOfSettlement = formatter.format(localDate).toString();
            } else {
                localDate = localDate.plusDays(1);
                dateOfSettlement = formatter.format(localDate).toString();

            }

        } else {
            if (localDate.getDayOfWeek().getValue() == 5) {
                localDate = localDate.plusDays(3);
                dateOfSettlement = formatter.format(localDate).toString();

            } else {
                localDate = localDate.plusDays(1);
                dateOfSettlement = formatter.format(localDate).toString();
            }

        }
        return dateOfSettlement;
    }


    //Sort for ranking and return the list
    public List<ClientsData> getIncomingSettledData() {
        Collections.sort(CalculateSettledAmount.incomingSettledData, ClientsData.sortBySettledAmount);
        return this.incomingSettledData;
    }


    public List<ClientsData> getOutgoingSettledData() {
        Collections.sort(CalculateSettledAmount.outgoingSettledData, ClientsData.sortBySettledAmount);
        return this.outgoingSettledData;
    }


}

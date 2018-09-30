import java.util.Comparator;

public class ClientsData {

    private String item;
    private String instruction;
    private String currency;
    private String instructionDate;
    private String settlementDate;
    private double pricePerUnit;
    private double settledAmount;
    private double agreedFX;
    private long units;


    public ClientsData() {
    }

    public ClientsData(String entity, String instruction, double agreedFX, String currency, String instructionDate, long units, double pricePerUnit) {
        this.item = entity;
        this.instruction = instruction;
        this.agreedFX = agreedFX;
        this.currency = currency;
        this.instructionDate = instructionDate;
        this.units = units;
        this.pricePerUnit = pricePerUnit;
    }

    public ClientsData(String entity, String instruction, String instructionDate, String settlementDate, double settledAmount) {
        this.item = entity;
        this.instruction = instruction;
        this.settlementDate = settlementDate;
        this.settledAmount = settledAmount;
        this.instructionDate = instructionDate;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getInstructionDate() {
        return instructionDate;
    }

    public void setInstructionDate(String instructionDate) {
        this.instructionDate = instructionDate;
    }

    public String getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(String settlementDate) {
        this.settlementDate = settlementDate;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public double getSettledAmount() {
        return settledAmount;
    }

    public void setSettledAmount(double settledAmount) {
        this.settledAmount = settledAmount;
    }

    public double getAgreedFX() {
        return agreedFX;
    }

    public void setAgreedFX(double agreedFX) {
        this.agreedFX = agreedFX;
    }

    public long getUnits() {
        return units;
    }

    public void setUnits(long units) {
        this.units = units;
    }

    @Override
    public String toString() {
        return this.getItem() + " \t\t" + this.getInstruction() + " \t\t\t" + this.getInstructionDate() + "\t\t\t" + this.getSettlementDate() + "\t\t" + this.getSettledAmount() + "$";
    }

    public static Comparator<ClientsData> sortBySettledAmount = new Comparator<ClientsData>() {
        public int compare(ClientsData o1, ClientsData o2) {
            return (int) (o1.getSettledAmount() - o2.getSettledAmount());
        }
    };


}

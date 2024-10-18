import java.time.LocalDate;

public class CrispyFlour extends Material {
    private int quantity;

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, int quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getAmount() {
        return this.getQuantity() * super.getCost();
    }

    @Override
    public LocalDate getExpiryDate() {;
        return super.getManufacturingDate().plusYears(1) ;
    }


    @Override
    public String toString() {
        return "Crispy Flour - " + super.toString() + " - " + super.getCost() + ",000 VND/pack - "
                + this.getQuantity() + " pack";
    }
}

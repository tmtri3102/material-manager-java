import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        MaterialManager manager = new MaterialManager();

        manager.addMaterial(new CrispyFlour("001", "Chicken flour", LocalDate.now(), 1500, 15));
        manager.addMaterial(new CrispyFlour("002", "Pork flour", LocalDate.now(), 1800, 25));
        manager.addMaterial(new CrispyFlour("003", "Beef flour", LocalDate.now(), 2000, 30));
        manager.addMaterial(new CrispyFlour("004", "Shrimp flour", LocalDate.now(), 2500, 35));
        manager.addMaterial(new CrispyFlour("005", "Squid flour", LocalDate.now(), 2200, 32));

        manager.addMaterial(new Meat("006", "Beef", LocalDate.now(), 3000, 100));
        manager.addMaterial(new Meat("007", "Pork", LocalDate.now(), 2500,90));
        manager.addMaterial(new Meat("008", "Chicken", LocalDate.now(), 2000, 65));
        manager.addMaterial(new Meat("009", "Shrimp", LocalDate.now(), 3500, 75));
        manager.addMaterial(new Meat("010", "Squid", LocalDate.now(), 3200, 85));


        manager.displayMaterial();
        System.out.println("============================");
        manager.removeMaterial("008");
        System.out.println("============================");
//        manager.editMaterial("003");
        manager.totalCost();
        System.out.println("============================");
        manager.sortCost();
        System.out.println("============================");

        manager.displayDiscountDifference();
    }
}

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class MaterialManager {
    Material[] material;
    public MaterialManager() {
        material = new Material[50];
    }

    public void displayMaterial() {
        for (Material m : material) {
            if (m != null) {  // Check if the material is not null
                System.out.println(m.getId() +
                        " - " + m.getName() +
                        " - " + m.getAmount() +
                        " ------ " + m.getManufacturingDate());
            }
        }
    }

    public void addMaterial(Material newMaterial) {
        for (int i = 0; i < material.length; i++) {
            if (material[i] == null) { // Find the first empty slot
                material[i] = newMaterial;
                break;
            }
        }
    }

    public void editMaterial(String materialId) {
        System.out.println("Let's edit the material, first: ");
        for (int i = 0; i < material.length; i++) {
            if (material[i].getId().equals(materialId)) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter Name: ");
                material[i].setName(scanner.next());
                System.out.print("Enter Amount: ");
                material[i].setCost(scanner.nextInt());
                // DANG BI LOI java.util.InputMismatchException
                break;
            }
        }

        System.out.println("After editing: " + materialId);
        displayMaterial();

    }

    public void removeMaterial(String materialId) {
        for (int i = 0; i < material.length; i++) {
            if (material[i].getId().equals(materialId)) { // Find the material to remove
                material[i] = null;
                break;
            }
        }
        System.out.println("After removing: " + materialId);
        displayMaterial();
    }

    public void totalCost(){
        int sum = 0;
        for (Material m : material) {
            if (m != null) {
                sum += m.getAmount();

            }
        }
        System.out.println("Total Cost: " + sum);
    }

    public void sortCost() {
        for (int i = 0; i < material.length - 1; i++) {
            for (int j = 0; j < material.length - 1 - i; j++) {
                if (material[j] != null && material[j + 1] != null && material[j].getCost() > material[j + 1].getCost()) {
                    // Swap the materials if they are in the wrong order
                    Material temp = material[j];
                    material[j] = material[j + 1];
                    material[j + 1] = temp;
                }
            }
        }
        displayMaterial();

    }
    public double totalWithoutDiscount() {
        double total = 0;
        for (Material m : material) {
            if (m != null) {
                total += m.getAmount();
            }
        }
        return total;
    }
    public double totalWithDiscount() {
        double total = 0;
        for (Material m : material) {
            if (m != null && m instanceof Discount) {
                total += ((Discount) m).getRealMoney();
            }
        }
        return total;
    }
    public void displayDiscountDifference() {
        double withoutDiscount = totalWithoutDiscount();
        double withDiscount = totalWithDiscount();
        double difference = withoutDiscount - withDiscount;

        System.out.println("Total without discount: " + withoutDiscount);
        System.out.println("Total with discount: " + withDiscount);
        System.out.println("Discount difference: " + difference);
    }

}

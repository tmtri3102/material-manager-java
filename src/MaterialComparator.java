import java.util.Comparator;

public class MaterialComparator implements Comparator<Material> {
    public int compare(Material m1, Material m2) {
        return Integer.compare(m2.getCost(), m1.getCost());
    }
}
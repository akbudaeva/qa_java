import com.example.Feline;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class FelineTest {

    @Test
    public void eatMeatTest() throws Exception {
        Feline feline = new Feline();
        List<String> result = feline.eatMeat();
        Assertions.assertLinesMatch(List.of("Животные", "Птицы", "Рыба"), result);
    }

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        Assertions.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensTest() {
        Feline feline = new Feline();
        Assertions.assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittens2Test() {
        Feline feline = new Feline();
        Assertions.assertEquals(2, feline.getKittens(2));
    }
}
import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTest {
    @Parameterized.Parameters(name = "{index}: sex={0}, hasMane={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Самец", true},
                {"Самка", false}
        });
    }
    private final String sex;
    private final boolean hasMane;

    public LionTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        Lion lion = new Lion(sex);
        assertEquals(hasMane, lion.doesHaveMane());
    }

    @Test
    public void testGetKittens() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(sex);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actualKittens = lion.getKittens();
        assertEquals(1, actualKittens);
    }

    @Test
    public void testGetFood() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(sex);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualFood = lion.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), actualFood);
    }
}
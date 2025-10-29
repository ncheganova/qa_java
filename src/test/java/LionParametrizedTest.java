import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParametrizedTest {
    private final boolean hasMane;
    private final String sex;

    public LionParametrizedTest(String sex, boolean hasMane) {
        this.hasMane = hasMane;
        this.sex = sex;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}") // добавили аннотацию
    public static Object[][] getHasManeData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void getCorrectHasMane() throws Exception {
        Lion lion = new Lion(sex, new Feline());
        assertEquals("Что-то с гривой не так", hasMane, lion.doesHaveMane());
    }
}
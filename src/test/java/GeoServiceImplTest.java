import org.junit.jupiter.api.*;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceImplTest {

    static GeoServiceImpl sut;

    @BeforeAll
    public static void startedAll() {
        System.out.println("Начало тестов");
    }

    @BeforeEach
    public void InitAndStart() {
        System.out.println("Старт теста");
        sut = new GeoServiceImpl();
    }

    @AfterAll
    public static void finishAll() {
        System.out.println("Все тесты завершены");
    }

    @AfterEach
    public void finished() {
        System.out.println("Тест завершен");
        sut = null;
    }

    @Test
    public void idIp_location_check() {

        // given:
        final Location expected = new Location("New York", Country.USA, null, 0);
        final String argument = "96.";

        // when:
        Location actual = sut.byIp(argument);

        // then:
        Assertions.assertEquals(expected.getCountry(), actual.getCountry());
    }
}
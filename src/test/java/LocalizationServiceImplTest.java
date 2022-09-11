import org.junit.jupiter.api.*;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceImplTest {
    static LocalizationServiceImpl sut;

    @BeforeAll
    public static void startedAll() {
        System.out.println("Начало тестов");
    }

    @BeforeEach
    public void InitAndStart() {
        System.out.println("Старт теста");
        sut = new LocalizationServiceImpl();
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
    public void locale_check_return_text() {
        // given:
        final Country argument = Country.RUSSIA;
        final String expected = "Добро пожаловать";

        // when:
        String actual = sut.locale(argument);

        // then:
        Assertions.assertEquals(expected,actual);
    }

    }

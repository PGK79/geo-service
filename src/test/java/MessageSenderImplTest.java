import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

class MessageSenderImplTest {

    @Test
    void sendTest_text_language_rus() {
        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp("172.0.32.11"))
                .thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));

        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");


        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
       Map<String,String> header = new HashMap<>();
        header.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11");
        String preferenses = messageSender.send(header);

        String expected = "Добро пожаловать";

        Assertions.assertEquals(expected, preferenses);
    }

    @Test
    void sendTest_text_language_us() {
        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp("96.44.183.149"))
                .thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));

        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String,String> header = new HashMap<>();
        header.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");
        String preferenses = messageSender.send(header);

        String expected = "Welcome";

        Assertions.assertEquals(expected, preferenses);
    }

    @Test
    void sendTest_text_language_us_ip() {
        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(GeoServiceImpl.NEW_YORK_IP))
                .thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));

        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String,String> header = new HashMap<>();
        header.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");
        String preferenses = messageSender.send(header);

        String expected = "Welcome";

        Assertions.assertEquals(expected, preferenses);
    }

    @Test
    void sendTest_text_language_rus_ip() {
        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(GeoServiceImpl.MOSCOW_IP))
                .thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));

        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");


        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String,String> header = new HashMap<>();
        header.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11");
        String preferenses = messageSender.send(header);

        String expected = "Добро пожаловать";

        Assertions.assertEquals(expected, preferenses);
    }

    @Test
    void sendTest_text_language_brazil() {
        GeoService geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp("106.0.0.1"))
                .thenReturn(new Location("Rio", Country.BRAZIL, null,  0));

        LocalizationService localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.BRAZIL))
                .thenReturn("Welcome");

        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String,String> header = new HashMap<>();
        header.put(MessageSenderImpl.IP_ADDRESS_HEADER, "106.0.0.1");
        String actual = messageSender.send(header);

        String expected = "Welcome";

        Assertions.assertEquals(expected, actual);
    }

}

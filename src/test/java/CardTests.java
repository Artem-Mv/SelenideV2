import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CardTests {
    @Test
    void cardOrderPositiveTest() throws InterruptedException {
        open("http://localhost:9999/");
        $x("//input[@placeholder='Город']").setValue("Кемерово");
        //  дата выставляется автоматом
        $x("//input[@name='name']").setValue("Фамилия Имя");
        $x("//input[@name='phone']").setValue("+79999999999");
        $x("//label[@data-test-id='agreement']").click();
        $x("//span[@class='button__text']").click();

        Thread.sleep(10000);
        boolean actualResult = $x("//div[@data-test-id='notification']").isDisplayed();

        assertTrue(actualResult);
    }
}
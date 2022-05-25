import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class CardTests {
    @Test
    void cardOrderPositiveTest(){
        Helper helper = new Helper();

        open("http://localhost:9999/");

        $x("//input[@placeholder='Город']").setValue("Кемерово");
        $("[data-test-id='date'] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
        $x("(//input[@class='input__control'])[2]").setValue(helper.datePlusDay(4));
        $x("//input[@name='name']").setValue("Фамилия Имя");
        $x("//input[@name='phone']").setValue("+79999999999");
        $x("//label[@data-test-id='agreement']").click();
        $x("//span[@class='button__text']").click();

        $x("//div[@data-test-id='notification']").shouldBe(Condition.visible, Duration.ofSeconds(15));
        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + helper.datePlusDay(4)),
                        Duration.ofSeconds(15));
    }
}

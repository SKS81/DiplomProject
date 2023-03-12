package ru.netology.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class firstTests {
    
    @BeforeEach
    void setUP() {
        Configuration.holdBrowserOpen = true;
        open(DataHelper.getTestURL());
    }

    @Test
    void byeWithValidDebitCard() {
        $(byXpath("/html/body/div/div/button[1]/span/span")).click();
        $("input[type=\"text\"][placeholder=\"0000 0000 0000 0000\"]").sendKeys("4444444444444441");
        $("input[type=\"text\"][placeholder=\"08\"]").sendKeys("07");
        $("input[type=\"text\"][placeholder=\"22\"]").sendKeys("23");
        $$(".input").find(exactText("Владелец")).$(".input__control").sendKeys("Ivan Ivanov");
        $("input[type=\"text\"][placeholder=\"999\"]").sendKeys("000");
        $$(".button").find(exactText("Продолжить")).click();
    }

    @Test
    void byeInCreditWithValid() {
        $(byXpath("/html/body/div/div/button[2]/span/span")).click();
        $("input[type=\"text\"][placeholder=\"0000 0000 0000 0000\"]").sendKeys("4444444444444441");
        $("input[type=\"text\"][placeholder=\"08\"]").sendKeys("07");
        $("input[type=\"text\"][placeholder=\"22\"]").sendKeys("23");
        $$(".input").find(exactText("Владелец")).$(".input__control").sendKeys("Ivan Ivanov");
        $("input[type=\"text\"][placeholder=\"999\"]").sendKeys("000");
        $$(".button").find(exactText("Продолжить")).click();
    }
}
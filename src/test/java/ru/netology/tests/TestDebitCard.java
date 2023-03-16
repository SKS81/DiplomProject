package ru.netology.tests;

import ru.netology.page.BuyWithCard;
import ru.netology.page.StartPage;
import com.codeborne.selenide.logevents.SelenideLogger;
import ru.netology.data.DataHelper;
import ru.netology.data.SQL;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.SneakyThrows;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDebitCard {
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @SneakyThrows
    @BeforeEach
    public void setUpEach() {
        String url = System.getProperty("sut.url");
        open(url);
        SQL.clearData();
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @SneakyThrows
    @Test
    void shouldDebitByCardWithApproved() {
        StartPage startPage = new StartPage();
        startPage.openBuyWithCard();
        val buyWithCard = new BuyWithCard();
        buyWithCard.fillData(DataHelper.getApprovedCard());
        buyWithCard.waitNotificationOk();
        assertEquals("APPROVED", SQL.getDebitStatus());
    }

    @SneakyThrows
    @Test
    void shouldDebitByCardWithDecline() {
        StartPage startPage = new StartPage();
        startPage.openBuyWithCard();
        val buyWithCard = new BuyWithCard();
        buyWithCard.fillData(DataHelper.getDeclinedCard());
        buyWithCard.waitNotificationError();
        assertEquals("DECLINED", SQL.getDebitStatus());
    }

    @Test
    void shouldShortNameInOwnerApproved() {
        StartPage startPage = new StartPage();
        startPage.openBuyWithCard();
        val buyWithCard = new BuyWithCard();
        buyWithCard.fillData(DataHelper.getShortNameInOwnerApprovedCard());
        buyWithCard.waitNotificationOk();
    }

    @Test
    void shouldShortNameInOwnerDeclined() {
        StartPage startPage = new StartPage();
        startPage.openBuyWithCard();
        val debitPage = new BuyWithCard();
        debitPage.fillData(DataHelper.getShortNameInOwnerDeclinedCard());
        debitPage.waitNotificationError();
    }

    @Test
    void shouldInvalidFieldMessageEmptyForm() {
        StartPage startPage = new StartPage();
        startPage.openBuyWithCard();
        val debitPage = new BuyWithCard();
        debitPage.fillData(DataHelper.getEmptyForm());
        debitPage.getInputInvalid();
        assertEquals("Неверный формат", debitPage.getInputInvalid());
    }

    @Test
    void shouldInvalidFieldMessageInvalidMonthApproved() {
        StartPage startPage = new StartPage();
        startPage.openBuyWithCard();
        val debitPage = new BuyWithCard();
        debitPage.fillData(DataHelper.getInvalidMonthApprovedCard());
        assertEquals("Неверно указан срок действия карты", debitPage.getInputInvalid());
    }

    @Test
    void shouldInvalidFieldMessageInvalidMonthDeclined() {
        StartPage startPage = new StartPage();
        startPage.openBuyWithCard();
        val debitPage = new BuyWithCard();
        debitPage.fillData(DataHelper.getInvalidMonthDeclinedCard());
        assertEquals("Неверно указан срок действия карты", debitPage.getInputInvalid());
    }

    @Test
    void shouldInvalidFieldMessageBygoneMonthApproved() {
        StartPage startPage = new StartPage();
        startPage.openBuyWithCard();
        val debitPage = new BuyWithCard();
        debitPage.fillData(DataHelper.getBygoneMonthApprovedCard());
        assertEquals("Неверно указан срок действия карты", debitPage.getInputInvalid());
    }

    @Test
    void shouldInvalidFieldMessageBygoneMonthDeclined() {
        StartPage startPage = new StartPage();
        startPage.openBuyWithCard();
        val debitPage = new BuyWithCard();
        debitPage.fillData(DataHelper.getBygoneMonthDeclinedCard());
        assertEquals("Неверно указан срок действия карты", debitPage.getInputInvalid());
    }

    @Test
    void shouldInvalidFieldMessageIncompleteField() {
        StartPage startPage = new StartPage();
        startPage.openBuyWithCard();
        val debitPage = new BuyWithCard();
        debitPage.fillData(DataHelper.getIncompleteField());
        assertEquals("Неверный формат", debitPage.getInputInvalid());
    }

    @Test
    void shouldCharactersInFieldOwnerApproved() {
        StartPage startPage = new StartPage();
        startPage.openBuyWithCard();
        val debitPage = new BuyWithCard();
        debitPage.fillData(DataHelper.getCharactersInFieldOwnerApprovedCard());
        assertEquals("Неверный формат", debitPage.getInputInvalid());
    }

    @Test
    void shouldCharactersInFieldOwnerDeclined() {
        StartPage startPage = new StartPage();
        startPage.openBuyWithCard();
        val debitPage = new BuyWithCard();
        debitPage.fillData(DataHelper.getCharactersInFieldOwnerDeclinedCard());
        assertEquals("Неверный формат", debitPage.getInputInvalid());
    }

    @Test
    void shouldOneCharacterInFieldOwnerApproved() {
        StartPage startPage = new StartPage();
        startPage.openBuyWithCard();
        val debitPage = new BuyWithCard();
        debitPage.fillData(DataHelper.getCharactersInFieldOwnerApprovedCard());
        assertEquals("Неверный формат", debitPage.getInputInvalid());
    }

    @Test
    void shouldOneCharacterInFieldOwnerDeclined() {
        StartPage startPage = new StartPage();
        startPage.openBuyWithCard();
        val debitPage = new BuyWithCard();
        debitPage.fillData(DataHelper.getOneCharacterInFieldOwnerDeclinedCard());
        assertEquals("Неверный формат", debitPage.getInputInvalid());
    }

    @Test
    void shouldInvalidFieldMessageBygoneYearApproved() {
        StartPage startPage = new StartPage();
        startPage.openBuyWithCard();
        val debitPage = new BuyWithCard();
        debitPage.fillData(DataHelper.getBygoneYearApprovedCard());
        assertEquals("Истёк срок действия карты", debitPage.getInputInvalid());
    }

    @Test
    void shouldInvalidFieldMessageBygoneYearDeclined() {
        StartPage startPage = new StartPage();
        startPage.openBuyWithCard();
        val debitPage = new BuyWithCard();
        debitPage.fillData(DataHelper.getBygoneYearDeclinedCard());
        assertEquals("Истёк срок действия карты", debitPage.getInputInvalid());
    }

    @Test
    void shouldInvalidDebitCard() {
        StartPage startPage = new StartPage();
        startPage.openBuyWithCard();
        val debitPage = new BuyWithCard();
        debitPage.fillData(DataHelper.getNonExistentCard());
        assertEquals("Ошибка! Банк отказал в проведении операции.", debitPage.getInputInvalid());
    }

    @SneakyThrows
    @Test
    void shouldAmountByCardWithApproved() {
        StartPage startPage = new StartPage();
        startPage.openBuyWithCard();
        val buyWithCard = new BuyWithCard();
        buyWithCard.fillData(DataHelper.getApprovedCard());
        buyWithCard.waitNotificationOk();
        assertEquals("45000", SQL.getAmountStatus());
    }
}
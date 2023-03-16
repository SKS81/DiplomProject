# Отчёт о проведённой автоматизации
***
## 1. Что было запланировано и что было сделано
В результате работы над дипломным проектом были выполнены следующие задачи:
1. Автоматизированы позитивные и негативные тестовые сценарии покупки тура по двум сценариям:
- "Оплата по карте"
- "Кредит по данным карты"
2. Протестирована работа сервиса на двух СУБД _(MySQL и PostgreSQL)_, а так же параметризован запуск SUT и тестов для указанных БД.
3. Сгенерирован отчет о проведенном тестировании в Allure Report.
***
## 2. Причины, по которым что-то не было сделано
Не была выполнена дополнительно интеграция с системой Appveyor CI, GitHub Actions или прочей CI по причине нехватки времени.
***
## 3. Возникшие сложности
В процессе автоматизации тестирования возникли следующие сложности:
- Отсутствие уникальных идентификаторов для элементов страниц (id), был затруднён поиск требуемых селекторов.
- Потребовалось дополнительное время при проверке работы тестов вручную и исключения «ложных» падений по причине наличия дефектов в сервисе.
- Отсутствие подробной документации к сервису.
- Встретились проблемы с правильным подключением к базе данных в MySQL и PostgreSQL, а именно получением данных из таблиц в процессе автоматизации;
***
## 4. Общий итог по времени
Запланировано: **120 часов**  
Фактически потрачено: **160 часов**
insert into products values(1, 'Навіть поганий програмний код може працювати. Однак якщо код не є «чистим», це завжди буде заважати розвитку проекту і компанії-розробника, віднімаючи значні ресурси на його підтримку і «приборкання». Ця книга присвячена хорошому програмуванню. У ній повно реальних прикладів коду. Прочитавши книгу, ви дізнаєтеся багато нового про коди. Більш того, ви навчитеся відрізняти хороший код від поганого. Ви дізнаєтеся, як писати хороший код і як перетворити поганий код у хороший.', 'Чистий Код', 448, 'ROBERTMARTIN');
insert into products values (2, 'Детальний опис принципів роботи процесора та інших комп’ютерних пристроїв. Cам автор має цікаву форму подачі інформації, з долею іронії. Навіть назви глав змушують зацікавитись: “Анатомія ліхтарика”, “За бітом біт”, “Під шерех шин”, “Там за поворотом” та інші.', 'КОД: Таємна мова інформатики', 448, 'CHARLESPETZOLD');
insert into products values (3, 'Всі ми — божевільні, які живуть в технологічному божевільні, і створили цей божевільний світ ми самі. Своїми руками створили цей кошмар: інтерфейси, які нас дратують і стомлюють очі, пристрої, які призводять до болів в спині і в зап''ястях. Ця книга стала маніфестом і досі не втратила актуальності. Двері на свободу розкриті. Чому ж ми не помічаємо виходу? Про це і розповідає Алан Купер, пояснюючи різницю між інтерфейсом і взаємодією. Гей, хлопці, у вас тут повно розлючених клієнтів. Вам є що їм відповісти?', 'Психлікарня в руках пацієнтів', 384, 'ALANCOOPER');
insert into products values (4, 'Виглядає переконливо. Проте не поспішайте лякатися і відкладати книжку до “кращих часів”. Вперше матеріал був опублікований у 2016 році. Тобто, вся приведена інформація актуальна та “свіжа”. Книга ще не набула великої популярності, проте всі, хто вже встиг з нею познайомитись, підкреслюють унікальність та простоту. Чарльз Северанс – доцент клінічного факультету Школи інформації Мічиганського університету, де викладає курси інформатики; він також викладав інформатику в Університеті штату Мічиган. Чарльз намагається спростити бачення Python, як важкої для вивчення мови.', 'Python for Everybody: Exploring Data Using Python 3', 256, 'CHARLESSEVERANCE');


insert into product_images values (1, 'https://book-ye.com.ua/upload/resize_cache/iblock/632/520_860_1/64293f2e_fbf7_11e9_8123_000c29ae1566_b881fd5c_5291_11eb_8144_000c29ae1566.jpg', 1);
insert into product_images values (2, 'https://book-ye.com.ua/upload/iblock/72a/64293f2e_fbf7_11e9_8123_000c29ae1566_b881fd5d_5291_11eb_8144_000c29ae1566.jpg', 0);

insert into product_images values (3, 'https://stylus.ua/thumbs/568x568/2d/bf/1371835.jpeg', 1);
insert into product_images values (4, 'https://stylus.ua/thumbs/568x568/8e/c0/1371836.jpeg', 0);
insert into product_images values (5, 'https://stylus.ua/thumbs/568x568/d2/33/1371837.jpeg', 0);

insert into product_images values (6, 'https://images.prom.ua/2065157445_kniga-psihlikarnya-v.jpg', 1);

insert into product_images values (7, 'https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQ3mhbH8RQIGcAfsmr7Yzt2CAcyzb3vUMHyvFSg0azsJi0_dMaK', 1);


insert into thumbnails values (1, 1);
insert into thumbnails values (1, 2);

insert into thumbnails values (2, 3);
insert into thumbnails values (2, 4);
insert into thumbnails values (2, 5);

insert into thumbnails values (3, 6);

insert into thumbnails values (4, 7);

insert into product_variant values (default, 'Українська', 300.00, 1);
insert into product_variant values (default, 'Російська', 300.00, 1);
insert into product_variant values (default, 'Англійська', 300.00, 1);
insert into product_variant values (default, 'Російська', 150.00, 2);
insert into product_variant values (default, 'Російська', 220.00, 3);
insert into product_variant values (default, 'Англійська', 500.00, 4);
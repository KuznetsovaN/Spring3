Практическое задание №2_Spring

Вторая часть ДЗ:

Создать REST веб-сервис (компас) используя технологию Spring, который будет определять сторону света по введенным градусам (от 0 до 359). Точка отсчета будет север - 0 градусов.

Изначально нужно дать понять сервису с помощью POST-запроса какие диапазоны градусов будут отвечать за какие стороны света.

В примере ниже рассмотрены 4 диапазона (север, юг, запад, восток), а в ДЗ необходимо создать 8 (северо-восток, юго-запад и тд). Реализация свободная, например, можно записать в Map - в качестве ключа будут стороны света, а значение - это диапазон градусов, но при этом поддерживается любой энтузиазм :)

Пример запроса:

{
"North": "316-45",
"East": "46-135",
"South": "136-225",
"West": "226-315"
}

В качестве GET-запроса необходимо реализовать вывод стороны света по запрашиваемому градусу, например:
Запрос:

{
"Degree": 56
}

Ответ:
{
"Side": "East"
}

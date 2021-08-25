## Программа для расчета хэшкода субдиректорий на основании размещенных в них файлов (1 уровень вложенности)

![Java](https://img.shields.io/badge/-Java-05122A?style=flat&logo=Java&logoColor=FFA518) ![JavaFX](https://img.shields.io/badge/-JavaFX-05122A?style=flat&logo=JavaFX) ![File](https://img.shields.io/badge/-File-05122A?style=flat&logo=File) ![Hashcode](https://img.shields.io/badge/-Hashcode-05122A?style=Hashcode) ![CSV](https://img.shields.io/badge/-CSV-05122A?style=flat&logo=csv&logoColor=fffffb) ![Concurrent](https://img.shields.io/badge/-Concurrent-05122A?style=flat&logo=Concurrent&logoColor=fffffb)

![Скриншот gui](appScreen.png)

### Использованные технологии:
* Java 11 (Concurrent, Stream API, IO, NIO);
* JavaFX (GUI);

### Алгоритм работы:

* На вход подается корневая директория для подпапок которой требуется определить хэшкод.

* Затем после нажатия кнопки Generate, программа находит внутри все поддиректории содержащие файлы (на один уровень), файлы корневой директории игнорируются.
 Создается очередь из объектов. Генерируется хэшкод в несколько потоков (в зависимости от количества ядер процессора) 
для каждой подпапки с файлами. Результат запоминается в очередь.

* После получения всех результатов, при нажатии кнопки Export производит запись в файл в формате csv 
(путь и имя файла задается в поле ввода).

* При нажатии кнопки Open происходит открытие файла.


p.s. Программа на основании задания ниже, но точные параметры задания не известны (алгоритм, структура файлов, профайлы):

![Скриншот задания](HashTask.png)


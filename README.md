## Program for calculating the hash code of subdirectories based on the files placed in them (1 level of nesting)

![Java](https://img.shields.io/badge/-Java-05122A?style=flat&logo=Java&logoColor=FFA518) ![JavaFX](https://img.shields.io/badge/-JavaFX-05122A?style=flat&logo=JavaFX) ![File](https://img.shields.io/badge/-File-05122A?style=flat&logo=File) ![Hashcode](https://img.shields.io/badge/-Hashcode-05122A?style=Hashcode) ![CSV](https://img.shields.io/badge/-CSV-05122A?style=flat&logo=csv&logoColor=fffffb) ![Concurrent](https://img.shields.io/badge/-Concurrent-05122A?style=flat&logo=Concurrent&logoColor=fffffb)

![Gui screenshot](appScreen.png)

### Technologies used
* Java 11 (Concurrent, Stream API, IO, NIO);
* JavaFX (GUI);

### Operating algorithm:

* The root directory for which subdirectories are required to determine the hash code is entered as input.

* Then, after clicking the Generate button, the program finds all subdirectories containing files inside (at one level), files of the root directory are ignored. A queue of objects is created. The hash code is generated in multiple threads (depending on the number of processor cores) for each subfolder with files. The result is stored in the queue.

* After obtaining all the results, clicking the Export button writes to a file in csv format (the path and file name are entered in the input field).

* Clicking the Open button opens the file.

* p.s. The program is based on the task below, but the exact task parameters are unknown (algorithm, file structure, profiles):

![Task screenshot](HashTask.png)


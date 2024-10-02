#**Решение 1-5: **
**1.**
dima@dima-linux:~$ mkdir Final_task_2
dima@dima-linux:~$ cd Final_task_2
dima@dima-linux:~/Final_task_2$ mkdir Pitomnik
dima@dima-linux:~/Final_task_2$ cd Pitomnik
dima@dima-linux:~/Final_task_2/Pitomnik$ cat > Pets.txt
Собака
Кошка
Хомяк
dima@dima-linux:~/Final_task_2/Pitomnik$ cat > Pack_animals.txt
Лошадь
Верблюд
Осел
dima@dima-linux:~/Final_task_2/Pitomnik$ ls
Pack_animals.txt  Pets.txt
dima@dima-linux:~/Final_task_2/Pitomnik$ cat Pets.txt Pack_animals.txt > Animals.txt
dima@dima-linux:~/Final_task_2/Pitomnik$ ls
Animals.txt  Pack_animals.txt  Pets.txt
dima@dima-linux:~/Final_task_2/Pitomnik$ cat Animals.txt
Собака
Кошка
Хомяк
Лошадь
Верблюд
Осел
dima@dima-linux:~/Final_task_2/Pitomnik$ mv Animals.txt Human_friends.txt
dima@dima-linux:~/Final_task_2/Pitomnik$ ls
Human_friends.txt  Pack_animals.txt  Pets.txt
 
**2.**
dima@dima-linux:~/Final_task_2/Pitomnik$ mkdir new_folder
dima@dima-linux:~/Final_task_2/Pitomnik$ mv Human_friends.txt new_folder/
dima@dima-linux:~/Final_task_2/Pitomnik$ ls
new_folder  Pack_animals.txt  Pets.txt

**3.** 
dima@dima-linux:~/Final_task_2/Pitomnik$ sudo apt-get update
dima@dima-linux:~/Final_task_2/Pitomnik$ sudo apt-get install mysql-server
dima@dima-linux:~/Final_task_2/Pitomnik$ mysql \--version
mysql  Ver 8.0.39-0ubuntu0.24.04.2 for Linux on x86_64 ((Ubuntu))
 
**4.** 
dima@dima-linux:~/Final_task_2/Pitomnik$ wget https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-j_8.0.32-1ubuntu22.04_all.deb
dima@dima-linux:~/Final_task_2/Pitomnik$ sudo dpkg -i mysql-connector-j_8.0.32-1ubuntu22.04_all.deb
dima@dima-linux:~/Final_task_2/Pitomnik$ sudo dpkg -r mysql-connector-j
dima@dima-linux:~/Final_task_2/Pitomnik$ sudo apt-get autoremove
 
**5.**
dima@dima-linux:~/Final_task_2/Pitomnik$ history
  549  mkdir Final_task_2
  550  cd Final_task_2
  551  mkdir Pitomnik
  552  cd Pitomnik
  553  cat > Pets.txt
  554  cat > Pack_animals.txt
  555  ls
  556  cat Pets.txt Pack_animals.txt > Animals.txt
  557  ls
  558  cat Animals.txt
  559  mv Animals.txt Human_friends.txt
  560  ls
  561  mkdir new_folder
  562  mv Human_friends.txt new_folder/
  563  ls
  564  sudo apt-get update
  565  sudo apt-get install mysql-server
  566  mysql \--version
  567  wget https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-j_8.0.32-1ubuntu22.04_all.deb
  568  sudo dpkg - i mysql-connector-j_8.0.32-1ubuntu22.04_all.deb
  569  sudo dpkg -i mysql-connector-j_8.0.32-1ubuntu22.04_all.deb
  570  sudo dpkg -r mysql-connector-j
  571  sudo apt-get autoremove
  572  clear
  573  history

BANK MANAGMENT SYSTEM 💵
Este proyecto esta hecho con fines educativos y esta basado principalmente en el blog de una programador llamado Kunal Tyagi. La mecánica de la aplicación es muy práctica y
el código aquí desarrollado promueve la lectura y la legibilidad del mismo. 

🗂️ src/ En la carpeta src/ se encuentran todos los archivos referentes a la aplicación para el manejo de sistema de banco. 
        El código ha sido documentado siguiendo los principios y convenciones estándar de JavaDoc, como se recomienda en las guías oficiales de Oracle. 
        IMPORTANTE: La aplicación empieza y se EJECUTA desde la clase 'Login'.
    
🖼️ icons/ En la carpeta icons se encuentran únicamente el logo para darle un toque más bancario, pero realmente lo que importa es el archivo que contiene el cajero, este
        se llama 'atm.jpg'. En esta se llevara a cabo todas las funcionalidades del cajero ATM. 

📚 libraries/ Es muy importante mencionar que la aplicación no funciona sin la implementación de dos librerías que ayudan a correr la aplicación.
        1. jcalendar-tz-1.3.3-4. Para la fecha nacimiento, (en donde se solicitara en la clase 'SignupOne' representada por la página 1) utilizo una librería que
        contiene funciones adicionales; haciendo posible al usuario que se apoye con el cursos hasta ingresar su fecha de nacimiento, esto con el fin de ahorrar código, tiempo y recursos.
        En la carpeta libraries/ anexe la librería jcalendar/ para que la descargues.
        2. mysql-connector-java-8.0.28.jar. La aplicación funciona con una base de datos, en este caso yo use MySQL, por lo que necesitas descargar un conector para llevar a cabo
        la conexión de tu aplicación con tu base de datos. 
        Además, depende de tu IDE con la que te acomodes, pero necesitaras una WorbBench para crear las mesas o campos en los que se almacenaran los datos de tus usuarios, en tu caso
        utiliza 'MySQLWorkbench'. Pero si utilizar IntelIJ IDEA, entonces, puedes omitir este paso y pasar directo a la consola que te proporciona tu IDE. Hará falta correr algunos comandos
        importantes para construir tu base de datos. Así es como debería verse tu consola:
        ------------------------------------------------------------------
        create database bankmanagementsystem;
        use bankmanagementsystem;
        create table signup(formno varchar(20), name varchar(20), father_name varchar(20), dob varchar(20), gender varchar(20), email varchar(30), marital_status varchar(20), address varchar(40), city varchar(25), pincode varchar(20), state varchar(25));
        select * from signup;
        create table signuptwo(formno varchar(20), religion varchar(20), category varchar(20), income varchar(20), education varchar(20), occupation varchar(20), curp varchar(20), zip varchar(20), seniorcitizen varchar(20), existingaccount varchar(20));
        select * from signuptwo;
        create table signupthree(formno varchar(20), account_type varchar(40), card_number varchar(25), pin varchar(10),facility varchar(100));
        create table login(formno varchar (20), cardnumber varchar(25), pin varchar(10));
        select * from signupthree;
        select * from login;
        create table bank(pin varchar(12), date varchar(50), type varchar(25), amount varchar(25));
        select * from bank;
        FIN
        ------------------------------------------------------------------

  Tienes todos los recursos en las carpetas y el código fuente en los archivos. Por último, como mencionaba anteriormente, este proyecto fue hecho con fines educativos y con la idea de promover
  código legible. Me despido y este fue mi proyecto del Manejo de sistema de banco. Gracias!
  
  Autor: Atom Alexander Muñoz. Nava




*****NOTAS : V 1.0*****

-La base de datos se encuentra en el archivo mr_robot.sql para la facilidad de usarla además de que tiene datos preescritos.
-Patrón dao trabajado, se podrá adaptar sin ningún problema a cualquier base de datos, actualmente trabaja con MySql5 a través de XAMPP.
-Patrón singleton para mantener la sesión.
-Fallo en la creación de reportes PDF arreglado.
-Interfaces gráficas mejoradas, y código optimizado.

-Los datos que se usaron son referenciales, si desea probar el cambio de correo o contraseña debera usar datos reales para la verificación.

*****NOTAS : V 0.5*****

-Para su funcionamiento necesita activar la Base de Datos a través de Xampp.
-La Base de Datos permanecera hasta donde pueda existir.
-Si se cambia de Datos necesitas cambiar las direcciones, pues con estas se conectan.
-Hay un pequeño fallo con la creación de Reportes de PDF, surge cuando se cambia la direcciónd e la imagen banner.jpg que
se encuentra en /ProyectoFinal/src/img/banner.jpg, en caso de cambiar la dirección de imagen se debera configurar de nuevo
los códigos internos.

-Disfrute :D

--- BASE DE DATOS -- Creada por Xampp

 nombre :   base_mrobot        tablas :  usuarios    -    clientes    -     equipo

-- usuarios
ID_Usuarios (Key,AI) , NombreUsuario , Email , Telefono , Nick , Pass , Status , Nivel , RegistradoPor

-- clientes
ID_Clientes (Key,AI), NombreClientes , EmailCliente , TelefonoCliente , DireccionCliente , ModificacionCliente

-- equipo
ID_Equipo (Key,AI), ID_Clientes , TipoEquipo , Marca , Modelo , Serie , Status , Modificación , Observaciones , Comentarios , 
Fecha 

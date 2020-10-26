create table usuarios(
IdUser              INT          PRIMARY KEY  AUTO_INCREMENT, 
NameUser            VARCHAR(40), 
EmailUser           VARCHAR(40), 
PhoneUser           VARCHAR(20), 
NickUser            VARCHAR(20), 
PassUser            VARCHAR(20), 
StatusUser          BOOLEAN, -- true : Activo, false : Inactivo
NivelUser           INT, -- 0 : Administrador, 1 : Capturista, 2: Ténico
RegisteredBy        VARCHAR(50)
);

create table clientes(
IdClient            INT          PRIMARY KEY AUTO_INCREMENT, 
NameClient          VARCHAR(40),
EmailClient         VARCHAR(40),
PhoneClient         VARCHAR(20),
DirectionClient     VARCHAR(50),
ChangeClient        VARCHAR(50)
);

create table equipos(
IdDevice            INT            PRIMARY KEY AUTO_INCREMENT,
IdClient            INT           ,FOREIGN KEY (IDClient) REFERENCES clientes(IDClient),
TypeDevice          INT,
BrandDevice         INT,
ModelDevice         VARCHAR(50),
SerieDevice         VARCHAR(50),
StatusDevice        INT, -- 0 : Nuevo Ingreso, 1 : No Reparado, 2 : En Revisión, 3 : Reparado, 4 : Entregado
ChangeDevice        VARCHAR(50),
ObservationsDevice  VARCHAR(50),
CommentsDevice      VARCHAR(50), 
DateDevice          DATE
);

-- Ingresando datos
-- Admin
insert into usuarios values('0','Steffano Fernandez','zero19.cr@gmail.com','988568325','ZERO','zero',true,0,'Steffano Fernandez');
insert into usuarios values('0','Marcos Castillo','marcoscastillo@mrrobot.com','987654321','MARQUITOS','marcos',true,0,'Steffano Fernandez');
insert into usuarios values('0','Fernanda Gutierrez','fergutierrez@mrrobot.com','986862001','Fernanda','gutierres',true,0,'Steffano Fernandez');
-- Capturista
insert into usuarios values('0','Julio Artiaga','julioa@mrrobot.com','989852010','Julio','julio',true,1,'Marcos Castillo');
insert into usuarios values('0','Maria Velazques','mariavela@mrrobot.com','923611200','mari12','contra',true,1,'Marcos Castillo');
insert into usuarios values('0','Lucia Flores','luciflor@mrrobot.com','925369874','LuciFlor','vaquita',true,1,'Fernanda Gutierrez');
-- Tecnico
insert into usuarios values('0','Jose Vaca','joseva@mrrobot.com','968522000','JoseVa','josevaaa',true,2,'Marcos Castillo');
insert into usuarios values('0','Lucas Arias','lucas@mrrobot.com','964552010','Lcas','eldiez',true,2,'Fernanda Gutierrez');
insert into usuarios values('0','Jordan Casas','casasj@mrrobot.com','998632110','casasj','casas',true,2,'Fernanda Gutierrez');
insert into usuarios values('0','Julieta Ramos','ramosss@mrrobot.com','900125774','ramosj','violeta',false,2,'Steffano Fernandez');
-- Clientes
insert into clientes values('0','Lucho Parra','luchitop@gmail.com','967465562','Av Rosales 123','Maria Velazques');
insert into clientes values('0','Enrique Torres','enriquet@gmail.com','987456320','Calle Las Palmas 526','Lucia Flores');
insert into clientes values('0','Josefina Artiaga','josefinaa@gmail.com','998563002','Av Valladolid 12','Julio Artiaga');
insert into clientes values('0','Miguel Hidalgo','miguelh@gmail.com','995220005','Av Arenales 256','Julio Artiaga');
insert into clientes values('0','Jonas Melendez','melendez@gmail.com','925521008','Urb. Monte Azul 24','Julio Artiaga');
insert into clientes values('0','Hector Gomez','gomez@gmail.com','999785100','Av. Arequipa 125','Maria Velazques');
insert into clientes values('0','Francis Pereyra','francisper@gmail.com','900252111','Urb. Cerro Negro 856','Lucia Flores');
insert into clientes values('0','Frank Luna','frankluna@gmail.com','987521101','Av. Espíritu Blanco 47a','Lucia Flores');
insert into clientes values('0','Kiara Juarez','kiarita@gmail.com','925411046','Urb. Del Arco 8s','Maria Velazques');
insert into clientes values('0','Naty Castro','ncastro@gmail.com','966522100','Av. Areqiupa 589','Lucia Flores');
-- Equipos
insert into equipos values('0',1,0,3,'iPhone 11 pro max','13',4,'Maria Velazques','Cambio de pantalla','Listo','2020-09-19');
insert into equipos values('0',2,0,15,'Motorola One Macro','One',4,'Julio Artiaga','Cambio de Touch','Listo','2020-09-23');
insert into equipos values('0',3,0,15,'Moto G8 Plus','G',4,'Lucia Flores','Cambio de pantalla','Listo','2020-09-28');
insert into equipos values('0',4,0,26,'Redmi Note 9 Pro','Redmi Note 9',4,'Maria Velazques','Cambio de batería','Listo','2020-10-02');
insert into equipos values('0',5,0,11,'Huawei Mate 20 Pro','Mate 20',4,'Lucia Flores','Cambio puerto de carga','Listo','2020-10-06');
insert into equipos values('0',6,0,26,'Xiaomi Mi A2','Mi',4,'Maria Velazques','Cambio de pantalla','Listo','2020-10-08');
insert into equipos values('0',7,0,13,'LG Velvet','LG Velvet',1,'Maria Velazques','Recalentamiento','No se pudo hallar solución','2020-10-08');
insert into equipos values('0',8,0,22,'Galaxy A30s','Galaxy A',4,'Lucia Flores','Cambio de cámara','Se uso repuesto para A30','2020-10-16');
insert into equipos values('0',9,0,22,'Galaxy M30s','Galaxy M',2,'Maria Velazques','Botones hundidos','En proceso...','2020-10-18');
insert into equipos values('0',10,0,3,'iPhone 7','7',2,'Julio Artiaga','Recalentamiento de celular','En proceso...','2020-10-20');

insert into equipos values('0',2,1,0,'Acer Spin 5','Spin 5',2,'Lucia Flores','Cambio de visagra','En proceso...','2020-10-10');
insert into equipos values('0',5,1,12,'Lenovo ideapad S145','ideapad S145',0,'Julio Artiaga','Cambio de teclado','','2020-10-11');
insert into equipos values('0',8,1,4,'Asus Vivobook 15','X512JF',1,'Julio Artiaga','Sobrecalentamiento','Placamadre dañada','2020-10-14');
insert into equipos values('0',10,1,26,'Xiaomi Redmibook 16','Redmibook 16',4,'Lucia Flores','Error software','Faltaba actualizar drivers/ ya actualizado','2020-10-18');

insert into equipos values('0',3,4,8,'Multifuncional Epson Ecotank L5190','L5190',4,'Maria Velazques','Recarga de tinta','Listo','2020-10-19');

















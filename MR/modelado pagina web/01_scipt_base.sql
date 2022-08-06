/*==============================================================*/
/* Create Database: favoritesDB                                 */
/*==============================================================*/

create database favoritesDB;

/*==============================================================*/
/* Use Database                                                 */
/*==============================================================*/

use favoritesDB

create table categorias
(
   idcategoria          bigint not null auto_increment  comment '',
   nombre               varchar(200) not null  comment '',
   primary key (idcategoria)
);

/*==============================================================*/
/* Table: favoritos                                             */
/*==============================================================*/
create table favoritos
(
   idfavorito           int not null auto_increment  comment '',
   idusuario            bigint not null  comment '',
   idcliente            bigint not null  comment '',
   fecha                date not null  comment '',
   primary key (idfavorito)
);

/*==============================================================*/
/* Table: permisos                                              */
/*==============================================================*/
create table permisos
(
   idpermiso            bigint not null auto_increment  comment '',
   nombre               varchar(200) not null  comment '',
   ruta                 varchar(100) not null  comment '',
   iconos               varchar(100) not null  comment '',
   primary key (idpermiso)
);

/*==============================================================*/
/* Table: productos                                             */
/*==============================================================*/
create table productos
(
   idproducto           bigint not null auto_increment  comment '',
   idusuario            bigint not null  comment '',
   idcategoria          bigint not null  comment '',
   nombre               varchar(100) not null  comment '',
   cantidad             bigint not null  comment '',
   descripcion          text not null  comment '',
   imagen               varchar(300) not null  comment '',
   fechacreacion        date not null  comment '',
   primary key (idproducto)
);

/*==============================================================*/
/* Table: relproductosfavoritos                                 */
/*==============================================================*/
create table relproductosfavoritos
(
   idrelproducto        bigint not null auto_increment  comment '',
   idproducto           bigint not null  comment '',
   idfavorito           int not null  comment '',
   primary key (idrelproducto)
);

/*==============================================================*/
/* Table: relusuariospermisos                                   */
/*==============================================================*/
create table relusuariospermisos
(
   idrelusuariopermiso  bigint not null auto_increment  comment '',
   idusuario            bigint not null  comment '',
   idpermiso            bigint not null  comment '',
   primary key (idrelusuariopermiso)
);

/*==============================================================*/
/* Table: roles                                                 */
/*==============================================================*/
create table roles
(
   idrol                bigint not null auto_increment  comment '',
   nombre               varchar(100) not null  comment '',
   primary key (idrol)
);

/*==============================================================*/
/* Table: usuarios                                              */
/*==============================================================*/
create table usuarios
(
   idusuario            bigint not null auto_increment  comment '',
   idrol                bigint not null  comment '',
   nombre               varchar(200) not null  comment '',
   apellido             varchar(200) not null  comment '',
   correo               varchar(300) not null  comment '',
   usuario              varchar(40) not null  comment '',
   pass                 varchar(100) not null  comment '',
   primary key (idusuario)
);

alter table favoritos add constraint fk_favorito_reference_usuarios foreign key (idusuario)
      references usuarios (idusuario) on delete restrict on update cascade;

alter table favoritos add constraint fk_favorito_ref_cliente foreign key (idcliente)
      references usuarios (idusuario) on delete restrict on update cascade;

alter table productos add constraint fk_producto_reference_categori foreign key (idcategoria)
      references categorias (idcategoria) on delete restrict on update cascade;

alter table productos add constraint fk_producto_reference_usuarios foreign key (idusuario)
      references usuarios (idusuario) on delete restrict on update cascade;

alter table relproductosfavoritos add constraint fk_relprodu_reference_producto foreign key (idproducto)
      references productos (idproducto) on delete restrict on update cascade;

alter table relproductosfavoritos add constraint fk_relprodu_reference_favorito foreign key (idfavorito)
      references favoritos (idfavorito) on delete restrict on update cascade;

alter table relusuariospermisos add constraint fk_relusuar_reference_permisos foreign key (idpermiso)
      references permisos (idpermiso) on delete restrict on update cascade;

alter table relusuariospermisos add constraint fk_relusuar_reference_usuarios foreign key (idusuario)
      references usuarios (idusuario) on delete restrict on update cascade;

alter table usuarios add constraint fk_usuarios_reference_roles foreign key (idrol)
      references roles (idrol) on delete restrict on update cascade;


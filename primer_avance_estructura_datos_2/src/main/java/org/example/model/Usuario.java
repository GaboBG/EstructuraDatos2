package org.example.model;

import java.time.LocalDate;



    public class Usuario extends BaseModel {

        private String usuario;
        private String password;
        private String primerNombre;
        private String primerApellido;
        private String segundoApellido;
        private LocalDate fechaNacimiento;
        private String genero;

        private String avatar;

        private Grupo grupo;


        public Usuario() {

        }

        public Usuario(int id, LocalDate fechaCreacion, LocalDate fechaModificacion, String usuario, String password, String primerNombre, String primerApellido, String segundoApellido, LocalDate fechaNacimiento, String genero, String avatar, Grupo grupo) {
            super(id, fechaCreacion, fechaModificacion);
            this.usuario = usuario;
            this.password = password;
            this.primerNombre = primerNombre;
            this.primerApellido = primerApellido;
            this.segundoApellido = segundoApellido;
            this.fechaNacimiento = fechaNacimiento;
            this.genero = genero;
            this.avatar = avatar;
            this.grupo = grupo;
        }

        public String getUsuario() {
            return usuario;
        }

        public void setUsuario(String usuario) {
            this.usuario = usuario;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPrimerNombre() {
            return primerNombre;
        }

        public void setPrimerNombre(String primerNombre) {
            this.primerNombre = primerNombre;
        }

        public String getPrimerApellido() {
            return primerApellido;
        }

        public void setPrimerApellido(String primerApellido) {
            this.primerApellido = primerApellido;
        }

        public String getSegundoApellido() {
            return segundoApellido;
        }

        public void setSegundoApellido(String segundoApellido) {
            this.segundoApellido = segundoApellido;
        }

        public LocalDate getFechaNacimiento() {
            return fechaNacimiento;
        }

        public void setFechaNacimiento(LocalDate fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public Grupo getGrupo() {
            return grupo;
        }

        public void setGrupo(Grupo grupo) {
            this.grupo = grupo;
        }
    }

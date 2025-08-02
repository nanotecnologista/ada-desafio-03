package br.com.nanotech.model;

    public abstract class User {
        private String password;
        protected String email;
        public String name;

        public User(String name, String email, String password) {
            this.name = name;
            this.email = email;
            this.password = password;
        }

        public abstract boolean authenticate(String password);

        public final void displayUser() {
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
        }

        protected String getPassword() {
            return password;
        }

        protected void setPassword(String password) {
            this.password = password;
        }
    }
package br.com.nanotech.model;

import br.com.nanotech.utils.SecurityUtils;

public class Adm extends User {
    public Adm(String name, String email, String password) {
        super(name, email, password);
    }

    @Override
    public boolean authenticate(String password) {
        return password.equals(getPassword());
    }

    public void resetPassword(String newPassword) {
        if (SecurityUtils.isStrongPassword(newPassword)) {
            setPassword(newPassword);
            System.out.println("Password successfully reset!");
        } else {
            System.out.println("The password does not meet security requirements.");
        }
    }
}
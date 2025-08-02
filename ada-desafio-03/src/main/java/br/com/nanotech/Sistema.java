package br.com.nanotech;

import br.com.nanotech.model.Adm;
import br.com.nanotech.utils.SecurityUtils;

public class Sistema {
    public static void main(String[] args) {
        Adm admin = new Adm("Juba da Silva", "juba@juba.com", "1234");
        System.out.println("Nome: " + admin.name);

        System.out.println("Autentica com senha: " + admin.authenticate("errada"));
        System.out.println("Autenticação com senha correta: " + admin.authenticate("1234"));

        admin.displayUser();

        admin.resetPassword("senha33311");
        admin.resetPassword("senha33311");

        System.out.println("\nValidando senhas com SecurityUtils:");
        System.out.println("'abc123': " + SecurityUtils.isStrongPassword("abc123"));
        System.out.println("'outraSenha123': " + SecurityUtils.isStrongPassword("outraSenha123"));
    }
}

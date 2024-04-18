package br.com.celsonfernando.gestao_vagas.exceptions;

public class UserFoundExecption extends RuntimeException {
    public UserFoundExecption() {
        super("Usuario já existe");
    }
}

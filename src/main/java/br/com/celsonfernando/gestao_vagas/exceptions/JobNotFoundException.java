package br.com.celsonfernando.gestao_vagas.exceptions;

public class JobNotFoundException  extends RuntimeException {
    public JobNotFoundException() {
        super("Job não existe");
    }
}

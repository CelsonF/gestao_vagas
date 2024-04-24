package br.com.celsonfernando.gestao_vagas.modules.company.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.celsonfernando.gestao_vagas.exceptions.UserFoundExecption;
import br.com.celsonfernando.gestao_vagas.modules.company.entities.CompanyEntity;
import br.com.celsonfernando.gestao_vagas.modules.company.repositories.*;;

@Service
public class CreateCompanyUseCase {
    
    @Autowired
    private CompanyRepository companyRepository;


    public CompanyEntity execute(CompanyEntity companyEntity)
    {
        this.companyRepository
        .findByUsernameOrEmail(companyEntity.getUsername(),companyEntity.getName())
        .ifPresent((user) -> {
            throw new UserFoundExecption();
        });

        return this.companyRepository.save(companyEntity);
    }

    
}

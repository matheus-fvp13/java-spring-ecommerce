package edu.mfvp.javaspringecommerce.infrastructure.config;

import edu.mfvp.javaspringecommerce.domain.category.gateways.CategoryRepositoryGateway;
import edu.mfvp.javaspringecommerce.domain.category.usecases.CreateCategoryUseCase;
import edu.mfvp.javaspringecommerce.domain.category.usecases.impl.CreateCategoryUseCaseImpl;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.category.gateways.JpaCategoryRepositoryGateway;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.category.mappers.CategoryMapper;
import edu.mfvp.javaspringecommerce.infrastructure.persistence.category.repositories.JpaCategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryConfig {
    @Bean
    CategoryMapper getCategoryMapper(ModelMapper modelMapper) {
        return new CategoryMapper(modelMapper);
    }

    @Bean
    CategoryRepositoryGateway getCategoryRepositoryGateway(CategoryMapper mapper, JpaCategoryRepository repository) {
        return new JpaCategoryRepositoryGateway(mapper, repository);
    }

    @Bean
    CreateCategoryUseCase getCreateCategoryUseCase(CategoryRepositoryGateway gateway) {
        return new CreateCategoryUseCaseImpl(gateway);
    }
}

package edu.mfvp.javaspringecommerce.infrastructure.persistence.product.entities;

import java.util.HashSet;
import java.util.Set;

import edu.mfvp.javaspringecommerce.infrastructure.persistence.category.entities.CategoryEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;

@Getter
@Setter
@Entity(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 100)
    private String name;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false, name = "img_url")
    private String imgUrl;

    @Setter(AccessLevel.NONE)
    @ManyToMany
    @JoinTable(
        name = "products_categories", 
        joinColumns = @JoinColumn(name = "product_id"), 
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<CategoryEntity> categories = new HashSet<>();

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProductEntity other = (ProductEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

}

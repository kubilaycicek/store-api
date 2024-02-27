package com.kubilaycicek.store.data.specification;

import com.kubilaycicek.store.data.model.Phone;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;


public class PhoneSpecification {

    public static Specification<Phone> searchPhone(String search) {
        return (root, query, criteriaBuilder) -> {
            Predicate brandPredicate = criteriaBuilder.like(root.get("phoneBrand"), likePattern(search));
            Predicate namePredicate = criteriaBuilder.like(root.get("phoneName"), likePattern(search));
            return criteriaBuilder.or(namePredicate, brandPredicate);
        };
    }

    public static Specification<Phone> hasBrand(String phoneBrand) {
        return (root, query, criteriaBuilder) -> {
            Predicate phoneBrandPredicate = criteriaBuilder.equal(root.get("phoneBrand"), phoneBrand);
            return criteriaBuilder.and(phoneBrandPredicate);
        };
    }

    private static String likePattern(String value) {
        return "%" + value + "%";
    }
}

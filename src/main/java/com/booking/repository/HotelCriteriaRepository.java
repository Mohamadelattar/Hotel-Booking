package com.booking.repository;

import com.booking.model.Hotel;
import com.booking.model.HotelPage;
import com.booking.model.HotelSearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class HotelCriteriaRepository {

    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    @Autowired
    public HotelCriteriaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    public Page<Hotel> findAllWithFilters(HotelPage hotelPage,
                                          HotelSearchCriteria hotelSearchCriteria){
        CriteriaQuery<Hotel> criteriaQuery = criteriaBuilder.createQuery(Hotel.class);
        Root<Hotel> hotelRoot = criteriaQuery.from(Hotel.class);
        Predicate predicate = getPredicate(hotelSearchCriteria, hotelRoot);
        criteriaQuery.where(predicate);
        setOrder(hotelPage, criteriaQuery, hotelRoot);

        TypedQuery<Hotel> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(hotelPage.getPageNumber() * hotelPage.getPageSize());
        typedQuery.setMaxResults(hotelPage.getPageSize());

        Pageable pageable = getPageable(hotelPage);

        long hotelsCount = getHotelsCount(predicate);

        return new PageImpl<>(typedQuery.getResultList(), pageable, hotelsCount);
    }

    private Predicate getPredicate(HotelSearchCriteria hotelSearchCriteria,
                                   Root<Hotel> hotelRoot) {
        List<Predicate> predicates = new ArrayList<>();
        if(Objects.nonNull(hotelSearchCriteria.getName())){
            predicates.add(
                    criteriaBuilder.like(hotelRoot.get("name"),
                            "%" + hotelSearchCriteria.getName() + "%")
            );
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    private void setOrder(HotelPage hotelPage,
                          CriteriaQuery<Hotel> criteriaQuery,
                          Root<Hotel> hotelRoot) {
        if(hotelPage.getSortDirection().equals(Sort.Direction.ASC)){
            criteriaQuery.orderBy(criteriaBuilder.asc(hotelRoot.get(hotelPage.getSortBy())));
        } else {
            criteriaQuery.orderBy(criteriaBuilder.desc(hotelRoot.get(hotelPage.getSortBy())));
        }
    }

    private Pageable getPageable(HotelPage hotelPage) {
        Sort sort = Sort.by(hotelPage.getSortDirection(), hotelPage.getSortBy());
        return PageRequest.of(hotelPage.getPageNumber(),hotelPage.getPageSize(), sort);
    }

    private long getHotelsCount(Predicate predicate) {
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<Hotel> countRoot = countQuery.from(Hotel.class);
        countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
        return entityManager.createQuery(countQuery).getSingleResult();
    }
}

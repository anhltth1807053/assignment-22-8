package com.demo.entity.specification;

import com.demo.entity.Dogs;
import com.demo.entity.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class   DogSpecification implements Specification<Dogs> {

    private SearchCriteria searchCriteria;

    public DogSpecification(SearchCriteria searchCriteria){
        this.searchCriteria =searchCriteria;
    }

    //thực thi tìm kiếm, lọc search creteria truyền vào
    @Override
    public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
          if (this.searchCriteria.getOperation().equals("=")){
              //tim theo gia tri
              if (root.get(searchCriteria.getKey()).getJavaType() == String.class) {
                  //search theo like neu la tim kiem theo String
                  return criteriaBuilder.like(
                          root.get(searchCriteria.getKey()), "%" + searchCriteria.getValue() + "%");
              }else{
                    return criteriaBuilder.equal(
                    root.get(this.searchCriteria.getKey()),this.searchCriteria.getValue().toString());
              }
          }else  if (this.searchCriteria.getOperation().equals(">")){
              //tim theo gia tri
              return criteriaBuilder.greaterThan(
                      root.get(this.searchCriteria.getKey()),
                      this.searchCriteria.getValue().toString());
          }else if (this.searchCriteria.getOperation().equals(">=")){
              return criteriaBuilder.greaterThanOrEqualTo(
                      root.get(this.searchCriteria.getKey()),
                      this.searchCriteria.getValue().toString());
          }else  if (this.searchCriteria.getOperation().equals("<")){
              return criteriaBuilder.lessThan(
                      root.get(this.searchCriteria.getKey()),
                      this.searchCriteria.getValue().toString());
          }else if (this.searchCriteria.getOperation().equals("<=")){
              return criteriaBuilder.lessThanOrEqualTo(
                      root.get(this.searchCriteria.getKey()),
                      this.searchCriteria.getValue().toString());
          }
          return null;
    }

}

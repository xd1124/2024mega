package com.application.jpa.chapter03_persistenceQueries;

import java.util.List;

import org.springframework.data.jpa.repository.query.JpaQueryExecution;
import org.springframework.stereotype.Repository;

import com.application.jpa.entity.Product;
import com.application.jpa.entity.QBrand;
import com.application.jpa.entity.QProduct;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final 키워드가 붙거나 @NonNull 어노테이션이 붙은 필드에 대한 생성자를 자동으로 생성
@Repository
public class QueryDslRepositoryCustomImpl implements QueryDslRepositoryCustom {

	/*
	
		JPAQueryFactory는 QueryDSL의 핵심 클래스 중 하나로 JPA 엔티티에 대한 쿼리를 생성하고 실행하는 메서드를 제공한다. 
		이 필드는 @RequiredArgsConstructor에 의해 생성되는 생성자를 통해 자동으로 주입된다.
	
	*/
	
	private final JPAQueryFactory queryFactory;
	
	/*
	  
		QProduct와 QBrand는 QueryDSL이 엔티티 클래스(Product와 Brand)로부터 자동으로 생성한 Q-타입 클래스이다.
		이 클래스들은 타입 세이프 쿼리를 작성할 때 해당 엔티티의 필드에 접근하는 데 사용되며
		Product와 Brand 엔티티에 대한 복잡한 쿼리나 조건을 처리하는 커스텀 리포지토리 메서드를 작성할 수 있다.
	
	*/
	
	QProduct product = QProduct.product;
	QBrand brand = QBrand.brand;
	
	@Override
	public List<Product> basicEx() {
		return queryFactory
			   .selectFrom(product)
			   .fetch();
	}

	@Override
	public List<Product> whereEx(Integer start, Integer end) {
		return queryFactory
			   .selectFrom(product)
			   .where(product.price.between(start, end))
			   .fetch();
	}

	@Override
	public List<Product> orderByEx(Integer deliveryPrice) {
		return queryFactory
			   .selectFrom(product)
			   .where(product.deliveryPrice.eq(deliveryPrice))
			   .orderBy(product.price.desc())
			   .fetch();
	}

	@Override
	public List<Tuple> groupByEx() {
		List<Tuple> results =  queryFactory
							   .select(product.deliveryPrice , product.price.avg())
							   .from(product)
							   .groupBy(product.deliveryPrice)
							   .fetch();
		
//		for (Tuple tuple : results) {
//			//System.out.println(tuple);
//			System.out.println(tuple.get(product.deliveryPrice));
//			System.out.println(tuple.get(product.price.avg()));
//			System.out.println();
//		}
		
		return results;
		
	}

	@Override
	public List<Product> joinEx(String activeYn) {
		return queryFactory
			  .select(product)
			  .from(product)
			  .join(product.brand , brand) // 조인 조건
			  .where(brand.activeYn.eq(activeYn))
			  .fetch();
	}

	@Override
	public List<Product> subqueryEx() {
		return queryFactory
			   .selectFrom(product)
			   .where(product.price.goe(JPAExpressions.
					   					select(product.price.avg())
					   					.from(product)))
			   .fetch();
	}

}

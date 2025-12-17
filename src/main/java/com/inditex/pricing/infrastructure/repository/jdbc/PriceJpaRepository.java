package com.inditex.pricing.infrastructure.repository.jdbc;

import com.inditex.pricing.infrastructure.repository.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceJpaRepository extends JpaRepository<PriceEntity, Long> {

    @Query("""
        select p
        from PriceEntity p
        join fetch p.brand b
        where p.brand.id = :brandId
          and p.productId = :productId
          and :date between p.startDate and p.endDate
        order by p.priority desc
    """)
    List<PriceEntity> findByBrandIdProductIdAndDate(@Param("brandId") long brandId,
                                                    @Param("productId") long productId,
                                                    @Param("date") LocalDateTime date);
}

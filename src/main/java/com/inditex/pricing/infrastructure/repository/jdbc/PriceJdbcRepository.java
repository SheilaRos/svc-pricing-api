package com.inditex.pricing.infrastructure.repository.jdbc;

import com.inditex.pricing.infrastructure.repository.entity.PriceEntity;
import com.inditex.pricing.infrastructure.repository.entity.PriceProjection;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceJdbcRepository extends CrudRepository<PriceEntity, String> {

    @Query("""
            SELECT p.*, b.name as BRAND_NAME
            from PRICE p
            INNER JOIN BRAND b on p.BRAND_ID = b.ID
            WHERE p.BRAND_ID = :brandId AND p.PROJECT_ID = :projectId
            AND :date BETWEEN START_DATE AND END_DATE
            ORDER BY p.PRIORITY DESC
            LIMIT 1;
            """)
    Optional<PriceProjection> findByBrandIdProjectIdAndDate(long brandId, long projectId, LocalDateTime date);
}

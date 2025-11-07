package com.inditex.pricing.domain.entity;

import com.inditex.pricing.domain.valueobject.*;

public final class Tariff {
    private final TariffId id;
    private final Price price;
    private final Brand brand;
    private final ProductId productId;
    private final Priority priority;
    private final DateTime startDate;
    private final DateTime endDate;

    private Tariff(TariffId id, Price price, Brand brand, ProductId productId, Priority priority,
                   DateTime startDate, DateTime endDate) {
        this.id = id;
        this.price = price;
        this.brand = brand;
        this.productId = productId;
        this.priority = priority;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public TariffId getId() {
        return id;
    }

    public Price getPrice() {
        return price;
    }

    public Brand getBrand() {
        return brand;
    }

    public ProductId getProductId() {
        return productId;
    }

    public Priority getPriority() {
        return priority;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public DateTime getEndDate() {
        return endDate;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private TariffId id;
        private Price price;
        private Brand brand;
        private ProductId productId;
        private Priority priority;
        private DateTime startDate;
        private DateTime endDate;

        public Builder() {}

        public Builder withTariffId(TariffId id) {
            this.id = id;
            return this;
        }

        public Builder withPrice(Price price) {
            this.price = price;
            return this;
        }

        public Builder withBrand(Brand brand) {
            this.brand = brand;
            return this;
        }

        public Builder withProductId(ProductId productId) {
            this.productId = productId;
            return this;
        }

        public Builder withPriority(Priority priority) {
            this.priority = priority;
            return this;
        }

        public Builder withStartDate(DateTime dateTime) {
            this.startDate = dateTime;
            return this;
        }

        public Builder withEndDate(DateTime dateTime) {
            this.endDate = dateTime;
            return this;
        }

        public Tariff build() {
            return new Tariff(id, price, brand, productId, priority, startDate, endDate);
        }
    }
}

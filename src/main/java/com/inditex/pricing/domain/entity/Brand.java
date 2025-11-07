package com.inditex.pricing.domain.entity;

import com.inditex.pricing.domain.valueobject.BrandId;
import com.inditex.pricing.domain.valueobject.BrandName;

public final class Brand {
    private final BrandId id;
    private final BrandName name;

    private Brand(BrandId id, BrandName name) {
        this.id = id;
        this.name = name;
    }

    public BrandId getId() {
        return id;
    }

    public BrandName getName() {
        return name;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private BrandId id;
        private BrandName name;

        public Builder() {}

        public Builder withId(BrandId id) {
            this.id = id;
            return this;
        }

        public Builder withName(BrandName name) {
            this.name = name;
            return this;
        }

        public Brand build() {
            return new Brand(id, name);
        }
    }
}

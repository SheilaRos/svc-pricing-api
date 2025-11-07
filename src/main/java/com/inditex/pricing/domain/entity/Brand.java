package com.inditex.pricing.domain.entity;

import com.inditex.pricing.domain.exception.BrandNameCannotBeNullException;

public final class Brand {
    private final long id;
    private final String name;

    private Brand(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private long id;
        private String name;

        public Builder() {}

        public Builder withId(long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Brand build() {
            validate(name);
            return new Brand(id, name);
        }

        private void validate(String name) {
            if (name == null || name.trim().isEmpty()) {
                throw new BrandNameCannotBeNullException();
            }
        }
    }
}

package com.inditex.pricing.domain.valueobject;

import com.inditex.pricing.domain.exception.CurrencyCannotBeNullOrEmptyException;
import com.inditex.pricing.domain.exception.InvalidCurrencyException;

public enum Currency {
    EUR("Euro"),
    USD("United States Dollar"),
    GBP("Pound Sterling"),
    JPY("Japanese Yen"),
    CHF("Swiss Franc"),
    CAD("Canadian Dollar"),
    AUD("Australian Dollar"),
    NZD("New Zealand Dollar"),
    CNY("Chinese Yuan Renminbi"),
    HKD("Hong Kong Dollar"),
    SEK("Swedish Krona"),
    NOK("Norwegian Krone"),
    DKK("Danish Krone"),
    MXN("Mexican Peso"),
    BRL("Brazilian Real"),
    ARS("Argentine Peso"),
    CLP("Chilean Peso"),
    COP("Colombian Peso"),
    PEN("Peruvian Sol"),
    RUB("Russian Ruble"),
    INR("Indian Rupee"),
    KRW("South Korean Won"),
    SGD("Singapore Dollar"),
    ZAR("South African Rand"),
    TRY("Turkish Lira"),
    AED("UAE Dirham"),
    SAR("Saudi Riyal"),
    ILS("Israeli Shekel"),
    PLN("Polish Zloty"),
    CZK("Czech Koruna"),
    HUF("Hungarian Forint"),
    RON("Romanian Leu"),
    THB("Thai Baht"),
    IDR("Indonesian Rupiah"),
    MYR("Malaysian Ringgit"),
    PHP("Philippine Peso"),
    VND("Vietnamese Dong"),
    EGP("Egyptian Pound"),
    NGN("Nigerian Naira"),
    MAD("Moroccan Dirham"),
    KWD("Kuwaiti Dinar"),
    BHD("Bahraini Dinar"),
    QAR("Qatari Riyal"),
    PKR("Pakistani Rupee"),
    BDT("Bangladeshi Taka"),
    LKR("Sri Lankan Rupee"),
    UAH("Ukrainian Hryvnia"),
    UYU("Uruguayan Peso"),
    BOB("Bolivian Boliviano"),
    PYG("Paraguayan Guarani"),
    DOP("Dominican Peso"),
    CRC("Costa Rican Colon"),
    GTQ("Guatemalan Quetzal"),
    HNL("Honduran Lempira");

    private final String name;

    Currency(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return name();
    }

    public static Currency of(String currency) {
        if (currency == null) {
            throw new CurrencyCannotBeNullOrEmptyException();
        }

        try {
            return Currency.valueOf(currency);
        } catch (IllegalArgumentException e) {
            throw new InvalidCurrencyException(currency);
        }
    }
}

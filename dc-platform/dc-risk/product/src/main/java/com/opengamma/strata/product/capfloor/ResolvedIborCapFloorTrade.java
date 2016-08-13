/**
 * Copyright (C) 2016 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.product.capfloor;

import java.io.Serializable;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.ImmutableDefaults;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.strata.basics.ReferenceData;
import com.opengamma.strata.basics.currency.Payment;
import com.opengamma.strata.product.ResolvedTrade;
import com.opengamma.strata.product.TradeInfo;

/**
 * A trade in an Ibor cap/floor, resolved for pricing.
 * <p>
 * This is the resolved form of {@link IborCapFloorTrade} and is the primary input to the pricers.
 * Applications will typically create a {@code ResolvedIborCapFloorTrade} from a {@code IborCapFloorTrade}
 * using {@link IborCapFloorTrade#resolve(ReferenceData)}.
 * <p>
 * A {@code ResolvedIborCapFloorTrade} is bound to data that changes over time, such as holiday calendars.
 * If the data changes, such as the addition of a new holiday, the resolved form will not be updated.
 * Care must be taken when placing the resolved form in a cache or persistence layer.
 */
@BeanDefinition
public final class ResolvedIborCapFloorTrade
    implements ResolvedTrade, ImmutableBean, Serializable {

  /**
   * The additional trade information, defaulted to an empty instance.
   * <p>
   * This allows additional information to be attached to the trade.
   */
  @PropertyDefinition(overrideGet = true)
  private final TradeInfo info;
  /**
   * The resolved Ibor cap/floor product.
   * <p>
   * The product captures the contracted financial details of the trade.
   */
  @PropertyDefinition(validate = "notNull", overrideGet = true)
  private final ResolvedIborCapFloor product;
  /**
   * The optional premium of the product.
   * <p>
   * For most Ibor cap/floor products, a premium is paid upfront. This typically occurs instead
   * of periodic payments based on fixed or Ibor rates over the lifetime of the product.
   * <p>
   * The premium sign must be compatible with the product Pay/Receive flag.
   */
  @PropertyDefinition(get = "optional")
  private final Payment premium;

  //-------------------------------------------------------------------------
  @ImmutableDefaults
  private static void applyDefaults(Builder builder) {
    builder.info = TradeInfo.empty();
  }

    //------------------------- AUTOGENERATED START -------------------------
    ///CLOVER:OFF
    /**
     * The meta-bean for {@code ResolvedIborCapFloorTrade}.
     * @return the meta-bean, not null
     */
    public static ResolvedIborCapFloorTrade.Meta meta() {
        return ResolvedIborCapFloorTrade.Meta.INSTANCE;
    }

    static {
        JodaBeanUtils.registerMetaBean(ResolvedIborCapFloorTrade.Meta.INSTANCE);
    }

    /**
     * The serialization version id.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Returns a builder used to create an instance of the bean.
     * @return the builder, not null
     */
    public static ResolvedIborCapFloorTrade.Builder builder() {
        return new ResolvedIborCapFloorTrade.Builder();
    }

    private ResolvedIborCapFloorTrade(
            TradeInfo info,
            ResolvedIborCapFloor product,
            Payment premium) {
        JodaBeanUtils.notNull(product, "product");
        this.info = info;
        this.product = product;
        this.premium = premium;
    }

    @Override
    public ResolvedIborCapFloorTrade.Meta metaBean() {
        return ResolvedIborCapFloorTrade.Meta.INSTANCE;
    }

    @Override
    public <R> Property<R> property(String propertyName) {
        return metaBean().<R>metaProperty(propertyName).createProperty(this);
    }

    @Override
    public Set<String> propertyNames() {
        return metaBean().metaPropertyMap().keySet();
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the additional trade information, defaulted to an empty instance.
     * <p>
     * This allows additional information to be attached to the trade.
     * @return the value of the property
     */
    @Override
    public TradeInfo getInfo() {
        return info;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the resolved Ibor cap/floor product.
     * <p>
     * The product captures the contracted financial details of the trade.
     * @return the value of the property, not null
     */
    @Override
    public ResolvedIborCapFloor getProduct() {
        return product;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the optional premium of the product.
     * <p>
     * For most Ibor cap/floor products, a premium is paid upfront. This typically occurs instead
     * of periodic payments based on fixed or Ibor rates over the lifetime of the product.
     * <p>
     * The premium sign must be compatible with the product Pay/Receive flag.
     * @return the optional value of the property, not null
     */
    public Optional<Payment> getPremium() {
        return Optional.ofNullable(premium);
    }

    //-----------------------------------------------------------------------
    /**
     * Returns a builder that allows this bean to be mutated.
     * @return the mutable builder, not null
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == this.getClass()) {
            ResolvedIborCapFloorTrade other = (ResolvedIborCapFloorTrade) obj;
            return JodaBeanUtils.equal(info, other.info) &&
                    JodaBeanUtils.equal(product, other.product) &&
                    JodaBeanUtils.equal(premium, other.premium);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = getClass().hashCode();
        hash = hash * 31 + JodaBeanUtils.hashCode(info);
        hash = hash * 31 + JodaBeanUtils.hashCode(product);
        hash = hash * 31 + JodaBeanUtils.hashCode(premium);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(128);
        buf.append("ResolvedIborCapFloorTrade{");
        buf.append("info").append('=').append(info).append(',').append(' ');
        buf.append("product").append('=').append(product).append(',').append(' ');
        buf.append("premium").append('=').append(JodaBeanUtils.toString(premium));
        buf.append('}');
        return buf.toString();
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-bean for {@code ResolvedIborCapFloorTrade}.
     */
    public static final class Meta extends DirectMetaBean {
        /**
         * The singleton instance of the meta-bean.
         */
        static final Meta INSTANCE = new Meta();

        /**
         * The meta-property for the {@code info} property.
         */
        private final MetaProperty<TradeInfo> info = DirectMetaProperty.ofImmutable(
                this, "info", ResolvedIborCapFloorTrade.class, TradeInfo.class);
        /**
         * The meta-property for the {@code product} property.
         */
        private final MetaProperty<ResolvedIborCapFloor> product = DirectMetaProperty.ofImmutable(
                this, "product", ResolvedIborCapFloorTrade.class, ResolvedIborCapFloor.class);
        /**
         * The meta-property for the {@code premium} property.
         */
        private final MetaProperty<Payment> premium = DirectMetaProperty.ofImmutable(
                this, "premium", ResolvedIborCapFloorTrade.class, Payment.class);
        /**
         * The meta-properties.
         */
        private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
                this, null,
                "info",
                "product",
                "premium");

        /**
         * Restricted constructor.
         */
        private Meta() {
        }

        @Override
        protected MetaProperty<?> metaPropertyGet(String propertyName) {
            switch (propertyName.hashCode()) {
                case 3237038:  // info
                    return info;
                case -309474065:  // product
                    return product;
                case -318452137:  // premium
                    return premium;
            }
            return super.metaPropertyGet(propertyName);
        }

        @Override
        public ResolvedIborCapFloorTrade.Builder builder() {
            return new ResolvedIborCapFloorTrade.Builder();
        }

        @Override
        public Class<? extends ResolvedIborCapFloorTrade> beanType() {
            return ResolvedIborCapFloorTrade.class;
        }

        @Override
        public Map<String, MetaProperty<?>> metaPropertyMap() {
            return metaPropertyMap$;
        }

        //-----------------------------------------------------------------------
        /**
         * The meta-property for the {@code info} property.
         * @return the meta-property, not null
         */
        public MetaProperty<TradeInfo> info() {
            return info;
        }

        /**
         * The meta-property for the {@code product} property.
         * @return the meta-property, not null
         */
        public MetaProperty<ResolvedIborCapFloor> product() {
            return product;
        }

        /**
         * The meta-property for the {@code premium} property.
         * @return the meta-property, not null
         */
        public MetaProperty<Payment> premium() {
            return premium;
        }

        //-----------------------------------------------------------------------
        @Override
        protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
            switch (propertyName.hashCode()) {
                case 3237038:  // info
                    return ((ResolvedIborCapFloorTrade) bean).getInfo();
                case -309474065:  // product
                    return ((ResolvedIborCapFloorTrade) bean).getProduct();
                case -318452137:  // premium
                    return ((ResolvedIborCapFloorTrade) bean).premium;
            }
            return super.propertyGet(bean, propertyName, quiet);
        }

        @Override
        protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
            metaProperty(propertyName);
            if (quiet) {
                return;
            }
            throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
        }

    }

    //-----------------------------------------------------------------------
    /**
     * The bean-builder for {@code ResolvedIborCapFloorTrade}.
     */
    public static final class Builder extends DirectFieldsBeanBuilder<ResolvedIborCapFloorTrade> {

        private TradeInfo info;
        private ResolvedIborCapFloor product;
        private Payment premium;

        /**
         * Restricted constructor.
         */
        private Builder() {
            applyDefaults(this);
        }

        /**
         * Restricted copy constructor.
         * @param beanToCopy  the bean to copy from, not null
         */
        private Builder(ResolvedIborCapFloorTrade beanToCopy) {
            this.info = beanToCopy.getInfo();
            this.product = beanToCopy.getProduct();
            this.premium = beanToCopy.premium;
        }

        //-----------------------------------------------------------------------
        @Override
        public Object get(String propertyName) {
            switch (propertyName.hashCode()) {
                case 3237038:  // info
                    return info;
                case -309474065:  // product
                    return product;
                case -318452137:  // premium
                    return premium;
                default:
                    throw new NoSuchElementException("Unknown property: " + propertyName);
            }
        }

        @Override
        public Builder set(String propertyName, Object newValue) {
            switch (propertyName.hashCode()) {
                case 3237038:  // info
                    this.info = (TradeInfo) newValue;
                    break;
                case -309474065:  // product
                    this.product = (ResolvedIborCapFloor) newValue;
                    break;
                case -318452137:  // premium
                    this.premium = (Payment) newValue;
                    break;
                default:
                    throw new NoSuchElementException("Unknown property: " + propertyName);
            }
            return this;
        }

        @Override
        public Builder set(MetaProperty<?> property, Object value) {
            super.set(property, value);
            return this;
        }

        @Override
        public Builder setString(String propertyName, String value) {
            setString(meta().metaProperty(propertyName), value);
            return this;
        }

        @Override
        public Builder setString(MetaProperty<?> property, String value) {
            super.setString(property, value);
            return this;
        }

        @Override
        public Builder setAll(Map<String, ? extends Object> propertyValueMap) {
            super.setAll(propertyValueMap);
            return this;
        }

        @Override
        public ResolvedIborCapFloorTrade build() {
            return new ResolvedIborCapFloorTrade(
                    info,
                    product,
                    premium);
        }

        //-----------------------------------------------------------------------
        /**
         * Sets the additional trade information, defaulted to an empty instance.
         * <p>
         * This allows additional information to be attached to the trade.
         * @param info  the new value
         * @return this, for chaining, not null
         */
        public Builder info(TradeInfo info) {
            this.info = info;
            return this;
        }

        /**
         * Sets the resolved Ibor cap/floor product.
         * <p>
         * The product captures the contracted financial details of the trade.
         * @param product  the new value, not null
         * @return this, for chaining, not null
         */
        public Builder product(ResolvedIborCapFloor product) {
            JodaBeanUtils.notNull(product, "product");
            this.product = product;
            return this;
        }

        /**
         * Sets the optional premium of the product.
         * <p>
         * For most Ibor cap/floor products, a premium is paid upfront. This typically occurs instead
         * of periodic payments based on fixed or Ibor rates over the lifetime of the product.
         * <p>
         * The premium sign must be compatible with the product Pay/Receive flag.
         * @param premium  the new value
         * @return this, for chaining, not null
         */
        public Builder premium(Payment premium) {
            this.premium = premium;
            return this;
        }

        //-----------------------------------------------------------------------
        @Override
        public String toString() {
            StringBuilder buf = new StringBuilder(128);
            buf.append("ResolvedIborCapFloorTrade.Builder{");
            buf.append("info").append('=').append(JodaBeanUtils.toString(info)).append(',').append(' ');
            buf.append("product").append('=').append(JodaBeanUtils.toString(product)).append(',').append(' ');
            buf.append("premium").append('=').append(JodaBeanUtils.toString(premium));
            buf.append('}');
            return buf.toString();
        }

    }

    ///CLOVER:ON
    //-------------------------- AUTOGENERATED END --------------------------
}

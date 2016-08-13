/**
 * Copyright (C) 2014 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.product.rate;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.google.common.collect.ImmutableSet;
import com.opengamma.strata.basics.ReferenceData;
import com.opengamma.strata.basics.currency.Currency;
import com.opengamma.strata.basics.index.IborIndex;
import com.opengamma.strata.basics.index.IborIndexObservation;
import com.opengamma.strata.basics.index.Index;

/**
 * Defines the computation of a rate of interest from a single Ibor index.
 * <p>
 * An interest rate determined directly from an Ibor index.
 * For example, a rate determined from 'GBP-LIBOR-3M' on a single fixing date.
 */
@BeanDefinition(builderScope = "private")
public final class IborRateComputation
    implements RateComputation, ImmutableBean, Serializable {

  /**
   * The underlying index observation.
   */
  @PropertyDefinition(validate = "notNull")
  private final IborIndexObservation observation;

  //-------------------------------------------------------------------------
  /**
   * Creates an instance from an index and fixing date.
   * <p>
   * The reference data is used to find the maturity date from the fixing date.
   * 
   * @param index  the index
   * @param fixingDate  the fixing date
   * @param refData  the reference data to use when resolving holiday calendars
   * @return the rate computation
   */
  public static IborRateComputation of(IborIndex index, LocalDate fixingDate, ReferenceData refData) {
    return new IborRateComputation(IborIndexObservation.of(index, fixingDate, refData));
  }

  /**
   * Creates an instance from the underlying index observation.
   * 
   * @param underlyingObservation  the underlying index observation
   * @return the rate computation
   */
  public static IborRateComputation of(IborIndexObservation underlyingObservation) {
    return new IborRateComputation(underlyingObservation);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the Ibor index.
   * 
   * @return the index
   */
  public IborIndex getIndex() {
    return observation.getIndex();
  }

  /**
   * Gets the currency of the Ibor index.
   * 
   * @return the currency of the index
   */
  public Currency getCurrency() {
    return getIndex().getCurrency();
  }

  /**
   * Gets the fixing date.
   * 
   * @return the fixing date
   */
  public LocalDate getFixingDate() {
    return observation.getFixingDate();
  }

  /**
   * Gets the effective date.
   * 
   * @return the effective date
   */
  public LocalDate getEffectiveDate() {
    return observation.getEffectiveDate();
  }

  /**
   * Gets the maturity date.
   * 
   * @return the maturity date
   */
  public LocalDate getMaturityDate() {
    return observation.getMaturityDate();
  }

  /**
   * Gets the year fraction.
   * 
   * @return the year fraction
   */
  public double getYearFraction() {
    return observation.getYearFraction();
  }

  //-------------------------------------------------------------------------
  @Override
  public void collectIndices(ImmutableSet.Builder<Index> builder) {
    builder.add(getIndex());
  }

    //------------------------- AUTOGENERATED START -------------------------
    ///CLOVER:OFF
    /**
     * The meta-bean for {@code IborRateComputation}.
     * @return the meta-bean, not null
     */
    public static IborRateComputation.Meta meta() {
        return IborRateComputation.Meta.INSTANCE;
    }

    static {
        JodaBeanUtils.registerMetaBean(IborRateComputation.Meta.INSTANCE);
    }

    /**
     * The serialization version id.
     */
    private static final long serialVersionUID = 1L;

    private IborRateComputation(
            IborIndexObservation observation) {
        JodaBeanUtils.notNull(observation, "observation");
        this.observation = observation;
    }

    @Override
    public IborRateComputation.Meta metaBean() {
        return IborRateComputation.Meta.INSTANCE;
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
     * Gets the underlying index observation.
     * @return the value of the property, not null
     */
    public IborIndexObservation getObservation() {
        return observation;
    }

    //-----------------------------------------------------------------------
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == this.getClass()) {
            IborRateComputation other = (IborRateComputation) obj;
            return JodaBeanUtils.equal(observation, other.observation);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = getClass().hashCode();
        hash = hash * 31 + JodaBeanUtils.hashCode(observation);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(64);
        buf.append("IborRateComputation{");
        buf.append("observation").append('=').append(JodaBeanUtils.toString(observation));
        buf.append('}');
        return buf.toString();
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-bean for {@code IborRateComputation}.
     */
    public static final class Meta extends DirectMetaBean {
        /**
         * The singleton instance of the meta-bean.
         */
        static final Meta INSTANCE = new Meta();

        /**
         * The meta-property for the {@code observation} property.
         */
        private final MetaProperty<IborIndexObservation> observation = DirectMetaProperty.ofImmutable(
                this, "observation", IborRateComputation.class, IborIndexObservation.class);
        /**
         * The meta-properties.
         */
        private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
                this, null,
                "observation");

        /**
         * Restricted constructor.
         */
        private Meta() {
        }

        @Override
        protected MetaProperty<?> metaPropertyGet(String propertyName) {
            switch (propertyName.hashCode()) {
                case 122345516:  // observation
                    return observation;
            }
            return super.metaPropertyGet(propertyName);
        }

        @Override
        public BeanBuilder<? extends IborRateComputation> builder() {
            return new IborRateComputation.Builder();
        }

        @Override
        public Class<? extends IborRateComputation> beanType() {
            return IborRateComputation.class;
        }

        @Override
        public Map<String, MetaProperty<?>> metaPropertyMap() {
            return metaPropertyMap$;
        }

        //-----------------------------------------------------------------------
        /**
         * The meta-property for the {@code observation} property.
         * @return the meta-property, not null
         */
        public MetaProperty<IborIndexObservation> observation() {
            return observation;
        }

        //-----------------------------------------------------------------------
        @Override
        protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
            switch (propertyName.hashCode()) {
                case 122345516:  // observation
                    return ((IborRateComputation) bean).getObservation();
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
     * The bean-builder for {@code IborRateComputation}.
     */
    private static final class Builder extends DirectFieldsBeanBuilder<IborRateComputation> {

        private IborIndexObservation observation;

        /**
         * Restricted constructor.
         */
        private Builder() {
        }

        //-----------------------------------------------------------------------
        @Override
        public Object get(String propertyName) {
            switch (propertyName.hashCode()) {
                case 122345516:  // observation
                    return observation;
                default:
                    throw new NoSuchElementException("Unknown property: " + propertyName);
            }
        }

        @Override
        public Builder set(String propertyName, Object newValue) {
            switch (propertyName.hashCode()) {
                case 122345516:  // observation
                    this.observation = (IborIndexObservation) newValue;
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
        public IborRateComputation build() {
            return new IborRateComputation(
                    observation);
        }

        //-----------------------------------------------------------------------
        @Override
        public String toString() {
            StringBuilder buf = new StringBuilder(64);
            buf.append("IborRateComputation.Builder{");
            buf.append("observation").append('=').append(JodaBeanUtils.toString(observation));
            buf.append('}');
            return buf.toString();
        }

    }

    ///CLOVER:ON
    //-------------------------- AUTOGENERATED END --------------------------
}

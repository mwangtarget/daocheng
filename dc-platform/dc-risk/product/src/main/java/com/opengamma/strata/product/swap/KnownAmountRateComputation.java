/**
 * Copyright (C) 2016 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.product.swap;

import java.io.Serializable;
import java.util.Set;

import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaBean;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.light.LightMetaBean;

import com.google.common.collect.ImmutableSet;
import com.opengamma.strata.basics.currency.CurrencyAmount;
import com.opengamma.strata.basics.index.Index;
import com.opengamma.strata.product.rate.RateComputation;

/**
 * Defines a known amount of interest as a rate computation.
 * <p>
 * This is a special computation that represents a known amount instead of a rate.
 * It is used to pass the known amount through the standard rate computation process.
 * This computation is converted to a {@link KnownAmountNotionalSwapPaymentPeriod} for pricing.
 */
@BeanDefinition(style = "light")
final class KnownAmountRateComputation
    implements RateComputation, ImmutableBean, Serializable {
  // package scoped, as this is not intended for general use
  // it exists to allow known amount stubs to be handled by RateAccrualPeriod
  // PaymentSchedule resolves it to KnownAmountNotionalPaymentPeriod, not RatePaymentPeriod

  /**
   * The known amount.
   */
  @PropertyDefinition
  private final CurrencyAmount amount;

  //-------------------------------------------------------------------------
  /**
   * Creates an instance.
   * 
   * @param amount  the known amount
   * @return the known amount
   */
  public static KnownAmountRateComputation of(CurrencyAmount amount) {
    return new KnownAmountRateComputation(amount);
  }

  //-------------------------------------------------------------------------
  @Override
  public void collectIndices(ImmutableSet.Builder<Index> builder) {
    // no indices to add
  }

    //------------------------- AUTOGENERATED START -------------------------
    ///CLOVER:OFF
    /**
     * The meta-bean for {@code KnownAmountRateComputation}.
     */
    private static MetaBean META_BEAN = LightMetaBean.of(KnownAmountRateComputation.class);

    /**
     * The meta-bean for {@code KnownAmountRateComputation}.
     * @return the meta-bean, not null
     */
    public static MetaBean meta() {
        return META_BEAN;
    }

    static {
        JodaBeanUtils.registerMetaBean(META_BEAN);
    }

    /**
     * The serialization version id.
     */
    private static final long serialVersionUID = 1L;

    private KnownAmountRateComputation(
            CurrencyAmount amount) {
        this.amount = amount;
    }

    @Override
    public MetaBean metaBean() {
        return META_BEAN;
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
     * Gets the known amount.
     * @return the value of the property
     */
    public CurrencyAmount getAmount() {
        return amount;
    }

    //-----------------------------------------------------------------------
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == this.getClass()) {
            KnownAmountRateComputation other = (KnownAmountRateComputation) obj;
            return JodaBeanUtils.equal(amount, other.amount);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = getClass().hashCode();
        hash = hash * 31 + JodaBeanUtils.hashCode(amount);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(64);
        buf.append("KnownAmountRateComputation{");
        buf.append("amount").append('=').append(JodaBeanUtils.toString(amount));
        buf.append('}');
        return buf.toString();
    }

    ///CLOVER:ON
    //-------------------------- AUTOGENERATED END --------------------------
}

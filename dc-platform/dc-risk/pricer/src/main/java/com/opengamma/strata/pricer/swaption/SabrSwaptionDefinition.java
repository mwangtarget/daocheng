/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.pricer.swaption;

import java.io.Serializable;
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

import com.opengamma.strata.basics.date.DayCount;
import com.opengamma.strata.market.surface.interpolator.SurfaceInterpolator;
import com.opengamma.strata.product.swap.type.FixedIborSwapConvention;

/**
 * Definition of standard inputs to SABR swaption calibration.
 */
@BeanDefinition(builderScope = "private")
public final class SabrSwaptionDefinition
    implements ImmutableBean, Serializable {

  /**
   * The name of the volatilities.
   */
  @PropertyDefinition(validate = "notNull")
  private final SwaptionVolatilitiesName name;
  /**
   * The swap convention that the volatilities are to be used for.
   */
  @PropertyDefinition(validate = "notNull")
  private final FixedIborSwapConvention convention;
  /**
   * The day count to use.
   */
  @PropertyDefinition(validate = "notNull")
  private final DayCount dayCount;
  /**
   * The interpolator for the alpha, rho and nu surfaces.
   */
  @PropertyDefinition(validate = "notNull")
  private final SurfaceInterpolator interpolator;

  //-------------------------------------------------------------------------
  /**
   * Obtains an instance from the name, convention, day count and tenors.
   * 
   * @param name  the name of the volatilities
   * @param convention  the swap convention that the volatilities are to be used for
   * @param dayCount  the day count to use
   * @param interpolator  the interpolator for the alpha, rho and nu surfaces
   * @return the volatilities
   */
  public static SabrSwaptionDefinition of(
      SwaptionVolatilitiesName name,
      FixedIborSwapConvention convention,
      DayCount dayCount,
      SurfaceInterpolator interpolator) {

    return new SabrSwaptionDefinition(name, convention, dayCount, interpolator);
  }

    //------------------------- AUTOGENERATED START -------------------------
    ///CLOVER:OFF
    /**
     * The meta-bean for {@code SabrSwaptionDefinition}.
     * @return the meta-bean, not null
     */
    public static SabrSwaptionDefinition.Meta meta() {
        return SabrSwaptionDefinition.Meta.INSTANCE;
    }

    static {
        JodaBeanUtils.registerMetaBean(SabrSwaptionDefinition.Meta.INSTANCE);
    }

    /**
     * The serialization version id.
     */
    private static final long serialVersionUID = 1L;

    private SabrSwaptionDefinition(
            SwaptionVolatilitiesName name,
            FixedIborSwapConvention convention,
            DayCount dayCount,
            SurfaceInterpolator interpolator) {
        JodaBeanUtils.notNull(name, "name");
        JodaBeanUtils.notNull(convention, "convention");
        JodaBeanUtils.notNull(dayCount, "dayCount");
        JodaBeanUtils.notNull(interpolator, "interpolator");
        this.name = name;
        this.convention = convention;
        this.dayCount = dayCount;
        this.interpolator = interpolator;
    }

    @Override
    public SabrSwaptionDefinition.Meta metaBean() {
        return SabrSwaptionDefinition.Meta.INSTANCE;
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
     * Gets the name of the volatilities.
     * @return the value of the property, not null
     */
    public SwaptionVolatilitiesName getName() {
        return name;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the swap convention that the volatilities are to be used for.
     * @return the value of the property, not null
     */
    public FixedIborSwapConvention getConvention() {
        return convention;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the day count to use.
     * @return the value of the property, not null
     */
    public DayCount getDayCount() {
        return dayCount;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the interpolator for the alpha, rho and nu surfaces.
     * @return the value of the property, not null
     */
    public SurfaceInterpolator getInterpolator() {
        return interpolator;
    }

    //-----------------------------------------------------------------------
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == this.getClass()) {
            SabrSwaptionDefinition other = (SabrSwaptionDefinition) obj;
            return JodaBeanUtils.equal(name, other.name) &&
                    JodaBeanUtils.equal(convention, other.convention) &&
                    JodaBeanUtils.equal(dayCount, other.dayCount) &&
                    JodaBeanUtils.equal(interpolator, other.interpolator);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = getClass().hashCode();
        hash = hash * 31 + JodaBeanUtils.hashCode(name);
        hash = hash * 31 + JodaBeanUtils.hashCode(convention);
        hash = hash * 31 + JodaBeanUtils.hashCode(dayCount);
        hash = hash * 31 + JodaBeanUtils.hashCode(interpolator);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(160);
        buf.append("SabrSwaptionDefinition{");
        buf.append("name").append('=').append(name).append(',').append(' ');
        buf.append("convention").append('=').append(convention).append(',').append(' ');
        buf.append("dayCount").append('=').append(dayCount).append(',').append(' ');
        buf.append("interpolator").append('=').append(JodaBeanUtils.toString(interpolator));
        buf.append('}');
        return buf.toString();
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-bean for {@code SabrSwaptionDefinition}.
     */
    public static final class Meta extends DirectMetaBean {
        /**
         * The singleton instance of the meta-bean.
         */
        static final Meta INSTANCE = new Meta();

        /**
         * The meta-property for the {@code name} property.
         */
        private final MetaProperty<SwaptionVolatilitiesName> name = DirectMetaProperty.ofImmutable(
                this, "name", SabrSwaptionDefinition.class, SwaptionVolatilitiesName.class);
        /**
         * The meta-property for the {@code convention} property.
         */
        private final MetaProperty<FixedIborSwapConvention> convention = DirectMetaProperty.ofImmutable(
                this, "convention", SabrSwaptionDefinition.class, FixedIborSwapConvention.class);
        /**
         * The meta-property for the {@code dayCount} property.
         */
        private final MetaProperty<DayCount> dayCount = DirectMetaProperty.ofImmutable(
                this, "dayCount", SabrSwaptionDefinition.class, DayCount.class);
        /**
         * The meta-property for the {@code interpolator} property.
         */
        private final MetaProperty<SurfaceInterpolator> interpolator = DirectMetaProperty.ofImmutable(
                this, "interpolator", SabrSwaptionDefinition.class, SurfaceInterpolator.class);
        /**
         * The meta-properties.
         */
        private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
                this, null,
                "name",
                "convention",
                "dayCount",
                "interpolator");

        /**
         * Restricted constructor.
         */
        private Meta() {
        }

        @Override
        protected MetaProperty<?> metaPropertyGet(String propertyName) {
            switch (propertyName.hashCode()) {
                case 3373707:  // name
                    return name;
                case 2039569265:  // convention
                    return convention;
                case 1905311443:  // dayCount
                    return dayCount;
                case 2096253127:  // interpolator
                    return interpolator;
            }
            return super.metaPropertyGet(propertyName);
        }

        @Override
        public BeanBuilder<? extends SabrSwaptionDefinition> builder() {
            return new SabrSwaptionDefinition.Builder();
        }

        @Override
        public Class<? extends SabrSwaptionDefinition> beanType() {
            return SabrSwaptionDefinition.class;
        }

        @Override
        public Map<String, MetaProperty<?>> metaPropertyMap() {
            return metaPropertyMap$;
        }

        //-----------------------------------------------------------------------
        /**
         * The meta-property for the {@code name} property.
         * @return the meta-property, not null
         */
        public MetaProperty<SwaptionVolatilitiesName> name() {
            return name;
        }

        /**
         * The meta-property for the {@code convention} property.
         * @return the meta-property, not null
         */
        public MetaProperty<FixedIborSwapConvention> convention() {
            return convention;
        }

        /**
         * The meta-property for the {@code dayCount} property.
         * @return the meta-property, not null
         */
        public MetaProperty<DayCount> dayCount() {
            return dayCount;
        }

        /**
         * The meta-property for the {@code interpolator} property.
         * @return the meta-property, not null
         */
        public MetaProperty<SurfaceInterpolator> interpolator() {
            return interpolator;
        }

        //-----------------------------------------------------------------------
        @Override
        protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
            switch (propertyName.hashCode()) {
                case 3373707:  // name
                    return ((SabrSwaptionDefinition) bean).getName();
                case 2039569265:  // convention
                    return ((SabrSwaptionDefinition) bean).getConvention();
                case 1905311443:  // dayCount
                    return ((SabrSwaptionDefinition) bean).getDayCount();
                case 2096253127:  // interpolator
                    return ((SabrSwaptionDefinition) bean).getInterpolator();
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
     * The bean-builder for {@code SabrSwaptionDefinition}.
     */
    private static final class Builder extends DirectFieldsBeanBuilder<SabrSwaptionDefinition> {

        private SwaptionVolatilitiesName name;
        private FixedIborSwapConvention convention;
        private DayCount dayCount;
        private SurfaceInterpolator interpolator;

        /**
         * Restricted constructor.
         */
        private Builder() {
        }

        //-----------------------------------------------------------------------
        @Override
        public Object get(String propertyName) {
            switch (propertyName.hashCode()) {
                case 3373707:  // name
                    return name;
                case 2039569265:  // convention
                    return convention;
                case 1905311443:  // dayCount
                    return dayCount;
                case 2096253127:  // interpolator
                    return interpolator;
                default:
                    throw new NoSuchElementException("Unknown property: " + propertyName);
            }
        }

        @Override
        public Builder set(String propertyName, Object newValue) {
            switch (propertyName.hashCode()) {
                case 3373707:  // name
                    this.name = (SwaptionVolatilitiesName) newValue;
                    break;
                case 2039569265:  // convention
                    this.convention = (FixedIborSwapConvention) newValue;
                    break;
                case 1905311443:  // dayCount
                    this.dayCount = (DayCount) newValue;
                    break;
                case 2096253127:  // interpolator
                    this.interpolator = (SurfaceInterpolator) newValue;
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
        public SabrSwaptionDefinition build() {
            return new SabrSwaptionDefinition(
                    name,
                    convention,
                    dayCount,
                    interpolator);
        }

        //-----------------------------------------------------------------------
        @Override
        public String toString() {
            StringBuilder buf = new StringBuilder(160);
            buf.append("SabrSwaptionDefinition.Builder{");
            buf.append("name").append('=').append(JodaBeanUtils.toString(name)).append(',').append(' ');
            buf.append("convention").append('=').append(JodaBeanUtils.toString(convention)).append(',').append(' ');
            buf.append("dayCount").append('=').append(JodaBeanUtils.toString(dayCount)).append(',').append(' ');
            buf.append("interpolator").append('=').append(JodaBeanUtils.toString(interpolator));
            buf.append('}');
            return buf.toString();
        }

    }

    ///CLOVER:ON
    //-------------------------- AUTOGENERATED END --------------------------
}

/**
 * Copyright (C) 2016 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.market.curve;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Supplier;

import org.joda.beans.Bean;
import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.ImmutableDefaults;
import org.joda.beans.ImmutableValidator;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.strata.collect.ArgChecker;
import com.opengamma.strata.collect.Messages;

/**
 * The date of the curve node.
 * <p>
 * A {@code CurveNodeDate} provides a flexible mechanism of defining the date of the curve node.
 * It may be associated with the end date, the last fixing date, or specified exactly.
 */
@BeanDefinition(builderScope = "private")
public final class CurveNodeDate
    implements ImmutableBean, Serializable {

  /**
   * An instance defining the curve node date as the end date of the trade.
   */
  public static final CurveNodeDate END = new CurveNodeDate(CurveNodeDateType.END, null);
  /**
   * An instance defining the curve node date as the last fixing date date of the trade.
   * Used only for instruments referencing an Ibor index.
   */
  public static final CurveNodeDate LAST_FIXING = new CurveNodeDate(CurveNodeDateType.LAST_FIXING, null);

  //-------------------------------------------------------------------------
  /**
   * The method by which the date of the node is calculated, defaulted to 'End'.
   */
  @PropertyDefinition
  private final CurveNodeDateType type;
  /**
   * The fixed date to be used on the node, only used when the type is 'Fixed'.
   */
  @PropertyDefinition(get = "field")
  private final LocalDate date;

  //-------------------------------------------------------------------------
  /**
   * Obtains an instance specifying a fixed date.
   * <p>
   * This returns an instance with the type {@link CurveNodeDateType#FIXED}.
   *
   * @param date  the specific date
   * @return an instance specifying a fixed date
   */
  public static CurveNodeDate of(LocalDate date) {
    return new CurveNodeDate(CurveNodeDateType.FIXED, date);
  }

  @ImmutableDefaults
  private static void applyDefaults(Builder builder) {
    builder.type = CurveNodeDateType.END;
  }

  @ImmutableValidator
  private void validate() {
    if (type.equals(CurveNodeDateType.FIXED)) {
      ArgChecker.isTrue(date != null, "Date must be present when type is 'Fixed'");
    } else {
      ArgChecker.isTrue(date == null, "Date must not be present unless type is 'Fixed'");
    }
  }

  //-------------------------------------------------------------------------
  /**
   * Checks if the type is 'End'.
   * 
   * @return true if the type is 'End'
   */
  public boolean isEnd() {
    return (type == CurveNodeDateType.END);
  }

  /**
   * Checks if the type is 'LastFixing'.
   * 
   * @return true if the type is 'LastFixing'
   */
  public boolean isLastFixing() {
    return (type == CurveNodeDateType.LAST_FIXING);
  }

  /**
   * Checks if the type is 'Fixed'.
   * 
   * @return true if the type is 'Fixed'
   */
  public boolean isFixed() {
    return (type == CurveNodeDateType.FIXED);
  }

  /**
   * Gets the node date if the type is 'Fixed'.
   * <p>
   * If the type is 'Fixed', this returns the node date.
   * Otherwise, this throws an exception.
   * 
   * @return the node date, only available if the type is 'Fixed'
   * @throws IllegalStateException if called when the type is not fixed
   */
  public LocalDate getDate() {
    if (!isFixed()) {
      throw new IllegalStateException(Messages.format("No date available for type '{}'", type));
    }
    return date;
  }

  /**
   * Calculates the appropriate date for the node.
   * 
   * @param endDateSupplier  the supplier invoked to get the end date
   * @param lastFixingDateSupplier  the supplier invoked to get the last fixing date
   * @return the calculated date
   */
  public LocalDate calculate(Supplier<LocalDate> endDateSupplier, Supplier<LocalDate> lastFixingDateSupplier) {
    switch (type) {
      case FIXED:
        return date;
      case END:
        return endDateSupplier.get();
      case LAST_FIXING:
        return lastFixingDateSupplier.get();
    }
    throw new IllegalStateException("Unknown curve node type");
  }

    //------------------------- AUTOGENERATED START -------------------------
    ///CLOVER:OFF
    /**
     * The meta-bean for {@code CurveNodeDate}.
     * @return the meta-bean, not null
     */
    public static CurveNodeDate.Meta meta() {
        return CurveNodeDate.Meta.INSTANCE;
    }

    static {
        JodaBeanUtils.registerMetaBean(CurveNodeDate.Meta.INSTANCE);
    }

    /**
     * The serialization version id.
     */
    private static final long serialVersionUID = 1L;

    private CurveNodeDate(
            CurveNodeDateType type,
            LocalDate date) {
        this.type = type;
        this.date = date;
        validate();
    }

    @Override
    public CurveNodeDate.Meta metaBean() {
        return CurveNodeDate.Meta.INSTANCE;
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
     * Gets the method by which the date of the node is calculated, defaulted to 'End'.
     * @return the value of the property
     */
    public CurveNodeDateType getType() {
        return type;
    }

    //-----------------------------------------------------------------------
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == this.getClass()) {
            CurveNodeDate other = (CurveNodeDate) obj;
            return JodaBeanUtils.equal(type, other.type) &&
                    JodaBeanUtils.equal(date, other.date);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = getClass().hashCode();
        hash = hash * 31 + JodaBeanUtils.hashCode(type);
        hash = hash * 31 + JodaBeanUtils.hashCode(date);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(96);
        buf.append("CurveNodeDate{");
        buf.append("type").append('=').append(type).append(',').append(' ');
        buf.append("date").append('=').append(JodaBeanUtils.toString(date));
        buf.append('}');
        return buf.toString();
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-bean for {@code CurveNodeDate}.
     */
    public static final class Meta extends DirectMetaBean {
        /**
         * The singleton instance of the meta-bean.
         */
        static final Meta INSTANCE = new Meta();

        /**
         * The meta-property for the {@code type} property.
         */
        private final MetaProperty<CurveNodeDateType> type = DirectMetaProperty.ofImmutable(
                this, "type", CurveNodeDate.class, CurveNodeDateType.class);
        /**
         * The meta-property for the {@code date} property.
         */
        private final MetaProperty<LocalDate> date = DirectMetaProperty.ofImmutable(
                this, "date", CurveNodeDate.class, LocalDate.class);
        /**
         * The meta-properties.
         */
        private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
                this, null,
                "type",
                "date");

        /**
         * Restricted constructor.
         */
        private Meta() {
        }

        @Override
        protected MetaProperty<?> metaPropertyGet(String propertyName) {
            switch (propertyName.hashCode()) {
                case 3575610:  // type
                    return type;
                case 3076014:  // date
                    return date;
            }
            return super.metaPropertyGet(propertyName);
        }

        @Override
        public BeanBuilder<? extends CurveNodeDate> builder() {
            return new CurveNodeDate.Builder();
        }

        @Override
        public Class<? extends CurveNodeDate> beanType() {
            return CurveNodeDate.class;
        }

        @Override
        public Map<String, MetaProperty<?>> metaPropertyMap() {
            return metaPropertyMap$;
        }

        //-----------------------------------------------------------------------
        /**
         * The meta-property for the {@code type} property.
         * @return the meta-property, not null
         */
        public MetaProperty<CurveNodeDateType> type() {
            return type;
        }

        /**
         * The meta-property for the {@code date} property.
         * @return the meta-property, not null
         */
        public MetaProperty<LocalDate> date() {
            return date;
        }

        //-----------------------------------------------------------------------
        @Override
        protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
            switch (propertyName.hashCode()) {
                case 3575610:  // type
                    return ((CurveNodeDate) bean).getType();
                case 3076014:  // date
                    return ((CurveNodeDate) bean).date;
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
     * The bean-builder for {@code CurveNodeDate}.
     */
    private static final class Builder extends DirectFieldsBeanBuilder<CurveNodeDate> {

        private CurveNodeDateType type;
        private LocalDate date;

        /**
         * Restricted constructor.
         */
        private Builder() {
            applyDefaults(this);
        }

        //-----------------------------------------------------------------------
        @Override
        public Object get(String propertyName) {
            switch (propertyName.hashCode()) {
                case 3575610:  // type
                    return type;
                case 3076014:  // date
                    return date;
                default:
                    throw new NoSuchElementException("Unknown property: " + propertyName);
            }
        }

        @Override
        public Builder set(String propertyName, Object newValue) {
            switch (propertyName.hashCode()) {
                case 3575610:  // type
                    this.type = (CurveNodeDateType) newValue;
                    break;
                case 3076014:  // date
                    this.date = (LocalDate) newValue;
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
        public CurveNodeDate build() {
            return new CurveNodeDate(
                    type,
                    date);
        }

        //-----------------------------------------------------------------------
        @Override
        public String toString() {
            StringBuilder buf = new StringBuilder(96);
            buf.append("CurveNodeDate.Builder{");
            buf.append("type").append('=').append(JodaBeanUtils.toString(type)).append(',').append(' ');
            buf.append("date").append('=').append(JodaBeanUtils.toString(date));
            buf.append('}');
            return buf.toString();
        }

    }

    ///CLOVER:ON
    //-------------------------- AUTOGENERATED END --------------------------
}

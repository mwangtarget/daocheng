/**
 * Copyright (C) 2016 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.market.curve;

import java.io.Serializable;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.ImmutableValidator;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.strata.collect.Messages;

/**
 * The date order rules to apply to a pair of curve nodes.
 * <p>
 * In any curve, two nodes may not have the same date. In addition, it is typically
 * desirable to ensure that there is a minimum gap between two nodes, such as 7 days.
 * An instance of {@code CurveNodeDateOrder} specifies the minimum gap and what to do if the clash occurs.
 */
@BeanDefinition(builderScope = "private")
public final class CurveNodeDateOrder
    implements ImmutableBean, Serializable {

  /**
   * The default instance, that throws an exception if the node is on the same date
   * or before another node.
   */
  public static final CurveNodeDateOrder DEFAULT = new CurveNodeDateOrder(1, CurveNodeClashAction.EXCEPTION);

  //-------------------------------------------------------------------------
  /**
   * The minimum gap between two curve nodes, measured in calendar days.
   * A gap of one day is the smallest allowed.
   * A clash occurs if the period between the two nodes is less than the minimum.
   * The gap applies to the node before this one and the node after this one.
   */
  @PropertyDefinition
  private final int minGapInDays;
  /**
   * The action to perform if a clash occurs.
   */
  @PropertyDefinition(validate = "notNull")
  private final CurveNodeClashAction action;

  //-------------------------------------------------------------------------
  /**
   * Obtains an instance from the minimum gap, allowing reordering flag and clash action.
   *
   * @param minGapInDays  the minimum gap between this node and the previous node in days, one or greater
   * @param action  the action to perform if a clash occurs
   * @return an instance specifying a fixed date
   */
  public static CurveNodeDateOrder of(int minGapInDays, CurveNodeClashAction action) {
    return new CurveNodeDateOrder(minGapInDays, action);
  }

  @ImmutableValidator
  private void validate() {
    if (minGapInDays < 1) {
      throw new IllegalArgumentException(Messages.format(
          "Minimum gap must be at least one day, but was {}", minGapInDays));
    }
  }

    //------------------------- AUTOGENERATED START -------------------------
    ///CLOVER:OFF
    /**
     * The meta-bean for {@code CurveNodeDateOrder}.
     * @return the meta-bean, not null
     */
    public static CurveNodeDateOrder.Meta meta() {
        return CurveNodeDateOrder.Meta.INSTANCE;
    }

    static {
        JodaBeanUtils.registerMetaBean(CurveNodeDateOrder.Meta.INSTANCE);
    }

    /**
     * The serialization version id.
     */
    private static final long serialVersionUID = 1L;

    private CurveNodeDateOrder(
            int minGapInDays,
            CurveNodeClashAction action) {
        JodaBeanUtils.notNull(action, "action");
        this.minGapInDays = minGapInDays;
        this.action = action;
        validate();
    }

    @Override
    public CurveNodeDateOrder.Meta metaBean() {
        return CurveNodeDateOrder.Meta.INSTANCE;
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
     * Gets the minimum gap between two curve nodes, measured in calendar days.
     * A gap of one day is the smallest allowed.
     * A clash occurs if the period between the two nodes is less than the minimum.
     * The gap applies to the node before this one and the node after this one.
     * @return the value of the property
     */
    public int getMinGapInDays() {
        return minGapInDays;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the action to perform if a clash occurs.
     * @return the value of the property, not null
     */
    public CurveNodeClashAction getAction() {
        return action;
    }

    //-----------------------------------------------------------------------
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == this.getClass()) {
            CurveNodeDateOrder other = (CurveNodeDateOrder) obj;
            return (minGapInDays == other.minGapInDays) &&
                    JodaBeanUtils.equal(action, other.action);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = getClass().hashCode();
        hash = hash * 31 + JodaBeanUtils.hashCode(minGapInDays);
        hash = hash * 31 + JodaBeanUtils.hashCode(action);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(96);
        buf.append("CurveNodeDateOrder{");
        buf.append("minGapInDays").append('=').append(minGapInDays).append(',').append(' ');
        buf.append("action").append('=').append(JodaBeanUtils.toString(action));
        buf.append('}');
        return buf.toString();
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-bean for {@code CurveNodeDateOrder}.
     */
    public static final class Meta extends DirectMetaBean {
        /**
         * The singleton instance of the meta-bean.
         */
        static final Meta INSTANCE = new Meta();

        /**
         * The meta-property for the {@code minGapInDays} property.
         */
        private final MetaProperty<Integer> minGapInDays = DirectMetaProperty.ofImmutable(
                this, "minGapInDays", CurveNodeDateOrder.class, Integer.TYPE);
        /**
         * The meta-property for the {@code action} property.
         */
        private final MetaProperty<CurveNodeClashAction> action = DirectMetaProperty.ofImmutable(
                this, "action", CurveNodeDateOrder.class, CurveNodeClashAction.class);
        /**
         * The meta-properties.
         */
        private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
                this, null,
                "minGapInDays",
                "action");

        /**
         * Restricted constructor.
         */
        private Meta() {
        }

        @Override
        protected MetaProperty<?> metaPropertyGet(String propertyName) {
            switch (propertyName.hashCode()) {
                case 1925599072:  // minGapInDays
                    return minGapInDays;
                case -1422950858:  // action
                    return action;
            }
            return super.metaPropertyGet(propertyName);
        }

        @Override
        public BeanBuilder<? extends CurveNodeDateOrder> builder() {
            return new CurveNodeDateOrder.Builder();
        }

        @Override
        public Class<? extends CurveNodeDateOrder> beanType() {
            return CurveNodeDateOrder.class;
        }

        @Override
        public Map<String, MetaProperty<?>> metaPropertyMap() {
            return metaPropertyMap$;
        }

        //-----------------------------------------------------------------------
        /**
         * The meta-property for the {@code minGapInDays} property.
         * @return the meta-property, not null
         */
        public MetaProperty<Integer> minGapInDays() {
            return minGapInDays;
        }

        /**
         * The meta-property for the {@code action} property.
         * @return the meta-property, not null
         */
        public MetaProperty<CurveNodeClashAction> action() {
            return action;
        }

        //-----------------------------------------------------------------------
        @Override
        protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
            switch (propertyName.hashCode()) {
                case 1925599072:  // minGapInDays
                    return ((CurveNodeDateOrder) bean).getMinGapInDays();
                case -1422950858:  // action
                    return ((CurveNodeDateOrder) bean).getAction();
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
     * The bean-builder for {@code CurveNodeDateOrder}.
     */
    private static final class Builder extends DirectFieldsBeanBuilder<CurveNodeDateOrder> {

        private int minGapInDays;
        private CurveNodeClashAction action;

        /**
         * Restricted constructor.
         */
        private Builder() {
        }

        //-----------------------------------------------------------------------
        @Override
        public Object get(String propertyName) {
            switch (propertyName.hashCode()) {
                case 1925599072:  // minGapInDays
                    return minGapInDays;
                case -1422950858:  // action
                    return action;
                default:
                    throw new NoSuchElementException("Unknown property: " + propertyName);
            }
        }

        @Override
        public Builder set(String propertyName, Object newValue) {
            switch (propertyName.hashCode()) {
                case 1925599072:  // minGapInDays
                    this.minGapInDays = (Integer) newValue;
                    break;
                case -1422950858:  // action
                    this.action = (CurveNodeClashAction) newValue;
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
        public CurveNodeDateOrder build() {
            return new CurveNodeDateOrder(
                    minGapInDays,
                    action);
        }

        //-----------------------------------------------------------------------
        @Override
        public String toString() {
            StringBuilder buf = new StringBuilder(96);
            buf.append("CurveNodeDateOrder.Builder{");
            buf.append("minGapInDays").append('=').append(JodaBeanUtils.toString(minGapInDays)).append(',').append(' ');
            buf.append("action").append('=').append(JodaBeanUtils.toString(action));
            buf.append('}');
            return buf.toString();
        }

    }

    ///CLOVER:ON
    //-------------------------- AUTOGENERATED END --------------------------
}

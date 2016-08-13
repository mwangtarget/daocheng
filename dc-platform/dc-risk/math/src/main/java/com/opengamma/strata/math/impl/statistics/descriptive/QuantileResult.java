/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.math.impl.statistics.descriptive;

import java.io.Serializable;

import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.PropertyDefinition;

import com.opengamma.strata.collect.array.DoubleArray;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;
import org.joda.beans.BeanBuilder;

/**
 * Object describing the result from a {@link QuantileCalculationMethod}.
 */
@BeanDefinition(builderScope="private")
public final class QuantileResult
  implements ImmutableBean, Serializable {
  
  /** The quantile value. */
  @PropertyDefinition
  private final double value;
  /** The indices of sample data used in the calculation. For discrete methods, the length is 1 and for interpolated
   * methods, the length is usually 2. */
  @PropertyDefinition
  private final int[] indices;
  /** The weights of the sample data used in the quantitle calculation. The samples used with those weights are given
   * by the indices. */
  @PropertyDefinition(validate = "notNull")
  private final DoubleArray weights;
  

  /**
   * Creates an {@code QuantileResult} from the value, the indices and the weights.
   * <p>
   * The amounts must be of the correct type, one pay and one receive.
   * The currencies of the payments must differ.
   * @param value  the quantile value
   * @param indices  the indices of the samples used in the quantile computation
   * @param weights  the weights of the samples used in the quantile computation
   * @return the quantile result
   */
  public static QuantileResult of(double value, int[] indices, DoubleArray weights) {
    return new QuantileResult(value, indices, weights);
  }
  
    //------------------------- AUTOGENERATED START -------------------------
    ///CLOVER:OFF
    /**
     * The meta-bean for {@code QuantileResult}.
     * @return the meta-bean, not null
     */
    public static QuantileResult.Meta meta() {
        return QuantileResult.Meta.INSTANCE;
    }

    static {
        JodaBeanUtils.registerMetaBean(QuantileResult.Meta.INSTANCE);
    }

    /**
     * The serialization version id.
     */
    private static final long serialVersionUID = 1L;

    private QuantileResult(
            double value,
            int[] indices,
            DoubleArray weights) {
        JodaBeanUtils.notNull(weights, "weights");
        this.value = value;
        this.indices = (indices != null ? indices.clone() : null);
        this.weights = weights;
    }

    @Override
    public QuantileResult.Meta metaBean() {
        return QuantileResult.Meta.INSTANCE;
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
     * Gets the quantile value.
     * @return the value of the property
     */
    public double getValue() {
        return value;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the indices.
     * @return the value of the property
     */
    public int[] getIndices() {
        return (indices != null ? indices.clone() : null);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the weights.
     * @return the value of the property, not null
     */
    public DoubleArray getWeights() {
        return weights;
    }

    //-----------------------------------------------------------------------
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == this.getClass()) {
            QuantileResult other = (QuantileResult) obj;
            return JodaBeanUtils.equal(value, other.value) &&
                    JodaBeanUtils.equal(indices, other.indices) &&
                    JodaBeanUtils.equal(weights, other.weights);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = getClass().hashCode();
        hash = hash * 31 + JodaBeanUtils.hashCode(value);
        hash = hash * 31 + JodaBeanUtils.hashCode(indices);
        hash = hash * 31 + JodaBeanUtils.hashCode(weights);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(128);
        buf.append("QuantileResult{");
        buf.append("value").append('=').append(value).append(',').append(' ');
        buf.append("indices").append('=').append(indices).append(',').append(' ');
        buf.append("weights").append('=').append(JodaBeanUtils.toString(weights));
        buf.append('}');
        return buf.toString();
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-bean for {@code QuantileResult}.
     */
    public static final class Meta extends DirectMetaBean {
        /**
         * The singleton instance of the meta-bean.
         */
        static final Meta INSTANCE = new Meta();

        /**
         * The meta-property for the {@code value} property.
         */
        private final MetaProperty<Double> value = DirectMetaProperty.ofImmutable(
                this, "value", QuantileResult.class, Double.TYPE);
        /**
         * The meta-property for the {@code indices} property.
         */
        private final MetaProperty<int[]> indices = DirectMetaProperty.ofImmutable(
                this, "indices", QuantileResult.class, int[].class);
        /**
         * The meta-property for the {@code weights} property.
         */
        private final MetaProperty<DoubleArray> weights = DirectMetaProperty.ofImmutable(
                this, "weights", QuantileResult.class, DoubleArray.class);
        /**
         * The meta-properties.
         */
        private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
                this, null,
                "value",
                "indices",
                "weights");

        /**
         * Restricted constructor.
         */
        private Meta() {
        }

        @Override
        protected MetaProperty<?> metaPropertyGet(String propertyName) {
            switch (propertyName.hashCode()) {
                case 111972721:  // value
                    return value;
                case 1943391143:  // indices
                    return indices;
                case 1230441723:  // weights
                    return weights;
            }
            return super.metaPropertyGet(propertyName);
        }

        @Override
        public BeanBuilder<? extends QuantileResult> builder() {
            return new QuantileResult.Builder();
        }

        @Override
        public Class<? extends QuantileResult> beanType() {
            return QuantileResult.class;
        }

        @Override
        public Map<String, MetaProperty<?>> metaPropertyMap() {
            return metaPropertyMap$;
        }

        //-----------------------------------------------------------------------
        /**
         * The meta-property for the {@code value} property.
         * @return the meta-property, not null
         */
        public MetaProperty<Double> value() {
            return value;
        }

        /**
         * The meta-property for the {@code indices} property.
         * @return the meta-property, not null
         */
        public MetaProperty<int[]> indices() {
            return indices;
        }

        /**
         * The meta-property for the {@code weights} property.
         * @return the meta-property, not null
         */
        public MetaProperty<DoubleArray> weights() {
            return weights;
        }

        //-----------------------------------------------------------------------
        @Override
        protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
            switch (propertyName.hashCode()) {
                case 111972721:  // value
                    return ((QuantileResult) bean).getValue();
                case 1943391143:  // indices
                    return ((QuantileResult) bean).getIndices();
                case 1230441723:  // weights
                    return ((QuantileResult) bean).getWeights();
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
     * The bean-builder for {@code QuantileResult}.
     */
    private static final class Builder extends DirectFieldsBeanBuilder<QuantileResult> {

        private double value;
        private int[] indices;
        private DoubleArray weights;

        /**
         * Restricted constructor.
         */
        private Builder() {
        }

        //-----------------------------------------------------------------------
        @Override
        public Object get(String propertyName) {
            switch (propertyName.hashCode()) {
                case 111972721:  // value
                    return value;
                case 1943391143:  // indices
                    return indices;
                case 1230441723:  // weights
                    return weights;
                default:
                    throw new NoSuchElementException("Unknown property: " + propertyName);
            }
        }

        @Override
        public Builder set(String propertyName, Object newValue) {
            switch (propertyName.hashCode()) {
                case 111972721:  // value
                    this.value = (Double) newValue;
                    break;
                case 1943391143:  // indices
                    this.indices = (int[]) newValue;
                    break;
                case 1230441723:  // weights
                    this.weights = (DoubleArray) newValue;
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
        public QuantileResult build() {
            return new QuantileResult(
                    value,
                    indices,
                    weights);
        }

        //-----------------------------------------------------------------------
        @Override
        public String toString() {
            StringBuilder buf = new StringBuilder(128);
            buf.append("QuantileResult.Builder{");
            buf.append("value").append('=').append(JodaBeanUtils.toString(value)).append(',').append(' ');
            buf.append("indices").append('=').append(JodaBeanUtils.toString(indices)).append(',').append(' ');
            buf.append("weights").append('=').append(JodaBeanUtils.toString(weights));
            buf.append('}');
            return buf.toString();
        }

    }

    ///CLOVER:ON
    //-------------------------- AUTOGENERATED END --------------------------
}

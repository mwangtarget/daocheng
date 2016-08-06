/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.data.scenario;

import static com.opengamma.strata.collect.Guavate.toImmutableList;
import static com.opengamma.strata.collect.Guavate.zipWithIndex;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.IntFunction;
import java.util.stream.Stream;

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

import com.google.common.collect.ImmutableList;
import com.opengamma.strata.basics.currency.Currency;
import com.opengamma.strata.basics.currency.FxConvertible;
import com.opengamma.strata.collect.ArgChecker;
import com.opengamma.strata.collect.Messages;

/**
 * A scenario array holding one value for each scenario.
 * <p>
 * This contains a list of values, one value for each scenario.
 * 
 * @param <T>  the type of each individual value
 */
@BeanDefinition(builderScope = "private")
final class DefaultScenarioArray<T>
    implements ScenarioArray<T>, ScenarioFxConvertible<ScenarioArray<?>>, ImmutableBean, Serializable {

  /**
   * The values, one per scenario.
   */
  @PropertyDefinition(validate = "notNull")
  private final ImmutableList<T> values;

  //-------------------------------------------------------------------------
  /**
   * Obtains an instance from the specified array of values.
   *
   * @param <T>  the type of the value
   * @param values  the values, one value for each scenario
   * @return an instance with the specified values
   */
  @SafeVarargs
  public static <T> DefaultScenarioArray<T> of(T... values) {
    return new DefaultScenarioArray<>(ImmutableList.copyOf(values));
  }

  /**
   * Obtains an instance from the specified list of values.
   *
   * @param <T>  the type of the value
   * @param values  the values, one value for each scenario
   * @return an instance with the specified values
   */
  public static <T> DefaultScenarioArray<T> of(List<T> values) {
    return new DefaultScenarioArray<>(values);
  }

  /**
   * Obtains an instance using a function to create the entries.
   * <p>
   * The function is passed the scenario index and returns the value for that index.
   * 
   * @param <T>  the type of the value
   * @param scenarioCount  the number of scenarios
   * @param valueFunction  the function used to obtain each value
   * @return an instance initialized using the function
   * @throws IllegalArgumentException is size is zero or less
   */
  public static <T> DefaultScenarioArray<T> of(int scenarioCount, IntFunction<T> valueFunction) {
    ArgChecker.notNegativeOrZero(scenarioCount, "scenarioCount");
    ImmutableList.Builder<T> builder = ImmutableList.builder();
    for (int i = 0; i < scenarioCount; i++) {
      builder.add(valueFunction.apply(i));
    }
    return new DefaultScenarioArray<>(builder.build());
  }

  //-------------------------------------------------------------------------
  @Override
  public int getScenarioCount() {
    return values.size();
  }

  @Override
  public T get(int index) {
    return values.get(index);
  }

  @Override
  public Stream<T> stream() {
    return values.stream();
  }

  //-------------------------------------------------------------------------
  @Override
  public ScenarioArray<?> convertedTo(Currency resultCurrency, ScenarioFxRateProvider fxRateProvider) {
    int scenarioCount = getScenarioCount();
    if (fxRateProvider.getScenarioCount() != scenarioCount) {
      throw new IllegalArgumentException(Messages.format(
          "Expected {} FX rates but received {}", scenarioCount, fxRateProvider.getScenarioCount()));
    }
    ImmutableList<Object> converted = zipWithIndex(values.stream())
        .map(tp -> convert(resultCurrency, fxRateProvider, tp.getFirst(), tp.getSecond()))
        .collect(toImmutableList());
    return DefaultScenarioArray.of(converted);
  }

  // convert value if possible
  private Object convert(Currency reportingCurrency, ScenarioFxRateProvider fxRateProvider, Object base, int index) {
    if (base instanceof FxConvertible<?>) {
      FxConvertible<?> convertible = (FxConvertible<?>) base;
      return convertible.convertedTo(reportingCurrency, fxRateProvider.fxRateProvider(index));
    }
    return base;
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code DefaultScenarioArray}.
   * @return the meta-bean, not null
   */
  @SuppressWarnings("rawtypes")
  public static DefaultScenarioArray.Meta meta() {
    return DefaultScenarioArray.Meta.INSTANCE;
  }

  /**
   * The meta-bean for {@code DefaultScenarioArray}.
   * @param <R>  the bean's generic type
   * @param cls  the bean's generic type
   * @return the meta-bean, not null
   */
  @SuppressWarnings("unchecked")
  public static <R> DefaultScenarioArray.Meta<R> metaDefaultScenarioArray(Class<R> cls) {
    return DefaultScenarioArray.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(DefaultScenarioArray.Meta.INSTANCE);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  private DefaultScenarioArray(
      List<T> values) {
    JodaBeanUtils.notNull(values, "values");
    this.values = ImmutableList.copyOf(values);
  }

  @SuppressWarnings("unchecked")
  @Override
  public DefaultScenarioArray.Meta<T> metaBean() {
    return DefaultScenarioArray.Meta.INSTANCE;
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
   * Gets the values, one per scenario.
   * @return the value of the property, not null
   */
  public ImmutableList<T> getValues() {
    return values;
  }

  //-----------------------------------------------------------------------
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      DefaultScenarioArray<?> other = (DefaultScenarioArray<?>) obj;
      return JodaBeanUtils.equal(values, other.values);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(values);
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(64);
    buf.append("DefaultScenarioArray{");
    buf.append("values").append('=').append(JodaBeanUtils.toString(values));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code DefaultScenarioArray}.
   * @param <T>  the type
   */
  public static final class Meta<T> extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    @SuppressWarnings("rawtypes")
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code values} property.
     */
    @SuppressWarnings({"unchecked", "rawtypes" })
    private final MetaProperty<ImmutableList<T>> values = DirectMetaProperty.ofImmutable(
        this, "values", DefaultScenarioArray.class, (Class) ImmutableList.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "values");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case -823812830:  // values
          return values;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends DefaultScenarioArray<T>> builder() {
      return new DefaultScenarioArray.Builder<T>();
    }

    @SuppressWarnings({"unchecked", "rawtypes" })
    @Override
    public Class<? extends DefaultScenarioArray<T>> beanType() {
      return (Class) DefaultScenarioArray.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code values} property.
     * @return the meta-property, not null
     */
    public MetaProperty<ImmutableList<T>> values() {
      return values;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case -823812830:  // values
          return ((DefaultScenarioArray<?>) bean).getValues();
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
   * The bean-builder for {@code DefaultScenarioArray}.
   * @param <T>  the type
   */
  private static final class Builder<T> extends DirectFieldsBeanBuilder<DefaultScenarioArray<T>> {

    private List<T> values = ImmutableList.of();

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case -823812830:  // values
          return values;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Builder<T> set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case -823812830:  // values
          this.values = (List<T>) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public Builder<T> set(MetaProperty<?> property, Object value) {
      super.set(property, value);
      return this;
    }

    @Override
    public Builder<T> setString(String propertyName, String value) {
      setString(meta().metaProperty(propertyName), value);
      return this;
    }

    @Override
    public Builder<T> setString(MetaProperty<?> property, String value) {
      super.setString(property, value);
      return this;
    }

    @Override
    public Builder<T> setAll(Map<String, ? extends Object> propertyValueMap) {
      super.setAll(propertyValueMap);
      return this;
    }

    @Override
    public DefaultScenarioArray<T> build() {
      return new DefaultScenarioArray<T>(
          values);
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(64);
      buf.append("DefaultScenarioArray.Builder{");
      buf.append("values").append('=').append(JodaBeanUtils.toString(values));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}

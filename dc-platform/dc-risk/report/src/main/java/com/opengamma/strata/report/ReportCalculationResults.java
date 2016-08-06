/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 * 
 * Please see distribution for license.
 */
package com.opengamma.strata.report;

import java.time.LocalDate;
import java.util.List;
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

import com.google.common.collect.ImmutableList;
import com.opengamma.strata.basics.CalculationTarget;
import com.opengamma.strata.basics.ReferenceData;
import com.opengamma.strata.calc.Column;
import com.opengamma.strata.calc.Results;
import com.opengamma.strata.calc.runner.CalculationFunctions;
import com.opengamma.strata.measure.StandardComponents;

/**
 * Stores a set of engine calculation results along with the context required to run reports.
 */
@BeanDefinition(builderScope = "private")
public final class ReportCalculationResults implements ImmutableBean {

  /**
   * The valuation date.
   */
  @PropertyDefinition(validate = "notNull")
  private final LocalDate valuationDate;
  /**
   * The targets on which the results are calculated.
   */
  @PropertyDefinition(validate = "notNull")
  private final List<CalculationTarget> targets;
  /**
   * The columns contained in the results.
   */
  @PropertyDefinition(validate = "notNull")
  private final List<Column> columns;
  /**
   * The calculation results.
   */
  @PropertyDefinition(validate = "notNull")
  private final Results calculationResults;
  /**
   * The calculation functions.
   */
  @PropertyDefinition(validate = "notNull")
  private final CalculationFunctions calculationFunctions;
  /**
   * The reference data.
   * This is used to resolve trade or security information if necessary.
   */
  @PropertyDefinition(validate = "notNull")
  private final ReferenceData referenceData;

  //-------------------------------------------------------------------------
  /**
   * Obtains an instance from the valuation date, trades, columns and results.
   * <p>
   * This uses standard reference data.
   *
   * @param valuationDate  the valuation date used in the calculations
   * @param targets  the targets for which the results were calculated
   * @param columns  the columns in the results
   * @param calculationResults  the results of the calculations
   * @return the results
   */
  public static ReportCalculationResults of(
      LocalDate valuationDate,
      List<? extends CalculationTarget> targets,
      List<Column> columns,
      Results calculationResults) {

    return of(
        valuationDate,
        targets,
        columns,
        calculationResults,
        StandardComponents.calculationFunctions(),
        ReferenceData.standard());
  }

  /**
   * Obtains an instance from the valuation date, trades, columns, results and reference data.
   *
   * @param valuationDate  the valuation date used in the calculations
   * @param targets  the targets for which the results were calculated
   * @param columns  the columns in the results
   * @param calculationResults  the results of the calculations
   * @param calculationFunctions  the calculation functions that were used
   * @param refData  the reference data used in the calculation
   * @return the results
   */
  public static ReportCalculationResults of(
      LocalDate valuationDate,
      List<? extends CalculationTarget> targets,
      List<Column> columns,
      Results calculationResults,
      CalculationFunctions calculationFunctions,
      ReferenceData refData) {

    return new ReportCalculationResults(
        valuationDate, ImmutableList.copyOf(targets), columns, calculationResults, calculationFunctions, refData);
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code ReportCalculationResults}.
   * @return the meta-bean, not null
   */
  public static ReportCalculationResults.Meta meta() {
    return ReportCalculationResults.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(ReportCalculationResults.Meta.INSTANCE);
  }

  private ReportCalculationResults(
      LocalDate valuationDate,
      List<CalculationTarget> targets,
      List<Column> columns,
      Results calculationResults,
      CalculationFunctions calculationFunctions,
      ReferenceData referenceData) {
    JodaBeanUtils.notNull(valuationDate, "valuationDate");
    JodaBeanUtils.notNull(targets, "targets");
    JodaBeanUtils.notNull(columns, "columns");
    JodaBeanUtils.notNull(calculationResults, "calculationResults");
    JodaBeanUtils.notNull(calculationFunctions, "calculationFunctions");
    JodaBeanUtils.notNull(referenceData, "referenceData");
    this.valuationDate = valuationDate;
    this.targets = ImmutableList.copyOf(targets);
    this.columns = ImmutableList.copyOf(columns);
    this.calculationResults = calculationResults;
    this.calculationFunctions = calculationFunctions;
    this.referenceData = referenceData;
  }

  @Override
  public ReportCalculationResults.Meta metaBean() {
    return ReportCalculationResults.Meta.INSTANCE;
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
   * Gets the valuation date.
   * @return the value of the property, not null
   */
  public LocalDate getValuationDate() {
    return valuationDate;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the targets on which the results are calculated.
   * @return the value of the property, not null
   */
  public List<CalculationTarget> getTargets() {
    return targets;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the columns contained in the results.
   * @return the value of the property, not null
   */
  public List<Column> getColumns() {
    return columns;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the calculation results.
   * @return the value of the property, not null
   */
  public Results getCalculationResults() {
    return calculationResults;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the calculation functions.
   * @return the value of the property, not null
   */
  public CalculationFunctions getCalculationFunctions() {
    return calculationFunctions;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the reference data.
   * This is used to resolve trade or security information if necessary.
   * @return the value of the property, not null
   */
  public ReferenceData getReferenceData() {
    return referenceData;
  }

  //-----------------------------------------------------------------------
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      ReportCalculationResults other = (ReportCalculationResults) obj;
      return JodaBeanUtils.equal(valuationDate, other.valuationDate) &&
          JodaBeanUtils.equal(targets, other.targets) &&
          JodaBeanUtils.equal(columns, other.columns) &&
          JodaBeanUtils.equal(calculationResults, other.calculationResults) &&
          JodaBeanUtils.equal(calculationFunctions, other.calculationFunctions) &&
          JodaBeanUtils.equal(referenceData, other.referenceData);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(valuationDate);
    hash = hash * 31 + JodaBeanUtils.hashCode(targets);
    hash = hash * 31 + JodaBeanUtils.hashCode(columns);
    hash = hash * 31 + JodaBeanUtils.hashCode(calculationResults);
    hash = hash * 31 + JodaBeanUtils.hashCode(calculationFunctions);
    hash = hash * 31 + JodaBeanUtils.hashCode(referenceData);
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(224);
    buf.append("ReportCalculationResults{");
    buf.append("valuationDate").append('=').append(valuationDate).append(',').append(' ');
    buf.append("targets").append('=').append(targets).append(',').append(' ');
    buf.append("columns").append('=').append(columns).append(',').append(' ');
    buf.append("calculationResults").append('=').append(calculationResults).append(',').append(' ');
    buf.append("calculationFunctions").append('=').append(calculationFunctions).append(',').append(' ');
    buf.append("referenceData").append('=').append(JodaBeanUtils.toString(referenceData));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code ReportCalculationResults}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code valuationDate} property.
     */
    private final MetaProperty<LocalDate> valuationDate = DirectMetaProperty.ofImmutable(
        this, "valuationDate", ReportCalculationResults.class, LocalDate.class);
    /**
     * The meta-property for the {@code targets} property.
     */
    @SuppressWarnings({"unchecked", "rawtypes" })
    private final MetaProperty<List<CalculationTarget>> targets = DirectMetaProperty.ofImmutable(
        this, "targets", ReportCalculationResults.class, (Class) List.class);
    /**
     * The meta-property for the {@code columns} property.
     */
    @SuppressWarnings({"unchecked", "rawtypes" })
    private final MetaProperty<List<Column>> columns = DirectMetaProperty.ofImmutable(
        this, "columns", ReportCalculationResults.class, (Class) List.class);
    /**
     * The meta-property for the {@code calculationResults} property.
     */
    private final MetaProperty<Results> calculationResults = DirectMetaProperty.ofImmutable(
        this, "calculationResults", ReportCalculationResults.class, Results.class);
    /**
     * The meta-property for the {@code calculationFunctions} property.
     */
    private final MetaProperty<CalculationFunctions> calculationFunctions = DirectMetaProperty.ofImmutable(
        this, "calculationFunctions", ReportCalculationResults.class, CalculationFunctions.class);
    /**
     * The meta-property for the {@code referenceData} property.
     */
    private final MetaProperty<ReferenceData> referenceData = DirectMetaProperty.ofImmutable(
        this, "referenceData", ReportCalculationResults.class, ReferenceData.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "valuationDate",
        "targets",
        "columns",
        "calculationResults",
        "calculationFunctions",
        "referenceData");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 113107279:  // valuationDate
          return valuationDate;
        case -1538277118:  // targets
          return targets;
        case 949721053:  // columns
          return columns;
        case 2096132333:  // calculationResults
          return calculationResults;
        case 1722473170:  // calculationFunctions
          return calculationFunctions;
        case 1600456085:  // referenceData
          return referenceData;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends ReportCalculationResults> builder() {
      return new ReportCalculationResults.Builder();
    }

    @Override
    public Class<? extends ReportCalculationResults> beanType() {
      return ReportCalculationResults.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code valuationDate} property.
     * @return the meta-property, not null
     */
    public MetaProperty<LocalDate> valuationDate() {
      return valuationDate;
    }

    /**
     * The meta-property for the {@code targets} property.
     * @return the meta-property, not null
     */
    public MetaProperty<List<CalculationTarget>> targets() {
      return targets;
    }

    /**
     * The meta-property for the {@code columns} property.
     * @return the meta-property, not null
     */
    public MetaProperty<List<Column>> columns() {
      return columns;
    }

    /**
     * The meta-property for the {@code calculationResults} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Results> calculationResults() {
      return calculationResults;
    }

    /**
     * The meta-property for the {@code calculationFunctions} property.
     * @return the meta-property, not null
     */
    public MetaProperty<CalculationFunctions> calculationFunctions() {
      return calculationFunctions;
    }

    /**
     * The meta-property for the {@code referenceData} property.
     * @return the meta-property, not null
     */
    public MetaProperty<ReferenceData> referenceData() {
      return referenceData;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 113107279:  // valuationDate
          return ((ReportCalculationResults) bean).getValuationDate();
        case -1538277118:  // targets
          return ((ReportCalculationResults) bean).getTargets();
        case 949721053:  // columns
          return ((ReportCalculationResults) bean).getColumns();
        case 2096132333:  // calculationResults
          return ((ReportCalculationResults) bean).getCalculationResults();
        case 1722473170:  // calculationFunctions
          return ((ReportCalculationResults) bean).getCalculationFunctions();
        case 1600456085:  // referenceData
          return ((ReportCalculationResults) bean).getReferenceData();
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
   * The bean-builder for {@code ReportCalculationResults}.
   */
  private static final class Builder extends DirectFieldsBeanBuilder<ReportCalculationResults> {

    private LocalDate valuationDate;
    private List<CalculationTarget> targets = ImmutableList.of();
    private List<Column> columns = ImmutableList.of();
    private Results calculationResults;
    private CalculationFunctions calculationFunctions;
    private ReferenceData referenceData;

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case 113107279:  // valuationDate
          return valuationDate;
        case -1538277118:  // targets
          return targets;
        case 949721053:  // columns
          return columns;
        case 2096132333:  // calculationResults
          return calculationResults;
        case 1722473170:  // calculationFunctions
          return calculationFunctions;
        case 1600456085:  // referenceData
          return referenceData;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case 113107279:  // valuationDate
          this.valuationDate = (LocalDate) newValue;
          break;
        case -1538277118:  // targets
          this.targets = (List<CalculationTarget>) newValue;
          break;
        case 949721053:  // columns
          this.columns = (List<Column>) newValue;
          break;
        case 2096132333:  // calculationResults
          this.calculationResults = (Results) newValue;
          break;
        case 1722473170:  // calculationFunctions
          this.calculationFunctions = (CalculationFunctions) newValue;
          break;
        case 1600456085:  // referenceData
          this.referenceData = (ReferenceData) newValue;
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
    public ReportCalculationResults build() {
      return new ReportCalculationResults(
          valuationDate,
          targets,
          columns,
          calculationResults,
          calculationFunctions,
          referenceData);
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(224);
      buf.append("ReportCalculationResults.Builder{");
      buf.append("valuationDate").append('=').append(JodaBeanUtils.toString(valuationDate)).append(',').append(' ');
      buf.append("targets").append('=').append(JodaBeanUtils.toString(targets)).append(',').append(' ');
      buf.append("columns").append('=').append(JodaBeanUtils.toString(columns)).append(',').append(' ');
      buf.append("calculationResults").append('=').append(JodaBeanUtils.toString(calculationResults)).append(',').append(' ');
      buf.append("calculationFunctions").append('=').append(JodaBeanUtils.toString(calculationFunctions)).append(',').append(' ');
      buf.append("referenceData").append('=').append(JodaBeanUtils.toString(referenceData));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
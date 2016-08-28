package com.daocheng.transaction.user;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import org.joda.beans.BeanBuilder;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.strata.basics.StandardId;
import com.opengamma.strata.basics.currency.Currency;
import org.joda.beans.Bean;
import org.joda.beans.impl.direct.DirectMetaProperty;

/**
 * 
 * @author mwang
 * To define the UserInfo,
 * 
 * Per transaction, there can had multiple User been involved, like trader/sales/etc..
 * @TODO: Define the UserGroup also
 *
 */
@BeanDefinition
public final class UserInfo implements ImmutableBean, Serializable {
    
    @PropertyDefinition(get = "optional")
    private final StandardId id;

    @PropertyDefinition(get = "optional")
    private final String password;
   
    @PropertyDefinition(get = "optional")
    private final LocalDate creationDate;

    @PropertyDefinition(get = "optional")
    private final LocalTime creationTime;

    //------------------------- AUTOGENERATED START -------------------------
    ///CLOVER:OFF
    /**
     * The meta-bean for {@code UserInfo}.
     * @return the meta-bean, not null
     */
    public static UserInfo.Meta meta() {
        return UserInfo.Meta.INSTANCE;
    }

    static {
        JodaBeanUtils.registerMetaBean(UserInfo.Meta.INSTANCE);
    }

    /**
     * The serialization version id.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Returns a builder used to create an instance of the bean.
     * @return the builder, not null
     */
    public static UserInfo.Builder builder() {
        return new UserInfo.Builder();
    }

    private UserInfo(
            StandardId id,
            String password,
            LocalDate creationDate,
            LocalTime creationTime) {
        this.id = id;
        this.password = password;
        this.creationDate = creationDate;
        this.creationTime = creationTime;
    }

    @Override
    public UserInfo.Meta metaBean() {
        return UserInfo.Meta.INSTANCE;
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
     * Gets the id.
     * @return the optional value of the property, not null
     */
    public Optional<StandardId> getId() {
        return Optional.ofNullable(id);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the password.
     * @return the optional value of the property, not null
     */
    public Optional<String> getPassword() {
        return Optional.ofNullable(password);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the creationDate.
     * @return the optional value of the property, not null
     */
    public Optional<LocalDate> getCreationDate() {
        return Optional.ofNullable(creationDate);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the creationTime.
     * @return the optional value of the property, not null
     */
    public Optional<LocalTime> getCreationTime() {
        return Optional.ofNullable(creationTime);
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
            UserInfo other = (UserInfo) obj;
            return JodaBeanUtils.equal(id, other.id) &&
                    JodaBeanUtils.equal(password, other.password) &&
                    JodaBeanUtils.equal(creationDate, other.creationDate) &&
                    JodaBeanUtils.equal(creationTime, other.creationTime);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = getClass().hashCode();
        hash = hash * 31 + JodaBeanUtils.hashCode(id);
        hash = hash * 31 + JodaBeanUtils.hashCode(password);
        hash = hash * 31 + JodaBeanUtils.hashCode(creationDate);
        hash = hash * 31 + JodaBeanUtils.hashCode(creationTime);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(160);
        buf.append("UserInfo{");
        buf.append("id").append('=').append(id).append(',').append(' ');
        buf.append("password").append('=').append(password).append(',').append(' ');
        buf.append("creationDate").append('=').append(creationDate).append(',').append(' ');
        buf.append("creationTime").append('=').append(JodaBeanUtils.toString(creationTime));
        buf.append('}');
        return buf.toString();
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-bean for {@code UserInfo}.
     */
    public static final class Meta extends DirectMetaBean {
        /**
         * The singleton instance of the meta-bean.
         */
        static final Meta INSTANCE = new Meta();

        /**
         * The meta-property for the {@code id} property.
         */
        private final MetaProperty<StandardId> id = DirectMetaProperty.ofImmutable(
                this, "id", UserInfo.class, StandardId.class);
        /**
         * The meta-property for the {@code password} property.
         */
        private final MetaProperty<String> password = DirectMetaProperty.ofImmutable(
                this, "password", UserInfo.class, String.class);
        /**
         * The meta-property for the {@code creationDate} property.
         */
        private final MetaProperty<LocalDate> creationDate = DirectMetaProperty.ofImmutable(
                this, "creationDate", UserInfo.class, LocalDate.class);
        /**
         * The meta-property for the {@code creationTime} property.
         */
        private final MetaProperty<LocalTime> creationTime = DirectMetaProperty.ofImmutable(
                this, "creationTime", UserInfo.class, LocalTime.class);
        /**
         * The meta-properties.
         */
        private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
                this, null,
                "id",
                "password",
                "creationDate",
                "creationTime");

        /**
         * Restricted constructor.
         */
        private Meta() {
        }

        @Override
        protected MetaProperty<?> metaPropertyGet(String propertyName) {
            switch (propertyName.hashCode()) {
                case 3355:  // id
                    return id;
                case 1216985755:  // password
                    return password;
                case 1585531693:  // creationDate
                    return creationDate;
                case 1586015820:  // creationTime
                    return creationTime;
            }
            return super.metaPropertyGet(propertyName);
        }

        @Override
        public UserInfo.Builder builder() {
            return new UserInfo.Builder();
        }

        @Override
        public Class<? extends UserInfo> beanType() {
            return UserInfo.class;
        }

        @Override
        public Map<String, MetaProperty<?>> metaPropertyMap() {
            return metaPropertyMap$;
        }

        //-----------------------------------------------------------------------
        /**
         * The meta-property for the {@code id} property.
         * @return the meta-property, not null
         */
        public MetaProperty<StandardId> id() {
            return id;
        }

        /**
         * The meta-property for the {@code password} property.
         * @return the meta-property, not null
         */
        public MetaProperty<String> password() {
            return password;
        }

        /**
         * The meta-property for the {@code creationDate} property.
         * @return the meta-property, not null
         */
        public MetaProperty<LocalDate> creationDate() {
            return creationDate;
        }

        /**
         * The meta-property for the {@code creationTime} property.
         * @return the meta-property, not null
         */
        public MetaProperty<LocalTime> creationTime() {
            return creationTime;
        }

        //-----------------------------------------------------------------------
        @Override
        protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
            switch (propertyName.hashCode()) {
                case 3355:  // id
                    return ((UserInfo) bean).id;
                case 1216985755:  // password
                    return ((UserInfo) bean).password;
                case 1585531693:  // creationDate
                    return ((UserInfo) bean).creationDate;
                case 1586015820:  // creationTime
                    return ((UserInfo) bean).creationTime;
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
     * The bean-builder for {@code UserInfo}.
     */
    public static final class Builder extends DirectFieldsBeanBuilder<UserInfo> {

        private StandardId id;
        private String password;
        private LocalDate creationDate;
        private LocalTime creationTime;

        /**
         * Restricted constructor.
         */
        private Builder() {
        }

        /**
         * Restricted copy constructor.
         * @param beanToCopy  the bean to copy from, not null
         */
        private Builder(UserInfo beanToCopy) {
            this.id = beanToCopy.id;
            this.password = beanToCopy.password;
            this.creationDate = beanToCopy.creationDate;
            this.creationTime = beanToCopy.creationTime;
        }

        //-----------------------------------------------------------------------
        @Override
        public Object get(String propertyName) {
            switch (propertyName.hashCode()) {
                case 3355:  // id
                    return id;
                case 1216985755:  // password
                    return password;
                case 1585531693:  // creationDate
                    return creationDate;
                case 1586015820:  // creationTime
                    return creationTime;
                default:
                    throw new NoSuchElementException("Unknown property: " + propertyName);
            }
        }

        @Override
        public Builder set(String propertyName, Object newValue) {
            switch (propertyName.hashCode()) {
                case 3355:  // id
                    this.id = (StandardId) newValue;
                    break;
                case 1216985755:  // password
                    this.password = (String) newValue;
                    break;
                case 1585531693:  // creationDate
                    this.creationDate = (LocalDate) newValue;
                    break;
                case 1586015820:  // creationTime
                    this.creationTime = (LocalTime) newValue;
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
        public UserInfo build() {
            return new UserInfo(
                    id,
                    password,
                    creationDate,
                    creationTime);
        }

        //-----------------------------------------------------------------------
        /**
         * Sets the id.
         * @param id  the new value
         * @return this, for chaining, not null
         */
        public Builder id(StandardId id) {
            this.id = id;
            return this;
        }

        /**
         * Sets the password.
         * @param password  the new value
         * @return this, for chaining, not null
         */
        public Builder password(String password) {
            this.password = password;
            return this;
        }

        /**
         * Sets the creationDate.
         * @param creationDate  the new value
         * @return this, for chaining, not null
         */
        public Builder creationDate(LocalDate creationDate) {
            this.creationDate = creationDate;
            return this;
        }

        /**
         * Sets the creationTime.
         * @param creationTime  the new value
         * @return this, for chaining, not null
         */
        public Builder creationTime(LocalTime creationTime) {
            this.creationTime = creationTime;
            return this;
        }

        //-----------------------------------------------------------------------
        @Override
        public String toString() {
            StringBuilder buf = new StringBuilder(160);
            buf.append("UserInfo.Builder{");
            buf.append("id").append('=').append(JodaBeanUtils.toString(id)).append(',').append(' ');
            buf.append("password").append('=').append(JodaBeanUtils.toString(password)).append(',').append(' ');
            buf.append("creationDate").append('=').append(JodaBeanUtils.toString(creationDate)).append(',').append(' ');
            buf.append("creationTime").append('=').append(JodaBeanUtils.toString(creationTime));
            buf.append('}');
            return buf.toString();
        }

    }

    ///CLOVER:ON
    //-------------------------- AUTOGENERATED END --------------------------
}
package com.daocheng.clearout;
///* package com.daocheng.trade;
//
//
//import java.io.Serializable;
//
//import org.joda.beans.BeanDefinition;
//import org.joda.beans.ImmutableBean;
//import java.util.Map;
//import java.util.NoSuchElementException;
//import java.util.Optional;
//import java.util.Set;
//import org.joda.beans.BeanBuilder;
//import org.joda.beans.JodaBeanUtils;
//import org.joda.beans.MetaProperty;
//import org.joda.beans.Property;
//import org.joda.beans.PropertyDefinition;
//import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
//import org.joda.beans.impl.direct.DirectMetaBean;
//import org.joda.beans.impl.direct.DirectMetaPropertyMap;
//
//import com.daocheng.trade.book.BookInfo;
//import com.daocheng.trade.party.PartyInfo;
//import com.daocheng.trade.user.UserInfo;
//import com.opengamma.strata.basics.StandardId;
//import com.opengamma.strata.product.Trade;
//import com.opengamma.strata.product.fx.FxSingleTrade;
//
//import org.joda.beans.Bean;
//import org.joda.beans.impl.direct.DirectMetaProperty;
//
//@BeanDefinition
//public final class Transaction implements ImmutableBean, Serializable {
//
//
//    
//    @PropertyDefinition(get = "optional")
//    private final StandardId id;
//
//    @PropertyDefinition(get = "optional")
//    private final BookInfo bookInfo;
//
//    @PropertyDefinition(get = "optional")
//    private final PartyInfo partyInfo;
//
//    @PropertyDefinition(get = "optional")
//    private final UserInfo userInfo;
//
//    @PropertyDefinition(get = "optional")
//    private final Trade trade;
//
//    //------------------------- AUTOGENERATED START -------------------------
//    ///CLOVER:OFF
//    *//**
//     * The meta-bean for {@code Transaction}.
//     * @return the meta-bean, not null
//     *//*
//    public static Transaction.Meta meta() {
//        return Transaction.Meta.INSTANCE;
//    }
//
//    static {
//        JodaBeanUtils.registerMetaBean(Transaction.Meta.INSTANCE);
//    }
//
//    *//**
//     * The serialization version id.
//     *//*
//    private static final long serialVersionUID = 1L;
//
//    *//**
//     * Returns a builder used to create an instance of the bean.
//     * @return the builder, not null
//     *//*
//    public static Transaction.Builder builder() {
//        return new Transaction.Builder();
//    }
//
//    private Transaction(
//            StandardId id,
//            BookInfo bookInfo,
//            PartyInfo partyInfo,
//            UserInfo userInfo,
//            Trade trade) {
//        this.id = id;
//        this.bookInfo = bookInfo;
//        this.partyInfo = partyInfo;
//        this.userInfo = userInfo;
//        this.trade = trade;
//    }
//
//    @Override
//    public Transaction.Meta metaBean() {
//        return Transaction.Meta.INSTANCE;
//    }
//
//    @Override
//    public <R> Property<R> property(String propertyName) {
//        return metaBean().<R>metaProperty(propertyName).createProperty(this);
//    }
//
//    @Override
//    public Set<String> propertyNames() {
//        return metaBean().metaPropertyMap().keySet();
//    }
//
//    //-----------------------------------------------------------------------
//    *//**
//     * Gets the id.
//     * @return the optional value of the property, not null
//     *//*
//    public Optional<StandardId> getId() {
//        return Optional.ofNullable(id);
//    }
//
//    //-----------------------------------------------------------------------
//    *//**
//     * Gets the bookInfo.
//     * @return the optional value of the property, not null
//     *//*
//    public Optional<BookInfo> getBookInfo() {
//        return Optional.ofNullable(bookInfo);
//    }
//
//    //-----------------------------------------------------------------------
//    *//**
//     * Gets the partyInfo.
//     * @return the optional value of the property, not null
//     *//*
//    public Optional<PartyInfo> getPartyInfo() {
//        return Optional.ofNullable(partyInfo);
//    }
//
//    //-----------------------------------------------------------------------
//    *//**
//     * Gets the userInfo.
//     * @return the optional value of the property, not null
//     *//*
//    public Optional<UserInfo> getUserInfo() {
//        return Optional.ofNullable(userInfo);
//    }
//
//    //-----------------------------------------------------------------------
//    *//**
//     * Gets the trade.
//     * @return the optional value of the property, not null
//     *//*
//    public Optional<Trade> getTrade() {
//        return Optional.ofNullable(trade);
//    }
//
//    //-----------------------------------------------------------------------
//    *//**
//     * Returns a builder that allows this bean to be mutated.
//     * @return the mutable builder, not null
//     *//*
//    public Builder toBuilder() {
//        return new Builder(this);
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == this) {
//            return true;
//        }
//        if (obj != null && obj.getClass() == this.getClass()) {
//            Transaction other = (Transaction) obj;
//            return JodaBeanUtils.equal(id, other.id) &&
//                    JodaBeanUtils.equal(bookInfo, other.bookInfo) &&
//                    JodaBeanUtils.equal(partyInfo, other.partyInfo) &&
//                    JodaBeanUtils.equal(userInfo, other.userInfo) &&
//                    JodaBeanUtils.equal(trade, other.trade);
//        }
//        return false;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = getClass().hashCode();
//        hash = hash * 31 + JodaBeanUtils.hashCode(id);
//        hash = hash * 31 + JodaBeanUtils.hashCode(bookInfo);
//        hash = hash * 31 + JodaBeanUtils.hashCode(partyInfo);
//        hash = hash * 31 + JodaBeanUtils.hashCode(userInfo);
//        hash = hash * 31 + JodaBeanUtils.hashCode(trade);
//        return hash;
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder buf = new StringBuilder(192);
//        buf.append("Transaction{");
//        buf.append("id").append('=').append(id).append(',').append(' ');
//        buf.append("bookInfo").append('=').append(bookInfo).append(',').append(' ');
//        buf.append("partyInfo").append('=').append(partyInfo).append(',').append(' ');
//        buf.append("userInfo").append('=').append(userInfo).append(',').append(' ');
//        buf.append("trade").append('=').append(JodaBeanUtils.toString(trade));
//        buf.append('}');
//        return buf.toString();
//    }
//
//    //-----------------------------------------------------------------------
//    *//**
//     * The meta-bean for {@code Transaction}.
//     *//*
//    public static final class Meta extends DirectMetaBean {
//        *//**
//         * The singleton instance of the meta-bean.
//         *//*
//        static final Meta INSTANCE = new Meta();
//
//        *//**
//         * The meta-property for the {@code id} property.
//         *//*
//        private final MetaProperty<StandardId> id = DirectMetaProperty.ofImmutable(
//                this, "id", Transaction.class, StandardId.class);
//        *//**
//         * The meta-property for the {@code bookInfo} property.
//         *//*
//        private final MetaProperty<BookInfo> bookInfo = DirectMetaProperty.ofImmutable(
//                this, "bookInfo", Transaction.class, BookInfo.class);
//        *//**
//         * The meta-property for the {@code partyInfo} property.
//         *//*
//        private final MetaProperty<PartyInfo> partyInfo = DirectMetaProperty.ofImmutable(
//                this, "partyInfo", Transaction.class, PartyInfo.class);
//        *//**
//         * The meta-property for the {@code userInfo} property.
//         *//*
//        private final MetaProperty<UserInfo> userInfo = DirectMetaProperty.ofImmutable(
//                this, "userInfo", Transaction.class, UserInfo.class);
//        *//**
//         * The meta-property for the {@code trade} property.
//         *//*
//        private final MetaProperty<Trade> trade = DirectMetaProperty.ofImmutable(
//                this, "trade", Transaction.class, Trade.class);
//        *//**
//         * The meta-properties.
//         *//*
//        private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
//                this, null,
//                "id",
//                "bookInfo",
//                "partyInfo",
//                "userInfo",
//                "trade");
//
//        *//**
//         * Restricted constructor.
//         *//*
//        private Meta() {
//        }
//
//        @Override
//        protected MetaProperty<?> metaPropertyGet(String propertyName) {
//            switch (propertyName.hashCode()) {
//                case 3355:  // id
//                    return id;
//                case 2004318007:  // bookInfo
//                    return bookInfo;
//                case -1786310476:  // partyInfo
//                    return partyInfo;
//                case -266803431:  // userInfo
//                    return userInfo;
//                case 110621028:  // trade
//                    return trade;
//            }
//            return super.metaPropertyGet(propertyName);
//        }
//
//        @Override
//        public Transaction.Builder builder() {
//            return new Transaction.Builder();
//        }
//
//        @Override
//        public Class<? extends Transaction> beanType() {
//            return Transaction.class;
//        }
//
//        @Override
//        public Map<String, MetaProperty<?>> metaPropertyMap() {
//            return metaPropertyMap$;
//        }
//
//        //-----------------------------------------------------------------------
//        *//**
//         * The meta-property for the {@code id} property.
//         * @return the meta-property, not null
//         *//*
//        public MetaProperty<StandardId> id() {
//            return id;
//        }
//
//        *//**
//         * The meta-property for the {@code bookInfo} property.
//         * @return the meta-property, not null
//         *//*
//        public MetaProperty<BookInfo> bookInfo() {
//            return bookInfo;
//        }
//
//        *//**
//         * The meta-property for the {@code partyInfo} property.
//         * @return the meta-property, not null
//         *//*
//        public MetaProperty<PartyInfo> partyInfo() {
//            return partyInfo;
//        }
//
//        *//**
//         * The meta-property for the {@code userInfo} property.
//         * @return the meta-property, not null
//         *//*
//        public MetaProperty<UserInfo> userInfo() {
//            return userInfo;
//        }
//
//        *//**
//         * The meta-property for the {@code trade} property.
//         * @return the meta-property, not null
//         *//*
//        public MetaProperty<Trade> trade() {
//            return trade;
//        }
//
//        //-----------------------------------------------------------------------
//        @Override
//        protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
//            switch (propertyName.hashCode()) {
//                case 3355:  // id
//                    return ((Transaction) bean).id;
//                case 2004318007:  // bookInfo
//                    return ((Transaction) bean).bookInfo;
//                case -1786310476:  // partyInfo
//                    return ((Transaction) bean).partyInfo;
//                case -266803431:  // userInfo
//                    return ((Transaction) bean).userInfo;
//                case 110621028:  // trade
//                    return ((Transaction) bean).trade;
//            }
//            return super.propertyGet(bean, propertyName, quiet);
//        }
//
//        @Override
//        protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
//            metaProperty(propertyName);
//            if (quiet) {
//                return;
//            }
//            throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
//        }
//
//    }
//
//    //-----------------------------------------------------------------------
//    *//**
//     * The bean-builder for {@code Transaction}.
//     *//*
//    public static final class Builder extends DirectFieldsBeanBuilder<Transaction> {
//
//        private StandardId id;
//        private BookInfo bookInfo;
//        private PartyInfo partyInfo;
//        private UserInfo userInfo;
//        private Trade trade;
//
//        *//**
//         * Restricted constructor.
//         *//*
//        private Builder() {
//        }
//
//        *//**
//         * Restricted copy constructor.
//         * @param beanToCopy  the bean to copy from, not null
//         *//*
//        private Builder(Transaction beanToCopy) {
//            this.id = beanToCopy.id;
//            this.bookInfo = beanToCopy.bookInfo;
//            this.partyInfo = beanToCopy.partyInfo;
//            this.userInfo = beanToCopy.userInfo;
//            this.trade = beanToCopy.trade;
//        }
//
//        //-----------------------------------------------------------------------
//        @Override
//        public Object get(String propertyName) {
//            switch (propertyName.hashCode()) {
//                case 3355:  // id
//                    return id;
//                case 2004318007:  // bookInfo
//                    return bookInfo;
//                case -1786310476:  // partyInfo
//                    return partyInfo;
//                case -266803431:  // userInfo
//                    return userInfo;
//                case 110621028:  // trade
//                    return trade;
//                default:
//                    throw new NoSuchElementException("Unknown property: " + propertyName);
//            }
//        }
//
//        @Override
//        public Builder set(String propertyName, Object newValue) {
//            switch (propertyName.hashCode()) {
//                case 3355:  // id
//                    this.id = (StandardId) newValue;
//                    break;
//                case 2004318007:  // bookInfo
//                    this.bookInfo = (BookInfo) newValue;
//                    break;
//                case -1786310476:  // partyInfo
//                    this.partyInfo = (PartyInfo) newValue;
//                    break;
//                case -266803431:  // userInfo
//                    this.userInfo = (UserInfo) newValue;
//                    break;
//                case 110621028:  // trade
//                    this.trade = (Trade) newValue;
//                    break;
//                default:
//                    throw new NoSuchElementException("Unknown property: " + propertyName);
//            }
//            return this;
//        }
//
//        @Override
//        public Builder set(MetaProperty<?> property, Object value) {
//            super.set(property, value);
//            return this;
//        }
//
//        @Override
//        public Builder setString(String propertyName, String value) {
//            setString(meta().metaProperty(propertyName), value);
//            return this;
//        }
//
//        @Override
//        public Builder setString(MetaProperty<?> property, String value) {
//            super.setString(property, value);
//            return this;
//        }
//
//        @Override
//        public Builder setAll(Map<String, ? extends Object> propertyValueMap) {
//            super.setAll(propertyValueMap);
//            return this;
//        }
//
//        @Override
//        public Transaction build() {
//            return new Transaction(
//                    id,
//                    bookInfo,
//                    partyInfo,
//                    userInfo,
//                    trade);
//        }
//
//        //-----------------------------------------------------------------------
//        *//**
//         * Sets the id.
//         * @param id  the new value
//         * @return this, for chaining, not null
//         *//*
//        public Builder id(StandardId id) {
//            this.id = id;
//            return this;
//        }
//
//        *//**
//         * Sets the bookInfo.
//         * @param bookInfo  the new value
//         * @return this, for chaining, not null
//         *//*
//        public Builder bookInfo(BookInfo bookInfo) {
//            this.bookInfo = bookInfo;
//            return this;
//        }
//
//        *//**
//         * Sets the partyInfo.
//         * @param partyInfo  the new value
//         * @return this, for chaining, not null
//         *//*
//        public Builder partyInfo(PartyInfo partyInfo) {
//            this.partyInfo = partyInfo;
//            return this;
//        }
//
//        *//**
//         * Sets the userInfo.
//         * @param userInfo  the new value
//         * @return this, for chaining, not null
//         *//*
//        public Builder userInfo(UserInfo userInfo) {
//            this.userInfo = userInfo;
//            return this;
//        }
//
//        *//**
//         * Sets the trade.
//         * @param trade  the new value
//         * @return this, for chaining, not null
//         *//*
//        public Builder trade(Trade trade) {
//            this.trade = trade;
//            return this;
//        }
//
//        //-----------------------------------------------------------------------
//        @Override
//        public String toString() {
//            StringBuilder buf = new StringBuilder(192);
//            buf.append("Transaction.Builder{");
//            buf.append("id").append('=').append(JodaBeanUtils.toString(id)).append(',').append(' ');
//            buf.append("bookInfo").append('=').append(JodaBeanUtils.toString(bookInfo)).append(',').append(' ');
//            buf.append("partyInfo").append('=').append(JodaBeanUtils.toString(partyInfo)).append(',').append(' ');
//            buf.append("userInfo").append('=').append(JodaBeanUtils.toString(userInfo)).append(',').append(' ');
//            buf.append("trade").append('=').append(JodaBeanUtils.toString(trade));
//            buf.append('}');
//            return buf.toString();
//        }
//
//    }
//
//    ///CLOVER:ON
//    //-------------------------- AUTOGENERATED END --------------------------
//}
//*/
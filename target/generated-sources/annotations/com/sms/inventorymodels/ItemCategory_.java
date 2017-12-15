package com.sms.inventorymodels;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ItemCategory.class)
public abstract class ItemCategory_ {

	public static volatile SingularAttribute<ItemCategory, Long> id;
	public static volatile SingularAttribute<ItemCategory, String> categoryCode;
	public static volatile SingularAttribute<ItemCategory, String> categoryName;

}


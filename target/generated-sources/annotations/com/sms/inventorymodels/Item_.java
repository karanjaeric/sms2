package com.sms.inventorymodels;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Item.class)
public abstract class Item_ {

	public static volatile SingularAttribute<Item, String> itemName;
	public static volatile SingularAttribute<Item, Integer> reorderPoint;
	public static volatile SingularAttribute<Item, String> itemCode;
	public static volatile SingularAttribute<Item, Long> id;
	public static volatile SingularAttribute<Item, ItemCategory> category;
	public static volatile SingularAttribute<Item, Integer> remaining;

}


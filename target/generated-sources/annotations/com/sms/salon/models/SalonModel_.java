package com.sms.salon.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SalonModel.class)
public abstract class SalonModel_ {

	public static volatile SingularAttribute<SalonModel, String> phoneNumber;
	public static volatile SingularAttribute<SalonModel, String> salonName;
	public static volatile SingularAttribute<SalonModel, String> location;
	public static volatile SingularAttribute<SalonModel, Long> id;
	public static volatile SingularAttribute<SalonModel, Integer> numberOfEmployees;

}


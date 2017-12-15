package com.sms.salon.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CustomerModel.class)
public abstract class CustomerModel_ {

	public static volatile SingularAttribute<CustomerModel, Long> id;
	public static volatile SingularAttribute<CustomerModel, String> customerPhoneNumber;
	public static volatile SingularAttribute<CustomerModel, String> customerName;
	public static volatile SingularAttribute<CustomerModel, SalonModel> salon;

}


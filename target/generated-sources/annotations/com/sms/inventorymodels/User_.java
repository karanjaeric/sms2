package com.sms.inventorymodels;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, String> passWord;
	public static volatile SingularAttribute<User, Long> id;
	public static volatile SingularAttribute<User, String> userName;
	public static volatile SingularAttribute<User, UserProfile> userProfile;

}


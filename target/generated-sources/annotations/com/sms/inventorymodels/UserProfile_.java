package com.sms.inventorymodels;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserProfile.class)
public abstract class UserProfile_ {

	public static volatile SingularAttribute<UserProfile, String> profileName;
	public static volatile SingularAttribute<UserProfile, YesNo> inventoryAccess;
	public static volatile SingularAttribute<UserProfile, YesNo> adminAccess;
	public static volatile SingularAttribute<UserProfile, YesNo> gamesAndSportsAccess;
	public static volatile SingularAttribute<UserProfile, String> profileCode;
	public static volatile SingularAttribute<UserProfile, Long> id;
	public static volatile SingularAttribute<UserProfile, YesNo> feesManagementAccess;
	public static volatile SingularAttribute<UserProfile, YesNo> studentManagementAccess;

}


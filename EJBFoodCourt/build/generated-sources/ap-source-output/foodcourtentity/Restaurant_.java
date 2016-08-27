package foodcourtentity;

import foodcourtentity.Restaurant;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-26T06:16:03")
@StaticMetamodel(Restaurant.class)
public class Restaurant_ { 

    public static volatile SingularAttribute<Restaurant, Long> restId;
    public static volatile SingularAttribute<Restaurant, String> address;
    public static volatile ListAttribute<Restaurant, Restaurant> r;
    public static volatile SingularAttribute<Restaurant, String> restName;
    public static volatile SingularAttribute<Restaurant, BigInteger> locationId;
    public static volatile SingularAttribute<Restaurant, BigInteger> contactNo;
    public static volatile SingularAttribute<Restaurant, BigInteger> rating;

}
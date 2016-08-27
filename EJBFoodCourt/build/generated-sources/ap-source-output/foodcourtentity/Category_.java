package foodcourtentity;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-26T06:16:03")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile SingularAttribute<Category, Long> categoryId;
    public static volatile SingularAttribute<Category, String> foodType;
    public static volatile SingularAttribute<Category, BigInteger> menuId;

}
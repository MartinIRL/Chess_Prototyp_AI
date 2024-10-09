package Kern_Logik_Klassen;

import java.util.function.Predicate;

public interface PredicateBewegung<T,I1,I2> {



    boolean isMoveLegal(T t,I1 i, I2 j);


}

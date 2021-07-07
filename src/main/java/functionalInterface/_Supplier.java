package functionalInterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println(getDBConnectionUrl());
        System.out.println(getDBConnectionUrl.get());
    }

    // Regular way
    static String getDBConnectionUrl(){
        return "jdbc://localhost:8000";
    }

    // Supplier way
    static Supplier<List<String>> getDBConnectionUrl = ()
            -> List.of("jdbc://localhost:8080","jdbc://localhost:8081","jdbc://localhost:8082") ;
}

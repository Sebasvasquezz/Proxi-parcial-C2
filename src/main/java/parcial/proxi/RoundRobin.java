package parcial.proxi;

public class RoundRobin {
    public static String round(boolean service) {
        if (service) {
            return getUrl("SERVICE_1");
        } else {
            return getUrl("SERVICE_2");
        }   
    }

    private static String getUrl(String variable) {
        if (System.getenv(variable) != null) {
            return System.getenv(variable);
        }
        return "localhost:8080";
    }
}

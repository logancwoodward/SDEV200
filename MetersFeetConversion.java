public class MetersFeetConversion {

    public static double footToMeter(double foot) {
        return 0.305 * foot;
    }
    
    public static double meterToFoot(double meter) {
        return 3.279 * meter;
    }

    public static void main(String[] args) {
        System.out.println("Foot to meter");
        for (int foot = 1; foot <= 10; foot++) {
            double meter = footToMeter(foot);
            System.out.printf("", foot, meter);
        }
        System.out.println("Meter to foot"); {
        for (int meter = 20; meter <= 65; meter += 5) {
            double foot = meterToFoot(meter);
            System.out.printf("", meter, foot);
        }
        }
    
    }
} 
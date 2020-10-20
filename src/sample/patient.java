package sample;
import java.util.UUID;

public class patient {
    public String name;
    @Override
    public String toString()
    {
        return name;
    }

    public String gender;
    public int AGE;
    public String BloodType;
    public int weight;
    public double height;
    private UUID ID;
    public patient()
    {
        int min1 = 100;
        int max1 = 250;
        double min2 = 5;
        double max2 = 6;
        int min3 = 1;
        int max3 = 95;
        weight =  (int)(Math.random() * (max1 - min1 + 1) + min1);
        double a = Math.random() * (max2 - min2 + 1) + min2;
        height = Math.round(a * 10) / 10.0;
        AGE = (int)(Math.random() * (max3 - min3 + 1) + min3);
        ID = UUID.randomUUID();
    }
}


package org.abgehoben.rest;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class cards {
    public static HashMap<String, Float> car1 = new HashMap<String, Float>();
    public static HashMap<String, Float> car2 = new HashMap<String, Float>();
    public static HashMap<String, Float> car3 = new HashMap<String, Float>();
    public static HashMap<String, Float> car4 = new HashMap<String, Float>();
    public static HashMap<String, Float> car5 = new HashMap<String, Float>();
    public static HashMap<String, Float> car6 = new HashMap<String, Float>();
    public static HashMap<String, Float> car7 = new HashMap<String, Float>();
    public static HashMap<String, Float> car8 = new HashMap<String, Float>();
    public static HashMap<String, Float> car9 = new HashMap<String, Float>();
    public static HashMap<String, Float> car10 = new HashMap<String, Float>();
    public static HashMap<String, Float> car11 = new HashMap<String, Float>();
    public static HashMap<String, Float> car12 = new HashMap<String, Float>();
    public static HashMap<String, Float> car13 = new HashMap<String, Float>();
    public static HashMap<String, Float> car14 = new HashMap<String, Float>();
    public static HashMap<String, Float> car15 = new HashMap<String, Float>();
    public static HashMap<String, Float> car16 = new HashMap<String, Float>();
    public static HashMap<String, Float> car17 = new HashMap<String, Float>();
    public static HashMap<String, Float> car18 = new HashMap<String, Float>();

    public cards() {

        // 1 = Lamborghini Aventador Ultimate
        car1.put("Name", 1f);
        car1.put("Top-Speed", 355f);
        car1.put("0-100", 2.8f);
        car1.put("PS", 780f);
        car1.put("Consumption", 15.0f);

        // 2 = Ferrari 812 Competizione
        car2.put("Name", 2f);
        car2.put("Top-Speed", 340f);
        car2.put("0-100", 2.85f);
        car2.put("PS", 830f);
        car2.put("Consumption", 14.5f);

        // 3 = McLaren 765LT
        car3.put("Name", 3f);
        car3.put("Top-Speed", 330f);
        car3.put("0-100", 2.8f);
        car3.put("PS", 765f);
        car3.put("Consumption", 12.5f);

        // 4 = Porsche 911 GT3 RS (992)
        car4.put("Name", 4f);
        car4.put("Top-Speed", 296f);
        car4.put("0-100", 3.2f);
        car4.put("PS", 525f);
        car4.put("Consumption", 13.0f);

        // 5 = Mercedes-AMG GT Black Series
        car5.put("Name", 5f);
        car5.put("Top-Speed", 325f);
        car5.put("0-100", 3.2f);
        car5.put("PS", 730f);
        car5.put("Consumption", 14.0f);

        // 6 = Aston Martin Vantage AMR
        car6.put("Name", 6f);
        car6.put("Top-Speed", 314f);
        car6.put("0-100", 3.6f);
        car6.put("PS", 510f);
        car6.put("Consumption", 12.0f);

        // 7 = Lamborghini Huracán STO
        car7.put("Name", 7f);
        car7.put("Top-Speed", 310f);
        car7.put("0-100", 3.0f);
        car7.put("PS", 640f);
        car7.put("Consumption", 15.5f);

        // 8 = Porsche 911 Turbo S (992)
        car8.put("Name", 8f);
        car8.put("Top-Speed", 330f);
        car8.put("0-100", 2.7f);
        car8.put("PS", 650f);
        car8.put("Consumption", 12.7f);

        // 9 = McLaren 720S
        car9.put("Name", 9f);
        car9.put("Top-Speed", 341f);
        car9.put("0-100", 2.9f);
        car9.put("PS", 720f);
        car9.put("Consumption", 13.5f);

        // 10 = Audi R8 V10 Performance RWD
        car10.put("Name", 10f);
        car10.put("Top-Speed", 329f);
        car10.put("0-100", 3.4f);
        car10.put("PS", 570f);
        car10.put("Consumption", 14.3f);

        // 11 = Ferrari F8 Tributo
        car11.put("Name", 11f);
        car11.put("Top-Speed", 340f);
        car11.put("0-100", 2.9f);
        car11.put("PS", 720f);
        car11.put("Consumption", 13.2f);

        // 12 = Noble M600
        car12.put("Name", 12f);
        car12.put("Top-Speed", 362f);
        car12.put("0-100", 3.0f);
        car12.put("PS", 650f);
        car12.put("Consumption", 15.0f);

        // 13 = Koenigsegg Agera RS
        car13.put("Name", 13f);
        car13.put("Top-Speed", 457f);
        car13.put("0-100", 2.5f);
        car13.put("PS", 1160f);
        car13.put("Consumption", 18.0f);

        // 14 = Hennessey Venom F5
        car14.put("Name", 14f);
        car14.put("Top-Speed", 500f);
        car14.put("0-100", 2.6f);
        car14.put("PS", 1817f);
        car14.put("Consumption", 20.0f);

        // 15 = SSC Tuatara
        car15.put("Name", 15f);
        car15.put("Top-Speed", 455f);
        car15.put("0-100", 2.5f);
        car15.put("PS", 1750f);
        car15.put("Consumption", 18.5f);

        // 16 = Bugatti Chiron Super Sport 300+
        car16.put("Name", 16f);
        car16.put("Top-Speed", 490f);
        car16.put("0-100", 2.4f);
        car16.put("PS", 1600f);
        car16.put("Consumption", 22.0f);

        // 17 = Hyundai i30 Kurth Edition
        car17.put("Name", 17f);
        car17.put("Top-Speed", 250f);
        car17.put("0-100", 5.5f);
        car17.put("PS", 140f);
        car17.put("Consumption", 7.0f);

        // 18 = Ford Focus Hofi Light Edition
        car18.put("Name", 18f);
        car18.put("Top-Speed", 171f);
        car18.put("0-100", 15.1f);
        car18.put("PS", 75f);
        car18.put("Consumption", 7.5f);
    }


    public static String getCarAttribute(int carNumber, String attribute) {
        String Requested = "";
        try {
            if (attribute.equals("Name")) {
                switch (carNumber) {
                    case 1:
                        Requested = "Lamborghini Aventador Ultimate";
                        break;
                    case 2:
                        Requested = "Ferrari 812 Competizione";
                        break;
                    case 3:
                        Requested = "McLaren 765LT";
                        break;
                    case 4:
                        Requested = "Porsche 911 GT3 RS (992)";
                        break;
                    case 5:
                        Requested = "Mercedes-AMG GT Black Series";
                        break;
                    case 6:
                        Requested = "Aston Martin Vantage AMR";
                        break;
                    case 7:
                        Requested = "Lamborghini Huracán STO";
                        break;
                    case 8:
                        Requested = "Porsche 911 Turbo S (992)";
                        break;
                    case 9:
                        Requested = "McLaren 720S";
                        break;
                    case 10:
                        Requested = "Audi R8 V10 Performance RWD";
                        break;
                    case 11:
                        Requested = "Ferrari F8 Tributo";
                        break;
                    case 12:
                        Requested = "Noble M600";
                        break;
                    case 13:
                        Requested = "Koenigsegg Agera RS";
                        break;
                    case 14:
                        Requested = "Hennessey Venom F5";
                        break;
                    case 15:
                        Requested = "SSC Tuatara";
                        break;
                    case 16:
                        Requested = "Bugatti Chiron Super Sport 300+";
                        break;
                    case 17:
                        Requested = "Hyundai i30 Kurth Edition";
                        break;
                    case 18:
                        Requested = "Ford Focus Hofi Light Edition";
                        break;
                }
            } else {
                // Build the field name dynamically, e.g., "car1", "car2", etc.
                String fieldName = "car" + carNumber;
                                                                                //transform to single hashmap
                Field field = cards.class.getDeclaredField(fieldName);

                HashMap<String, Float> car = (HashMap<String, Float>) field.get(cards.class);

                Requested = car.get(attribute).toString();
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("There was an Error" + e);
            return "There was an Error" + e;
        }
        System.out.println("Requested: (" + carNumber + ", " + attribute + ") = " + Requested);
        return Requested;
    }
}

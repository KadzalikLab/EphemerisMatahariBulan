package com.falak;

import java.util.Locale;

public class Main {
    static double interval_perjam=1/24.0,interval_permenit=(1/60.0)/24.0,interval_perdetik=(1/3600.0)/24.0, interval_perMilidetik =(interval_perdetik/1000);
   static String format2 = "%-20s%20s%20s%20s%20s%20s%20s%20s%20s%n";
    public static void main(String[] args) {

        double tgl,bln,thn,jam,mnt,dtk,jamDes;
        tgl=1;
        bln=1;
        thn=2013;
        jam=0;
        mnt=0;
        dtk=0;
        jamDes=Konversi.dmsKeDesimal(jam,mnt,dtk);
        double jd = Konversi.kmJd(tgl,bln,thn,jamDes);

        //semisal ingin mendapatkan nila apparent declination sun // deklinasi matahari
        double dek_mat  = Sun.Vsop87.apparentDeclination(jd);

        //print dalam format Dms
       // printDms("Deklinasi =",dek_mat);


        double delta_T=DynamicalTime.delta_t(tgl,bln,thn); // mau pakai delta T atau tidak?
        // jd +=(delta_T/86400); //JD waktu TD(Dynamical time)

        System.out.printf(format2
                , "Pukul"
                , "Longitude"
                , "Latitude"
                , "Appr Right Asc"
                , "Appr Declination"
                , "Geo distance"
                , "Semi diameter"
                , "Obliquity"
                , "EoT"
        );
        meuusMethod(jd);
        vsop87Metode(jd);

        System.out.println(System.lineSeparator());
        System.out.printf(format2
                , "Pukul"
                , "Longitude"
                , "Latitude"
                , "Appr Right Asc"
                , "Appr Declination"
                , "Parallax"
                , "Semi diameter"
                , "Angle Bright"
                , "Fib"
        );
        meuusMoonMethod(jd);
        elp2000Method(jd);
        elpMpp02TruncMethod(jd);
        elpMpp02Method(jd);

//        for (int i = 0; i<=24;i++){
//            vsop87Metode(jd);
//            jd+=interval_perMilidetik;
//        }




    }

    static void meuusMethod(double jd){
        double longitude_sun_true = Sun.Meeus.trueGeocentricLongitude(jd);
        double latitude_sun = Sun.Meeus.geocentricLatitude(jd);
        double rightAscension_sun = Sun.Meeus.apparentRightAscension(jd);
        double declination_sun = Sun.Meeus.apparentDeclination(jd);
        double geo_distance_sun = Sun.Meeus.trueGeocentricDistance(jd);
        double semiDiameter_sun = Sun.Meeus.angularSemiDiameter(jd);
        double obliquity_earth = Sun.Meeus.trueObliquity(jd);
        double eot = Sun.Meeus.equationOfTime(jd);

//        printDms("Ecliptic Longitude",longitude_sun_true);
//        printDigit("Ecliptic Latitude",latitude_sun,3);
//        printDms("Appr Right Ascension",rightAscension_sun);
//        printDms("Apparent Declination",declination_sun);
//        printDigit("True Geo Distance ",geo_distance_sun,5);
//        printDms("Semi Diameter",semiDiameter_sun);
//        printDms("Obliquity",obliquity_earth);
//        printHms("Equation of time",eot);

        printRowColSun(jd
                ,longitude_sun_true
                ,latitude_sun/3600
                ,rightAscension_sun
                ,declination_sun
                ,geo_distance_sun
                ,semiDiameter_sun
                ,obliquity_earth
                ,eot
        );
    }
    static void meuusMoonMethod(double jd){
        double longitude_moon_appr = Moon.Meeus.apparentGeocentricLongitude(jd);
        double latitude_moon_appr = Moon.Meeus.apparentGeocentricLatitude(jd);
        double rightAscension_moon= Moon.Meeus.apparentRightAscension(jd);
        double declination_moon = Moon.Meeus.apparentDeclination(jd);
        double horizontalParallax_moon = Moon.Meeus.equatorialHorizontalParallax(jd);
        double semiDiameter_moon = Moon.Meeus.angularSemiDiameter(jd);
        double angleBrightLimb_moon = Moon.Meeus.brightLimbAngle(jd);
        double fractionillumination_moon = Moon.Meeus.diskIlluminatedFraction(jd);

        printRowColMoon(jd
                ,longitude_moon_appr
                ,latitude_moon_appr
                ,rightAscension_moon
                ,declination_moon
                ,horizontalParallax_moon
                ,semiDiameter_moon
                ,angleBrightLimb_moon
                ,fractionillumination_moon
        );

//        printDms("Ecliptic Longitude",longitude_moon_appr);
//        printDms("Ecliptic Latitude",latitude_moon_appr);
//        printDms("Appr Right Ascension",rightAscension_moon);
//        printDms("Apparent Declination",declination_moon);
//        printDms("Horizontal Parallax",horizontalParallax_moon);
//        printDms("Semi Diameter",semiDiameter_moon);
//        printDms("Angle Bright Limb",angleBrightLimb_moon);
//        printDigit("Fraction Illumination",fractionillumination_moon,5);
    }

    static void vsop87Metode(double jd){

        double longitude_sun_true = Sun.Vsop87.apparentGeocentricLongitude(jd);
        double latitude_sun = Sun.Vsop87.geocentricLatitude(jd);
        double rightAscension_sun = Sun.Vsop87.apparentRightAscension(jd);
        double declination_sun = Sun.Vsop87.apparentDeclination(jd);
        double geo_distance_sun = Sun.Vsop87.trueGeocentricDistance(jd);
        double semiDiameter_sun = Sun.Vsop87.angularSemiDiameter(jd);
        double obliquity_earth = Sun.Vsop87.trueObliquity(jd);
        double eot = Sun.Vsop87.equationOfTime(jd);

//        printDms("Ecliptic Longitude",longitude_sun_true);
//        printDms("Ecliptic ",latitude_sun);
//        printDigit("Ecliptic Latitude",latitude_sun,7);
//        printDms("Appr Right Ascension",rightAscension_sun);
//        printDms("Apparent Declination",declination_sun);
//        printDigit("True Geo Distance ",geo_distance_sun,5);
//        printDms("Semi Diameter",semiDiameter_sun);
//        printDms("Obliquity",obliquity_earth);
//        printHms("Equation of time",eot);


        printRowColSun(jd
                ,longitude_sun_true
                ,latitude_sun
                ,rightAscension_sun
                ,declination_sun
                ,geo_distance_sun
                ,semiDiameter_sun
                ,obliquity_earth
                ,eot
                );


    }

    static void elpMpp02Method(double jd){
        double longitude_moon_appr = Moon.Elpmpp02.apparentGeocentricLongitude(jd);
        double latitude_moon_appr = Moon.Elpmpp02.apparentGeocentricLatitude(jd);
        double rightAscension_moon= Moon.Elpmpp02.apparentRightAscension(jd);
        double declination_moon = Moon.Elpmpp02.apparentDeclination(jd);
        double horizontalParallax_moon = Moon.Elpmpp02.equatorialHorizontalParallax(jd);
        double semiDiameter_moon = Moon.Elpmpp02.angularSemiDiameter(jd);
        double angleBrightLimb_moon = Moon.Elpmpp02.brightLimbAngle(jd);
        double fractionillumination_moon = Moon.Elpmpp02.diskIlluminatedFraction(jd);

        printRowColMoon(jd
                ,longitude_moon_appr
                ,latitude_moon_appr
                ,rightAscension_moon
                ,declination_moon
                ,horizontalParallax_moon
                ,semiDiameter_moon
                ,angleBrightLimb_moon
                ,fractionillumination_moon
        );

//        printDms("Ecliptic Longitude",longitude_moon_appr);
//        printDms("Ecliptic Latitude",latitude_moon_appr);
//        printDms("Appr Right Ascension",rightAscension_moon);
//        printDms("Apparent Declination",declination_moon);
//        printDms("Horizontal Parallax",horizontalParallax_moon);
//        printDms("Semi Diameter",semiDiameter_moon);
//        printDms("Angle Bright Limb",angleBrightLimb_moon);
//        printDigit("Fraction Illumination",fractionillumination_moon,5);



    }
    static void elpMpp02TruncMethod(double jd){
        double longitude_moon_appr = Moon.Elpmpp02Trunc.apparentGeocentricLongitude(jd);
        double latitude_moon_appr = Moon.Elpmpp02Trunc.apparentGeocentricLatitude(jd);
        double rightAscension_moon= Moon.Elpmpp02Trunc.apparentRightAscension(jd);
        double declination_moon = Moon.Elpmpp02Trunc.apparentDeclination(jd);
        double horizontalParallax_moon = Moon.Elpmpp02Trunc.equatorialHorizontalParallax(jd);
        double semiDiameter_moon = Moon.Elpmpp02Trunc.angularSemiDiameter(jd);
        double angleBrightLimb_moon = Moon.Elpmpp02Trunc.brightLimbAngle(jd);
        double fractionillumination_moon = Moon.Elpmpp02Trunc.diskIlluminatedFraction(jd);
        printRowColMoon(jd
                ,longitude_moon_appr
                ,latitude_moon_appr
                ,rightAscension_moon
                ,declination_moon
                ,horizontalParallax_moon
                ,semiDiameter_moon
                ,angleBrightLimb_moon
                ,fractionillumination_moon
        );

//        printDms("Ecliptic Longitude",longitude_moon_appr);
//        printDms("Ecliptic Latitude",latitude_moon_appr);
//        printDms("Appr Right Ascension",rightAscension_moon);
//        printDms("Apparent Declination",declination_moon);
//        printDms("Horizontal Parallax",horizontalParallax_moon);
//        printDms("Semi Diameter",semiDiameter_moon);
//        printDms("Angle Bright Limb",angleBrightLimb_moon);
//        printDigit("Fraction Illumination",fractionillumination_moon,5);
    }

    static void elp2000Method(double jd){
        double longitude_moon_appr = Moon.Elp2000.apparentGeocentricLongitude(jd);
        double latitude_moon_appr = Moon.Elp2000.apparentGeocentricLatitude(jd);
        double rightAscension_moon= Moon.Elp2000.apparentRightAscension(jd);
        double declination_moon = Moon.Elp2000.apparentDeclination(jd);
        double horizontalParallax_moon = Moon.Elp2000.equatorialHorizontalParallax(jd);
        double semiDiameter_moon = Moon.Elp2000.angularSemiDiameter(jd);
        double angleBrightLimb_moon = Moon.Elp2000.brightLimbAngle(jd);
        double fractionillumination_moon = Moon.Elp2000.diskIlluminatedFraction(jd);

        printRowColMoon(jd
                ,longitude_moon_appr
                ,latitude_moon_appr
                ,rightAscension_moon
                ,declination_moon
                ,horizontalParallax_moon
                ,semiDiameter_moon
                ,angleBrightLimb_moon
                ,fractionillumination_moon
        );

//        printDms("Ecliptic Longitude",longitude_moon_appr);
//        printDms("Ecliptic Latitude",latitude_moon_appr);
//        printDms("Appr Right Ascension",rightAscension_moon);
//        printDms("Apparent Declination",declination_moon);
//        printDms("Horizontal Parallax",horizontalParallax_moon);
//        printDms("Semi Diameter",semiDiameter_moon);
//        printDms("Angle Bright Limb",angleBrightLimb_moon);
//        printDigit("Fraction Illumination",fractionillumination_moon,5);
    }




    static void printDms(String teks, double dms_value){
        String format = "%-25s%5s%n";
        System.out.printf(format,teks,":"+Konversi.dmsMili(dms_value));

    }

    static  String printDms(double val){
        return  Konversi.dmsMili(val);
    }

    static void printHms(String teks, double hms_value){
        String format = "%-25s%5s%n";
        System.out.printf(format,teks,":"+Konversi.hms(hms_value));

    }

    static void printDigit(String teks, double value,int digit){
        String format = "%-25s%5s%n";
        System.out.printf(format,teks,":"+String.format(Locale.JAPAN,"%."+digit+"f",value));

    }
    static String printDigit(double value,int digit){
        return  String.format(Locale.JAPAN,"%."+digit+"f",value);

    }

    public  static String jd_km(double jd){
        int tanggal=Konversi.jdKm(jd)[1]; // 1 berarti mengambil array urutan nomor 1, yaitu yang berisikan nilai tanggal
        int bulan=Konversi.jdKm(jd)[2];
        int tahun=Konversi.jdKm(jd)[3];
        double jam_des = Konversi.jdPukul(jd);
        int nomor_hari = Konversi.jdKm(jd)[7]; // 7 berarti mengambil array urutan nomor 7, yaitu yang berisikan nilai nomor hari
        int nomor_pasaran= Konversi.jdKm(jd)[8];
        return Konversi.namahari(nomor_hari)+" "+Konversi.namapasaran(nomor_pasaran)+", "+tanggal+" "+Konversi.namaBulanMasehi(bulan)+" "+tahun+" | "+Konversi.hmsMili(jam_des);
    }

    public  static String jdKmPukul(double jd){
        double jam_des = Konversi.jdPukul(jd);
        if (jam_des<0)      return "-"+(int) Konversi.desimalKeDmsMili(jam_des)[1]+":"+(int) Konversi.desimalKeDmsMili(jam_des)[2]+":"+String.format("%.3f", Konversi.desimalKeDmsMili(jam_des)[3]);
        else return (int) Konversi.desimalKeDmsMili(jam_des)[1]+":"+(int) Konversi.desimalKeDmsMili(jam_des)[2]+":"+String.format("%.3f", Konversi.desimalKeDmsMili(jam_des)[3]);
    }

    //print dengan Style spt Winhisab
    static void printRowColSun(double jd,double a1,double a2,double a3,double a4,double a5,double a6,double a7,double a8){
        System.out.printf(format2
                , jdKmPukul(jd) // Pukul
                , printDms(a1) // Longitude
                , printDms(a2) // latitude
                , printDms(a3) // Right Asc
                , printDms(a4) // Decl
                , printDigit(a5,7) //Distance
                , printDms(a6) // Diameter
                , printDms(a7) //obliquity
                , printDms(a8) //EoT
        );
    }
    //print dengan Style spt Winhisab
    static void printRowColMoon(double jd,double a1,double a2,double a3,double a4,double a5,double a6,double a7,double a8){
        System.out.printf(format2
                , jdKmPukul(jd) // Pukul
                , printDms(a1) // Longitude
                , printDms(a2) // latitude
                , printDms(a3) // Right Asc
                , printDms(a4) // Decl
                , printDms(a8)  //paralax
                , printDms(a6) // Diameter
                , printDms(a7) //angleBright
                ,  printDigit(a5,7) //Illumination
        );
    }


}

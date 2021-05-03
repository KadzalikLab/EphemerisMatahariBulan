package com.falak;

import java.util.Locale;

public class Main {


    public static void main(String[] args) {

        double tgl,bln,thn;
        tgl=21;
        bln=6;
        thn=2020;
        double jd = Konversi.km_jd(tgl,bln,thn,0);

        //semisal ingin mendapatkan nila apparent declination sun // deklinasi matahari
        double dek_mat  = Sun.Vsop87.apparentDeclination(jd);

        //print dalam format Dms
        printDms("Deklinasi =",dek_mat);


        double delta_T=DynamicalTime.delta_t(tgl,bln,thn); // mau pakai delta T atau tidak?
        double jd_deltaT= jd +(delta_T/86400); //JD waktu TD(Dynamical time)
//        jd=jd_deltaT;


       // Moon.Elpmpp02.ngisiValue(jd);
        //vsop87Metode(jd);
        meeusMethod(jd);
        System.out.println("Elongasi Bul - Mat = "+ Moon.Meeus.sunGeocentricElongation(jd));
       // elpMethod(jd);
       // elpTruncMethod(jd);


    }

    static void meeusMethod(double jd){
        System.out.println(System.lineSeparator());
        System.out.println("Meeus");
        double longitude_sun_true = Sun.Meeus.trueGeocentricLongitude(jd);
        double latitude_sun = Sun.Meeus.geocentricLatitude(jd);
        double rightAscension_sun = Sun.Meeus.apparentRightAscension(jd);
        double declination_sun = Sun.Meeus.apparentDeclination(jd);
        double geo_distance_sun = Sun.Meeus.trueGeocentricDistance(jd);
        double semiDiameter_sun = Sun.Meeus.angularSemiDiameter(jd);
        double obliquity_earth = Sun.Meeus.trueObliquity(jd);
        double eot = Sun.Meeus.equationOfTime(jd);

        printDms("Ecliptic Longitude",longitude_sun_true);
        printDigit("Ecliptic Latitude",latitude_sun,3);
        printDms("Appr Right Ascension",rightAscension_sun);
        printDms("Apparent Declination",declination_sun);
        printDigit("True Geo Distance ",geo_distance_sun,5);
        printDms("Semi Diameter",semiDiameter_sun);
        printDms("Obliquity",obliquity_earth);
        printHms("Equation of time",eot);

        System.out.println(System.lineSeparator());
        double longitude_moon_appr = Moon.Meeus.apparentGeocentricLongitude(jd);
        double latitude_moon_appr = Moon.Meeus.apparentGeocentricLatitude(jd);
        double rightAscension_moon= Moon.Meeus.apparentRightAscension(jd);
        double declination_moon = Moon.Meeus.apparentDeclination(jd);
        double horizontalParallax_moon = Moon.Meeus.equatorialHorizontalParallax(jd);
        double semiDiameter_moon = Moon.Meeus.angularSemiDiameter(jd);
        double angleBrightLimb_moon = Moon.Meeus.brightLimbAngle(jd);
        double fractionillumination_moon = Moon.Meeus.diskIlluminatedFraction(jd);

        printDms("Ecliptic Longitude",longitude_moon_appr);
        printDms("Ecliptic Latitude",latitude_moon_appr);
        printDms("Appr Right Ascension",rightAscension_moon);
        printDms("Apparent Declination",declination_moon);
        printDms("Horizontal Parallax",horizontalParallax_moon);
        printDms("Semi Diameter",semiDiameter_moon);
        printDms("Angle Bright Limb",angleBrightLimb_moon);
        printDigit("Fraction Illumination",fractionillumination_moon,5);




    }

    static void vsop87Metode(double jd){
        System.out.println(System.lineSeparator());
        System.out.println("Vsop Sun");
        double longitude_sun_true = Sun.Vsop87.trueGeocentricLongitude(jd);
        double latitude_sun = Sun.Vsop87.geocentricLatitude(jd);
        double rightAscension_sun = Sun.Vsop87.apparentRightAscension(jd);
        double declination_sun = Sun.Vsop87.apparentDeclination(jd);
        double geo_distance_sun = Sun.Vsop87.trueGeocentricDistance(jd);
        double semiDiameter_sun = Sun.Vsop87.angularSemiDiameter(jd);
        double obliquity_earth = Sun.Vsop87.trueObliquity(jd);
        double eot = Sun.Vsop87.equationOfTime(jd);

        printDms("Ecliptic Longitude",longitude_sun_true);
        printDms("Ecliptic ",latitude_sun);
        printDigit("Ecliptic Latitude",latitude_sun,7);
        printDms("Appr Right Ascension",rightAscension_sun);
        printDms("Apparent Declination",declination_sun);
        printDigit("True Geo Distance ",geo_distance_sun,5);
        printDms("Semi Diameter",semiDiameter_sun);
        printDms("Obliquity",obliquity_earth);
        printHms("Equation of time",eot);





    }

    static void elpMethod(double jd){
        System.out.println(System.lineSeparator());
        System.out.println("Elpmpp02 Moon");
        double longitude_moon_appr = Moon.Elpmpp02.apparentGeocentricLongitude(jd);
        double latitude_moon_appr = Moon.Elpmpp02.apparentGeocentricLatitude(jd);
        double rightAscension_moon= Moon.Elpmpp02.apparentRightAscension(jd);
        double declination_moon = Moon.Elpmpp02.apparentDeclination(jd);
        double horizontalParallax_moon = Moon.Elpmpp02.equatorialHorizontalParallax(jd);
        double semiDiameter_moon = Moon.Elpmpp02.angularSemiDiameter(jd);
        double angleBrightLimb_moon = Moon.Elpmpp02.brightLimbAngle(jd);
        double fractionillumination_moon = Moon.Elpmpp02.diskIlluminatedFraction(jd);

        printDms("Ecliptic Longitude",longitude_moon_appr);
        printDms("Ecliptic Latitude",latitude_moon_appr);
        printDms("Appr Right Ascension",rightAscension_moon);
        printDms("Apparent Declination",declination_moon);
        printDms("Horizontal Parallax",horizontalParallax_moon);
        printDms("Semi Diameter",semiDiameter_moon);
        printDms("Angle Bright Limb",angleBrightLimb_moon);
        printDigit("Fraction Illumination",fractionillumination_moon,5);




    }
    static void elpTruncMethod(double jd){
        System.out.println(System.lineSeparator());
        System.out.println("Elpmpp02Trunc Moon");
        double longitude_moon_appr = Moon.Elpmpp02Trunc.apparentGeocentricLongitude(jd);
        double latitude_moon_appr = Moon.Elpmpp02Trunc.apparentGeocentricLatitude(jd);
        double rightAscension_moon= Moon.Elpmpp02Trunc.apparentRightAscension(jd);
        double declination_moon = Moon.Elpmpp02Trunc.apparentDeclination(jd);
        double horizontalParallax_moon = Moon.Elpmpp02Trunc.equatorialHorizontalParallax(jd);
        double semiDiameter_moon = Moon.Elpmpp02Trunc.angularSemiDiameter(jd);
        double angleBrightLimb_moon = Moon.Elpmpp02Trunc.brightLimbAngle(jd);
        double fractionillumination_moon = Moon.Elpmpp02Trunc.diskIlluminatedFraction(jd);

        printDms("Ecliptic Longitude",longitude_moon_appr);
        printDms("Ecliptic Latitude",latitude_moon_appr);
        printDms("Appr Right Ascension",rightAscension_moon);
        printDms("Apparent Declination",declination_moon);
        printDms("Horizontal Parallax",horizontalParallax_moon);
        printDms("Semi Diameter",semiDiameter_moon);
        printDms("Angle Bright Limb",angleBrightLimb_moon);
        printDigit("Fraction Illumination",fractionillumination_moon,5);


    }




    static void printDms(String teks, double dms_value){
        String format = "%-25s%5s%n";
        System.out.printf(format,teks,":"+Konversi.dmsMili(dms_value));

    }

    static void printHms(String teks, double hms_value){
        String format = "%-25s%5s%n";
        System.out.printf(format,teks,":"+Konversi.hms(hms_value));

    }

    static void printDigit(String teks, double value,int digit){
        String format = "%-25s%5s%n";
        System.out.printf(format,teks,":"+String.format(Locale.JAPAN,"%."+digit+"f",value));

    }





}

package com.falak;

public class Test {
    public static void main(String[] args) {
        // ambil tanggal dari android
        // tgl diubah ke jd
        // jd -> data ehem

        double tgl,bln,thn,jam;
        tgl=3; bln= 5;thn=2021;jam=5;

        double jd = Konversi.km_jd(3,bln,thn,5);
        System.out.println(jd);
        double sdo_5gmt = Sun.Meeus.angularSemiDiameter(jd);
        System.out.println(sdo_5gmt);

        double ecliptic_long_sun = Sun.Vsop87.trueGeocentricLongitude(jd);
        double ecliptic_long_sun_appr = Sun.Vsop87.apparentGeocentricLongitude(jd);

    }
}

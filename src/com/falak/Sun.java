package com.falak;

public class Sun {

    /**
     * Mendapatkan data-data matahari menggunakan metode buku Astonomy Algorithm - Jean Meeus
     * dimana perhitunganya ada di class: {@link Calculation#meeus(double jd)}}
     * @author Kadzalik Lab
     * @version 1.0
     * @see <a href="http://www.agopax.it/Libri_astronomia/pdf/Astronomical%20Algorithms.pdf">http://www.agopax.it/Libri_astronomia/pdf/Astronomical%20Algorithms.pdf</a>
     * @since 2021-03-31
     */
    static class Meeus {


        //nilai sebenarnya Bujur Matahari Koordinat Ekliptika Geosentrik
        static double trueGeocentricLongitude(double jd) {
            return Calculation.meeus(jd)[1];
        }
        //nilai nampak Bujur Matahari Koordinat Ekliptika Geosentrik
        static double apparentGeocentricLongitude(double jd) {
            return Calculation.meeus(jd)[2];
        }

        //nilai sebenarnya Lintang Matahari Koordinat Ekliptika Geosentrik
        static double geocentricLatitude(double jd) {
            return Calculation.meeus(jd)[3];
        }

        //nilai nampak Asensio rekta / Panjatan tegak / Bujur Matahari Koordinat Ekuator Geosentrik
        static double apparentRightAscension(double jd) {
            return Calculation.meeus(jd)[4];
        }

        //nilai nampak Deklinasi / lintang Matahari Koordinat Ekuator Geosentrik
        static double apparentDeclination(double jd) {
            return Calculation.meeus(jd)[5];
        }

        //Jarak Bumi - Matahari Vector
        static double trueGeocentricDistance(double jd) {
            return Calculation.meeus(jd)[6];
        }

        //Semi diameter / piringan Matahari
        static double angularSemiDiameter(double jd) {
            return Calculation.meeus(jd)[7];
        }
        //Perata waktu
        static double equationOfTime(double jd) {

            double tau, alpha, deltaPsi, epsilon, L0, e;
            tau = Calculation.meeus(jd)[8];
            alpha = apparentRightAscension(jd);
            deltaPsi = Calculation.meeus(jd)[9];
            epsilon = Calculation.meeus(jd)[10];
            L0 = 280.4664567 + 360007.6982779 * tau + 0.03032028 * Math.pow(tau, 2) + Math.pow(tau, 3) / 49931 - Math.pow(tau, 4) / 15300 - Math.pow(tau, 5) / 2000000;
            L0 %= 360;
            e = L0 - 0.0057183 - alpha + deltaPsi * Math.cos(Math.toRadians(epsilon));

            if (Math.abs(e) * 4 < 20) e = e / 15;
            else if (Math.abs(e) * 4 >= 20 && e > 0) e = e / 15 - 24;
            else if (Math.abs(e) * 4 >= 20 && e < 0) e = e / 15 + 24;
            else e = e / 15;

            return e;
        }

        //Horizontal paralaks
        static double equatorialHorizontalParallax(double jd) {
            double R = trueGeocentricDistance(jd);
            double phi = Math.toDegrees(Math.asin(Math.sin(Math.toRadians(8.794 / 3600d)) / R));

            return phi;
        }

        //Kemiringan sumbu bumi
        static double trueObliquity(double jd) {
            return Calculation.meeus(jd)[10];
        }

    }


    static class Vsop87 {

        static double trueGeocentricLongitude(double jd) {
            return Calculation.vsop87(jd)[1];
        }

        static double apparentGeocentricLongitude(double jd) {
            return Calculation.vsop87(jd)[2];
        }

//
//        static double (double jd){
//            return  Calculation.meeus(jd)[]; }

        static double geocentricLatitude(double jd) {
            return Calculation.vsop87(jd)[3];
        }


        static double apparentRightAscension(double jd) {
            return Calculation.vsop87(jd)[4];
        }


        static double apparentDeclination(double jd) {
            return Calculation.vsop87(jd)[5];
        }


        static double trueGeocentricDistance(double jd) {
            return Calculation.vsop87(jd)[6];
        }


        static double angularSemiDiameter(double jd) {
            return Calculation.vsop87(jd)[7];
        }

        static double equationOfTime(double jd) {

            double tau, alpha, deltaPsi, epsilon, L0, e;
            tau = Calculation.vsop87(jd)[8];
            alpha = apparentRightAscension(jd);
            deltaPsi = Calculation.vsop87(jd)[9];
            epsilon = Calculation.vsop87(jd)[10];
            L0 = 280.4664567 + 360007.6982779 * tau + 0.03032028 * Math.pow(tau, 2) + Math.pow(tau, 3) / 49931 - Math.pow(tau, 4) / 15300 - Math.pow(tau, 5) / 2000000;
            L0 %= 360;
            e = L0 - 0.0057183 - alpha + deltaPsi * Math.cos(Math.toRadians(epsilon));

            if (Math.abs(e) * 4 < 20) e = e / 15;
            else if (Math.abs(e) * 4 >= 20 && e > 0) e = e / 15 - 24;
            else if (Math.abs(e) * 4 >= 20 && e < 0) e = e / 15 + 24;
            else e = e / 15;

            return e;
        }

        static double equatorialHorizontalParallax(double jd) {
            double R = trueGeocentricDistance(jd);
            double phi = Math.toDegrees(Math.asin(Math.sin(Math.toRadians(8.794 / 3600d)) / R));

            return phi;
        }

        static double trueObliquity(double jd) {
            return Calculation.meeus(jd)[10];
        }

    }


}


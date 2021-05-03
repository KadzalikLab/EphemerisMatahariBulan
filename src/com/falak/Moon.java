package com.falak;


public class Moon {


    static class Meeus{
        static double trueGeocentricLongitude(double jd){
            return  Calculation.meeus(jd)[11];
        }

        static double apparentGeocentricLongitude (double jd){
            return  Calculation.meeus(jd)[12]; }

        static double apparentGeocentricLatitude(double jd){
            return  Calculation.meeus(jd)[13];
        }



        static double apparentRightAscension (double jd){
            return  Calculation.meeus(jd)[14];
        }


        static double apparentDeclination(double jd){
            return  Calculation.meeus(jd)[15];
        }


        static double trueGeocentricDistance(double jd){
            return  Calculation.meeus(jd)[16];
        }


        static double angularSemiDiameter (double jd){
            return  Calculation.meeus(jd)[17];
        }


        static double equatorialHorizontalParallax (double jd){
            return  Calculation.meeus(jd)[18];
        }

        static double diskIlluminatedFraction (double jd){
            return  Calculation.meeus(jd)[19];
        }


        static double brightLimbAngle(double jd){
            return  Calculation.meeus(jd)[20];
        }


        static double sunGeocentricElongation(double jd){
            double deltaSun,alphaSun,deltaMoon,alphaMoon,psi;
            deltaSun = Sun.Meeus.apparentDeclination(jd);
            alphaSun = Sun.Meeus.apparentRightAscension(jd);
            deltaMoon = apparentDeclination(jd);
            alphaMoon = apparentRightAscension(jd);
            psi = Math.toDegrees(Math.acos(Math.sin(Math.toRadians(deltaSun))*Math.sin(Math.toRadians(deltaMoon))+Math.cos(Math.toRadians(deltaSun))*Math.cos(Math.toRadians(deltaMoon))*Math.cos(Math.toRadians(alphaSun-alphaMoon))));
            return  psi;
        }


    }





    static class Elpmpp02{
//        static double appr_Longitude_geo_moon;
//        static double appr_Latitudegeo_moon;
//
//        public static void ngisiValue(double jd){
//             double T=(jd-2451545)/36525;
//
//
//            double mean_longitude_moon= ElpMpp02Term.meanLongitude(T);
//
//            double koreksibujurB= ElpMpp02Term.koreksiLongitude(T);
//            double deltaPsi= Nutasi.deltaPsiDanEpsilon(T)[2];
//
//            //Koreksi bujur bulan
//            double true_longitude_moon=(mean_longitude_moon+koreksibujurB)%360;
//            double apparent_longitude_moon=(true_longitude_moon+deltaPsi)%360;
//            if (apparent_longitude_moon<0)apparent_longitude_moon+=360;
//            appr_Longitude_geo_moon =apparent_longitude_moon;
//
//            appr_Latitudegeo_moon = ElpMpp02Term.latitude(T);
//
//        }


        static double trueGeocentricLongitude(double jd){
            return  Calculation.elpMpp02(jd)[1];
        }

        static double apparentGeocentricLongitude (double jd){
            return Calculation.elpMpp02(jd)[2];
        }



        static double apparentGeocentricLatitude(double jd){
            return  Calculation.elpMpp02(jd)[3];
        }



        static double apparentRightAscension (double jd){
            return  Calculation.elpMpp02(jd)[4];
        }


        static double apparentDeclination(double jd){
            return  Calculation.elpMpp02(jd)[5];
        }


        static double trueGeocentricDistance(double jd){
            return  Calculation.elpMpp02(jd)[6];
        }


        static double angularSemiDiameter (double jd){
            return  Calculation.elpMpp02(jd)[7];
        }


        static double equatorialHorizontalParallax (double jd){
            return  Calculation.elpMpp02(jd)[8];
        }

        static double diskIlluminatedFraction (double jd){
            //kombinasi dengan data matahari dari Vsop87
            return  Calculation.elpMpp02(jd)[10]; }


        static double brightLimbAngle(double jd){
            return  Calculation.elpMpp02(jd)[9];
        }


        static double sunGeocentricElongation(double jd){
            double deltaSun,alphaSun,deltaMoon,alphaMoon,psi;
            deltaSun = Calculation.vsop87(jd)[5];
            alphaSun = Calculation.vsop87(jd)[4];
            deltaMoon = Calculation.vsop87(jd)[15];
            alphaMoon = Calculation.vsop87(jd)[14];
            psi = Math.toDegrees(Math.acos(Math.sin(Math.toRadians(deltaSun))*Math.sin(Math.toRadians(deltaMoon))+Math.cos(Math.toRadians(deltaSun))*Math.cos(Math.toRadians(deltaMoon))*Math.cos(Math.toRadians(alphaSun-alphaMoon))));
            return  psi;
        }


    }



    static class Elpmpp02Trunc{


        static double trueGeocentricLongitude(double jd){
            return  Calculation.elpMpp02Trunc(jd)[1];
        }

        static double apparentGeocentricLongitude (double jd){
            return Calculation.elpMpp02Trunc(jd)[2];
        }



        static double apparentGeocentricLatitude(double jd){
            return  Calculation.elpMpp02Trunc(jd)[3];
        }



        static double apparentRightAscension (double jd){
            return  Calculation.elpMpp02Trunc(jd)[4];
        }


        static double apparentDeclination(double jd){
            return  Calculation.elpMpp02Trunc(jd)[5];
        }


        static double trueGeocentricDistance(double jd){
            return  Calculation.elpMpp02Trunc(jd)[6];
        }


        static double angularSemiDiameter (double jd){
            return  Calculation.elpMpp02Trunc(jd)[7];
        }


        static double equatorialHorizontalParallax (double jd){
            return  Calculation.elpMpp02Trunc(jd)[8];
        }

        static double diskIlluminatedFraction (double jd){
            //kombinasi dengan data matahari dari Vsop87
            return  Calculation.elpMpp02Trunc(jd)[10]; }


        static double brightLimbAngle(double jd){
            return  Calculation.elpMpp02Trunc(jd)[9];
        }


        static double sunGeocentricElongation(double jd){
            double deltaSun,alphaSun,deltaMoon,alphaMoon,psi;
            deltaSun = Calculation.vsop87(jd)[5];
            alphaSun = Calculation.vsop87(jd)[4];
            deltaMoon = Calculation.vsop87(jd)[15];
            alphaMoon = Calculation.vsop87(jd)[14];
            psi = Math.toDegrees(Math.acos(Math.sin(Math.toRadians(deltaSun))*Math.sin(Math.toRadians(deltaMoon))+Math.cos(Math.toRadians(deltaSun))*Math.cos(Math.toRadians(deltaMoon))*Math.cos(Math.toRadians(alphaSun-alphaMoon))));
            return  psi;
        }


    }



}

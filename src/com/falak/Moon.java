package com.falak;


public class Moon {


    static class AstroAlgo {
        static double trueGeocentricLongitude(double jd){
            return  Calculation.astroAlgo(jd)[11];
        }

        static double apparentGeocentricLongitude (double jd){
            return  Calculation.astroAlgo(jd)[12]; }

        static double apparentGeocentricLatitude(double jd){
            return  Calculation.astroAlgo(jd)[13];
        }



        static double apparentRightAscension (double jd){
            return  Calculation.astroAlgo(jd)[14];
        }


        static double apparentDeclination(double jd){
            return  Calculation.astroAlgo(jd)[15];
        }


        static double trueGeocentricDistance(double jd){
            return  Calculation.astroAlgo(jd)[16];
        }


        static double angularSemiDiameter (double jd){
            return  Calculation.astroAlgo(jd)[17];
        }


        static double equatorialHorizontalParallax (double jd){
            return  Calculation.astroAlgo(jd)[18];
        }

        static double diskIlluminatedFraction (double jd){
            return  Calculation.astroAlgo(jd)[19];
        }


        static double brightLimbAngle(double jd){
            return  Calculation.astroAlgo(jd)[20];
        }


        static double sunGeocentricElongation(double jd){
            double deltaSun,alphaSun,deltaMoon,alphaMoon,psi;
            deltaSun = Sun.AstroAlgo.apparentDeclination(jd);
            alphaSun = Sun.AstroAlgo.apparentRightAscension(jd);
            deltaMoon = apparentDeclination(jd);
            alphaMoon = apparentRightAscension(jd);
            psi = Math.toDegrees(Math.acos(Math.sin(Math.toRadians(deltaSun))*Math.sin(Math.toRadians(deltaMoon))+Math.cos(Math.toRadians(deltaSun))*Math.cos(Math.toRadians(deltaMoon))*Math.cos(Math.toRadians(alphaSun-alphaMoon))));
            return  psi;
        }


    }





    static class Elpmpp02{

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

    static class Elp2000{


        static double trueGeocentricLongitude(double jd){
            return  Calculation.elp2000(jd)[1];
        }

        static double apparentGeocentricLongitude (double jd){
            return Calculation.elp2000(jd)[2];
        }



        static double apparentGeocentricLatitude(double jd){
            return  Calculation.elp2000(jd)[3];
        }



        static double apparentRightAscension (double jd){
            return  Calculation.elp2000(jd)[4];
        }


        static double apparentDeclination(double jd){
            return  Calculation.elp2000(jd)[5];
        }


        static double trueGeocentricDistance(double jd){
            return  Calculation.elp2000(jd)[6];
        }


        static double angularSemiDiameter (double jd){
            return  Calculation.elp2000(jd)[7];
        }


        static double equatorialHorizontalParallax (double jd){
            return  Calculation.elp2000(jd)[8];
        }

        static double diskIlluminatedFraction (double jd){
            //kombinasi dengan data matahari dari Vsop87
            return  Calculation.elp2000(jd)[10]; }


        static double brightLimbAngle(double jd){
            return  Calculation.elp2000(jd)[9];
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

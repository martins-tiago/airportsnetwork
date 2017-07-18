/*
    @Date LP2
    @author Rui Moreira, Christophe Soares, Ana Ribeiro Gomes
    @Tiago Martins 24440, Goncalo Silva 26329
    @version 2.0
    @date 2017
 */
package edu.ufp.inf.lp2.projeto17;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date implements Comparable<Date> {
// abributos

    private int day;

    private int month;

    private int year;

    private int hour;

    private int minutes;

    private int seconds;

//metodos publicos
    /**
     * @brief Função Verificar se Data anterior
     */
    public boolean beforeDate(Date d) {

        /**
         * @details Função que recebe uma data e verifica se é anterior à data a
         * comparar e retorna um boleano
         * @param Data d data a verificar
         */
        if (this.year < d.year) {
            return true;
        } else if (this.year == d.year) {
            if (this.month < d.month) {
                return true;
            } else if (this.month == d.month) {
                if (this.day < d.day) {
                    return true;
                } else if (this.day == d.day) {
                    if (this.hour < d.hour) {
                        return true;
                    } else if (this.hour == d.hour) {
                        if (this.minutes < d.minutes) {
                            return true;
                        } else if (this.minutes == d.minutes) {
                            if (this.seconds < d.seconds) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean isLeapYear() {
        return ((this.year % 4 == 0) && ((this.year % 100 != 0) || (this.year % 400 == 0)));
    }

    public int dayMonth() {
        switch (this.month) {
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (this.isLeapYear()) {
                    return 29;
                }
                return 28;
            default:
                return 31;
        }
    }

    public int differenceYears(Date d) {
        /*    d1=(5,1,2015)
            --------------
            d2=(1,1,2017)
           d1.difference.years(d2)
         */

        //return this.getYear()-d.getYear(); //2015-2017 -ou-
        return Math.abs(this.getYear() - d.getYear()); //Math.abs - dÃ¡ o valor absoluto, sempre positivo de 2015-2017
    }

    public int differenceMonths(Date d) {

        return Math.abs(this.getMonth() - d.getMonth() + 12 * this.differenceYears(d));
        //return Math.abs(this.getMonth()-d.getMonth() + (this.getYear()-d.getYear())*12);
    }

    public int differenceDays(Date d) {

        return Math.abs(this.getDay() - d.getDay() + this.differenceYears(d) * 365);
    }

    @Override
    public String toString() {

        return this.getDay() + "/" + this.getMonth() + "/" + this.getYear() + " " + this.getHour() + ":" + this.getMinutes() + ":" + this.getSeconds();
    }

    public Date(int day, int month, int year, int hour, int minutes, int seconds) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minutes = minutes;
        this.seconds = seconds;
    }

//metodos especiais
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    ///dia de hoje
    public Date() {
        Calendar c = new GregorianCalendar();
        this.day = c.get(Calendar.DAY_OF_MONTH);
        this.month = c.get(Calendar.MONTH) + 1;
        this.year = c.get(Calendar.YEAR);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    /**
     * @brief Função Comparar datas
     */
    @Override
    public int compareTo(Date d) {

        /**
         * @details Função que compara duas datas e retorna 0 se iguais , 1 se
         * maior e -1 se anterior
         * @param Data d data a verificar
         */
        if (this.day == d.day && this.month == d.month && this.year == d.year && this.hour == d.hour && this.minutes == d.minutes && this.seconds == d.seconds) {

            return 0;

        }
        return (this.beforeDate(d) ? -1 : 1);
    }

}

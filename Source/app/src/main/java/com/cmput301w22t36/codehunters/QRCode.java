package com.cmput301w22t36.codehunters;

import org.apache.commons.codec.digest.DigestUtils;
import org.osmdroid.util.GeoPoint;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;
import java.util.Hashtable;
import java.util.concurrent.ThreadLocalRandom;

public class QRCode implements Serializable {
    //Attributes accounted for
    private String hash;
    private int score;
    private String code;
    //Attributes yet to be implemented
    private GeoPoint geolocation;
    //private Photo photo;

    public QRCode(String code){
        //Set code equal to passed in code and compute hash
        this.code = code;
        hash = DigestUtils.sha256Hex(code);

        // TODO: this is a placeholder coordinate for the geolocation, just somewhere on campus
        double lat = ThreadLocalRandom.current().nextDouble(53.523273103233294d, 53.5291036673118d);
        double lon = ThreadLocalRandom.current().nextDouble(-113.52954192682526, -113.518766067236d);
        this.geolocation = new GeoPoint(lat, lon);

        //Compute score of code
        String []letters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v"};
        Hashtable<String, Integer> letters_values = new Hashtable<String, Integer>();
        for (int i=0; i<letters.length; i++) {
            letters_values.put(letters[i], i+10);
        }
        int length = 1;
        for (int i=1; i<hash.length(); i++) {
            if (hash.charAt(i)==hash.charAt(i-1)) {
                length++;
            } else if (length > 1){
                String value = String.valueOf(hash.charAt(i-1));
                try{
                    int number = Integer.parseInt(value);
                    if (number==0) { number = 20; };
                    score += (int) Math.pow(number, length-1);
                } catch (NumberFormatException ex) {
                    score += (int) Math.pow(letters_values.get(value), length-1);
                }
                length = 1;
            }
        }
    }

    public String getHash() {
        return hash;
    }

    public int getScore() {
        return score;
    }

    public String getCode() {
        return code;
    }

    public GeoPoint getGeolocation() { return geolocation; }
}

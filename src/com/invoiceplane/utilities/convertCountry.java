package com.invoiceplane.utilities;

/**
 * Created by amolpc on 27/08/2018.
 */
public class convertCountry
{
    public static String convertCountry(String country)
    {
        String convertedCountry = "";

        switch (country)
        {
            case "IN" : convertedCountry="India";break;
        }


        return convertedCountry;
    }
}

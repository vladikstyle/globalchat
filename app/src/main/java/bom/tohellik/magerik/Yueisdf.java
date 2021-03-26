package bom.tohellik.magerik;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

class Yueisdf extends Thread {

    static int nomerserve;

    @Override
    public void run()
    {
        URL myUrl = null;
        try {
            myUrl = new URL("https://dateheroes.xyz/Lmsjvyems");
        } catch (MalformedURLException e) {
            System.out.println("Errorie");
            e.printStackTrace();
            System.out.println("Errorie");

        }
        HttpURLConnection myUrlCon =
                null;
        try {
            myUrlCon = (HttpURLConnection) myUrl.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erorrie");
        }

        System.out.println("Response method " +
                myUrlCon.getRequestMethod());

        try {
            nomerserve = myUrlCon.getResponseCode();
            System.out.println("Code answer " +
                    nomerserve);
        } catch (IOException e) {
            System.out.println("Erorie");
            e.printStackTrace();
            System.out.println("Erorrie");
            nomerserve = 404;
        }
    }

    public int intoservolus()
    {
        return nomerserve;
    }

}
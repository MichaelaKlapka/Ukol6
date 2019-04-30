package com.example.ukol6;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.orhanobut.hawk.Hawk;

import org.w3c.dom.Text;

// prvni string je vstup, druhy v prubehu, napr. procenta, treti vystup
// implement methods vygeneruje doInBackground
//code - override methods - onPostExecute
//když s tím nepracuju, tak dám void
public class MyAsyncTask extends AsyncTask<Void, Void, String> {

    //udelam si konstruktor, abych si mohla poslat aktivitu nebo jine veci z tridy do tridy
    public MyAsyncTask(Activity activity, String zadanyText, String preklad) {
        this.activity = activity;
        this.zadanyText = zadanyText;
        this.preklad = preklad;
    }


    public TextView textView;
    public Activity activity;
    public String zadanyText;
    public String preklad;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Void... voids) {
        //tady bych stahovala data atd. - to co nechci aby mi zpomalovalo aplikaci
        try {
            preklad = new StringBuilder(zadanyText).reverse().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return preklad;
        //uklada se do s a pak muzu vyvolat v onPostExecute
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        //casting - findViewById vrací textView a musím jí převést na TextView, která už má implementovánu metodu setText
        ((TextView)activity.findViewById(R.id.textView)).setText(preklad);

        Toast.makeText(activity, preklad, Toast.LENGTH_SHORT).show();

//        TextView@ textView = (R.id.textView);
//        TextView textView=(TextView)findViewbyId(R.id.textView);


//        activity.runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                ((TextView) findViewById(R.id.textView)).setText(preklad);}});
// findViewById nejde spustit protože je to metoda aktivity a ne Asynctasku jako třídy

    }
}


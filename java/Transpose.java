package com.transposethis;

import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;


public class Transpose extends ActionBarActivity {

    private SeekBar seekBar;
    private TextView trebleNotes, trebleStaff, altoNotes, altoStaff;
    HashMap fontToAlto, fontToTreble, fontToBass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_transpose);

        seekBar = (SeekBar) findViewById(R.id.trebleSeekBar);
        trebleNotes = (TextView) findViewById(R.id.trebleNotes);
        trebleStaff = (TextView) findViewById(R.id.trebleStaff);
        altoNotes = (TextView) findViewById(R.id.altoNotes);
        altoStaff = (TextView) findViewById(R.id.altoStaff);

        fontToAlto = new HashMap<String, String>();
        fontToTreble = new HashMap<String, String>();
        fontToBass = new HashMap<String, String>();

        setHashMap();

        Typeface music_font = Typeface.createFromAsset(getAssets(), "fonts/LASSUS.TTF");
        trebleNotes.setTypeface(music_font);
        trebleStaff.setTypeface(music_font);
        altoNotes.setTypeface(music_font);
        altoStaff.setTypeface(music_font);
        //øæ
        // Initialize the textview with staff and middle note
        trebleStaff.setText("`5555");
        trebleNotes.setText("55_");
        altoStaff.setText("25555");
        altoNotes.setText("55_");

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;
            String trebleNote = "";
            String altoNote = "";

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                progress = progressValue;
                trebleNote = (String)fontToTreble.get(Integer.toString(progress));
                trebleNotes.setText("55" + trebleNote);

                altoNote = (String)fontToAlto.get(Integer.toString(progress));
                altoNotes.setText("55" + altoNote);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                trebleNote = (String)fontToTreble.get(Integer.toString(progress));
                trebleNotes.setText("55" + trebleNote);

                altoNote = (String)fontToAlto.get(Integer.toString(progress));
                altoNotes.setText("55" + altoNote);
            }
        });
    }

    private void setHashMap() {
        fontToTreble.put("0", "#");
        fontToTreble.put("1", "$");
        fontToTreble.put("2", "%");
        fontToTreble.put("3", "^");
        fontToTreble.put("4", "&");
        fontToTreble.put("5", "*");
        fontToTreble.put("6", "(");
        fontToTreble.put("7", ")");
        fontToTreble.put("8", "_");
        fontToTreble.put("9", "+");
        fontToTreble.put("10", "Q");
        fontToTreble.put("11", "W");
        fontToTreble.put("12", "E");
        fontToTreble.put("13", "R");
        fontToTreble.put("14", "T");
        fontToTreble.put("15", "Y");
        fontToTreble.put("16", "U");

        fontToAlto.put("0", "(");
        fontToAlto.put("1", ")");
        fontToAlto.put("2", "_");
        fontToAlto.put("3", "+");
        fontToAlto.put("4", "Q");
        fontToAlto.put("5", "W");
        fontToAlto.put("6", "E");
        fontToAlto.put("7", "R");
        fontToAlto.put("8", "T");
        fontToAlto.put("9", "Y");
        fontToAlto.put("10", "U");
        fontToAlto.put("11", "5");
        fontToAlto.put("12", "5");
        fontToAlto.put("13", "5");
        fontToAlto.put("14", "5");
        fontToAlto.put("15", "5");
        fontToAlto.put("16", "5");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_transpose, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_transpose, container, false);
            return rootView;
        }
    }
}

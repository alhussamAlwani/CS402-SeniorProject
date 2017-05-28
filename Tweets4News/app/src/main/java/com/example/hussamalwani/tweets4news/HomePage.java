package com.example.hussamalwani.tweets4news;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import sources.AA;
import sources.AHaber;
import sources.AjansHaber;
import sources.Aksam;
import sources.Anayurt;
import sources.CNNTURK;
import sources.Cumhuriyet;
import sources.DW;
import sources.EuroNews;
import sources.GercekGundem;
import sources.Hurriyet;
import sources.Sabah;
import sources.Star;
import sources.Yenisafak;

public class HomePage extends Activity {

    ImageView hurriyet, cnnTurk, sabah, cumhuriyet, anayurt, yenisafak, star, aksam,
        dw, ajanshaber, eunews, ahbr, aa, gercekgundem;
    Button hurriyetBtn, cnnTurkBtn, sabahBtn, cumhuriyetBtn, anayurtBtn, yenisafakBtn, starBtn, aksamBtn,
            dwBtn, ajanshaberBtn, eunewsBtn, ahbrBtn, aaBtn, gercekgundemBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        hurriyetBtn = (Button) findViewById(R.id.hurriyetBtn);
        cnnTurkBtn = (Button) findViewById(R.id.cnnturkBtn);
        anayurtBtn = (Button) findViewById(R.id.anayurtBtn);
        sabahBtn = (Button) findViewById(R.id.sabahBtn);
        cumhuriyetBtn = (Button) findViewById(R.id.cumhuriyetBtn);
        yenisafakBtn = (Button) findViewById(R.id.yenisafakBtn);
        starBtn = (Button) findViewById(R.id.starBtn);
        aksamBtn = (Button) findViewById(R.id.aksamBtn);
        aaBtn = (Button) findViewById(R.id.aaBtn);
        ahbrBtn = (Button) findViewById(R.id.ahbrBtn);
        ajanshaberBtn = (Button) findViewById(R.id.ajhaberBtn);
        eunewsBtn = (Button) findViewById(R.id.eunewsBtn);
        dwBtn = (Button) findViewById(R.id.dwBtn);
        gercekgundemBtn  = (Button) findViewById(R.id.ggBtn);

        hurriyet = (ImageView) findViewById(R.id.hurriyetImg);
        cnnTurk = (ImageView) findViewById(R.id.cnnTurkImg);
        anayurt = (ImageView) findViewById(R.id.anayurtImg);
        sabah = (ImageView) findViewById(R.id.sabahImg);
        cumhuriyet = (ImageView) findViewById(R.id.cumhuriyetImg);
        yenisafak = (ImageView) findViewById(R.id.yenisafakImg);
        star = (ImageView) findViewById(R.id.starImg);
        aksam = (ImageView) findViewById(R.id.aksamImg);
        dw = (ImageView) findViewById(R.id.dwImg);
        ajanshaber = (ImageView) findViewById(R.id.ajhaberImg);
        eunews = (ImageView) findViewById(R.id.eunewsImg);
        ahbr = (ImageView) findViewById(R.id.ahbrImg);
        aa = (ImageView) findViewById(R.id.aaImg);
        gercekgundem = (ImageView) findViewById(R.id.ggImg);

        hurriyet.setImageResource(R.drawable.rsz_hurriyetlogo);
        cnnTurk.setImageResource(R.drawable.rsz_cnnturklogo);
        anayurt.setImageResource(R.drawable.rsz_anayurt);
        sabah.setImageResource(R.drawable.rsz_sabah);
        cumhuriyet.setImageResource(R.drawable.rsz_cumhuriyet);
        yenisafak.setImageResource(R.drawable.rsz_yenisafak);
        star.setImageResource(R.drawable.rsz_star);
        aksam.setImageResource(R.drawable.rsz_aksam);
        dw.setImageResource(R.drawable.rsz_dw);
        ajanshaber.setImageResource(R.drawable.rsz_ajanshaber);
        eunews.setImageResource(R.drawable.rsz_euronews);
        ahbr.setImageResource(R.drawable.rsz_ahaber);
        aa.setImageResource(R.drawable.rsz_anadoluajans);
        gercekgundem.setImageResource(R.drawable.rsz_gercekgundem);

        hurriyetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, Hurriyet.class);
                startActivity(intent);
            }
        });

        cnnTurkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, CNNTURK.class);
                startActivity(intent);
            }
        });

        anayurtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, Anayurt.class);
                startActivity(intent);
            }
        });

        sabahBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, Sabah.class);
                startActivity(intent);
            }
        });

        cumhuriyetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, Cumhuriyet.class);
                startActivity(intent);
            }
        });

        yenisafakBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, Yenisafak.class);
                startActivity(intent);
            }
        });

        starBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, Star.class);
                startActivity(intent);
            }
        });

        aksamBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, Aksam.class);
                startActivity(intent);
            }
        });

        aaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, AA.class);
                startActivity(intent);
            }
        });

        ahbrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, AHaber.class);
                startActivity(intent);
            }
        });

        ajanshaberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, AjansHaber.class);
                startActivity(intent);
            }
        });

        eunewsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, EuroNews.class);
                startActivity(intent);
            }
        });

        dwBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, DW.class);
                startActivity(intent);
            }
        });

        gercekgundemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, GercekGundem.class);
                startActivity(intent);
            }
        });

    }

}

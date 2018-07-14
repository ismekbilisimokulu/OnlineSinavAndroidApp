package com.ismek.onlinesinav;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.ismek.onlinesinav.entity.Sorular;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;

import butterknife.BindView;

public class SinavActivity extends BaseActivity {

    @BindView(R.id.webView)
    public WebView webView;

    @BindView(R.id.spGit)
    public Spinner spGit;

    @BindView(R.id.txtSure)
    public TextView txtSure;

    List<String> listSpinner;

    HashMap<Integer, String> answers;

    public List<Sorular> sorulars;

    int current_page = 0;
    int lengthOfSorular;
    String soruHtml;

    long gecensure,sinavSuresi,kalansure;


    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);

        answers = new HashMap<Integer, String>();

        createQuestionList();

        lengthOfSorular = sorulars.size();
        soruHtml = sorulars.get(0).getSoru().toString();  //ilk soruyu alır.

        webViewSettings();

        goToQuestions();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND,-30);
        Date now = new Date();

        gecensure = now.getTime()-calendar.getTime().getTime();
        sinavSuresi = 60* 60 * 1000;
        kalansure = sinavSuresi - gecensure;

        TimerTask timerTask = new CountDownTimerTask();
        //running timer task as daemon thread
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, 1 * 1000);


    }

    public void createQuestionList(){
        sorulars = new ArrayList<>();
        Sorular s1 = new Sorular();
        s1.setSoru("<html><body><strong>1-Aşağıdakilerden hangisi bilgisayarlar arasındaki farklılıkların nedenlerinden biri değildir?</strong><br />\n" +
                "a) Kapasite&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;b) Hız &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; c) G&uuml;venlik &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;d) Maliyet</p>\n</body></html>");
        sorulars.add(s1);

        Sorular s2 = new Sorular();
        s2.setSoru("<html><body><p><strong>2-Yazılım nedir?</strong><br />\n" +
                "(a) Donanım ile kullanıcı arasındaki iletişimi kuran ve donanımı kontrol eden programlar<br />\n" +
                "b) Bilgisayarın fiziksel olarak algılanabilen t&uuml;m par&ccedil;aları<br />\n" +
                "c) Bilgisayarda bilgilerin ge&ccedil;ici olarak tutulduğu bir donanım elemanı<br />\n" +
                "d) Bilgisayarda bilgilerin kalıcı olarak saklandığı ve diğer adı ROM olan donanım elemanı</p>\n</body></html>");
        sorulars.add(s2);

        Sorular s3 = new Sorular();
        s3.setSoru("<html><body><p><strong>3-Bilgisayarın temel &ccedil;alışma mantığı aşağıdaki se&ccedil;eneklerden hangisi ile ifade edilebilir?</strong><br />\n" +
                "a) Veri-İşlem-Bilgi&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; b) RAM-ROM-Sabit disk<br />\n" +
                "c) Klavye-Ekran-Kasa&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; d) Bilgi-İşlem-Veri</p>\n</body></html>");
        sorulars.add(s3);

        Sorular s4 = new Sorular();
        s4.setSoru("<html><body><p><strong>4-Aşağıdakilerden hangisi doğrudur?</strong><br />\n" +
                "a) 1 Kilobyte = 8 Bit<br />\n" +
                "b) 1024 MB = 1 KB<br />\n" +
                "(с) 1 KB = 1024 Byte<br />\n" +
                "d) 1 GB - 1024 KB</p>\n</body></html>");
        sorulars.add(s4);

        Sorular s5 = new Sorular();
        s5.setSoru("<html><body><p><strong>5-Aşağıdakilerden hangisi depolama birimi değildir?</strong><br />\n" +
                "a) Sabit disk &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;b) RAM &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;c) ROM&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;(d) Anakart</p>\n</body></html>");
        sorulars.add(s5);
    }

    public void webViewSettings(){
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.loadData(soruHtml, "text/html", "UTF-8");
        webView.setWebViewClient(new WebViewClient());
        webView.setBackgroundColor(Color.argb(1, 255, 255, 255));
    }

    private void goToQuestions() {
        listSpinner = new ArrayList();

        for (int i = 1; i < lengthOfSorular + 1; i++) {
            listSpinner.add(i + ". Soru");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.spinner_item, listSpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spGit.setAdapter(adapter);


        spGit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                soruHtml = sorulars.get(position).getSoru().toString();
                webView.loadData(soruHtml, "text/html", "UTF-8");
                current_page = position;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }

        });
    }

    public void changeQuestionForward(View view){

        if (current_page < lengthOfSorular-1){
            current_page ++;
            soruHtml = sorulars.get(current_page).getSoru().toString();  //sonraki soruyu alır.
            webView.loadData(soruHtml, "text/html", "UTF-8");
        }
        else{
            showToast("Daha Fazla soru yok!");
        }

    }

    public void changeQuestionBackward(View view){

        if (current_page > 0){
            current_page--;
            soruHtml = sorulars.get(current_page).getSoru().toString();  //önceki soruyu alır.
            webView.loadData(soruHtml, "text/html", "UTF-8");
        }
        else{
            showToast("Bu ilk soru!");
        }

    }

    public  void choiceA(View view){
        answers.put(current_page + 1, "a");
    }

    public  void choiceB(View view){
        answers.put(current_page + 1, "b");
    }

    public  void choiceC(View view){
        answers.put(current_page + 1, "c");
    }

    public  void choiceD(View view){
        answers.put(current_page + 1, "d");
    }

    public  void choiceE(View view){
        answers.put(current_page + 1, "e");
    }

    public  void sinaviBitir(View view){
        showToast(answers.toString());
    }


    @Override
    protected int getContentView() {
        return R.layout.activity_sinav;
    }

    @Override
    public void onBackPressed() {
        showAlertDialog("Sınavdan çıkmak istediğinize emin misiniz? (Cevaplarınız silinecektir!)",View.VISIBLE,View.VISIBLE,"Evet", "Hayır",new Callable<Void>() {
            public Void call() {
                Intent i = new Intent(SinavActivity.this,MainActivity.class);
                startActivity(i);
                finish();
                return null;
            }
        });
    }

    public class CountDownTimerTask extends TimerTask {

        @Override
        public void run() {
           long saniye = kalansure / 1000 % 60;
           long dk = kalansure / 1000 / 60;
           txtSure.setText(String.format("%02d", dk) + ":" + String.format("%02d", saniye));
           if (kalansure == 0)
               cancel();
            kalansure -= 1 * 1000;
        }

    }
}

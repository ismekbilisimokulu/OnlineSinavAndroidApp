package com.ismek.onlinesinav;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.ismek.onlinesinav.entity.BaseReturn;
import com.ismek.onlinesinav.entity.Sinav;
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
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.ismek.onlinesinav.util.ApplicationConstant;
import com.ismek.onlinesinav.util.Utils;
import com.ismek.onlinesinav.ws.ApiClient;
import com.ismek.onlinesinav.ws.IRestService;

public class SinavActivity extends BaseActivity {

    @BindView(R.id.webView)
    public WebView webView;

    @BindView(R.id.spGit)
    public Spinner spGit;

    @BindView(R.id.txtSure)
    public TextView txtSure;

    @BindView(R.id.rgChoices)
    public RadioGroup rgChoices;

    @BindView(R.id.txtSinavBilgiSorular)
    public TextView txtSinavBilgiSorular;

    @BindView(R.id.btn_a)
    public RadioButton btn_a;

    @BindView(R.id.btn_b)
    public RadioButton btn_b;

    @BindView(R.id.btn_c)
    public RadioButton btn_c;

    @BindView(R.id.btn_d)
    public RadioButton btn_d;

    @BindView(R.id.btn_e)
    public RadioButton btn_e;

    @BindView(R.id.txtSinavBilgiAdi)
    public TextView txtSinavBilgiAdi;

    List<String> listSpinner;

    HashMap<Integer, String> answers;

    public List<Sorular> sorulars;

    int current_page = 0;
    int lengthOfSorular;
    String soruHtml;
    String secenekSayisi;

    long gecensure,sinavSuresi,kalansure;


    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);

        answers = new HashMap<Integer, String>();

        createQuestionList();



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

        Bundle bundle = getIntent().getExtras();
        Sinav sinav = bundle.getParcelable("sinav");

        //long sinavId = sinav.getSinavId();
        //txtSinavBilgiAdi.setText(sinav.getBransId().getBransAdi());
        txtSinavBilgiAdi.setText("Android");

        long sinavId = 1;

        progressDialog.show();

        IRestService iService = ApiClient.getClient(SinavActivity.this).create(IRestService.class);
        Call<BaseReturn<List<Sorular>>> call = iService.getQuestions(Utils.getAuthToken(), sinavId);
        call.enqueue(new Callback<BaseReturn<List<Sorular>>>() {
            @Override
            public void onResponse(Call<BaseReturn<List<Sorular>>> call, Response<BaseReturn<List<Sorular>>> response) {
                BaseReturn<List<Sorular>> resp = response.body();
                Log.d("ISMEKKK",""+response.code());

                progressDialog.dismiss();
                if (resp != null && ApplicationConstant.SUCCESS_CODE.equals(resp.getCode()))
                {
                    sorulars = resp.getData();
                    lengthOfSorular = sorulars.size();
                    Log.d("ISMEKKK",resp.toString());
                }
                else{
                    showAlertDialog("Sınav verileri alınırken bir hata meydana geldi!",View.VISIBLE,View.GONE,getString(R.string.ok),"",new Callable<Void>() {
                        public Void call() {
                            finish();
                            return null;
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<BaseReturn<List<Sorular>>> call, Throwable t) {
                progressDialog.dismiss();
                showAlertDialog("Hata oluştu! Lütfen sistem yöneticinizle görüşün!",View.VISIBLE,View.GONE,getString(R.string.ok),"",new Callable<Void>() {
                    public Void call() {
                        return null;
                    }
                });
            }
        });



//        sorulars = new ArrayList<>();
//        Sorular s1 = new Sorular();
//        s1.setSoru("<html><body><strong>1-Aşağıdakilerden hangisi bilgisayarlar arasındaki farklılıkların nedenlerinden biri değildir?</strong><br />\n" +
//                "a) Kapasite&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;b) Hız &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; c) G&uuml;venlik &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;d) Maliyet</p>\n</body></html>");
//        s1.setSecenekSayisi("5");
//        sorulars.add(s1);
//
//        Sorular s2 = new Sorular();
//        s2.setSoru("<html><body><p><strong>2-Yazılım nedir?</strong><br />\n" +
//                "(a) Donanım ile kullanıcı arasındaki iletişimi kuran ve donanımı kontrol eden programlar<br />\n" +
//                "b) Bilgisayarın fiziksel olarak algılanabilen t&uuml;m par&ccedil;aları<br />\n" +
//                "c) Bilgisayarda bilgilerin ge&ccedil;ici olarak tutulduğu bir donanım elemanı<br />\n" +
//                "d) Bilgisayarda bilgilerin kalıcı olarak saklandığı ve diğer adı ROM olan donanım elemanı</p>\n</body></html>");
//        s2.setSecenekSayisi("4");
//        sorulars.add(s2);
//
//        Sorular s3 = new Sorular();
//        s3.setSoru("<html><body><p><strong>3-Bilgisayarın temel &ccedil;alışma mantığı aşağıdaki se&ccedil;eneklerden hangisi ile ifade edilebilir?</strong><br />\n" +
//                "a) Veri-İşlem-Bilgi&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; b) RAM-ROM-Sabit disk<br />\n" +
//                "c) Klavye-Ekran-Kasa&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; d) Bilgi-İşlem-Veri</p>\n</body></html>");
//        s3.setSecenekSayisi("3");
//        sorulars.add(s3);
//
//        Sorular s4 = new Sorular();
//        s4.setSoru("<html><body><p><strong>4-Aşağıdakilerden hangisi doğrudur?</strong><br />\n" +
//                "a) 1 Kilobyte = 8 Bit<br />\n" +
//                "b) 1024 MB = 1 KB<br />\n" +
//                "(с) 1 KB = 1024 Byte<br />\n" +
//                "d) 1 GB - 1024 KB</p>\n</body></html>");
//        sorulars.add(s4);
//
//        Sorular s5 = new Sorular();
//        s5.setSoru("<html><body><p><strong>5-Aşağıdakilerden hangisi depolama birimi değildir?</strong><br />\n" +
//                "a) Sabit disk &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;b) RAM &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;c) ROM&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;(d) Anakart</p>\n</body></html>");
//        s5.setSecenekSayisi("2");
//        sorulars.add(s5);
    }

    public void webViewSettings(){
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.loadData(soruHtml, "text/html", "UTF-8");
        webView.setWebViewClient(new WebViewClient());
        webView.setBackgroundColor(Color.argb(1, 255, 255, 255));
    }

    public void goToQuestions() {
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
                soruHtml = sorulars.get(position).getSoru();
                secenekSayisi = sorulars.get(position).getSecenekSayisi();

                secenekOlustur(secenekSayisi);

                webView.loadData(soruHtml, "text/html", "UTF-8");
                current_page = position;

                txtSinavBilgiSorular.setText((current_page + 1) + "/" + lengthOfSorular);

                String value = answers.get(current_page + 1);

                if (value != null){
                    setSelectedButton(value);
                }
                else{
                    rgChoices.clearCheck();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }

        });
    }

    public void changeQuestionForward(View view){

        if (current_page < lengthOfSorular-1){
            current_page ++;
            soruHtml = sorulars.get(current_page).getSoru();  //sonraki soruyu alır.

            secenekSayisi = sorulars.get(current_page).getSecenekSayisi();

            secenekOlustur(secenekSayisi);

            webView.loadData(soruHtml, "text/html", "UTF-8");
            spGit.setSelection(current_page); //Spinner'ın seçilenini şuanki soru yapar.(Yoksa 1.Soruya gitmiyor!)

            txtSinavBilgiSorular.setText((current_page + 1) + "/" + lengthOfSorular);

            String value = answers.get(current_page + 1);

            if (value != null){
                setSelectedButton(value);
            }
            else{
                rgChoices.clearCheck();
            }

        }
    }

    public void changeQuestionBackward(View view){

        if (current_page > 0){
            current_page--;
            soruHtml = sorulars.get(current_page).getSoru();  //önceki soruyu alır.

            secenekSayisi = sorulars.get(current_page).getSecenekSayisi();

            secenekOlustur(secenekSayisi);

            webView.loadData(soruHtml, "text/html", "UTF-8");
            spGit.setSelection(current_page);

            txtSinavBilgiSorular.setText((current_page + 1) + "/" + lengthOfSorular);

            String value = answers.get(current_page + 1);

            if (value != null){
                setSelectedButton(value);
            }
            else{
                rgChoices.clearCheck();
            }
        }
    }

    public  void choiceA(View view){
        String value = answers.get(current_page + 1);

        if (value != null && value.equals("a")){
            rgChoices.clearCheck();
            answers.remove(current_page + 1);
        }
        else{
            answers.put(current_page + 1, "a");
        }


    }

    public  void choiceB(View view){
        String value = answers.get(current_page + 1);

        if (value != null && value.equals("b")){
            rgChoices.clearCheck();
            answers.remove(current_page + 1);
        }
        else{
            answers.put(current_page + 1, "b");
        }
    }

    public  void choiceC(View view){
        String value = answers.get(current_page + 1);

        if (value != null && value.equals("c")){
            rgChoices.clearCheck();
            answers.remove(current_page + 1);
        }
        else{
            answers.put(current_page + 1, "c");
        }
    }

    public  void choiceD(View view){
        String value = answers.get(current_page + 1);

        if (value != null && value.equals("d")){
            rgChoices.clearCheck();
            answers.remove(current_page + 1);
        }
        else{
            answers.put(current_page + 1, "d");
        }
    }

    public  void choiceE(View view){
        String value = answers.get(current_page + 1);

        if (value != null && value.equals("e")){
            rgChoices.clearCheck();
            answers.remove(current_page + 1);
        }
        else{
            answers.put(current_page + 1, "e");
        }
    }

    public  void sinaviBitir(View view){
        //showToast(answers.toString());

        showAlertDialog("Sınavı bitirmek istediğinize emin misiniz?",View.VISIBLE,View.VISIBLE,"Evet", "Hayır",new Callable<Void>() {
            public Void call() {
                String cevaplar = sendAnswers();
                showToast(cevaplar);
                Intent i = new Intent(SinavActivity.this,SinavSonuc.class);
                startActivity(i);
                finish();
                return null;
            }
        });
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_sinav;
    }

    @Override
    public void onBackPressed() {
        showAlertDialog("Sınavdan çıkmak istediğinize emin misiniz? (Cevaplarınız silinecektir!)",View.VISIBLE,View.VISIBLE,"Evet", "Hayır",new Callable<Void>() {
            public Void call() {
//                Intent i = new Intent(SinavActivity.this,MainActivity.class);
//                startActivity(i);
                finish();
                return null;
            }
        });
    }

    public class CountDownTimerTask extends TimerTask {

        long saniye;
        long dk;
        @Override
        public void run() {
            saniye = kalansure / 1000 % 60;
            dk = kalansure / 1000 / 60;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    txtSure.setText(String.format("%02d", dk) + ":" + String.format("%02d", saniye));
                }
            });

            if (kalansure == 0){
                cancel();
                String cevaplar = sendAnswersTimeout();
                Intent i = new Intent(SinavActivity.this,SinavSonuc.class);
                startActivity(i);
                finish();
            }

            kalansure -= 1 * 1000;
        }

    }

    private String sendAnswers() {

        StringBuilder builder = new StringBuilder();

        for (int i = 1; i < lengthOfSorular + 1 ; i++) {

            if (!TextUtils.isEmpty(answers.get(i))){
                builder.append(answers.get(i));
            }
            else{
                builder.append(" ");
            }
        }

        String result = builder.toString();

        return result;
    }

    private String sendAnswersTimeout() {

        StringBuilder builder = new StringBuilder();

        for (int i = 1; i < lengthOfSorular + 1 ; i++) {

            if (!TextUtils.isEmpty(answers.get(i))){
                builder.append(answers.get(i));
            }
            else{
                builder.append(" ");
            }
        }

        String result = builder.toString();

        return result;
    }


    private void setSelectedButton(String choice) {
        if (choice.equals("a"))
            rgChoices.check(rgChoices.getChildAt(ApplicationConstant.CHOICE_A).getId());
        else if (choice.equals("b"))
            rgChoices.check(rgChoices.getChildAt(ApplicationConstant.CHOICE_B).getId());
        else if (choice.equals("c"))
            rgChoices.check(rgChoices.getChildAt(ApplicationConstant.CHOICE_C).getId());
        else if (choice.equals("d"))
            rgChoices.check(rgChoices.getChildAt(ApplicationConstant.CHOICE_D).getId());
        else if (choice.equals("e"))
            rgChoices.check(rgChoices.getChildAt(ApplicationConstant.CHOICE_E).getId());
    }

    private void secenekOlustur(String numberOfChoices) {

        if (numberOfChoices == null)
        {
            btn_a.setVisibility(View.VISIBLE);
            btn_b.setVisibility(View.VISIBLE);
            btn_c.setVisibility(View.VISIBLE);
            btn_d.setVisibility(View.VISIBLE);
            btn_e.setVisibility(View.VISIBLE);
        }

        else if (numberOfChoices.equals("2"))
        {
            btn_a.setVisibility(View.VISIBLE);
            btn_b.setVisibility(View.VISIBLE);
            btn_c.setVisibility(View.GONE);
            btn_d.setVisibility(View.GONE);
            btn_e.setVisibility(View.GONE);
        }
        else if (numberOfChoices.equals("3"))
        {
            btn_a.setVisibility(View.VISIBLE);
            btn_b.setVisibility(View.VISIBLE);
            btn_c.setVisibility(View.VISIBLE);
            btn_d.setVisibility(View.GONE);
            btn_e.setVisibility(View.GONE);
        }
        else if (numberOfChoices.equals("4"))
        {
            btn_a.setVisibility(View.VISIBLE);
            btn_b.setVisibility(View.VISIBLE);
            btn_c.setVisibility(View.VISIBLE);
            btn_d.setVisibility(View.VISIBLE);
            btn_e.setVisibility(View.GONE);
        }
        else if (numberOfChoices.equals("5"))
        {
            btn_a.setVisibility(View.VISIBLE);
            btn_b.setVisibility(View.VISIBLE);
            btn_c.setVisibility(View.VISIBLE);
            btn_d.setVisibility(View.VISIBLE);
            btn_e.setVisibility(View.VISIBLE);
        }
        else{
            btn_a.setVisibility(View.VISIBLE);
            btn_b.setVisibility(View.VISIBLE);
            btn_c.setVisibility(View.VISIBLE);
            btn_d.setVisibility(View.VISIBLE);
            btn_e.setVisibility(View.VISIBLE);
        }
    }
}

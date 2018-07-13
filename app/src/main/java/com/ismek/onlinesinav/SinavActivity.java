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
import com.ismek.onlinesinav.entity.Sorular;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

import butterknife.BindView;

public class SinavActivity extends BaseActivity {

    @BindView(R.id.webView)
    public WebView webView;

    @BindView(R.id.spGit)
    public Spinner spGit;

    List<String> listSpinner;

    HashMap<Integer, String> answers;

    public List<Sorular> sorulars;

    int current_page = 0;
    int lengthOfSorular;
    String soruHtml;


    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);

        answers = new HashMap<Integer, String>();

        createQuestionList();

        lengthOfSorular = sorulars.size();
        soruHtml = sorulars.get(0).getSoru().toString();  //ilk soruyu alır.

        webViewSettings();

        goToQuestions();
    }

    public void createQuestionList(){
        sorulars = new ArrayList<>();
        Sorular s1 = new Sorular();
        s1.setSoru("<html><body>1.Soru</body></html>");
        sorulars.add(s1);

        Sorular s2 = new Sorular();
        s2.setSoru("<html><body>2.Soru</body></html>");
        sorulars.add(s2);

        Sorular s3 = new Sorular();
        s3.setSoru("<html><body>3.Soru</body></html>");
        sorulars.add(s3);

        Sorular s4 = new Sorular();
        s4.setSoru("<html><body>4.Soru</body></html>");
        sorulars.add(s4);

        Sorular s5 = new Sorular();
        s5.setSoru("<html><body>5.Soru</body></html>");
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
}

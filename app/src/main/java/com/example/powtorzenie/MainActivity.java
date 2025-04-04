package com.example.powtorzenie;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {       //zrobienie klasy main

    private static int ID = 0;      //ustawia ID powiadomienia które nie może być takie samo w przeciwnym razie powiadomienia będą się zmieniać zamiast tworzyć nowe

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);     //robi aktywność

        Button button = findViewById(R.id.powiadomienie);
        button.setOnClickListener(v -> {
                    pomocnik.wyslij(ID,
                            this, "Powiadomienie", "To jest zwykłe powiadomienie", 0, 0);       //znajduje id powiadomienia z pomocnik i używa funkcji wyslij z pomocnik żeby wysłać wiadomość
                    ID++;
                }
        );
        Button button1 = findViewById(R.id.dlugie);     //znajduje id powiadomienia z pomocnik i używa funkcji wyslij z pomocnik żeby wysłać dużo tekstu
        button1.setOnClickListener(view -> {
                    pomocnik.wyslij(ID,
                            this, "Długie powiadomienie",
                            "Tu z winnicy miłości niedojrzałe grona\n" +
                                    "Wzięto na stół Allaha; tu perełki Wschodu³⁴,\n" +
                                    "Grób, Kobieta, Niewola,\n" +
                                    "Religia\n" +
                                    "Z morza uciech i szczęścia, porwała za młodu\n" +
                                    "Truna³⁵, koncha wieczności, do mrocznego łona.\n" +
                                    "Skryła గe niepamięci i czasu zasłona;\n" +
                                    "Nad niemi turban zimny³⁶ błyszczy śród ogrodu,\n" +
                                    "Przemĳanie\n" +
                                    "Jak buńczuk woగska cieniów, i ledwie u spodu\n" +
                                    "Zostały dłonią giaura³⁷ wyryte imiona.\n" +
                                    "O wy, róże edeńskie! u czystości stoku³⁸\n" +
                                    "Odkwitnęły dni³⁹ wasze pod wstydu liściami⁴⁰,\n" +
                                    "Na wieki zataగone niewiernemu oku.\n" +
                                    "Teraz grób wasz spoగrzenie cuǳoziemca plami⁴¹, —\n" +
                                    "Pozwalam mu, — daruగesz, o wielki Proroku!\n" +
                                    "On గeden z cuǳoziemców poglądał ze łzami.", 1, 0);
                    ID++;
                }
        );
        Button button2 = findViewById(R.id.obraz);
        button2.setOnClickListener(view -> {
            pomocnik.wyslij (ID,
                    this, "obraz powiadomienie", "ptak", 2, R.drawable.burd);       //znajduje id powiadomienia z pomocnik i używa funkcji wyslij z pomocnik żeby wysłać obraz
            ID++;
        });

    }
}
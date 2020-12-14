package a.event_handling;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView text_view_1, text_view_2, text_view_3, text_view_4;

    //Установить кастомный toolbar в меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_view_1 = findViewById(R.id.textView1);
        text_view_2 = findViewById(R.id.textView2);
        text_view_3 = findViewById(R.id.textView3);
        text_view_4 = findViewById(R.id.textView4);
        button = findViewById(R.id.button1);

        //Обработчик короткого нажатия кнопки
        button.setOnClickListener(view -> {
            text_view_1.setText("Button clicked");
        });

        //Обработчик долгого нажатия кнопки
        button.setOnLongClickListener(view -> {
            text_view_1.setText("Long button clicked");
            return true;
        });
    }

    //Вызывается после выбора какого-либо пункта toolbar'а
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String action = item.getTitle().toString();

        setTitle(action);

        if ("ButtonClick".equals(action)) {
            setVisibleElements(View.VISIBLE, View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.VISIBLE);
        }
        else if ("MotionEvent".equals(action)) {
            setVisibleElements(View.INVISIBLE, View.VISIBLE, View.VISIBLE, View.INVISIBLE, View.INVISIBLE);
        }
        else {
            setVisibleElements(View.INVISIBLE, View.INVISIBLE, View.INVISIBLE, View.VISIBLE, View.INVISIBLE);
        }

        return super.onOptionsItemSelected(item);
    }

    //Изменить видимость элементов в зависимости от выбранного действия
    private void setVisibleElements(int text_view_1, int text_view_2, int text_view_3, int text_view_4, int button) {
        this.text_view_1.setVisibility(text_view_1);
        this.text_view_2.setVisibility(text_view_2);
        this.text_view_3.setVisibility(text_view_3);
        this.text_view_4.setVisibility(text_view_4);
        this.button.setVisibility(button);
    }
}
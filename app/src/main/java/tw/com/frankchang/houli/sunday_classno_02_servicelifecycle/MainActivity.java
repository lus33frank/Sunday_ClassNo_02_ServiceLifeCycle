package tw.com.frankchang.houli.sunday_classno_02_servicelifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvShow;
    private Intent actionIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findviewer();
        setActionIntent();
    }

    private void findviewer() {
        tvShow = (TextView) findViewById(R.id.textView);
    }

    private void setActionIntent() {
        actionIntent = new Intent(MainActivity.this, MyServiceAction.class);
    }

    public void startOnClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt(getString(R.string.bundle_01), (int)(Math.random() * 49) + 1);
        actionIntent.putExtras(bundle);
        startService(actionIntent);
    }

    public void stopOnClick(View view) {
        stopService(actionIntent);
    }
}
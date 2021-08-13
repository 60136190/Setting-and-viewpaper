package Mr_Dat.setting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SendFeedback extends AppCompatActivity {
    EditText etSubject,etMessage;
    TextView tvTo;
    Button btsend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_feedback);
        etSubject = findViewById(R.id.et_subject);
        etMessage = findViewById(R.id.et_message);
        tvTo = findViewById(R.id.tv_to);
        btsend = findViewById(R.id.bt_send);

        btsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND
                , Uri.parse("mailto:"+tvTo.getText().toString()));
                intent.putExtra(Intent.EXTRA_EMAIL,tvTo.getText().toString());
                intent.putExtra(Intent.EXTRA_SUBJECT,etSubject.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT,etMessage.getText().toString());
                                        intent.setType("message/rfc822");
                        startActivity(Intent.createChooser(intent,"Choose an email client"));
            }
        });
    }
}
//    String to = tvTo.getText().toString();
//    String[] re = to.split(",");
//    String subject = etSubject.getText().toString();
//    String message = etMessage.getText().toString();
//    Intent intent = new Intent(Intent.ACTION_SEND);
//                intent.putExtra(Intent.EXTRA_EMAIL,to);
//                        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
//                        intent.putExtra(Intent.EXTRA_TEXT,message);
//                        intent.setType("message/rfc822");
//                        startActivity(Intent.createChooser(intent,"Choose an email client"));
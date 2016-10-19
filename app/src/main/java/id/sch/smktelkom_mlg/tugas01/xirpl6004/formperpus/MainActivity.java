package id.sch.smktelkom_mlg.tugas01.xirpl6004.formperpus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    EditText etLahir;
    Button bBuat;
    RadioButton rpl, tkj;
    CheckBox cb10, cb11, cb12;
    Spinner angk;
    TextView Nama;
    TextView Lahir;
    TextView Kelas;
    TextView Jurusan;
    TextView Angkatan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNama = (EditText) findViewById(R.id.editTextNama);
        etLahir = (EditText) findViewById(R.id.editTextLahir);
        bBuat = (Button) findViewById(R.id.buttonBuat);
        rpl = (RadioButton) findViewById(R.id.radioButtonRpl);
        tkj = (RadioButton) findViewById(R.id.radioButtonTkj);
        cb10 = (CheckBox) findViewById(R.id.checkBox10);
        cb11 = (CheckBox) findViewById(R.id.checkBox11);
        cb12 = (CheckBox) findViewById(R.id.checkBox12);
        angk = (Spinner) findViewById(R.id.spinnerAngk);
        Nama = (TextView) findViewById(R.id.textViewNama);
        Lahir = (TextView) findViewById(R.id.textViewLahir);
        Kelas = (TextView) findViewById(R.id.textViewKelas);
        Jurusan = (TextView) findViewById(R.id.textViewJurusan);
        Angkatan = (TextView) findViewById(R.id.textViewAngkatan);

        bBuat.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
                                         doProcess();
                                         doClick();
                                         doPush();
                                         dolast();
                                         String name = etNama.getText().toString();
                                         int lahir = Integer.parseInt(etLahir.getText().toString());
                                         int umur = 2016 - lahir;
                                         Nama.setText("Nama : " + name);
                                         Lahir.setText("Bersusia : " + lahir + " Tahun");

                                     }
                                 }


        );
    }

    private void dolast() {
        Angkatan.setText("Angkatan : " + angk.getSelectedItem().toString());
    }

    private void doPush() {
        String hasil = " Anda Sekarang berada di Kelas : \n";
        int starten = hasil.length();
        if (cb10.isChecked()) hasil += cb10.getText() + "\n";
        if (cb11.isChecked()) hasil += cb11.getText() + "\n";
        if (cb12.isChecked()) hasil += cb12.getText() + "\n";
    }

    private void doClick() {
        String jurus = null;
        if (rpl.isChecked()) {
            jurus = rpl.getText().toString();
        } else if (tkj.isChecked()) {
            jurus = tkj.getText().toString();
        }
        if (jurus == null) {
            Jurusan.setError("Apa Jurusan kamu?");
        } else {
            Jurusan.setText("Mengambil Jurusan : " + jurus);
        }
    }

    private void doProcess() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            int tahun = Integer.parseInt(etLahir.getText().toString());
            int usia = 2016 - tahun;
            Nama.setText("Nama : " + nama);
            Lahir.setText("Berusia " + usia + " tahun ");
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String asal = etLahir.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Siapa Nama Anda");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama Terlalu Pendek !!!");
            valid = false;
        } else {
            etNama.setError(null);
        }
        if (asal.isEmpty()) {
            Nama.setError("Kapan kamu lahir ?");
            valid = false;
        } else {
            Lahir.setError(null);
        }
        return valid;
    }



}

package com.monti.mascotas;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Contacto extends AppCompatActivity {
    private EditText nombre;
    private EditText mail;
    private EditText comentario;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacto);

        nombre = (EditText) findViewById(R.id.tvNombre);
        mail = (EditText) findViewById(R.id.tvEmail);
        comentario = (EditText) findViewById(R.id.tvComentario);


        toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle("Contacto");
        }


        Button enviar = (Button) findViewById(R.id.btnEnviar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Getting content for email


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {

                            String email = mail.getText().toString().trim();
                            String subject = nombre.getText().toString().trim();
                            String message = comentario.getText().toString().trim();

/* Forma 1 - Google bloquea este acceso por cuestiones de seguridad
                //Creating com.monti.mascotas.SendMail object
                SendMail sm = new SendMail(getBaseContext(), email, subject, message);

                //Executing sendmail to send email
                sm.execute();
*/


/* Forma 2 = Funciona Muy Bien  */
                            String recepientEmail = email;
                            Intent intentt = new Intent(Intent.ACTION_SENDTO);
                            intentt.setData(Uri.parse("mailto:" + recepientEmail));
                            intentt.putExtra(Intent.EXTRA_SUBJECT, subject);
                            intentt.putExtra(Intent.EXTRA_TEXT, message);
                            startActivity(intentt);


        /* Forma 3..... No quiere funcionar
*       http://es.stackoverflow.com/questions/21574/error-al-intentar-env%C3%ADar-un-email-android-os-networkonmainthreadexception/21581
                            Properties props = new Properties();

                            props.setProperty("mail.smtp.host", "smtp.gmail.com");
                            props.setProperty("mail.smtp.starttls.enable", "true");
                            props.put("mail.transport.protocol", "smtp");
                            props.put("mail.smtp.port", 25);
                            props.setProperty("mail.smtp.user", "susi.chaveez@gmail.com");
                            props.setProperty("mail.smtp.auth", "desamparados");

                            Session mailSession = Session.getInstance(props, null);

                            Message msg = new MimeMessage(mailSession);

                            //Establecemos el asunto, el remitente y el destinatario
                            try {
                                msg.setSubject(subject);
                                msg.setFrom(new InternetAddress(email, subject));
                                msg.addRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress("susana.chvz@gmail.com")});
                            } catch (javax.mail.MessagingException ex) {
                                ex.getMessage();
                            } catch (java.io.UnsupportedEncodingException e) {
                                e.getMessage();
                            }

                            //Mensaje que se quiere enviar (cuerpo del mensaje)
                            DataHandler dh = new DataHandler(message, "text/plain");
                            try {
                                msg.setDataHandler(dh);
                            } catch (MessagingException e) {
                                e.printStackTrace();
                            }
                            //Línea para envíar el mensaje
                            try {
                                javax.mail.Transport.send(msg);
                            } catch (MessagingException e) {
                                e.printStackTrace();
                            }
*/

                        } catch (Exception e) {
                            Log.e("Error", "Exception: " + e.getMessage());
                        }
                    }
                });
            }
        });
    }
}


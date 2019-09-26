package store.www.kinggames.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import store.www.kinggames.R

import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.content_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        window.setBackgroundDrawableResource( R.drawable.bg_activity )


        /*
    * Colocando configuração de validação de campo de email
    * para enquanto o usuário informa o conteúdo deste campo.
    * */
        et_email.addTextChangedListener( object: TextWatcher {
            override fun afterTextChanged( content: Editable) {

                val message = getString(R.string.invalid_email)

                et_email.error =
                    if( content.isNotEmpty()
                        && Patterns.EMAIL_ADDRESS.matcher(content).matches() )
                        null
                    else
                        message
            }

            override fun beforeTextChanged(
                content: CharSequence?,
                start: Int,
                count: Int,
                after: Int ) {}

            override fun onTextChanged(
                content: CharSequence?,
                start: Int,
                before: Int,
                count: Int) {}
        } )


        /*
    * Colocando configuração de validação de campo de senha
    * para enquanto o usuário informa o conteúdo deste campo.
    * */
        et_password.addTextChangedListener( object: TextWatcher{
            override fun afterTextChanged( content: Editable ) {

                val message = getString(R.string.invalid_password)

                et_password.error =
                    if( content.length > 5 )
                        null
                    else
                        message
            }

            override fun beforeTextChanged(
                content: CharSequence?,
                start: Int,
                count: Int,
                after: Int ) {}

            override fun onTextChanged(
                content: CharSequence?,
                start: Int,
                before: Int,
                count: Int) {}
        } )

      }


    }



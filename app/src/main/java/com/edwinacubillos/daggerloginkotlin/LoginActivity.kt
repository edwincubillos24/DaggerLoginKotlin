package com.edwinacubillos.daggerloginkotlin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.edwinacubillos.root.App
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity() , LoginActivityMVP.View {

    @Inject
    lateinit var presenter: LoginActivityMVP.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        (application as App).getComponent().inject(this)

        bt_login.setOnClickListener {
            presenter.loginButtonClicked()
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.setView(this)
        presenter.getCurrentUser()
    }

    override fun getFirstName(): String = et_first_name.text.toString()


    override fun getLastName(): String = et_last_name.text.toString()


    override fun showUserNotAvailable() {
        Toast.makeText(
            this,
            "Error, el usuario no esta disponible",
            Toast.LENGTH_SHORT).show()
    }


    override fun showInputError() {
        Toast.makeText(
            this,
            "Error, el nombre ni el apellido pueden estar vacios",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun showUserSaved() {
        Toast.makeText(this, "Usuario guardado correctamente", Toast.LENGTH_SHORT).show()
    }

    override fun setFirstName(firstName: String) {
        et_first_name.setText(firstName)
    }

    override fun setLastName(lastName: String) {
        et_last_name.setText(lastName)
    }
}

package com.edwinacubillos.daggerloginkotlin

import androidx.annotation.Nullable


class LoginActivityPresenter(var model: LoginActivityMVP.Model) : LoginActivityMVP.Presenter {

    @Nullable
    private lateinit  var view: LoginActivityMVP.View


    override fun setView(view: LoginActivityMVP.View) {
        this.view = view
    }

    override fun loginButtonClicked() {
        if (view.getFirstName().trim().equals("") || view.getLastName().trim().equals("")) {
            view.showInputError()
        } else {
            model.createUser(view.getFirstName().trim(), view.getLastName().trim())
            view.showUserSaved()
        }
    }

    override fun getCurrentUser() {
        val user = model.getUser()

        view.setFirstName(user.firstName)
        view.setLastName(user.lastName)
    }
}
package com.soft.instagram.ui.login

sealed class Event {
    object Signin : Event()
    object Signup : Event()
}

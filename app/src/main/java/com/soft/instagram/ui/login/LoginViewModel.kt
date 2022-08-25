package com.soft.instagram.ui.login

import androidx.lifecycle.viewModelScope
import com.soft.instagram.data.login.model.LoginRepository
import com.soft.instagram.ui.base.BaseViewModel
import com.soft.instagram.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: LoginRepository
) : BaseViewModel() {

    private val _eventFlow = MutableSharedFlow<Event>()
    val eventFlow = _eventFlow.asSharedFlow()

    private val _loginState = MutableStateFlow<UiState<Boolean>>(UiState.Empty)
    val loginState = _loginState.asStateFlow()

    /**
     * 유저 token 저장
     *
     * @param userToken
     */
    fun saveToken(userToken: Long) {
        repository.saveToken(userToken)
    }

    /**
     * 로그인 UI 이벤트
     */
    fun signin() {
        event(Event.Signin)
    }

    /**
     * 회원가입 UI 이벤트
     */
    fun singup() {
        event(Event.Signup)
    }

    /**
     * 서버에 login 시도 결과
     *
     * @param email Email
     * @param password password
     */
    fun login(email: String, password: String) = viewModelScope.launch {
        _loginState.emit(UiState.Loading)
        // TODO 서버 전송, 성공시 emit
    }

    private fun event(event: Event) {
        viewModelScope.launch {
            _eventFlow.emit(event)
        }
    }
}

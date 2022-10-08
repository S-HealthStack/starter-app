package com.samsung.healthstack.starter_app.registration

sealed class RegistrationState {
    object Init : RegistrationState()
    object Success : RegistrationState()
    object Failed : RegistrationState()
    object Loading : RegistrationState()
}

package com.samsung.healthstack.starter_app.registration

import com.samsung.healthcare.kit.model.Model
import com.samsung.healthcare.kit.model.question.QuestionModel

class RegistrationModel(
    title: String,
    val eligibilityQuestions: List<QuestionModel<Any>>
) : Model("", title, null)

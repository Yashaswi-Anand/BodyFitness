package com.yashanand.bodyfitness

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()

        login_btn.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
    }

    fun registrationBtn(view: View) {
        signUp()
    }

    private fun signUp() {
        if (editEmail.text.toString().isEmpty()) {
            editEmail.error = "Please Enter Email"
            editEmail.requestFocus()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(editEmail.text.toString()).matches()) {
            editEmail.error = "Please Enter valid Email"
            editEmail.requestFocus()
            return
        }
        if (editPassword.text.toString().isEmpty()) {
            editPassword.error = "Please Enter Email"
            editPassword.requestFocus()
            return
        }
        auth.createUserWithEmailAndPassword(editEmail.text.toString(), editPassword.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    user!!.sendEmailVerification()
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                // Sign in success, update UI with the signed-in user's information
                                //Log.d(, "createUserWithEmail:success")
                                startActivity(Intent(this, LoginActivity::class.java::class.java))
                            }
                        }
                } else {
                    // If sign in fails, display a message to the user.
                    // Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Authentication failed. Try again after some time...",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }

    }


}
package com.yashanand.bodyfitness

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.yashanand.bodyfitness.activities.DifferentLevels
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()


        register_btn.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
            overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left)
        }


    }
    //When initializing your Activity, check to see if the user is currently signed in:
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }
    private fun updateUI(currentUser : FirebaseUser?){
        if (currentUser != null){
            if (currentUser.isEmailVerified) {
                startActivity(Intent(this, DifferentLevels::class.java))
                //finish()
            }else{
                Toast.makeText(this, "Please verify email address.",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun loginBtn(view: View) {
        if (edit_email_login.text.toString().isEmpty()){
            edit_email_login.error="Please Enter Email"
            edit_email_login.requestFocus()
            return
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(edit_email_login.text.toString()).matches()){
            edit_email_login.error="Please Enter valid Email"
            edit_email_login.requestFocus()
            return
        }
        if (edit_Password_login.text.toString().isEmpty()){
            edit_Password_login.error="Please Enter Email"
            edit_Password_login.requestFocus()
            return
        }
        auth.signInWithEmailAndPassword(edit_email_login.text.toString(), edit_Password_login.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    updateUI(null)
                    // ...
                }

            }

    }
}
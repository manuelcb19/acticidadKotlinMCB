package fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.kotlinmcb.AuthActivity
import com.example.kotlinmcb.R
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment(), View.OnClickListener {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        emailEditText = view.findViewById(R.id.editTextEmail)
        passwordEditText = view.findViewById(R.id.editTextPassword)

        view.findViewById<Button>(R.id.btnLogin).setOnClickListener(this)
        view.findViewById<TextView>(R.id.tvSwitchRegistro).setOnClickListener {
            (activity as AuthActivity).switchToRegistroFragment()
        }

        return view
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnLogin -> {
                val email = emailEditText.text.toString().trim()
                val password = passwordEditText.text.toString().trim()

                FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            (activity as AuthActivity).onLoginSuccess()
                        } else {
                            Toast.makeText(context, "Error en el inicio de sesión", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
    }
}

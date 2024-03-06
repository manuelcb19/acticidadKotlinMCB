package fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.kotlinmcb.R
import com.google.firebase.auth.FirebaseAuth

class RegistroFragment : Fragment(), View.OnClickListener {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_registro, container, false)

        emailEditText = view.findViewById(R.id.editTextEmailRegistro)
        passwordEditText = view.findViewById(R.id.editTextPasswordRegistro)

        view.findViewById<Button>(R.id.btnRegistro).setOnClickListener(this)

        return view
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnRegistro -> {
                val email = emailEditText.text.toString().trim()
                val password = passwordEditText.text.toString().trim()
                if (email.isNotEmpty() && password.isNotEmpty()) {
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Toast.makeText(
                                    context,
                                    "Registro exitoso",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                Toast.makeText(
                                    context,
                                    "Error en el registro: ${task.exception?.message}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                } else {
                    Toast.makeText(
                        context,
                        "Por favor, ingrese el correo electrónico y la contraseña",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}
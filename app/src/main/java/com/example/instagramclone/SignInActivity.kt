package com.example.instagramclone

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.instagramclone.daos.UserDao
import com.example.instagramclone.databinding.ActivitySignInBinding
import com.example.instagramclone.utils.User
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class SignInActivity : AppCompatActivity() {


    companion object {
        const val RC_SIGN_IN = 120
        const val TAG = "GoogleSignIN"
    }

    private lateinit var auth: FirebaseAuth
    private lateinit var binding:ActivitySignInBinding
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // [START config_signin]
        // Configure Google Sign In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.Default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)
        // [START initialize_auth]
        // Initialize Firebase Auth
        auth = Firebase.auth
        // [END initialize_auth]

        binding.signInButton.setOnClickListener{
            signIn()
        }

    }

    //if the user is already loged in
    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            val exception = task.exception
            if (task.isSuccessful) {
                try {
                    // Google Sign In was successful, authenticate with Firebase
                    val account = task.getResult(ApiException::class.java)!!
                    Log.d(TAG, "firebaseAuthWithGoogle:" + account.id)
                    firebaseAuthWithGoogle(account.idToken!!)
                } catch (e: ApiException) {
                    // Google Sign In failed, update UI appropriately
                    Log.w(TAG, "Google sign in failed",e)
                }
            } else {
                Toast.makeText(this, exception.toString(), Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)

        binding.signInButton.visibility = View.GONE
        binding.emailText.visibility = View.GONE
        binding.passwordText.visibility = View.GONE
        binding.progressBar.visibility = View.VISIBLE

        //signing in user on the background thread user Coroutines
         GlobalScope.launch(Dispatchers.IO){
             val auth = auth.signInWithCredential(credential).await()
             val firebaseUser = auth.user
             //returning back to the UI thread
             withContext(Dispatchers.Main){
                 updateUI(firebaseUser)
             }
         }
    }

    private fun updateUI(firebaseUser: FirebaseUser?) {


        if(firebaseUser != null){

            //making the user
            val user = User(firebaseUser.uid,firebaseUser.displayName,firebaseUser.photoUrl.toString())
            val userDao = UserDao()
            userDao.addUser(user) //adding the user

            val mainActivity = Intent(this,MainActivity::class.java)
                   startActivity(mainActivity)
        }else{

            binding.signInButton.visibility = View.VISIBLE
            binding.emailText.visibility = View.VISIBLE
            binding.passwordText.visibility = View.VISIBLE
            binding.progressBar.visibility = View.GONE
        }
    }
}

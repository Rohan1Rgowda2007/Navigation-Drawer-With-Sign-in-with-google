package com.example.navigationdrawerfirebase

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.navigationdrawerfirebase.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth

class ProfileFragment : Fragment() {

    private lateinit var mAuth : FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val mBinding = FragmentProfileBinding.inflate(layoutInflater)

        mAuth = FirebaseAuth.getInstance()

        val currentUser = mAuth.currentUser

        mBinding.EmailAdress.text = currentUser?.email
        mBinding.userName.text = currentUser?.displayName

        val userImage = mBinding.userImage

        Glide
            .with(this)
            .load(currentUser!!.photoUrl)
            .into(userImage)


        mBinding.LogOutButton.setOnClickListener {
            mAuth.signOut()
            Toast.makeText(this.context, "you are sign out", Toast.LENGTH_SHORT).show()
            val intenting = Intent(this.context,SignInWIthGoogle::class.java)
            intenting.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intenting)
            activity?.finish()


        }

        return mBinding.root
    }
}
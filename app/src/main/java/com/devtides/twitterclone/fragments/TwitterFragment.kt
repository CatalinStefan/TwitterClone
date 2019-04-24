package com.devtides.twitterclone.fragments

import android.content.Context
import android.support.v4.app.Fragment
import com.devtides.twitterclone.adapters.TweetListAdapter
import com.devtides.twitterclone.listeners.HomeCallback
import com.devtides.twitterclone.listeners.TweetListener
import com.devtides.twitterclone.listeners.TwitterListenerImpl
import com.devtides.twitterclone.util.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.lang.RuntimeException

abstract class TwitterFragment : Fragment() {

    protected var tweetsAdapter: TweetListAdapter? = null
    protected var currentUser: User? = null
    protected val firebaseDB = FirebaseFirestore.getInstance()
    protected val userId = FirebaseAuth.getInstance().currentUser?.uid
    protected var listener: TwitterListenerImpl? = null
    protected var callback: HomeCallback? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is HomeCallback) {
            callback = context
        } else {
            throw RuntimeException(context.toString() + " must implement HomeCallback")
        }
    }

    fun setUser(user: User?) {
        this.currentUser = user
        listener?.user = user
    }

    abstract fun updateList()

    override fun onResume() {
        super.onResume()
        updateList()
    }
}
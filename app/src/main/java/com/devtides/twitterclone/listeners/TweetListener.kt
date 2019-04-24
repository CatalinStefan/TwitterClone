package com.devtides.twitterclone.listeners

import com.devtides.twitterclone.util.Tweet

interface TweetListener {
    fun onLayoutClick(tweet: Tweet?)
    fun onLike(tweet: Tweet?)
    fun onRetweet(tweet: Tweet?)
}
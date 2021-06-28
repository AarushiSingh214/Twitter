package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.jetbrains.annotations.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.ViewHolder>{

    Context context;
    List<Tweet> tweets;

    //Pass in the contect and list of tweets
    public TweetsAdapter(Context context, List<Tweet> tweets){
        this.context = context;
        this.tweets = tweets;
    }
    //For each row, inflate the layout
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tweet, parent, false);
        return new ViewHolder(view);
    }

    //Bind values based on the position of the element
    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        //Get the data at position
        Tweet tweet = tweets.get(position);
        // Bind the tweet with teh view holder
        holder.bind(tweet);
    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }
    //Pass in the contect and list of tweets


    //Bind values based on the position of the element

    //Define a viewholder
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivProfileImage;
        TextView tvBody;
        TextView tvScreenName;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            ivProfileImage = itemView.findViewById(R.id.imageView);
            tvBody = itemView.findViewById(R.id.tvBody);
            tvScreenName = itemView.findViewById(R.id.tvScreenName);
        }

        public void bind(Tweet tweet) {
            tvBody.setText(tweet.body);
            tvScreenName.setText((tweet.user.screenName));
            Glide.with(context).load(tweet.user.profileImageUrl).into(ivProfileImage);

        }

        //WHERE DO U PUT THISSSSSSSSSSS
//        // getRelativeTimeAgo("Mon Apr 01 21:16:23 +0000 2014");
//        public String getRelativeTimeAgo(String rawJsonDate) {
//            String twitterFormat = "EEE MMM dd HH:mm:ss ZZZZZ yyyy";
//            SimpleDateFormat sf = new SimpleDateFormat(twitterFormat, Locale.ENGLISH);
//            sf.setLenient(true);
//
//            String relativeDate = "";
//            try {
//                long dateMillis = sf.parse(rawJsonDate).getTime();
//                relativeDate = DateUtils.getRelativeTimeSpanString(dateMillis,
//                        System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS).toString();
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//
//            return relativeDate;
//        }
    }
}

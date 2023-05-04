package com.example.newtasknews;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class News implements Parcelable {

    private String title;
    private String description;
    private int image;

    public News(String title, String description, int image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }

    protected News(Parcel in) {
        title = in.readString();
        description = in.readString();
        image = in.readInt();
    }

    public static final Creator<News> CREATOR = new Creator<News>() {
        @Override
        public News createFromParcel(Parcel in) {
            return new News(in);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }

    public static List<News> getTopStories() {
        // TODO: Replace with actual data fetching and processing logic
        List<News> topStories = new ArrayList<>();

        // Add dummy data
        topStories.add(new News("Top Story 1", "Top story description 1jbbkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk", R.drawable.news));
        topStories.add(new News("Top Story 2", "Top story description 21jbbkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk", R.drawable.news));
        topStories.add(new News("Top Story 3", "Top story description 31jbbkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk", R.drawable.news));

        return topStories;
    }

    public static List<News> getNewsItems() {
        // TODO: Replace with actual data fetching and processing logic
        List<News> newsItems = new ArrayList<>();

        // Add dummy data
        newsItems.add(new News("News Item 1", "News item description 11jbbkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk", R.drawable.news));
        newsItems.add(new News("News Item 2", "News item description 2", R.drawable.news));
        newsItems.add(new News("News Item 3", "News item description 3", R.drawable.news));

        return newsItems;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeInt(image);
    }
}

package com.example.sit708_task_51c_newsapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/**
 * MainActivity sets up the horizontal and vertical RecyclerViews and initializes the data for the news items.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView HRecycler, VRecycler;
    RecyclerView.LayoutManager HlayoutManager, VlayoutManager;
    ArrayList<NewsModel> news;

    NewsAdaptor newsAdaptorHorizontal, newsAdaptorVertical;
    Boolean viewHorizontal = true;

    // Add your headlines and news content here
    private String[] headlines = {
            "Tornado Hits ",
            "Tech Company",
            "Nobel Prize",
            "Global Summit",
            "New Mars Rover",
            "Ancient City",
            "Breaking Hurricane",
            "Potential for Life",
            "Innovative Startup",
            "Rare Wildlife"
    };

    private String[] newsContent = {
            "A powerful tornado has swept through the Midwest, causing extensive damage to homes and infrastructure. Emergency services are working tirelessly to assist affected communities, and local authorities have declared a state of emergency.",
            "A major tech company has announced a groundbreaking development in quantum computing, promising to revolutionize the field of computing. The new technology is expected to have a significant impact on various industries, including healthcare, finance, and artificial intelligence.",
            "The Nobel Prize winners in the science categories have been announced, recognizing outstanding achievements in physics, chemistry, and medicine. The laureates' work has contributed to advancements in our understanding of the universe and human health.",
            "World leaders have gathered for a global summit to discuss urgent action on climate change. The summit aims to develop strategies for reducing greenhouse gas emissions, protecting ecosystems, and building resilience against the impacts of climate change.",
            "The latest Mars rover mission has discovered evidence of ancient water on the Red Planet. The findings suggest that Mars may have once harbored conditions suitable for life, raising questions about the planet's history and potential for future exploration.",
            "Archaeologists have uncovered the remains of an ancient city in the Middle East, offering new insights into the region's history. The well-preserved ruins contain artifacts and structures that date back thousands of years, shedding light on the lives of the city's inhabitants.",
            "The current hurricane season has broken records, raising concerns for the safety of coastal cities. The frequency and intensity of hurricanes have increased due to climate change, prompting calls for more effective disaster preparedness and mitigation measures.",
            "Astronomers have discovered a new exoplanet with conditions that may be suitable for life. The planet, located in the habitable zone of its star, has a climate and atmosphere that could potentially support the existence of liquid water and life.",
            "An innovative startup has developed a groundbreaking solar energy technology, promising to transform the renewable energy industry. The company's new solar panels are significantly more efficient and cost-effective than existing solutions, making clean energy more accessible to consumers.",
            "A rare wildlife species, long thought to be extinct, has been rediscovered in a remote region. The discovery has sparked hope for the conservation of the species and highlights the importance of protecting biodiversity and natural habitats."
    };

    // Add your image resource IDs here
    private int[] newsImages = {
            R.drawable.news,
            R.drawable.news1,
            R.drawable.news2,
            R.drawable.news3,
            R.drawable.news,
            R.drawable.news1,
            R.drawable.news2,
            R.drawable.news3,
            R.drawable.news,
            R.drawable.news3
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HRecycler = findViewById(R.id.recyclerView);
        VRecycler = findViewById(R.id.recyclerViewVertical);

        HlayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        VlayoutManager = new LinearLayoutManager(this);
        news = new ArrayList<>();

        for (int i = 0; i < headlines.length; i++) {
            populateNews(i);
        }
        newsAdaptorHorizontal = new NewsAdaptor(this, news, viewHorizontal);
        newsAdaptorVertical = new NewsAdaptor(this, news, false);
        HRecycler.setAdapter(newsAdaptorHorizontal);
        VRecycler.setAdapter(newsAdaptorVertical);
        HRecycler.setLayoutManager(HlayoutManager);
        VRecycler.setLayoutManager(VlayoutManager);
    }


    /**
     * Populates the news ArrayList with the given index's news information.
     *
     * @param num The index of the news item to add.
     */
    public void populateNews(int num) {
        news.add(new NewsModel(headlines[num], newsContent[num], newsImages[num], true));
    }

    @Override
    public void onClick(View view) {

    }
}

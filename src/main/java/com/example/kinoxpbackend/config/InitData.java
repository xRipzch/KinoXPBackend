package com.example.kinoxpbackend.config;
import com.example.kinoxpbackend.models.*;
import com.example.kinoxpbackend.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class InitData implements CommandLineRunner {



    @Autowired
    MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
        Movie movie1 = new Movie();
        movie1.setTitle("Saw CCCCCCCC ASD ASD");
        movie1.setDescription("Lots of gore Lots of goSAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAE AWEAWE AWE AWE AWE AWE AWE AWE AWE AWE AWE AWE AWE AWE ADSD AWEAreLots of goreLots of goreLots of goreLots of goreLots of goreLots of goreLots of goreLots of goreLots of goreLots of goreLots of goreLots of goreLots of goreLots of goreLots of goreLots of goreLots of goreLots of goreLots of goreLots of goreLots of gore");
        movie1.setDurationInMinutes(1181);
        movie1.setReleaseDate(LocalDate.of(2025, 7, 7));
        movie1.setImageUrl("https://i0.wp.com/bloody-disgusting.com/wp-content/uploads/2023/07/saw-x-poster.jpg?resize=740%2C925&ssl=1");
        movieRepository.save(movie1);

        // Movie 2
        Movie movie2 = new Movie();
        movie2.setTitle("Avatar: The Way of Water");
        movie2.setDescription("Avatar: The Way of Water is a 2022 epic science fiction film co-produced, co-edited, and directed by James Cameron, who co-wrote the screenplay with Rick Jaffa and Amanda Silver from a story the trio wrote with Josh Friedman and Shane Salerno. Distributed by 20th Century Studios, it is the sequel to Avatar (2009) and the second installment in the Avatar film series. It features Sam Worthington, Zoe Saldaña, Stephen Lang, Joel David Moore, CCH Pounder, Giovanni Ribisi, Dileep Rao and Matt Gerald reprising their roles from the first film, with Sigourney Weaver returning in an additional role[6] and Kate Winslet joining the cast. It follows a blue-skinned humanoid Na'vi named Jake Sully (Worthington) as he and his family, under renewed human threat, seek refuge with the aquatic Metkayina clan of Pandora, a habitable exomoon on which they live.");
        movie2.setDurationInMinutes(152);
        movie2.setReleaseDate(LocalDate.of(2022, 7, 18));
        movie2.setIs3d(true);
        movie2.setImageUrl("https://m.media-amazon.com/images/I/61Ka+BIOnVL._AC_SL1280_.jpg");
        movieRepository.save(movie2);

        // Movie 3
        Movie movie3 = new Movie();
        movie3.setTitle("Joker 2: Funny Movie");
        movie3.setDescription("Joker: Folie à Deux[a] is a 2024 American jukebox musical[8] psychological thriller film directed by Todd Phillips from a screenplay he co-wrote with Scott Silver. Loosely based on DC Comics characters, it is the sequel to Joker (2019). The film stars Joaquin Phoenix reprising the title role as Arthur Fleck, with Lady Gaga joining as his love interest Lee Quinzel. Zazie Beetz also reprises her role from the previous film, while Brendan Gleeson and Catherine Keener join the cast. It is produced by Warner Bros. Pictures in association with Joint Effort and was distributed by Warner Bros. Pictures.");
        movie3.setDurationInMinutes(148);
        movie3.setReleaseDate(LocalDate.of(2024, 7, 16));
        movie3.setImageUrl("https://sportshub.cbsistatic.com/i/2024/08/19/9a15da04-fb52-4f9c-9980-63f1f51cdfdf/joker-folie-a-deux-movie-poster.jpg?");
        movieRepository.save(movie3);

        // Movie 4
        Movie movie4 = new Movie();
        movie4.setTitle("Interstellar");
        movie4.setDescription("A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.");
        movie4.setDurationInMinutes(169);
        movie4.setReleaseDate(LocalDate.of(2014, 11, 7));
        movie4.setImageUrl("https://i.ebayimg.com/images/g/zu4AAOSw2spbJQ0J/s-l1600.jpg");
        movieRepository.save(movie4);
    }
}

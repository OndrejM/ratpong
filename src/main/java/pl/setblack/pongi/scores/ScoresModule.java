package pl.setblack.pongi.scores;

import pl.setblack.pongi.scores.repo.ScoreRepositoryES;
import pl.setblack.pongi.scores.repo.ScoresRepository;
import pl.setblack.pongi.scores.repo.ScoresRepositoryNonBlocking;

/**
 * Created by jarek on 2/13/17.
 */
public class ScoresModule {

    private final ScoresRepository scoresRepository;

    public ScoresModule(ScoresRepository scoresRepository) {
        this.scoresRepository = scoresRepository;
    }

    public ScoresModule() {
        this ( new ScoreRepositoryES());
    }

    public ScoresService createService() {
        return new ScoresService(new ScoresRepositoryNonBlocking(scoresRepository));
    }
}

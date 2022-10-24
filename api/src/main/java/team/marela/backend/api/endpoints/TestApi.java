package team.marela.backend.api.endpoints;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import team.marela.backend.api.interfaces.TestApiInterface;
import team.marela.backend.database.entities.test.TestEntity;
import team.marela.backend.database.repositories.test.TestRepository;

@RestController
@RequiredArgsConstructor
public class TestApi implements TestApiInterface {

    private final TestRepository testRepository;

    @GetMapping
    public TestEntity test() {
        var uuid = testRepository.save(
                TestEntity.builder().name("test 1").build()
        ).getId();

        return testRepository.findById(uuid).get();
    }
}

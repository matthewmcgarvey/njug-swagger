package io.swagger;

import io.swagger.model.BigIdea;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Component
public class Database {
    private final Map<Integer, BigIdea> internal = new HashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);
    private final HashSet<String> nameList = new HashSet<>();

    public Optional<BigIdea> save(BigIdea bigIdea) {
        if (nameList.contains(bigIdea.getName())) {
            return Optional.empty();
        }
        nameList.add(bigIdea.getName());
        int id = idCounter.getAndIncrement();
        bigIdea.setId(id);
        internal.put(id, bigIdea);
        return Optional.of(bigIdea);
    }

    public Optional<BigIdea> get(int id) {
        return Optional.ofNullable(internal.get(id));
    }

    public List<BigIdea> getAll() {
        return new ArrayList<>(internal.values());
    }

    public List<BigIdea> getAll(int limit) {
        return internal.values()
                .stream()
                .limit(limit)
                .collect(Collectors.toList());
    }

    public Optional<BigIdea> update(int id, BigIdea bigIdea) {
        BigIdea toUpdate = internal.get(id);
        if (toUpdate == null) {
            return Optional.empty();
        }
        toUpdate.setRating(bigIdea.getRating());
        return Optional.of(bigIdea);
    }

    public Optional<BigIdea> delete(int id) {
        Optional<BigIdea> remove = Optional.ofNullable(internal.remove(id));
        remove.ifPresent(bi -> nameList.remove(bi.getName()));
        return remove;
    }
}
